package utilities;

/**
 *
 * @author isaac
 */

// Validate coordinates
public class UtilitiesValidation {
    // Validate coordinates
    public static boolean isValidDouble(String str) {
    try {
        Double.parseDouble(str); 
        return true;
    } catch (NumberFormatException e) {
        return false;
      }
    }
}

