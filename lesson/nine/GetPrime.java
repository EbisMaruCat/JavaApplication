
// 2024/05/06追記
package lesson.nine;

// 2024/05/13 追加
import java.util.Scanner;

public class GetPrime {
    // echo使えるようにしたよ！
    public static void echo(String words){
        System.out.println(words);
    }

    // main()メソッド
    public static void main(String[] args){

        echo("何番目の素数を調べますか？ :");
        Scanner get_No = new Scanner(System.in);
        int PrimeNo = get_No.nextInt();

        int Answer = GetPrime.getPrime(PrimeNo);
        System.out.println( PrimeNo + " 番目の素数は "  + Answer + " です");

    }

    // 素数判定処理 関数 .....特に変えていない、はず。
    public static boolean isPrime(int Number){  // Number : 調べる数値
        if (Number<1){
            // Numberが 正数でない時の エラーメッセ
            throw new IllegalArgumentException("入力された数は正でなければなりません。\n");
        }
        if (Number == 1){
            return false;                // isPrime(Number)==0 : 素数ではない
        }
        for(int iNum = 2; iNum<Number; iNum++){
            if(Number % iNum ==0){      // Number が iNumで割り切れた
                return false;           // isPrime(Number)==0 : 素数ではない
            }
        }
        return true;                    // isPrime(Number)==1 : 素数
    }

    // === 課題 ===  素数 何番目げっと getPrime(nht)
    public static int getPrime(int nht){
        int whatPrime = 2;      // 初期設定。最初の素数でもある。
        int count = 0;          // nht(PrimeNoの数の分)
        int answerPrime = 0;    // 戻り値 予定

        while(count<nht){
            if(isPrime(whatPrime)){        // whatPrimeが 素数である
                count++;                   // +1 進める (nhtの数に至るまで while文)
            }
            whatPrime++;                   // 素数でなくても 素数判定終わっても whatPrimeを+1。(countがnhtに至るまで)
        }

        answerPrime = whatPrime - 1;   // 戻り値予定の answerPrimeに 現在のwhatPrimeの値を入れる
        // なぜか 余分に多いから -1 しとく...　【修正】
        return answerPrime;
    }

}
