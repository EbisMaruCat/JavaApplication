
package samples;

// https://nompor.com/2017/11/30/post-1503/

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;


public class TryTri_Swings_1 {
    public static void main(String[] args) {
        GameWindow gw = new GameWindow("テストウィンドウ",400,300);
        gw.add(new DrawCanvas());//描画領域の追加
        gw.setVisible(true);
    }
}

//ウィンドウクラス
class GameWindow extends JFrame{
    public GameWindow(String title, int width, int height) {

        super(title);
        //
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //
        setSize(width,height);
        //
        setLocationRelativeTo(null);

        // Sets whether this frame is resizable by the user
        setResizable(false);
    }
}

//描画する紙を表すクラス
class DrawCanvas extends JPanel{
    public void paintComponent(Graphics g) {

        super.paintComponent(g);//ここは無くても問題ないかもしれませんが一応書いておいてください。

        //ここに描画処理を記述
        // 点(100,100)と 点(200,200) を結ぶ線
        // g.drawLine(100,100,200,200);

        // g.drawRect(100,100,50,50);//矩形
        // g.fillRect(200,100,50,50);//矩形の塗りつぶし

        g.drawPolygon(new int[] {125,150,100}, new int[] {100,150,150}, 3);//多角形
        g.fillPolygon(new int[] {225,250,200}, new int[] {100,150,150}, 3);//多角形の塗りつぶし
    }
}

