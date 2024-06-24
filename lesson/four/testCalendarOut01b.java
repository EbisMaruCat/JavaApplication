
package lesson.four;

// === #include的なもの。使用クラス ===
import java.util.Calendar;

public class testCalendarOut01b {

    // --- main()メソッド ---
    public static void main(String[] args){

        // ~~~ echoLN01()メソッドを呼び出して 利用する方法！(「インスタンス化」) ~~~
        testCalendarOut01a test01A = new testCalendarOut01a();     // まぁ 次からはやめとこう...

        // 下のように、「クラス名.メソッド名();」 で 呼び出して使えるようになった echo
        // (「インスタンス参照を介している」というらしい)
        test01A.echoLN01(" --- test Calendar(today) printOut 01(ver.b)--- ");
        test01A.echoLN01("");

        test01A.echoLN01(" \" 【test01b】Calendar ミニ応用 \" ");   // !? 「"」を表示する方法ミッケ...
        test01A.echoLN01(" それぞれの 部分を 取得して表示する「get(Calendar.____ )」の登場 ");



        // ...どうやって 01aの Calendar呼び出したらいいかわからんから...もう一回
        Calendar today01b = Calendar.getInstance();


        // ~~~~~ ここから Calendarの 特有メソッド "get(Calendar.____ )" ~~~~~~~
        test01A.echoLN01("YEAR : " + today01b.get(Calendar.YEAR));


        test01A.echoLN01("MONTH (あれ?) : " + today01b.get(Calendar.MONTH) + "  (「0」で 1月----→「11」で 12月)");
        test01A.echoLN01("MONTH (はぁ?) : " + (today01b.get(Calendar.MONTH))+1 + "  (迂闊！「()」の囲い忘れ)");
        test01A.echoLN01("MONTH (おぉ?) : " + ( ( today01b.get(Calendar.MONTH) ) + 1) + "  (よし、「()」で囲ったもの)");

        int actualMonth = today01b.get(Calendar.MONTH) + 1;
        test01A.echoLN01("MONTH (修正!) : " + actualMonth + "  (あえて 変数にして表示したもの)");


        test01A.echoLN01("DAY_OF_MONTH：" + today01b.get(Calendar.DAY_OF_MONTH));
        test01A.echoLN01("DAY_OF_WEEK (日曜日が「1」)：" + today01b.get(Calendar.DAY_OF_WEEK));
        test01A.echoLN01("WEEK_OF_YEAR：" + today01b.get(Calendar.WEEK_OF_YEAR));

        test01A.echoLN01("HOUR：" + today01b.get(Calendar.HOUR));
        test01A.echoLN01("( 24時間表示だと HOUR_OF_DAY：" + today01b.get(Calendar.HOUR_OF_DAY) + ")");
        test01A.echoLN01("MINUTE：" + today01b.get(Calendar.MINUTE));
        test01A.echoLN01("SECOND：" + today01b.get(Calendar.SECOND));

    }
}
