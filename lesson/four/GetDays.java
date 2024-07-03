
package lesson.four;

/*
本題のふたつ。 date1とdate2の日数差分を 出す...
           example:) date1=5/14 , date2=5/18。  date1,date2 == 4 days
                       (. .  ;) ...?
           ① 「Date abc = new Date();」 で取ってやるのか、scannerでするのか?
           ② 差分をとるには Stringからintに変換する必要があるのでは？
        Date date1_A = validateAndParseDate("test");
        Date date1_B = validateAndParseDate();
        ?
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDays {
    // public static void main(String[] args){
    // }


    static Date validateAndParseDate(String inputDate) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        //try{
        return sdf.parse(inputDate);
        //}
        //catch(ParseException e){
        //    System.out.println("そんな日付ありませんよ。");
        //}

        // throws ParseException == try-catch省略か？

    }


    static int getDaysBetweenDates(Date date1, Date date2){
        // long huh = 0;
        int huh = 0;

        //  Date1+numbers equals Date2 ?
        // long addDay = date1.getTime() + (huh  * 24L * 60 * 60 * 1000);
        // あかん、 だってsdfされてるやんけ、もはや long型じゃなくね？

        // sdfされたDate型を Calendar型変換 + cal.add??
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        // cal.add(Calendar.DAY_OF_MONTH, ??? ); == date2に いざなう
        // getDaysBetweenDate(Date date1,Date date2)と、引数は 限定されテール
        // ...how do I add days???

        // while(!(cal.add(Calendar.DAY_OF_MONTH,(int)huh)).equals(date2))
        //  エラー。 date1はcalendar型 で date2がdate型のまま で 比較出来無んだ...

        // ...ohh. AddDays_proto.java ??
        while(!(addDay(date1,huh)).equals(date2)){
            huh += 1;
        }

        return huh;
    }
    // https://www.sejuku.net/blog/21395

    // from SampleAnswers
    // AddDay_proto.java ...... String → Date ?
    static Date addDay(Date date1,int number){
        Calendar calBefore = Calendar.getInstance();
        calBefore.setTime(date1);

        calBefore.add(Calendar.DAY_OF_MONTH,number);
        return calBefore.getTime();
    }
}


// SimpleDateFormat...ここで もう一回確認。CheQには 別のメモを入れているからね
/*
https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html#SimpleDateFormat-java.lang.String-
https://docs.oracle.com/javase/jp/8/docs/api/java/text/SimpleDateFormat.html

・void applyLocalizedPattern(String pattern)
    指定されたローカライズされたパターン文字列を、この日付フォーマットに適用

・void applyPattern(String pattern)
    指定されたパターン文字列を、この日付フォーマットに適用

・Object clone()
    このSimpleDateFormatのコピーを作成

・boolean equals(Object obj)
    指定されたオブジェクトとこのSimpleDateFormatが等しいかどうかを比較

・StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos)
    指定されたDateを日付/時間文字列にフォーマットし、指定されたStringBufferに結果を付加。

・AttributedCharacterIterator formatToCharacterIterator(Object obj)
    Objectをフォーマットし、AttributedCharacterIteratorを生成。

・Date get2DigitYearStart()
    2桁年が属すると解釈される100年間の開始日付を返します。

・DateFormatSymbols getDateFormatSymbols()
    この日付フォーマットの、日付と時刻のフォーマット記号のコピーを取得。

・int hashCode()
    このSimpleDateFormatオブジェクトのハッシュ・コード値を返します。

・Date parse(String text, ParsePosition pos)
    文字列からテキストを解析してDateを生成。

・void set2DigitYearStart(Date startDate)
    2桁年が属すると解釈される100年間をユーザーが指定する日付から始まるように設定。

・void setDateFormatSymbols(DateFormatSymbols newFormatSymbols)
    この日付フォーマットの、日付と時刻のフォーマット記号を設定。

・String toLocalizedPattern()
    この日付フォーマットのローカライズされたパターン文字列を返します。

・String toPattern()
    この日付フォーマットを記述するパターン文字列を返します。
 */
/*
main()の時 : これかな？
    StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos)
        指定されたDateを日付/時間文字列にフォーマットし、指定されたStringBufferに結果を付加

Calendar testCal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try{
            System.out.println(sdf.format(testCal.getTime()));
        }catch (IllegalArgumentException e){  //引数が不正の例外クラス
            e.printStackTrace();
        }

どこかのプログラムの 関数型の時 : 明らかにこれか？
     Date parse(String text, ParsePosition pos)
         文字列からテキストを解析してDateを生成

public static String todayDate_sdfC(String abc){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date = sdfD.parse(abc);
            cal.setTime(date);
        }catch (ParseException errorD){
            errorD.printStackTrace();
        }
        return  sdfD.format(reGetCD.getTime());
    }
 */