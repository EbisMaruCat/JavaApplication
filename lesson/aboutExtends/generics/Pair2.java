
/* 型パラメータを2つ持つPair2クラス
 */

package lesson.aboutExtends.generics;

// Pair.java と ほぼ同じだが、 ただ異なるのは <T,S>と わざわざ区別している。
// ...目的は ずばり、「違う型が 使えるようになる」こと である。
public class Pair2<T,S> {

    // Field
    public T first;
    public S second;

    // Constructor
    Pair2(T first, S second){
        this.first=first;
        this.second=second;
    }

    // Override
    @Override
    public String toString(){
        return "( First:" + this.first + ", Second:" + this.second +")";
    }

}
