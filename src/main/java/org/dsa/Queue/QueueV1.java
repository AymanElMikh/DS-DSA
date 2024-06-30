package org.dsa.Queue;

import java.util.Arrays;

public class QueueV1<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int actualCapacity = 0;
    private int positionTail = 0;
    private int positionHead = 0;

    public QueueV1() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(E data) {
        if (actualCapacity - 1  == array.length) {
            resizeArray();
        }

        array[positionTail] = data;
        positionTail = (positionTail + 1) % array.length;
        actualCapacity++;
    }

    @Override
    public E dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("The queue is empty");
        }

        E data = array[positionHead];
        array[positionHead] = null; // Clear the element
        positionHead = (positionHead + 1) % array.length; // Circular increment
        actualCapacity--;
        return data;
    }

    @Override
    public E front() throws Exception {
        if (isEmpty()) {
            throw new Exception("The queue is empty");
        }

        return array[positionHead];
    }

    @Override
    public boolean isEmpty() {
        return actualCapacity == 0;
    }

    @Override
    public int size() {
        return actualCapacity;
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        E[] newArray = (E[]) new Object[newCapacity];

        if (positionHead < positionTail) {
            // Case 1: Elements are contiguous in the array
            System.arraycopy(array, positionHead, newArray, 0, actualCapacity);
        } else {
            // Case 2: Elements wrap around the end of the array
            int length1 = array.length - positionHead;
            int length2 = positionTail;
            System.arraycopy(array, positionHead, newArray, 0, length1);
            System.arraycopy(array, 0, newArray, length1, length2);
        }

        array = newArray;
        positionHead = 0;
        positionTail = actualCapacity;
    }
}
