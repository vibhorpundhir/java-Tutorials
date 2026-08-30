package topic13_abstraction;

/**
 * ============================================================================
 * TOPIC 13: ABSTRACTION (PRACTICE QUESTIONS)
 * ============================================================================
 * Short, clean notification & payment practice examples.
 */

// ----------------------------------------------------------------------------
// PROBLEM 1: Abstract Notification System
// ----------------------------------------------------------------------------
abstract class NotificationService {
    // Abstract method: Har service alag tarike se send karegi
    abstract void sendNotification(String message, String recipient);

    // Concrete method: Common header logging
    void logDispatch(String type) {
        System.out.println("[Log] Dispatching notification via " + type + "...");
    }
}

class EmailNotification extends NotificationService {
    @Override
    void sendNotification(String message, String recipient) {
        logDispatch("SMTP Email Server");
        System.out.println("📧 Email sent to [" + recipient + "]: " + message);
    }
}

class SmsNotification extends NotificationService {
    @Override
    void sendNotification(String message, String recipient) {
        logDispatch("Telecom SMS Gateway");
        System.out.println("📱 SMS sent to [" + recipient + "]: " + message);
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 2: Interface (Remote Control Contract)
// ----------------------------------------------------------------------------
interface SmartRemote {
    void powerOn();
    void powerOff();
}

class SmartTV implements SmartRemote {
    @Override
    public void powerOn() {
        System.out.println("SmartTV: Display ON (4K OLED ready) 📺");
    }

    @Override
    public void powerOff() {
        System.out.println("SmartTV: Screen OFF (Entering Standby mode)");
    }
}

// ----------------------------------------------------------------------------
// MAIN PRACTICE
// ----------------------------------------------------------------------------
public class AbstractionPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 13: ABSTRACTION PRACTICE               ");
        System.out.println("==================================================\n");

        // 1. Notification Demo
        System.out.println("--- 1. Notification System ---");
        NotificationService email = new EmailNotification();
        NotificationService sms = new SmsNotification();

        email.sendNotification("Your OTP is 482910", "user@example.com");
        System.out.println();
        sms.sendNotification("Your order has been shipped!", "+91-9876543210");
        System.out.println();

        // 2. Smart Remote Interface Demo
        System.out.println("--- 2. Smart Remote Interface ---");
        SmartRemote remote = new SmartTV();
        remote.powerOn();
        remote.powerOff();

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
