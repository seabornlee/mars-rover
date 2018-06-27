package com.flyingwillow.mars;

/**
 * 小车的位置：坐标及朝向
 * */
public class Position {

    private Point point;
    private Face face;
    private Plateau plateau;

    public Position(Point point, Face face, Plateau plateau) {
        this.point = point;
        this.face = face;
        this.plateau = plateau;
    }

    public void move(){

        this.point.add(step());// 前进一步

        // 检查坐标合法性 避免越界
        if(this.point.getX()< plateau.getLeftBottom().getX()){
            this.point.setX(plateau.getLeftBottom().getX());
        }
        if(this.point.getY()<plateau.getLeftBottom().getY()){
            this.point.setY(plateau.getLeftBottom().getY());
        }
        if(this.point.getX()> plateau.getRightTop().getX()){
            this.point.setX(plateau.getRightTop().getX());
        }
        if(this.point.getY()>plateau.getRightTop().getY()){
            this.point.setY(plateau.getRightTop().getY());
        }
    }

    /**
     * 左转  相当于  N W S E  逆时针
     * */
    public void left(){
        this.face = face.anticlockwise();
    }

    /**
     *  右转 相当于  N W S E  顺时针
     * */
    public void right(){
        this.face = face.clockwise();
    }

    @Override
    public String toString() {
        return String.format("%d %d %s", point.getX(), point.getY(), face);
    }

    private Point step(){
        switch (face){
            case E: return new Point(1,0);
            case N: return new Point(0,1);
            case W: return new Point(-1,0);
            case S: return new Point(0,-1);
            default:
                return new Point(0,0);
        }
    }
}
