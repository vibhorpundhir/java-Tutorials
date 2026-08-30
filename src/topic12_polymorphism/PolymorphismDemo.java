package topic12_polymorphism;

/**
 * ============================================================================
 * TOPIC 12: POLYMORPHISM IN JAVA (ONE THING, MANY FORMS)
 * ============================================================================
 * 
 * 📌 POLYMORPHISM KYA HAI?
 * - "Poly" = Many (Anek), "Morph" = Forms (Roop).
 * - Ek hi method ya action ka situation ke hisaab se alag-alag tarike se behave karna.
 * 
 * 📌 2 TYPES OF POLYMORPHISM:
 * 1. Compile-Time Polymorphism (Method Overloading / Static Binding):
 *    - Java ko Compile time par hi pata chal jata hai ki konsa method chalega.
 * 2. Runtime Polymorphism (Method Overriding / Dynamic Binding / Upcasting):
 *    - Parent class ka reference variable Child class ke object ko point karta hai.
 *    - Konsa method chalega ye RUNTIME par decide hota hai.
 */

// ----------------------------------------------------------------------------
// 1. RUNTIME POLYMORPHISM EXAMPLE (Animal Sound)
// ----------------------------------------------------------------------------
class Animal {
    void sound() {
        System.out.println("Animal: Makes a generic sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog: Barks (Bho-Bho) 🐕");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat: Meows (Meow-Meow) 🐈");
    }
}

// ----------------------------------------------------------------------------
// 2. COMPILE-TIME POLYMORPHISM EXAMPLE (Calculator)
// ----------------------------------------------------------------------------
class SimpleCalculator {
    // Same method name 'add', alag parameters
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

// ----------------------------------------------------------------------------
// MAIN DEMO
// ----------------------------------------------------------------------------
public class PolymorphismDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      TOPIC 12: POLYMORPHISM COMPLETE DEMO        ");
        System.out.println("==================================================\n");

        // 🔹 1. COMPILE-TIME POLYMORPHISM (Overloading)
        System.out.println("--- 1. Compile-Time Polymorphism (Overloading) ---");
        SimpleCalculator calc = new SimpleCalculator();
        System.out.println("add(10, 20)       : " + calc.add(10, 20));
        System.out.println("add(10.5, 20.5)   : " + calc.add(10.5, 20.5));
        System.out.println();

        // 🔹 2. RUNTIME POLYMORPHISM & UPCASTING
        // Parent Reference = Child Object
        // KAISE KAAM KARTA HAI:
        // 'Animal pet' ek general reference hai, par actual object runtime par 'Dog' ya 'Cat' banta hai.
        System.out.println("--- 2. Runtime Polymorphism (Dynamic Dispatch) ---");

        Animal pet1 = new Dog(); // UPCASTING (Dog object, Animal reference)
        Animal pet2 = new Cat(); // UPCASTING (Cat object, Animal reference)

        pet1.sound(); // Dog ka method chala!
        pet2.sound(); // Cat ka method chala!
        System.out.println();

        // 🔹 3. POLYMORPHISM ARRAY (Looping Over Different Objects)
        System.out.println("--- 3. Polymorphic Array Traversal ---");
        Animal[] zoo = { new Dog(), new Cat(), new Animal() };

        for (Animal animal : zoo) {
            animal.sound(); // Har animal apne hisaab se sound karega
        }

        System.out.println("\n==================================================");
        System.out.println("        POLYMORPHISM DEMO COMPLETED!              ");
        System.out.println("==================================================");
    }
}
