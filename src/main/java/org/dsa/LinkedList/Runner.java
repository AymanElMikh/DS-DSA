package org.dsa.LinkedList;

public class Runner {

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtTheBeginning(1);
        linkedList.insertAtTheBeginning(3);
        linkedList.insertAtPosition(2,1);
        linkedList.deleteAtPosition(1);
        linkedList.insertAtPosition(4, 1);
        linkedList.printAll();

    }

}