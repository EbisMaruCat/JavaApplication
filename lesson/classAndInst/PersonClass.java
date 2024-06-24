
/*  2024/05/22　第12回   クラスとインスタンス

    「モノ」をプログラムで表現する方法

Person.java  → PersonClass.java 、PersonMain.java

Step01.クラスを書く
Step02.書いたクラスをもとにインスタンス(モノ)を生成

 */
package lesson.classAndInst;

public class PersonClass {          // personClassクラス

    // フィールド の定義
    private static int number;      // 人数 クラス変数(static)
    private String name;            // 名前 インスタンス変数
    private int age;                // 年齢 インスタンス変数

    // コンストラクタ の定義 ( "new" する時に 赤部分が走る )
    public PersonClass(String nameN, int ageA){
        this.name = nameN;         // nameインスタンス指定
        this.age = ageA;           // ageインスタンス指定
        number++;
    }

    // それぞれの インスタンス メソッド
    public static int getNumber(){
        return number;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

}
