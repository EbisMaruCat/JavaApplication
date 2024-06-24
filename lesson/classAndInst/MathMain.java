
package lesson.classAndInst;

/* 2024/05/27   クラスとインスタンス 練習問題

   準備：import java.awt.Point;

   その1：Mathクラスの static変数"Math.PI" の値を出力。
         PI=円周率のこと(自動的に取り出される)
   その2：import java.awt.Pointを使って インスタンス変数「x,y」の値を設定して出力
   その3：Stringクラスの staticメソッド"valueOf" を使って値を出力
   その4：Integerクラスの staticメソッド"parseInt" を使って値を出力
   その5：Dateクラスの インスタンスメソッド"getTime" を使って値を出力。
         getTime()=1970年1月1日午前0時からの経過時間をミリ秒で返し
*/

import java.awt.Point;
import java.util.Date;

public class MathMain {

    private static void echo(String words){
        System.out.println(words);
    }

    public static void main(String[] args){

        // その１  単純に こういうことだった...
        System.out.println(Math.PI);

        // その２ 「例」模範  インスタンス変数「x,y」の値
        Point p = new Point(5,10);
        int x = p.x;
        int y = p.y;
        System.out.println(p);

        // その２　模範解答
        Point o = new Point();
        o.x = 1;
        o.y = 3;
        System.out.println(o);

        // その３ 「例」模範  Stringクラスの staticメソッド"valueOf"
        String a = String.valueOf(11);   // String 変数名 = Stringクラス.
        echo(a);

        // その４ 「例」模範  Integerクラスの staticメソッド"parseInt"
        Integer b = Integer.parseInt("111");
        System.out.println(b);

        // その５ 「例」模範  Dateクラスの インスタンスメソッド"getTime"
        Date mathDate = new Date();
        String mDate01 = String.valueOf(mathDate.getTime());
        echo(mDate01);
        String mDate02 = mathDate.toString();
        echo( mDate02 );

        // その５  模範解答１
        Date dateEx = new Date();
        System.out.println(dateEx.getTime());
        // 模範解答２
        Date dateEx2 = new Date();
        long time = dateEx2.getTime();
        System.out.println(time);
        // 模範解答 2.5
        Date d = new Date();
        long l = d.getTime();
        System.out.println(l);
        long sec = l / 1000 ;
        long minute = sec / 60;
        long hour = minute / 60;
        long day = hour / 24;
        long year = day /365;
        System.out.println(year);

    }

}
