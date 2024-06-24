
package lesson.refactors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sample_Prac_After {

    public static Scanner howManyHours = new Scanner(System.in);

    public static void main(String[] args){

        employeePracA e_taro = new employeePracA();

        System.out.print("お疲れ様です、\n" +
                " 昨日は 何時間働きましたか? : ");

        double iWorked = scanHours();

        System.out.println( " *** 給料の 支払い額は こちらになります *** : "
                + e_taro.actualPayment(iWorked) );
    }


    // 別クラスにしたら またちょっとややこいぞ...
    // 独立したもの(メソッド)にするなら くれぐれも、 main()には いれないで
    private static int scanHours(){
        try{
            return howManyHours.nextInt();
        }catch (InputMismatchException e){
            System.out.println(" 数字 を入れてください(>x<); ");
            System.out.print("もう一度：何時間 働きましたか？ : ");
            howManyHours.next();    // ここは nextInt()ではない。
        }
        return scanHours();      // 再帰法。
    }

}


class employeePracA{

    public static double STANDARD_HOURS = 8;
    public static int WAGE_PER_HOUR = 1000;

    // double(高)から int(低)には castできねぇぞ
    public static double WAGE_OVER_HOUR = WAGE_PER_HOUR * 1.5;


    //時間計算
    double chqOverHours(double workingHours){
        if(workingHours < STANDARD_HOURS){
            return 0;
        }else{
            return workingHours - STANDARD_HOURS;
        }
    }

    // 実質 給料支払い額 計算
    double actualPayment(double workingHours){

        double overWorkHours = chqOverHours(workingHours);
        double paymentOverWorkH = overWorkHours * WAGE_OVER_HOUR;

        double standardWorkHour = workingHours - overWorkHours;
        double paymentStandardH = standardWorkHour * WAGE_PER_HOUR;

        return paymentStandardH + paymentOverWorkH;
    }

}
