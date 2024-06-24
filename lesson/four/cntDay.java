package lesson.four;

/* 2024/04/22  (1306_Java問題(課題) 問5より)
 *  演習4 日付演算をする(第1引数：日付(形式：yyyy/MM/dd) 第2引数：日数)
 *        引数で指定した日付に日数(*)を加算し、結果を標準出力する
 *          出力形式： 指定日時 日数 演算結果
 *  【!】指定日時や日数が不正の場合、エラーメッセージ表示を行う
 * */

// ２つの引数  つまり関数づくり？　abc(引数、引数)
// つまり：日付ゲット、追加する日数を指定して、計算(加算)
// echo   ? いまだに使えない... (;;)   ※2024/04/23 Ubuntuはok、だがIDEあかん
// 2024/04/24 模範解答追加...


// ==== 使用クラス(#include的なもの) ===
import java.util.Calendar;           // 今日の日付取得する 便利道具(クラス)
import java.text.SimpleDateFormat;   // 日時の書式変換(フォーマット変換) 便利道具(クラス)

import java.util.Date;               // 日付取得。ミリ秒単位で示したもの
import java.text.ParseException;     // Parse 万が一のエラー処理

// setTime()モジュール   Date型をCalendar型に変換する

// === 本題 ===
public class cntDay {
    public static void main(String[] args) {
        System.out.println("== 演習4 ==");

        System.out.println("試し01 ---日付取得中...(Calendar直接版)");
        Calendar today = Calendar.getInstance();  // 今日の日付取得 用の 関数today(インスタンス)作成
        System.out.println(today.getTime());      // today の内容 出力。おそらく時間まで出る...


        System.out.println("試し02 ---再取得中...(Calendarを SimpleDateFormat変換版)");
        String N_day = disDate("test");
        System.out.println(N_day);

        System.out.println("試し03 ---ここから追加してみる。今日の月+3カ月 (Calendar.add版)");
        today.add(Calendar.MONTH,3);    // String N_dayあかんかった...
        System.out.println(today.getTime());
        System.out.println("上のやつ(SimpleDateFormat) 使えんかった...");

        /*System.out.println("試し04 ---echo使ってみた (2024/04/23)、IDE まだ失敗中... ");
        echo("エコー使えるデー！ こんな感じで。");
        */

        System.out.println("試し04 ---echo使ってみた 2024/04/25 解決");
        echo("エコー使えるデー！やったぜよ！");

        System.out.println("---------本題。");
        /*String test_Date = abc_Date("test01",30);
         * 失敗。*/

        // ↓ 解答
        String test_Add = cntDate("2024/04/24",30);
        System.out.println(test_Add);
    }

    // --- 試し02 ---
    public static String disDate(String inputDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  // 表示方法
        // mm(小文字)あかん。 MMにすればOK
        Calendar restart = Calendar.getInstance();
        return sdf.format(restart.getTime());        // 戻り値
    }

    // --- 試し03 ---
    /*public static String echo(String str){
        return System.out.println(str);
    }*/
    // "String" → "void"  ----String型ではなく、void型にすれば使える。
    public static void echo(String str){
        System.out.println(str);
        // return 不要！
    }



    // --- 試し04 ---
    /* public static String abc_Date(){
         SimpleDateFormat xyz = new SimpleDateFormat("yyyy/MM/dd");
         Calendar YMD = Calendar.getInstance;
         YMD.add(Calendar.DAY_OF_MONTH, abc_Date);
         return xyz.format(YMD.getTime());
       }
    */

    // --- 試し04 (解答版)---   String cntDateあかんかった
    public static String cntDate( String yyyymmdd, int countDate){
        SimpleDateFormat abc = new SimpleDateFormat("yyyy/MM/dd");
        Calendar HDK = Calendar.getInstance();
        try {
            Date d = abc.parse(yyyymmdd);   // simpleDateFormatの変数abc に parseメソッド(引数 yyyymmdd)
            HDK.setTime(d);                 // Calendarの変数HDKに setTime(Date dを)
            HDK.add(Calendar.DAY_OF_MONTH, countDate);       //そこで、HDKにaddメソッド()
        }catch (ParseException e) {
            e.printStackTrace();//例外処理 (出力するように)
        }
        return abc.format(HDK.getTime());
    }
}