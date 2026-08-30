package topic12_polymorphism;

/**
 * ============================================================================
 * TOPIC 12: POLYMORPHISM (PRACTICE QUESTIONS)
 * ============================================================================
 * Short and sweet real-world examples.
 */

// ----------------------------------------------------------------------------
// PROBLEM 1: Payment Gateway (Polymorphic Payment Processing)
// ----------------------------------------------------------------------------
class PaymentMethod {
    void processPayment(double amount) {
        System.out.println("Processing generic payment of Rs. " + amount);
    }
}

class UpiPayment extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Paid Rs. " + amount + " instantly via UPI (GPay/PhonePe) 📲");
    }
}

class CardPayment extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Paid Rs. " + amount + " via Credit/Debit Card 💳 (OTP Verified)");
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 2: Shape Drawing
// ----------------------------------------------------------------------------
class Shape {
    void draw() {
        System.out.println("Drawing a generic Shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle ⭕");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Square ⬛");
    }
}

// ----------------------------------------------------------------------------
// MAIN PRACTICE
// ----------------------------------------------------------------------------
public class PolymorphismPractice {

    // Helper method jo kisi bhi payment method ko handle kar sakta hai
    public static void makeCheckout(PaymentMethod payment, double amount) {
        payment.processPayment(amount); // Polymorphic call!
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 12: POLYMORPHISM PRACTICE              ");
        System.out.println("==================================================\n");

        // 1. Payment Gateway Demo
        System.out.println("--- 1. Polymorphic Checkout System ---");
        PaymentMethod upi = new UpiPayment();
        PaymentMethod card = new CardPayment();

        makeCheckout(upi, 499.0);
        makeCheckout(card, 2500.0);
        System.out.println();

        // 2. Shape Renderer Loop
        System.out.println("--- 2. Polymorphic Canvas Renderer ---");
        Shape[] canvas = { new Circle(), new Square(), new Circle() };

        for (Shape shape : canvas) {
            shape.draw();
        }

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
