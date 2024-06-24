
// https://ja.stackoverflow.com/questions/88076/%E4%BE%8B%E5%A4%96%E3%81%8C%E8%B5%B7%E3%81%8D%E3%81%9F%E5%A0%B4%E5%90%88-%E4%BE%8B%E5%A4%96%E3%81%8C%E8%B5%B7%E3%81%8D%E3%81%AA%E3%81%8F%E3%81%AA%E3%82%8B%E3%81%BE%E3%81%A7%E5%87%A6%E7%90%86%E3%82%92%E7%B9%B0%E3%82%8A%E8%BF%94%E3%81%97%E3%81%9F%E3%81%84
package samples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTryCatch_Cycle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // InputMismatchException -- + scanner.nextLine()
        while (true) {
            try {
                System.out.print("年齢を打ってください:");
                int age = sc.nextInt();

                System.out.println("あなたは " + age + "歳です。!");
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("あなたの年齢を打ってください。");
            }
        }


        // 別version  NumberFormatException
        while (true) {
            try {

                System.out.print("年齢を打ってください:");

                // 文字列として取得するので数字でなくても例外は発生しない
                String text = sc.nextLine();

                // ここで文字列を数値に変換
                // 数値に変換できなかった場合の例外は NumberFormatException
                // https://docs.oracle.com/javase/jp/17/docs/api/java.base/java/lang/Integer.html#valueOf(java.lang.String)
                int age = Integer.valueOf(text);

                System.out.println("あなたは " + age + "歳です。!");
                break;

            } catch (NumberFormatException e) {

                // 上の処理でスキャナから入力情報は取り除かれているので
                // ここで sc.nextLine(); を呼び出す必要はなくなった
                System.out.println("あなたの年齢を打ってください。");
            }
        }

    }
}
