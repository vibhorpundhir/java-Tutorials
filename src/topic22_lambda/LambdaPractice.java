package topic22_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ============================================================================
 * TOPIC 22: LAMBDAS (PRACTICE QUESTIONS)
 * ============================================================================
 */
public class LambdaPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("          TOPIC 22: LAMBDA PRACTICE               ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Filter Words by Length using Lambda
        // --------------------------------------------------------------------
        System.out.println("--- 1. Filter Short Words (< 5 letters) ---");
        List<String> words = new ArrayList<>(Arrays.asList("cat", "elephant", "dog", "tiger", "lion"));
        System.out.println("Before Filter: " + words);

        // Remove if length is less than 5 letters
        words.removeIf(w -> w.length() < 5);
        System.out.println("After Filter (Length >= 5): " + words);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Running a Thread using Lambda
        // --------------------------------------------------------------------
        System.out.println("--- 2. Thread execution via Lambda ---");
        // Bina Runnable class banaye direct lambda se thread chalana
        Thread bgThread = new Thread(() -> System.out.println("🚀 Background Task executed cleanly via Lambda expression!"));
        bgThread.start();

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
