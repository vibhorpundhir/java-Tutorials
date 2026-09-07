package topic25_jdbc_sql;

import java.util.*;

/**
 * ============================================================================
 * TOPIC 25: JDBC PRACTICE - BANK ACCOUNT DAO MANAGEMENT SYSTEM
 * ============================================================================
 * 
 * In real-world enterprise applications, Database operations are structured
 * using the DAO (Data Access Object) Pattern to separate business logic
 * from database queries.
 * 
 * CHALLENGES INCLUDED:
 * 1. Account Model & DAO Interface (CRUD Operations).
 * 2. PreparedStatement-based Query Execution.
 * 3. Atomic Fund Transfer with Transaction Rollback on failure.
 */

// Model Entity
class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return String.format("Acc #[%d] | Holder: %-15s | Balance: $%,10.2f", 
            accountNumber, holderName, balance);
    }
}

// DAO Pattern Implementation
class BankAccountDAO {
    private final Map<Integer, BankAccount> databaseTable = new HashMap<>();

    public BankAccountDAO() {
        // Seed initial records
        databaseTable.put(1001, new BankAccount(1001, "Vibhor Pundhir", 15000.00));
        databaseTable.put(1002, new BankAccount(1002, "Amit Roy", 8500.00));
        databaseTable.put(1003, new BankAccount(1003, "Sneha Kapoor", 24000.00));
    }

    // CREATE: INSERT INTO accounts (account_number, holder_name, balance) VALUES (?, ?, ?)
    public boolean createAccount(BankAccount account) {
        if (databaseTable.containsKey(account.getAccountNumber())) {
            System.out.println("❌ Error: Account number already exists!");
            return false;
        }
        databaseTable.put(account.getAccountNumber(), account);
        System.out.println("✔ [INSERT] Account created successfully for: " + account.getHolderName());
        return true;
    }

    // READ: SELECT * FROM accounts WHERE account_number = ?
    public Optional<BankAccount> getAccount(int accNo) {
        return Optional.ofNullable(databaseTable.get(accNo));
    }

    // READ ALL: SELECT * FROM accounts
    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(databaseTable.values());
    }

    // UPDATE: UPDATE accounts SET balance = ? WHERE account_number = ?
    public boolean updateBalance(int accNo, double newBalance) {
        BankAccount acc = databaseTable.get(accNo);
        if (acc != null) {
            acc.setBalance(newBalance);
            return true;
        }
        return false;
    }

    // DELETE: DELETE FROM accounts WHERE account_number = ?
    public boolean deleteAccount(int accNo) {
        BankAccount removed = databaseTable.remove(accNo);
        if (removed != null) {
            System.out.println("✔ [DELETE] Account #" + accNo + " closed successfully.");
            return true;
        }
        System.out.println("❌ Error: Account not found for deletion.");
        return false;
    }

    // TRANSACTION: Atomic Fund Transfer (ACID Compliance)
    public boolean transferFunds(int fromAccNo, int toAccNo, double amount) {
        System.out.println(String.format("\n--> Initiating Transfer: $%,.2f from #%d to #%d",
            amount, fromAccNo, toAccNo));

        BankAccount fromAcc = databaseTable.get(fromAccNo);
        BankAccount toAcc = databaseTable.get(toAccNo);

        // Transaction validation
        if (fromAcc == null || toAcc == null) {
            System.out.println("❌ TRANSACTION FAILED: One or both accounts do not exist! (Rolling back)");
            return false;
        }

        if (fromAcc.getBalance() < amount) {
            System.out.println(String.format(
                "❌ TRANSACTION FAILED: Insufficient balance! (Has: $%,.2f, Needs: $%,.2f) -> ROLLBACK",
                fromAcc.getBalance(), amount));
            return false;
        }

        // Simulate atomic debit & credit
        double originalFromBalance = fromAcc.getBalance();
        double originalToBalance = toAcc.getBalance();

        try {
            fromAcc.setBalance(originalFromBalance - amount); // Debit
            toAcc.setBalance(originalToBalance + amount);     // Credit
            System.out.println("✔ TRANSACTION COMMITTED: $ " + amount + " transferred successfully!");
            return true;
        } catch (Exception e) {
            // Rollback state in case of any failure
            fromAcc.setBalance(originalFromBalance);
            toAcc.setBalance(originalToBalance);
            System.out.println("❌ TRANSACTION ERROR: Rolled back state safely.");
            return false;
        }
    }
}

public class JdbcPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 25: JDBC BANK DAO PRACTICE LAB         ");
        System.out.println("==================================================\n");

        BankAccountDAO dao = new BankAccountDAO();

        // 1. READ ALL ACCOUNTS
        System.out.println("--- 1. Initial Accounts List ---");
        dao.getAllAccounts().forEach(acc -> System.out.println("  • " + acc));
        System.out.println();

        // 2. CREATE NEW ACCOUNT (INSERT)
        System.out.println("--- 2. Creating New Account ---");
        dao.createAccount(new BankAccount(1004, "Pooja Sharma", 12000.00));
        System.out.println();

        // 3. ATOMIC TRANSACTION: VALID TRANSFER
        System.out.println("--- 3. Successful Atomic Transfer (ACID) ---");
        dao.transferFunds(1001, 1002, 3000.00);
        System.out.println("Updated Accounts:");
        dao.getAccount(1001).ifPresent(a -> System.out.println("  • " + a));
        dao.getAccount(1002).ifPresent(a -> System.out.println("  • " + a));
        System.out.println();

        // 4. ATOMIC TRANSACTION: INSUFFICIENT BALANCE (SAFE ROLLBACK)
        System.out.println("--- 4. Failed Transfer Simulation (Rollback Triggered) ---");
        dao.transferFunds(1002, 1001, 50000.00); // Exceeds balance!
        System.out.println();

        // 5. DELETE ACCOUNT
        System.out.println("--- 5. Closing Account ---");
        dao.deleteAccount(1003);
        System.out.println();

        // Final Summary
        System.out.println("--- Final Database State ---");
        dao.getAllAccounts().forEach(acc -> System.out.println("  • " + acc));

        System.out.println("\n==================================================");
        System.out.println("       JDBC PRACTICE COMPLETED SUCCESSFULLY!      ");
        System.out.println("==================================================");
    }
}
