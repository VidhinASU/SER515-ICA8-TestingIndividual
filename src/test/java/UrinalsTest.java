import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    @Test
    void goodString() {
        System.out.println("====== Vidhin Parmar== TEST ONE EXECUTED =======");
        Urinals urinals = new Urinals();
        assertTrue(urinals.goodString("1011"));
    }
}