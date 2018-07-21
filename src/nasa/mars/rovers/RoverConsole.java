package nasa.mars.rovers;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 对漫游者探测器输入操作指令的控制台
 * Created by lin on 2018/7/21.
 */
public class RoverConsole {

    public static void main(String[] args) {

        scan = new Scanner(System.in); // 获取控制台输入
        RoverConsole console = new RoverConsole();

        // 初始化探索的目的地
        Plateau plateau = new Plateau();
        console.initializePlateau(plateau);

        // 漫游者一号执行任务
        Rover rover1 = new Rover(plateau);
        console.initializeRover(rover1);
        console.command(rover1);

        // 漫游者二号执行任务
        Rover rover2 = new Rover(plateau);
        console.initializeRover(rover2);
        console.command(rover2);

        scan.close();

        System.out.println("---------------output-------------------");
        System.out.println(rover1);
        System.out.println(rover2);
    }

    /**
     * 初始化火星探测区域的数据
     * @param plateau
     */
    private void initializePlateau(Plateau plateau) {
        System.out.println("please input the upper-right coordinates of the plateau:");
        while (true) {
            /*
             * 校验输入的右上角坐标是否合法
             */
            String coordinates = scan.nextLine();
            if (null == coordinates || !Pattern.matches("^\\d+\\s\\d+$", coordinates)) {
                System.err.println("invalid parameters, plase retry again:");
                continue;
            }
            /*
             * 保存输入的坐标
             */
            String[] coordinatesArray = coordinates.split(" ");
            plateau.setLength(Integer.valueOf(coordinatesArray[0]));
            plateau.setWidth(Integer.valueOf(coordinatesArray[1]));
            break;
        }
    }

    /**
     * 初始化火星探测机器人的初始位置
     * @param rover
     */
    private void initializeRover(Rover rover) {
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
            rover.setX(Integer.valueOf(coordinatesArray[0]));
            rover.setY(Integer.valueOf(coordinatesArray[1]));
            rover.setOrientation(Rover.Orientation.getOrientation(coordinatesArray[2]));
            break;
        }
    }

    /**
     * 给机器人下达一系列的操作指令
     */
    public void command(Rover rover) {
        System.out.println("please input the instructions for this rover:");
        String instructions = scan.nextLine();
        String pattern = "(L|R|M)+";
        // 输入的指令格式校验
        if (null == instructions || !Pattern.matches(pattern, instructions)) {
            System.err.println("invalid instructions, please retry");
        }
        rover.execute(instructions);
    }

    static Scanner scan;

}
