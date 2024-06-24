
/*  2024/06/12 追加
    「 ジェネリクス で 使う型を 限定する 書き方 を 学んでみよう！
     (FruitsPairクラスの作成)」

 */
package lesson.aboutExtends;

// ジェネリクス < T extends xyz >
// T ==
// extends == 継承
// xyz = 継承される クラス名(プログラム名)、つまり 親クラス。
public class FruitsPair< T extends Fruits > {
    // Field
    public T first;
    public T second;

    //Constructor    クラス名(引数たち){}  not<>
    FruitsPair(T first,T second){
        this.first=first;     // 設定
        this.second=second;   // 設定
    }

    @Override
    //  T に 該当するクラス の toString()を あつらえた(カスタマイズ)
    public String toString(){
        return "( FirstPair:" + this.first + ", SecondPair:" + this.second +")";
    }
}

/*
https://qiita.com/suema0331/items/c5cc61c274fa94b68541

ジェネリクスとは
===============
任意の型を受け付ける クラス・メソッド に対して
特定の型を割り当てて、型専用のクラスを生成する機能

 */
