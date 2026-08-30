package topic09_constructors;

/**
 * ============================================================================
 * TOPIC 09: CONSTRUCTORS (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein Constructors ke 5 real-world practice questions hain.
 */

// ----------------------------------------------------------------------------
// PROBLEM 1: Product with Multi-Level Constructor Chaining
// ----------------------------------------------------------------------------
class Product {
    int productId;
    String name;
    double price;
    String category;

    // Base constructor
    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Chained Constructor 1: Default Category = "General"
    public Product(int productId, String name, double price) {
        this(productId, name, price, "General");
    }

    // Chained Constructor 2: Default Price = 0.0, Category = "Free Tier"
    public Product(int productId, String name) {
        this(productId, name, 0.0, "Free Tier");
    }

    public void printProduct() {
        System.out.println("ID: #" + productId + " | " + name + " | Category: " + category + " | Price: Rs. " + price);
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 2: Employee with Copy Constructor
// ----------------------------------------------------------------------------
class Employee {
    int empId;
    String name;
    String department;
    double salary;

    // Parameterized constructor
    public Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Copy Constructor: Creates a clone of employee with a new ID
    public Employee(int newEmpId, Employee templateEmp) {
        this.empId = newEmpId;
        this.name = templateEmp.name + " (Cloned)";
        this.department = templateEmp.department;
        this.salary = templateEmp.salary;
    }

    public void printEmployee() {
        System.out.println("EmpId: " + empId + " | Name: " + name + " | Dept: " + department + " | Salary: Rs. " + salary);
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 3: Game Character Overloading
// ----------------------------------------------------------------------------
class GamePlayer {
    String username;
    int health;
    int attackPower;
    String rank;

    // Default Beginner Character
    public GamePlayer(String username) {
        this(username, 100, 25, "Bronze");
    }

    // Custom Level Character
    public GamePlayer(String username, int health, int attackPower, String rank) {
        this.username = username;
        this.health = health;
        this.attackPower = attackPower;
        this.rank = rank;
    }

    public void displayStats() {
        System.out.println("Player: " + username + " [Rank: " + rank + "] -> HP: " + health + ", ATK: " + attackPower);
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 4: Singleton Pattern using Private Constructor
// ----------------------------------------------------------------------------
// KAISE KAAM KARTA HAI:
// Constructor ko 'private' banaya taaki bahar se koi 'new AppConfig()' na kar sake.
// Poore application me SIRF 1 HI OBJECT (instance) banta hai jo 'getInstance()' se milta hai.
class AppConfig {
    private static AppConfig singleInstance = null;
    String appName;
    String environment;

    // Private Constructor
    private AppConfig() {
        this.appName = "JavaLearningApp";
        this.environment = "Production";
        System.out.println("-> [AppConfig Initialized] Single Instance Created.");
    }

    // Global Access Point
    public static AppConfig getInstance() {
        if (singleInstance == null) {
            singleInstance = new AppConfig();
        }
        return singleInstance;
    }

    public void showConfig() {
        System.out.println("App: " + appName + " | Environment: " + environment);
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 5: Complex Number with Copy Constructor
// ----------------------------------------------------------------------------
class ComplexNumber {
    double real;
    double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Copy Constructor
    public ComplexNumber(ComplexNumber other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    public void printComplex() {
        System.out.println(real + " + " + imaginary + "i");
    }
}

// ----------------------------------------------------------------------------
// MAIN EXECUTION
// ----------------------------------------------------------------------------
public class ConstructorPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     TOPIC 09: CONSTRUCTOR PRACTICE PROBLEMS      ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // TEST 1: Product Constructor Chaining
        // --------------------------------------------------------------------
        System.out.println("--- 1. Product Constructor Chaining ---");
        Product p1 = new Product(101, "MacBook Pro M3", 199990.0, "Electronics");
        Product p2 = new Product(102, "Coffee Mug", 350.0);
        Product p3 = new Product(103, "Starter Course Access");

        p1.printProduct();
        p2.printProduct();
        p3.printProduct();
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 2: Employee Copy Constructor
        // --------------------------------------------------------------------
        System.out.println("--- 2. Employee Copy Constructor ---");
        Employee seniorDev = new Employee(501, "Vikram", "Engineering", 120000.0);
        Employee juniorDev = new Employee(502, seniorDev); // Clone using copy constructor

        seniorDev.printEmployee();
        juniorDev.printEmployee();
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 3: Game Player Setup
        // --------------------------------------------------------------------
        System.out.println("--- 3. Game Player Overloading ---");
        GamePlayer player1 = new GamePlayer("ShadowNinja"); // Beginner default
        GamePlayer player2 = new GamePlayer("ProGamer99", 500, 150, "Diamond");

        player1.displayStats();
        player2.displayStats();
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 4: Singleton Pattern (Private Constructor)
        // --------------------------------------------------------------------
        System.out.println("--- 4. Singleton Pattern using Private Constructor ---");
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        config1.showConfig();
        System.out.println("Kya config1 aur config2 EXACT SAME OBJECT hain? : " + (config1 == config2) + " (True)");
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 5: Complex Number Cloning
        // --------------------------------------------------------------------
        System.out.println("--- 5. Complex Number Copy Constructor ---");
        ComplexNumber c1 = new ComplexNumber(3.5, 2.5);
        ComplexNumber c2 = new ComplexNumber(c1);

        System.out.print("Original c1 : ");
        c1.printComplex();
        System.out.print("Cloned c2   : ");
        c2.printComplex();

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
