package lesson.aboutInterface;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class testImpl_aboutJframe {

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setSize(400,600);


        JPanel p = new JPanel();

        frame.add(p);

        //JButton button = new JButton("三角形を移動");
        //p.add(button);

        JButton button2 = new JButton("保存");
        p.add(button2);

        // なぁるほど、クラスにされたら 表示できなんだ...?
        // いまんところ、overrideはできなさそう...わからん！
        JButt button3 = new JButt("押す");
        p.add(button3);    // 表示に失敗しておる

        frame.setVisible(true);

        frame.setTitle("課題");    // ウィンドウ 題名
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);  // 閉じるを押したら プログラム終了 する 設定

    }
}

class JButt extends JButton{
    public JButt(String text){
        JButton jButton = new JButton(text);
    }
}