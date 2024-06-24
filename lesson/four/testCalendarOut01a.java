
package lesson.four;

// === #include的なもの。使用クラス ===
import java.util.Calendar;


public class testCalendarOut01a {

    // --- echoLN01(String)メソッド ---
    public static void echoLN01(String words){
        System.out.println(words);
    }


    // --- main()メソッド ---
    public static void main(String[] args){

        // ~~~ echo()利用 ~~~
        echoLN01(" --- test Calendar(today) printOut 01(ver.a)--- ");

        echoLN01("【test01a】Calendar直接 ");

        // Calendar型 の インスタンス 「today」生成
        // 特有メソッド "getInstance()"
        Calendar today = Calendar.getInstance();


        // このあと使用するのは  Calendar型の 特有メソッド "getTime()" 。日付取得。

        // 【!】 通じない：echoLN01(today.getTime())　。「System.out.println()」で出力しよう...


        System.out.println(today.getTime());      // 「インスタンス名.メソッド名」
        // 出力結果： WEEK MONTH DAY 00:00:00 GMT+09:00 YEAR

    }
}
