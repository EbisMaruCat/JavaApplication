package lesson.four;

// どっちも 日付取得
import java.util.Date;      //
import java.util.Calendar;  // Dataオブジェクトの値を、 年月日・時間などの値に変換する「抽象クラス」

public class testCalendarToDate01 {
    public static void main(String[] args){

        // echoLN02.java の echo()メソッド の利用
        echoLN02 useEchoforCalDate = new echoLN02();

        useEchoforCalDate.echo(""" 
                 --- test Calendar(today) to Date ---
                 【test Calendar to Date】「Calendar型」から「Date型」に入れた 版
                 """);


        // なんかわかってきたけど、それぞれのクラスの main()メソッドから変数とかは使えんぞ。
        // だから もう一回 calendarのインスタンスを作ろう...

        Calendar todayCal = Calendar.getInstance();

        Date todayDate = todayCal.getTime();

        // useEchoforDate.echo(todayDate) は　使えないけど、string型を作ればできる：
        String s_date = String.valueOf(todayDate);
        useEchoforCalDate.echo(s_date);


        useEchoforCalDate.echo("""
                    
                    このとおりCalendar型もDate型も　同じ出力内容・表示内容だ...??
                    次のプログラムで Calendar型→Date型　の SimpleDateFormatにしてみようか
                    """);

    }

}
