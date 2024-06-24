package samples;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFour_chatGPTver {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("引数の数が正しくありません。第1引数には日付(形式:YYYY/MM/DD)、第2引数には日数を指定してください。");
            System.exit(1);
        }

        String dateStr = args[0];
        String daysStr = args[1];

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse(dateStr);
            int days = Integer.parseInt(daysStr);
            long ms = date.getTime() + (days * 24L * 60 * 60 * 1000);
            Date newDate = new Date(ms);

            System.out.println(dateStr + " " + daysStr + " " + sdf.format(newDate));

        } catch (Exception e) {
            System.out.println("日付または日数の形式が正しくありません。日付はYYYY/MM/DDの形式で入力してください。日数は整数値で指定してください。");
        }
    }

}

/*
====python====
import sys
import datetime

if len(sys.argv) != 3:
    print("引数の数が正しくありません。第1引数には日付(形式:YYYY/MM/DD)、第2引数には日数を指定してください。")
    sys.exit(1)

date_str = sys.argv[1]
days_str = sys.argv[2]

try:
    date = datetime.datetime.strptime(date_str, "%Y/%m/%d")
    days = int(days_str)
    new_date = date + datetime.timedelta(days=days)
    print(date_str, days_str, new_date.strftime("%Y/%m/%d"))
except ValueError:
    print("日付または日数の形式が正しくありません。日付はYYYY/MM/DDの形式で入力してください。日数は整数値で指定してください。")
 */