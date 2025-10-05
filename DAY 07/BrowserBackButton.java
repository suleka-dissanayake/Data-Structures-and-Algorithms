import java.util.Scanner;

public class BrowserBackButton {

    // Manual Stack implementation for storing visited pages
    static class Stack {
        private String[] stackArray;
        private int top;
        private int capacity;

        public Stack(int capacity) {
            this.capacity = capacity;
            stackArray = new String[capacity];
            top = -1;
        }

        public void push(String url) {
            if (top >= capacity - 1) {
                System.out.println("Stack Overflow. Cannot visit new page.");
            } else {
                stackArray[++top] = url;
                System.out.println("Visited: " + url);
            }
        }

        public String pop() {
            if (isEmpty()) {
                System.out.println("No pages to go back to.");
                return null;
            } else {
                return stackArray[top--];
            }
        }

        public String peek() {
            if (isEmpty()) return null;
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void displayHistory() {
            if (isEmpty()) {
                System.out.println("No browsing history.");
                return;
            }
            System.out.println("Browsing history:");
            for (int i = top; i >= 0; i--) {
                System.out.println("- " + stackArray[i]);
            }
        }
    }

    // Main method to simulate browser navigation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack browserStack = new Stack(10); // can store up to 10 pages

        String currentPage = null;

        while (true) {
            System.out.println("\n==== Browser Menu ====");
            System.out.println("1. Visit new page");
            System.out.println("2. Back");
            System.out.println("3. Show current page");
            System.out.println("4. Show history");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = scanner.nextLine();
                    browserStack.push(url);
                    currentPage = url;
                    break;

                case 2:
                    browserStack.pop(); // pop current page
                    currentPage = browserStack.peek(); // update to previous
                    if (currentPage != null) {
                        System.out.println("Back to: " + currentPage);
                    }
                    break;

                case 3:
                    if (currentPage != null) {
                        System.out.println("Current page: " + currentPage);
                    } else {
                        System.out.println("No page currently loaded.");
                    }
                    break;

                case 4:
                    browserStack.displayHistory();
                    break;

                case 5:
                    System.out.println("Exiting browser simulation.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
