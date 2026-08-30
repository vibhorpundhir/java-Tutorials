package topic15_exception_handling;

/**
 * ============================================================================
 * TOPIC 15: EXCEPTION HANDLING IN JAVA (CRASH PROTECTION & SAFETY)
 * ============================================================================
 * 
 * 📌 EXCEPTION KYA HAI?
 * - Program run hone ke dauran aane wali koi aisi galti (Error) jo program ke normal 
 *   flow ko achanak band (Crash) kar deti hai.
 * - For example: 10 ko 0 se divide karna (`ArithmeticException`), 
 *   kisi null variable ka method call karna (`NullPointerException`), ya file na milna.
 * 
 * 📌 5 KEYWORDS OF EXCEPTION HANDLING:
 * 1. `try`     -> Risky code jisme error aane ki sambhavna ho.
 * 2. `catch`   -> Error aane par program ko crash hone se bacha kar alternative solution chalana.
 * 3. `finally` -> Code jo HAMESHA chalega (chahe error aaye ya na aaye) - Resource clean up.
 * 4. `throw`   -> Khud se manually exception create karke phekna.
 * 5. `throws`  -> Method signature me warning dena ki ye method exception throw kar sakta hai.
 */
public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TOPIC 15: EXCEPTION HANDLING COMPLETE DEMO     ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. BASIC TRY-CATCH-FINALLY
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Java 'try' ke andar ka code run karta hai.
        // Agar koi error aayi, toh program crash NAHI hota, balki control seedha 'catch' block me chala jata hai!
        // 'finally' block har haal me execute hota hai.
        System.out.println("--- 1. Basic try-catch-finally ---");

        try {
            int numerator = 50;
            int denominator = 0; // Risky: Divide by zero
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("⚠️ Catch Block: Cannot divide by zero! Message: " + e.getMessage());
        } finally {
            System.out.println("🔒 Finally Block: Cleanup done. (Ye block HAMESHA chalta hai!)");
        }
        System.out.println();

        // ====================================================================
        // 2. MULTIPLE CATCH BLOCKS
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Ek try block me kai tarah ke errors aa sakte hain.
        // Rule: Specific exceptions (NullPointer, ArrayIndex) upar likho, 
        // aur general (Exception e) sabse neeche likho.
        System.out.println("--- 2. Multiple Catch Blocks ---");

        try {
            int[] arr = { 10, 20, 30 };
            System.out.println("Accessing index 5: " + arr[5]); // Out of bounds!
        } catch (NullPointerException e) {
            System.out.println("Caught Null Pointer Exception!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("⚠️ Caught Array Index Error: Index does not exist!");
        } catch (Exception e) {
            System.out.println("⚠️ Generic Exception caught: " + e.getMessage());
        }
        System.out.println();

        // ====================================================================
        // 3. 'throw' vs 'throws' & CUSTOM EXCEPTION
        // ====================================================================
        System.out.println("--- 3. Using 'throw' and 'throws' ---");

        try {
            validateVoterAge(16); // Throws exception because age < 18
        } catch (InvalidAgeException e) {
            System.out.println("⚠️ Custom Exception Caught: " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println("      EXCEPTION HANDLING DEMO COMPLETED!          ");
        System.out.println("==================================================");
    }

    // 🔹 'throws': Method declare kar raha hai ki ye InvalidAgeException throw kar sakta hai
    public static void validateVoterAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // 🔹 'throw': Manually exception trigger kar rahe hain
            throw new InvalidAgeException("Voting not allowed for age " + age + "! Minimum age is 18.");
        }
        System.out.println("Eligible to Vote!");
    }
}

// ----------------------------------------------------------------------------
// CUSTOM EXCEPTION CLASS
// ----------------------------------------------------------------------------
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
