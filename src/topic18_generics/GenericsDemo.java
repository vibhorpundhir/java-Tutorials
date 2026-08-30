package topic18_generics;

/**
 * ============================================================================
 * TOPIC 18: JAVA GENERICS (COMPILE-TIME TYPE SAFETY & CODE REUSABILITY)
 * ============================================================================
 * 
 * 📌 GENERICS KYA HOTE HAIN?
 * - Generics ka matlab hota hai: "Parameterized Types" (`<T>`).
 * - Ek hi Class ya Method ko ALAG-ALAG Data Types (Integer, String, Custom Objects) 
 *   ke saath kaam karne ke kaabil banana bina typecasting ke!
 * 
 * 📌 2 SABSE BADE FAAYDE:
 * 1. Compile-Time Type Safety: Galat type ka data daalne par compiler compile time 
 *    par hi error pakad leta hai (Runtime crash / `ClassCastException` se bachata hai).
 * 2. No Typecasting Needed: `(String) obj` jaisi manual typecasting ki zaroorat nahi padti.
 * 
 * 📌 COMMON CONVENTIONS:
 * - `<T>` -> Type
 * - `<E>` -> Element (Collections me)
 * - `<K>` -> Key, `<V>` -> Value (Maps me)
 * - `<N>` -> Number
 */

// ----------------------------------------------------------------------------
// 1. GENERIC CLASS: Box<T>
// ----------------------------------------------------------------------------
// KAISE KAAM KARTA HAI:
// 'T' ek placeholder hai. Jab user `new Box<String>()` likhega toh 'T' String ban jayega.
// Jab user `new Box<Integer>()` likhega toh 'T' Integer ban jayega.
class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }
}

// ----------------------------------------------------------------------------
// 2. MULTIPLE TYPE PARAMETERS CLASS: KeyValuePair<K, V>
// ----------------------------------------------------------------------------
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void displayPair() {
        System.out.println("Key: " + key + " (Type: " + key.getClass().getSimpleName() + 
                           ") -> Value: " + value + " (Type: " + value.getClass().getSimpleName() + ")");
    }
}

// ----------------------------------------------------------------------------
// 3. BOUNDED TYPE PARAMETER: NumberBox<T extends Number>
// ----------------------------------------------------------------------------
// KAISE KAAM KARTA HAI:
// '<T extends Number>' ka matlab: 'T' sirf wahi data types ho sakte hain jo 'Number' class ke 
// children hain (jaise Integer, Double, Float). String ya Boolean daalne par COMPILE ERROR aayega!
class NumberBox<T extends Number> {
    private T num;

    public NumberBox(T num) {
        this.num = num;
    }

    public double getSquare() {
        // num.doubleValue() Number class ka method hai
        return num.doubleValue() * num.doubleValue();
    }
}

// ----------------------------------------------------------------------------
// MAIN DEMO
// ----------------------------------------------------------------------------
public class GenericsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        TOPIC 18: JAVA GENERICS COMPLETE DEMO     ");
        System.out.println("==================================================\n");

        // 🔹 1. GENERIC CLASS USAGE (String & Integer)
        System.out.println("--- 1. Generic Class Box<T> ---");
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello Java Generics!");
        System.out.println("String Box Content : " + stringBox.getItem());

        Box<Integer> intBox = new Box<>();
        intBox.setItem(2026);
        System.out.println("Integer Box Content: " + intBox.getItem());
        System.out.println();

        // 🔹 2. MULTI-TYPE GENERICS (Pair<K, V>)
        System.out.println("--- 2. Multi-Type Generic Pair<K, V> ---");
        Pair<String, Double> productPrice = new Pair<>("MacBook", 199990.0);
        Pair<Integer, String> studentRoll = new Pair<>(101, "Aman");

        productPrice.displayPair();
        studentRoll.displayPair();
        System.out.println();

        // 🔹 3. GENERIC METHOD DEMO
        System.out.println("--- 3. Generic Method (Any Array Type) ---");
        String[] languages = { "Java", "Python", "Rust", "Go" };
        Integer[] scores = { 95, 88, 72, 99 };

        System.out.print("Languages Array : ");
        printArrayElements(languages);

        System.out.print("Scores Array    : ");
        printArrayElements(scores);
        System.out.println();

        // 🔹 4. BOUNDED GENERICS (Restricted to Numbers)
        System.out.println("--- 4. Bounded Generics (<T extends Number>) ---");
        NumberBox<Integer> intNumBox = new NumberBox<>(7);
        NumberBox<Double> doubleNumBox = new NumberBox<>(5.5);

        System.out.println("Square of 7   : " + intNumBox.getSquare());
        System.out.println("Square of 5.5 : " + doubleNumBox.getSquare());

        // NumberBox<String> strBox = new NumberBox<>("Hello"); // ❌ COMPILE ERROR! String is not a Number

        System.out.println("\n==================================================");
        System.out.println("          GENERICS DEMO COMPLETED!                ");
        System.out.println("==================================================");
    }

    // 🔹 GENERIC METHOD: Ek hi method se kisi bhi type ka array print karo
    public static <E> void printArrayElements(E[] array) {
        System.out.print("[ ");
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }
}
