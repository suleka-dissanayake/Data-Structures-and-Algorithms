class MergeSortChar {
    public char[] sort(char[] datalist) {
        if (datalist.length <= 1) {
            return datalist;
        }

        int mid = datalist.length / 2;
        char[] left = new char[mid];
        char[] right = new char[datalist.length - mid];

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

    private char[] merge(char[] left, char[] right) {
        char[] result = new char[left.length + right.length];
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
        String input = "Hello World".toLowerCase();
        char[] data = input.toCharArray();

        MergeSortChar sorter = new MergeSortChar();
        char[] sorted = sorter.sort(data);

        System.out.print("Sorted data: ");
        for (char ch : sorted) {
            System.out.print(ch);
        }
    }
}