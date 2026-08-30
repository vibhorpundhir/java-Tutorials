package topic02_strings;

import java.util.Arrays;

/**
 * ============================================================================
 * TOPIC 02: STRINGS IN JAVA (DEEP DIVE + OPERATION-BY-OPERATION EXPLANATION)
 * ============================================================================
 * 
 * 📌 STRING KYA HAI?
 * - String characters (alphabets, numbers, symbols) ka group / sequence hoti hai.
 * - Java mein String koi primitive data type nahi hai, balki `java.lang.String` Class ka Object hai.
 * 
 * 📌 3 SABSE IMPORTANT RULES:
 * 1. Immutability: String ki value kabhi badal nahi sakti. Har badlaav par NAYA object banta hai.
 * 2. SCP (String Constant Pool): Memory bachane ke liye Java same string literals ko reuse karta hai.
 * 3. 0-based Indexing: String ka pehla character index 0 par, doosra index 1 par hota hai.
 */
public class StringDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       TOPIC 02: STRING OPERATIONS DEEP-DIVE      ");
        System.out.println("==================================================\n");

        // ====================================================================
        // SECTION 1: STRING CREATION & MEMORY WORKING (SCP vs HEAP)
        // ====================================================================
        System.out.println("--- 1. String Creation & Memory Working ---");

        // 🔹 Operation: String Literal se banana
        // KAISE KAAM KARTA HAI:
        // Java Heap memory ke andar ek special jagah banata hai jisko 'SCP' (String Constant Pool) kehte hain.
        // Jab hum "Java" likhte hain, Java SCP mein check karta hai: kya "Java" pehle se hai?
        // Agar nahi hai, toh SCP mein "Java" bana deta hai aur s1 ko uska address de deta hai.
        String s1 = "Java";

        // Jab s2 = "Java" likha, toh Java ne dekha SCP mein "Java" already exist karta hai!
        // Isliye Java ne naya object NAHI banaya, balki wahi purana address s2 ko bhi de diya.
        String s2 = "Java";

        // 🔹 Operation: 'new' Keyword se banana
        // KAISE KAAM KARTA HAI:
        // 'new' keyword Java ko force karta hai ki SCP ke bahar general Heap Memory mein ek 
        // bilkul NAYA aur ALAG object banao, chahe "Java" pehle se SCP mein ho!
        String s3 = new String("Java");

        System.out.println("s1: " + s1 + ", s2: " + s2 + ", s3: " + s3);
        System.out.println();

        // ====================================================================
        // SECTION 2: COMPARISON OPERATORS (== vs .equals())
        // ====================================================================
        System.out.println("--- 2. String Comparison Operations ---");

        // 🔹 Operation: '==' Operator
        // KAISE KAAM KARTA HAI:
        // Ye text ko nahi dekhta, ye dono variables ke 'Memory Address' (Reference) ko compare karta hai.
        // s1 aur s2 dono SCP ke same memory address ko point kar rahe hain -> Isliye TRUE.
        // s1 aur s3 ka memory address alag-alag hai -> Isliye FALSE.
        System.out.println("s1 == s2 (Memory Address Check) : " + (s1 == s2) + " [Dono SCP mein same address par hain]");
        System.out.println("s1 == s3 (Memory Address Check) : " + (s1 == s3) + " [s3 Heap mein naya object hai]");

        // 🔹 Operation: .equals() Method
        // KAISE KAAM KARTA HAI:
        // Ye memory address nahi dekhta! Ye character-by-character dono strings ka actual content check karta hai.
        // s1 ke andar 'J'-'a'-'v'-'a' hai aur s3 ke andar bhi 'J'-'a'-'v'-'a' hai -> Isliye TRUE.
        System.out.println("s1.equals(s3) (Content Check)   : " + s1.equals(s3) + " [Kyunki dono ka text 'Java' same hai]");

        // 🔹 Operation: .equalsIgnoreCase() Method
        // KAISE KAAM KARTA HAI:
        // Ye small aur capital letters ka farq ignore karke sirf spelling match karta hai.
        String upperCaseJava = "JAVA";
        System.out.println("s1.equals(\"JAVA\")              : " + s1.equals(upperCaseJava) + " [Case alag hai: 'Java' vs 'JAVA']");
        System.out.println("s1.equalsIgnoreCase(\"JAVA\")   : " + s1.equalsIgnoreCase(upperCaseJava) + " [Case ignore karke match kiya]");
        System.out.println();

        // ====================================================================
        // SECTION 3: IMMUTABILITY (Value Change Na Hone Ka Concept)
        // ====================================================================
        System.out.println("--- 3. String Immutability Demo ---");

        // 🔹 Operation: .concat() Method
        // KAISE KAAM KARTA HAI:
        // language.concat(" World") do strings ko jodta hai.
        // LEKIN String immutable hai, toh ye purane 'language' variable ko modify NAHI karega.
        // Balki memory mein ek naya "Hello World" create karega.
        String greeting = "Hello";
        greeting.concat(" World"); // Humne is naye result ko kisi variable mein store nahi kiya
        System.out.println("greeting.concat() ke baad     : " + greeting + " [Dekho 'Hello' hi raha, change nahi hua!]");

        // Agar hum naye object ko wapas greeting variable ko assign kar dein:
        greeting = greeting.concat(" World"); // Ab greeting naye "Hello World" object ko point karne laga
        System.out.println("greeting = greeting.concat()   : " + greeting + " [Ab naya reference store ho gaya]");
        System.out.println();

        // ====================================================================
        // SECTION 4: ALL ESSENTIAL STRING METHODS & UNKA WORKING LOGIC
        // ====================================================================
        System.out.println("--- 4. String Methods (Kaise Kaam Karte Hain) ---");

        String sample = "  Core Java Programming  ";
        System.out.println("Original String: \"" + sample + "\"");

        // 1️⃣ .length()
        // KAISE KAAM KARTA HAI: String ke andar kitne total characters (spaces mila kar) hain, unka count return karta hai.
        int len = sample.length();
        System.out.println("1. sample.length()             : " + len + " [Total characters including spaces]");

        // 2️⃣ .trim()
        // KAISE KAAM KARTA HAI: String ke sirf aage (start) aur peeche (end) ke faaltu spaces ko hata deta hai.
        // Beech ke spaces ko touch nahi karta.
        String trimmed = sample.trim();
        System.out.println("2. sample.trim()               : \"" + trimmed + "\" [Aage-peeche ke space hat gaye]");

        // 3️⃣ .charAt(index)
        // KAISE KAAM KARTA HAI: 0 se counting shuru karta hai aur diye gaye index par jo character hai wo laakar deta hai.
        // trimmed = "Core Java Programming" -> index 0='C', index 1='o', index 5='J'
        char chAt5 = trimmed.charAt(5);
        System.out.println("3. trimmed.charAt(5)           : '" + chAt5 + "' [Index 5 wala character]");

        // 4️⃣ .substring(startIndex, endIndex)
        // KAISE KAAM KARTA HAI:
        // String me se ek tukda (sub-part) nikalta hai.
        // Rule: 'startIndex' INCLUDE hota hai, lekin 'endIndex' EXCLUDE (chhod diya) jata hai.
        // substring(5, 9) matlab index 5 se shuru karega aur index 8 tak lega (5, 6, 7, 8 -> 4 characters = "Java").
        // Trick: Nikli hui string ki length hamesha (endIndex - startIndex) hoti hai (9 - 5 = 4).
        String sub = trimmed.substring(5, 9);
        System.out.println("4. trimmed.substring(5, 9)     : \"" + sub + "\" [Index 5 se 8 tak ka hissa]");

        // 5️⃣ .substring(startIndex) - Single argument wala
        // KAISE KAAM KARTA HAI: startIndex se lekar poori string ke end tak sab le leta hai.
        String rest = trimmed.substring(10);
        System.out.println("   trimmed.substring(10)       : \"" + rest + "\" [Index 10 se aakhiri tak]");

        // 6️⃣ .toUpperCase() aur .toLowerCase()
        // KAISE KAAM KARTA HAI: Saare letters ko CAPITAL ya small mein badalta hai. Non-alphabets (digits, spaces) same rehte hain.
        System.out.println("5. trimmed.toUpperCase()       : \"" + trimmed.toUpperCase() + "\"");
        System.out.println("6. trimmed.toLowerCase()       : \"" + trimmed.toLowerCase() + "\"");

        // 7️⃣ .contains("text")
        // KAISE KAAM KARTA HAI: Check karta hai kya diya gaya word/character string ke andar kahin par bhi maujood hai.
        // Return type: boolean (true ya false). Case-sensitive hota hai!
        boolean hasJava = trimmed.contains("Java");
        System.out.println("7. trimmed.contains(\"Java\")     : " + hasJava + " [Kyunki 'Java' andar maujood hai]");
        System.out.println("   trimmed.contains(\"Python\")   : " + trimmed.contains("Python") + " ['Python' nahi mila]");

        // 8️⃣ .startsWith("prefix") aur .endsWith("suffix")
        // KAISE KAAM KARTA HAI:
        // startsWith check karta hai kya string shuru is word se hoti hai.
        // endsWith check karta hai kya string khatam is word par hoti hai.
        System.out.println("8. trimmed.startsWith(\"Core\")   : " + trimmed.startsWith("Core") + " [Shuru Core se hoti hai]");
        System.out.println("9. trimmed.endsWith(\"ming\")     : " + trimmed.endsWith("ming") + " [Khatam ming par hoti hai]");

        // 9️⃣ .indexOf("text")
        // KAISE KAAM KARTA HAI:
        // Left se search karna shuru karta hai aur pehli baar wo word/character kis index par mila wo number deta hai.
        // Agar wo word string me NAHI mila, toh hamesha '-1' return karta hai.
        int indexOfJava = trimmed.indexOf("Java");
        int indexOfNotFound = trimmed.indexOf("Kotlin");
        System.out.println("10. trimmed.indexOf(\"Java\")     : " + indexOfJava + " [Index 5 se shuru hota hai]");
        System.out.println("    trimmed.indexOf(\"Kotlin\")   : " + indexOfNotFound + " [-1 matlab word nahi mila]");

        // 🔟 .replace(oldChar, newChar) / .replace(oldString, newString)
        // KAISE KAAM KARTA HAI:
        // String me jahan-jahan purana word/char milega, uski jagah naya word/char fit kar dega.
        String replaced = trimmed.replace("Core", "Advanced");
        System.out.println("11. trimmed.replace(\"Core\",..)  : \"" + replaced + "\"");

        // 1️⃣1️⃣ .isEmpty() vs .isBlank() (Java 11+)
        // KAISE KAAM KARTA HAI:
        // isEmpty(): Sirf tab true dega jab length bilkul 0 ho ("").
        // isBlank(): Agar string me sirf spaces/tabs/newlines hain ("   "), tab bhi true dega (kyunki koi useful text nahi hai).
        String emptyStr = "";
        String spacesOnly = "   ";
        System.out.println("12. \"\".isEmpty()                 : " + emptyStr.isEmpty());
        System.out.println("    \"   \".isEmpty()             : " + spacesOnly.isEmpty() + " [False: kyunki spaces hain length > 0]");
        System.out.println("    \"   \".isBlank()             : " + spacesOnly.isBlank() + " [True: kyunki koi real text nahi hai]");

        // 1️⃣2️⃣ .split("delimiter")
        // KAISE KAAM KARTA HAI:
        // String ko kisi separator (jaise comma, space, hyphen) ke basis par alag-alag tukdon mein kaat kar ek Array (String[]) bana deta hai.
        String tags = "Java,Spring,Docker,Kubernetes";
        String[] tagArray = tags.split(","); // Har comma (,) par string ko tod do
        System.out.println("13. tags.split(\",\") Array       : " + Arrays.toString(tagArray));
        System.out.println("    Pehla Tag (index 0)        : " + tagArray[0]);
        System.out.println("    Total Tags Count           : " + tagArray.length);
        System.out.println();

        // ====================================================================
        // SECTION 5: STRINGBUILDER (MUTABLE STRING KI WORKING)
        // ====================================================================
        System.out.println("--- 5. StringBuilder (Fast & Mutable String) ---");

        // KAISE KAAM KARTA HAI:
        // Kyunki normal String har modification par naya object banati hai (memory slow ho jati hai).
        // StringBuilder ek internal expandable char[] array use karta hai.
        // Isme .append() karne se SAME memory location par text judta hai, naya object nahi banta!
        StringBuilder builder = new StringBuilder("Start");
        builder.append(" -> Step 1");
        builder.append(" -> Step 2");
        System.out.println("StringBuilder output           : " + builder.toString());

        // .reverse() method poori string ke characters ko ulta kar deta hai
        builder.reverse();
        System.out.println("builder.reverse() output       : " + builder.toString());

        System.out.println("\n==================================================");
        System.out.println("        STRING DEEP-DIVE DEMO COMPLETED!          ");
        System.out.println("==================================================");
    }
}
