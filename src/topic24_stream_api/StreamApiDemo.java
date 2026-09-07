package topic24_stream_api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ============================================================================
 * TOPIC 24: JAVA 8 STREAM API & STREAM VS COLLECTIONS/LOOPS
 * ============================================================================
 * 
 * 📌 STREAM API KYA HAI? (Java 8 Feature)
 * - Stream Java me Collections (List, Set) ya Arrays ke data ko process
 *   karne ka ek "Functional & Declarative" pipeline hota hai.
 * - Ye data ko STORE nahi karta, balki data par OPERATIONS (Filter, Map, Sort, 
 *   Reduce) perform karke result produce karta hai.
 * 
 * 📌 STREAM PIPELINE KE 3 PARTS HOTE HAIN:
 *   1. SOURCE                : List, Set, Array, etc. (e.g., list.stream())
 *   2. INTERMEDIATE OPS      : filter(), map(), sorted(), distinct(), limit() (Lazy execution)
 *   3. TERMINAL OP           : collect(), forEach(), count(), reduce(), min(), max() (Eager execution)
 * 
 * 📌 KEY DIFFERENCE (Stream API vs Traditional Loops / Collections):
 * -----------------------------------------------------------------------------
 * Feature                 Traditional Collections/Loops       Stream API
 * -----------------------------------------------------------------------------
 * Data Storage            Stores elements in memory           Does NOT store data
 * Programming Style       Imperative (HOW to do - loops)      Declarative (WHAT to do)
 * Execution               Eager (instantly on call)           Lazy (runs only when terminal op is called)
 * Modifies Source?        Can modify original list            Never modifies original source (Pure functions)
 * Reusability             Can iterate multiple times          Can be consumed ONLY ONCE
 * Parallel Execution      Complex multi-threading code        Easy with .parallelStream()
 * -----------------------------------------------------------------------------
 */

// Sample Data Class for Demonstration
class Student {
    private int id;
    private String name;
    private double marks;
    private String department;

    public Student(int id, String name, double marks, String department) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("[%d] %-10s | %5.1f | %s", id, name, marks, department);
    }
}

