package topic24_stream_api;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * TOPIC 24: STREAM API PRACTICE CHALLENGES
 * ============================================================================
 * 
 * CHALLENGES INCLUDED:
 * 1. Employee Management: Filter active employees, give 10% bonus, sort by salary.
 * 2. Word Frequency & String Analytics: Count frequency of each word in a paragraph.
 * 3. E-Commerce Order Aggregation: Calculate total revenue of DELIVERED orders.
 */

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private boolean active;

    public Employee(int id, String name, String department, double salary, boolean active) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public boolean isActive() { return active; }

    @Override
    public String toString() {
        return String.format("[%d] %-10s (%-11s) -> $%,10.2f | Status: %s",
            id, name, department, salary, active ? "Active" : "Inactive");
    }
}

class OrderItem {
    private String item;
    private int quantity;
    private double pricePerUnit;
    private String status; // "DELIVERED", "PENDING", "CANCELLED"

    public OrderItem(String item, int quantity, double pricePerUnit, String status) {
        this.item = item;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
    }

    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
    public double getPricePerUnit() { return pricePerUnit; }
    public String getStatus() { return status; }
    public double getTotalAmount() { return quantity * pricePerUnit; }
}

public class StreamApiPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 24: STREAM API PRACTICE PROBLEMS       ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // PROBLEM 1: EMPLOYEE FILTERING, SALARY HIKE & SORTING
        // --------------------------------------------------------------------
        System.out.println("--- Problem 1: Active IT Employees with Bonus Sorted by Salary ---");
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Vibhor", "IT", 85000, true),
            new Employee(2, "Amit", "HR", 50000, true),
            new Employee(3, "Rohan", "IT", 60000, false), // Inactive
            new Employee(4, "Priya", "IT", 95000, true),
            new Employee(5, "Simran", "Finance", 75000, true),
            new Employee(6, "Karan", "IT", 110000, true)
        );

        // Solution: Filter active IT employees -> Sort by salary descending -> Map names with new salary (+10%)
        List<String> itHikedSalaries = employees.stream()
            .filter(Employee::isActive)                                             // Only active
            .filter(e -> "IT".equalsIgnoreCase(e.getDepartment()))                  // Only IT
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())    // Highest salary first
            .map(e -> String.format("%s : Old: $%,.2f -> With 10%% Bonus: $%,.2f",
                e.getName(), e.getSalary(), e.getSalary() * 1.10))
            .collect(Collectors.toList());

        itHikedSalaries.forEach(line -> System.out.println("  • " + line));
        System.out.println();

        // --------------------------------------------------------------------
        // PROBLEM 2: WORD FREQUENCY IN STRING USING STREAMS
        // --------------------------------------------------------------------
        System.out.println("--- Problem 2: Word Frequency Counter with Stream API ---");
        String text = "java spring boot java microservices docker java docker spring";
        System.out.println("Input Text: \"" + text + "\"");

        // Solution: Split text by space -> Stream words -> Group by identity and count
        Map<String, Long> wordCounts = Arrays.stream(text.split("\\s+"))
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println("Word Frequencies:");
        wordCounts.forEach((word, count) -> 
            System.out.println(String.format("  %-15s : %d times", word, count)));
        System.out.println();

        // --------------------------------------------------------------------
        // PROBLEM 3: E-COMMERCE TOTAL REVENUE FOR DELIVERED ORDERS
        // --------------------------------------------------------------------
        System.out.println("--- Problem 3: E-Commerce Delivered Orders Revenue ---");
        List<OrderItem> orders = Arrays.asList(
            new OrderItem("MacBook Pro", 2, 1999.99, "DELIVERED"),
            new OrderItem("Wireless Mouse", 5, 29.99, "CANCELLED"),
            new OrderItem("Mechanical Keyboard", 3, 89.99, "DELIVERED"),
            new OrderItem("4K Monitor", 1, 399.99, "PENDING"),
            new OrderItem("USB-C Hub", 4, 34.99, "DELIVERED")
        );

        // Calculate total revenue of only DELIVERED orders
        double totalDeliveredRevenue = orders.stream()
            .filter(o -> "DELIVERED".equalsIgnoreCase(o.getStatus()))
            .mapToDouble(OrderItem::getTotalAmount)
            .sum();

        long deliveredItemCount = orders.stream()
            .filter(o -> "DELIVERED".equalsIgnoreCase(o.getStatus()))
            .count();

        System.out.println("Total Delivered Items   : " + deliveredItemCount);
        System.out.println(String.format("Total Delivered Revenue : $%,.2f", totalDeliveredRevenue));

        System.out.println("\n==================================================");
        System.out.println("       STREAM PRACTICE CHALLENGES SOLVED!         ");
        System.out.println("==================================================");
    }
}
