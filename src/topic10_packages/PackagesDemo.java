package topic10_packages;

// 1. Explicit Class Import (Sabse acchi practice)
import topic10_packages.model.UserAccount;
import topic10_packages.service.AuthService;

// 2. Built-in Java Packages Import
import java.util.ArrayList;
import java.util.Arrays;

// 3. Static Import (Class ke static methods/constants ko bina ClassName likhe use karna)
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * ============================================================================
 * TOPIC 10: PACKAGES & ACCESS MODIFIERS (THEORY + STEP-BY-STEP WORKING)
 * ============================================================================
 * 
 * 📌 PACKAGE KYA HOTA HAI?
 * - Package Java mein related Classes, Interfaces aur Sub-packages ka FOLDER (Container) hota hai.
 * - Jaise computer mein hum Songs, Movies aur Documents ke alag-alag folders banate hain.
 * 
 * 📌 PACKAGES KE 3 BADE FAAYDE:
 * 1. Name Collision Prevention: Agar do developers ne 'User' naam ki class banayi, 
 *    toh unhe 'com.company1.User' aur 'com.company2.User' me alag-alag rakha ja sakta hai.
 * 2. Access Protection: 'package-private' (default) aur 'protected' se data ko restrict kiya ja sakta hai.
 * 3. Easy Code Organization: Real projects me Model, Service, Controller, Utils ke alag packages hote hain.
 * 
 * 📌 ACCESS MODIFIER VISIBILITY MATRIX:
 * ┌──────────────┬────────────┬──────────────┬──────────────────┬─────────────────┐
 * │ Modifier     │ Same Class │ Same Package │ Subclass(Diff Pkg)│ Different Package│
 * ├──────────────┼────────────┼──────────────┼──────────────────┼─────────────────┤
 * │ public       │    YES     │     YES      │       YES        │       YES       │
 * │ protected    │    YES     │     YES      │       YES        │        NO       │
 * │ default      │    YES     │     YES      │        NO        │        NO       │
 * │ private      │    YES     │      NO      │        NO        │        NO       │
 * └──────────────┴────────────┴──────────────┴──────────────────┴─────────────────┘
 */
public class PackagesDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 10: PACKAGES & ACCESS MODIFIERS        ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. CROSS-PACKAGE IMPORT & USAGE
        // ====================================================================
        System.out.println("--- 1. Cross-Package Interaction ---");

        // Model package se UserAccount object banaya
        UserAccount adminUser = new UserAccount("john_doe", "ADMIN", "SecretPass123");
        adminUser.displayPublicInfo();
        System.out.println();

        // Service package se AuthService object banaya
        AuthService auth = new AuthService();
        auth.login(adminUser, "WrongPassword");  // Fail check
        auth.login(adminUser, "SecretPass123");  // Success check
        System.out.println();

        // ====================================================================
        // 2. STATIC IMPORT DEMO
        // ====================================================================
        // KAISE KAAM KARTA HAI:
        // 'import static java.lang.Math.*' lagane se hume 'Math.PI' ya 'Math.sqrt()'
        // likhne ki zaroorat nahi padti, direct 'PI' aur 'sqrt()' use kar sakte hain!
        System.out.println("--- 2. Static Imports in Java ---");
        System.out.println("Value of PI           : " + PI);
        System.out.println("Square root of 64     : " + sqrt(64));
        System.out.println("Power 2^8             : " + pow(2, 8));
        System.out.println();

        // ====================================================================
        // 3. HANDLING SAME-NAME CLASSES FROM DIFFERENT PACKAGES (NAME CONFLICTS)
        // ====================================================================
        // KAISE SOLVE HOTA HAI:
        // Java me 'java.util.Date' bhi hota hai aur 'java.sql.Date' bhi hota hai.
        // Agar dono ko ek sath use karna ho, toh FULLY QUALIFIED NAME likha jata hai:
        System.out.println("--- 3. Handling Name Collisions (Fully Qualified Names) ---");

        java.util.Date utilDate = new java.util.Date(); // System current date/time
        System.out.println("java.util.Date object : " + utilDate);

        long currentTimeMillis = System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(currentTimeMillis); // Database date format
        System.out.println("java.sql.Date object  : " + sqlDate);

        System.out.println("\n==================================================");
        System.out.println("          PACKAGES DEMO COMPLETED!                ");
        System.out.println("==================================================");
    }
}
