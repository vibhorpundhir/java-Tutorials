package topic02_strings;

/**
 * ============================================================================
 * TOPIC 02: STRINGS (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein String ke 5 popular real-world & interview coding questions hain.
 */
public class StringPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       TOPIC 02: STRING PRACTICE QUESTIONS        ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // QUESTION 1: Reverse a String (Without built-in reverse method)
        // --------------------------------------------------------------------
        // Problem: String "JavaDeveloper" ko ulta karke print karein.
        System.out.println("--- Question 1: Reverse a String ---");
        String original = "JavaDeveloper";
        String reversed = "";

        // Loop peeche se aage chalayenge (last index se 0 tak)
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        System.out.println("Original String : " + original);
        System.out.println("Reversed String : " + reversed);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 2: Palindrome String Checker
        // --------------------------------------------------------------------
        // Problem: Check karein ki string aage aur peeche se same hai ya nahi (e.g., "racecar", "madam").
        System.out.println("--- Question 2: Palindrome Checker ---");
        String word = "racecar";
        boolean isPalindrome = true;

        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Word to check   : \"" + word + "\"");
        System.out.println("Is Palindrome?  : " + isPalindrome);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 3: Count Vowels (a, e, i, o, u) & Consonants
        // --------------------------------------------------------------------
        // Problem: Ek sentence mein kitne vowels aur consonants hain count karein.
        System.out.println("--- Question 3: Vowels & Consonants Counter ---");
        String sentence = "Learning Java is Fun";
        int vowels = 0;
        int consonants = 0;

        String lowerSentence = sentence.toLowerCase();
        for (int i = 0; i < lowerSentence.length(); i++) {
            char ch = lowerSentence.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // Sirf alphabets consider karenge
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Input Sentence  : \"" + sentence + "\"");
        System.out.println("Total Vowels    : " + vowels);
        System.out.println("Total Consonants: " + consonants);
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 4: Email Address Parser (Username & Domain Extractor)
        // --------------------------------------------------------------------
        // Problem: "john.doe@company.com" me se username aur domain name alag karein.
        System.out.println("--- Question 4: Email Extractor ---");
        String email = "john.doe@company.com";

        int atIndex = email.indexOf('@');
        if (atIndex != -1) {
            String username = email.substring(0, atIndex);
            String domain = email.substring(atIndex + 1);

            System.out.println("Full Email      : " + email);
            System.out.println("Username        : " + username);
            System.out.println("Domain          : " + domain);
        }
        System.out.println();

        // --------------------------------------------------------------------
        // QUESTION 5: Count Words in a Sentence
        // --------------------------------------------------------------------
        // Problem: String mein total kitne words hain calculate karein.
        System.out.println("--- Question 5: Word Counter ---");
        String speech = "Practice makes a coder perfect in Java";
        String[] words = speech.trim().split(" ");

        System.out.println("Input Text      : \"" + speech + "\"");
        System.out.println("Total Words     : " + words.length);

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
