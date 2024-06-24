
/*  2024/05/22　第12回   クラスとインスタンス

    「モノ」をプログラムで表現する方法

Person.java  → PersonClass.java 、PersonMain.java

Step01.クラスを書く
Step02.書いたクラスをもとにインスタンス(モノ)を生成

 */
package lesson.classAndInst;

public class PersonMain {
    public static void main(String[] args){

        // インスタンス(オブジェクト) を 生成
        PersonClass p1 = new PersonClass("竈門",10);
        PersonClass p2 = new PersonClass("坂田",30);

        // 個々の情報の場合、オブジェクト名.メソッド名 で 出力
        System.out.println("エントリー：" + p1.getName() + p1.getAge());
        System.out.println("エントリー：" + p2.getName() + p2.getAge());


        // 人数(private static int number)の場合、
        // 同じパッケージ内にあるので プログラム(クラス名).メソッド()で 出力
        System.out.println("登録情報は、ただいま " +
                PersonClass.getNumber() + " 人です。");

    }
}
