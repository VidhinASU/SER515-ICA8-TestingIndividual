/**
 * This is a class for Urinals
 *
 * @author Vidhin
 */
public class Urinals {
    public static void main(String[] args) {

    }

    public Boolean goodString(String str) {
        // System.out.println ("Not yet implemented");
        // checks to see if valid string
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
        if (goodString(str) == false) {
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
    // mens
    // public toilet, there is this unwritten rule that you leave at least one
    // urinal
    // free between you and the next person peeing
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
}
