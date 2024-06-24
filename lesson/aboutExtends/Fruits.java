
/*  2024/06/05  ワンポイント--継承について--
    クラスとインスタンス の回 から 続いて。
    配布pdf資料より。

    2024/06/12   abstractとかを追加していく予定
    hashSet とか ラムダとかも 。
 */
package lesson.aboutExtends;

// hashSetで？
import java.util.Objects;

public class Fruits {
    // Field
    int price;
    String madeIn;
    String colour;

    // Constructor
    Fruits(int price, String madeIn,String colour){
        this.price=price;
        this.madeIn=madeIn;
        this.colour=colour;
    }

    String getDetail(){  // のちに Apple.javaで Overrideされている
        return "このフルーツの 生産地：" + this.madeIn + "、色：" +this.colour;
    }


    // boolean型 ... 「madeIn()で Japanと書いてあったか」の 判定
    boolean isMadeInJapan(){
        if(this.madeIn.equals("Japan") ){
            return true;
        }else {
            return false;
        }

        /* おぉ？ 上の全体を こんな書き方に 纏められるらしい... :
           return this.madeIn.equals("Japan");
         */
    }


    // https://www.bold.ne.jp/engineer-club/java-tostring
    // 細かいことは省略するけど、 「どこでも使える」「文字列に変換するためのメソッド」 らしい ?
    // ...Override が 発生してる？ @Override
    // それと、Apple.javaで Overrideされてる。 つまり Overrideしてる/されてる 状態。
    public String toString(){
        return "果物の値段は " + this.price + "円です。";
    }



    // ----- 06/12 追加 -----
    // equals()メソッド を Override...? 「(Objectクラスが親クラス)」...?
    public boolean equals(Object a){
        if( this.getClass() != a.getClass() ){
            return false;
        }
        else {
            Fruits sample = (Fruits) a;

            if(this.colour.equals(sample.colour)
                    && this.madeIn.equals(sample.madeIn)
                    //&& this.price.equals(sample.price)  intは使えない みたい？
               )
            {
                return true;
            }
            return equals(a);
        }
    }


    // ここで 一旦 Output.javaに戻ってみてや。

    // HashSetから戻ってきたな？ ほいだら、falseを 解決していく...
    // ここに hashCode()メソッド(こいつぁライブラリ物、デフォルトが falseなんだろうか) を 作成(Override)
    public int hashCode(){
        return Objects.hash(price,colour,madeIn);
    }


}
