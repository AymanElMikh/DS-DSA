package org.dsa.Queue;

import org.dsa.Stack.Stack;
import org.dsa.Stack.StackV1;
import org.dsa.Stack.StackV2;

public class QueueV2<E extends Comparable<E>> implements Queue<E> {

    private Stack<E> stack1;
    private Stack<E> stack2;

    public QueueV2() {
        stack1 = new StackV2<E>();
        stack2 = new StackV2<E>();
    }

    @Override
    public void enqueue(E data) {
        stack1.push(data);
    }

    @Override
    public E dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public E front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.top();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }
}
