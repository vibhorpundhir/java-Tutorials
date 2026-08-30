package topic11_inheritance.parent;

/**
 * ============================================================================
 * PARENT CLASS: Vehicle (Super Class / Base Class)
 * ============================================================================
 * 
 * Ye hamari main Parent Class hai jisme hum 4 Access Modifiers define karenge:
 * 1. public    -> Har jagah accessible
 * 2. protected -> Same package me + Doosre package ke SUBCLASSES (extends) me
 * 3. default   -> Sirf same package (topic11_inheritance.parent) me
 * 4. private   -> Sirf is Vehicle class ke andar
 */
public class Vehicle {

    // 🔹 1. PUBLIC: Accessible everywhere in any package
    public String vehicleType;

    // 🔹 2. PROTECTED: Accessible in same package AND in child classes (extends) in other packages
    protected int maxSpeed;

    // 🔹 3. DEFAULT (Package-Private): Accessible ONLY inside 'topic11_inheritance.parent' package
    int totalWheels;

    // 🔹 4. PRIVATE: Accessible ONLY inside this Vehicle.java file
    private String engineChassisNumber;

    // Constructor: Jab bhi koi Child class banti hai, pehle Parent ka constructor chalta hai
    public Vehicle(String vehicleType, int maxSpeed, int totalWheels, String engineChassisNumber) {
        this.vehicleType = vehicleType;
        this.maxSpeed = maxSpeed;
        this.totalWheels = totalWheels;
        this.engineChassisNumber = engineChassisNumber;
        System.out.println("-> [Parent: Vehicle Constructor] Initialized base vehicle: " + vehicleType);
    }

    // 🔹 Public Method: Can be called and overridden anywhere
    public void start() {
        System.out.println("Vehicle: General vehicle ignition started.");
    }

    // 🔹 Protected Method: Can be called by subclasses
    protected void displaySpeedInfo() {
        System.out.println("Protected Speed Info: Max Speed = " + maxSpeed + " km/h");
    }

    // 🔹 Default (Package-Private) Method: Accessible only in same package
    void displayWheelsInfo() {
        System.out.println("Package-Private Info: Total Wheels = " + totalWheels);
    }

    // 🔹 Private Method: Cannot be accessed or overridden by child classes
    private void secretEngineDiagnostics() {
        System.out.println("Private Engine Diagnostics: Chassis = " + engineChassisNumber);
    }

    // 🔹 Final Method: Child class isko inherit kar sakti hai par OVERRIDE nahi kar sakti!
    public final void rtoRegistrationInfo() {
        System.out.println("Govt RTO Info: This vehicle is certified and registered.");
    }

    // Getter for private field (Encapsulation)
    public String getEngineChassisNumber() {
        return engineChassisNumber;
    }
}
