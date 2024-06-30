package org.dsa.LinkedList;

public class LinkedList<E extends Comparable<E>> {
    private Node<E> head;
    private int size; // Variable to keep track of the size

    public LinkedList() {
        this.head = null;
        this.size = 0; // Initialize size to 0
    }

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
        size++; // Increment size after inserting a node
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
        size++; // Increment size after inserting a node
    }

    public void insertAtPosition(E data, int position) {
        Node<E> newNode = new Node<>();
        newNode.data = data;

        if (position <= 0 || head == null) {
            newNode.next = head;
            head = newNode;
            size++; // Increment size after inserting a node
            return;
        }

        Node<E> current = head;
        Node<E> prev = null;
        int counter = 0;

        while (current != null && counter < position) {
            prev = current;
            current = current.next;
            counter++;
        }

        prev.next = newNode;
        newNode.next = current;
        size++; // Increment size after inserting a node
    }

    public void deleteAtPosition(int position) {
        if (position < 0 || head == null) {
            return;
        }
        if (position == 0) {
            this.head = this.head.next;
            size--; // Decrement size after deleting a node
            return;
        }

        Node<E> current = head;
        Node<E> prev = null;
        int counter = 0;

        while (current != null && counter < position) {
            prev = current;
            current = current.next;
            counter++;
        }

        if (current != null) {
            prev.next = current.next;
            size--; // Decrement size after deleting a node
        }
    }

    public void reverseLinkedList() {
        if (head == null || head.next == null) {
            return;
        }

        Node<E> current = head;
        Node<E> prev = null;
        Node<E> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void merge(LinkedList<E> linkedList) {
        if (linkedList.head == null) {
            return;
        }

        if (this.head == null) {
            this.head = linkedList.head;
            size += linkedList.size(); // Update size after merging
            return;
        }

        Node<E> result = new Node<>();
        Node<E> currentResult = result;
        Node<E> current1 = this.head;
        Node<E> current2 = linkedList.head;

        while (current1 != null && current2 != null) {
            if (current1.data.compareTo(current2.data) <= 0) {
                currentResult.next = current1;
                current1 = current1.next;
            } else {
                currentResult.next = current2;
                current2 = current2.next;
            }
            currentResult = currentResult.next;
        }

        if (current1 != null) {
            currentResult.next = current1;
        }

        if (current2 != null) {
            currentResult.next = current2;
        }

        this.head = result.next;
        size += linkedList.size(); // Update size after merging
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

    public Node<E> find(int position) {
        if (position < 0 || head == null) {
            return null;
        }

        Node<E> current = head;
        int index = 0;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        return current;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return size; // Return the size variable
    }
}
