package topic11_inheritance.child;

// Kyunki 'Vehicle' doosre package ('topic11_inheritance.parent') me hai, isliye import karna padega
import topic11_inheritance.parent.Vehicle;

/**
 * ============================================================================
 * CHILD CLASS 2: Car (DIFFERENT PACKAGE INHERITANCE)
 * ============================================================================
 * 
 * Ye class 'Vehicle' ko inherit (extends) kar rahi hai lekin ye EK ALAG PACKAGE 
 * ('topic11_inheritance.child') ke andar maujood hai.
 * 
 * 📌 DIFFERENT PACKAGE SUBCLASS ME KYA ACCESS HO SAKTA HAI:
 * ✅ public       -> Accessible (vehicleType)
 * ✅ protected    -> Accessible (maxSpeed - Kyunki 'Car' Vehicle ka SUBCLASS hai!)
 * ❌ default      -> NOT Accessible (totalWheels - Package alag hai!)
 * ❌ private      -> NOT Accessible (engineChassisNumber)
 */
public class Car extends Vehicle {

    public int doors;
    public boolean hasAirConditioner;

    // Constructor: 'super(...)' se Parent (Vehicle) ka constructor call karna
    public Car(String vehicleType, int maxSpeed, int totalWheels, String chassisNo, int doors, boolean hasAC) {
        super(vehicleType, maxSpeed, totalWheels, chassisNo);
        this.doors = doors;
        this.hasAirConditioner = hasAC;
        System.out.println("-> [Child: Car Constructor] Initialized Car with " + doors + " doors.");
    }

    public void testDifferentPackageAccess() {
        System.out.println("\n--- Testing Car (Different Package Subclass Access) ---");

        // 1. PUBLIC Access:
        System.out.println("✅ Public vehicleType     : " + this.vehicleType);

        // 2. PROTECTED Access:
        // Protected ka sabse bada jaadu yahi hai: Alag package hone ke BAAVJOOD 
        // Subclass hone ki wajah se direct access ho gaya!
        System.out.println("✅ Protected maxSpeed     : " + this.maxSpeed + " km/h (Protected allowed via Inheritance!)");

        // 3. DEFAULT (Package-Private) Access:
        // System.out.println(this.totalWheels); // ❌ COMPILE ERROR! Package alag hai toh default block ho jata hai!
        System.out.println("❌ Default 'totalWheels' direct access NAHI ho sakta! (Package alag hai)");

        // 4. PRIVATE Access:
        // System.out.println(this.engineChassisNumber); // ❌ COMPILE ERROR! Private is only inside Vehicle class
        System.out.println("❌ Private field direct access NAHI ho sakta!");

        // Methods:
        this.start();            // public method
        this.displaySpeedInfo(); // protected method (Allowed!)
        // this.displayWheelsInfo(); // ❌ COMPILE ERROR! default method in different package is not visible
    }

    // Method Overriding: Parent ke general start() method ko Car ke hisaab se customize karna
    @Override
    public void start() {
        // 'super.start()' se Parent ka method bhi call kar sakte hain
        super.start();
        System.out.println("Car: Key inserted, AC turned " + (hasAirConditioner ? "ON" : "OFF") + ", ready to drive!");
    }
}
