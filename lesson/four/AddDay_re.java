
/*  2024/04/22    remake:2024/06/22
    演習4  (1306_Java問題(課題) 問5より)

    日付演算をする(第1引数：日付 第2引数：日数)
    引数で指定した日付に日数(!)を加算し、結果を標準出力するプログラムを作成してください。

    第1引数 : 日付 (形式:YYYY/MM/DD)
    第2引数 : 日数

    出力形式 : 指定日時 日数 演算結果

   【!】演算結果の形式は 指定日付に同じ
   【!】指定日時や 日数が 不正の場合は エラーメッセージ表示を行う
*/

package lesson.four;


import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;
// import java.util.Calendar;

public class AddDay_re {

    public static void main(String[] args){

        System.out.print("日付(形式は yyyy/MM/dd と)、加算したい日数を 入力してください : ");

        Scanner sortScan = new Scanner(System.in);
        sortScan.useDelimiter("\\s");  // 空白

        if(sortScan.hasNext()){
            String dateStr = sortScan.next();

            if(sortScan.hasNextInt()){
                int daysInt = sortScan.nextInt();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                // Calendar cal_Input = Calendar.getInstance();

                try{
                    Date date_Info = sdf.parse(dateStr);

                    // cal_Input.setTime(date_Info);では エラー ばっかりぜよ
                    // 計算式の説明。今度 時間かけて読め: https://www.bold.ne.jp/engineer-club/java-date

                    // Dateが持つのは 1970/01/01 00:00:00(GMT)からの経過ミリ秒(エポック(epoch)ミリ秒)
                    // 24L * 60 * 60 * 1000 == 1日分の経過ミリ秒(86400000ms)
                    // min=1000ミリ秒*60秒,  hour=min*60分,  day=hour*24時間,  dayInt(何日分) * day(一日分の経過ミリ秒)
                    // L = long型用に。 これがfloat型だったら Fつける。
                    long dateEdited = date_Info.getTime() + (daysInt * 24L * 60 * 60 * 1000);

                    //cal_Input.add(Calendar.DAY_OF_MONTH,daysInt);  nope.unaffordable

                    System.out.println(dateStr
                            + " " + daysInt
                            + " " + sdf.format(dateEdited) );  // 不思議ねんな。formatが あのミリ秒dateEdited を 自動的に計算してくれるらしい。

                }catch (Exception error){
                    System.out.println("=== Error ===");
                    System.out.println("日付または日数の形式が正しくありません。");
                    sortScan.nextLine();   // 不正な入力をクリア
                }

            }
            else{
                System.out.println("=== Error ===");
                System.out.println("日数は 整数を入れてください。");
                sortScan.nextLine();
            }

        }
        else{
            System.out.println("=== Error ===");
            System.out.println("日付 を入れてください。");
            sortScan.nextLine();
        }

        sortScan.close();
    }


}

// https://docs.oracle.com/javase/jp/7/api/java/util/Scanner.html
// Special Thanks to : chatGPT