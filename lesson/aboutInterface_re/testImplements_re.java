
package lesson.aboutInterface_re;

/*
    2024/07/03
 */

import javax.swing.*;
import java.awt.*;


public class testImplements_re {

    // paintComponent 利用可能にするため。やっと voidの非static関係 解消... なんで？？？
    public static Triangle_re triangleRe;

    public static void main(String[] args){

        testImplements_re.triangleRe = new Triangle_re(
                // 一桁を三桁に変更...?
                new Point(300,200),
                new Point(100,300),
                new Point(100,100)
        );

        // MakeFrame frame = new MakeFrame("課題 --三角形-- __re__");

        JFrame jframe = new JFrame();
        jframe.setTitle("課題 --三角形-- __re__");
        jframe.setSize(400,600);

        // ここいらは setVisible()の後でつけても 通じる... 解せん。
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);

        // ボタン表示したいなら、ここに置いたらあかん！ってのがわかった。
        // jframe.setVisible(true);

        //JPanel panel = new JPanel();

        //jframe.add(panel);

        JButton button1 = new JButton("三角形を移動");
        // panel.add(button1);

        // 今度は、JPanelじゃなくて externしたCanvasTriで
        CanvasTri canvasTri = new CanvasTri();

        jframe.add(canvasTri);

        canvasTri.add(button1);

        jframe.setVisible(true);


        System.out.println(testImplements_re.triangleRe.getArea());

    }


}

/* 関数名と処理名を同一(一緒)にする
class MakeFrame extends JFrame{
    public MakeFrame(String title){
        JFrame jframe = new JFrame();
        jframe.setTitle(title);
        jframe.setSize(400,600);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }
}
*/


class CanvasTri extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        testImplements_re.triangleRe.draw(g);
    }
}


/*  これでは まｔｔったく使えないみたい。
 JFrame構築は 単独クラスでは 作れないのかもしれない...?
 だから その時は  "class ABC extends JFrame"のように 継承して使う？？？
------error?-----
public class JFrame_settings{
    JFrame frame = new JFrame();
    frame.setTitle("課題 --三角形--__re__ ");
    frame.setSize(400,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
-----------------
 */

