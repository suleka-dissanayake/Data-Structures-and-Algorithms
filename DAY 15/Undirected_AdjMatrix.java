class Undirected_AdjMatrix{
    int size;
    int[][] arr;

    public Undirected_AdjMatrix(int size){
        this.size = size;
        arr = new int[size][size];
    }

    public void addEdge(int x, int y){
        arr[x][y] = 1;
        arr[y][x] = 1;
    }

    public void removeEdge(int x, int y){
        arr[x][y] = 0;
        arr[y][x] = 0;
    }

    public void display(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Undirected_AdjMatrix matrix = new Undirected_AdjMatrix(5);
        matrix.addEdge(0, 1);
        matrix.addEdge(2, 4);
        matrix.addEdge(1, 3);
        matrix.addEdge(1, 4);
        matrix.addEdge(3, 1);
        matrix.display();
    }
}