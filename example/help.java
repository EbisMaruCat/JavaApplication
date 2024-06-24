package example;
/* echoっぽい メソッドを作ってみた：「echoモドキ()メソッド」

    ・public static "void" で 戻り値が不要になる
    ・引数にString型

    ・system.outシリーズ それぞれの違い
    ・ 改行 "\n" と "%n" の 違い
        ( 2023年Java基礎によると "\n"は 使ってほしくないらしい)
*/

public class help {

    /* === main()メソッド === */
    public static void main(String[] args){

        // いつもなら こうするだろう。
        System.out.println("Hello world!");

        // echoモドキ()メソッド 試してみた
        echo("試してみたでー");
        echo("Hello!");
        echo("01234567890!!");


        // echoモドキ()メソッド  の system.outシリーズ それぞれ お試し
        // %n(改行書式、\nみたいなもの ) 通じるかどうか お試し

        echo01("echo01 test %n");    // %n 通用しない
        echo01("\n");                // \n　通用する(ただし本来あまり好ましくない)

        echo01("echo01 test"+ "%n");  // %n 分別しても通用しない
        echo01("\n");                 // \n 通用する(同文)

        echoF("echoF test_");        // %nまだ入れてない。次の文章と比較するために、あえて。
        echoF("echoF test %n");      // %n 通用する！
        echoF("\n");                 // \n 通用する(同文)

        echoLN("echoLN test %n");       // %n 通じない。ーーーただし改行されてる
        echoLN("echoLN test" + "%n");   // %n 分別しても通用しない。ーーーただし改行されてる

    }

    /* === echoモドキ()メソッド === */
    public static void echo(String str){
        System.out.println(str);
    }

    /* === echoモドキ メソッド 種類１：echo01 === */
    private static void echo01(String words){
        System.out.print(words);    // out.printで出力、()内は出力する内容
    }

    /* === echoモドキ メソッド 種類２：echoF ===*/
    private static void echoF(String wF){
        System.out.printf(wF);      // printf の F:Format(意味：書式設定)
    }

    /* === echoモドキ メソッド 種類３：echoLN ===*/
    private static void echoLN(String wLN){
        System.out.println(wLN);    // println の LN(改行付き)
    }
}