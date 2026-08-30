package topic11_inheritance.child;

/**
 * ============================================================================
 * CHILD CLASS 3: ElectricCar (MULTILEVEL INHERITANCE)
 * ============================================================================
 * 
 * 📌 MULTILEVEL INHERITANCE:
 * Vehicle (Grandparent)  -->  Car (Parent)  -->  ElectricCar (Child)
 * 
 * ElectricCar ko Car aur Vehicle DONO ki properties aur methods milte hain!
 */
public class ElectricCar extends Car {

    public int batteryCapacityKwh;
    public int rangeKm;

    // Constructor Chaining through 3 levels:
    // ElectricCar -> super(...) -> Car -> super(...) -> Vehicle
    public ElectricCar(String vehicleType, int maxSpeed, int totalWheels, String chassisNo, 
                       int doors, boolean hasAC, int batteryCapacityKwh, int rangeKm) {
        super(vehicleType, maxSpeed, totalWheels, chassisNo, doors, hasAC); // Calls Car constructor
        this.batteryCapacityKwh = batteryCapacityKwh;
        this.rangeKm = rangeKm;
        System.out.println("-> [Grandchild: ElectricCar Constructor] Battery: " + batteryCapacityKwh + " kWh, Range: " + rangeKm + " km.");
    }

    // Method Overriding
    @Override
    public void start() {
        System.out.println("ElectricCar: Push Button Start... Silent EV Motors Active (Battery at " + batteryCapacityKwh + " kWh) ⚡");
    }

    public void displayEvStats() {
        System.out.println("EV Stats: " + this.vehicleType + " | Max Speed: " + this.maxSpeed + 
                           " km/h | Range: " + this.rangeKm + " km | Battery: " + this.batteryCapacityKwh + " kWh");
    }
}
