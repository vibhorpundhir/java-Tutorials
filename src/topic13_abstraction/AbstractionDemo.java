package topic13_abstraction;

/**
 * ============================================================================
 * TOPIC 13: ABSTRACTION IN JAVA (HIDING COMPLEXITY, SHOWING ESSENTIALS)
 * ============================================================================
 * 
 * 📌 ABSTRACTION KYA HAI?
 * - User ko sirf "Kya kaam karta hai" (What to do) dikhana, 
 *   aur "Kaise kaam karta hai" (How it works internally) chhipana.
 * - Real-world Example: Car me hum accelerator press karte hain toh car chalti hai.
 *   Hume internal fuel injection ya piston working janne ki zaroorat nahi hoti.
 * 
 * 📌 ABSTRACTION ACHIEVE KARNE KE 2 TARIQE:
 * 1. Abstract Class (0% se 100% Abstraction) -> `abstract class`
 * 2. Interface (100% Pure Abstraction)       -> `interface`
 */

// ============================================================================
// 1. ABSTRACT CLASS (Can have Abstract + Normal methods)
// ============================================================================
abstract class Vehicle {
    String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    // 🔹 Abstract Method: Iski body `{}` nahi hoti! 
    // Har child class ko iska implementation LIKHNA HI PADEGA (Compulsory rule).
    abstract void accelerate();

    // 🔹 Normal (Concrete) Method: Saare children ke liye common logic
    void honk() {
        System.out.println(brand + ": Beep Beep! 📢");
    }
}

class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    // Abstract method ko body di (Compulsory)
    @Override
    void accelerate() {
        System.out.println(brand + " Car: Pressed accelerator pedal -> Speed increased! 🚗");
    }
}

// ============================================================================
// 2. INTERFACE (100% Pure Contract & Multiple Inheritance)
// ============================================================================
// Interface me by default saare methods 'public abstract' hote hain
interface FastChargeable {
    void fastCharge(); // Bina body ke
}

interface GPSNavigable {
    void navigateTo(String destination);
}

// 🔹 MULTIPLE INTERFACE IMPLEMENTATION (Java allows multiple interfaces!)
class ElectricTesla extends Vehicle implements FastChargeable, GPSNavigable {

    public ElectricTesla(String brand) {
        super(brand);
    }

    @Override
    void accelerate() {
        System.out.println(brand + ": Instant electric motor acceleration! ⚡");
    }

    @Override
    public void fastCharge() {
        System.out.println(brand + ": Supercharger connected -> 0 to 80% in 20 mins 🔋");
    }

    @Override
    public void navigateTo(String destination) {
        System.out.println(brand + ": GPS set route to -> " + destination + " 🗺️");
    }
}

// ============================================================================
// MAIN DEMO
// ============================================================================
public class AbstractionDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       TOPIC 13: ABSTRACTION COMPLETE DEMO        ");
        System.out.println("==================================================\n");

        // 🔹 1. ABSTRACT CLASS DEMO
        System.out.println("--- 1. Abstract Class Demo ---");
        // Vehicle v = new Vehicle("Generic"); // ❌ ERROR! Abstract class ka direct object nahi ban sakta!

        Vehicle myCar = new Car("Hyundai"); // Reference = Vehicle, Object = Car
        myCar.accelerate(); // Abstract method implementation
        myCar.honk();       // Normal concrete method
        System.out.println();

        // 🔹 2. INTERFACE & MULTIPLE INHERITANCE DEMO
        System.out.println("--- 2. Interface & Multiple Features Demo ---");
        ElectricTesla tesla = new ElectricTesla("Tesla Model Y");
        tesla.accelerate();
        tesla.fastCharge();
        tesla.navigateTo("Connaught Place, Delhi");

        System.out.println("\n==================================================");
        System.out.println("         ABSTRACTION DEMO COMPLETED!              ");
        System.out.println("==================================================");
    }
}
