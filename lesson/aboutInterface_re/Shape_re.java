package lesson.aboutInterface_re;

import javax.swing.*;
import java.awt.*;


class Shape_re /*extends JPanel*/ {
    // int size;  使ってる場面がない

    //public void paintComponent(Graphics g){
    // ここは無くても問題ないかもしれませんが一応書いておいてください。
         //super.paintComponent(g);
    //}
}

interface Drawable_re{
    void draw(Graphics g);
}

interface Measurable_re{
    int getArea();
    int getPerimeter();
}

interface ParallelMovable_re{
    void parallelMove();
}

interface Movable_re extends ParallelMovable_re {
    void rotate();
}
