package topic10_packages;

import topic10_packages.model.UserAccount;

/**
 * ============================================================================
 * TOPIC 10: PACKAGES (PRACTICE QUESTIONS & ARCHITECTURE DESIGN)
 * ============================================================================
 * Is file mein Real-World Industry Standard Multi-Package Architecture ke examples hain.
 */

// ----------------------------------------------------------------------------
// PROBLEM 1: Model Layer (Order)
// ----------------------------------------------------------------------------
class Order {
    private String orderId;
    private String customerName;
    private double amount;
    private String status; // "PENDING", "COMPLETED"

    public Order(String orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.status = "PENDING";
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }

    public void markCompleted() {
        this.status = "COMPLETED";
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 2: Service Layer (OrderProcessor)
// ----------------------------------------------------------------------------
class OrderProcessor {
    public void processPayment(Order order, double paymentGiven) {
        System.out.println("Processing Payment for Order: " + order.getOrderId());
        if (paymentGiven >= order.getAmount()) {
            order.markCompleted();
            double change = paymentGiven - order.getAmount();
            System.out.println("Payment Successful! Order Status: " + order.getStatus());
            if (change > 0) {
                System.out.println("Change Returned: " + CurrencyUtils.formatINR(change));
            }
        } else {
            System.out.println("Payment Failed: Incomplete amount paid!");
        }
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 3: Utility Layer (CurrencyUtils)
// ----------------------------------------------------------------------------
class CurrencyUtils {
    // Private constructor so no one creates an object of Utility class
    private CurrencyUtils() {}

    public static String formatINR(double amount) {
        return "₹ " + String.format("%,.2f", amount);
    }
}

// ----------------------------------------------------------------------------
// MAIN PRACTICE EXECUTION
// ----------------------------------------------------------------------------
public class PackagesPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 10: PACKAGES PRACTICE PROBLEMS         ");
        System.out.println("==================================================");

        // --------------------------------------------------------------------
        // TEST 1: Model + Service + Util Layer Architecture
        // --------------------------------------------------------------------
        System.out.println("--- 1. Multi-Layer Architecture in Action ---");
        Order order1 = new Order("ORD-9871", "Aditya", 3450.0);

        System.out.println("New Order Created: " + order1.getOrderId() + " for " + order1.getCustomerName());
        System.out.println("Total Amount     : " + CurrencyUtils.formatINR(order1.getAmount()));
        System.out.println("Current Status   : " + order1.getStatus());
        System.out.println();

        OrderProcessor processor = new OrderProcessor();
        processor.processPayment(order1, 4000.0);
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 2: Encapsulation & Access Boundary Testing
        // --------------------------------------------------------------------
        System.out.println("--- 2. Access Boundary & Security Testing ---");
        UserAccount secureUser = new UserAccount("coder_boss", "DEVELOPER", "MySecret@2026");

        // Public field: Accessible directly
        System.out.println("Public Username: " + secureUser.username);

        // Private password check through public method
        System.out.println("Checking Correct Password: " + secureUser.checkPassword("MySecret@2026")); // true
        System.out.println("Checking Wrong Password  : " + secureUser.checkPassword("WrongPass"));     // false

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
