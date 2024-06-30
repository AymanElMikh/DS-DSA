package org.dsa.Queue;

public interface Queue<E> {
    void enqueue(E data);

    E dequeue() throws Exception;

    E front() throws Exception;

    boolean isEmpty();

    int size();
}
