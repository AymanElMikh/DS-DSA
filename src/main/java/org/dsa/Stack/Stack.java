package org.dsa.Stack;

public interface Stack<E> {
    void push(E data);
    E pop();
    E top();
    E peek(int position);

}