package lesson.nine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetPrimeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void echo() {
    }


    // まだ fail中... コンソール画面に 失敗の結果が出なーい?  2024/05/08 13
    // ----->解決！ テストプロに equals追加で表示される。たぶんこれでok
    // 本プロ【修正】ok  2024/05/13
    @Test
    void isPrime() {
        assertTrue(GetPrime.isPrime(5));
        assertFalse(GetPrime.isPrime(10));
        assertThrows(
                // ラムダ式:
                IllegalArgumentException.class, () -> GetPrime.isPrime(-5)
                /* ラムダ式に変更する前はこんな感じ... {}を 外しただけかいな？
                IllegalArgumentException.class, () -> {
                    GetPrime.isPrime(-5);
                }
                 */
        );
    }

    @Test
    void getPrime() {
        assertEquals(2, GetPrime.getPrime(1));
        assertEquals(3, GetPrime.getPrime(2));
        assertEquals(5, GetPrime.getPrime(3));
        assertEquals(7, GetPrime.getPrime(4));
        assertEquals(11, GetPrime.getPrime(5));
        assertEquals(13,GetPrime.getPrime(6));
    }
}