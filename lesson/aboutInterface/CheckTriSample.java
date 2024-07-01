package lesson.aboutInterface;

import java.awt.*;

class CheckTriSample {
    public static void main(String[] args){
        Point gotP = new Point(0,2);
        Point gotQ = new Point(0,6);

        /*
        ある点 A(x1,y1) B(x2,y2)で
            public static double distance(double x1, double y1,
                                          double x2, double y2)
        指定された 2つの座標セット(AとB) の間の距離を 算出してくれるメソッド。
         */
        double ansDis1 = Point.distance(gotP.x,gotP.y,gotQ.x,gotQ.y);

        System.out.println(ansDis1);  // 結果 : 3.0と出る


        Point gotR = new Point(3,2);

        double ansDis2 = Point.distance(gotR.x,gotR.y,gotQ.x,gotQ.y);
        System.out.println(ansDis2);

        double ansDis3 = Point.distance(gotR.x,gotR.y,gotP.x,gotP.y);
        System.out.println(ansDis3);
    }

}

class testTri extends Shape implements Drawable,Measurable,Movable{

    Point testP1;

    testTri(Point testP1){
        this.testP1=testP1;
    }

    // Drawable
    public void draw(){

    }

    //Measurable
    public int getArea(){
        return 0;
    }
    public int getPerimeter(){
        return 0;
    }

    //Movable
    public void parallelMove(){

    }
    public void rotate(){

    }

}