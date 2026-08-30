package topic08_oops_basics;

/**
 * ============================================================================
 * TOPIC 08: CLASSES & OBJECTS (PRACTICE QUESTIONS & PROBLEMS)
 * ============================================================================
 * Is file mein Object-Oriented Programming ke 5 real-world practical examples hain.
 */

// ----------------------------------------------------------------------------
// PROBLEM 1: Bank Account Class
// ----------------------------------------------------------------------------
class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs. " + amount + " deposited successfully in Account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rs. " + amount + " withdrawn successfully. Remaining Balance: Rs. " + balance);
        } else {
            System.out.println("Withdrawal Failed: Insufficient balance or invalid amount!");
        }
    }

    public void printSummary() {
        System.out.println("Account [" + accountNumber + "] | Holder: " + accountHolder + " | Balance: Rs. " + balance);
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 2: Student Report Card Class
// ----------------------------------------------------------------------------
class Student {
    int rollNo;
    String name;
    int[] marks;

    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public double calculatePercentage() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return (double) total / marks.length;
    }

    public String getGrade() {
        double pct = calculatePercentage();
        if (pct >= 90) return "A+";
        if (pct >= 75) return "A";
        if (pct >= 60) return "B";
        if (pct >= 40) return "C";
        return "F";
    }

    public void displayReport() {
        System.out.println("Student Roll No: " + rollNo + " | Name: " + name + 
                           " | Percentage: " + String.format("%.2f", calculatePercentage()) + 
                           "% | Grade: " + getGrade());
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 3: Rectangle Geometry Class
// ----------------------------------------------------------------------------
class Rectangle {
    double length;
    double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double getArea() {
        return length * breadth;
    }

    public double getPerimeter() {
        return 2 * (length + breadth);
    }

    public boolean isSquare() {
        return length == breadth;
    }
}

// ----------------------------------------------------------------------------
// PROBLEM 4: Book Class with Constructor Chaining using this(...)
// ----------------------------------------------------------------------------
class Book {
    String title;
    String author;
    double price;

    // Constructor 1: Full details
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Constructor 2: Free book (Chaining to Constructor 1)
    public Book(String title, String author) {
        this(title, author, 0.0); // calls Constructor 1
    }

    public void printBook() {
        System.out.println("Book: \"" + title + "\" by " + author + " | Price: Rs. " + price);
    }
}

// ----------------------------------------------------------------------------
// MAIN EXECUTION
// ----------------------------------------------------------------------------
public class ClassesAndObjectsPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TOPIC 08: OOPS PRACTICE QUESTIONS & EXAMPLES   ");
        System.out.println("==================================================\n");

        // --------------------------------------------------------------------
        // TEST 1: Bank Account Management
        // --------------------------------------------------------------------
        System.out.println("--- 1. Bank Account Operations ---");
        BankAccount myAccount = new BankAccount("SBI-100234", "Rahul Sharma", 5000.0);
        myAccount.printSummary();
        myAccount.deposit(2500.0);
        myAccount.withdraw(3000.0);
        myAccount.withdraw(10000.0); // Insufficient check
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 2: Student Report & Grading
        // --------------------------------------------------------------------
        System.out.println("--- 2. Student Report Cards ---");
        int[] rahulMarks = { 85, 92, 78, 88, 90 };
        Student s1 = new Student(101, "Rahul", rahulMarks);
        s1.displayReport();

        int[] priyaMarks = { 95, 98, 92, 96, 94 };
        Student s2 = new Student(102, "Priya", priyaMarks);
        s2.displayReport();
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 3: Rectangle & Square Check
        // --------------------------------------------------------------------
        System.out.println("--- 3. Rectangle Calculations ---");
        Rectangle r1 = new Rectangle(10.0, 5.0);
        System.out.println("Rectangle (10x5) Area: " + r1.getArea() + ", Perimeter: " + r1.getPerimeter() + ", Is Square? " + r1.isSquare());

        Rectangle r2 = new Rectangle(6.0, 6.0);
        System.out.println("Rectangle (6x6)  Area: " + r2.getArea() + ", Perimeter: " + r2.getPerimeter() + ", Is Square? " + r2.isSquare());
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 4: Constructor Chaining (Book)
        // --------------------------------------------------------------------
        System.out.println("--- 4. Constructor Chaining with Books ---");
        Book paidBook = new Book("Atomic Habits", "James Clear", 450.0);
        Book freeGuide = new Book("Java Beginner Guide (Free Edition)", "Antigravity Team");
        paidBook.printBook();
        freeGuide.printBook();
        System.out.println();

        // --------------------------------------------------------------------
        // TEST 5: Array of Objects (Looping through multiple objects)
        // --------------------------------------------------------------------
        System.out.println("--- 5. Array of Objects Traversal ---");
        Student[] classroom = { s1, s2, new Student(103, "Amit", new int[]{55, 60, 48, 52, 58}) };

        for (Student student : classroom) {
            student.displayReport();
        }

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
