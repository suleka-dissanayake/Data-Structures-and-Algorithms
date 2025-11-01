public class ManualDFS {
    static class BoolArray {
        private boolean[] data;
        private int size;

        BoolArray(int capacity) {
            data = new boolean[capacity];
            size = capacity;
        }

        void set(int idx, boolean val) {
            if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
            data[idx] = val;
        }

        boolean get(int idx) {
            if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
            return data[idx];
        }
    }

    static class IntList {
        private int[] data;
        private int size;

        IntList() {
            data = new int[4];
            size = 0;
        }

        void add(int value) {
            if (size == data.length) grow();
            data[size++] = value;
        }

        int get(int idx) {
            if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
            return data[idx];
        }

        int size() { return size; }

        private void grow() {
            int oldCap = data.length;
            int newCap = oldCap << 1;
            int[] tmp = new int[newCap];
            for (int i = 0; i < oldCap; i++) tmp[i] = data[i];
            data = tmp;
        }
    }

    static class IntGraph {
        private IntList[] adj;
        private int V;

        IntGraph(int vertices) {
            V = vertices;
            adj = new IntList[V];
            for (int i = 0; i < V; i++) adj[i] = new IntList();
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        IntList getNeighbors(int v) {
            return adj[v];
        }

        int vertexCount() { return V; }
    }

    static void dfsRec(IntGraph g, BoolArray visited, int s, IntList res) {
        visited.set(s, true);
        res.add(s);

        IntList neighbors = g.getNeighbors(s);
        for (int i = 0; i < neighbors.size(); i++) {
            int neigh = neighbors.get(i);
            if (!visited.get(neigh)) {
                dfsRec(g, visited, neigh, res);
            }
        }
    }

    static IntList dfs(IntGraph g) {
        BoolArray visited = new BoolArray(g.vertexCount());
        IntList res = new IntList();
        dfsRec(g, visited, 0, res);
        return res;
    }

    static void printIntList(IntList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        IntGraph g = new IntGraph(V);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(2, 4);

        IntList traversal = dfs(g);
        printIntList(traversal);
    }
}