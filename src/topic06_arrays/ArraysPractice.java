package topic06_arrays;

import java.util.Arrays;

/**
 * ============================================================================
 * TOPIC 06: ARRAYS (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein Array manipulation & looping ke 5 most popular interview questions hain.
 */
public class ArraysPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 06: ARRAYS PRACTICE QUESTIONS          ");
        System.out.println("==================================================\n");

        int[] dataset = { 24, 67, 12, 89, 45, 99, 31, 15 };
        System.out.println("Original Dataset: " + Arrays.toString(dataset) + "\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Find Maximum and Minimum Element in Array
        // --------------------------------------------------------------------
        // Problem: Array me se sabse bada (Max) aur sabse chota (Min) number nikalein.
        System.out.println("--- Question 1: Find Max and Min ---");
        int max = dataset[0];
        int min = dataset[0];

        for (int i = 1; i < dataset.length; i++) {
            if (dataset[i] > max) {
                max = dataset[i];
            }
            if (dataset[i] < min) {
                min = dataset[i];
            }
        }

        System.out.println("Maximum Element : " + max);
        System.out.println("Minimum Element : " + min);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Calculate Sum and Average of Elements
        // --------------------------------------------------------------------
        // Problem: Array ke saare elements ka Total Sum aur Exact Average nikalo.
        System.out.println("--- Question 2: Sum and Average ---");
        int totalSum = 0;

        for (int num : dataset) {
            totalSum += num;
        }

        double average = (double) totalSum / dataset.length;

        System.out.println("Total Sum : " + totalSum);
        System.out.println("Average   : " + String.format("%.2f", average));
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 3: Linear Search Algorithm
        // --------------------------------------------------------------------
        // Problem: Check karein kya target number 89 array me hai? Agar hai toh index batao.
        System.out.println("--- Question 3: Linear Search ---");
        int target = 89;
        int foundIndex = -1;

        for (int i = 0; i < dataset.length; i++) {
            if (dataset[i] == target) {
                foundIndex = i;
                break; // Milte hi loop band kar diya
            }
        }

        if (foundIndex != -1) {
            System.out.println("Target " + target + " found at Index: " + foundIndex);
        } else {
            System.out.println("Target " + target + " not found in array!");
        }
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 4: In-place Array Reversal (Two-Pointer Technique)
        // --------------------------------------------------------------------
        // Problem: Array ko bina koi naya array banaye usi array ke andar ulta (reverse) karo.
        // Logic: Left pointer index 0 par, Right pointer last index par. Swap karte jao!
        System.out.println("--- Question 4: In-Place Reverse (Two-Pointer) ---");
        int[] arrToReverse = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Before Reverse : " + Arrays.toString(arrToReverse));

        int left = 0;
        int right = arrToReverse.length - 1;

        while (left < right) {
            // Swap arrToReverse[left] and arrToReverse[right]
            int temp = arrToReverse[left];
            arrToReverse[left] = arrToReverse[right];
            arrToReverse[right] = temp;

            left++;
            right--;
        }

        System.out.println("After Reverse  : " + Arrays.toString(arrToReverse));
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 5: Count Even and Odd Numbers
        // --------------------------------------------------------------------
        // Problem: Array mein kitne Even aur kitne Odd numbers hain count karein.
        System.out.println("--- Question 5: Count Even and Odd ---");
        int evenCount = 0;
        int oddCount = 0;

        for (int val : dataset) {
            if (val % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even Numbers Count : " + evenCount);
        System.out.println("Odd Numbers Count  : " + oddCount);

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
