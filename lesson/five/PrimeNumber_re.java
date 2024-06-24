
/*  2024/04/24    remake:2024/06/22
    演習5 素数リスト作成  (1306_Java問題(課題) 問6より)

    指定した個数の素数リストを作成するクラス、メソッドを作成してください。
    個数が１未満の場合は空のリストを作成してください。
       クラス名：PrimeNumber(素数クラス)
       メソッド：List generate (Integer number)
       出力形式： 通番：素数
       出力例 (引数に3を指定した場合)：
             1:2
             2:3
             3:5
 */
package lesson.five;


import java.util.Scanner;
import java.util.InputMismatchException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class PrimeNumber_re {

    private final static int AMOUNT_ZERO = 0, AMOUNT_ONE = 1;
    private final static Scanner scanAmount = new Scanner(System.in);

    public static void main(String[] args){

        System.out.print("表示したい素数の 個数を 指定してください : ");

        // int amountOfPrimes = 10;
        int amountOfPrimes = scanCheQ();

        List<Integer> primeNumbers = PrimeNumber_re.generateRe(amountOfPrimes);

        for (int i = 0; i < primeNumbers.size(); i++) {
            System.out.println(i + 1 + ":" + primeNumbers.get(i));
        }
        scanAmount.close();
    }

    // Scannerで受け取ったのが integerか否か
    private static int scanCheQ(){
        try{
            return scanAmount.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("==Error==");
            System.out.print("表示したい素数の 個数を 整数で 指定してください:");
            scanAmount.next();  //さっきの入力を 白紙化?
        }
        return scanCheQ();
    }


    // 素数判定 によって リストに入れる
    private static List<Integer> generateRe(int scannedNum){

        List<Integer> listDone = new ArrayList<>();

        if(scannedNum == AMOUNT_ZERO || scannedNum == AMOUNT_ONE){
            return Collections.emptyList();   // 空のリストを返す
        }
        else {

            int cntAmount = 0;     // 個数分までの 計算機
            int number = 2;        // 素数判定か否か の 対象

            while (cntAmount < scannedNum) {        // 指定された個数まで の 間
                if (isPrimeRe(number)) {            // 対象が 素数であった場合
                    listDone.add(number);           // リストに 対象の数値 を 追加
                    cntAmount++;                    // 計算機に +1加算
                }
                number++;                           // 素数であってもなくても 対象に +1加算
            }
        }
        return listDone;
    }


    // 素数判定
    private static boolean isPrimeRe(int numberIn){

        // 対象数値=2の場合  たぶんここのfor枠 すっとばされるんじゃね？
        for (int i = 2; i < numberIn; i++) {    // i=2の時から  i<対象数値の間、 iで比較する
            if(numberIn % i ==0){               // iで割り切れちゃった場合
                return false;                   // そいつは素数ではない ということだ
            }
        }
        return true;                           // 対象数値=2の時も true判定
    }
}

/* 参考ありがとう
空のリストを返す
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Collections.html

https://qiita.com/yoshi389111/items/1ce067cbaf868f6d4565
https://blog.sgnet.co.jp/2015/06/java.html
https://hjm333.hatenablog.com/entry/2016/06/13/231845
 */