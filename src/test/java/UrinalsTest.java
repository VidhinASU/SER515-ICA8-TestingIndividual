import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    // Test cases

    // Good case
    @Test
    void goodString() {
        System.out.println("====== Vidhin Parmar== TEST ONE EXECUTED =======");
        Urinals urinals = new Urinals();
        assertTrue(urinals.goodString("1011"));
    }

    // Bad alphabet string
    @Test
    void badString() {
        System.out.println("====== Vidhin Parmar== TEST TWO EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodString("101a"));
    }

    // Bad number string
    @Test
    void badString2() {
        System.out.println("====== Vidhin Parmar== TEST THREE EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodString("1012"));
    }

    // 10001 returns 1 (10101)
    // 1001 returns 0 (1001)
    // 00000 returns 3 (10101)
    // 0000 returns 2 (1001)
    // 01000 returns 1 (01010 or 01001)
    // 011 returns -1
    // Count max free urinals string 1
    @Test
    void getFreeUrinals() {
        System.out.println("====== Vidhin Parmar== TEST FOUR EXECUTED =======");
        Urinals urinals = new Urinals();
        assertEquals(1, urinals.getFreeUrinals("10001"));
    }

    // Count max free urinals string 2
    @Test
    void getFreeUrinals2() {
        System.out.println("====== Vidhin Parmar== TEST FIVE EXECUTED =======");
        Urinals urinals = new Urinals();
        assertEquals(0, urinals.getFreeUrinals("1001"));
    }

    // Count max free urinals string 3
    @Test
    void getFreeUrinals3() {
        System.out.println("====== Vidhin Parmar== TEST SIX EXECUTED =======");
        Urinals urinals = new Urinals();
        assertEquals(3, urinals.getFreeUrinals("00000"));
    }

    // Count max free urinals string 4
    @Test
    void getFreeUrinals4() {
        System.out.println("====== Vidhin Parmar== TEST SEVEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertEquals(2, urinals.getFreeUrinals("0000"));
    }

    // Count max free urinals string 5
    @Test
    void getFreeUrinals5() {
        System.out.println("====== Vidhin Parmar== TEST EIGHT EXECUTED =======");
        Urinals urinals = new Urinals();
        assertEquals(1, urinals.getFreeUrinals("01000"));
    }

    // Count max free urinals string 6
    @Test
    void getFreeUrinals6() {
        System.out.println("====== Vidhin Parmar== TEST NINE EXECUTED =======");
        Urinals urinals = new Urinals();
        assertEquals(-1, urinals.getFreeUrinals("011"));
    }

    // Good Case Public Urinal String
    @Test
    void goodPublicUrinalString() {
        System.out.println("====== Vidhin Parmar== TEST TEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertTrue(urinals.goodPublicUrinalString("1010"));
    }

    // Bad Case Public Urinal String
    @Test
    void badPublicUrinalString() {
        System.out.println("====== Vidhin Parmar== TEST ELEVEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodPublicUrinalString("1011"));
    }

    // Bad Case Public Urinal String
    @Test
    void badPublicUrinalString2() {
        System.out.println("====== Vidhin Parmar== TEST TWELVE EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodPublicUrinalString("1012"));
    }

    // Bad Case Public Urinal String
    @Test
    void badPublicUrinalString3() {
        System.out.println("====== Vidhin Parmar== TEST THIRTEEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodPublicUrinalString("101a"));
    }

    // Good Case Public Urinal String
    @Test
    void badPublicUrinalString4() {
        System.out.println("====== Vidhin Parmar== TEST FOURTEEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertTrue(urinals.goodPublicUrinalString("101"));
    }
}