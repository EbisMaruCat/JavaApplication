
/* 2024/06/19  インターフェースについて
        06/24  追加:
   「平行移動を表すinterface 「ParallelMovable」
    回転を含んだ移動を表すinterface 「Movable」(interface の 継承(extends) を用いる) 」

 */
package lesson.aboutInterface;

// 2024/07/01 試すか？
import javax.swing.*;

// 2024/07/01  extends JPanel追加
class Shape extends JPanel {
    int size;
}

// インターフェースDrawable
interface Drawable{
    void draw();
}

// インターフェースMeasurable
interface Measurable{
    int getArea();
    int getPerimeter();
}

/*　
Heroクラスを インターフェースDrawable を実装して 作成
これが もし 独立した Hero.javaだったら、

class Hero implements Shape.Drawable{}
になってた...
*/
class Hero implements Drawable {
    public void draw(){
        System.out.println("勇者を 描きました。");
    }
}


// 06/24 追加部分
interface ParallelMovable{
    void parallelMove();
}

interface Movable extends ParallelMovable{
    void rotate();
}


// 07/01 ----追加
interface Scale{
    void scalable();
}

