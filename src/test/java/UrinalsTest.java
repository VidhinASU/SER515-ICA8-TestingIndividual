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
}