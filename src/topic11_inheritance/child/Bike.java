package topic11_inheritance.child;

import topic11_inheritance.parent.Vehicle;

/**
 * ============================================================================
 * CHILD CLASS 4: Bike (HIERARCHICAL INHERITANCE)
 * ============================================================================
 * 
 * 📌 HIERARCHICAL INHERITANCE:
 * Ek hi Parent Class (Vehicle) se multiple Children alag-alag ban rahe hain:
 * Vehicle -> Car
 * Vehicle -> Bike
 * Vehicle -> Truck
 */
public class Bike extends Vehicle {

    public boolean hasHelmetCompartment;

    public Bike(String vehicleType, int maxSpeed, int totalWheels, String chassisNo, boolean hasHelmetComp) {
        super(vehicleType, maxSpeed, totalWheels, chassisNo);
        this.hasHelmetCompartment = hasHelmetComp;
        System.out.println("-> [Child: Bike Constructor] Initialized 2-Wheeler Bike.");
    }

    // Method Overriding
    @Override
    public void start() {
        System.out.println("Bike: Self-Start Ignition... 🏍️ Kick stand up, helmet checked!");
    }

    public void doWheelie() {
        System.out.println("Bike: Performing a safe stunt wheelie at speed " + (this.maxSpeed / 2) + " km/h!");
    }
}
