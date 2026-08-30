package topic11_inheritance;

import topic11_inheritance.parent.Truck;
import topic11_inheritance.child.Car;
import topic11_inheritance.child.ElectricCar;
import topic11_inheritance.child.Bike;
import topic11_inheritance.other.OutsideTester;

/**
 * ============================================================================
 * MASTER FILE: INHERITANCE IN JAVA (POORA CONCEPT + COMPLETE EXPLANATION)
 * ============================================================================
 * 
 * 📌 INHERITANCE KYA HOTA HAI?
 * - Inheritance OOPs ka wo feature hai jisme ek Child Class (Subclass) kisi doosri 
 *   Parent Class (Superclass) ki properties (variables) aur methods ko INHERIT (prapt) karti hai.
 * - Iska sabse bada faayda: CODE REUSABILITY (Baar-baar same code nahi likhna padta).
 * - Keyword: `extends` (Jaise: `class Car extends Vehicle`)
 * 
 * 📌 INHERITANCE KE TYPES IN JAVA:
 * 1. Single Inheritance       : A -> B (Vehicle -> Car)
 * 2. Multilevel Inheritance   : A -> B -> C (Vehicle -> Car -> ElectricCar)
 * 3. Hierarchical Inheritance : A -> B, A -> C, A -> D (Vehicle se Car, Bike, Truck teeno bane)
 * 4. Multiple Inheritance     : ❌ Java Classes ke saath Multiple Inheritance (ek child ke 2 direct parents)
 *                               ALLOW NAHI karta! Kyunki isse "Diamond Problem / Ambiguity" aati hai.
 *                               (Java ise 'Interfaces' ke zariye support karta hai).
 * 
 * 📌 'super' KEYWORD KE 3 MUKHYA USE:
 * 1. `super(...)`        -> Parent class ke constructor ko call karna (Child constructor ki 1st line honi chahiye).
 * 2. `super.methodName()`-> Parent class ke overridden method ko call karna.
 * 3. `super.variableName`-> Parent class ke variable ko access karna (agar child me same naam ka variable ho).
 * 
 * 📌 METHOD OVERRIDING (@Override):
 * - Jab Child class Parent class ke method ko apne hisaab se customize (naya implementation) karti hai.
 * - Rules: Method ka naam, parameters aur return type bilkul SAME hona chahiye.
 * 
 * 📌 ACCESS MODIFIER INHERITANCE RULES:
 * ┌───────────┬─────────────────────────────────────────────────────────────────┐
 * │ Modifier  │ Inheritance Behavior                                            │
 * ├───────────┼─────────────────────────────────────────────────────────────────┤
 * │ public    │ Har package ke Child class me freely inherit hota hai.          │
 * │ protected │ Alag package hone par bhi SUBCLASSES (extends) me visible hai!  │
 * │ default   │ SIRF same package ke child me visible hai (Alag package me NO). │
 * │ private   │ Child class me KABHI inherit NAHI hota! (Data Hiding).          │
 * └───────────┴─────────────────────────────────────────────────────────────────┘
 */
public class InheritanceDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 11: INHERITANCE COMPLETE MASTER DEMO   ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. SAME PACKAGE INHERITANCE (Truck)
        // ====================================================================
        System.out.println("==================================================");
        System.out.println("1. DEMO: Same Package Child (Truck extends Vehicle)");
        System.out.println("==================================================");
        Truck heavyTruck = new Truck("Tata Prima Heavy Truck", 90, 10, "CHASSIS-TRK-1001", 25.5);
        heavyTruck.testSamePackageAccess();
        System.out.println();

        // ====================================================================
        // 2. DIFFERENT PACKAGE INHERITANCE (Car)
        // ====================================================================
        System.out.println("==================================================");
        System.out.println("2. DEMO: Different Package Child (Car extends Vehicle)");
        System.out.println("==================================================");
        Car myCar = new Car("BMW 3 Series", 250, 4, "CHASSIS-CAR-2002", 4, true);
        myCar.testDifferentPackageAccess();
        System.out.println();

        // ====================================================================
        // 3. MULTILEVEL INHERITANCE (ElectricCar -> Car -> Vehicle)
        // ====================================================================
        System.out.println("==================================================");
        System.out.println("3. DEMO: Multilevel Inheritance (ElectricCar)");
        System.out.println("==================================================");
        ElectricCar tesla = new ElectricCar("Tesla Model 3", 260, 4, "CHASSIS-EV-3003", 4, true, 82, 560);
        tesla.start(); // Overridden method called
        tesla.displayEvStats();
        System.out.println();

        // ====================================================================
        // 4. HIERARCHICAL INHERITANCE (Bike)
        // ====================================================================
        System.out.println("==================================================");
        System.out.println("4. DEMO: Hierarchical Inheritance (Bike extends Vehicle)");
        System.out.println("==================================================");
        Bike sportsBike = new Bike("Kawasaki Ninja ZX-10R", 299, 2, "CHASSIS-BK-4004", false);
        sportsBike.start(); // Overridden start
        sportsBike.doWheelie();
        System.out.println();

        // ====================================================================
        // 5. OUTSIDE NON-SUBCLASS ACCESS RESTRICTION
        // ====================================================================
        System.out.println("==================================================");
        System.out.println("5. DEMO: Outside Package Non-Subclass Access");
        System.out.println("==================================================");
        OutsideTester.testOutsideAccess();

        System.out.println("\n==================================================");
        System.out.println("         INHERITANCE MASTER DEMO COMPLETED!       ");
        System.out.println("==================================================");
    }
}
