
package lesson.test_JUnit;

/*  2024/05/06   05/15  05/22   remake:06/28
   ユニットテスト を 試す 課題 (1304-1 IDEを使ったユニットテスト)
   配布資料から そのまま 書き写せとのこと。
       ・DateData.java    ユニットテストする対象
       ・TestMain.java    人の手 で ユニットテスト作成したもの
       ・DateDataTest.java    IDEお任せ操作 で ユニットテスト作成したもの
 */

import java.util.Calendar;   // 「今日の日付取得」で必要

/* 日付データクラス */
public class DateData {

    private String dateData = null;

    /* dateData setter */     // その(05)
    public void setDateDate(String yyyymmdd){
        dateData = yyyymmdd;
    }

    /* dateData getter */    // その(06)
    public String getDateData(){
        return dateData;    // String dateDataだから 戻り値と一致している
    }

    /* 今日の日付取得 */
    public String getToday(){
        Calendar cal = Calendar.getInstance();
        return String.format("%02d", cal.get(Calendar.YEAR))
                +
                // 変更前 : String.format("%02d",cal.get(Calendar.MONTH))
                // DateDataTest.javaの『その(07)』の解決方法！ 変更後 :
                String.format( "%02d", cal.get(Calendar.MONTH) + 1 )
                +
                String.format("%02d",cal.get(Calendar.DAY_OF_MONTH));
    }

    /* 今日か否かの判定 */
    public boolean isToday(String yyyymmdd){
        // 変更前 : yyyymmdd == ( getToday() )
        // DateDataTest.java の『その(08)』の解決方法！ 変更後 :
        if( yyyymmdd.equals(getToday()) ){
            return true;
        }
        return false;
    }

    /* うるう年の判定 String */
    public boolean isLeapYear(String yyyymmdd){
        return isLeapYear(Integer.parseInt(yyyymmdd.substring(0,4)));
    }

    /* うるう年の判定 int */   // これは オーバーロード? (Overload、重複 関数)
    public boolean isLeapYear(int year){
        if(year % 400 == 0){
            return true;
        } else if (year % 100 == 0) {
            return false;
        }else
            return year % 4 == 0;
    }
}
