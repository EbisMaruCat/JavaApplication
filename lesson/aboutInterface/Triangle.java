
package lesson.aboutInterface;

// public class Point用
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
    @Override
    public void draw() {
        System.out.println("三角を 描きました。");
    }


    // ここから インターフェースMeasurableの部分
    // Perimeterを 応用？
    @Override
    public int getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {

        return 0;
    }


    // ここから インターフェースMovable(ParallelMovable継承) の部分
    public void parallelMove(){
        System.out.println("平行移動しました。");
    }
    public void rotate(){
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

・ Math.sqrt、 Math.cbrt
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

Area(つまり面積) = |(xA-xC)(yB-yA)-(xA-xB)(yC-yA)|/2

「*0.5」ってするから メソッドは intではなく doubleに。 ------return (キャストint) が効かないから...。

 */

// 面積について
/*
https://ja.wikipedia.org/wiki/%E4%B8%89%E8%A7%92%E5%BD%A2

三角形の面積 :
    01.底辺・高さによる式
    02.3辺による式
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
    1/4 √2(BC+CA+AB)-( Aの2乗 + Bの2乗 + Cの2乗 )   ????
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

わかりやすくすると(三平方の定理がもと) :
Lengthの2乗 =  ( (x2-x1)の2乗) + (y2-y1)の2乗 )

...あれ?
平方根square root やん。
え、つまり？
    double X = Math.sqrt( (x2-x1)の2乗) );
    double Y = Math.sqrt( (y2-y1)の2乗) );

    double Length = X + Y; ?

追記 :
Point2Dクラス から 継承された distance()メソッドについて
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
だから、さっきの A(x1,y1) B(x2,y2) だったら...

Length =  √()
 */