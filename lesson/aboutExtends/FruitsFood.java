

package lesson.aboutExtends;

import java.util.Objects;


// Foodクラスを FruitsFoodで継承
// ちなみに このFruitsFoodクラスは ほとんどFruitsクラスの中身と一緒。
// 作成物をあとから見返すときに 混乱しないように あえて 別物FruitsFood.java にさせてもろうてます

// Food.javaを継承している FruitsFood.java
public class FruitsFood extends Food{

    // Field (継承してる身だから ここは 親クラスFruits.javaから 取れる)

    // Constructor 親クラスで組み立てて ここブランクでもok  p115見る限りでは。
    FruitsFood(int price, String madeIn,String colour){
        this.price=price;
        this.madeIn=madeIn;
        this.colour=colour;
    }

    // 親クラスであるFood.javaで abstract指定されているもの。
    // といっても、別に なにも 特別設定はない。 ただただ、組み立てる。
    // これを、Food.javaは 「ほな この通りに 利用させてもらいまっせ」の 関係 だけ。
    String getDetail(){
        return "このフルーツの 生産地：" + this.madeIn + "、色：" +this.colour;
    }


    // 親クラスFood.java の isMadeInJapanを オーバーライド
    // (といっても 中身に変化ないんだけど、宣言(組立)してるからには オーバーライド扱い...?)
    @Override
    boolean isMadeInJapan(){
        return this.madeIn.equals("Japan");
    }


    @Override
    public String toString(){
        // ごめんね、おまけというか。 「こんなこともできまっせ」ってこと：getDetail()の中身を ごっそり利用。
        return getDetail() + "\n" +
                "果物の値段は " + this.price + "円です。";
    }

    // ----- 06/12 追加箇所 -----
    @Override
    public boolean equals(Object a){
        if( this.getClass() != a.getClass() ){
            return false;
        }
        else {
            Fruits sample = (Fruits) a;
            if(this.colour.equals(sample.colour) && this.madeIn.equals(sample.madeIn) )
            {
                return true;
            }
            return equals(a);
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(price,colour,madeIn);
    }
}
