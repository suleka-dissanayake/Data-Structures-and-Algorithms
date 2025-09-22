import java.util.*;

class Queue{
    String[] queueArray;
    int maxSize, front = 0, rear = -1;

    public Queue(int size){
        this.maxSize = size;
        queueArray = new String[maxSize];
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return front > rear;
    }

    public void enqueue(String x){
        if(isFull()){
            System.out.println("Queue is already full!");
            return;
        } else{
            rear++;
            queueArray[rear] = x;
        }
    }

    public String dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return null;
        } else{
            String temp = queueArray[front];
            queueArray[front] = null;
            front++;
            return temp;
        }
    }

    public String peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return null;
        } else{
            return queueArray[front];
        }
    }

    public void displayAllElements(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
        } else{
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue(5);

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
    }
}