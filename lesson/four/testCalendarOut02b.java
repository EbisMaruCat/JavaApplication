package lesson.four;


public class testCalendarOut02b {
    public static void main(String[] args){

        // echoLN02.java から　echo()メソッドを利用
        echoLN02 echoOutB = new echoLN02();        // インスタンス化
        echoOutB.echo("test echoLN02");
        echoOutB.echo("");

        echoOutB.echo("""
                --- test Calendar(today) printOut 02(ver.b) ---
                【test02b】Calendar[SimpleDateFormat変換版] ～こうして 前のjavaプログラムから ゴソッと使えるのよ～
                """);


        // testCalendarOut02a.java から todayDate()メソッド を利用してみよう...
        testCalendarOut02a useOut02a = new testCalendarOut02a();    // インスタンス化
        String s_today02b = useOut02a.todayDate("test");

        echoOutB.echo("【再】SimpleDateFormantで yyyy/MM/dd と 表示指定： ");
        echoOutB.echo(s_today02b);

    }

}
