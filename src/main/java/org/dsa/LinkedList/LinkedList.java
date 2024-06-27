package org.dsa.LinkedList;

public class LinkedList<E> {
    private Node<E> head;

    public void insertAtEnd(E data) {
        Node<E> node = new Node<>();
        node.data = data;

        if (head == null) {
            this.head = node;
        } else {
            Node<E> ref = head;
            while (ref.next != null) {
                ref = ref.next;
            }
            ref.next = node;
        }
    }

    public void insertAtTheBeginning(E data) {
        Node<E> node = new Node<>();
        node.data = data;

        if (head == null) {
            this.head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
    public void insertAtPosition(E data, int position) {
        Node newNode = new Node();
        newNode.data = data;

        if (position <= 0 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        Node prev = null;
        int counter = 0;

        while (current != null && counter < position) {
            prev = current;
            current = current.next;
            counter++;
        }

        prev.next = newNode;
        newNode.next = current;
    }
    public void deleteAtPosition(int position) {
        if (position < 0 || head == null) {
            return;
        }
        if (position == 0) {
            this.head = this.head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        int counter = 0;

        while (current != null && counter < position) {
            prev = current;
            current = current.next;
            counter++;
        }

        if (current != null) {
            prev.next = current.next;
        }
    }

    public void printAll() {
        Node<E> ref = head;

        if (ref == null) {
            System.out.println("The Linked List is empty");
        } else {
            while (ref != null) {
                System.out.println("Node : " + ref.data);
                ref = ref.next;
            }
        }
    }
}
