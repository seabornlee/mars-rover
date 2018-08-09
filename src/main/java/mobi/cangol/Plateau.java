package mobi.cangol;

public class Plateau {
    private boolean[][] points;

    private Plateau(int maxX, int maxY) {
        points = new boolean[maxX + 1][maxY + 1];
        for (int i = 0; i < maxX + 1; i++) {
            for (int j = 0; j < maxY + 1; j++) {
                points[i][j] = true;
            }
        }
    }

    public static Plateau initInstance(String command) {
        if (null == command || "".equals(command) || command.isEmpty()) {
            throw new IllegalArgumentException("error command!");
        }
        String[] array = command.split(" ");
        if (array.length != 2) {
            throw new IllegalArgumentException("error command!");
        } else {
            int x;
            try {
                x = Integer.valueOf(array[0]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("error command! x{" + array[0] + "} is Invalid");
            }
            int y;
            try {
                y = Integer.valueOf(array[1]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("error command! y{" + array[1] + "} is Invalid");
            }
            return new Plateau(x, y);
        }
    }

    public boolean isReachable(int[] xy) {
        try {
            return points[xy[0]][xy[1]];
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setReachable(int[] xy, boolean reachable) {
        try {
            points[xy[0]][xy[1]] = reachable;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
