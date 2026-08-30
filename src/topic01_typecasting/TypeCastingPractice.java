package topic01_typecasting;

/**
 * ============================================================================
 * TOPIC 01: TYPE CASTING (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein 5 real-world practice questions hain jisse concept crystal clear ho jaye.
 */
public class TypeCastingPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TOPIC 01: TYPE CASTING PRACTICE QUESTIONS      ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Grocery Bill Round-off (Double to Int Conversion)
        // --------------------------------------------------------------------
        // Problem: Ek customer ka total bill 457.85 rupees hai. 
        // 1. Bill amount ko nearest int mein truncate (round-down) karein.
        // 2. Kitne paise ka decimal difference aaya wo calculate karke print karein.
        System.out.println("--- Question 1: Bill Round-off ---");
        double exactBill = 457.85;
        int cashPaid = (int) exactBill; // Narrowing casting
        double changeDifference = exactBill - cashPaid;

        System.out.println("Original Bill     : Rs. " + exactBill);
        System.out.println("Cash Paid (Int)   : Rs. " + cashPaid);
        System.out.println("Difference (Lost) : Rs. " + String.format("%.2f", changeDifference));
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Next Character Finder (Char & ASCII Math)
        // --------------------------------------------------------------------
        // Problem: Diye gaye char 'C' ka agla alphabet character nikalo bina direct 'D' likhe.
        // Logic: 'C' ki ASCII value mein 1 add karo, phir result ko (char) mein cast karo.
        System.out.println("--- Question 2: Next Character Finder ---");
        char currentChar = 'C';
        int nextAscii = currentChar + 1;       // Automatic type promotion to int
        char nextChar = (char) nextAscii;      // Explicit cast back to char

        System.out.println("Current Character : " + currentChar + " (ASCII: " + (int) currentChar + ")");
        System.out.println("Next Character    : " + nextChar + " (ASCII: " + nextAscii + ")");
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 3: Byte Overflow Behavior
        // --------------------------------------------------------------------
        // Problem: Byte ki maximum limit 127 hoti hai. 
        // Agar hum int value 130 ko byte mein cast karein toh kya result aayega aur kyu?
        System.out.println("--- Question 3: Byte Overflow Demonstration ---");
        int originalValue = 130;
        byte castedByte = (byte) originalValue;

        System.out.println("Int Value         : " + originalValue);
        System.out.println("Byte Cast Result  : " + castedByte);
        System.out.println("Explanation       : Byte range is -128 to 127. 130 wraps around to -126!");
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 4: String Parsing & Arithmetic
        // --------------------------------------------------------------------
        // Problem: User se do input strings aayi hain: "120" aur "80".
        // Dono ko add karke sum nikalo, aur phir sum ko wapas String banao.
        System.out.println("--- Question 4: String Parsing ---");
        String input1 = "120";
        String input2 = "80";

        // Direct string addition would give "12080" (concatenation)
        // Isliye pehle numbers mein parse karenge:
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);
        int totalSum = num1 + num2;

        String resultString = "Total: " + totalSum; // String conversion
        System.out.println("String input addition : " + input1 + " + " + input2 + " = " + totalSum);
        System.out.println("Final Result String   : \"" + resultString + "\"");
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 5: Average Calculation with Double Precision
        // --------------------------------------------------------------------
        // Problem: 3 subjects ke marks diye hain (int): 85, 90, 82.
        // Unka exact decimal average nikalo (without integer division bug).
        System.out.println("--- Question 5: Exact Average Calculation ---");
        int m1 = 85, m2 = 90, m3 = 82;
        int totalMarks = m1 + m2 + m3; // 257

        // TRICK: Agar (totalMarks / 3) karenge toh 85.0 aayega (int division).
        // Isliye 3.0 (double) se divide karein ya (double) cast lagayein:
        double wrongAvg = totalMarks / 3;          // Bug: 85.0
        double correctAvg = (double) totalMarks / 3; // Correct: 85.6666...

        System.out.println("Total Marks (257) : " + totalMarks);
        System.out.println("Wrong Avg (int / 3)       : " + wrongAvg);
        System.out.println("Correct Avg ((double)/3)  : " + String.format("%.2f", correctAvg));

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
