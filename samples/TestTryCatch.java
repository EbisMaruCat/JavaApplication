
// https://qiita.com/mikuma/items/22bbb254dc82b39e983f
package samples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTryCatch {
    public static void main(String[] args){

        System.out.print("数値を入れてください : ");
        Scanner in = new Scanner(System.in);

        try{
            int in_next = in.nextInt();
            System.out.println(in_next + "は無事通ったよ");
            in.close();
        }
        catch(InputMismatchException e){
            System.out.println("エラーだよ");
            System.out.println(e);
        }

    }
}