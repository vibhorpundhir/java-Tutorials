package topic07_methods;

/**
 * ============================================================================
 * TOPIC 07: METHODS & FUNCTIONS (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein Methods / Functions ke 5 essential practice problems hain.
 */
public class MethodsPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 07: METHODS PRACTICE QUESTIONS         ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Simple Interest & Total Amount Calculator
        // --------------------------------------------------------------------
        // Formula: SI = (P * R * T) / 100
        System.out.println("--- Question 1: Simple Interest Method ---");
        double principal = 10000;
        double rate = 7.5; // 7.5% per year
        double time = 3;   // 3 years

        double interest = calculateSimpleInterest(principal, rate, time);
        double totalRepayment = principal + interest;

        System.out.println("Principal : Rs. " + principal);
        System.out.println("Interest  : Rs. " + interest);
        System.out.println("Total Due : Rs. " + totalRepayment);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Palindrome Number Checker Method
        // --------------------------------------------------------------------
        // Problem: Ek method `isPalindrome(int num)` banao jo check kare 
        // kya number aage aur peeche se same hai (e.g. 121, 1331).
        System.out.println("--- Question 2: Palindrome Method ---");
        int testNum1 = 1221;
        int testNum2 = 1234;

        System.out.println("Is " + testNum1 + " Palindrome? : " + isPalindromeNumber(testNum1));
        System.out.println("Is " + testNum2 + " Palindrome? : " + isPalindromeNumber(testNum2));
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 3: Method Overloading for Geometry Area Calculator
        // --------------------------------------------------------------------
        // Overloaded methods:
        // 1. area(radius) -> Circle
        // 2. area(length, width) -> Rectangle
        // 3. area(base, height, isTriangle) -> Triangle
        System.out.println("--- Question 3: Overloaded Area Calculator ---");
        System.out.println("Circle Area (r = 5.0)              : " + String.format("%.2f", calculateArea(5.0)));
        System.out.println("Rectangle Area (l = 10, w = 5)     : " + calculateArea(10.0, 5.0));
        System.out.println("Triangle Area (b = 8, h = 6)       : " + calculateArea(8.0, 6.0, true));
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 4: Array Processing Method (Find Array Average)
        // --------------------------------------------------------------------
        // Problem: Array ko parameter ke roop mein accept karke uska average return karna.
        System.out.println("--- Question 4: Array Processor Method ---");
        int[] studentScores = { 78, 85, 92, 64, 89 };
        double classAvg = findArrayAverage(studentScores);
        System.out.println("Calculated Class Average : " + String.format("%.2f", classAvg));
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 5: Array Element Swapping Helper Method
        // --------------------------------------------------------------------
        // Primitives pass-by-value hote hain isliye direct swap nahi hote.
        // Par array pass karne par reference pass hota hai, isliye elements swap ho jate hain!
        System.out.println("--- Question 5: Array Swap Method ---");
        int[] pair = { 100, 200 };
        System.out.println("Before Swap : [" + pair[0] + ", " + pair[1] + "]");

        swapArrayElements(pair, 0, 1);

        System.out.println("After Swap  : [" + pair[0] + ", " + pair[1] + "]");

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }

    // ------------------------------------------------------------------------
    // HELPER METHODS:
    // ------------------------------------------------------------------------

    // Q1:
    public static double calculateSimpleInterest(double p, double r, double t) {
        return (p * r * t) / 100.0;
    }

    // Q2:
    public static boolean isPalindromeNumber(int num) {
        if (num < 0) return false; // Negative numbers cannot be palindromes
        int original = num;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = (reversed * 10) + digit;
            num /= 10;
        }
        return original == reversed;
    }

    // Q3 Overloaded Methods:
    // Circle Area: PI * r * r
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Rectangle Area: length * width
    public static double calculateArea(double length, double width) {
        return length * width;
    }

    // Triangle Area: 0.5 * base * height
    public static double calculateArea(double base, double height, boolean isTriangle) {
        return 0.5 * base * height;
    }

    // Q4:
    public static double findArrayAverage(int[] arr) {
        if (arr == null || arr.length == 0) return 0.0;
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return (double) sum / arr.length;
    }

    // Q5:
    public static void swapArrayElements(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
