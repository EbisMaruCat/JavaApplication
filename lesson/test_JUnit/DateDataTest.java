
package lesson.test_JUnit;

/*  2024/05/06   05/15  05/22   remake:06/28
   ユニットテスト を 試す 課題 (1304-1 IDEを使ったユニットテスト)
   配布資料から そのまま 書き写せとのこと。
       ・DateData.java    ユニットテストする対象
       ・TestMain.java    人の手 で ユニットテスト作成したもの
       ・DateDataTest.java    IDEお任せ操作 で ユニットテスト作成したもの
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

// その後(07)で 追加された Calendarクラス


// @マーク以外の個所は 後から書き足したもの。
class DateDataTest {

    // その(01)
    // テスト対象クラス(DateData) の インスタンス用変数
    DateData dd;

    // その(02)
    // テスト対象クラス(DateData) の インスタンス生成
    DateDataTest(){
        dd = new DateData();
    }

    @BeforeEach  // テスト共通の前処理がないため、書込み無し
    void setUp() {
    }

    @AfterEach  //　これも テスト共通の前処理がないため、書込み無し
    void tearDown() {
    }

    @Test
    void setDateDate() {  // その(05) 書き込みあり
        dd.setDateDate(null);
        assertNull(dd.getDateData());

        // つまり、復帰値NULLであれば  テストOK ?
    }

    @Test
    void getDateData() {    // その(06) 書き込みあり
        dd.setDateDate("20200920");

        //  テストokとなる値と、テスト対象クラス(DateData)で設定されてる値
        assertEquals("20200920",dd.getDateData());

        // つまり、設定した値が取得できれば テストok。
    }

    @Test
    void getToday() {    // その(07) 書き込みあり
        Calendar calTest = Calendar.getInstance();
        String toDay = String.format("%02d",calTest.get(Calendar.YEAR))
                + String.format("%02d",calTest.get(Calendar.MONTH)+1)
                + String.format("%02d",calTest.get(Calendar.DAY_OF_MONTH));

        // テストokとなる値と、テスト対象クラス(DateData)で設定されてる値
        assertEquals(toDay,dd.getToday());

        // つまり、今日の年月日が取得できれば テストOK
    }

    @Test
    void isToday() {    // その(08)   書き込みあり
        assertEquals(true,dd.isToday(dd.getToday()) );
        // つまり、取得した「今日の年月日」が 今日 と 判定できれば テストOK
    }

    @Test
    void isLeapYear() {    // その(09)   書き込みあり
        // 検証サンプル 多いこと...

        // 変更前 :
        //        assertEquals(true, dd.isLeapYear("20200916"));
        //        assertEquals(false, dd.isLeapYear("20210916"));
        //        assertEquals(true, dd.isLeapYear("20000916"));
        //        assertEquals(true, dd.isLeapYear(2020));
        //        assertEquals(false, dd.isLeapYear(2021));
        //        assertEquals(true, dd.isLeapYear(20000));

        // 変更後 :
        assertTrue(dd.isLeapYear("20200916"));
        assertFalse(dd.isLeapYear("20210916"));
        assertTrue(dd.isLeapYear("20000916"));
        assertTrue(dd.isLeapYear(2020));
        assertFalse(dd.isLeapYear(2021));
        assertTrue(dd.isLeapYear(20000));

        // うるう年を 正しく判定できれば テストOK
    }

    @Test
    void testIsLeapYear() {   // ? DateDataクラスには ない ものだし、書き込みなし か？
    }
}

/*
どういうことなのか。
演習問題7のDateData.javaと TestMain.java を 作った後、
『JUnitでテストプログラムを作成する方法』を行い、DateDataTest.javaを生成。
さらに 細かい追記(コピペだけど) や 修正(DateData.javaも訂正対象)して
今件のテストプログラムを完成させていく ための 一連の実習。
 */