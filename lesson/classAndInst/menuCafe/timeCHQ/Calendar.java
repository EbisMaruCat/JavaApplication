package lesson.classAndInst.menuCafe.timeCHQ;

class Calendar {
    public static void main(String[] args){

        // Calendarクラスは「抽象クラス」なので、インスタンス化はできない。これ無理：　Calendar YMD = new Calendar();
        java.util.Calendar YMDp = java.util.Calendar.getInstance();

        // 無理 : String ymdOut = YMD.getTime()
        // この出力は とんでもないからNO: System.out.println(YMD);
        // これは 以前の出力: System.out.println(YMD.getTime());  結果：Fri May 31 17:14:59 GMT+09:00 2024

        int thisYEAR = YMDp.get(java.util.Calendar.YEAR);
        int thisMONTH = (YMDp.get(java.util.Calendar.MONTH)) + 1 ;    // 【!!】
        int thisDAY = YMDp.get(java.util.Calendar.DAY_OF_MONTH);

        int today_HOUR = YMDp.get(java.util.Calendar.HOUR_OF_DAY);     // 24時間:HOUR_OF_DAY  12時間:HOUR
        int today_MINUTE = YMDp.get(java.util.Calendar.MINUTE);

        System.out.println(
                thisYEAR + "年 " + thisMONTH + "月 " + thisDAY + "日  "
                + today_HOUR + "時 " + today_MINUTE + "分 ");

    }
}

/* memo
class OrderTime {
    public static void main(String[] args){

    // Calendarクラスは「抽象クラス」なので、インスタンス化はできない。これ無理：　Calendar YMD = new Calendar();
    Calendar YMD = Calendar.getInstance();

    // 無理：String ymdOut = YMD.getTime();

    System.out.println(YMD);


    System.out.println(YMD.getTime());
    }
}



出力結果 それぞれ.... :

System.out.println(YMD);
------------------------------------------
java.util.GregorianCalendar[
	time=1717143011522,
	areFieldsSet=true,
	areAllFieldsSet=true,
	lenient=true,
	zone=sun.util.calendar.ZoneInfo
		[id="GMT+09:00",
		offset=32400000,
		dstSavings=0,
		useDaylight=false,
		transitions=0,
		lastRule=null
		],
	firstDayOfWeek=1,
	minimalDaysInFirstWeek=1,
	ERA=1,
	YEAR=2024,
	MONTH=4,
	WEEK_OF_YEAR=22,
	WEEK_OF_MONTH=5,
	DAY_OF_MONTH=31,
	DAY_OF_YEAR=152,
	DAY_OF_WEEK=6,
	DAY_OF_WEEK_IN_MONTH=5,
	AM_PM=1,
	HOUR=5,
	HOUR_OF_DAY=17,
	MINUTE=10,
	SECOND=11,
	MILLISECOND=522,
	ZONE_OFFSET=32400000,
	DST_OFFSET=0
	]


System.out.println(YMD.getTime());
--------------------------------------
Fri May 31 17:14:59 GMT+09:00 2024

*/