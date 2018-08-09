package mobi.cangol;

public enum Direction {

    E,
    N,
    W,
    S;

    public static Direction rotate90Angle(Direction direction, boolean left) {
        switch (direction) {
            case N:
                return left ? W : E;
            case S:
                return left ? E : W;
            case E:
                return left ? N : S;
            case W:
                return left ? S : N;
            default:
                return direction;
        }
    }
}
