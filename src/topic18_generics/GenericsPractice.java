package topic18_generics;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * TOPIC 18: JAVA GENERICS (PRACTICE QUESTIONS)
 * ============================================================================
 */

// Generic Stack implementation (LIFO - Last In First Out)
class CustomStack<T> {
    private List<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
        System.out.println("Pushed: " + item);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class GenericsPractice {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        TOPIC 18: GENERICS PRACTICE               ");
        System.out.println("==================================================\n");

        // Testing Generic CustomStack with String
        System.out.println("--- 1. String Stack ---");
        CustomStack<String> nameStack = new CustomStack<>();
        nameStack.push("First (Bottom)");
        nameStack.push("Second (Middle)");
        nameStack.push("Third (Top)");

        System.out.println("Popped: " + nameStack.pop()); // Removes "Third"
        System.out.println("Popped: " + nameStack.pop()); // Removes "Second"
        System.out.println();

        // Testing Same Generic CustomStack with Integer
        System.out.println("--- 2. Integer Stack ---");
        CustomStack<Integer> numberStack = new CustomStack<>();
        numberStack.push(100);
        numberStack.push(200);

        System.out.println("Popped: " + numberStack.pop()); // 200

        System.out.println("\n==================================================");
        System.out.println("          ALL QUESTIONS COMPLETED!                ");
        System.out.println("==================================================");
    }
}
