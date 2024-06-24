
/*  2024/06/05  ワンポイント--継承について--
    クラスとインスタンス の回 から 続いて。
    配布pdf資料より。

継承 : extends

    2024/06/12   abstractとかを追加していく予定
    hashSet とか ラムダとかも 。今 特に変化なし

 */
package lesson.aboutExtends;

// Fruits.java (Fruitsクラス)を 継承した Apple.java
public class Apple extends Fruits{

    // Field
    // 継承のなかで、 新たに追加したもの:
    String taste;

    // Constructor
    // 継承した物らは super()で、 そのあとは 追加した物を いつも通りに書く。
    Apple(int price, String madeIn,String colour,String taste){
        super(price, madeIn, colour);
        this.taste=taste;
    }

    // 別クラス(Fruits.javaのことでんな)と 同じメソッド名 だけど、内容が ちょっぴし変わっているもの。
    // これがオーバーライド(Ride)。 not ロードLoad
    @Override
    String getDetail(){
        return "このりんごの 生産地：" + this.madeIn +
                "、色：" + this.colour +
                "、味：" + this.taste;

        /* お得情報 2024/06/05
            最初の部分がほぼ おなじなら 上を こんな風に書けるんやて
            return super.getDetail() + "、味：" + this.taste;   // Fruitクラスを 丸々そのまま 使うってことやわ
        */
    }


    // Overrideその2
    @Override
    public String toString(){
        return "このりんごの値段は " + this.price + "円です。";
    }
}
