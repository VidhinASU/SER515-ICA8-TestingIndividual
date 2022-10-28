import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    // Bad String too long (>20)
    @Test
    void badString3() {
        System.out.println("====== Vidhin Parmar== TEST FIFTEEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodString("101010101010101010101"));
    }

    // Bad String too short <1
    @Test
    void badString4() {
        System.out.println("====== Vidhin Parmar== TEST SIXTEEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodString(""));
    }

    // Bad Case Public Urinal String too long (>20)
    @Test
    void badPublicUrinalString5() {
        System.out.println("====== Vidhin Parmar== TEST SEVENTEEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodPublicUrinalString("101010101010101010101"));
    }

    // Bad Case Public Urinal String too short <1
    @Test
    void badPublicUrinalString6() {
        System.out.println("====== Vidhin Parmar== TEST EIGHTEEN EXECUTED =======");
        Urinals urinals = new Urinals();
        assertFalse(urinals.goodPublicUrinalString(""));
    }

    // Read file test file does not exist
    @Test
    void getInputFileDoesNotExist() {
        System.out.println("====== Vidhin Parmar== TEST NINETEEN EXECUTED =======");
        Urinals urinal = new Urinals();
        Throwable exception = assertThrows(FileNotFoundException.class, () -> urinal.getInput(true, "urinalssssss.dat"));
        assertEquals("dataFiles\\urinalssssss.dat (The system cannot find the file specified)", exception.getMessage());
    }

    // Read file test file is empty
    @Test
    void getInputFileIsEmpty() throws Exception {
        System.out.println("====== Vidhin Parmar== TEST TWENTY EXECUTED =======");
        Urinals urinal = new Urinals();
        // check if function printed File is empty or Null
        urinal.getInput(true, "urinalsEmpty.dat");
        assertEquals(0, urinal.getInput().size());
    }

    // IOException has many subclasses that are specific in nature.
    // That means, when your application searching to read a file,
    // if the file is not found that there is a ileNotFoundException to be thrown.
    // FileNotFoundException is a subclass of IOException
    // Few of the well known classes are:
    //
    // FileNotFoundException
    // EOFException
    // SSLException
    // UnSupportedEncodingException
    // SocketException
    @Test
    void getInputFileIOException() {
        System.out.println("====== Vidhin Parmar== TEST TWENTY ONE EXECUTED =======");
        Urinals urinal = new Urinals();
        Throwable exception = assertThrows(FileNotFoundException.class, () -> urinal.getInput(true, "urinalssssss.dat"));
        assertEquals("dataFiles\\urinalssssss.dat (The system cannot find the file specified)", exception.getMessage());
    }

    // write file exception in sendOutput file is duplicate
    // since we create an output file with ending numbers based on last known
    // serialized digit in the file, we will never get this exception in our program
    @Test
    void sendOutputFileDuplicate() {
        System.out.println("====== Vidhin Parmar== TEST TWENTY TWO EXECUTED =======");
        Urinals urinal = new Urinals();
        try {
            urinal.getInput(true, "urinal.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // run the generated output file function twice and check if any exception is
        // thrown
        try {
            urinal.sendOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            urinal.sendOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // check if the two files rule.txt and rule1.txt are same in content
        File file1 = new File("dataFiles\\rule.txt");
        File file2 = new File("dataFiles\\rule1.txt");
        try {
            assertTrue(FileUtils.contentEquals(file1, file2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // write IOException file has wrong path (folder does not exist)
    @Test
    void sendOutputFileIOException() {
        System.out.println("====== Vidhin Parmar== TEST TWENTY THREE EXECUTED =======");
        Urinals urinal = new Urinals();
        try {
            urinal.getInput(true, "urinal.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }
        urinal.setOutputFolder("abcdefghijk/");
        // catch IOException of type FileNotFoundException to be thrown because folder does not exist
        Throwable exception = assertThrows(FileNotFoundException.class, () -> urinal.sendOutput());
        assertEquals("abcdefghijk\\rule.txt (The system cannot find the path specified)", exception.getMessage());
    }
}