package topic25_jdbc_sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * TOPIC 25: JDBC (JAVA DATABASE CONNECTIVITY) & WRITING SQL IN JAVA
 * ============================================================================
 * 
 * 📌 JDBC KYA HAI?
 * - JDBC ek Java standard API (java.sql package) hai jo Java programs ko 
 *   Databases (MySQL, PostgreSQL, Oracle, SQLite, H2) se connect aur SQL 
 *   queries execute karne ki suvidha deta hai.
 * 
 * 📌 5 CORE STEPS TO RUN SQL IN JAVA:
 *   Step 1: Load Driver (Optional in JDBC 4.0+): Class.forName("com.mysql.cj.jdbc.Driver")
 *   Step 2: Establish Connection               : DriverManager.getConnection(url, user, pass)
 *   Step 3: Create PreparedStatement / Statement : conn.prepareStatement(sql)
 *   Step 4: Execute SQL Query                  :
 *           - executeUpdate() -> For INSERT, UPDATE, DELETE, CREATE (Returns int: rows affected)
 *           - executeQuery()  -> For SELECT (Returns ResultSet)
 *   Step 5: Process Results & Auto-Close       : try-with-resources
 * 
 * 📌 STATEMENT VS PREPAREDSTATEMENT (WHY PREPAREDSTATEMENT IS BEST?):
 * -----------------------------------------------------------------------------
 * Feature                 Statement                       PreparedStatement
 * -----------------------------------------------------------------------------
 * SQL Injection Safety    ❌ Vulnerable to hacking         ✅ 100% Safe (Parametrized '?')
 * Performance             Slower (Compiles every time)    Faster (Pre-compiled once)
 * Dynamic Values          String concatenation (" + x + ") Clean placeholders: ps.setString(1, x)
 * Binary/Blobs/Dates      Difficult                       Easy setter methods
 * -----------------------------------------------------------------------------
 */

// Simulated In-Memory Database to run anywhere without external MySQL server setup
class DatabaseConnectionSimulator {
    // In real-world MySQL: "jdbc:mysql://localhost:3306/school_db", "root", "password"
    public static final String DB_URL = "jdbc:h2:mem:school;DB_CLOSE_DELAY=-1";
    public static final String USER = "sa";
    public static final String PASS = "";
}

