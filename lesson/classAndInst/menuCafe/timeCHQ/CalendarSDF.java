
package lesson.classAndInst.menuCafe.timeCHQ;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class CalendarSDF {
    public static void main(String[] args){

        Calendar YMD = Calendar.getInstance();

        SimpleDateFormat sdfYDK = new SimpleDateFormat("yyyy年 M月 d日");
        SimpleDateFormat sdfHM = new SimpleDateFormat("HH:mm");

        String ymdNow,timeNow;
        ymdNow = sdfYDK.format(YMD.getTime());  // こっちのほうが 月+1の心配ないんだよなぁ...
        timeNow = sdfHM.format(YMD.getTime());


        // あかん：System.out.println(sdfYMD);  結果：java.text.SimpleDateFormat@406062f

        System.out.println(ymdNow + " " + timeNow);
    }

}