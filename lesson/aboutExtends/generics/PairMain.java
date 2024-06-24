
/* 2024/06/10  ジェネリクスを使ってみよう

クラスArrayList<E>
https://docs.oracle.com/javase/jp/8/docs/api/java/util/ArrayList.html

 */

// 今回の主役：
package lesson.aboutExtends.generics;
// これでも いけなくはないけど、 おすすめではない らしい : import lesson.generics.Pair;

public class PairMain {
    public static void main(String[] args){

        // ----- 「class Pair<T>」  -----
        // 型は1種 だけど、フィールドでは 要素を 2つとか設定できる...?
        Pair<String> testPair1 = new Pair<>("test1a","test2a");

        // で、toString()メソッドに 記述した通りの 出力になる。
        System.out.println("test1a:"+ (testPair1) );


        // ...つまり こんなこともできる <String → Integer>：
        Pair<Integer> testPair1b = new Pair<>(200,400);
        System.out.println("test1b:" + testPair1b);


        // ----- 型パラメータが ２つ 「class Pair2<T,S>」 -----
        // これなら こう...別々の型が使える
        Pair2<String, Integer> testPair2 = new Pair2<>("test1b",100);

        System.out.println("test2a:" + testPair2 );

        // ここも試してみよう。
        Pair2<Integer,Float> testPair2b = new Pair2<>(100,50.5f);
        System.out.println("test2b:" + testPair2b);


        // ----- Quadruple.java を使って 出力をしてみる。 -----
        Pair<String> pairQ1 = new Pair<>("testQ-a1","testQ-a2");
        Pair<String> pairQ2 = new Pair<>("testQ-b1","testQ-b2");

        // 本当は 候補にpairPairとあるけど、あえてpairQQにしてみてる...見やすさのため
        Pair<Pair<String>> pairQQ = new Pair<>(pairQ1,pairQ2);

        // 「Quadruple<String> qOUT = new Quadruple<>(pairQQ);」 は 違うぞ... ほら、getなんちゃら使うんや。
        Quadruple<String> qOUT = Quadruple.getQuadrupleBy(pairQQ);

        System.out.println(qOUT);



        /* ----- 暇だったら作ってみてな の SAMPLE -----
            照り焼きマック   ...a
            通常価格 : 250  ...b
            深夜価格 : 200  ...c

            a: 普通の String
            b,c: Pair2<String,Integer>ずつ だとして...

            あ、あかんわ。
            やっぱ なし！
         */


    }
}