package topic10_packages.model;

/**
 * ============================================================================
 * MODEL PACKAGE: UserAccount (Demonstrating Access Modifiers)
 * ============================================================================
 * 
 * 📌 4 ACCESS MODIFIERS IN JAVA:
 * 1. public    -> Kahin se bhi access ho sakta hai (Any package, any class).
 * 2. protected -> Same package mein + Doosre package ke SUBCLASSES (Inheritance) mein.
 * 3. default   -> (Koi keyword nahi likha) -> SIRF SAME PACKAGE mein access ho sakta hai (Package-Private).
 * 4. private   -> SIRF IS CLASS KE ANDAR access ho sakta hai (Bahar kahin nahi).
 */
public class UserAccount {

    // 1. PUBLIC: Accessible everywhere
    public String username;

    // 2. PROTECTED: Accessible in same package + Subclasses in other packages
    protected String userRole;

    // 3. DEFAULT (Package-Private): Accessible ONLY within 'topic10_packages.model' package
    int failedLoginAttempts;

    // 4. PRIVATE: Accessible ONLY inside this UserAccount class
    private String passwordHash;

    // Constructor
    public UserAccount(String username, String userRole, String rawPassword) {
        this.username = username;
        this.userRole = userRole;
        this.failedLoginAttempts = 0;
        this.passwordHash = hashPassword(rawPassword);
    }

    // Private Helper Method
    private String hashPassword(String password) {
        return "SHA256_HASHED_" + password;
    }

    // Public method to verify password (Encapsulation)
    public boolean checkPassword(String inputPassword) {
        return this.passwordHash.equals(hashPassword(inputPassword));
    }

    // Public method to display summary
    public void displayPublicInfo() {
        System.out.println("User: " + username + " | Role: " + userRole + " | Failed Attempts: " + failedLoginAttempts);
    }
}
