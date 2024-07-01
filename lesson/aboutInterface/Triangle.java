
package lesson.aboutInterface;

/*
    2024/06/24
         06/26  JFrame,JPanel 追加
 */

// public class Point用
import javax.swing.*;
import java.awt.*;

// Shapeクラスを継承し、 インターフェースDrawable,Measurableを実装
class Triangle extends Shape implements Drawable,Measurable,Movable {

    // 実装する際、import java.awt.*がいる。各 Point = (x,y)の値
    Point p1;
    Point p2;
    Point p3;

    // 「平面上の 直交座標系(Cartesian coordinate system)」 2次元直交座標平面 ?
    // 3点 A(xA, yA), B(xB, yB), C(xC, yC) を頂点とする三角形
    //  ...つまり 座標図上の ３点の座標 から作った 三角形の図
    Triangle(Point p1,Point p2,Point p3){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
    }


    // インターフェースDrawableの部分
    // 2024/06/26 JFrame、JPanel追加したから 構築(Override)できる
    // 2024/07/01  インターフェース同士の継承ならまだしも、JPanelの構築ってなんぞ？
    //             testImplements から JFrame関連 移動
    @Override
    public void draw() {

        // 2024/07/01 -------------------------------------
        JFrame frame = new JFrame();
        frame.setTitle("課題 --三角形--");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel(){
            // @Override ...no?
            public void paintComponent(Graphics g){
                super.paintComponent(g);

                // 色 設定
                g.setColor(Color.LIGHT_GRAY);

                // xとyの座標指定、配列で作成する
                // this.p1.aa → p1.aa と、「this」を 削除してみる
                // ...これでは 描写されないみたいだわ。
                int[] xPoints = {
                        p1.x,
                        p2.x,
                        p3.x,
                };
                int[] yPoints = {
                        p1.y,
                        p2.y,
                        p3.y,
                };

                // 描写
                g.drawPolygon(xPoints, yPoints,3);

                // 塗りつぶし
                g.fillPolygon(xPoints, yPoints, 3);
            }
        };

        frame.add(panel);

        JButton button1 = new JButton("三角形を移動");
        panel.add(button1);
        // frame.add(button1);
        JButton button2 = new JButton("保存");
        panel.add(button2);
        // frame.add(button2);  oh,no...nope!
        // -------------------------------------------------

        System.out.println("三角を 描きました。");
    }

    // Overloadしてみっか？ でもこれだと interfaceじゃなくなるぞ？？
    // public void draw(Graphics g){
    // }


    // ここから インターフェースMeasurableの部分
    // Perimeterを 応用？
    // 平方根 Math.sqrt
    // S = √s(s-a)(s-b)(s-c) ......
    //      ↑この小文字s = 1/2 * (a + b + c)
    @Override
    public int getArea() {
        double s = getPerimeter()*0.5;

        double aP = Point.distance(this.p1.x,this.p1.y,this.p2.x,this.p2.y);
        double bP = Point.distance(this.p2.x,this.p2.y,this.p3.x,this.p3.y);
        double cP = Point.distance(this.p1.x,this.p1.y,this.p3.x,this.p3.y);

        double sBig = Math.sqrt( s*(s-aP)*(s-bP)*(s-cP) );
        return (int) sBig;
    }

    @Override
    public int getPerimeter() {
        double a = Point.distance(this.p1.x,this.p1.y,this.p2.x,this.p2.y);
        double b = Point.distance(this.p2.x,this.p2.y,this.p3.x,this.p3.y);
        double c = Point.distance(this.p1.x,this.p1.y,this.p3.x,this.p3.y);
        return (int)(a+b+c);
    }


    // ここから インターフェースMovable(ParallelMovable継承) の部分
    public void parallelMove(){
        // x軸に amtX, y軸に amtY
        // 点P(xp,yp) Q(xq,yq) R(xr,yr)   → ( xp+amtX, yp+amtY)とかか？
        int ampX = 5,ampY = 5;

        Triangle moveTri = new Triangle(
                new Point(this.p1.x + ampX,this.p1.y + ampY),
                new Point(this.p2.x + ampX,this.p2.y + ampY),
                new Point(this.p3.x + ampX,this.p3.y + ampY)
        );

        System.out.println("平行移動しました。");
    }

    // 回転移動
    public void rotate(){
        // sin θ(シータ)、 cosΘ、tanΘ

        System.out.println("回転しました。");
    }
}


// ......ええぃ メモは 後でや！！

// java の　Mathクラス について
/*
https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Math.html
https://www.javadrive.jp/start/math/

・ Math.random
    乱数を生成。簡素ゲームで お馴染みの。

・ Math.abs()
    絶対値(負数だろうと正数にする) を取得
・ Math.max、 Math.min
    大きい値(maxの方) または 小さい値(min) を取得
・ Math.pow
    累乗した値を取得

・ Math.sqrt(double a)、 Math.cbrt
    平方根(sqrt、正しく丸めた正の平方根) あるいは 立方根(cbrt)を取得。

    平方根square root: 2乗(平方) して a になる数を a の平方根。
        √4 == 2     4の平方根 = 2
    立方根cubic root : 3乗(立方) して a になる数を a の立方根。
        √27 == 3    27の立方根 = 3


・ Math.log など
    対数を取得
・ Math.ceil、 Math.floor、 Math.round
    切り上げ/切捨て/四捨五入を取得
・ Math.sin、 Math.cos、 Math.tan
    三角関数に関する計算を行う
・ Math.toRadians、 Math.toDegrees
度の単位の角度をラジアン単位に変換
 */

