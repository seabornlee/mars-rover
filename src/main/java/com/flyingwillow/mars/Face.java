package com.flyingwillow.mars;

public enum Face {
    N(0),//北
    W(1),//西
    S(2),//南
    E(3);//东

    private int index;

    Face(int index) {
        this.index = index;
    }

    public Face clockwise(){
        int l = values().length;
        return values()[(this.index+1)%l];
    }

    public Face anticlockwise(){
        int l = values().length;
        return values()[(this.index-1+l)%l];
    }
}
