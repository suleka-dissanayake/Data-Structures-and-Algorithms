class MergeSort {
    public int[] sort(int[] datalist) {
        if (datalist.length <= 1) {
            return datalist;
        }

        int mid = datalist.length / 2;
        int[] left = new int[mid];
        int[] right = new int[datalist.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = datalist[i];
        }

        for (int i = mid; i < datalist.length; i++) {
            right[i - mid] = datalist[i];
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = {5, 1, 3, 2, 4, 9, 10, 7, 6, 8};
        MergeSort sorter = new MergeSort();
        int[] sorted = sorter.sort(data);

        System.out.print("Sorted data: ");
        for (int num : sorted) {
            System.out.print(num + ", ");
        }
    }
}