package topic20_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ============================================================================
 * TOPIC 20: REGEX (PRACTICE QUESTIONS)
 * ============================================================================
 */
public class RegExPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("          TOPIC 20: REGEX PRACTICE                ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Strong Password Policy Validator
        // --------------------------------------------------------------------
        // Rule: Min 8 chars, at least 1 digit, at least 1 uppercase, at least 1 special char
        System.out.println("--- 1. Password Strength Validation ---");
        String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        String p1 = "Pass@1234"; // Valid
        String p2 = "simplepass"; // Invalid

        System.out.println("Password \"" + p1 + "\" Strong? : " + p1.matches(passRegex));
        System.out.println("Password \"" + p2 + "\" Strong? : " + p2.matches(passRegex));
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Extracting all Hashtags from Social Media Post
        // --------------------------------------------------------------------
        System.out.println("--- 2. Extract Hashtags from Post ---");
        String post = "Loving the new #Java21 features and #SpringBoot3 development with #AI tools!";

        Pattern tagPattern = Pattern.compile("#\\w+");
        Matcher tagMatcher = tagPattern.matcher(post);

        System.out.println("Post Text: " + post);
        System.out.print("Extracted Tags: ");
        while (tagMatcher.find()) {
            System.out.print(tagMatcher.group() + " ");
        }
        System.out.println();

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
