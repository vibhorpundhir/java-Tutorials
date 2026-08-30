package topic11_inheritance.parent;

/**
 * ============================================================================
 * CHILD CLASS 1: Truck (SAME PACKAGE INHERITANCE)
 * ============================================================================
 * 
 * Ye class 'Vehicle' ko inherit (extends) kar rahi hai aur SAME PACKAGE 
 * ('topic11_inheritance.parent') ke andar hi maujood hai.
 * 
 * 📌 SAME PACKAGE ME KYA ACCESS HO SAKTA HAI:
 * ✅ public       -> Accessible (vehicleType)
 * ✅ protected    -> Accessible (maxSpeed)
 * ✅ default      -> Accessible (totalWheels - Kyunki package same hai!)
 * ❌ private      -> NOT Accessible (engineChassisNumber)
 */
public class Truck extends Vehicle {

    public double cargoCapacityTons;

    // Constructor: 'super(...)' se Parent (Vehicle) ke constructor ko call kiya
    public Truck(String vehicleType, int maxSpeed, int totalWheels, String chassisNo, double cargoCapacityTons) {
        super(vehicleType, maxSpeed, totalWheels, chassisNo);
        this.cargoCapacityTons = cargoCapacityTons;
        System.out.println("-> [Child: Truck Constructor] Initialized Truck with Cargo Capacity: " + cargoCapacityTons + " Tons.");
    }

    public void testSamePackageAccess() {
        System.out.println("\n--- Testing Truck (Same Package Child Access) ---");

        // 1. PUBLIC Access:
        System.out.println("✅ Public vehicleType  : " + this.vehicleType);

        // 2. PROTECTED Access:
        System.out.println("✅ Protected maxSpeed  : " + this.maxSpeed + " km/h");

        // 3. DEFAULT (Package-Private) Access:
        // Kyunki Truck aur Vehicle SAME package me hain, isliye default member direct access ho gaya!
        System.out.println("✅ Default totalWheels : " + this.totalWheels);

        // 4. PRIVATE Access:
        // System.out.println(this.engineChassisNumber); // ❌ COMPILE ERROR! Private variables child me bhi visible nahi hote.
        System.out.println("❌ Private field direct access nahi ho sakta! Getter use karna padega: " + getEngineChassisNumber());

        // Methods Calling:
        this.start();               // public
        this.displaySpeedInfo();    // protected
        this.displayWheelsInfo();   // default
        this.rtoRegistrationInfo(); // final
    }
}
