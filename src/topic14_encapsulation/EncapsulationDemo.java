package topic14_encapsulation;

/**
 * ============================================================================
 * TOPIC 14: ENCAPSULATION IN JAVA (DATA HIDING & PROTECTION)
 * ============================================================================
 * 
 * 📌 ENCAPSULATION KYA HAI?
 * - Data (Variables) aur uspar kaam karne wale Methods ko ek single "Capsule" 
 *   (Class) ke andar pack/bind karne ko Encapsulation kehte hain.
 * 
 * 📌 2 MAIN STEPS TO ACHIEVE ENCAPSULATION:
 * 1. Variables ko `private` banao (taaki bahar se koi direct modify na kar sake).
 * 2. Public `Getter` (data read karne ke liye) aur `Setter` (validation ke saath data update karne ke liye) methods banao.
 * 
 * 📌 FAAYDA (KYU ZAROORI HAI?):
 * - Agar variable `public` hoga, toh koi bhi `account.balance = -50000;` ya `user.age = -5;` kar dega.
 * - Setter method ke andar hum VALIDATION check lagate hain taaki galat data kabhi store na ho sake!
 */

// ----------------------------------------------------------------------------
// ENCAPSULATED CLASS: BankAccount
// ----------------------------------------------------------------------------
class SecureBankAccount {
    // 🔹 Step 1: Data Hiding (Private variables)
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public SecureBankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = holderName;
        setBalance(initialBalance); // Setter ke through safe initialization
    }

    // 🔹 Step 2: GETTERS (Read-Only Access)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // 🔹 Step 3: SETTERS (Controlled Write Access with Validation Rules)
    public void setAccountHolderName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.accountHolderName = newName;
            System.out.println("Holder name updated to: " + newName);
        } else {
            System.out.println("❌ Invalid Name! Name cannot be empty.");
        }
    }

    public void setBalance(double newBalance) {
        // Validation: Balance kabhi negative nahi ho sakta
        if (newBalance >= 0) {
            this.balance = newBalance;
        } else {
            System.out.println("❌ Security Alert: Balance cannot be negative! Operation blocked.");
        }
    }

    // Business Methods
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("✅ Deposited: Rs. " + amount + " | New Balance: Rs. " + this.balance);
        } else {
            System.out.println("❌ Deposit amount must be positive!");
        }
    }
}

// ----------------------------------------------------------------------------
// MAIN DEMO
// ----------------------------------------------------------------------------
public class EncapsulationDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       TOPIC 14: ENCAPSULATION COMPLETE DEMO      ");
        System.out.println("==================================================\n");

        SecureBankAccount myAcc = new SecureBankAccount("HDFC-7788", "Rohan Gupta", 5000.0);

        // 1. Reading Data safely via Getters:
        System.out.println("Account Number : " + myAcc.getAccountNumber());
        System.out.println("Account Holder : " + myAcc.getAccountHolderName());
        System.out.println("Initial Balance: Rs. " + myAcc.getBalance());
        System.out.println();

        // 2. Direct access blocked (Security):
        // myAcc.balance = -99999; // ❌ COMPILE ERROR! 'balance' has private access

        // 3. Testing Setter with INVALID Data (Validation will catch it):
        System.out.println("--- Testing Invalid Balance Update ---");
        myAcc.setBalance(-2000.0); // Blocked!
        System.out.println("Balance after invalid update: Rs. " + myAcc.getBalance() + " (Protected!)");
        System.out.println();

        // 4. Testing Setter with VALID Data:
        System.out.println("--- Testing Valid Updates ---");
        myAcc.deposit(3000.0);
        myAcc.setAccountHolderName("Rohan S. Gupta");

        System.out.println("\n==================================================");
        System.out.println("        ENCAPSULATION DEMO COMPLETED!             ");
        System.out.println("==================================================");
    }
}
