package org.dsa.LinkedList;

public class LinkedList<E extends Comparable<E>>{
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

    public void reverseLinkedList() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void merge(LinkedList<E> linkedList){
        if (linkedList.head == null)
            return;
        if(this.head == null)
            this.head = linkedList.head;

        Node<E> temp = new Node();
        Node<E> current1 = this.head;
        Node<E> current2  = this.head;
        Node<E> currentResult = temp;


        while (current2.next !=null && current2.next != null){

            if (current1.data.compareTo(current2.data) <= 0) {
                currentResult.next = current1;
                current1 = current1.next;
            } else {
                currentResult.next = current2;
                current2 = current2.next;
            }
            currentResult = currentResult.next;
        }

        if (current1.next == null)
            current1.next = current2;

        if ( current2.next == null )
            current2.next = current1;

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
