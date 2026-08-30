package topic11_inheritance;

/**
 * ============================================================================
 * TOPIC 11: INHERITANCE (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein Inheritance ke 5 standard industry-level coding questions hain.
 */

// ----------------------------------------------------------------------------
// PROBLEM 1: Employee Payroll Multilevel Hierarchy
// ----------------------------------------------------------------------------
class BaseEmployee {
    protected int id;
    protected String name;
    protected double baseSalary;

    public BaseEmployee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateMonthlyPay() {
        return baseSalary;
    }

    public void printPaySlip() {
        System.out.println("Employee #" + id + " [" + name + "] Net Pay: Rs. " + calculateMonthlyPay());
    }
}

class Manager extends BaseEmployee {
    protected double teamManagementBonus;

    public Manager(int id, String name, double baseSalary, double teamBonus) {
        super(id, name, baseSalary);
        this.teamManagementBonus = teamBonus;
    }

    @Override
    public double calculateMonthlyPay() {
        // Parent salary + bonus
        return super.calculateMonthlyPay() + teamManagementBonus;
    }
}

class Director extends Manager {
    private double companyStockOptionProfit;

    public Director(int id, String name, double baseSalary, double teamBonus, double stockProfit) {
        super(id, name, baseSalary, teamBonus);
        this.companyStockOptionProfit = stockProfit;
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + companyStockOptionProfit;
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 2: Banking Account Inheritance (Savings vs Current)
// ----------------------------------------------------------------------------
class Account {
    protected String accNo;
    protected double balance;

    public Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs. " + amount + " in " + accNo);
    }
}

class SavingsAccount extends Account {
    private double annualInterestRate;

    public SavingsAccount(String accNo, double balance, double interestRate) {
        super(accNo, balance);
        this.annualInterestRate = interestRate;
    }

    public void addMonthlyInterest() {
        double interest = (balance * (annualInterestRate / 100)) / 12;
        balance += interest;
        System.out.println("Interest Added: Rs. " + String.format("%.2f", interest) + " | New Balance: Rs. " + String.format("%.2f", balance));
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accNo, double balance, double overdraftLimit) {
        super(accNo, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn Rs. " + amount + " | Current Balance: Rs. " + balance);
        } else {
            System.out.println("Withdrawal Denied: Exceeds Overdraft Limit!");
        }
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 3: Security System with 'final' Method
// ----------------------------------------------------------------------------
class SecurityGateway {
    // Final method cannot be overridden by hackers or subclasses
    public final void verifyFingerprint() {
        System.out.println("Security: Biometric Hardware encryption verified. Access Granted!");
    }
}

class CustomAppGateway extends SecurityGateway {
    public void startApp() {
        verifyFingerprint(); // Can inherit and call, but cannot modify/override
        System.out.println("App Gateway: Dashboard opened.");
    }
}

// ----------------------------------------------------------------------------
// MAIN EXECUTION
// ----------------------------------------------------------------------------
public class InheritancePractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 11: INHERITANCE PRACTICE PROBLEMS      ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // TEST 1: Multilevel Employee Payroll
        // --------------------------------------------------------------------
        System.out.println("--- 1. Multilevel Employee Hierarchy ---");
        BaseEmployee emp = new BaseEmployee(101, "Suresh", 45000.0);
        Manager mgr = new Manager(102, "Ramesh", 85000.0, 20000.0);
        Director dir = new Director(103, "Dr. Ananya", 150000.0, 50000.0, 80000.0);

        emp.printPaySlip();
        mgr.printPaySlip();
        dir.printPaySlip();
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 2: Savings & Current Accounts
        // --------------------------------------------------------------------
        System.out.println("--- 2. Banking Account Hierarchical Inheritance ---");
        SavingsAccount sa = new SavingsAccount("SAV-9001", 50000.0, 6.0); // 6% annual interest
        sa.deposit(10000.0);
        sa.addMonthlyInterest();
        System.out.println();

        CurrentAccount ca = new CurrentAccount("CUR-8002", 20000.0, 15000.0); // 15,000 overdraft limit
        ca.withdraw(25000.0); // Allowed via overdraft
        ca.withdraw(20000.0); // Denied check
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 3: Final Security Method Check
        // --------------------------------------------------------------------
        System.out.println("--- 3. Final Method Security Test ---");
        CustomAppGateway gateway = new CustomAppGateway();
        gateway.startApp();

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
