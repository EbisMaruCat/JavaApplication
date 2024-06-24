package lesson.classAndInst.menuCafe.timeCHQ;

/*
https://docs.oracle.com/javase/jp/8/docs/api/java/text/SimpleDateFormat.html
https://jp-seemore.com/app/14221/#toc7
https://qiita.com/takahirocook/items/aa857c8f2153193095e4

SimpleDataFormat
  01.日付の書式設定(日付→文字列)
  02.解析(文字列→日付)

01.は 今までの こと。
---------------------------------------------------------------------
    Calendar cdf = Calendar.getInstance();
    SimpleDataFormat sdf = new SimpleDateFormat("yyyy/MM/dd  H:m");
    String todayCal;
    todayCal= sdf.format(cdf.getTime());

    System.out.println(" 今日の日付 : " + todayCal);
---------------------------------------------------------------------

02.は、Parseを使うらしい。  https://jp-seemore.com/app/14221/#toc7
ただし、例の「try{}catch{} 」の使い方も 忘れずに

*/

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateSDFParse {
    public static void main(String[] args){

        Date hmToday = new Date();
        String what = u(hmToday);

        System.out.println("First : " + what);

        try {
            // SimpleDateFormat インスタンスの作成
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  H:m");

            // 文字列から Date オブジェクトへの変換
            Date dateBack = sdf.parse(u(hmToday));

            // 変換結果の出力
            System.out.println("ReDate:" + dateBack);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String u(Date hmToday){

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd  H:m");

        String formatedDate = sdfDate.format(hmToday);

        return formatedDate;
    }
}
