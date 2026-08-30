package topic21_threads;

/**
 * ============================================================================
 * TOPIC 21: JAVA THREADS (PRACTICE QUESTIONS)
 * ============================================================================
 */

// Thread-safe ATM Account balance
class BankATM {
    private double balance = 10000.0;

    public synchronized void withdraw(String personName, double amount) {
        System.out.println("💳 " + personName + " trying to withdraw Rs. " + amount);
        if (amount <= balance) {
            try { Thread.sleep(200); } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println("✅ " + personName + " withdrawal SUCCESS! Remaining: Rs. " + balance);
        } else {
            System.out.println("❌ " + personName + " withdrawal FAILED: Insufficient Funds!");
        }
    }
}

public class ThreadsPractice {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================================================");
        System.out.println("        TOPIC 21: THREADS PRACTICE                ");
        System.out.println("==================================================\n");

        BankATM atm = new BankATM();

        // 2 log ek sath same ATM account se withdraw karne ki koshish kar rahe hain
        Thread userA = new Thread(() -> atm.withdraw("Rahul", 7000.0));
        Thread userB = new Thread(() -> atm.withdraw("Pooja", 5000.0));

        userA.start();
        userB.start();

        userA.join();
        userB.join();

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
