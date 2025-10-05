public class BubbleSort_ArrayList {
    private int[] data;
    private int size;

    // Constructor
    public BubbleSort_ArrayList() {
        data = new int[10];  // initial capacity
        size = 0;
    }

    // Add element to the end
    public void add(int value) {
        if (size == data.length) {
            resize();
        }
        data[size++] = value;
    }

    // Get element at index
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    // Set element at index
    public void set(int index, int value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    // Get current size
    public int size() {
        return size;
    }

    // Resize internal array when full
    private void resize() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // Bubble Sort implementation
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Swap
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Print all elements
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        BubbleSort_ArrayList list = new BubbleSort_ArrayList();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(6);

        System.out.println("Before sorting:");
        list.print();

        list.bubbleSort();

        System.out.println("After sorting:");
        list.print();
    }
}