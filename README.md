# ☕ Complete Core & Advanced Java Tutorials (Zero to Hero)

Welcome to the comprehensive, self-paced **Java Learning Roadmap**. This repository contains modular, topic-wise source code files with detailed step-by-step explanations, real-world examples, and hands-on practice problems.

---

## 📚 Repository Structure & Topics Covered

| # | Topic | Concept File | Practice File | Key Concepts Covered |
|:---:|:---|:---|:---|:---|
| **01** | **Type Casting** | `TypeCastingDemo.java` | `TypeCastingPractice.java` | Widening, Narrowing, Type Promotion, Parsing |
| **02** | **Strings** | `StringDemo.java` | `StringPractice.java` | String Pool (SCP), Immutability, `==` vs `.equals()`, StringBuilder |
| **03** | **Boolean & Logic** | `BooleanDemo.java` | `BooleanPractice.java` | Relational operators, `&&`, `\|\|`, `!`, Short-Circuit Evaluation |
| **04** | **Conditionals** | `ConditionalsDemo.java` | `ConditionalsPractice.java` | `if-else`, `else-if` ladder, Nested if, Enhanced Switch-Case |
| **05** | **Loops** | `LoopsDemo.java` | `LoopsPractice.java` | `for`, `while`, `do-while`, `break`, `continue`, Nested Loops |
| **06** | **Arrays** | `ArraysDemo.java` | `ArraysPractice.java` | 1D & 2D Arrays, Enhanced for-each, In-place reversal, Search |
| **07** | **Methods** | `MethodsDemo.java` | `MethodsPractice.java` | Static vs Instance, Overloading, Pass-By-Value, Varargs |
| **08** | **OOPs Basics** | `ClassesAndObjectsDemo.java` | `ClassesAndObjectsPractice.java` | Class Blueprint, Object Instance, `this` keyword, Heap vs Stack |
| **09** | **Constructors** | `ConstructorDemo.java` | `ConstructorPractice.java` | Default, Parameterized, Overloaded, Chaining, Copy, Private |
| **10** | **Packages** | `PackagesDemo.java` | `PackagesPractice.java` | Package structure, Imports, Static Imports, Visibility Matrix |
| **11** | **Inheritance** | `InheritanceDemo.java` | `InheritancePractice.java` | `extends`, `super()`, `@Override`, Multilevel, Hierarchical |
| **12** | **Polymorphism** | `PolymorphismDemo.java` | `PolymorphismPractice.java` | Compile-time vs Runtime Polymorphism, Upcasting, Dispatch |
| **13** | **Abstraction** | `AbstractionDemo.java` | `AbstractionPractice.java` | `abstract` class vs `interface`, Multiple Interfaces |
| **14** | **Encapsulation** | `EncapsulationDemo.java` | `EncapsulationPractice.java` | Private variables, Getters & Setters, Data validation |
| **15** | **Exception Handling** | `ExceptionHandlingDemo.java` | `ExceptionHandlingPractice.java` | `try-catch-finally`, `throw`, `throws`, Custom Exceptions |
| **16** | **Collections** | `CollectionsDemo.java` | `CollectionsPractice.java` | `ArrayList`, `HashSet`, `HashMap`, Dynamic sizing |
| **17** | **Wrapper Classes** | `WrapperClassesDemo.java` | `WrapperClassesPractice.java` | Autoboxing, Unboxing, Integer Cache Pool (-128 to 127) |
| **18** | **Generics** | `GenericsDemo.java` | `GenericsPractice.java` | `<T>`, Type Safety, Generic Methods, Bounded Type Parameters |
| **19** | **Annotations** | `AnnotationsDemo.java` | `AnnotationsPractice.java` | Built-in annotations, Custom `@interface`, Reflection |
| **20** | **RegEx** | `RegExDemo.java` | `RegExPractice.java` | Pattern, Matcher, Regex Tokens, Phone & Email Validation |
| **21** | **Multithreading** | `ThreadsDemo.java` | `ThreadsPractice.java` | `Thread` class, `Runnable`, `start()` vs `run()`, Synchronization |
| **22** | **Lambda Expressions** | `LambdaDemo.java` | `LambdaPractice.java` | `@FunctionalInterface`, `() -> {}`, Method References (`::`) |
| **23** | **Advanced Sorting** | `AdvancedSortingDemo.java` | `AdvancedSortingPractice.java` | `Comparable` vs `Comparator`, Chained Sorting with Lambdas |
| **24** | **Stream API** | `StreamApiDemo.java` | `StreamApiPractice.java` | `filter()`, `map()`, `collect()`, Streams vs Loops / Collections |
| **25** | **JDBC & SQL in Java** | `JdbcDemo.java` | `JdbcPractice.java` | `PreparedStatement`, `ResultSet`, SQL Injection Prevention, ACID Transactions |
| **26** | **Java Web Apps & Webpages** | `JavaWebAppDemo.java` | `JavaWebAppPractice.java` | HTTP Server, Dynamic HTML Webpages, REST APIs, Form POST Handling |

---

## 🚀 How to Run the Code

### 1. Compile All Files:
```bash
javac -d out src/topic*/*.java
```

### 2. Run Any Specific Topic Demo or Practice:
```bash
# Example: Run Inheritance Master Demo
java -cp out topic11_inheritance.InheritanceDemo

# Example: Run Collections Demo
java -cp out topic16_collections.CollectionsDemo

# Example: Run Lambda Expressions
java -cp out topic22_lambda.LambdaDemo
```

---
*Happy Coding! 🚀*
