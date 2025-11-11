class InsertionChar {
    public char[] sort(char[] datalist){
        int n = datalist.length;

        for (int i = 0; i < n; i++) {
            char key = datalist[i];
            int j = i - 1;

            while (j >= 0 && datalist[j] > key){
                datalist[j + 1] = datalist[j];
                j--;
            }
            datalist[j + 1] = key;
        }
        return datalist;
    }

    public static void main(String[] args) {
        String input = "Hello World".toLowerCase();
        char[] data = input.toCharArray();

        InsertionChar sorter = new InsertionChar();
        char[] sorted = sorter.sort(data);

        System.out.print("Sorted characters: ");
        for(char ch : sorted){
            System.out.print(ch);
        }
    }
}