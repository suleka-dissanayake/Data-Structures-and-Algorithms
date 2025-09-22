import java.util.*;

class CircularQueue {
    String[] queueArray;
    int maxSize, front = 0, rear = 0;
    int count = 0;

    public CircularQueue(int size) {
        this.maxSize = size;
        queueArray = new String[maxSize];
    }

    public boolean isFull() {
        return count == maxSize;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(String x) {
        if (isFull()) {
            System.out.println("Queue is already full!");
            return;
        }
        queueArray[rear] = x;
        rear = (rear + 1) % maxSize;
        count++;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        String temp = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % maxSize;
        count--;
        return temp;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return queueArray[front];
    }

    public void displayAllElements() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queueArray[index] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q1 = new CircularQueue(5);

        q1.enqueue("Apple");
        q1.enqueue("Orange");
        q1.enqueue("Car");
        q1.enqueue("Cat");
        q1.enqueue("Dog");
        q1.displayAllElements();
        System.out.println("Front element is " + q1.peek() + "\n");

        q1.dequeue();
        q1.dequeue();
        q1.displayAllElements();
        System.out.println("Front element is " + q1.peek());

        q1.enqueue("Elephant");
        q1.enqueue("Fish");
        q1.displayAllElements();
    }
}