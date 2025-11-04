class SelectionSort {
    public int[] sort(int[] datalist) {
        int n = datalist.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (datalist[j] < datalist[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = datalist[minIndex];
            datalist[minIndex] = datalist[i];
            datalist[i] = temp;
        }

        return datalist;
    }

    public static void main(String[] args) {
        int[] data = {4, 9, 5, 6, 1, 3, 7};
        SelectionSort sorter = new SelectionSort();
        int[] sorted = sorter.sort(data);

        System.out.print("Sorted data: ");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}