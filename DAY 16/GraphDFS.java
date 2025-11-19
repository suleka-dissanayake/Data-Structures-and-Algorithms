class GraphDFS{
    private int[][] adjMatrix;
    private boolean[] visited;
    private int vertices;

    public GraphDFS(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
        visited = new boolean[vertices];
    }

    public void addEdge(int src, int dest){
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    public void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < vertices; i++) {
            if(adjMatrix[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.print("DFS Traversal: ");
        graph.dfs(1);
    }
}