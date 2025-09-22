import java.util.*;

class IntQueue {
    int[] queueArray;
    int maxSize, front = 0, rear = -1;

    public IntQueue(int size) { 
        this.maxSize = size;
        queueArray = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is already full!");
            return;
        } else {
            rear++;
            queueArray[rear] = x;
        }
    }

    public int dequeue() { 
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            int temp = queueArray[front];
            front++;
            return temp;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    public void displayAllElements() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i]);
                if (i < rear) System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        IntQueue q1 = new IntQueue(5);

        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);
        q1.enqueue(50);
        q1.displayAllElements();
        System.out.println("Front element is " + q1.peek() + "\n");

        q1.dequeue();
        q1.dequeue();
        q1.displayAllElements();
        System.out.println("Front element is " + q1.peek());
    }
}