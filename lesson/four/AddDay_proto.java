
/*  2024/04/22
    演習4  (1306_Java問題(課題) 問5より)

    日付演算をする(第1引数：日付 第2引数：日数)
    引数で指定した日付に日数(!)を加算し、結果を標準出力する

    第1引数 : 日付 (形式:YYYY/MM/DD)
    第2引数 : 日数

    出力形式 : 指定日時 日数 演算結果

   【!】演算結果の形式は 指定日付に同じ
   【!】指定日時や 日数が 不正の場合は エラーメッセージ表示を行う
*/
package lesson.four;

/*  メモ
    ・２つの引数 == つまり関数づくり？　abc(引数、引数)
      つまり：日付ゲット、追加する日数を指定して、計算(加算)
*/

// === #include的なもの。使用クラス ===
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDay_proto {

    // --- echoLN(String)メソッド ---
    private static void echoLN(String words){
        System.out.println(words);
    }

    // --- main()メソッド ---
    public static void main(String[] args){
        echoLN(" 2024/04/22  === 演習4 ===");
        System.out.println("演習4");
        String today = setDate("test");
        System.out.println(today);

        // 解答版
        String todayAnswer = addDayAnswer("2023/11/11",59);
        System.out.println(todayAnswer);
    }

    public static String setDate(String inputDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 表示方法
                                                                           // mm(小文字)あかん。 MMにすればOK
        Calendar restart = Calendar.getInstance();
        return sdf.format(restart.getTime());        // 戻り値
    }


    // 解答版
    public static String addDayAnswer(String yyyymmdd, int addDate){

        //yyyy/mm/ddの形式を読み取るためのもの
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");

        //カレンダー型のインスタンスを取得(実行時の日付になる)
        Calendar calendar = Calendar.getInstance();

        try{
            // yyyy/mm/dd形式のStringをDate型に変換
            Date d = sdf2.parse(yyyymmdd);
            // Date型をCalendar型に変換
            calendar.setTime(d);

            // 指定分の日数を加算
            calendar.add(Calendar.DAY_OF_MONTH, addDate);
        }
        // https://itsakura.com/java_printstacktrace
        catch (ParseException e){ //クラスParseException : 解析中に予想外のエラーが発生したことを表すシグナル
            // 例外処理 (出力するように)   Throwableクラスの「メソッド:printStackTrace」でスタックトレースを出力
            e.printStackTrace();  // 「スタックトレース」を出力
        }

        //yyyy/mm/dd形式のString型でreturn
        return sdf2.format(calendar.getTime());
    }
}


/*
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Date.html
https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html
https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
 */