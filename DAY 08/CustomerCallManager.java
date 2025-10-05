import java.util.Scanner;

public class CustomerCallManager {

    // Customer class
    static class Customer {
        private String name;
        private String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{name='" + name + "', phone='" + phoneNumber + "'}";
        }
    }

    // Manual CallQueue implementation using circular array
    static class CallQueue {
        private final int capacity;
        private Customer[] queue;
        private int front;
        private int rear;
        private int size;

        public CallQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new Customer[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void enqueue(Customer customer) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot add customer: " + customer.getName());
                return;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = customer;
            size++;
            System.out.println("Enqueued: " + customer);
        }

        public Customer dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. No customers to dequeue.");
                return null;
            }
            Customer customer = queue[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println("Dequeued: " + customer);
            return customer;
        }

        public Customer peek() {
            if (isEmpty()) {
                return null;
            }
            return queue[front];
        }

        public void displayQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            System.out.println("Current Queue:");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                System.out.println(" -> " + queue[index]);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CallQueue callQueue = new CallQueue(5); // Set queue capacity here

        while (true) {
            System.out.println("\n=== Customer Call Management ===");
            System.out.println("1. Add Incoming Call");
            System.out.println("2. Attend Call");
            System.out.println("3. Peek Next Call");
            System.out.println("4. Display Call Queue");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    Customer customer = new Customer(name, phone);
                    callQueue.enqueue(customer);
                    break;
                case 2:
                    callQueue.dequeue();
                    break;
                case 3:
                    Customer next = callQueue.peek();
                    if (next != null) {
                        System.out.println("Next in queue: " + next);
                    } else {
                        System.out.println("No calls in queue.");
                    }
                    break;
                case 4:
                    callQueue.displayQueue();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
