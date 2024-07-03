
package lesson.test_JUnit;

/*  2024/05/06   05/15  05/22   remake:06/28
   ユニットテスト を 試す 課題 (1304-1 IDEを使ったユニットテスト)
   配布資料から そのまま 書き写せとのこと。
       ・DateData.java    ユニットテストする対象
       ・TestMain.java    人の手 で ユニットテスト作成したもの
       ・DateDataTest.java    IDEお任せ操作 で ユニットテスト作成したもの
 */

/* 配布資料から ただのコピペ...
 */

public class TestMain {

    public static void main(String[] args){

        DateData dd;          //クラスDateData の インスタンス生成
        dd = new DateData();

        dd.setDateDate("20200920");   // 設定

        // 解説 01
        if (dd.isToday(dd.getDateData())){
            System.out.printf("%s は今日です。\n",dd.getDateData());
        } else {
            System.out.printf("%s は 今日ではありません。\n",dd.getDateData());
        }

        // 解説 02
        if (dd.isLeapYear(dd.getDateData())) {
            System.out.printf("%s はうるう年です \n", dd.getDateData());
        } else {
            System.out.printf("%s はうるう年ではありません \n", dd.getDateData());
        }

        System.out.printf("今日は%sです\n", dd.getToday());
    }
}

/*

解説 01
---------
【TestMain.java】 該当箇所
        if (dd.isToday(dd.getDateData())){
            System.out.printf("%s は今日です。\n",dd.getDateData());
        } else {
            System.out.printf("%s は 今日ではありません。\n",dd.getDateData());
        }

この、 dd.isToday( dd.getDateData() )
    ・ dd.getDateData() ==  dd.setDateDate("20200920")
            つまり 日付が あらかじめ 設定している 20200920
    ・ dd.isToday() == boolean質問している。
        関数では:
            boolean isToday(String yyyymmdd){
                if(yyyymmdd == ( getToday() )){
                    return true;
                } ...
        ということで。まず dd.getToday()を算出する...
            dd.getToday() == Calendar.getInstance()して cal.get()が行われた。
            ...つまり、 このプログラムを実行した日付 ということになる。

    で、 だから、ここのプログラムは
        yyyymmdd(==20200920のこと) は getToday(==実行日の日付) と 一致してますか？

    と、問いている意味。

【DateData.java】の ここが 係る
        public void setDateDate(String yyyymmdd){
            dateData = yyyymmdd;
        }
        public String getDateData(){
            return dateData;    // String dateDataだから 戻り値と一致している
        }

        public String getToday(){
            Calendar cal = Calendar.getInstance();
            return String.format("%02d", cal.get(Calendar.YEAR))
                +
                String.format("%02d",cal.get(Calendar.MONTH))
                +
                String.format("%02d",cal.get(Calendar.DAY_OF_MONTH));
        }

        public boolean isToday(String yyyymmdd){
            if(yyyymmdd == ( getToday() )){
                return true;
            }
            return false;
        }

------------------------------------------------------------------------


解説 02
-----------------
これは。さっきの続きから考えると。
その 20200920が うるう年かどうか を 聞いてるわけで。


【DateData.java】の ここが 係る
        public void setDateDate(String yyyymmdd){
            dateData = yyyymmdd;
        }
        public String getDateData(){
            return dateData;    // String dateDataだから 戻り値と一致している
        }

        public String getToday(){
            Calendar cal = Calendar.getInstance();
            return String.format("%02d", cal.get(Calendar.YEAR))
                ...
                (省略)
                ...
        }

        if (dd.isLeapYear(dd.getDateData())) {
            System.out.printf("%s はうるう年です \n", dd.getDateData());
        } else {
            System.out.printf("%s はうるう年ではありません \n", dd.getDateData());
        }
 */