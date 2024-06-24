package lesson.aboutExtends.generics;

public class Quadruple<X> {

    // Field
    public X firstQ;
    public X secondQ;
    public X thirdQ;
    public X fourthQ;

    // Constructor    しょっちゅう注意： ここは()であって <>ではない！
    Quadruple(X firstQ, X secondQ, X thirdQ, X fourthQ){
        this.firstQ=firstQ;
        this.secondQ=secondQ;
        this.thirdQ=thirdQ;
        this.fourthQ=fourthQ;
    }


    // 前に作った Pair.java と Pair2.java を 使って 組み立ててみよう...?
    //  Pair2( Pair(X f1,X s1), Pair(X f2,X s2) ) ...????
    //  宣言するときってこうだから...「 Pair2<String, Integer> testPair2 」

    // まずは Pair.java どうしで。
    // 宣言って 「Pair<String> testPair1 = new Pair<>("test1a","test2a")」
    //  ...... Pair<> ( Pair<>(A,B), Pair<>(C,D) ) にしたいわけだから...
    // Pair<Pair<String> >  testXYA
    //  getメソッド？ あの取得メソッドか？？
    // public <X> getQuadruple(){}では不足らしい。

    /* 講師の助言  <(__ )> 助かります...
     public - メソッドの公開範囲
     static  - クラスメソッドにするよ
     <A>  - Aという型パラメータを使うよ
     Quadruple<A> -  Quadruple<A> 型を返すよ
     getQuadrupleBy(Pair<Pair<A>> pairPair) {
     */
    public static <A>  Quadruple<A> getQuadrupleBy( Pair< Pair<A> >  pairFour ){
        return new Quadruple<A>(
            pairFour.one.one,
            pairFour.one.two,
            pairFour.two.one,
            pairFour.two.two
        );
    }

    // 締めには この 出力文章。
    // でないと PairMain.javaの println()で こんな文章になっちまうぞ:「lesson.generics.Quadruple@133314b」
    public String toString(){
        return "( First:" + this.firstQ +
                ", Second:" + this.secondQ +
                ", Third:" + this.thirdQ +
                ", Fourth:" + this.fourthQ + ")";
    }

}
