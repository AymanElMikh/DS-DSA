package org.dsa.LinkedList;

public class Node<E> {
    E data;
    Node next;
    public boolean equals(Node<E> otherNode) {
        return this.data.equals(otherNode.data);
    }

    public E getData(){
        return data;
    }
}