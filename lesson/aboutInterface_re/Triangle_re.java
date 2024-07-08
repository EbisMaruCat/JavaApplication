package lesson.aboutInterface_re;

import java.awt.*;

class Triangle_re
        extends Shape_re implements Drawable_re, Measurable_re, Movable_re {

    Point p1;
    Point p2;
    Point p3;

    Triangle_re(Point p1,Point p2,Point p3){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
    }


    // implements Drawable----------
    @Override
    public void draw(Graphics g) {

        // ---class Shape_re extends JPanelの時:---
        // super.paintComponent(g);

        int[] xPoints = {p1.x,p2.x,p3.x};
        int[] yPoints = {p1.y,p2.y,p3.y};
        // 線の色
        g.setColor(Color.LIGHT_GRAY);
        // 描写
        g.drawPolygon(xPoints, yPoints,3);
        // 塗りつぶし
        g.fillPolygon(xPoints, yPoints, 3);
    }

    // implements Measurable 01----------
    @Override
    public int getArea() {
        double s = getPerimeter()*0.5;

        double aP = Point.distance(p1.x,p1.y,p2.x,p2.y);
        double bP = Point.distance(p2.x,p2.y,p3.x,p3.y);
        double cP = Point.distance(p1.x,p1.y,p3.x,p3.y);

        double sBig = Math.sqrt( s*(s-aP)*(s-bP)*(s-cP) );
        return (int) sBig;
    }

    // implements Measurable 02----------
    @Override
    public int getPerimeter() {
        double a = Point.distance(this.p1.x,this.p1.y,this.p2.x,this.p2.y);
        double b = Point.distance(this.p2.x,this.p2.y,this.p3.x,this.p3.y);
        double c = Point.distance(this.p1.x,this.p1.y,this.p3.x,this.p3.y);

        return (int)(a+b+c);
    }

    // implements ParallelMovable_re----------
    @Override
    public void rotate() {
        int ampX = 5,ampY = 5;
        Triangle_re moveTri = new Triangle_re(
                new Point(this.p1.x + ampX,this.p1.y + ampY),
                new Point(this.p2.x + ampX,this.p2.y + ampY),
                new Point(this.p3.x + ampX,this.p3.y + ampY)
        );

        System.out.println("平行移動しました。");
    }

    // interface Movable_re extends ParallelMovable_re--------
    @Override
    public void parallelMove() {
        System.out.println("回転しました。");
    }
}


