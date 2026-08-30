package topic05_loops;

/**
 * ============================================================================
 * TOPIC 05: LOOPING STATEMENTS (THEORY + STEP-BY-STEP EXECUTION FLOW)
 * ============================================================================
 * 
 * 📌 LOOP KYA HOTA HAI?
 * - Jab hume ek hi code ko baar-baar repeat chalana ho, tab hum Loops ka use karte hain.
 * - For example: 1 se lekar 100 tak numbers print karna ya 1000 users ko email bhejna.
 * 
 * 📌 JAVA MEIN 3 MAIN LOOPS:
 * 1. for loop     -> Jab pehle se pata ho ki loop KITNI BAAR (fixed count) chalana hai.
 * 2. while loop   -> Entry-controlled loop (Jab loop tab tak chalana ho jab tak condition true rahe).
 * 3. do-while     -> Exit-controlled loop (Kam se kam 1 BAAR ZAROOR chalega, chahe condition false ho).
 * 
 * 📌 LOOP CONTROL STATEMENTS:
 * - break    -> Loop ko turant terminate (rok) deta hai.
 * - continue -> Current step/iteration ko chhod kar turant agle step par chala jata hai.
 */
public class LoopsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 05: LOOPING STATEMENTS DEEP-DIVE       ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. 'for' LOOP (STEP-BY-STEP EXECUTION FLOW)
        // ====================================================================
        // KAISE KAAM KARTA HAI (INTERNAL 4 STEPS):
        // Syntax: for (Initialization; Condition; Update)
        //
        // Step 1: [Initialization] -> 'int i = 1' (Ye poore loop me SIRF 1 BAAR chalta hai shuru me).
        // Step 2: [Condition Check] -> 'i <= 5' check hota hai.
        //         - Agar TRUE hai  -> Loop body { ... } execute hogi.
        //         - Agar FALSE hai -> Loop turant khatam ho jayega.
        // Step 3: [Body Execution]  -> Console par print hoga.
        // Step 4: [Update]          -> 'i++' (i ki value 1 badh jayegi).
        //         Wapas Step 2 par jayega aur condition check karega.
        System.out.println("--- 1. 'for' Loop (Print 1 to 5) ---");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i + ": Value of i = " + i);
        }
        System.out.println();

        // ====================================================================
        // 2. 'while' LOOP (ENTRY-CONTROLLED LOOP)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // 1. Loop ke andar ghusne se pehle hi condition check hoti hai.
        // 2. Agar shuru me hi condition 'false' hui, toh loop EK BAAR BHI NAHI chalega.
        // 3. Loop ke andar variable ko update (increment/decrement) karna zaroori hai,
        //    warna loop kabbhi nahi rukega (INFINITE LOOP ban jayega!).
        System.out.println("--- 2. 'while' Loop (Countdown 5 to 1) ---");

        int count = 5; // Initialization loop ke bahar
        while (count >= 1) { // Condition check
            System.out.println("Countdown: " + count);
            count--; // Update step (Decrease by 1)
        }
        System.out.println("Blast Off! 🚀\n");

        // ====================================================================
        // 3. 'do-while' LOOP (EXIT-CONTROLLED LOOP)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // 1. Pehle loop body { ... } chal jati hai, USKE BAAD condition check hoti hai.
        // 2. Iska matlab: Chahe condition pehli baar me hi FALSE kyu na ho, 
        //    ye loop AT LEAST 1 TIME zaroor chalega!
        System.out.println("--- 3. 'do-while' Loop (Guaranteed 1 Run) ---");

        int num = 10;
        do {
            System.out.println("Ye line kam se kam 1 baar zaroor print hogi! num = " + num);
            num++;
        } while (num < 5); // 11 < 5 FALSE hai, phir bhi upar wala code 1 baar chala!

        System.out.println("Condition false hone par do-while loop exit ho gaya.\n");

        // ====================================================================
        // 4. 'break' VS 'continue' STATEMENT
        // ====================================================================
        // 🔹 'break': Loop ko turant permanently band kar deta hai.
        // 🔹 'continue': Sirf current round ko skip karke agle round par chala jata hai.
        System.out.println("--- 4. 'break' vs 'continue' Demo ---");

        System.out.println("--> Testing 'continue' (Skip number 3):");
        for (int k = 1; k <= 5; k++) {
            if (k == 3) {
                System.out.println("  [Skip kar rahe hain k = 3 ko]");
                continue; // 3 print nahi hoga, seedha k=4 par jump karega
            }
            System.out.println("  k = " + k);
        }

        System.out.println("\n--> Testing 'break' (Stop loop when k == 4):");
        for (int k = 1; k <= 5; k++) {
            if (k == 4) {
                System.out.println("  [k == 4 mil gaya! Loop band kar rahe hain]");
                break; // Loop yahin khatam, 4 aur 5 kabhi print nahi honge
            }
            System.out.println("  k = " + k);
        }
        System.out.println();

        // ====================================================================
        // 5. NESTED LOOPS (Loop ke andar doosra Loop)
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // Bahar wala loop (Outer loop) rows ke liye chalta hai.
        // Andar wala loop (Inner loop) columns ke liye chalta hai.
        // Outer loop ke HAR 1 round ke liye, Inner loop APNA POORA CHAKKAR lagata hai.
        System.out.println("--- 5. Nested Loops (2x3 Grid Matrix) ---");

        for (int row = 1; row <= 2; row++) {
            for (int col = 1; col <= 3; col++) {
                System.out.print("[" + row + "," + col + "] ");
            }
            System.out.println(); // Har row ke baad new line
        }

        System.out.println("\n==================================================");
        System.out.println("           LOOPS DEMO COMPLETED!                  ");
        System.out.println("==================================================");
    }
}
