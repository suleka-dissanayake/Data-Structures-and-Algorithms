class GraphBFS {
    private int[][] adjMatrix;
    private boolean[] visited;
    private int vertices;

    public GraphBFS(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
        visited = new boolean[vertices];
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    static class Queue {
        private int[] elements;
        private int front;
        private int rear;
        private int maxSize;

        public Queue(int size) {
            elements = new int[size];
            front = 0;
            rear = -1;
            maxSize = size;
        }

        public void enqueue(int value) {
            if (rear < maxSize - 1) {
                elements[++rear] = value;
            }
        }

        public int dequeue() {
            if (!isEmpty()) {
                return elements[front++];
            }
            return -1; // Indicating empty queue
        }

        public boolean isEmpty() {
            return front > rear;
        }
    }

    public void bfs(int start) {
        Queue queue = new Queue(vertices);
        visited[start] = true;
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            System.out.print(current + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.print("BFS Traversal: ");
        graph.bfs(1);
    }
}
