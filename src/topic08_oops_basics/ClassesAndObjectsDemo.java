package topic08_oops_basics;

/**
 * ============================================================================
 * TOPIC 08: CLASSES, OBJECTS & CONSTRUCTORS (OOPs FOUNDATION DEEP-DIVE)
 * ============================================================================
 * 
 * 📌 OOPs KYA HAI? (Object-Oriented Programming)
 * - OOPs real-world entities (jaise Car, Student, Bank Account) ko software 
 *   code mein model karne ka tareeqa hai.
 * 
 * 📌 4 CORE PILLARS OF OOPs:
 * 1. Encapsulation (Data Hiding & Protection)
 * 2. Inheritance (Reusability of code)
 * 3. Polymorphism (One thing, many forms)
 * 4. Abstraction (Hiding complexity, showing essential features)
 * 
 * 📌 CLASS KYA HAI? (Blueprint / Naksha)
 * - Class ek Template ya Naksha hota hai jisme define hota hai ki Object ke paas 
 *   kya-kya Data (State/Variables) aur kya-kya Actions (Behavior/Methods) honge.
 * - Class memory consume nahi karti jab tak uska Object na banaya jaye.
 * 
 * 📌 OBJECT KYA HAI? (Real-world Instance)
 * - Class ke naksha par bani hui Asli Entity ko Object kehte hain.
 * - Jab hum `new Car()` likhte hain, toh Heap Memory mein ek NAYA object banta hai.
 * 
 * 📌 CONSTRUCTOR KYA HOTA HAI?
 * - Constructor ek special method hota hai jiska naam Class ke naam jaisa hi hota hai 
 *   aur iska koi Return Type (void bhi nahi) nahi hota.
 * - Ye tab chalta hai jab `new` keyword se object create hota hai. 
 *   Iska kaam Object ke variables ko initialize karna hota hai.
 */

// ----------------------------------------------------------------------------
// 1. CLASS DEFINITION: Car (Blueprint)
// ----------------------------------------------------------------------------
class Car {
    // 🔹 Instance Variables (State / Properties)
    // Har car object ke paas ye properties alag-alag hongi (Heap memory me)
    String brand;
    String model;
    int year;
    double price;
    boolean isEngineRunning;

    // 🔹 1. Default / No-Argument Constructor
    // Agar hum koi constructor nahi banate toh Java khud ek empty default constructor deta hai.
    // Jab hum manually banate hain, toh default values set kar sakte hain.
    public Car() {
        this.brand = "Unknown Brand";
        this.model = "Standard Model";
        this.year = 2024;
        this.price = 0.0;
        this.isEngineRunning = false;
        System.out.println("-> Default Constructor called: Ek nayi empty Car ban gayi.");
    }

    // 🔹 2. Parameterized Constructor (Constructor Overloading)
    // KAISE KAAM KARTA HAI:
    // Parameters se aane wali values ko Object ke instance variables me store karta hai.
    // 'this' Keyword: Java ko batata hai ki 'this.brand' is Class ka variable hai,
    // aur '=' ke right side wala 'brand' bahar se aane wala parameter hai (Shadowing problem solve karta hai).
    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isEngineRunning = false;
        System.out.println("-> Parameterized Constructor called for: " + this.brand + " " + this.model);
    }

    // 🔹 Methods (Behavior / Actions)
    public void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println(brand + " " + model + ": Engine started! 🚗 Vroom Vroom...");
        } else {
            System.out.println(brand + " " + model + ": Engine already running hai!");
        }
    }

    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println(brand + " " + model + ": Engine stopped.");
        } else {
            System.out.println(brand + " " + model + ": Engine pehle se hi band hai.");
        }
    }

    public void displaySpecs() {
        System.out.println("----------------------------------------");
        System.out.println("Car Brand   : " + brand);
        System.out.println("Car Model   : " + model);
        System.out.println("Launch Year : " + year);
        System.out.println("Price (USD) : $" + price);
        System.out.println("Engine State: " + (isEngineRunning ? "RUNNING" : "OFF"));
        System.out.println("----------------------------------------");
    }
}

// ----------------------------------------------------------------------------
// 2. MAIN EXECUTION CLASS
// ----------------------------------------------------------------------------
public class ClassesAndObjectsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TOPIC 08: CLASSES & OBJECTS COMPLETE DEMO      ");
        System.out.println("==================================================\n");

        // ====================================================================
        // STEP 1: OBJECT CREATION (Heap Memory Allocation)
        // ====================================================================
        // 'Car car1' -> Stack Memory mein reference variable bana.
        // 'new Car(...)' -> Heap Memory mein actual Car Object bana jisme brand, model, price store hue.
        // '=' -> car1 variable ab Heap ke us object ko point kar raha hai.
        System.out.println("--- 1. Creating Objects using Parameterized Constructor ---");

        Car car1 = new Car("BMW", "M4 Competition", 2024, 79000.0);
        Car car2 = new Car("Tesla", "Model S Plaid", 2023, 89990.0);
        System.out.println();

        // ====================================================================
        // STEP 2: CALLING METHODS (Object Behavior)
        // ====================================================================
        System.out.println("--- 2. Interacting with Objects ---");

        car1.displaySpecs();
        car1.startEngine();
        car1.startEngine(); // Engine already on check
        car1.stopEngine();
        System.out.println();

        car2.displaySpecs();
        car2.startEngine();
        System.out.println();

        // ====================================================================
        // STEP 3: DEFAULT CONSTRUCTOR DEMO
        // ====================================================================
        System.out.println("--- 3. Creating Object with Default Constructor ---");
        Car car3 = new Car();
        car3.displaySpecs();

        // Instance variables ko direct modify karna:
        car3.brand = "Ford";
        car3.model = "Mustang GT";
        car3.price = 55000.0;
        System.out.println("After Updating car3 properties:");
        car3.displaySpecs();

        System.out.println("\n==================================================");
        System.out.println("        CLASSES & OBJECTS DEMO COMPLETED!         ");
        System.out.println("==================================================");
    }
}
