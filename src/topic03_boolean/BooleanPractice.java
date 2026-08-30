package topic03_boolean;

/**
 * ============================================================================
 * TOPIC 03: BOOLEAN (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein Boolean & Logical Operators ke 5 real-world practice questions hain.
 */
public class BooleanPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       TOPIC 03: BOOLEAN PRACTICE QUESTIONS       ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Driving Eligibility Checker
        // --------------------------------------------------------------------
        // Problem: Check karein kya user drive kar sakta hai:
        // Conditions: Age 18 ya usse zyada honi chahiye AND Valid License hona chahiye.
        System.out.println("--- Question 1: Driving Eligibility ---");
        int userAge = 21;
        boolean hasLicense = true;

        boolean canDrive = (userAge >= 18) && hasLicense;
        System.out.println("Age: " + userAge + ", Has License: " + hasLicense);
        System.out.println("Is user allowed to drive? : " + canDrive);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Leap Year Logic (Classic Problem)
        // --------------------------------------------------------------------
        // Problem: Ek saal Leap Year hai ya nahi check karein:
        // Rule: (Year 4 se divide ho AND 100 se divide NA ho) YA (400 se divide ho).
        System.out.println("--- Question 2: Leap Year Checker ---");
        int year = 2024;

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("Year " + year + " is Leap Year? : " + isLeapYear);

        int nonLeapYear = 2023;
        boolean isLeap2023 = (nonLeapYear % 4 == 0 && nonLeapYear % 100 != 0) || (nonLeapYear % 400 == 0);
        System.out.println("Year " + nonLeapYear + " is Leap Year? : " + isLeap2023);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 3: E-Commerce Free Delivery & Discount Check
        // --------------------------------------------------------------------
        // Problem: Customer ko Free Delivery milegi agar:
        // Cart Value >= 499 ho YA fir customer "Prime Member" ho.
        System.out.println("--- Question 3: Free Delivery Qualifier ---");
        double cartAmount = 350.0;
        boolean isPrimeMember = true;

        boolean getsFreeDelivery = (cartAmount >= 499.0) || isPrimeMember;
        System.out.println("Cart Amount: Rs. " + cartAmount + ", Prime Member: " + isPrimeMember);
        System.out.println("Eligible for Free Delivery? : " + getsFreeDelivery);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 4: Simple Password Length & Digit Checker
        // --------------------------------------------------------------------
        // Problem: Password valid tabhi hoga jab length >= 8 ho AUR usme koi digit ho.
        System.out.println("--- Question 4: Password Rule Checker ---");
        String password = "JavaCoder2026";

        boolean isLengthValid = password.length() >= 8;
        boolean hasDigit = password.matches(".*\\d.*"); // Regular expression check for any digit (0-9)
        boolean isPasswordStrong = isLengthValid && hasDigit;

        System.out.println("Password: \"" + password + "\"");
        System.out.println("Length >= 8 ? : " + isLengthValid);
        System.out.println("Contains digit? : " + hasDigit);
        System.out.println("Is Password Valid? : " + isPasswordStrong);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 5: Ternary Operator for Multi-Level Status
        // --------------------------------------------------------------------
        // Problem: Score ke basis par status determine karein:
        // Score >= 90 -> "Distinction", Score >= 40 -> "Pass", Else -> "Fail".
        System.out.println("--- Question 5: Grade Determination using Ternary ---");
        int studentMarks = 92;

        String grade = (studentMarks >= 90) ? "Distinction" 
                     : (studentMarks >= 40) ? "Pass" 
                     : "Fail";

        System.out.println("Student Marks : " + studentMarks);
        System.out.println("Final Grade   : " + grade);

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
