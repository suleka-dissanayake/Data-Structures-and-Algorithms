import java.util.Scanner;

public class TicketCounterQueue {

    // Manual Queue implementation using array
    static class Queue {
        private String[] queueArray;
        private int front, rear, size, capacity;

        public Queue(int capacity) {
            this.capacity = capacity;
            queueArray = new String[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(String name) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot add: " + name);
                return;
            }
            rear = (rear + 1) % capacity;
            queueArray[rear] = name;
            size++;
            System.out.println(name + " joined the queue.");
        }

        public void dequeue() {
            if (isEmpty()) {
                System.out.println("No customers in the queue.");
                return;
            }
            String served = queueArray[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println(served + " has been served.");
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            System.out.println("People in queue:");
            for (int i = 0; i < size; i++) {
                System.out.println("- " + queueArray[(front + i) % capacity]);
            }
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue ticketQueue = new Queue(5); // Max 5 people in queue

        while (true) {
            System.out.println("\n--- Ticket Counter Menu ---");
            System.out.println("1. Add person to queue");
            System.out.println("2. Serve person");
            System.out.println("3. Display queue");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    ticketQueue.enqueue(name);
                    break;

                case 2:
                    ticketQueue.dequeue();
                    break;

                case 3:
                    ticketQueue.display();
                    break;

                case 4:
                    System.out.println("Exiting simulation.");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
