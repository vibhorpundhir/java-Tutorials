package topic07_methods;

/**
 * ============================================================================
 * TOPIC 07: METHODS & FUNCTIONS (THEORY + EXECUTION FLOW DEEP-DIVE)
 * ============================================================================
 * 
 * 📌 METHOD / FUNCTION KYA HOTA HAI?
 * - Method code ka ek block hota hai jo tabhi execute hota hai jab hum usko "Call" (invoke) karte hain.
 * - Iska sabse bada faayda hai: DRY Principle ("Don't Repeat Yourself") - Ek baar code likho, baar-baar use karo!
 * 
 * 📌 METHOD KA ANATOMY (STRUCTURE):
 * 
 *   public static int calculateSum(int num1, int num2) {
 *     return num1 + num2;
 *   }
 * 
 * 1. Access Modifier (public, private) -> Method kahan se access ho sakta hai.
 * 2. Static Keyword (static / non-static) -> Bina object banaye call ho sakta hai ya nahi.
 * 3. Return Type (void, int, String, boolean) -> Method execute hone ke baad kya wapas dega.
 * 4. Method Name (calculateSum) -> Method ka naam (CamelCase me).
 * 5. Parameters (int num1, int num2) -> Method ko input data pass karna.
 * 6. Method Body { ... } -> Actual logic code.
 * 7. return statement -> Output wapas bhejna (agar return type void na ho).
 */
public class MethodsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 07: METHODS & FUNCTIONS DEEP-DIVE      ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. SIMPLE METHOD CALLING (void vs return type)
        // ====================================================================
        System.out.println("--- 1. Simple Method Calling ---");

        // 🔹 A. Calling void method (Jo kuch return nahi karta, sirf kaam karta hai)
        printGreeting("Aman");

        // 🔹 B. Calling method with return value (Jo calculate karke answer wapas deta hai)
        int total = add(25, 35); // 25 aur 35 Arguments hain
        System.out.println("add(25, 35) Result : " + total);
        System.out.println();

        // ====================================================================
        // 2. STATIC VS NON-STATIC (INSTANCE) METHODS
        // ====================================================================
        // 🔹 'static' Method: Class se juda hota hai. Direct call ho jata hai (No object needed).
        // 🔹 'non-static' (Instance) Method: Object se juda hota hai. Isko call karne ke liye 
        //    pehle Class ka Object ('new' keyword se) banana padta hai.
        System.out.println("--- 2. Static vs Non-Static Methods ---");

        // Static method direct call:
        staticMessage();

        // Non-static method ke liye object banana padega:
        MethodsDemo demoObject = new MethodsDemo();
        demoObject.instanceMessage();
        System.out.println();

        // ====================================================================
        // 3. METHOD OVERLOADING (Compile-Time Polymorphism)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Ek hi Class me SAME NAME ke multiple methods ho sakte hain, BAS unka 
        // Parameter Signature (parameters ka count ya data type) ALAG hona chahiye!
        // Return type alag hone se overloading nahi hoti, parameter list badalni chahiye.
        System.out.println("--- 3. Method Overloading ---");

        System.out.println("multiply(5, 4)           : " + multiply(5, 4));       // 2 integers
        System.out.println("multiply(2.5, 4.0)       : " + multiply(2.5, 4.0));   // 2 doubles
        System.out.println("multiply(2, 3, 4)        : " + multiply(2, 3, 4));    // 3 integers
        System.out.println();

        // ====================================================================
        // 4. PASS-BY-VALUE IN JAVA (PRIMITIVES)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Java HAMESHA "Pass-By-Value" hota hai!
        // Jab aap kisi primitive variable (int, double) ko method me bhejte hain, 
        // toh us variable ki ek NAYI COPY banti hai.
        // Method ke andar kiye gaye changes ORIGINAL variable ko affect NAHI karte!
        System.out.println("--- 4. Pass-By-Value Proof ---");

        int originalNumber = 50;
        System.out.println("Method call se pehle originalNumber : " + originalNumber);

        modifyValue(originalNumber);

        System.out.println("Method call ke baad originalNumber  : " + originalNumber + " (Same raha, change nahi hua!)");
        System.out.println();

        // ====================================================================
        // 5. VARARGS (Variable Arguments: int... numbers)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Agar hume nahi pata ki user method me 2 numbers bhejega, 5 bhejega ya 10,
        // toh hum 'Varargs' (`...`) use karte hain. Java internally isko ek Array bana deta hai.
        System.out.println("--- 5. Varargs (Variable Arguments) ---");
        System.out.println("Sum of 2 numbers : " + sumAll(10, 20));
        System.out.println("Sum of 4 numbers : " + sumAll(10, 20, 30, 40));
        System.out.println("Sum of 6 numbers : " + sumAll(1, 2, 3, 4, 5, 6));

        System.out.println("\n==================================================");
        System.out.println("           METHODS DEMO COMPLETED!                ");
        System.out.println("==================================================");
    }

    // ------------------------------------------------------------------------
    // METHOD DEFINITIONS:
    // ------------------------------------------------------------------------

    // 1. void method (No return)
    public static void printGreeting(String name) {
        System.out.println("Hello " + name + "! Welcome to Java Methods.");
    }

    // 2. method returning int
    public static int add(int a, int b) {
        return a + b; // Result wapas bhej diya
    }

    // 3. Static method
    public static void staticMessage() {
        System.out.println("Static Method: Class ke saath direct chal gaya!");
    }

    // 4. Non-static (Instance) method
    public void instanceMessage() {
        System.out.println("Instance Method: Object banakar 'demoObject.instanceMessage()' se call hua!");
    }

    // 5. Overloaded Methods:
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // 6. Pass-by-value demonstration method
    public static void modifyValue(int num) {
        num = num + 100; // Sirf local copy modify hui
        System.out.println("  [Inside Method] num modified to: " + num);
    }

    // 7. Varargs method (Takes any number of integers)
    public static int sumAll(int... values) {
        int total = 0;
        for (int val : values) {
            total += val;
        }
        return total;
    }
}
