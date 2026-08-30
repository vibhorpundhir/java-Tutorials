package topic17_wrapper_classes;

/**
 * ============================================================================
 * TOPIC 17: JAVA WRAPPER CLASSES (AUTOBOXING, UNBOXING & UTILITIES)
 * ============================================================================
 * 
 * 📌 WRAPPER CLASS KYA HAI?
 * - Java ke 8 Primitive Data Types (int, char, boolean, double, etc.) ko OBJECTS 
 *   ke roop mein "Wrap" (lapetna) karne wali classes ko Wrapper Classes kehte hain.
 * 
 * 📌 KYU ZAROORI HAI?
 * 1. Java Collections (jaise `ArrayList<Integer>`) sirf Objects store kar sakte hain, 
 *    primitives (`ArrayList<int>`) ALLOW NAHI hote!
 * 2. Primitives ke paas koi methods nahi hote, Wrapper classes bohot saare useful 
 *    utility methods (parseInt, toBinaryString, MAX_VALUE) provide karti hain.
 * 
 * 📌 MAPPING:
 * byte -> Byte, short -> Short, int -> Integer, long -> Long
 * float -> Float, double -> Double, char -> Character, boolean -> Boolean
 */
public class WrapperClassesDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 17: WRAPPER CLASSES COMPLETE DEMO      ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. AUTOBOXING (Primitive -> Object)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Java compiler automatically primitive value ko corresponding Wrapper Object 
        // mein convert kar deta hai: Integer.valueOf(50) likhne ki zaroorat nahi padti.
        System.out.println("--- 1. Autoboxing Demo ---");
        int primitiveInt = 50;
        Integer boxedInteger = primitiveInt; // Autoboxing

        System.out.println("Primitive int value : " + primitiveInt);
        System.out.println("Wrapper Object      : " + boxedInteger + " (Class: " + boxedInteger.getClass().getSimpleName() + ")");
        System.out.println();

        // ====================================================================
        // 2. UNBOXING (Object -> Primitive)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Wrapper object se automatically raw primitive value bahar nikal lena.
        System.out.println("--- 2. Unboxing Demo ---");
        Double boxedDouble = 99.75; // Autoboxing
        double rawDouble = boxedDouble; // Auto-unboxing

        System.out.println("Boxed Double Object : " + boxedDouble);
        System.out.println("Unboxed raw double  : " + rawDouble);
        System.out.println();

        // ====================================================================
        // 3. ESSENTIAL UTILITY METHODS (Roz Kaam Aane Wale Methods)
        // ====================================================================
        System.out.println("--- 3. Powerful Wrapper Utility Methods ---");

        // 🔹 A. String se Primitive me conversion (Parsing)
        int parsedNum = Integer.parseInt("2026");
        double parsedSalary = Double.parseDouble("85000.50");
        boolean parsedBool = Boolean.parseBoolean("true");
        System.out.println("Integer.parseInt(\"2026\")     : " + parsedNum);
        System.out.println("Double.parseDouble(\"85000.5\") : " + parsedSalary);
        System.out.println("Boolean.parseBoolean(\"true\")  : " + parsedBool);
        System.out.println();

        // 🔹 B. Binary, Hex, Octal conversions
        int number = 42;
        System.out.println("42 in Binary (Base 2)       : " + Integer.toBinaryString(number));
        System.out.println("42 in Hexadecimal (Base 16) : " + Integer.toHexString(number));
        System.out.println();

        // 🔹 C. Limits & Constants (Interview & Competitive Programming)
        System.out.println("Integer Range : " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Byte Range    : " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println();

        // 🔹 D. Character Utility methods
        char ch1 = 'A';
        char ch2 = '9';
        System.out.println("Character.isDigit('9')      : " + Character.isDigit(ch2));      // true
        System.out.println("Character.isLetter('A')     : " + Character.isLetter(ch1));     // true
        System.out.println("Character.toLowerCase('A')  : " + Character.toLowerCase(ch1));  // 'a'
        System.out.println();

        // ====================================================================
        // 4. INTEGER CACHING POOL (-128 to 127 TRAP!)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Java memory bachane ke liye -128 se lekar 127 tak ke Integers ko Cache me rakhta hai.
        // Is range me '==' true dega, par 128 ya usse upar '==' false dega (naye objects bante hain)!
        System.out.println("--- 4. Integer Cache Pool Trap (-128 to 127) ---");
        Integer numA = 100;
        Integer numB = 100;
        System.out.println("100 == 100 (In cache range)     : " + (numA == numB) + " (True: Same cached memory)");

        Integer numX = 200;
        Integer numY = 200;
        System.out.println("200 == 200 (Outside cache range): " + (numX == numY) + " (False: New Objects!)");
        System.out.println("numX.equals(numY) (Safe check)  : " + numX.equals(numY) + " (True: Content same)");

        System.out.println("\n==================================================");
        System.out.println("       WRAPPER CLASSES DEMO COMPLETED!            ");
        System.out.println("==================================================");
    }
}
