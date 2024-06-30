package org.dsa.Stack;

import java.util.EmptyStackException;

public class StackV1<E extends Comparable<E>> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int topIndex;

    @SuppressWarnings("unchecked")
    public StackV1() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.topIndex = -1;
    }

    @Override
    public void push(E data) {
        if (topIndex == array.length - 1) {
            resizeArray();
        }
        array[++topIndex] = data;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E data = array[topIndex];
        array[topIndex--] = null;
        return data;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[topIndex];
    }

    @Override
    public E peek(int position) {
        if (position < 0 || position > topIndex) {
            throw new IndexOutOfBoundsException("Position is out of bounds.");
        }
        return array[position];
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    public int size() {
        return topIndex + 1;
    }


    private void resizeArray() {
        int newSize = array.length * 2;
        E[] newArray = (E[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
