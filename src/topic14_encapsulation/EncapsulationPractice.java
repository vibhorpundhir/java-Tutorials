package topic14_encapsulation;

/**
 * ============================================================================
 * TOPIC 14: ENCAPSULATION (PRACTICE QUESTIONS)
 * ============================================================================
 */

// ----------------------------------------------------------------------------
// PROBLEM 1: User Profile with Strict Validation
// ----------------------------------------------------------------------------
class UserProfile {
    private String username;
    private String email;
    private int age;

    public UserProfile(String username, String email, int age) {
        this.username = username;
        setEmail(email);
        setAge(age);
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    public void setEmail(String email) {
        // Validation: Email must contain '@' and '.'
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
            System.out.println("✅ Email updated: " + email);
        } else {
            System.out.println("❌ Invalid Email format: " + email);
        }
    }

    public void setAge(int age) {
        // Validation: Age must be between 18 and 100
        if (age >= 18 && age <= 100) {
            this.age = age;
            System.out.println("✅ Age updated: " + age);
        } else {
            System.out.println("❌ Invalid Age: " + age + " (Must be 18 to 100)");
        }
    }
}

// ----------------------------------------------------------------------------
// MAIN PRACTICE
// ----------------------------------------------------------------------------
public class EncapsulationPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 14: ENCAPSULATION PRACTICE             ");
        System.out.println("==================================================\n");

        UserProfile user = new UserProfile("john_dev", "john@google.com", 25);

        System.out.println("\n--- Testing Invalid Data Protection ---");
        user.setEmail("bad_email_format"); // Invalid
        user.setAge(12);                   // Invalid (underage)

        System.out.println("\n--- Testing Valid Data Update ---");
        user.setEmail("john.official@company.com");
        user.setAge(26);

        System.out.println("\nFinal User Details: " + user.getUsername() + " | " + user.getEmail() + " | Age: " + user.getAge());

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
