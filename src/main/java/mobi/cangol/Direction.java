package mobi.cangol;

public enum Direction {
    N("N"),
    S("S"),
    W("W"),
    E("E");
    private String name;

    private Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
