package lesson.four;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class testCalendarToDate02 {
    public static void main(String[] args){

        echoLN02 echoForDateSDF = new echoLN02();

        echoForDateSDF.echo("""
                 --- test Calendar(today) to Date & SimpleDateFormat ---
                 【test Calendar to Date】前回のsimpleDateFormat 版
                 「SimpleDateFormat()メソッドさん、Dateの 年月日も お願いします」
                 """);

        String outDateSDF = todayDate_sdfC("2024/01/01"); // SimpleDateFormatに合わせる内容であること。

        echoForDateSDF.echo(outDateSDF);

    }

    public static String todayDate_sdfC(String abcd){
        Calendar reGetCD = Calendar.getInstance();
        SimpleDateFormat sdfD = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date d_calSDF = sdfD.parse(abcd);
            reGetCD.setTime(d_calSDF);
        }catch (ParseException errorD){
            errorD.printStackTrace();
        }
        return  sdfD.format(reGetCD.getTime());
    }
}
