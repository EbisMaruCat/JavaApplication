// マジック・ナンバーの削除
package lesson.refactors;

public class Sample_3_After {
    public static void main(String[] args){

        double overWorkHoursB = EmployeeB.calcOverWorkHours(6);
        System.out.println(overWorkHoursB);
    }
}

class EmployeeB {

    // これはつまりあれじゃない？ c言語の 「#define WORK_HOURS 8」 的な?
    public static int STANDARD_HOUR = 8;

    public static double calcOverWorkHours(double wHour) {
        if (wHour < STANDARD_HOUR)
            return 0;
        else
            return wHour - STANDARD_HOUR;
    }
}