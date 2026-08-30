package topic04_conditionals;

/**
 * ============================================================================
 * TOPIC 04: CONDITIONAL STATEMENTS (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein real-world decision making ke 5 practice questions hain.
 */
public class ConditionalsPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TOPIC 04: CONDITIONALS PRACTICE QUESTIONS      ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Electricity Bill Calculation (Slab-wise pricing)
        // --------------------------------------------------------------------
        // Problem: Monthly units consumed ke hisaab se total bill nikalo:
        // - Pehle 100 units  : Rs. 5.0 per unit
        // - Agle 100 units (101-200) : Rs. 7.0 per unit
        // - 200 units ke upar : Rs. 10.0 per unit
        System.out.println("--- Question 1: Electricity Bill Slab ---");
        int units = 250;
        double totalBill = 0;

        if (units <= 100) {
            totalBill = units * 5.0;
        } else if (units <= 200) {
            totalBill = (100 * 5.0) + ((units - 100) * 7.0);
        } else {
            totalBill = (100 * 5.0) + (100 * 7.0) + ((units - 200) * 10.0);
        }

        System.out.println("Units Consumed : " + units);
        System.out.println("Total Bill     : Rs. " + totalBill);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: ATM Cash Withdrawal Simulation (Nested if-else)
        // --------------------------------------------------------------------
        // Problem: User ATM se 4000 rupees nikalna chahta hai:
        // Conditions: Correct PIN (1234), Account Balance >= Amount, Amount multiple of 100.
        System.out.println("--- Question 2: ATM Cash Withdrawal ---");
        int enteredPin = 1234;
        int correctPin = 1234;
        double accountBalance = 10000.0;
        double withdrawAmount = 4000.0;

        if (enteredPin == correctPin) {
            if (withdrawAmount <= accountBalance) {
                if (withdrawAmount % 100 == 0) {
                    accountBalance -= withdrawAmount;
                    System.out.println("Transaction Successful! Please collect cash: Rs. " + withdrawAmount);
                    System.out.println("Remaining Balance: Rs. " + accountBalance);
                } else {
                    System.out.println("Error: Amount must be a multiple of 100!");
                }
            } else {
                System.out.println("Error: Insufficient Balance!");
            }
        } else {
            System.out.println("Error: Incorrect PIN!");
        }
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 3: Simple Calculator using Switch-Case
        // --------------------------------------------------------------------
        // Problem: Do numbers (a = 20, b = 4) aur ek operator ('*') par calculation perform karein.
        // Also handle divide by zero condition for '/'.
        System.out.println("--- Question 3: Calculator with Switch-Case ---");
        double a = 20;
        double b = 4;
        char operator = '*';

        switch (operator) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '/':
                if (b != 0) {
                    System.out.println(a + " / " + b + " = " + (a / b));
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                }
                break;
            default:
                System.out.println("Invalid Operator!");
        }
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 4: Triangle Type Classifier
        // --------------------------------------------------------------------
        // Problem: 3 sides ke basis par triangle classify karein:
        // - Equilateral : Teeno sides barabar (s1 == s2 && s2 == s3)
        // - Isosceles   : Koi bhi 2 sides barabar (s1==s2 || s2==s3 || s1==s3)
        // - Scalene     : Teeno sides alag-alag
        System.out.println("--- Question 4: Triangle Classifier ---");
        int side1 = 7, side2 = 7, side3 = 10;

        if (side1 == side2 && side2 == side3) {
            System.out.println("Sides (" + side1 + "," + side2 + "," + side3 + ") -> Equilateral Triangle");
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            System.out.println("Sides (" + side1 + "," + side2 + "," + side3 + ") -> Isosceles Triangle (Do side barabar)");
        } else {
            System.out.println("Sides (" + side1 + "," + side2 + "," + side3 + ") -> Scalene Triangle (Teeno alag)");
        }
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 5: Largest of Three Numbers
        // --------------------------------------------------------------------
        // Problem: 3 numbers me se sabse bada number nikalo using else-if.
        System.out.println("--- Question 5: Largest of Three Numbers ---");
        int n1 = 45, n2 = 89, n3 = 62;
        int largest;

        if (n1 >= n2 && n1 >= n3) {
            largest = n1;
        } else if (n2 >= n1 && n2 >= n3) {
            largest = n2;
        } else {
            largest = n3;
        }

        System.out.println("Numbers: " + n1 + ", " + n2 + ", " + n3);
        System.out.println("Largest Number is : " + largest);

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
