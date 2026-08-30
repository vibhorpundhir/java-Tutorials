package topic04_conditionals;

/**
 * ============================================================================
 * TOPIC 04: CONDITIONAL STATEMENTS (THEORY + STEP-BY-STEP WORKING)
 * ============================================================================
 * 
 * 📌 CONDITIONAL STATEMENTS KYA HOTE HAIN?
 * - Program ko conditions (sharton) ke basis par alag-alag decisions lene ke liye use hote hain.
 * - Jaise real life me: "Agar barish hui toh Chhata lo, nahi toh mat lo".
 * 
 * 📌 JAVA MEIN TYPES:
 * 1. if statement          -> Sirf tab chalta hai jab condition 'true' ho.
 * 2. if-else statement     -> Condition true ho toh 'if' block, false ho toh 'else' block.
 * 3. else-if ladder        -> Multiple conditions me se pehli matching condition execute hoti hai.
 * 4. Nested if-else        -> Ek if block ke andar doosra if block.
 * 5. switch-case statement -> Ek variable ki value ke hisaab se specific case execute karna.
 */
public class ConditionalsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TOPIC 04: CONDITIONAL STATEMENTS DEEP-DIVE     ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. SIMPLE 'if' STATEMENT
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Java brackets '(condition)' ke andar ki boolean value check karta hai.
        // Agar result 'true' aaya -> '{...}' block ke andar ka code chalega.
        // Agar result 'false' aaya -> Java is block ko skip karke aage badh jayega.
        System.out.println("--- 1. Simple 'if' Statement ---");
        int userAge = 20;

        if (userAge >= 18) {
            System.out.println("User is an Adult (Age: " + userAge + ")");
        }
        System.out.println();

        // ====================================================================
        // 2. 'if-else' STATEMENT (Binary Decision)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Agar condition TRUE hai -> 'if' block chalega aur 'else' chhod diya jayega.
        // Agar condition FALSE hai -> 'if' chhod diya jayega aur 'else' block chalega.
        System.out.println("--- 2. 'if-else' Statement ---");
        int number = 17;

        // number % 2 == 0 ka matlab: 2 se divide karne par remainder 0 bachta hai kya?
        if (number % 2 == 0) {
            System.out.println(number + " is an EVEN number.");
        } else {
            System.out.println(number + " is an ODD number.");
        }
        System.out.println();

        // ====================================================================
        // 3. 'else-if' LADDER (Multiple Sequential Checks)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Java upar se neeche ek-ek karke conditions check karta hai.
        // Jahan pehli condition TRUE mili, uska block run hoga aur Java BAAKI SAARI
        // conditions ko bina check kiye seedha LADDER SE BAHAR nikal jayega!
        // Agar koi bhi condition true nahi hui, toh aakhiri 'else' chalega.
        System.out.println("--- 3. 'else-if' Ladder ---");
        int marks = 82;

        if (marks >= 90) {
            System.out.println("Marks: " + marks + " -> Grade A+ (Outstanding)");
        } else if (marks >= 75) {
            // Ye tabhi chalega jab marks < 90 honge LEKIN >= 75 honge
            System.out.println("Marks: " + marks + " -> Grade A (Very Good)");
        } else if (marks >= 60) {
            System.out.println("Marks: " + marks + " -> Grade B (Good)");
        } else if (marks >= 33) {
            System.out.println("Marks: " + marks + " -> Grade C (Pass)");
        } else {
            System.out.println("Marks: " + marks + " -> Failed (Needs Improvement)");
        }
        System.out.println();

        // ====================================================================
        // 4. NESTED 'if-else' (Condition ke andar Condition)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Pehle bahar wala 'if' check hota hai. Jab tak bahar wala true na ho,
        // tab tak Java andar wale 'if' tak pahuch hi nahi sakta.
        System.out.println("--- 4. Nested 'if-else' ---");
        boolean hasPassport = true;
        boolean hasVisa = true;
        int luggageWeight = 22; // In Kg (Max allowed: 25Kg)

        if (hasPassport) {
            System.out.println("Step 1 Passed: Passport verified.");

            if (hasVisa) {
                System.out.println("Step 2 Passed: Visa verified.");

                if (luggageWeight <= 25) {
                    System.out.println("Step 3 Passed: Luggage weight is within limit. Boarding Allowed! ✈️");
                } else {
                    System.out.println("Step 3 Failed: Overweight luggage! Pay extra fee.");
                }
            } else {
                System.out.println("Step 2 Failed: Visa missing! Boarding Denied.");
            }
        } else {
            System.out.println("Step 1 Failed: Passport missing! Entry Denied.");
        }
        System.out.println();

        // ====================================================================
        // 5. 'switch-case' STATEMENT (Traditional with break & default)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // 1. switch(variable) us variable ki value match karta hai har 'case' se.
        // 2. Matching case milte hi uska code run hota hai.
        // 3. 'break' statement: Switch se bahar nikalne ke liye lagaya jata hai.
        //    IMPORTANT: Agar 'break' nahi lagayenge toh Java agle saare cases ko 
        //    bina check kiye execute kar dega (jisko 'Fall-Through' kehte hain!).
        // 4. 'default': Agar koi bhi case match na kare, toh default block chalega.
        System.out.println("--- 5. Traditional 'switch-case' ---");
        int dayNumber = 3; // 1 = Mon, 2 = Tue, 3 = Wed...

        switch (dayNumber) {
            case 1:
                System.out.println("Day 1: Monday (Week start)");
                break;
            case 2:
                System.out.println("Day 2: Tuesday");
                break;
            case 3:
                System.out.println("Day 3: Wednesday (Mid-week)");
                break;
            case 4:
                System.out.println("Day 4: Thursday");
                break;
            case 5:
                System.out.println("Day 5: Friday (Weekend loading...)");
                break;
            case 6:
            case 7: // Multiple cases ek sath (Grouping)
                System.out.println("Weekend! (Saturday / Sunday) 🎉");
                break;
            default:
                System.out.println("Invalid day number! Please enter 1 to 7.");
        }
        System.out.println();

        // ====================================================================
        // 6. ENHANCED SWITCH (Modern Java 14+ Arrow Syntax '->')
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Isme 'break' lagane ki zaroorat NAHI padti (Fall-through ka risk 0 ho jata hai).
        // Syntax clean aur readable hota hai.
        System.out.println("--- 6. Modern Enhanced Switch (Arrow Syntax) ---");
        String role = "ADMIN";

        switch (role) {
            case "ADMIN" -> System.out.println("Access: Full System Control & Settings");
            case "EDITOR" -> System.out.println("Access: Can Edit and Publish Articles");
            case "VIEWER" -> System.out.println("Access: Read-only Mode");
            default -> System.out.println("Access: Unknown Role!");
        }

        System.out.println("\n==================================================");
        System.out.println("        CONDITIONALS DEMO COMPLETED!              ");
        System.out.println("==================================================");
    }
}
