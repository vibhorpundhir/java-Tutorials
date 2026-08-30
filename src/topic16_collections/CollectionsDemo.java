package topic16_collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================================
 * TOPIC 16: JAVA COLLECTIONS FRAMEWORK (ARRAYLIST, HASHSET, HASHMAP)
 * ============================================================================
 * 
 * 📌 COLLECTIONS KYA HAI? (ARRAYS SE BEHTAR KYU?)
 * - Normal Array ka size FIXED hota hai (baad me badha ya ghata nahi sakte).
 * - Collections DYNAMIC hote hain (elements add karne par automatically size badh jata hai).
 * 
 * 📌 3 SABSE IMPORTANT COLLECTIONS:
 * 1. ArrayList<T>   -> Ordered List (Index-based, Duplicates allowed).
 * 2. HashSet<T>     -> Unordered Set (Unique elements ONLY, NO Duplicates, Super fast search).
 * 3. HashMap<K, V>  -> Key-Value Pairs (Dictionary / Phonebook, Keys are Unique).
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      TOPIC 16: JAVA COLLECTIONS COMPLETE DEMO    ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. ARRAYLIST (Ordered, Dynamic, Duplicates Allowed)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Ye internal dynamic array use karta hai.
        // Jis order me add karenge, usi order me store hoga.
        System.out.println("--- 1. ArrayList<String> (Ordered List) ---");
        ArrayList<String> fruits = new ArrayList<>();

        // .add(): Element add karna
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple"); // Duplicates allowed!

        System.out.println("ArrayList Elements : " + fruits);
        System.out.println("Total Size (.size()): " + fruits.size());
        System.out.println("Get Index 1 (.get()): " + fruits.get(1)); // "Banana"

        // .remove(): Element hatana
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);
        System.out.println();

        // ====================================================================
        // 2. HASHSET (Unique Elements Only, NO Duplicates)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Hashing algorithm use karta hai. Isme duplicate elements daalne par 
        // wo automatically ignore ho jate hain! Searching O(1) instant hoti hai.
        System.out.println("--- 2. HashSet<Integer> (Unique Values) ---");
        HashSet<Integer> uniqueUserIds = new HashSet<>();

        uniqueUserIds.add(101);
        uniqueUserIds.add(102);
        uniqueUserIds.add(103);
        uniqueUserIds.add(101); // Duplicate! Ignore ho jayega

        System.out.println("HashSet Elements (Duplicates automatically removed): " + uniqueUserIds);
        System.out.println("Contains 102? (.contains()) : " + uniqueUserIds.contains(102)); // true
        System.out.println("Contains 999? (.contains()) : " + uniqueUserIds.contains(999)); // false
        System.out.println();

        // ====================================================================
        // 3. HASHMAP (Key-Value Pairs: Dictionary / Phonebook)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Har data 'Key' aur 'Value' ke jode me store hota hai: HashMap<Key, Value>.
        // Rule: 'Key' hamesha UNIQUE honi chahiye, 'Value' duplicate ho sakti hai.
        System.out.println("--- 3. HashMap<String, Double> (Product -> Price) ---");
        HashMap<String, Double> productPrices = new HashMap<>();

        // .put(key, value): Data add karna
        productPrices.put("Laptop", 75000.0);
        productPrices.put("Smartphone", 25000.0);
        productPrices.put("Headphones", 3000.0);
        productPrices.put("Smartphone", 22000.0); // Duplicate Key! Purani price update ho jayegi (Overwrites)

        System.out.println("HashMap Data: " + productPrices);

        // .get(key): Key dekar Value nikalna (Super fast)
        System.out.println("Price of Laptop (.get(\"Laptop\")): Rs. " + productPrices.get("Laptop"));
        System.out.println("ContainsKey \"Tablet\"?             : " + productPrices.containsKey("Tablet")); // false

        // Looping over HashMap (entrySet)
        System.out.println("\n--> Looping over HashMap:");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.println("  Product: " + entry.getKey() + " -> Price: Rs. " + entry.getValue());
        }

        System.out.println("\n==================================================");
        System.out.println("        COLLECTIONS DEMO COMPLETED!               ");
        System.out.println("==================================================");
    }
}
