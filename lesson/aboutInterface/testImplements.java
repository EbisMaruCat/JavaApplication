
package lesson.aboutInterface;

/*
    2024/06/26
 */

// JFrameや JPanelのライブラリのこと。
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JButton;

// Pointのライブラリ
import java.awt.*;

// 07/01 追加
//import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class testImplements {
    public static void main(String[] args){

        /*  2024/07/01 Triangleの　implements Drawableの drawに移動してみる
         2024/06/26  追加: 表示画面を設計 ------------
        // ウィンドウを作成するためのクラスJFrame
        JFrame frame = new JFrame();
        // 画面の大きさ 設定(幅400 高さ600 pxかね?)
        frame.setSize(400,600);
        // ?
        JPanel p = new JPanel();

        // JFrames に 作りたいもの(JPanelの生成物 ?)を追加
        //     == frame.add() メソッドを使って JFrames に追加 ??
        frame.add(p);

        // ボタン「三角形を移動」ヲ作る
        JButton button = new JButton("三角形を移動");
        // JPanelに追加 (これがそのあと frameに追加されていく？)
        p.add(button);

        // ボタン「保存」を作る
        JButton button2 = new JButton("保存");
        p.add(button2);

        frame.setVisible(true);
        // --------------------------


        // --------------- 2024/07/01 追加
        frame.setTitle("課題");    // ウィンドウ 題名

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);  // 閉じるを押したら プログラム終了 する 設定
        // ----------------------------------
         */


        Drawable h = new Hero();
        h.draw();

        Triangle t1 = new Triangle(
                new Point(3,2),
                new Point(1,3),
                new Point(1,1)
        );

        t1.draw();
        System.out.println(t1.getArea());  // 面積:1??? 答えが2になっとらん

        Triangle tOwn = new Triangle(
                new Point(0,2),
                new Point(0,6),
                new Point(3,2)
                // 3辺の長さが 4,3,5
        );
        System.out.println(tOwn.getArea()); // 面積:6


    }
}

// コードの不吉な臭い
// https://qiita.com/NagaokaKenichi/items/22972e6ba698c7f2978a
/*

2024/06/26
copyPaste
GUIやっている人向け

2024/06/26  追加: 表示画面を設計 ------------

        // ウィンドウを作成するためのクラスJFrame
        JFrame frame = new JFrame();
        // 画面の大きさ 設定(幅400 高さ600 pxかね?)
        frame.setSize(400,600);
        // ?
        JPanel p = new JPanel();

        // JFrames に 作りたいもの(JPanelの生成物 ?)を追加 == frame.add() メソッドを使って JFrames に追加 ??
        //     Add the panel to the frame
        frame.add(p);

        // ボタン「三角形を移動」ヲ作る
        JButton button = new JButton("三角形を移動");
        // JPanelに追加 (これがそのあと frameに追加されていく？)
        p.add(button);

        // ボタン「保存」を作る
        JButton button2 = new JButton("保存");
        p.add(button2);

        frame.setVisible(true);
--------------------------




JPanel
-----------------
パネルを作成する
パネルは主に他のコンポーネントをまとめるコンテナとしての利用
パネルに
  ボタンやラベルなどの他のコンポーネントを追加しlayoutを設定することができる(複数のコンポーネントを配置できるコンテナ)

http://manabu.quu.cc/up/jv/eJ1410.htm
Componentの継承クラスなので、JButtonと同じような部品として扱える
つまり、JPanelオブジェクトにJPanelオブジェクトを配置できます

https://docs.oracle.com/javase/jp/8/docs/api/javax/swing/JPanel.html
https://www.javadrive.jp/tutorial/jpanel/


三角形の描き方 プログラム参考 に なりそうな資料
... ただ、 class xyz extends JPanel ばかりで、interface関連は 殆ど見かけない
-------------------------------------------
https://nompor.com/2017/11/30/post-1503/
https://www.delftstack.com/ja/howto/java/java-draw-triangle/
https://informatics.sist.ac.jp/suganuma/game/Java/basic_technology/figure/figure.htm
https://stackoverflow.com/questions/29447994/how-do-i-draw-a-triangle
https://java2everyone.blogspot.com/2009/02/draw-triangle-in-jpanel.html
https://medium.com/@michael71314/java-lesson-21-drawing-and-coloring-shapes-on-the-jframe-d740970e1d68

https://w3resource.com/java-exercises/java-interface-exercise-6.php

 */