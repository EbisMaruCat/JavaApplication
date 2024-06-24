package samples;
import java.util.Scanner;

public class TestScanner_withTwo_tryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\s");
        int num1 = 0;
        int num2 = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("整数を二つ入力してください:");

            if (scanner.hasNextInt()) {
                num1 = scanner.nextInt();

                if (scanner.hasNextInt()) {
                    num2 = scanner.nextInt();
                    validInput = true;

                } else {
                    System.out.println("エラー: 二つ目の整数が不足しています。再度入力してください。");
                    scanner.next(); // 不正な入力をクリア
                }
            } else {
                System.out.println("エラー: 一つ目の整数が不足しています。再度入力してください。");
                scanner.next(); // 不正な入力をクリア
            }
        }

        int sum = num1 + num2;

        System.out.println("加算結果: " + sum);

        scanner.close();
    }

}

