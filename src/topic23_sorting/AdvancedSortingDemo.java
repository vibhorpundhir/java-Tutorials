package topic23_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ============================================================================
 * TOPIC 23: JAVA ADVANCED SORTING (COMPARABLE VS COMPARATOR & LAMBDAS)
 * ============================================================================
 * 
 * 📌 COMPARABLE VS COMPARATOR (INTERVIEW MEIN HAMESHA PUCHA JATA HAI):
 * 
 * 1. Comparable<T> (Natural / Default Sorting):
 *    - Class ke andar hi implement hota hai (`class Student implements Comparable<Student>`).
 *    - Method: `compareTo(Student other)`.
 *    - Sirf 1 Default Sorting logic de sakta hai (e.g. Hamesha Roll Number se sort hona).
 * 
 * 2. Comparator<T> (Custom / Multiple Sorting Logics):
 *    - Class ke bahar alag se banta hai ya direct Lambda expression se banta hai.
 *    - Method: `compare(T o1, T o2)`.
 *    - Ek hi class ke MULTIPLE criteria se sorting kar sakta hai (Sort by Name, Sort by Salary, Sort by Age).
 */

// ----------------------------------------------------------------------------
// 1. CLASS IMPLEMENTING COMPARABLE (Default sort by ID)
// ----------------------------------------------------------------------------
class Product implements Comparable<Product> {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // 🔹 compareTo: Natural sort by ID (Ascending)
    // - Negative: this.id chota hai other.id se
    // - Zero    : Dono barabar hain
    // - Positive: this.id bada hai other.id se
    @Override
    public int compareTo(Product other) {
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return "Product [#" + id + " " + name + " - Rs. " + price + "]";
    }
}

// ----------------------------------------------------------------------------
// MAIN DEMO
// ----------------------------------------------------------------------------
public class AdvancedSortingDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      TOPIC 23: JAVA ADVANCED SORTING DEMO        ");
        System.out.println("==================================================\n");

        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product(103, "Mechanical Keyboard", 4500.0));
        catalog.add(new Product(101, "Gaming Laptop", 85000.0));
        catalog.add(new Product(104, "Wireless Mouse", 1200.0));
        catalog.add(new Product(102, "Monitor 4K", 28000.0));

        System.out.println("--- 1. Original Unsorted Catalog ---");
        catalog.forEach(System.out::println);
        System.out.println();

        // ====================================================================
        // 1. DEFAULT SORTING USING COMPARABLE (Sort by ID)
        // ====================================================================
        System.out.println("--- 2. Natural Sorting via Comparable (Sort by ID Ascending) ---");
        Collections.sort(catalog);
        catalog.forEach(System.out::println);
        System.out.println();

        // ====================================================================
        // 2. CUSTOM SORTING USING COMPARATOR (Lambda: Sort by Price)
        // ====================================================================
        System.out.println("--- 3. Custom Sorting via Comparator Lambda (Price: Low to High) ---");
        catalog.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        catalog.forEach(System.out::println);
        System.out.println();

        // ====================================================================
        // 3. MODERN JAVA 8+ COMPARATOR (Sort by Name Alphabetically)
        // ====================================================================
        System.out.println("--- 4. Modern Comparator.comparing() (Alphabetical by Name) ---");
        catalog.sort(Comparator.comparing(p -> p.name));
        catalog.forEach(System.out::println);

        System.out.println("\n==================================================");
        System.out.println("       ADVANCED SORTING DEMO COMPLETED!           ");
        System.out.println("==================================================");
    }
}
