package org.dsa.Stack;

public class Runner {
    public static void main(String[] args) {
        // Create a new stack of integers
        StackV2<Integer> stack = new StackV2<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the top element of the stack
        System.out.println("Top element: " + stack.top()); // Output: 30

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 20

        // Peek at elements at specific positions
        System.out.println("Element at position 0: " + stack.peek(0)); // Output: 10
        try {
            System.out.println("Element at position 1: " + stack.peek(1)); // Output: IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Print all elements of the stack
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        // Check if stack is empty after popping all elements
        System.out.println("Is stack empty now? " + stack.isEmpty()); // Output: true
    }

}