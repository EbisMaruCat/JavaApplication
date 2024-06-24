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

        testTri.draw();
        System.out.println(testTri.getArea());
    }
}
