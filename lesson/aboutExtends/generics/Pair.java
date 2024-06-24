
/*2024/06/10  ジェネリクスを使ってみよう

  homepageに書いてるこれ：
  クラス ArrayList<E>

  は、つまり：
  class Pair<T>

  のこと！
 */

package lesson.aboutExtends.generics;

// この < T > というのは、 つまりまぁ... 使用する型は決まってないから 「<(仮)>」っぽい設定
public class Pair<T> {
    // Field
    public T one;
    public T two;

    // Constructor
    public Pair(T one, T two){
        this.one=one;
        this.two=two;
    }

    // Override   not OverLoad
    @Override
    public String toString() {
        return "( One:" + this.one + ", Two:" + this.two + ")";
    }
}