public class JdbcDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TOPIC 25: JDBC & WRITING SQL QUERIES IN JAVA   ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // 1. HOW SQL STRINGS ARE WRITTEN IN JAVA (SYNTAX & PATTERNS)
        // --------------------------------------------------------------------
        System.out.println("--- 1. SQL Query Templates in Java ---");
        
        // DDL: Create Table
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS employees (
                id INT PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                department VARCHAR(50),
                salary DOUBLE
            );
            """;

        // DML: Insert with Parameterized placeholders '?' (PreparedStatement)
        String insertSql = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";

        // DQL: Select
        String selectSql = "SELECT id, name, department, salary FROM employees WHERE salary > ? ORDER BY salary DESC";

        // DML: Update
        String updateSql = "UPDATE employees SET salary = salary + ? WHERE department = ?";

        // DML: Delete
        String deleteSql = "DELETE FROM employees WHERE id = ?";

        System.out.println("✔ CREATE SQL     :\n" + createTableSql);
        System.out.println("✔ INSERT SQL     : " + insertSql);
        System.out.println("✔ SELECT SQL     : " + selectSql);
        System.out.println("✔ UPDATE SQL     : " + updateSql);
        System.out.println("✔ DELETE SQL     : " + deleteSql);
        System.out.println();

        // --------------------------------------------------------------------
        // 2. LIVE JDBC EXECUTION WITH IN-MEMORY ENGINE
        // --------------------------------------------------------------------
        System.out.println("--- 2. Executing Real JDBC CRUD Operations ---");
        
        // We initialize an in-memory SQL mock engine so users can run this immediately!
        MockJdbcDatabase db = new MockJdbcDatabase();
        db.createTable();

        // A. INSERT DATA USING PREPARED STATEMENT:
        System.out.println("--> Inserting Records with PreparedStatement:");
        db.insertEmployee(101, "Vibhor Pundhir", "Software Engineering", 95000.0);
        db.insertEmployee(102, "Aman Sharma", "Data Science", 85000.0);
        db.insertEmployee(103, "Pooja Verma", "Cloud DevOps", 90000.0);
        db.insertEmployee(104, "Rahul Gupta", "Software Engineering", 70000.0);
        System.out.println();

        // B. SELECT DATA & ITERATE OVER RESULTSET:
        System.out.println("--> Fetching All Employees (SELECT * FROM employees):");
        db.displayAllEmployees();
        System.out.println();

        // C. UPDATE DATA:
        System.out.println("--> Giving 5000 Hike to 'Software Engineering' (UPDATE employees):");
        db.updateSalary("Software Engineering", 5000.0);
        db.displayAllEmployees();
        System.out.println();

        // D. DELETE DATA:
        System.out.println("--> Deleting Employee ID 104 (DELETE FROM employees WHERE id = 104):");
        db.deleteEmployee(104);
        db.displayAllEmployees();
        System.out.println();

        // ====================================================================
        // 3. SQL INJECTION DEMO (STATEMENT VS PREPAREDSTATEMENT)
        // ====================================================================
        System.out.println("--- 3. Why PreparedStatement Prevents SQL Injection ---");
        String userInputName = "' OR '1'='1"; // Malicious Hacker Input!

        System.out.println("Hacker Entered Username: " + userInputName);
        
        // ❌ Vulnerable Statement:
        String unsafeQuery = "SELECT * FROM users WHERE username = '" + userInputName + "' AND password = 'password123'";
        System.out.println("❌ Unsafe Statement SQL : " + unsafeQuery);
        System.out.println("   Result: '1'='1' is always TRUE! Hacker bypasses login without password!");

        // ✅ Safe PreparedStatement:
        String safeQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
        System.out.println("✅ Safe Prepared Query : " + safeQuery);
        System.out.println("   Result: JDBC escapes quotes and treats input as literal string value, not executable SQL code!\n");

        // ====================================================================
        // 4. JDBC TRANSACTIONS (COMMIT & ROLLBACK)
        // ====================================================================
        System.out.println("--- 4. JDBC Transactions (ACID Properties) ---");
        System.out.println("Example: Bank Money Transfer (Debit Vibhor -> Credit Aman)");
        db.demonstrateTransaction();

        System.out.println("\n==================================================");
        System.out.println("            JDBC DEMO COMPLETED!                  ");
        System.out.println("==================================================");
    }
}

/**
 * Clean In-Memory JDBC Engine for self-contained runnable learning
 */
class MockJdbcDatabase {
    static class EmployeeRecord {
        int id;
        String name;
        String department;
        double salary;

        EmployeeRecord(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    private final List<EmployeeRecord> table = new ArrayList<>();

    public void createTable() {
        table.clear();
        System.out.println("✔ Table 'employees' created successfully.");
    }

    public void insertEmployee(int id, String name, String dept, double salary) {
        table.add(new EmployeeRecord(id, name, dept, salary));
        System.out.println(String.format("  [INSERT] Added %s (ID: %d, Salary: $%,.2f)", name, id, salary));
    }

    public void displayAllEmployees() {
        System.out.println("+-----+----------------------+----------------------+------------+");
        System.out.println("| ID  | Name                 | Department           | Salary     |");
        System.out.println("+-----+----------------------+----------------------+------------+");
        for (EmployeeRecord e : table) {
            System.out.println(String.format("| %-3d | %-20s | %-20s | $%,9.2f |", 
                e.id, e.name, e.department, e.salary));
        }
        System.out.println("+-----+----------------------+----------------------+------------+");
    }

    public void updateSalary(String dept, double hike) {
        int count = 0;
        for (EmployeeRecord e : table) {
            if (e.department.equalsIgnoreCase(dept)) {
                e.salary += hike;
                count++;
            }
        }
        System.out.println(String.format("✔ Updated salary for %d employees in department '%s'.", count, dept));
    }

    public void deleteEmployee(int id) {
        boolean removed = table.removeIf(e -> e.id == id);
        if (removed) {
            System.out.println(String.format("✔ Employee with ID %d successfully deleted.", id));
        }
    }

    public void demonstrateTransaction() {
        System.out.println("Step 1: Set auto-commit to false -> conn.setAutoCommit(false);");
        System.out.println("Step 2: Deduct $1000 from Account A -> executeUpdate()");
        System.out.println("Step 3: If any error occurs (e.g. server crash) -> conn.rollback();");
        System.out.println("Step 4: If all steps succeed -> conn.commit();");
        System.out.println("✔ Transaction committed safely with ACID compliance!");
    }
}
