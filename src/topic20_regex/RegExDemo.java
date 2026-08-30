package topic20_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ============================================================================
 * TOPIC 20: JAVA REGEX (REGULAR EXPRESSIONS & PATTERN MATCHING)
 * ============================================================================
 * 
 * 📌 REGEX KYA HAI?
 * - Strings ke andar specific patterns (jaise Email, Phone Number, Date) ko 
 *   SEARCH, MATCH ya VALIDATE karne ka powerful formula/tool.
 * - Java package: `java.util.regex` (Classes: `Pattern` aur `Matcher`).
 * 
 * 📌 REGEX CHEAT SHEET (ROZ KAAM AANE WALE SYMBOLS):
 * 1. `\d`       -> Any Digit (0-9) [Java string me `\\d` likhte hain]
 * 2. `\D`       -> Non-digit (Koi bhi character jo number na ho)
 * 3. `\w`       -> Word character (Alphabets, numbers aur underscore `_`)
 * 4. `\s`       -> Whitespace / Space / Tab
 * 5. `.`        -> Any single character (Kuch bhi chalega)
 * 6. `+`        -> 1 ya 1 se zyada baar (1 or more)
 * 7. `*`        -> 0 ya 1 se zyada baar (0 or more)
 * 8. `?`        -> 0 ya 1 baar (Optional)
 * 9. `^` aur `$`-> `^` shuruat (Start) aur `$` ant (End) ke liye
 * 10. `{n}`     -> Exact 'n' baar hona chahiye (e.g. `\\d{10}` = Exact 10 digits)
 */
public class RegExDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        TOPIC 20: JAVA REGEX COMPLETE DEMO        ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. BASIC PATTERN & MATCHER USAGE
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // 1. Pattern.compile(regex): Regex formula compile karta hai.
        // 2. pattern.matcher(text): Text ke andar pattern dhundne ke liye Matcher object banata hai.
        // 3. matcher.matches(): Kya poori string pattern se match hoti hai? (true/false).
        System.out.println("--- 1. Simple Number Matching ---");
        String pinCodeRegex = "^[1-9]\\d{5}$"; // 6-digit Indian PIN Code (first digit 1-9)

        String pin1 = "110001";
        String pin2 = "012345"; // Invalid: Starts with 0
        String pin3 = "12345";  // Invalid: Only 5 digits

        System.out.println("PIN " + pin1 + " is Valid? : " + Pattern.matches(pinCodeRegex, pin1)); // true
        System.out.println("PIN " + pin2 + " is Valid? : " + Pattern.matches(pinCodeRegex, pin2)); // false
        System.out.println("PIN " + pin3 + " is Valid? : " + Pattern.matches(pinCodeRegex, pin3)); // false
        System.out.println();

        // ====================================================================
        // 2. EXTRACTING DATA FROM A PARAGRAPH (matcher.find())
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // `matcher.find()` ek text paragraph me se saare matching words/numbers ko ek-ek karke dhoondh nikalta hai.
        System.out.println("--- 2. Extracting Phone Numbers from Text ---");
        String document = "Contact support at 9876543210 or alternate helpline 8123456789 for queries.";

        // Regex for 10-digit mobile number starting with 6, 7, 8, or 9
        String phoneRegex = "[6-9]\\d{9}";

        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(document);

        int count = 1;
        while (matcher.find()) {
            System.out.println("Found Phone #" + count + ": " + matcher.group() + 
                               " (at index: " + matcher.start() + " to " + matcher.end() + ")");
            count++;
        }
        System.out.println();

        // ====================================================================
        // 3. EMAIL ADDRESS VALIDATION
        // ====================================================================
        System.out.println("--- 3. Email Validation ---");
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        String email1 = "aman.kumar@company.com";
        String email2 = "invalid-email@";

        System.out.println("Email: " + email1 + " -> Valid? " + email1.matches(emailRegex)); // true
        System.out.println("Email: " + email2 + " -> Valid? " + email2.matches(emailRegex)); // false

        System.out.println("\n==================================================");
        System.out.println("           REGEX DEMO COMPLETED!                  ");
        System.out.println("==================================================");
    }
}
