import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a class for Urinals
 *
 * @author Vidhin
 */
public class Urinals {
    private final ArrayList<String> input = new ArrayList<>();
    private Boolean isInputFromFile;

    // public static void main(String[] args) throws Exception { {
    public void main(String[] args) throws Exception {
        Urinals urinal = new Urinals();
        urinal.getInput(true, "urinal.dat");
        urinal.sendOutput();

    }

    // getter for input
    public ArrayList<String> getInput() {
        return input;
    }

    public Boolean goodString(String str) {
        // System.out.println ("Not yet implemented");
        // checks to see if valid string
        // check if length between 1 and 20
        if (str.length() < 1 || str.length() > 20) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                return false;
            }
        }

        return true;
    }

    public Boolean goodPublicUrinalString(String str) {
        // System.out.println ("Not yet implemented");
        // checks to see if valid string using goodString method
        if (!goodString(str)) {
            return false;
        }

        // checks to see if there are 2 1's in a row
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '1' && str.charAt(i + 1) == '1') {
                return false;
            }
        }

        return true;
    }

    // given a string of urinals, return the number of urinals that can be used as
    // mens public toilet, there is this unwritten rule that you leave at least one
    // urinal free between you and the next person peeing
    public int getFreeUrinals(String str) {
        // System.out.println ("Not yet implemented");
        int count = 0;
        // if the string is not valid or a valid unwritten rule satisfying string,
        // return -1
        if (!goodPublicUrinalString(str)) {
            return -1;
        }

        // counts the number of free urinals
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                if (i == 0) {
                    if (str.charAt(i + 1) == '0') {
                        count++;
                        i++;
                    }
                } else if (i == str.length() - 1) {
                    if (str.charAt(i - 1) == '0') {
                        count++;
                    }
                } else {
                    if (str.charAt(i - 1) == '0' && str.charAt(i + 1) == '0') {
                        count++;
                        i++;
                    }
                }
            }
        }
        return count;
    }

    // get input from keyboard or a file named urinal.dat
    // if input is from keyboard, print results to screen
    // if input is from file, output to rule.txt
    public void getInput(Boolean isFromFile, String fileName) throws Exception {
        // System.out.println ("Not yet implemented");
        // continue processing until a -1 or <eof> is reached
        if (isFromFile) {
            isInputFromFile = true;
            try {
                Scanner sc = new Scanner(new File("dataFiles/" + fileName));
                while (sc.hasNext()) {
                    String str = sc.nextLine();
                    if (str.equals("-1")) {
                        break;
                    }
                    input.add(str);
                }
                sc.close();
            } catch (FileNotFoundException e) {
                // IOException
                // System.out.println("File not found");
                throw e;
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            // NumberFormatException // does this go here?
            // This will not be used because we are directly comparing strings instead of
            // integers
            // if file does not exist or is empty, return null
            if (input.size() == 0) {
                System.out.println("File is empty or Null");
            }
        } else {
            isInputFromFile = false;
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            while (!str.equals("-1")) {
                input.add(str);
                str = sc.nextLine();
            }
            sc.close();
        }
    }

    public void sendOutput() {
        // System.out.println ("Not yet implemented");
        if (isInputFromFile) {
            // output to rule.txt. If the file rule.txt already
            // exists, increment a counter, and rename the file using the following rule
            // pattern: rule1.txt, rule2.txt, etc.
            // The output is JUST THE NUMBER of free urinals.

            int count = 0;
            while (true) {
                String fileName = "rule" + count + ".txt";
                File file = new File(fileName);
                if (file.exists()) {
                    count++;
                } else {
                    break;
                }
            }
            try {
                PrintWriter pw = new PrintWriter("rule" + count + ".txt");
                for (String s : input) {
                    pw.println(getFreeUrinals(s));
                }
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // print results to screen
            for (String s : input) {
                System.out.println(getFreeUrinals(s));
            }
        }
    }
}
