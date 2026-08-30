package topic23_sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ============================================================================
 * TOPIC 23: ADVANCED SORTING (PRACTICE QUESTIONS)
 * ============================================================================
 */
class Student {
    String name;
    int marks;
    int age;

    public Student(String name, int marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " [Marks: " + marks + ", Age: " + age + "]";
    }
}

public class AdvancedSortingPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      TOPIC 23: ADVANCED SORTING PRACTICE         ");
        System.out.println("==================================================");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Rahul", 85, 21));
        students.add(new Student("Priya", 95, 20));
        students.add(new Student("Amit", 85, 22)); // Same marks as Rahul, but older
        students.add(new Student("Sneha", 90, 19));

        // --------------------------------------------------------------------
        // QUESTION: Chained Sorting (Sort by Marks DESCENDING, then by Age ASCENDING)
        // --------------------------------------------------------------------
        System.out.println("--- Chained Sorting (Marks High->Low, then Age Young->Old) ---");

        students.sort(
            Comparator.comparing(Student::getMarks).reversed()
                      .thenComparing(Student::getAge)
        );

        students.forEach(System.out::println);

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
