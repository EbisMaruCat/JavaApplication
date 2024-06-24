
package lesson.four;

// === #include的なもの。使用クラス ===
import java.text.SimpleDateFormat;  // 日時フォーマットの変換と解析。ロケールを考慮して行うための「具象クラス」
import java.util.Calendar;

public class testCalendarOut02a {

     // --- 今更ながら main()メソッドの 名前は 必ず main 、　その()内には 必ず String[] args と。 ---
     public static void main(String [] args){

          /* ~~~ echoLN02.java の、 echoLN02()メソッドを呼び出して 利用する方法！ */
          echoLN02 echoOutA = new echoLN02();            // インスタンス化
          echoOutA.echo("test echoLN02");

          // 連結するテキストは このようにブロックに置き換え (「"""」で囲う、段落付と インデント作り に 注意)
          echoOutA.echo("""
                  --- test Calendar(today) printOut 02(ver.a) ---
                   【test02a】Calendarから SimpleDateFormat変換 版
                   「SimpleDateFormat()メソッドさん、Calendarの 年月日だけ頂戴」
                  """);

          echoOutA.echo("");   // 改行だけなら これでも使える(printLNだから)。 覚えられたらいいけど...


          echoOutA.echo("SimpleDateFormantで yyyy/MM/dd と 表示指定： ");

          // String型 変数名「s_today02」 で、 そのメソッドは このmain()メソッドの下にある。
          // 実際は この「test」という文字 は 出力されない。
          String s_today02a = todayDate("test");

          // ほほう！ここでの echoは通じる(まぁ中身がString型だから？)
          echoOutA.echo(s_today02a);

     }

     // --- SimpleDateFormatを行う 「todayDate()メソッド」 ---
     public static String todayDate(String input){

          // Calendar の インスタンス生成
          Calendar reGet = Calendar.getInstance();

          // SimpleDateFormat の 準備。()内には 書式を指定する。
          // 注意！ monthは mm ではなく MMとしてね！
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

          // 戻り値 = SimpleDateFormat型 の 特有メソッド "format()"。 ()内は Calendar型の 特有メソッド "getTime()"
          return sdf.format(reGet.getTime());
     }
}

/*  メモ
    SimpleDateFormat
*/