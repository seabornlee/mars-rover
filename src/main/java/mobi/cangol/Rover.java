package mobi.cangol;

import java.util.regex.Pattern;

public class Rover {
    private static final String COMMAND_ERROR = "error command!";
    private static final char COMMAND_L = 'L';
    private static final char COMMAND_R = 'R';
    private static final char COMMAND_M = 'M';
    private int x;
    private int y;
    private Direction direction;

    private Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public String getStatusString() {
        return String.format("%s %s %s", x, y, direction);
    }

    private int[] preMove() {
        int preX = this.x;
        int preY = this.y;
        switch (direction) {
            case N:
                preY = preY + 1;
                break;
            case S:
                preY = preY - 1;
                break;
            case E:
                preX = preX + 1;
                break;
            case W:
                preX = preX - 1;
                break;
            default:
                break;
        }
        return new int[]{preX, preY};
    }

    private void move(int[] position) {
        this.x = position[0];
        this.y = position[1];
    }

    private void turnLeft() {
        this.direction = Direction.rotate90Angle(this.direction, true);

    }

    private void turnRight() {
        this.direction = Direction.rotate90Angle(this.direction, false);
    }


    public static Rover land(String command) {
        if (null == command || "".equals(command) || command.isEmpty()) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
        String[] array = command.split(" ");
        if (array.length != 3) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        } else {
            int x;
            int y;
            Direction direction;
            Rover rover;
            try {
                x = Integer.valueOf(array[0]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("error command! x=" + array[0] + " is Invalid");
            }
            try {
                y = Integer.valueOf(array[1]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("error command! y=" + array[1] + " is Invalid");
            }
            try {
                direction = Direction.valueOf(array[2]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("error command! Direction=" + array[2] + "is Invalid");
            }

            rover = new Rover(x, y, direction);
            return rover;
        }
    }

    public void explore(Plateau plateau, String command) {
        if (null == command || "".equals(command) || command.isEmpty()) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
        if (!Pattern.compile("[L|R|M]+?").matcher(command).matches()) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case COMMAND_L:
                    this.turnLeft();
                    break;
                case COMMAND_R:
                    this.turnRight();
                    break;
                case COMMAND_M:
                    int[] pre = this.preMove();
                    if (plateau.isReachable(pre)) {
                        plateau.setReachable(this.getPosition(), true);
                        this.move(pre);
                        plateau.setReachable(this.getPosition(), false);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
