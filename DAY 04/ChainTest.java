// Interface for a linear list
interface LinearList {
    boolean isEmpty();
    int size();
    Object get(int index);
    void add(int index, Object theElement);
    Object remove(int index);
}

// Represents a node in the linked list
class ChainNode {
    Object element; // Data stored in the node
    ChainNode next; // Reference to the next node in the chain

    // Constructor to create a new ChainNode
    public ChainNode(Object element, ChainNode next) {
        this.element = element;
        this.next = next; // Corrected: Should assign to 'next', not 'ChainNode'
    }

    // Displays the element of the node
    public void displayNode() {
        System.out.println("{" + element + "}");
    }
}

// Represents a singly linked list
class Chain implements LinearList {
    private ChainNode firstNode; // Reference to the first node in the list
    private int size; // Number of elements in the list

    // Constructor to create an empty Chain
    public Chain() {
        this.firstNode = null;
        this.size = 0;
    }

    // Constructor to create a Chain with an initial node
    public Chain(ChainNode firstNode, int size) {
        this.firstNode = firstNode;
        this.size = size;
    }

    // Returns the first node of the list (corrected return type)
    public ChainNode getFirstNode() {
        return firstNode;
    }

    // Returns the current size of the list
    public int getSize() {
        return size;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the current size of the list (implements LinearList method)
    @Override
    public int size() {
        return size; // Corrected: Should return the actual size, not 0
    }

    // Retrieves the element at a specific index
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: Index out of bounds in get!");
            return null;
        }
        ChainNode p = firstNode;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.element;
    }

    // Adds an element at a specific index
    @Override
    public void add(int index, Object theElement) {
        if (index < 0 || index > size) {
            System.out.println("Error in index for add!");
        } else if (index == 0) {
            // Add at the beginning of the list
            firstNode = new ChainNode(theElement, firstNode);
            size++;
        } else {
            // Add at a specific position
            ChainNode p = firstNode;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next = new ChainNode(theElement, p.next);
            size++;
        }
    }

    // Removes an element at a specific index
    @Override
    public Object remove(int index) {
        Object removedElement = null;
        if (index < 0 || index >= size) { // Corrected: index should be < size
            System.out.println("Error in index for remove!");
        } else if (index == 0) {
            // Remove the first element
            removedElement = firstNode.element;
            firstNode = firstNode.next;
            size--;
        } else {
            // Remove an element from a specific position
            ChainNode p = firstNode;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            removedElement = p.next.element;
            p.next = p.next.next;
            size--;
        }
        return removedElement;
    }

    // Method to print the elements of the chain
    public void printChain() {
        ChainNode current = firstNode;
        System.out.print("Chain: [");
        while (current != null) {
            System.out.print(current.element);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}

// Main class to test the Chain implementation
public class ChainTest {
    public static void main(String[] args) {
        // Create an empty chain
        Chain myChain = new Chain();
        System.out.println("Is chain empty? " + myChain.isEmpty()); // true
        System.out.println("Chain size: " + myChain.size()); // 0

        // Add elements
        myChain.add(0, "Apple"); // Add at the beginning
        myChain.add(1, "Banana"); // Add at index 1
        myChain.add(0, "Orange"); // Add at the beginning
        myChain.add(2, "Grape"); // Add at index 2
        myChain.printChain(); // Chain: [Orange, Apple, Grape, Banana]
        System.out.println("Chain size: " + myChain.size()); // 4

        // Get elements
        System.out.println("Element at index 1: " + myChain.get(1)); // Apple
        System.out.println("Element at index 3: " + myChain.get(3)); // Banana

        // Remove elements
        System.out.println("Removed element at index 0: " + myChain.remove(0)); // Orange
        myChain.printChain(); // Chain: [Apple, Grape, Banana]
        System.out.println("Chain size: " + myChain.size()); // 3

        System.out.println("Removed element at index 1: " + myChain.remove(1)); // Grape
        myChain.printChain(); // Chain: [Apple, Banana]
        System.out.println("Chain size: " + myChain.size()); // 2

        // Test edge cases for add/remove
        myChain.add(2, "Cherry"); // Add at the end
        myChain.printChain(); // Chain: [Apple, Banana, Cherry]

        System.out.println("Removed element at index 2: " + myChain.remove(2)); // Cherry
        myChain.printChain(); // Chain: [Apple, Banana]
    }
}