
package lesson.four;

/* テスト駆動開発で 2日の間の日数を返すメソッドgetDaysBetweenDates を 作成
getDaysBetweenDates(Date date1, Date date2)
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDaysCheQ {
    public static void main(String[] args) {

        // 確認(試し) Dateって取れてるかね？
        System.out.println("確認(試し)");
        Date testDate = new Date();
        System.out.println(testDate); // 表示:  曜日 月 日 時:分:秒 GMT+09:00 年

        // 確認(試し) Calendarで取れるかね？ Stringにしてな
        // https://www.sejuku.net/blog/19352?utm_source=blog&utm_medium=blog&utm_campaign=blog__20994
        Calendar testCal = Calendar.getInstance();
        String testStr = String.valueOf(testCal.getTime());
        System.out.println(testStr);  // testDateと同じ表示
        // わかったこと: testCal.getTime() は Date型 で、String型にしか 変換できないらしい？？
        //    直接 int にはできない。

        // ちなみに、Date型から そのままString型に変換するときは String.valueOfではなくて こう:
        //     Date date = new Date();
        //     String str = date.toString();
        // SimpleDateFormat経由だったら、
        //     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //     String strSdf = sdf.format(date);

        // 略  部分 取得(Year取れるかね？)
        // わかったこと: どうしても int型にしない場合、Date→String→Int の手順になる...
        int testIntYear = Integer.parseInt(String.valueOf(testCal.get(Calendar.YEAR)));
        System.out.println(testIntYear);

        // 略  yyyy/MM/dd形式に表示したい... StringDateFormatいきましょ、
        // ...まぁ、関数にせんと、 ここで。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try{
            System.out.println(sdf.format(testCal.getTime()));
        }catch (IllegalArgumentException e){  //引数が不正の例外クラス
            e.printStackTrace();
        }

        // 形式 変えまひょ, yyyy年mm月dd日
        // https://www.sejuku.net/blog/20994#index_id2
        sdf.applyPattern("yyyy年MM月dd日");  // E を加えたら = 曜日
        System.out.println(sdf.format(testCal.getTime()));


        // 日付 実在かどうかの確認 sdf.setLenient(boolean lenient);
        // あらかじめ falseを指定しておけば、日付設定時に日付の妥当性をチェックしてくれる
        // https://www.sejuku.net/blog/20994#index_id6
        sdf.setLenient(false);
        try{
            sdf.parse("2024年04月31日");
            System.out.println("実在してる日付です。");
        }
        catch(ParseException e){
            System.out.println("そんな日付ありませんよ。");
        }

    }

}

// 自分でも 何を読んでんだっけ ってなる エラーについての記事 :

// https://www.tohoho-web.com/java/exception.htm
// https://zenn.dev/airiin/articles/65264fddd581b2
// https://java-reference.com/exception-list/
// https://kanda-it-school-kensyu.com/java-basic-contents/jb_ch08/jb_0802/

/*
https://qiita.com/IRespectAkari/items/41052960d6f0cc55da91

Javaにおける例外の種類
============================
java.lang.Throwable
    --java.lang.Error
    --java.lang.Exception
        --java.lang.RuntimeException

エラー
------------
    java.lang.Errorを継承
    メモリ不足などプログラミングでどうしようもない物。主にハードウェアの面でどうにかする。

チェック例外
-------------
    java.lang.Exceptionを継承
    ただしjava.lang.RuntimeExceptionを継承しないもののみ

      java.lang.Exception
        --java.lang.RuntimeException// <--これ以外
        --java.lang.IOException

    コンパイラからtry-catch文などでハンドリングを強制される例外。IO処理などでよく見る。
    例外を自作するときは基本これを継承する。

非チェック例外
-------------
    java.lang.RuntimeExceptionを継承

      java.lang.RuntimeException
        --java.lang.NullPointerException
                        ：
        --java.lang.IndexOutOfException
            --java.lang.ArrayIndexOutOfException

    NullPointerExceptionなど実行時になって初めて発生する例外。
    ArrayIndexOutOfBoundsExceptionなどプログラミング時のミスで発生することが多い。

例外に関する用語
-------------------
例外ハンドリング
    発生した例外を補足して対処を書くことをいう。
（例外を）投げる
    生成した例外やキャッチ（捕捉）した例外を
    より上位のメソッド・オブジェクトに再びthrowすることを
    「throw」になぞらえて「例外を投げる・スローする」と言う。
（例外を）キャッチする
    例外をtry-catch文のcatchでキャッチ（捕捉）することを言う。
try-catch文
    発生した例外を捕捉してその対処を書くための構文
    例外が発生する可能性のあるメソッドをtry後の中カッコ内に書く。
    発生した例外の内どれを捕捉するかをcatch後の丸カッコ内に書く。
    例外への対処をcatch後の中カッコ内に書く。
    例外の発生の有無に限らず必ず行う処理をfinally後の中カッコ内に書く。
try-with-resource文
    簡単に言うとtry-catch文の進化版。
    IO処理などのtry-catch文で
    必要だったclose()やclose()が引き起こす可能性のある例外への対処を書かなくて済む。
throw
    例外をプログラマが自分で呼び出す時に使う。
    例えばメソッドの引数に間違いがあるときにそれを知らせる為に明示的に発生させる時がある。
    その時newを使って例外オブジェクトを生成しただけではどこにも通知されない。
    throwを用いることでメソッドの呼び出し元に通知する事ができる。
throws
    メソッドが発生しうる例外をメソッド呼び出し元に通知すると共にその例外への対処を強制する。
    throwsがあるメソッドを実行する時は必ずtry-catch文で囲む必要がある。
    囲んでいないとコンパイルエラーが発生して
    コンパイル自体出来なくなることによって例外への対処を忘れずに済む。

    例えばIO処理のメソッドであるFiles#readAllLines(Path)は
    IOExceptionが発生する可能性があり、
    その例外への対処を強制する為に 以下の様に書いてある。
    「 public class Files {
          public static List<String> readAllLines(Path path) throws IOException {
            // 処理
          }
       }
      」
 */
/*

https://qiita.com/shg3/items/f5d12ec1088d18ac7702

try-catch
    try{}
    catch(){}
finallyブロックを書くのが面倒だったら、最初のtryで()を書いたりする。(自動的にclose()させる)
    try(){}
    catch(){}

try-catch-finally
例外発生の如何に問わず必ず実行したい処理が設定できる。
開いたファイルを閉じる、データベースやネットワークの接続を閉じるなど、後片付けに。
    try{}
    catch(){}
    finally{}


throws宣言
メソッドで宣言するときに使用。
例外の送出にも使う。
呼び出し先の 関数では 処理(try{}catch()) をしない(設計)から、
呼び出し元の メインで 処理(try{}catch()) をしてくれー

例外の送出
throws 例外インスタンス
throws 例外インスタンス("エラー メッセージ")

オリジナルの例外クラスの定義
既存の例外クラスを継承してオリジナルの例外クラスを作れる。
作り方は一般的な継承方法と同様。

Exception.printStackTrace()
投げれらた例外のクラス名
コンストラクタで渡された 例外の説明
呼び出し元のメソッドとファイル名・行番号
 */
