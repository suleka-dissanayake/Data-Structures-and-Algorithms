class Shortest_Unweighted {
    int size;
    int[][] graph;

    public Shortest_Unweighted(int size) {
        this.size = size;
        graph = new int[size][size];
    }

    public void addEdge(int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    public void removeEdge(int x, int y) {
        graph[x][y] = 0;
        graph[y][x] = 0;
    }

    public void displayGraph() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Manual BFS for shortest path
    public void shortestPath(int start, int end) {
        boolean[] visited = new boolean[size];
        int[] parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = -1;

        // Manual queue implementation
        int[] queue = new int[size];
        int front = 0, rear = 0;

        visited[start] = true;
        queue[rear++] = start;

        while (front < rear) {
            int current = queue[front++];
            for (int i = 0; i < size; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue[rear++] = i;
                    if (i == end) break;
                }
            }
        }

        // Reconstruct path
        int[] path = new int[size];
        int pathLength = 0;
        int crawl = end;
        while (crawl != -1) {
            path[pathLength++] = crawl;
            crawl = parent[crawl];
        }

        // Print path in reverse
        if (path[pathLength - 1] != start) {
            System.out.println("No path found.");
        } else {
            System.out.print("Shortest path: ");
            for (int i = pathLength - 1; i >= 0; i--) {
                System.out.print(path[i]);
                if (i != 0) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Shortest_Unweighted myGraph = new Shortest_Unweighted(5);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(1, 4);
        myGraph.addEdge(1, 3);
        myGraph.addEdge(3, 1);
        myGraph.displayGraph();
        myGraph.shortestPath(0, 4);
    }
}