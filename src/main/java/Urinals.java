/**
 * This is a class for Urinals
 *
 * @author Vidhin
 *
 */
public class Urinals {
    public static void main(String[] args){

    }
    public Boolean goodString( String str ) {
        // System.out.println ("Not yet implemented");
        // checks to see if valid string
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                return false;
            }
        }

        return true; 
   }
}
