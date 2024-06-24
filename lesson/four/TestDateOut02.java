
// 前作 TestDateOut01 のやり直し
package lesson.four;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class TestDateOut02 {
    public static void main(String[] args){

        // オブジェクト生成
        Date dateInfo = new Date();
        System.out.println("まずは Date dateInfo = new Date();");

        System.out.println("-");

        // 結果:ミリ秒
        System.out.println("経過ミリ秒  dateInfo.getTime() : " + dateInfo.getTime());
        // 結果 : デフォルトコンストラクタ を使った 表示内容。 こっちのほうが馴染みあるわな。
        System.out.println("デフォルトコンストラクタ dateInfo : " + dateInfo);

        System.out.println("-");

        // SimpleDateFormatクラス で 書式設定を行う format()メソッド
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("書式設定 sdf.format(dateInfo) : " + sdf.format(dateInfo) );


        System.out.println("-");

        // Dateから 文字列に変換(ver01)  文字列に dateInfo.toString()と代入
        String strDateSDF = dateInfo.toString();
        System.out.println("String strDateSDF = dateInfo.toString(); : " + strDateSDF);

        // Dateから 文字列に変換(ver02) 文字列に sdf.format(dateInfo)を直接代入
        strDateSDF = sdf.format(dateInfo);
        System.out.println("String strDateSDF = sdf.format(dateInfo); : " + strDateSDF);

        System.out.println("-");

        // SimpleDateFormatクラス で 文字列から Dateが作れる parse()メソッド
        // ただし、 書式設定したように"yyyy/MM/dd HH:mm:ss" 形式 に合わせなければならない
        // さらに、try-catch文 で 例外処理ParseException が いる
        String str = "2024/01/01";
        System.out.println( "String str の中身 : " + str);
        try{
            dateInfo = sdf.parse(str);
            System.out.println("で、dateInfo = sdf.parse(str) したら : " + dateInfo);
        }
        // クラスParseException : 解析中に予想外のエラーが発生したことを表すシグナル。 変数名errorとする。
        catch (ParseException error){
            error.printStackTrace();  // Throwableクラスの「メソッド:printStackTrace」でスタックトレース(例外処理)を出力
        }


        System.out.println("-");

        // Calendar.getTime()で、 Calendarが持つ日時(getTimeしてるからこれは現在時刻) から Dateを 作る
        Calendar cal = Calendar.getInstance();  //getInstance()でオブジェクト生成
        dateInfo = cal.getTime();
        System.out.println("Calendar cal の 内容 : " + cal);
        System.out.println("dateInfo = cal.getTime() だと : " + dateInfo);


        System.out.println("-");

        // Calendar.setTime()で、Dateから Calendarを 作る
        dateInfo.getTime();       // もう一回 dateInfo.getTimeしてるのは、まぁ、初期化みたいなもん...だ。
        cal.setTime(dateInfo);
        System.out.println("cal.setTime(dateInfo);して、cal : " + cal );

        System.out.println("-");

        // https://qiita.com/ayaka105/items/1a68ed7ad84743dde7d5
        // Calendar で それぞれ setで 設定して getTime() を Dateに代入する....
        // !?? getTimeって現在時刻ちゃうの？？
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024); //年を設定
        calendar.set(Calendar.MONTH, 0); //月を設定(※MONTHは0始まり 0→Jan、1→Feb、...になる)
        calendar.set(Calendar.DAY_OF_MONTH, 1);//日を設定

        Date date = calendar.getTime();
        System.out.println("Date date = calendar.getTime(); : " + date);

        // おまけ
        String strDateSDFc = sdf.format(date);
        System.out.println("String strDateSDFc = sdf.format(date); : " + strDateSDFc);


        // 疲れた...　

    }
}

/* getTime() と setTime() の違い
https://qiita.com/icelandnono/items/073e57fdf74e6531731f

getTime()
1970年1月1日午前0時からの経過時間をミリ秒で返し
------------------------------------------
・CalendarクラスでのgetTime()
    現在の日時を返します
・DateクラスでのgetTime()
    1970年1月1日0時0分0秒らかの経過時間をミリ秒単位の値で取得し、
    処理開始直前と直後に経過時間を調べることによって、処理にかかった時間が得られる。


setTime(変数)
Dateオブジェクトに、
引数で指定された1970年1月1日午前0時からの経過時間(ミリ秒)の日時を指定
-----------------------------------------
・Date型の値をCalendar型に変換
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
dateに何か値が入っている場合は上記のようにCalendar型の変数を用意し、
そこにsetTimeでdateの値を代入しcalendar型への変換をすることが出来る。
 */

