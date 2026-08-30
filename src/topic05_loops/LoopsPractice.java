package topic05_loops;

/**
 * ============================================================================
 * TOPIC 05: LOOPING STATEMENTS (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein Loops ke 5 classic interview & logic-building coding problems hain.
 */
public class LoopsPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 05: LOOPS PRACTICE QUESTIONS           ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Factorial of a Number using 'for' loop
        // --------------------------------------------------------------------
        // Problem: 5 ka Factorial nikalo (5! = 5 * 4 * 3 * 2 * 1 = 120).
        System.out.println("--- Question 1: Factorial of a Number ---");
        int n = 5;
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }

        System.out.println("Factorial of " + n + "! = " + factorial);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Reverse an Integer Number using 'while' loop
        // --------------------------------------------------------------------
        // Problem: Diye gaye number 12345 ko ulta (54321) karo.
        // Logic:
        // 1. Last digit nikalne ke liye: num % 10
        // 2. Reverse me jodte jao: rev = (rev * 10) + digit
        // 3. Last digit hatane ke liye: num = num / 10
        System.out.println("--- Question 2: Reverse a Number ---");
        int originalNum = 12345;
        int temp = originalNum;
        int reversedNum = 0;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversedNum = (reversedNum * 10) + lastDigit;
            temp = temp / 10; // Number ko chota karte jao
        }

        System.out.println("Original Number : " + originalNum);
        System.out.println("Reversed Number : " + reversedNum);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 3: Sum of Digits of a Number
        // --------------------------------------------------------------------
        // Problem: Number 456 ke saare digits ka sum nikalo (4 + 5 + 6 = 15).
        System.out.println("--- Question 3: Sum of Digits ---");
        int targetNumber = 456;
        int numCopy = targetNumber;
        int sumOfDigits = 0;

        while (numCopy > 0) {
            int digit = numCopy % 10; // Last digit nikalo
            sumOfDigits += digit;     // Sum me add karo
            numCopy /= 10;            // Last digit remove karo
        }

        System.out.println("Number : " + targetNumber);
        System.out.println("Sum of Digits (4 + 5 + 6) = " + sumOfDigits);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 4: Prime Number Checker
        // --------------------------------------------------------------------
        // Problem: Check karo kya 29 ek Prime Number hai ya nahi.
        // Rule: Prime number sirf 1 aur khud se divide hota hai.
        System.out.println("--- Question 4: Prime Number Checker ---");
        int checkNum = 29;
        boolean isPrime = true;

        if (checkNum <= 1) {
            isPrime = false;
        } else {
            // 2 se lekar number ke aadhe (checkNum / 2) tak check karenge
            for (int i = 2; i <= checkNum / 2; i++) {
                if (checkNum % i == 0) {
                    isPrime = false;
                    break; // Agar kisi se divide ho gaya toh loop aage chalane ki zaroorat nahi
                }
            }
        }

        System.out.println("Is " + checkNum + " a Prime Number? : " + isPrime);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 5: Right-Angled Triangle Star Pattern using Nested Loops
        // --------------------------------------------------------------------
        // Problem: 4 rows ka star triangle print karein:
        // *
        // * *
        // * * *
        // * * * *
        System.out.println("--- Question 5: Star Pattern Printing ---");
        int rows = 4;

        for (int i = 1; i <= rows; i++) {
            // Har row me 'i' number of stars print honge
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(); // Next line
        }

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
