package lesson.aboutInterface;

import java.awt.*;

public class testImplements {
    public static void main(String[] args){

        Drawable h = new Hero();
        h.draw();

        Triangle testTri = new Triangle(
                new Point(3,2),
                new Point(1,3),
                new Point(1,1)
        );

        t1.draw();
        System.out.println(t1.getArea());  // 面積:1 ??? 答えが2になっとらん

        Triangle tOwn = new Triangle(
                new Point(0,2),
                new Point(0,6),
                new Point(3,2)
                // これで3辺の長さが 4,3,5
        );
        System.out.println(tOwn.getArea());  // 面積:6
    }
}
