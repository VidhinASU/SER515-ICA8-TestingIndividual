import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    // Test cases

    // good case
    @Test
    void goodString() {
        System.out.println("====== Vidhin Parmar== TEST ONE EXECUTED =======");
        Urinals urinals = new Urinals();
        assertTrue(urinals.goodString("1011"));
    }
    //bad alphabet string
    @Test
    void badString() {
        System.out.println("====== Vidhin Parmar== TEST TWO EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodString("101a"));
    }
}