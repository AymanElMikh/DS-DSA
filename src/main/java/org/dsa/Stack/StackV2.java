package org.dsa.Stack;

import org.dsa.LinkedList.LinkedList;
import org.dsa.LinkedList.Node;

import java.util.EmptyStackException;

public class StackV2<E extends Comparable<E>> implements Stack<E> {

    private LinkedList<E> linkedList;

    public StackV2() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void push(E data) {
        linkedList.insertAtTheBeginning(data);
    }

    @Override
    public E pop() {
        if (linkedList.isEmpty())
            throw new EmptyStackException();

        Node<E> node = linkedList.find(0);
        linkedList.deleteAtPosition(0);
        return node.getData();
    }

    @Override
    public E top() {
        if (linkedList.isEmpty())
            throw new EmptyStackException();

        Node<E> node = linkedList.find(0);
        return node.getData();
    }

    @Override
    public E peek(int position) {
        Node<E> node = linkedList.find(position);
        if( node == null)
            throw new IndexOutOfBoundsException("Position out of bound");
        else
            return node.getData();
    }

    @Override
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

}