package org.dsa.Queue;

public class Runner {

    public static void main(String[] args) {
        QueueV2<Integer> queue = new QueueV2<>();

        // Enqueue some elements
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Test dequeue and front
        try {
            System.out.println("Front element: " + queue.front()); // Should print 1
            System.out.println("Dequeued element: " + queue.dequeue()); // Should dequeue 1
            System.out.println("Front element after dequeue: " + queue.front()); // Should print 2
            System.out.println("Queue size: " + queue.size()); // Should print 4
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Dequeue remaining elements
        try {
            while (!queue.isEmpty()) {
                System.out.println("Dequeued element: " + queue.dequeue());
            }
            System.out.println("Queue size after dequeueing all elements: " + queue.size()); // Should print 0
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // Test dequeue from an empty queue
        try {
            System.out.println("Dequeued element from empty queue: " + queue.dequeue()); // Should throw exception
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage()); // Should print "The queue is empty"
        }
    }
}