/* About "Date"
プログラム参考 : https://www.bold.ne.jp/engineer-club/java-date#-Date-6
そのまま掲載 : https://docs.oracle.com/javase/jp/8/docs/api/java/sql/Date.html

メソッド
------------------------------
・ Instant toInstant() このメソッドは使わないでください。
・ int getHours() 非推奨。Deprecated。Calendar使ってください
・ int getMinutes() 非推奨。
・ int getSeconds() 非推奨。
・ void setHours(int i) 非推奨。
・ void setMinutes(int i) 非推奨。
・ void setSeconds(int i) 非推奨。

・ void setTime(long date)
指定されたミリ秒の値を使って、既存のDateオブジェクトを設定
    オーバーライド : setTime、クラス:Date
    パラメータ:
        date - 1970年1月1日、
               0時0分0秒GMT (グリニッジ標準時)を起点とした時間をミリ秒で表した値で、
               8099年のミリ秒表現を超えない値。
               負の値は、1970年1月1日、0時0分0秒GMT (グリニッジ標準時)より前のミリ秒を示す。

・ LocalDate toLocaleDate()
このDateオブジェクトをLocalDateに変換。
この変換によって、ローカル・タイムゾーンでこのDateと同じ日付値を表すLocalDateが作成されます
    戻り値 : 同じ日付値を表すLocalDateオブジェクト

・ String toString()
日付エスケープ形式yyyy-mm-ddに整形
    オーバーライド : toString、クラス:Date
    戻り値 : yyyy-mm-dd形式の文字列
    関連項目 : Date.toLocaleString(), Date.toGMTString()

・ static Date valueOf(LocalDate date)
指定されたLocalDate と 同じ年、月、および月間通算日 の 値を持つ Dateのインスタンスを LocalDateオブジェクトから取得。
指定されたLocalDateは、ローカル・タイムゾーンのローカル日付として解釈されます。
    パラメータ : date - 変換するLocalDate
    戻り値 : Dateオブジェクト
    例外 : NullPointerException - dateがnullの場合

・ static Date valueOf(String s)
JDBC日付エスケープ形式の文字列をDate値に変換。
    パラメータ : s - 形式「yyyy-[m]m-[d]d」で日付を表すStringオブジェクト。mmとddの先頭のゼロは省略できます。
    戻り値 : 指定された日付を表すjava.sql.Dateオブジェクト
    例外 : IllegalArgumentException - 指定された日付がJDBC日付エスケープ形式(yyyy-[m]m-[d]d)ではない場合

コンストラクタ
------------------------
・public Date(int year,int month,int day)  非推奨。Deprecated

・public Date(long date)
指定されたミリ秒の値を使ってDateオブジェクトを構築。
    指定されたミリ秒の値に時間の情報が含まれている場合、
    ドライバは時間コンポーネントを デフォルトのタイムゾーン
    (アプリケーションを実行しているJava仮想マシンのタイムゾーン) の時間に設定します。
    この時間はゼロGMT (グリニッジ標準時)に対応します。
    パラメータ : date - 1970年1月1日、
        0時0分0秒GMT (グリニッジ標準時)を起点とした時間をミリ秒で表した値で、
        8099年のミリ秒表現を超えない値。
        負の値は、1970年1月1日、0時0分0秒GMT (グリニッジ標準時)より前のミリ秒を示す。


クラス java.util.Dateから継承されたメソッド
-----------------------------------------
after, before, clone, compareTo, equals, from,
getDate, getDay, getMonth, getTime, getTimezoneOffset, getYear,
hashCode, parse,
setDate, setMonth, setYear,
toGMTString, toLocaleString, UTC


クラス java.lang.Objectから継承されたメソッド
------------------------------------------------
finalize, getClass, notify, notifyAll, wait, wait, wait

 */

/* About SimpleDateFormat
https://docs.oracle.com/javase/jp/7/api/java/text/SimpleDateFormat.html
https://qiita.com/takahirocook/items/aa857c8f2153193095e4

Simple Date Format
文字   日付/時刻のcomponent    表示             例
G     紀元                   Text            AD

y     年                     年              1996;96
Y     暦週の基準年             年              2009;09
M     月                     月              July; Jul; 07

w     年における週             Number          27
W     月における週             Number          2

D     年における日             Number          189
d     月における日             Number          10

F     月における曜日           Number           2
E     曜日の名前               Text            Tuesday;Tue
u     曜日の番号(1=Mon,7=Sun)  Number          1

a     午前/午後                Text           PM
H     一日における時(0~23)      Number          0
k     一日における時(1~24)      Number          24
K     午前/午後の時(0~11)       Number          0
h     午前/午後の時(1~12)       Number         12

m     分                      Number         30
s     秒                      Number         55
S     ミリ秒                   Number         978

z     タイムゾーン          一般的なタイムゾーン   Pacific Standard Time; PST; GMT-08:00
Z     タイムゾーン          RFC822タイムゾーン   -0800
X     タイムゾーン          ISO8601タイムゾーン  -08; -0800; -08:00

 */