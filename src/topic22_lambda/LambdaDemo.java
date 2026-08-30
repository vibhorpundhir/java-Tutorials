package topic22_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ============================================================================
 * TOPIC 22: JAVA LAMBDA EXPRESSIONS (MODERN FUNCTIONAL PROGRAMMING)
 * ============================================================================
 * 
 * 📌 LAMBDA KYA HAI? (Java 8+ Feature)
 * - Lambda Expression ek "Anonymous Function" (Bina naam, bina return type, 
 *   bina access modifier ka short code block) hota hai.
 * - Syntax: `(parameters) -> { body expression }`
 * 
 * 📌 REQUIREMENT (@FunctionalInterface):
 * - Lambda sirf tab use ho sakta hai jab Interface ke andar SIRF 1 ABSTRACT METHOD ho!
 */

// ----------------------------------------------------------------------------
// 1. CUSTOM FUNCTIONAL INTERFACE
// ----------------------------------------------------------------------------
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

@FunctionalInterface
interface StringFormatter {
    String format(String input);
}

// ----------------------------------------------------------------------------
// MAIN DEMO
// ----------------------------------------------------------------------------
public class LambdaDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       TOPIC 22: JAVA LAMBDA EXPRESSIONS          ");
        System.out.println("==================================================\n");

        // ====================================================================
        // 1. BASIC LAMBDA EXPRESSIONS
        // ====================================================================
        System.out.println("--- 1. Math Operations with Lambdas ---");

        // Addition Lambda: (a, b) -> a + b
        MathOperation add = (a, b) -> a + b;

        // Multiplication Lambda: (a, b) -> a * b
        MathOperation multiply = (a, b) -> a * b;

        System.out.println("Add (20 + 30)      : " + add.operate(20, 30));
        System.out.println("Multiply (5 * 6)   : " + multiply.operate(5, 6));
        System.out.println();

        // Single Parameter Lambda (No brackets needed around input):
        StringFormatter shout = s -> s.toUpperCase() + "!!!";
        System.out.println("Formatted String   : " + shout.format("hello lambda"));
        System.out.println();

        // ====================================================================
        // 2. LAMBDAS WITH JAVA COLLECTIONS
        // ====================================================================
        System.out.println("--- 2. Lambdas with Collections (forEach & removeIf) ---");
        List<String> frameworkList = Arrays.asList("Spring Boot", "React", "Docker", "Kubernetes");

        // 🔹 forEach loop with Lambda:
        System.out.println("--> Printing with list.forEach(item -> ...):");
        frameworkList.forEach(tech -> System.out.println("  • Tech: " + tech));
        System.out.println();

        // 🔹 removeIf() with Predicate Lambda:
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(12, 5, 8, 19, 24, 7));
        System.out.println("Original Numbers : " + numbers);

        // Remove all Odd numbers (num % 2 != 0)
        numbers.removeIf(n -> n % 2 != 0);
        System.out.println("Even Numbers Only: " + numbers);
        System.out.println();

        // ====================================================================
        // 3. METHOD REFERENCE ('::' Shortcut for Lambdas)
        // ====================================================================
        // 's -> System.out.println(s)' ki jagah 'System.out::println' likh sakte hain
        System.out.println("--- 3. Method Reference (::) ---");
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Bangalore");
        cities.forEach(System.out::println);

        System.out.println("\n==================================================");
        System.out.println("           LAMBDA DEMO COMPLETED!                 ");
        System.out.println("==================================================");
    }
}
