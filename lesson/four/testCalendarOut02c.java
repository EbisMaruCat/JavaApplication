
package lesson.four;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testCalendarOut02c {
    public static void main(String[] args){

        // echoLN02.java から　echo()メソッドを利用したい！
        echoLN02 echoOutC = new echoLN02();        // インスタンス化
        echoOutC.echo("""
                --- test Calendar(today) printOut 02(ver.c) ---
                【test02c】Calendar[SimpleDateFormat変換版] ～実は「例外処理」いるのよ～
                """);

        // さぁて、本来の『例外処理付き SimpleDataFormat』を 作りまひょ... 下に todayDate_02C()メソッド

        String s_today02c = todayDate_02C("test");
        echoOutC.echo(s_today02c);

    }

    // todayDate_02C()メソッド  ( testCalendarOut02a.javaにあった todayDate()メソッド を 変えたもの )
    public static String todayDate_02C(String input_02C){

        SimpleDateFormat sdf_02C = new SimpleDateFormat("yyyy/MM/dd");
        Calendar reGetC = Calendar.getInstance();

        // 戻り値出力 に 対応するため
        String s_CalC = new String();

        try{
            s_CalC = sdf_02C.format(reGetC.getTime());
        }catch (IllegalArgumentException errorC){
            errorC.printStackTrace();
        }

        // 戻り値
        return s_CalC;
    }
}
