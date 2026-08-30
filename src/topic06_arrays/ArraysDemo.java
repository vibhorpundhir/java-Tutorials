package topic06_arrays;

import java.util.Arrays;

/**
 * ============================================================================
 * TOPIC 06: ARRAYS & ARRAY LOOPING (THEORY + STEP-BY-STEP WORKING)
 * ============================================================================
 * 
 * 📌 ARRAY KYA HOTA HAI?
 * - Array ek same data type ke multiple elements ka fixed-size collection hota hai.
 * - For example: 50 students ke marks store karne ke liye 50 alag variables 
 *   (m1, m2, m3...) banane ke bajaye hum ek single `int[] marks = new int[50];` banate hain.
 * 
 * 📌 ARRAY KI KHAAS BAATEIN:
 * 1. Fixed Size: Array banne ke baad uski size badal nahi sakti.
 * 2. 0-based Indexing: Pehla element `arr[0]` par aur aakhiri `arr[arr.length - 1]` par hota hai.
 * 3. Contiguous Memory: Heap memory mein lagataar blocks mein store hota hai.
 * 4. Default Values: int array me shuru me sab '0', boolean me 'false', objects me 'null' hota hai.
 */
public class ArraysDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TOPIC 06: ARRAYS & ARRAY LOOPING DEEP-DIVE     ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. ARRAY CREATION KE 2 TARIQE
        // ====================================================================
        System.out.println("--- 1. Array Creation & Default Values ---");

        // Tareeqa 1: Size specify karke (Jab values baad me daalni ho)
        // Memory me 4 integer blocks banenge, sabme default '0' hoga
        int[] scores = new int[4];
        scores[0] = 95; // Index 0 par 95 daala
        scores[1] = 88; // Index 1 par 88 daala
        scores[2] = 72;
        scores[3] = 90;

        // Tareeqa 2: Array Literal (Direct values daal kar initialize karna)
        int[] numbers = { 10, 20, 30, 40, 50 };

        System.out.println("scores[0] : " + scores[0]);
        System.out.println("Array Length (.length property) : " + numbers.length + " elements");
        System.out.println("Arrays.toString(numbers)        : " + Arrays.toString(numbers));
        System.out.println();

        // ====================================================================
        // 2. ARRAY LOOPING / TRAVERSAL KE TARIQE (HOW TO LOOP OVER ARRAYS)
        // ====================================================================
        System.out.println("--- 2. Looping Through Arrays ---");

        String[] supercars = { "Ferrari", "Lamborghini", "Porsche", "McLaren" };

        // 🔹 Method A: Traditional 'for' Loop (Index ke saath)
        // KAISE KAAM KARTA HAI:
        // 'i' 0 se lekar supercars.length - 1 tak jata hai.
        // Jab hume index number bhi chahiye ho (e.g. "Rank 1: Ferrari"), tab ye best hai.
        System.out.println("--> Method A: Standard 'for' Loop:");
        for (int i = 0; i < supercars.length; i++) {
            System.out.println("  Index [" + i + "] = " + supercars[i]);
        }
        System.out.println();

        // 🔹 Method B: Enhanced 'for-each' Loop (Modern & Cleanest)
        // KAISE KAAM KARTA HAI:
        // Syntax: for (DataType item : arrayName)
        // Java internally array ke har ek element ko ek-ek karke 'car' variable me daalta hai.
        // Isme index manage karne ki zaroorat nahi hoti, loop kabhi out of bounds nahi ja sakta!
        System.out.println("--> Method B: Enhanced 'for-each' Loop:");
        for (String car : supercars) {
            System.out.println("  Car: " + car);
        }
        System.out.println();

        // 🔹 Method C: Reverse Traversal (Aakhiri se Pehle tak)
        // KAISE KAAM KARTA HAI:
        // Index 'supercars.length - 1' (last element) se shuru karke index '0' tak decrease karte hain.
        System.out.println("--> Method C: Reverse Looping:");
        for (int i = supercars.length - 1; i >= 0; i--) {
            System.out.println("  Backwards [" + i + "] = " + supercars[i]);
        }
        System.out.println();

        // ====================================================================
        // 3. 2D ARRAYS (MATRIX / GRID) & NESTED LOOPING
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // 2D Array asal mein "Arrays ka Array" hota hai (Rows aur Columns).
        // matrix[row][col] se access karte hain.
        // Outer loop har Row par chalta hai, Inner loop us Row ke Columns par chalta hai.
        System.out.println("--- 3. 2D Array (Matrix) Looping ---");

        int[][] matrix = {
            { 1, 2, 3 },  // Row 0
            { 4, 5, 6 },  // Row 1
            { 7, 8, 9 }   // Row 2
        };

        System.out.println("2D Matrix Elements:");
        for (int r = 0; r < matrix.length; r++) { // matrix.length = total rows (3)
            for (int c = 0; c < matrix[r].length; c++) { // matrix[r].length = total columns in that row (3)
                System.out.print(matrix[r][c] + "\t");
            }
            System.out.println(); // Har row ke baad new line
        }
        System.out.println();

        // ====================================================================
        // 4. COMMON MISTAKE: ArrayIndexOutOfBoundsException
        // ====================================================================
        // KAISE CRASH HOTA HAI:
        // Agar array ki length 4 hai, toh valid indices sirf 0, 1, 2, 3 hain.
        // Agar aap arr[4] access karenge, toh program crash ho jayega!
        System.out.println("--- 4. Array Safety Check ---");
        int[] sample = { 100, 200, 300 };
        int requestedIndex = 3; // Invalid! Max valid index is 2

        if (requestedIndex >= 0 && requestedIndex < sample.length) {
            System.out.println("Element: " + sample[requestedIndex]);
        } else {
            System.out.println("Safety Check: Index " + requestedIndex + " out of bounds! Valid range is 0 to " + (sample.length - 1));
        }
        System.out.println();

        // ====================================================================
        // 5. HELPFUL UTILITY METHODS (java.util.Arrays)
        // ====================================================================
        System.out.println("--- 5. Arrays Utility Methods ---");
        int[] unSorted = { 45, 12, 85, 32, 8 };
        System.out.println("Before Sort : " + Arrays.toString(unSorted));

        // Arrays.sort() internally Dual-Pivot Quicksort use karta hai
        Arrays.sort(unSorted);
        System.out.println("After Sort  : " + Arrays.toString(unSorted));

        // Binary Search: Sorted array me element dhundna
        int foundIndex = Arrays.binarySearch(unSorted, 32);
        System.out.println("Element 32 found at index: " + foundIndex);

        System.out.println("\n==================================================");
        System.out.println("           ARRAYS DEMO COMPLETED!                 ");
        System.out.println("==================================================");
    }
}
