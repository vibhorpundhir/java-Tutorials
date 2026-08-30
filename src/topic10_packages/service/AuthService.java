package topic10_packages.service;

// 📌 IMPORT STATEMENT:
// Kyunki 'UserAccount' doosre package ('topic10_packages.model') me hai,
// isliye hume usko yahan 'import' karna padega.
import topic10_packages.model.UserAccount;

/**
 * ============================================================================
 * SERVICE PACKAGE: AuthService (Demonstrating Cross-Package Access)
 * ============================================================================
 */
public class AuthService {

    public boolean login(UserAccount user, String enteredPassword) {
        System.out.println("AuthService: Attempting login for user -> " + user.username);

        // 🔹 Public member access: Allowed!
        // System.out.println(user.username); // ✅ YES: public hai

        // 🔹 Private member access: NOT ALLOWED!
        // System.out.println(user.passwordHash); // ❌ COMPILE ERROR! private hai

        // 🔹 Default (Package-Private) access: NOT ALLOWED!
        // System.out.println(user.failedLoginAttempts); // ❌ COMPILE ERROR! Alag package hai

        // 🔹 Public method ke through verification: Allowed!
        boolean isSuccess = user.checkPassword(enteredPassword);

        if (isSuccess) {
            System.out.println("AuthService: Login SUCCESSFUL for " + user.username + "!");
        } else {
            System.out.println("AuthService: Login FAILED! Incorrect Password.");
        }

        return isSuccess;
    }
}