// getArea()別もの。 double getArea()
/*

public double getArea() {
    return Math.abs((p1.getX()-p3.getX())*(p2.getY()-p1.getY())-
            (p1.getX()-p2.getX())*(p3.getY()-p1.getY())) * 0.5;
}

拝借:
https://stackoverflow.com/questions/2145571/java-calculating-area-of-a-triangle

A(xA,yA)  B(xB,yB)  C(xC,yC)

Area(つまり面積) = ( (xA-xC)(yB-yA)-(xA-xB)(yC-yA) ) ÷ 2

「*0.5」ってするから メソッドは intではなく doubleに。 ------return (キャストint) が効かないから...。

 */

// 面積について
/*
https://ja.wikipedia.org/wiki/%E4%B8%89%E8%A7%92%E5%BD%A2

三角形の面積 :
    01.底辺・高さによる式
    02.3辺による式                  ← int getArea() は 多分 この式
    03.2辺夾角による式
    04.1辺両端角（2角夾辺）による式
    05.内接円・傍接円による式
    06.直交座標による式              ← double getArea() は 多分 この式やろうな
    07.極座標による式

01.底辺・高さによる式 =
    1/2 * a * hに小さいa
    ↑
    a=底辺、 hに小さいa= 頂点 A の対辺 a に対する高さ

02. 3辺による式 (辺a,b,c) =

    面積Sとすると、
        S = √s(s-a)(s-b)(s-c)    ...??
             ↑
             この小さいsは 半周長といって 中身はこれ : 1/2 * (a + b + c)
    これは
        S = 1/4 * √(a+b+c)(-a+b+c)(a-b+c)(a+b-c) と 同じ意味...???

    あるいは、
        S = 1/4 * √2(BC+CA+AB)-( Aの2乗 + Bの2乗 + Cの2乗 )   ....????
           ↑
           aの2乗 = A, bの2乗 = B, cの2乗 = C

03. 2辺夾角による式 (辺a,b)=
    1/2 * a * b * sin * θ
                   ↑
                  sin = ヘロンの公式
                       (3辺の長さがa,b,cなどと分かっている三角形の面積Sを求める公式)、
                  θ = 2辺のなす角の大きさ(ラジアン(rad))

04.1辺両端角（2角夾辺）による式
05.内接円・傍接円による式
06.直交座標による式
07.極座標による式

... 続きの編集 は 今度！

 */

// Perimeter = 周囲。周長。
/* ...三角形の  3辺(a,b,c)の長さを加算するだけなのか？ そのままか？
だが、
座標だから 長さを求める手間がある... (;▽;)oh no...

...つまり？
      p1 x1,y1   p2 x2,y2   p3 x3,y3
        lenAの2乗 =  ( (x2-x1)の2乗 + (y2-y1)の2乗 )
        lenBの2乗 =  ( (x3-x2)の2乗 + (y3-y2)の2乗 )
        lenCの2乗 =  ( (x3-x1)の2乗 + (y3-y1)の2乗 )  ??
*/

// その 周長について (+ distance()メソッドについて )
/*
2点間の距離
https://www.try-it.jp/keyword_articles/26/

A(x1,y1)
B(x2,y2)

距離 Length = √ ( (x2-x1)の2乗) + (y2-y1)の2乗) )　

わかりやすくすると(三平方の定理がもと ?) :
Lengthの2乗 =  ( (x2-x1)の2乗) + (y2-y1)の2乗 )

...あれ?
平方根square root やん。
え、つまり？
点A(x1,y1)と B(x2,y2)を、
    double X = Math.sqrt( (x2-x1)の2乗) );
    double Y = Math.sqrt( (y2-y1)の2乗) );

    double Length = X + Y; ?




追記 :
Point2Dクラス から 継承された Point.distance()メソッドについて
https://docs.oracle.com/javase/jp/7/api/java/awt/geom/Point2D.html#distance(double,%20double)

ある点 A(x1,y1) B(x2,y2)で
    public static double distance(double x1, double y1,
                                  double x2, double y2)
    指定された 2つの座標セット(AとB) の間の距離を 算出してくれるメソッド。

また、ある点Point2D(??)と、点P(px,py)だとして、
    public double distance(double px, double py) を使うと、
    このPoint2Dから 点Pまで の 距離を 算出。

他にも、Point2Dだけ だったら
    public double distance(Point2D pt) を使うと、
    このPoint2Dから Point2Dまで の 距離を 算しゅ...つ... ????


...
だから、今回の A(x1,y1) B(x2,y2) C(x3,y3)だったら...

Length ab =  √((x2-x1)の2乗) + ((y2-y1)の2乗)
　　　さくっと = Point2D.distance(A.x,A.y, B.x,B.y)
Length bc = Point2D.distance(C.x,C.y, B.x,B.y)
Length ac = Point2D.distance(A.x,A.y, C.x,C.y)

...ここはもう Math.sqrt いらない？
　
 */