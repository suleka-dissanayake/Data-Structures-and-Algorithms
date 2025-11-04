class BubbleSort {
    public int[] sort(int[] datalist) {
        int n = datalist.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (datalist[j] > datalist[j + 1]) {
                    int temp = datalist[j];
                    datalist[j] = datalist[j + 1];
                    datalist[j + 1] = temp;
                }
            }
        }
        return datalist;
    }

    public static void main(String[] args) {
        int[] data = {4, 9, 5, 6, 1, 3, 7};
        BubbleSort sorter = new BubbleSort();
        int[] sorted = sorter.sort(data);

        System.out.print("Sorted data: ");
        for (int num : sorted) {
            System.out.print(num + ", ");
        }
    }
}