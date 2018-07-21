package nasa.mars.rovers;

import java.util.Scanner;
import java.util.regex.Pattern;

import static nasa.mars.rovers.Rover.Orientation.*;
import static nasa.mars.rovers.RoverConsole.scan;

/**
 * 漫游者机器人
 * Created by lin on 2018/7/21.
 */
public class Rover {

    // 机器人的探索目标
    private Plateau plateau;

    /**
     * 机器人的位置和朝向
     */
    private Integer x;
    private Integer y;
    private Orientation orientation;

    /**
     * 机器人收到NASA的控制指令
     */
    private String instructions;

    /**
     * 按当前方向移动一格位置
     */
    public void move() throws RuntimeException {
        boolean outOfRange = false; // 是否超出探索范围的边界
        switch (this.orientation) {
            case RIGHT:
                if (x == plateau.getLength()) {
                    outOfRange = true;
                    break;
                } else {
                    x ++;
                }
                break;
            case DOWN:
                if (y == 0) {
                    outOfRange = true;
                    break;
                } else {
                    y --;
                }
                break;
            case LEFT:
                if (x == 0) {
                    outOfRange = true;
                    break;
                } else {
                    x --;
                }
                break;
            case UP:
                if (y == plateau.getWidth()) {
                    outOfRange = true;
                    break;
                } else {
                    y ++;
                }
                break;
        }
        if (outOfRange) {
            throw new RuntimeException("rover has arrived the boarder of the plateau, mission abort");
        }
    }

    /**
     * 执行一系列的操作指令
     */
    public void execute() {
        System.out.println("please input the instructions for this rover:");
        String instructions = scan.nextLine();
        String pattern = "(L|R|M)+";
        // 输入的指令格式校验
        if (null == instructions || !Pattern.matches(pattern, instructions)) {
            System.err.println("invalid instructions, please retry");
        }
        for (int i=0; i<instructions.length(); i++) {
            char c = instructions.charAt(i);
            /*
             * 根据输入的指令，解析每一个命令，执行
             */
            switch (c) {
                case 'L':
                    setDegree(((getDegree() + 360) - 90) % 360);
                    break;
                case 'R':
                    setDegree(((getDegree() + 360) + 90) % 360);
                    break;
                case 'M':
                    try {
                        move();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        return;
                    }
                    break;
                default:
                    // never come here
                    return;
            }
        }

    }

    /**
     * 机器人当前面向的方向
     */
    enum Orientation {
        UP("N"), DOWN("S"), LEFT("W"), RIGHT("E");

        private String compass; // four cardinal compass points
        Orientation(String compass) {
            this.compass = compass;
        }

        public String getCompass() {
            return this.compass;
        }

        static Orientation getOrientation(String compass) {
            switch (compass) {
                case "N":
                    return UP;
                case "E":
                    return RIGHT;
                case "S":
                    return DOWN;
                case "W":
                    return LEFT;
                default:
                    return null; // never happens
            }
        }
    }

    public Rover(Plateau plateau, Integer x, Integer y, Orientation orientation) {
        this.plateau = plateau;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Rover(Plateau plateau) {
        this.plateau = plateau;
        System.out.println("please input the initial position of the rover:");
        while (true) {
            /*
             * 校验输入的机器人坐标是否合法
             */
            String position = scan.nextLine();
            if (null == position || !Pattern.matches("^\\d+\\s\\d+\\s(N|E|S|W)$", position)) {
                System.err.println("invalid position, plase retry again:");
                continue;
            }
            /*
             * 保存输入的坐标
             */
            String[] coordinatesArray = position.split(" ");
            this.x = Integer.valueOf(coordinatesArray[0]);
            this.y = Integer.valueOf(coordinatesArray[1]);
            this.orientation = Orientation.getOrientation(coordinatesArray[2]);
            break;
        }
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * 机器人的方向换算为角度，设定右为0度，顺时针增加
     * @return
     */
    public int getDegree() {
        switch (this.orientation) {
            case RIGHT:
                return 0;
            case DOWN:
                return 90;
            case LEFT:
                return 180;
            case UP:
                return 270;
            default:
                return 0;
        }
    }

    // 把角度转换为方向
    public void setDegree(int degree) {
        switch (degree) {
            case 0:
                this.orientation = RIGHT;
                break;
            case 90:
                this.orientation = DOWN;
                break;
            case 180:
                this.orientation = LEFT;
                break;
            case 270:
                this.orientation = UP;
                break;
        }
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y + " " + this.orientation.getCompass();
    }
}
