
package lesson.refactors;

public class Sample_Prac_Before {
    public static void main(String[] args) {

        //8時間超えを 残業とみなす

        // 長時間労働 確認。 この店員は 6時間　働いたという
        double overWorkingHours1 = EmployeePrac.calculateOverWorkingHours(6);

        // 上のメソッドで 実・労働時間 - 定・労働時間 = 残業時間が 算出されているはずだから 出力
        System.out.println(overWorkingHours1);


        // 店員オブジェクト(インスタンス)生成
        EmployeePrac e = new EmployeePrac();

        // その店員が 10時間労働した場合の 支払い給料
        System.out.println(e.getPayment(10));
    }
}


// 店員オブジェクト の 設計
class EmployeePrac {

    // 時給額 1000円/1時間
    int paymentPerHour = 1000;

    // 給料 実際 支払う額 = 実質労働時間 * 時給
    public double getPayment(int workingHours) {

        // まずは 残業代分
        // 時間超過分の 給料代 を 計算する ...
        double overWorkingHours = calculateOverWorkingHours(workingHours);
        // 残業代 = (時間分 * 時給額の1.5倍) 額
        double paymentForOverWorkingHours = this.paymentPerHour * 1.5 * overWorkingHours;

        // 次は 定・労働代
        // 定・労働時間 = 実質労働時間 - 残業時間
        double standardWorkingHours = workingHours - overWorkingHours;
        // 定・労働代 = (時間分 * 時給額どおり)
        double paymentForStandardWorkHours = this.paymentPerHour * standardWorkingHours;

        // 戻り値: 実質支払い額 = 残業代 + 定・労働代
        return paymentForOverWorkingHours + paymentForStandardWorkHours;
    }

    // 残業時間 算出メソッド( 引数: workingHours = 実質労働時間 のこと )
    public static double calculateOverWorkingHours(double workingHours) {

        // 定時間(8時間) 以内
        if(workingHours < 8) {
            return 0;
        }
        // 定時間(8時間) 実際超えている
        else {
            return workingHours - 8;   // 実質労働時間 - 定・労働時間 = 残業時間
        }
    }
}