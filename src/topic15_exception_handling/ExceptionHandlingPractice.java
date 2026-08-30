package topic15_exception_handling;

/**
 * ============================================================================
 * TOPIC 15: EXCEPTION HANDLING (PRACTICE QUESTIONS)
 * ============================================================================
 */

// Custom Exception for Banking
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccountWithException {
    private double balance;

    public BankAccountWithException(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Transaction Failed: Required Rs. " + amount + ", but Available Balance is only Rs. " + balance);
        }
        balance -= amount;
        System.out.println("✅ Withdrawn: Rs. " + amount + " | Remaining Balance: Rs. " + balance);
    }
}

public class ExceptionHandlingPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 15: EXCEPTION HANDLING PRACTICE        ");
        System.out.println("==================================================\n");

        // 1. Testing Bank Withdrawal Custom Exception
        System.out.println("--- 1. Testing Bank Custom Exception ---");
        BankAccountWithException acc = new BankAccountWithException(5000.0);

        try {
            acc.withdraw(2000.0); // Success
            acc.withdraw(8000.0); // Will trigger InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("⚠️ Alert: " + e.getMessage());
        }
        System.out.println();

        // 2. Testing NumberFormatException (Safe String Parsing)
        System.out.println("--- 2. Safe Parsing from String ---");
        String userInput = "123abc"; // Corrupted integer string

        try {
            int parsed = Integer.parseInt(userInput);
            System.out.println("Parsed: " + parsed);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Number Format Error: \"" + userInput + "\" is not a valid number! Defaulting to 0.");
        }

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
