
package samples;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestFour_chatGPTver2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\s");

        while (true) {
            System.out.println("日付と日数を入力してください (形式: YYYY/MM/DD 日数):");

            if (scanner.hasNext()) {
                String dateStr = scanner.next();

                if (scanner.hasNextInt()) {
                    int days = scanner.nextInt();

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                        Date date = sdf.parse(dateStr);
                        // date使ってるから このような計算式に...
                        long ms = date.getTime() + (days * 24L * 60 * 60 * 1000); // 24hours 60min 60sec
                        Date newDate = new Date(ms);

                        System.out.println("指定日時: " + dateStr
                                + " 日数: " + days
                                + " 演算結果: " + sdf.format(newDate));
                        break;

                    } catch (Exception e) {
                        System.out.println("エラー: 日付または日数の形式が正しくありません。再度入力してください。");
                        scanner.nextLine(); // 不正な入力をクリア
                    }

                } else {
                    System.out.println("エラー: 日数が不足しています。再度入力してください。");
                    scanner.nextLine(); // 不正な入力をクリア
                }

            } else {
                System.out.println("エラー: 日付が不足しています。再度入力してください。");
                scanner.nextLine(); // 不正な入力をクリア
            }
        }

        scanner.close();
    }
}
