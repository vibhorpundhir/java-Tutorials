package topic01_typecasting;

/**
 * ============================================================================
 * TOPIC 01: TYPE CASTING (THEORY + CONCEPT DEMO)
 * ============================================================================
 * 
 * Type Casting ka matlab: Ek primitive data type ki value ko doosre type mein
 * badalna.
 * 
 * Hierarchy (Chote se Bada):
 * byte (1B) -> short (2B) -> char (2B) -> int (4B) -> long (8B) -> float (4B)
 * -> double (8B)
 * 
 * 1. Widening (Implicit / Automatic) : Chote se Bada -> No data loss
 * 2. Narrowing (Explicit / Manual) : Bade se Chota -> Possible data loss /
 * overflow
 */
public class TypeCastingDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 01: TYPE CASTING (CONCEPT DEMO)        ");
        System.out.println("==================================================\n");

        // 1. WIDENING CASTING (Automatic)
        System.out.println("--- 1. Widening Casting (Automatic) ---");
        int myInt = 100;
        double myDouble = myInt; // Automatic conversion
        System.out.println("int 100 -> double: " + myDouble);

        char letter = 'A';
        int asciiValue = letter; // 'A' -> 65
        System.out.println("char 'A' -> ASCII int: " + asciiValue);
        System.out.println();

        // 2. NARROWING CASTING (Manual)
        System.out.println("--- 2. Narrowing Casting (Manual) ---");
        double itemPrice = 249.85;
        int roundedPrice = (int) itemPrice; // (int) lagana zaroori hai
        System.out.println("double 249.85 -> int: " + roundedPrice + " (.85 loss ho gaya)");

        int asciiCode = 66;
        char character = (char) asciiCode; // 66 -> 'B'
        System.out.println("int 66 -> char: '" + character + "'");
        System.out.println();

        // 3. TYPE PROMOTION IN ARITHMETIC
        System.out.println("--- 3. Type Promotion in Math ---");
        byte num1 = 30;
        byte num2 = 40;
        // byte sum = num1 + num2; // Error! Kyunki addition int ban jata hai
        int sum = num1 + num2;
        System.out.println("byte + byte as int sum: " + sum);
        System.out.println();

        // 4. PARSING (String <-> Numbers)
        System.out.println("--- 4. String <-> Numbers Conversion ---");
        String textNum = "500";
        int parsedInt = Integer.parseInt(textNum); // String to int
        System.out.println("Integer.parseInt(\"500\") + 50 = " + (parsedInt + 50));

        String textDouble = "99.99";
        double parsedDouble = Double.parseDouble(textDouble); // String to double
        System.out.println("Double.parseDouble(\"99.99\") = " + parsedDouble);

        String strFromInt = String.valueOf(parsedInt); // int to String
        System.out.println("String.valueOf(500) = \"" + strFromInt + "\"");
    }
}
