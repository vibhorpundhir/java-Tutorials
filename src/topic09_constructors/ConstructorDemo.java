package topic09_constructors;

/**
 * ============================================================================
 * TOPIC 09: CONSTRUCTORS IN JAVA (SABHI TYPES KA COMPLETE DEEP-DIVE)
 * ============================================================================
 * 
 * 📌 CONSTRUCTOR KYA HOTA HAI?
 * - Constructor ek special member method hota hai jiska naam EXACTLY Class ke naam jaisa hota hai.
 * - Iska koi Return Type (yahan tak ki `void` bhi) NAHI hota.
 * - Ye tab automatically execute hota hai jab hum `new` keyword se object banate hain.
 * - Iska main purpose hota hai: Naye bane Object ke variables ko INITIALIZE (initial value set) karna.
 * 
 * 📌 CONSTRUCTORS KE SABHI TYPES (ALL TYPES):
 * 1. Default Constructor (Compiler-provided if no constructor is written)
 * 2. No-Argument Constructor (User-defined empty/default initializer)
 * 3. Parameterized Constructor (Custom values pass karne ke liye)
 * 4. Constructor Overloading (Multiple constructors with different parameters)
 * 5. Constructor Chaining using `this(...)` (Ek constructor se doosre constructor ko call karna)
 * 6. Copy Constructor (Ek existing object ka data copy karke naya object banana)
 * 7. Private Constructor (Bahar se object creation rokne ke liye - Singleton / Utility classes)
 */

// ----------------------------------------------------------------------------
// CLASS: Smartphone (Demonstrating Constructor Types 1 to 6)
// ----------------------------------------------------------------------------
class Smartphone {
    String brand;
    String model;
    int ramGb;
    int storageGb;
    double price;

    // 🔹 1. NO-ARGUMENT CONSTRUCTOR (User-written default values)
    // KAISE KAAM KARTA HAI:
    // Jab user bina kisi data ke `new Smartphone()` call karega, 
    // toh ye constructor basic default values assign kar dega.
    public Smartphone() {
        // Constructor Chaining: Yahan hum direct initialize karne ke bajaye 
        // 5-parameter wale main constructor ko call kar rahe hain using this(...)
        this("Generic", "Standard", 4, 64, 9999.0);
        System.out.println("-> [No-Arg Constructor] Basic Default Phone Created.");
    }

    // 🔹 2. PARAMETERIZED CONSTRUCTOR (2 Parameters)
    // KAISE KAAM KARTA HAI:
    // User sirf brand aur model dega, baaki RAM/Storage default set ho jayenge.
    public Smartphone(String brand, String model) {
        this(brand, model, 6, 128, 19999.0); // Chaining to 5-param constructor
        System.out.println("-> [2-Param Constructor] Phone Created: " + brand + " " + model);
    }

    // 🔹 3. FULL PARAMETERIZED CONSTRUCTOR (All 5 Parameters)
    // KAISE KAAM KARTA HAI:
    // Ye main constructor hai jo saare instance variables ko actual values assign karta hai.
    // 'this.brand' = Class ka variable, 'brand' = Parameter variable.
    public Smartphone(String brand, String model, int ramGb, int storageGb, double price) {
        this.brand = brand;
        this.model = model;
        this.ramGb = ramGb;
        this.storageGb = storageGb;
        this.price = price;
        System.out.println("-> [5-Param Full Constructor] Initialized: " + this.brand + " " + this.model);
    }

    // 🔹 4. COPY CONSTRUCTOR
    // KAISE KAAM KARTA HAI:
    // Ye doosre already bane hue 'Smartphone' object ko input leta hai
    // aur uski saari properties copy karke ek bilkul NAYA ALAG object bana deta hai (Cloning).
    public Smartphone(Smartphone existingPhone) {
        this.brand = existingPhone.brand;
        this.model = existingPhone.model;
        this.ramGb = existingPhone.ramGb;
        this.storageGb = existingPhone.storageGb;
        this.price = existingPhone.price;
        System.out.println("-> [Copy Constructor] Cloned Phone from: " + existingPhone.model);
    }

    public void displayPhone() {
        System.out.println("Phone: " + brand + " " + model + " | " + ramGb + "GB RAM | " + 
                           storageGb + "GB Storage | Price: Rs. " + price);
    }
}

// ----------------------------------------------------------------------------
// CLASS: MathHelper (Demonstrating PRIVATE Constructor)
// ----------------------------------------------------------------------------
// KAISE KAAM KARTA HAI:
// Agar kisi class me saare methods 'static' hain (Utility Class jaise Math),
// toh hum uska constructor 'private' kar dete hain taaki koi galti se 
// 'new MathHelper()' karke memory waste na kare!
class MathHelper {
    // 🔹 5. PRIVATE CONSTRUCTOR
    private MathHelper() {
        System.out.println("Private Constructor: Bahar se access nahi ho sakta!");
    }

    public static int square(int x) {
        return x * x;
    }

    public static int cube(int x) {
        return x * x * x;
    }
}

// ----------------------------------------------------------------------------
// MAIN EXECUTION CLASS
// ----------------------------------------------------------------------------
public class ConstructorDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 09: CONSTRUCTORS IN JAVA COMPLETE      ");
        System.out.println("==================================================\n");

        // 1. NO-ARGUMENT CONSTRUCTOR CALL
        System.out.println("--- 1. Calling No-Argument Constructor ---");
        Smartphone phone1 = new Smartphone();
        phone1.displayPhone();
        System.out.println();

        // 2. 2-PARAMETER OVERLOADED CONSTRUCTOR CALL
        System.out.println("--- 2. Calling Overloaded (2-Param) Constructor ---");
        Smartphone phone2 = new Smartphone("OnePlus", "Nord CE");
        phone2.displayPhone();
        System.out.println();

        // 3. FULL PARAMETERIZED CONSTRUCTOR CALL
        System.out.println("--- 3. Calling Full Parameterized (5-Param) Constructor ---");
        Smartphone phone3 = new Smartphone("Apple", "iPhone 15 Pro", 8, 256, 134900.0);
        phone3.displayPhone();
        System.out.println();

        // 4. COPY CONSTRUCTOR CALL (Cloning an object)
        System.out.println("--- 4. Calling Copy Constructor (Cloning phone3) ---");
        Smartphone phone4 = new Smartphone(phone3); // phone3 ka clone phone4 me bana
        phone4.displayPhone();

        // Proof ki dono memory mein alag objects hain:
        System.out.println("Kya phone3 == phone4 (Same Memory)? : " + (phone3 == phone4) + " (False: Both are independent objects in Heap)");
        System.out.println();

        // 5. PRIVATE CONSTRUCTOR USAGE
        System.out.println("--- 5. Utility Class with Private Constructor ---");
        // MathHelper helper = new MathHelper(); // ❌ COMPILE ERROR! Constructor is private
        // Direct static methods call karenge:
        System.out.println("Square of 7 : " + MathHelper.square(7));
        System.out.println("Cube of 5   : " + MathHelper.cube(5));

        System.out.println("\n==================================================");
        System.out.println("        CONSTRUCTORS DEMO COMPLETED!              ");
        System.out.println("==================================================");
    }
}
