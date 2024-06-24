package samples;

import java.util.Scanner;

public class TestScanner_withTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("整数を二つ入力してください:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        System.out.println("加算結果: " + sum);

        scanner.close();
    }
}
