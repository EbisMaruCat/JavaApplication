
/*  2024/04/24
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

/* import xxxx.xxxx.PrimeNumber;
        成程...もしフォルダ跨いでprimeNumber関数を利用したい場合、こうしてパスを記述する
        だが、今回は 折角だから
        (折角というより 認知度を確証させるために) パッケージをリファクタリング。
*/

import java.util.List;       // リスト利用
import java.util.ArrayList;  // リスト作成
import java.util.Scanner;

public class PrimeNumber_proto {
    public static void main(String[] args) {

        System.out.println("素数判定を行う。今回は頭から個数分、リストとして表示される。"
                + "\n調べたい個数分を入力して：");

        // もし 個数指定だったら 直接こう: int numberOfPrimes = 10;
        Scanner get_Num = new Scanner(System.in);
        int numberOfPrimes = get_Num.nextInt();


        // 今回 作ったgeneratePrimes()メソッド使う特は このプログラム名(この場合クラス名).メソッド名
        List<Integer> primes = PrimeNumber_proto.generatePrimes(numberOfPrimes);
        for (int i = 0; i < primes.size(); i++) {
            System.out.println(i + 1 + ":" + primes.get(i));
        }
        get_Num.close();
    }

    // ===模範解答より ===
    public static List<Integer> generatePrimes(int n) { // n　は main()のnumberOfPrimes に該当
        List<Integer> primes = new ArrayList<>();
        int count = 0;   // 確かめていく
        int numberQ = 2;  // 開始位置であり、最初の素数でもある。 リスト[0]に入れる

        while (count < n) {             // 確かめる数値countが scan_fから取った nより 小さい間
            if (isPrime(numberQ)) {      // 関数isPrime(numberQ) numberが素数 == 1(true) の時
                primes.add(numberQ);     // リストprimes[0~ ]に numberQの値を挿入
                count++;                // countを +1進める(amNumに至るまで これが繰り返されるwhile)
            }
            numberQ++;                  // numberQを +1進める(次のputNumが素数かどうか これが繰り返されるif)
        }
        return primes;
    }

    // 指定数numberOfPrimes の区別...じゃない。 なんだこりゃ？？
    public static boolean isPrime(int numberIn) {
        if(numberIn < 1) {
            throw new IllegalArgumentException("入力された数は正でなければなりません。");
        }
        //1は素数ではないから、 もし入力で 1と入れられたら
        if (numberIn == 1) {
            return false;
        }
        for (int i = 2; i < numberIn; i++) {
            //「もっと計算効率を上げられるが最もわかりやすい処理を書いておく。」
            if (numberIn % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/*
指定した個数の素数リスト = ？
リストを作成 = List型オブジェクト使用？
個数が１未満の場合は空のリストを作成 = 別のList型？
generate()メソッド : 指定された関数を使用して無限の要素を生成するストリームを作成?

つまりこの問題は、こういうこと？
    リスト＝引数、素数を何個まで==通番の数
        通番(？個数目)：素数(該当する素数というか...)
    例：リスト = 5  == 5個の素数を出してくれ？
        出力： 1:2
              2:3
              3:5
              4:7
              5:11
     ...でもそれだと「個数が１未満の場合は空のリストを作成」って どゆこと？ NULL?
*/

/* 講師 ご指導(2024/04/24 ありがとうございます)
  === クラス作りで ===
  public ほかのクラスからも呼び出せる
  static クラス名.メソッド名の形で呼び出せる

  === 中身の話 ===
  public  他のクラスからも呼び出せる
  static  クラス名.メソッド名の形で呼び出せる
  List<Integer>  整数のリストをreturnで返すよ
  generatePrimes  メソッド名
  int n  整数をinputに取るよ
 */

/*
今回は、その数の分だけ 素数を取り出してこい って言ってる？
例えば 引数100個だったら、
「100までの間の素数全部くれ」ではなく「100個の素数をくれ」ってこと！？
   【注意：素数の扱いについて】
      「1」は素数じゃない。「2」は素数。
      「2」以降の「素数認定したもの」をリストに追加していく

    模索：
        例：int XYZ = 5個くれ
    ・つまり、引数 = 5。これを 下の "listNo"に代入することになる？
            List primeNum[listNo] : [ここで素数入れていく]
    ・ 5個になるまで 数字を一つずつ増やして、リストに入れていく？

    (while 個数 <= XYZ)
        【素数探し】
        int chQNum=0;
        primeNum.add("__");

 */

/*
List<Integer> numOneEM = new ArrayList<Integer>();  エラー用リスト？
上記 ----不要??(04/26 模範解答みるかぎり)
エラー処理方法:boolean?? 模範解答見たところ、リストではなくBoolean判定で返してた...???
 */

/*
    演習9 演習5[PrimeNumber]の続きで、
    「n番目の素数を返す」メソッドgetPrime(int nth)を作成
    （テストを先に作って、実装を行う テスト駆動開発)

    まぁ、もう、演習５をそのまま使うでんな。(コピペと修正)

演習5 を 把握しながら再構築。
    つまり、今までは n個まで 一覧として作り上げるものを、
    今度は、指定箇所の素数だけ取って来いってこと。
    例：
    隊長 「4番目の旗(素数)は、なんだ！？」
    隊員 「えぇっと... 2,3,5...7です！」
    隊長 「よし、それを掲げぃ！」
 */


/* 素数判定の仕方をおさらい：
  1~己自身まで、割り切れるかどうか判定(C言語 雑版)

    操作者の指定数値 : int ABC = scan_f ;

    int unNum : int ABCに該当する？
    int i : 素数判定するため、範囲は (2 ~ ABC-1)まで
    素数判定の旗印 : int primeDa = 1; 【戻り値】

    int n : 範囲(0 ~ ABC)まで 判定確認・表示する予定の数値
    素数の数個算機 : int counter = 0;

  ----- program -----
#include<stdio.h>

int primeChQ(int unNum){
    int i;
    int primeDa = 1;

    if(unNum<2){    //使えない素数(1とか)だよ！
        primeDa = 0;
    }
    for(i=2; i<unNum; i++){   // unNumが i(2 ~ unNum-1)で 割り切れる数値かどうか
        if(unNum % i == 0){   // unNumが i(2 ~ unNum-1)で 割り切れてしまった場合
            primeDa = 0;
        }
        // else = そうでなかったら *おそらく* 素数である( primeDa=1 のまま)
    }
    return primeDa;
}

int main(){
    printf("数値を指定してください：");

    int ABC;
    scan_f("%d", &ABC);

    int n;
    int counter = 0;

    printf("%dまでの素数一覧：\n",ABC);

    for(n=0; n <= ABC; n++){
        if( primeChQ(n) ){
            printf("%d ",n);
            counter = counter + 1;
        }
    }
    printf("\n素数の合計数：%d個\n",counter);
}
  ----- ------ ------
  */