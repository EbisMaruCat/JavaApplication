
/*  2024/06/17
    Abstractクラスを使ってみよう！
    (Foodクラスの作成→Fruitsクラスで継承)

abstract修飾子 : 抽象メソッド( それを持つクラスを 抽象クラス)
    処理を記述しないで、呼び出しだけを定義したもの。

    ・抽象クラスのオブジェクトは 生成できない(new できません)
    ・継承して 抽象メソッドを オーバーライドできる
 */
package lesson.aboutExtends;

public abstract class Food {
    // Field
    int price;
    String madeIn;
    String colour;



    // ① getDetailメソッドに abstract をつける
    // つまり、呼び出しだけを 作ってるけど、
    // 出力内容は extends先のクラス のメソッドで 組み立てる(作成)
    abstract String getDetail();

    boolean isMadeInJapan(){
        return this.madeIn.equals("Japan");
    }

    public String toString(){
        return "果物の値段は " + this.price + "円です。";
    }
}
