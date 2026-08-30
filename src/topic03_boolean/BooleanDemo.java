package topic03_boolean;

/**
 * ============================================================================
 * TOPIC 03: BOOLEAN IN JAVA (DEEP DIVE + OPERATION-BY-OPERATION EXPLANATION)
 * ============================================================================
 * 
 * 📌 BOOLEAN KYA HAI?
 * - Boolean Java ka sabse simple primitive data type hai.
 * - Isme sirf 2 hi possible values hoti hain: `true` ya `false`.
 * - Default value: `false`.
 * 
 * 📌 SABSE BADI GALTI (IMPORTANT RULE):
 * - C, C++ ya Python mein 0 = false aur 1 = true mana jata hai.
 * - LEKIN Java mein aisa NAHI hota! Java strictly Type-Safe hai.
 * - `boolean b = 1;` -> COMPILE ERROR dega! Java me sirf `true` ya `false` hi chalega.
 */
public class BooleanDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       TOPIC 03: BOOLEAN OPERATIONS DEEP-DIVE     ");
        System.out.println("==================================================\n");

        // ====================================================================
        // SECTION 1: BASIC DECLARATION & LITERALS
        // ====================================================================
        System.out.println("--- 1. Basic Boolean Variables ---");

        boolean isJavaAwesome = true;
        boolean isEarthFlat = false;

        System.out.println("isJavaAwesome : " + isJavaAwesome);
        System.out.println("isEarthFlat   : " + isEarthFlat);
        System.out.println();

        // ====================================================================
        // SECTION 2: COMPARISON (RELATIONAL) OPERATORS
        // ====================================================================
        // KAISE KAAM KARTE HAIN:
        // Ye operators do values (numbers, variables) ko aapas mein compare karte hain
        // aur calculation ke baad result hamesha ek `boolean` (true ya false) return karte hain.
        System.out.println("--- 2. Relational Operators (Kaise Result Dete Hain) ---");

        int marks = 75;
        int passingMarks = 40;

        // 🔹 1. '==' (Equal To): Kya dono values barabar hain?
        System.out.println("1. marks == 75     : " + (marks == 75) + " [75 barabar hai 75 ke]");
        System.out.println("   marks == 100    : " + (marks == 100) + " [75 barabar nahi hai 100 ke]");

        // 🔹 2. '!=' (Not Equal To): Kya dono values barabar NAHI hain?
        System.out.println("2. marks != 0      : " + (marks != 0) + " [True: 75 zero ke barabar nahi hai]");

        // 🔹 3. '>' aur '<' (Greater Than & Less Than)
        System.out.println("3. marks > 50      : " + (marks > 50) + " [True: 75 bada hai 50 se]");
        System.out.println("4. marks < 50      : " + (marks < 50) + " [False: 75 chota nahi hai 50 se]");

        // 🔹 4. '>=' aur '<=' (Greater Than/Equal To & Less Than/Equal To)
        // KAISE KAAM KARTA HAI: Agar value badi HO YA barabar HO, dono cases mein true dega.
        System.out.println("5. marks >= passingMarks : " + (marks >= passingMarks) + " [75 bada hai 40 se]");
        System.out.println();

        // ====================================================================
        // SECTION 3: LOGICAL OPERATORS (&&, ||, !, ^)
        // ====================================================================
        // KAISE KAAM KARTE HAIN:
        // Ye multiple boolean conditions ko combine (jodne) ke kaam aate hain.
        System.out.println("--- 3. Logical Operators (In-Depth Working) ---");

        int age = 22;
        boolean hasLicense = true;
        boolean isDrunk = false;

        // 🔹 1. Logical AND ('&&')
        // RULE: Dono side ki conditions TRUE honi chahiye, tabhi overall TRUE aayega.
        // Truth Table:
        // true  && true  -> TRUE
        // true  && false -> FALSE
        // false && true  -> FALSE
        // false && false -> FALSE
        boolean canDrive = (age >= 18) && hasLicense;
        System.out.println("1. (age >= 18) && hasLicense : " + canDrive + " [Dono True hain -> Isliye True]");

        // 🔹 2. Logical OR ('||')
        // RULE: Kam se kam EK condition TRUE honi chahiye, overall TRUE aane ke liye.
        // Truth Table:
        // true  || true  -> TRUE
        // true  || false -> TRUE
        // false || true  -> TRUE
        // false || false -> FALSE
        boolean hasIdentityProof = hasLicense || (age >= 18);
        System.out.println("2. hasLicense || (age >= 18)  : " + hasIdentityProof + " [Ek bhi True ho toh True]");

        // 🔹 3. Logical NOT ('!')
        // RULE: Ye ek Unary Operator hai jo result ko ulta (invert) kar deta hai.
        // !true  -> FALSE
        // !false -> TRUE
        boolean isSober = !isDrunk; // !false -> true
        System.out.println("3. !isDrunk                  : " + isSober + " [!false ban gaya true]");

        // 🔹 4. Logical XOR ('^' - Exclusive OR)
        // RULE: Sirf tab TRUE aayega jab DONO conditions ALAG-ALAG hon (ek true ho aur ek false ho).
        // Agar dono same hain (dono true ya dono false), toh FALSE aayega.
        System.out.println("4. true ^ false (Alag hain)  : " + (true ^ false) + " [True: kyunki dono alag hain]");
        System.out.println("   true ^ true  (Same hain)  : " + (true ^ true) + " [False: kyunki dono same hain]");
        System.out.println();

        // ====================================================================
        // SECTION 4: SHORT-CIRCUIT EVALUATION (JAVA KA SMART EXECUTION)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // 1. '&&' (Short-circuit AND):
        //    Java pehle left side evaluate karta hai. Agar left 'false' nikal gaya,
        //    toh Java right side ko CHECK HI NAHI KARTA! (Kyunki false && anything = false).
        //
        // 2. '||' (Short-circuit OR):
        //    Agar left side 'true' nikal gaya, toh Java right side ko CHECK HI NAHI KARTA!
        //    (Kyunki true || anything = true).
        System.out.println("--- 4. Short-Circuit Evaluation (Safety Feature) ---");

        // 💥 Real-world Example: Crash / Error se bachna
        String username = null; // Variable me koi object nahi hai (null hai)

        // Agar hum direct username.length() likhenge toh program CRASH (NullPointerException) ho jayega!
        // LEKIN Short-Circuit hume bacha leta hai:
        // Pehle 'username != null' check hua -> Wo aaya FALSE.
        // Java ne turant execution rok diya aur aage 'username.length()' ko call hi nahi kiya!
        if (username != null && username.length() > 0) {
            System.out.println("Valid username");
        } else {
            System.out.println("Short-Circuit Success: Program crash hone se bach gaya!");
        }

        // Divide by Zero se bachna:
        int divisor = 0;
        int number = 100;
        // Pehla check divisor != 0 false ho gaya, toh number / divisor execute hi nahi hoga
        if (divisor != 0 && (number / divisor) > 2) {
            System.out.println("Result calculated");
        } else {
            System.out.println("Short-Circuit ne Divide By Zero Exception se bacha liya!");
        }
        System.out.println();

        // ====================================================================
        // SECTION 5: TERNARY OPERATOR (if-else ka Shortcut)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Syntax: (Condition) ? (True hone par value) : (False hone par value);
        // Step 1: Pehle condition evaluate hoti hai (boolean true/false).
        // Step 2: Agar true hai -> ':' ke pehle wala part execute hoga.
        // Step 3: Agar false hai -> ':' ke baad wala part execute hoga.
        System.out.println("--- 5. Ternary Operator Working ---");

        int batteryLevel = 15;
        boolean isLowBattery = batteryLevel < 20;

        // Condition check: (isLowBattery == true) -> "Please connect charger"
        String batteryMessage = isLowBattery ? "Low Battery! Please connect charger." : "Battery is sufficient.";
        System.out.println("Battery: " + batteryLevel + "% -> " + batteryMessage);
        System.out.println();

        // ====================================================================
        // SECTION 6: STRING TO BOOLEAN PARSING (Boolean.parseBoolean)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Java ka `Boolean.parseBoolean(str)` method check karta hai:
        // Agar string "true" (case-insensitive jaise "TRUE", "True", "tRuE") hai toh `true` dega.
        // Uske alawa KUCH BHI ho (jaise "1", "yes", "ok", "false", null), toh ye `false` return karta hai.
        System.out.println("--- 6. String to Boolean Parsing Working ---");

        String s1 = "true";
        String s2 = "TrUe";
        String s3 = "yes";
        String s4 = "1";

        System.out.println("Boolean.parseBoolean(\"true\") : " + Boolean.parseBoolean(s1) + " [Matched 'true']");
        System.out.println("Boolean.parseBoolean(\"TrUe\") : " + Boolean.parseBoolean(s2) + " [Case-insensitive match]");
        System.out.println("Boolean.parseBoolean(\"yes\")  : " + Boolean.parseBoolean(s3) + " [Not 'true' -> False]");
        System.out.println("Boolean.parseBoolean(\"1\")    : " + Boolean.parseBoolean(s4) + " [Java doesn't treat 1 as true -> False]");

        System.out.println("\n==================================================");
        System.out.println("        BOOLEAN DEEP-DIVE DEMO COMPLETED!         ");
        System.out.println("==================================================");
    }
}
