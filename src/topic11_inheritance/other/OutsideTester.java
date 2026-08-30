package topic11_inheritance.other;

import topic11_inheritance.parent.Vehicle;

/**
 * ============================================================================
 * NON-SUBCLASS CLASS: OutsideTester (DIFFERENT PACKAGE, NO INHERITANCE)
 * ============================================================================
 * 
 * Ye class na toh 'topic11_inheritance.parent' package me hai, 
 * aur na hi isne 'Vehicle' ko extend kiya hai.
 * 
 * 📌 ACCESS RULES FOR NON-SUBCLASS IN DIFFERENT PACKAGE:
 * ✅ public       -> ONLY PUBLIC is Accessible! (vehicle.vehicleType, vehicle.start())
 * ❌ protected    -> BLOCKED! (Cannot access vehicle.maxSpeed)
 * ❌ default      -> BLOCKED! (Cannot access vehicle.totalWheels)
 * ❌ private      -> BLOCKED! (Cannot access vehicle.engineChassisNumber)
 */
public class OutsideTester {

    public static void testOutsideAccess() {
        System.out.println("\n--- Testing OutsideTester (Different Package, Non-Subclass) ---");

        Vehicle v = new Vehicle("Commercial Van", 120, 4, "CHASSIS-9998");

        // 1. PUBLIC Access:
        System.out.println("✅ Public vehicleType  : " + v.vehicleType);
        v.start();

        // 2. PROTECTED Access:
        // System.out.println(v.maxSpeed); // ❌ COMPILE ERROR! protected has protected access in Vehicle
        System.out.println("❌ Protected 'maxSpeed' is NOT accessible (Kyunki ye subclass nahi hai!)");

        // 3. DEFAULT Access:
        // System.out.println(v.totalWheels); // ❌ COMPILE ERROR! not public in Vehicle; cannot be accessed from outside package
        System.out.println("❌ Default 'totalWheels' is NOT accessible (Package alag hai)");

        // 4. PRIVATE Access:
        // System.out.println(v.engineChassisNumber); // ❌ COMPILE ERROR! private in Vehicle
        System.out.println("❌ Private 'engineChassisNumber' is NOT accessible");
    }
}
