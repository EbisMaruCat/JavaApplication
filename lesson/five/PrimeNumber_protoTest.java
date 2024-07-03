package lesson.five;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumber_protoTest {

    PrimeNumber_proto priNum_pro;

    PrimeNumber_protoTest(){
        priNum_pro = new PrimeNumber_proto();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
    }

    @Test
    void generatePrimes() {

        // まずは あらかじめ 解答を作るのかな？
        List<Integer> list1 = new ArrayList<>();  //リスト生成
        list1.add(2);     // リスト 1番目に 2
        list1.add(3);     // 2:3
        list1.add(5);     // 3:5
        list1.add(7);     // 4:7
        list1.add(11);
        list1.add(13);

        // asserts.Equals( さっき上で作った解答 list1、 実際ブログラムで出た答え(個数) )
        assertEquals(list1, PrimeNumber_proto.generatePrimes(5));
    }

    @Test
    void isPrime() {
        assertTrue(PrimeNumber_proto.isPrime(5));      // 5 は 素数。 だからtrueアセットに 入れる。
        assertFalse(PrimeNumber_proto.isPrime(10));    // 10 は 素数ではない！ だからfalseアセットに~

        assertThrows(
                // -5は そもそも正数ではない。 だから例外処理に... なんだこりゃ？
                IllegalArgumentException.class, () -> { PrimeNumber_proto.isPrime(-5);}
        );
    }

}


/*
アサーション Assertions
-------------------------
プログラム内で条件が真であることを確認するための仕組み
    これを使うと、特定の条件がプログラムの実行時に満たされているかどうかを 確認できる

    assertions 種類一覧
    https://yoshitaro-yoyo.hatenablog.com/entry/assertion-of-junit5
    よく使うもの 説明
    https://zenn.dev/kojikaya/articles/bf1fd780c93d50

    ・assertsEquals(expected, actual)
        ()内の 2つの値が等しいかどうか
            ① expected : 本来の答え つまりは期待された答え ようは解答
            ② actual   : 実際出た答え
    ・assertsTrue( 対象target )
        引数の値が true かどうか
    ・assertsFalse( 対象 )
        trueの逆。
    ・assertsNull( 対象 )
        Null かどうか
    ・assertThrows(例外クラス, テスト対象コードブロック)
        例外をスロー(示す？)するかどうか。
        テスト対象の コードブロックを実行した時に 例外クラスが発生する かどうか
            ① 例外クラス :
            ② コードブロック枠の書き方： () -> {関数というか}

    */
