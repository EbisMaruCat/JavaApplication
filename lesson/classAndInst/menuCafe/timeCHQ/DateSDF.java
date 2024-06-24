package lesson.classAndInst.menuCafe.timeCHQ;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSDF {
    public static void main(String[] args){

        Date hmToday = new Date();

        System.out.println("Original: " + hmToday);
        //　出力結果: Fri May 31 17:55:42 GMT+09:00 2024

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd  HH:mm");

        String formatedDate = sdfDate.format(hmToday);

        System.out.println("Changed : " + formatedDate);
    }
}
