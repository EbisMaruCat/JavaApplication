
/*  2024/06/05  ワンポイント--継承について--
    クラスとインスタンス の回 から 続いて。
    配布pdf資料より。

    2024/06/12   abstractとかを追加していく予定
    hashSet とか ラムダとかも 。
    今回は hashSet追加

    2024/06/17
    Abstractクラス 追加
 */
package lesson.aboutExtends;

// 06/12 hashSet()メソッド 利用するから パッケージ を インストール
import java.util.HashSet;


// Main.javaにすると ごっちゃになるから  Output.java変えたんです。
public class Output {
    public static void main(String[] args){

        // String型 system.out.println省略 echoS()メソッド
        echoS echoSOut =new echoS();

        // Fruitクラスの インスタンス作成(オブジェクトを生成する ともいう。混乱するなぁ...)
        // 参考例の apple→orange に 代えて見やすくしている...
        Fruits orange = new Fruits(400,"Japan","橙");

        // getDetail()の 参照
        echoSOut.echo(orange.getDetail());

        // madeIn() や price() の 参照
        echoSOut.echo("再確認 madeIn：" + orange.madeIn);
        System.out.println(orange.price);
        System.out.println("Made in Japan? :" + orange.isMadeInJapan());

        // toString() の 参照(というのか、インスタンス名だけ を 書いて 出力)。
        System.out.println(orange);


        // 改行
        echoSOut.echo("");


        // 継承クラスApple の インスタンス作成
        Apple apple = new Apple(350,"Japan","赤い","甘い");

        // 以下 同じように 参照
        echoSOut.echo(apple.getDetail());
        echoSOut.echo("再確認 madeIn：" + apple.madeIn);
        System.out.println(apple.price);

        System.out.println(apple);


        // Apple.javaには書いてなかったけど、 Fruitsクラスをextendsしてるなら
        // あの、boolean型isMadeInJapan() 出せるんじゃない？ の 部分
        System.out.println("Made in Japan? :" + apple.isMadeInJapan());  // 出せたねぇ...


        echoSOut.echo("");


        // ------ 06/12 追加 -----
        // equals()メソッド を Override...? 「(Objectクラスが親クラス)」...?
        // Fruit.javaで equals()メソッド 作ってきて。


        // それじゃあ
        //   まずは Fruitsで 全く同じ内容の オブジェクト(インスタンスともいう... )を 作成
        Fruits f1 = new Fruits(199,"Japan","赤い");
        Fruits f2 = new Fruits(199,"Japan","赤い");

        // くだんの equals()で 確認。
        System.out.println(f1.equals(f2));   // 結果が true。 よし


        // 次。
        //  「Fruitsクラスの同じ内容のインスタンス2つを
        //   HashSet2つにそれぞれ追加して
        //   equalで比較してみよう！」
        HashSet<Fruits> hf1 = new HashSet<>();
        hf1.add(f1);

        HashSet<Fruits> hf2 = new HashSet<>();
        hf2.add(f2);

        System.out.println(hf1.equals(hf2));  // 結果が FALSE !?

        // ここで Fruits.javaで hashCode()を 作成(Override)してきて。
        // ...結果が FALSE ではなくなって true に 変わったやろ？ なんでかは 調べてるけど

        echoSOut.echo("");


        // ジェネリクスで使う型を限定する書き方 : FruitsPair.javaを 早速
        Apple appleA = new Apple(199,"Japan","赤い","甘い");
        Apple appleB = new Apple(199,"Japan","赤い","甘い");

        FruitsPair<Fruits> pair001 = new FruitsPair<>(f1,f2);
        FruitsPair<Apple> pairApple = new FruitsPair<>(appleA,appleB);

        System.out.println(pair001);
        System.out.println(pairApple);


        echoSOut.echo("");

        // ----- 06/17 追加 -----
        // 「Abstractクラスを使ってみよう！
        //  (Foodクラスの作成→Fruitsクラスで継承)」

        // abstract Foodクラスであるから、
        //     new(オブジェクト生成)は できない :「Food food01 = new Food(210,"Japan"); 」エラー出る。
        // だが、その構成を 継承したFruitsFoodなら、 できる。
        FruitsFood papaya = new FruitsFood(210,"Japan","yellow");
        System.out.println(papaya);

    }
}
