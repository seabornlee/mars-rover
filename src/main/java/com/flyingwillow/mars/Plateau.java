package com.flyingwillow.mars;

/**
 * plateau 的边界点
 * */
public class Plateau {
    private Point leftBottom;
    private Point rightTop;

    public Plateau(Point leftBottom, Point rightTop) {
        this.leftBottom = leftBottom;
        this.rightTop = rightTop;
    }

    public Plateau(Point rightTop) {
        this(new Point(0,0), rightTop);
    }

    public Point getLeftBottom() {
        return leftBottom;
    }

    public Plateau setLeftBottom(Point leftBottom) {
        this.leftBottom = leftBottom;
        return this;
    }

    public Point getRightTop() {
        return rightTop;
    }

    public Plateau setRightTop(Point rightTop) {
        this.rightTop = rightTop;
        return this;
    }
}
