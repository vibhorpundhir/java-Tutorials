package topic16_collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

/**
 * ============================================================================
 * TOPIC 16: JAVA COLLECTIONS (PRACTICE QUESTIONS)
 * ============================================================================
 */
public class CollectionsPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 16: COLLECTIONS PRACTICE PROBLEMS      ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: E-Commerce Shopping Cart (ArrayList)
        // --------------------------------------------------------------------
        System.out.println("--- 1. Shopping Cart System (ArrayList) ---");
        ArrayList<String> cart = new ArrayList<>();
        cart.add("Wireless Mouse");
        cart.add("Mechanical Keyboard");
        cart.add("Gaming Monitor");

        System.out.println("Cart Items : " + cart);
        System.out.println("Total Items: " + cart.size());

        // Remove item
        cart.remove("Wireless Mouse");
        System.out.println("After item removal: " + cart);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Remove Duplicates from List (HashSet)
        // --------------------------------------------------------------------
        // Problem: Array list me duplicates hain, unhe filter out karein.
        System.out.println("--- 2. Duplicate Remover (HashSet) ---");
        ArrayList<String> duplicateNames = new ArrayList<>();
        duplicateNames.add("Aman");
        duplicateNames.add("Rohan");
        duplicateNames.add("Aman"); // duplicate
        duplicateNames.add("Priya");
        duplicateNames.add("Rohan"); // duplicate

        System.out.println("Original List with Duplicates : " + duplicateNames);

        // HashSet me daalte hi duplicates automatically gayab:
        HashSet<String> uniqueSet = new HashSet<>(duplicateNames);
        System.out.println("Filtered Unique Names         : " + uniqueSet);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 3: Word Frequency Counter (HashMap)
        // --------------------------------------------------------------------
        // Problem: Sentence me har word kitni baar aaya count karein.
        System.out.println("--- 3. Word Frequency Counter (HashMap) ---");
        String text = "java is fun and java is powerful";
        String[] words = text.split(" ");

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            // Agar word pehle se hai toh count + 1, warna 1
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        System.out.println("Sentence: \"" + text + "\"");
        System.out.println("Word Frequencies: " + wordCountMap);

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