public class StreamApiDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       TOPIC 24: JAVA STREAM API & COMPARISON     ");
        System.out.println("==================================================\n");

        List<Student> students = Arrays.asList(
            new Student(101, "Aman", 88.5, "Computer Science"),
            new Student(102, "Pooja", 94.0, "Information Tech"),
            new Student(103, "Rahul", 65.0, "Computer Science"),
            new Student(104, "Sneha", 91.5, "Electronics"),
            new Student(105, "Vikram", 58.0, "Information Tech"),
            new Student(106, "Neha", 78.5, "Computer Science")
        );

        // ====================================================================
        // 1. TRADITIONAL LOOP VS STREAM API (LIVE COMPARISON)
        // ====================================================================
        System.out.println("--- 1. Traditional Loop vs Stream API (Diff Demo) ---");
        System.out.println("Goal: Find uppercase names of CS students with marks > 70");

        // ❌ TRADITIONAL WAY (Imperative - 8+ lines of code):
        List<String> csToppersOldWay = new ArrayList<>();
        for (Student s : students) {
            if (s.getDepartment().equals("Computer Science") && s.getMarks() > 70) {
                csToppersOldWay.add(s.getName().toUpperCase());
            }
        }
        System.out.println("Old Way Result : " + csToppersOldWay);

        // ✅ STREAM API WAY (Declarative - Single clean readable pipeline):
        List<String> csToppersStreamWay = students.stream()
            .filter(s -> s.getDepartment().equals("Computer Science")) // Filter dept
            .filter(s -> s.getMarks() > 70)                            // Filter marks
            .map(s -> s.getName().toUpperCase())                       // Transform to uppercase String
            .collect(Collectors.toList());                             // Terminal Operation: Collect to List

        System.out.println("Stream Result  : " + csToppersStreamWay);
        System.out.println();

        // ====================================================================
        // 2. CORE INTERMEDIATE OPERATIONS
        // ====================================================================
        System.out.println("--- 2. Intermediate Operations (filter, map, sorted, distinct, limit) ---");
        List<Integer> numbers = Arrays.asList(5, 12, 8, 5, 20, 15, 8, 30, 2);

        System.out.println("Original Numbers: " + numbers);

        // Chain multiple operations:
        List<Integer> processedNumbers = numbers.stream()
            .filter(n -> n > 6)                 // Keep numbers > 6
            .distinct()                         // Remove duplicates (removes duplicate 8)
            .sorted((a, b) -> b - a)            // Sort descending using Lambda Comparator
            .map(n -> n * 2)                    // Double each number
            .limit(4)                           // Take first 4 elements
            .collect(Collectors.toList());

        System.out.println("Processed Numbers: " + processedNumbers);
        System.out.println();

        // ====================================================================
        // 3. STRING PROCESSING USING STREAM API & LAMBDAS
        // ====================================================================
        System.out.println("--- 3. String Processing with Streams & Lambdas ---");

        // A. Filter & Join Strings with delimiter:
        List<String> skills = Arrays.asList("Java", "Spring Boot", "SQL", "Docker", "AWS", "Kubernetes");
        String joinedSkills = skills.stream()
            .filter(s -> s.length() > 3)                   // Only skills with length > 3
            .map(String::toUpperCase)                      // Method reference for s -> s.toUpperCase()
            .collect(Collectors.joining(" -> "));          // Join with arrow

        System.out.println("Joined Skills: " + joinedSkills);

        // B. Stream over String Characters:
        String sentence = "Hello Java 8 Stream API";
        long vowelCount = sentence.chars()                 // Returns IntStream of ASCII chars
            .mapToObj(c -> (char) c)                       // Convert int to Character
            .filter(c -> "AEIOUaeiou".indexOf(c) != -1)    // Filter only vowels
            .count();                                      // Count terminal operation

        System.out.println("Sentence: \"" + sentence + "\"");
        System.out.println("Total Vowels Count: " + vowelCount);
        System.out.println();

        // ====================================================================
        // 4. TERMINAL OPERATIONS: REDUCE & AGGREGATION
        // ====================================================================
        System.out.println("--- 4. Terminal Operations (reduce, min, max, count) ---");

        List<Integer> marksList = Arrays.asList(85, 92, 78, 64, 99, 88);

        // A. Sum using reduce():
        int totalMarks = marksList.stream()
            .reduce(0, (sum, current) -> sum + current);
        System.out.println("Total Sum (reduce) : " + totalMarks);

        // B. Max & Min using Streams:
        int highest = marksList.stream().max(Integer::compareTo).orElse(0);
        int lowest = marksList.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Highest Mark       : " + highest);
        System.out.println("Lowest Mark        : " + lowest);

        // C. anyMatch / allMatch / noneMatch:
        boolean hasDistinction = marksList.stream().anyMatch(m -> m >= 90);
        boolean allPassed = marksList.stream().allMatch(m -> m >= 35);
        System.out.println("Has any 90+ score? : " + hasDistinction);
        System.out.println("All students pass? : " + allPassed);
        System.out.println();

        // ====================================================================
        // 5. ADVANCED COLLECTORS: GROUPING & STATISTICS
        // ====================================================================
        System.out.println("--- 5. Advanced Collectors (groupingBy & summarizing) ---");

        // Group students by Department:
        Map<String, List<Student>> studentsByDept = students.stream()
            .collect(Collectors.groupingBy(Student::getDepartment));

        System.out.println("--> Students Grouped by Department:");
        studentsByDept.forEach((dept, list) -> {
            System.out.println("  📍 " + dept + " (" + list.size() + " students):");
            list.forEach(s -> System.out.println("      " + s));
        });

        // Summary Statistics (Average, Count, Min, Max in one call):
        DoubleSummaryStatistics stats = students.stream()
            .collect(Collectors.summarizingDouble(Student::getMarks));

        System.out.println("\n--> Class Performance Summary:");
        System.out.println("  • Average Marks : " + String.format("%.2f", stats.getAverage()));
        System.out.println("  • Max Marks     : " + stats.getMax());
        System.out.println("  • Min Marks     : " + stats.getMin());
        System.out.println("  • Total Students: " + stats.getCount());

        // ====================================================================
        // 6. PARALLEL STREAMS (MULTI-CORE PROCESSING)
        // ====================================================================
        System.out.println("\n--- 6. Parallel Streams (.parallelStream()) ---");
        System.out.println("Using multiple CPU cores simultaneously for large datasets:");

        List<Integer> largeList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        
        System.out.println("Sequential Stream Execution:");
        largeList.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("Parallel Stream Execution (Executed by multiple threads in parallel):");
        largeList.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\n==================================================");
        System.out.println("       STREAM API DEMO COMPLETED!                 ");
        System.out.println("==================================================");
    }
}
