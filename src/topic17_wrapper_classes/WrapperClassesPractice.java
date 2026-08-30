package topic17_wrapper_classes;

import java.util.ArrayList;

/**
 * ============================================================================
 * TOPIC 17: WRAPPER CLASSES (PRACTICE QUESTIONS)
 * ============================================================================
 */
public class WrapperClassesPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 17: WRAPPER CLASSES PRACTICE           ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Autoboxing & Unboxing inside Collections
        // --------------------------------------------------------------------
        System.out.println("--- 1. Autoboxing & Unboxing in List ---");
        ArrayList<Integer> marksList = new ArrayList<>();

        // Primitives pass kar rahe hain, Java automatically unhe Integer objects banata hai (Autoboxing)
        marksList.add(85);
        marksList.add(92);
        marksList.add(78);

        int sum = 0;
        // Elements access karne par Integer object automatically int primitive ban jata hai (Unboxing)
        for (int m : marksList) {
            sum += m;
        }

        System.out.println("Marks List: " + marksList);
        System.out.println("Sum calculated using Unboxing: " + sum);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Character Analyzer (Letter vs Digit vs Special)
        // --------------------------------------------------------------------
        System.out.println("--- 2. Character Analysis using Character Wrapper ---");
        String password = "Java@2026";
        int letterCount = 0;
        int digitCount = 0;
        int specialCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                specialCount++;
            }
        }

        System.out.println("Password: \"" + password + "\"");
        System.out.println("Letters : " + letterCount);
        System.out.println("Digits  : " + digitCount);
        System.out.println("Special : " + specialCount);

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
