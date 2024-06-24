
// 後になって気づいたけど、getMonth()とか getDateはもうあかんねんな.... ;;
package lesson.four;

import java.util.Date;

public class testDateOut {
    public static void main(String[] args){
        echoLN02 useEchoforDate = new echoLN02();
        useEchoforDate.echo("test echoLN02");

        useEchoforDate.echo("--- test  Date --- ");
        useEchoforDate.echo("【test Date】CalendarOut01a の「Date型」版だけど 出力内容が違う & 応用 ");
        useEchoforDate.echo("");

        // Date型 インスタンス生成して 直接出力
        // Date型の 特有メソッド "getTime()"  データの種類は longらしいんだが？
        Date toDateB = new Date();
        useEchoforDate.echo("直接 Date型の getTime()メソッドを 出力");
        System.out.println(toDateB.getTime());
        useEchoforDate.echo("(Date型のgetTime()は 1970/1/1 00:00から今日まで、経過した時間数)");

        useEchoforDate.echo("");

        // getTime()メソッドの内容を long型 → String型 にしてみた
        long l_dateB = toDateB.getTime();
        String s_dateB0 = String.valueOf(l_dateB);
        useEchoforDate.echo("Date型のgetTime()を long型--→String型と 変換して 出力");
        useEchoforDate.echo(s_dateB0);
        useEchoforDate.echo("(まぁ 数値を 文字列にしただけだから 内容変わってない。)");

        useEchoforDate.echo("");

        // Date型の 特有メソッド "getDate()"  データの種類は int だ？
        // その内容を int型 → String型 にしてみた
        int i_dateB_gDate = toDateB.getDate();
        String s_dateB1 = String.valueOf(i_dateB_gDate);
        useEchoforDate.echo("Date型のgetDate()を int型--→String型と 変換して 出力");
        useEchoforDate.echo(s_dateB1);
        useEchoforDate.echo("(Date型のgetDate()は つまり 今日の日付。何日)");

        useEchoforDate.echo("");

        // Date型の 特有メソッド "getMonth()"
        // その内容を int型 → String型 にしてみた。 ...変数の名前 変え忘れるなよーーー！
        int i_dateB_gMonth = toDateB.getMonth();
        String s_dateB2 = String.valueOf(i_dateB_gMonth);
        useEchoforDate.echo("Date型のgetMonth()を  int型--→String型と 変換して 出力");
        useEchoforDate.echo(s_dateB2 + "(...あれぇ？？)");

        useEchoforDate.echo("");

        useEchoforDate.echo("やりなおし！");
        String s_dateB2a = String.valueOf(i_dateB_gMonth);
        useEchoforDate.echo("Date型のgetMonth()を  int型 --→ String型に +1 して 出力");
        useEchoforDate.echo(s_dateB2a + 1 + "(...あっ Σ(. .;) )");

        useEchoforDate.echo("\n ...もう一回 やりなおし！");    // めんどくさいので 改行は こっちで "\n"入れたった
        String s_dateB2b = String.valueOf(i_dateB_gMonth + 1);
        useEchoforDate.echo("Date型のgetMonth()を  (int型 + 1) --→ String型 で 出力");
        useEchoforDate.echo(s_dateB2b + "(ok！)");



        // Dateが持つのは 1970/01/01 00:00:00(GMT)からの経過ミリ秒(エポック(epoch)ミリ秒)
        // 24L * 60 * 60 * 1000 == 1日分の経過ミリ秒(86400000ms)
        // min=1000ミリ秒*60秒,  hour=min*60分,  day=hour*24時間
        // Date d = new Date(24 * 60 * 60 * 1000);
        // 計算式の説明。今度 時間かけて読め: https://www.bold.ne.jp/engineer-club/java-date

    }
}
