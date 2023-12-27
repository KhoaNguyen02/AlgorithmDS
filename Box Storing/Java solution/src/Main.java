import java.util.*;

class Box {
    /**
     * x, y, z are three dimensions of the box
     */
    double x, y, z;

    /**
     * Construct a Box with three dimensions x, y, z
     * @param x x dimension
     * @param y y dimension
     * @param z z dimension
     */
    public Box(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Check if current box is larger than the given box in all dimensions
     * @param box box to compare with
     * @return true if current box is larger than the given box in all dimensions, false otherwise
     */
    public boolean isBigger(Box box) {
        return this.x > box.x && this.y > box.y && this.z > box.z ||
                this.x > box.x && this.y > box.z && this.z > box.y ||
                this.x > box.y && this.y > box.x && this.z > box.z ||
                this.x > box.y && this.y > box.z && this.z > box.x ||
                this.x > box.z && this.y > box.x && this.z > box.y ||
                this.x > box.z && this.y > box.y && this.z > box.x;
    }
}

class Edge {
    int u, v; // u is start vertex, v is end vertex
    int flow, capacity; // flow and capacity of this edge
    int reverseIndex; // index of the reverse edge of this edge in the adjacency list

    /**
     * Construct an edge between two vertices with given capacity
     * @param u start vertex
     * @param v end vertex
     * @param flow current flow of this edge
     * @param capacity capacity of this edge
     */
    public Edge(int u, int v, int flow, int capacity, int reverseIndex) {
        this.u = u;
        this.v = v;
        this.flow = flow;
        this.capacity = capacity;
        this.reverseIndex = reverseIndex;
    }
}

class Graph {
    int numVertices; // number of vertices in the graph
    ArrayList<Edge>[] edges; // store graph as an adjacency list

    /**
     * Construct a graph with given number of vertices
     * @param numVertices number of vertices
     */
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        edges = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    /**
     * Add an edge between two vertices to the graph
     * @param u start vertex
     * @param v end vertex
     */
    public void addEdge(int u, int v) {
        edges[u].add(new Edge(u, v, 0, 1, edges[v].size()));
        edges[v].add(new Edge(v, u, 0, 0, edges[u].size() - 1));
    }
}

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Box[] boxes = new Box[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = new Box(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        }
        System.out.println(main.solve(n, boxes));
    }

    /**
     * Solve box storing problem
     * @param n number of boxes
     * @param boxes array of boxes
     * @return minimum final boxes after performing best box storing strategy
     */
    public int solve(int n, Box[] boxes) {
        Graph network = buildNetwork(n, boxes);
        int source = 0, sink = 2 * n + 1;
        return n - maxFlow(network, source, sink);
    }

    /**
     * Build a flow network to represent relations between boxes
     * @param n number of boxes
     * @param boxes array of boxes
     * @return a flow network arising from bipartite graph of boxes
     */
    private Graph buildNetwork(int n, Box[] boxes) {
        Graph network = new Graph(2 * n + 2);
        int source = 0, sink = 2 * n + 1;
        for (int i = 0; i < n; i++) {
            for (int j = n; j < 2 * n; j++) {
                if (boxes[i].isBigger(boxes[j - n])) {
                    network.addEdge(i + 1, j + 1);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            network.addEdge(source, i);
            network.addEdge(i + n, sink);
        }
        return network;
    }

    /**
     * Update level of each vertex in the network on the way from source to sink using BFS
     * @param network flow network
     * @param source source vertex
     * @param sink sink vertex
     * @param level an array to store level of each vertex
     * @return true if there is a path from source to sink, false otherwise
     */
    private boolean bfs(Graph network, int source, int sink, int[] level) {
        Arrays.fill(level, -1);
        level[source] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Edge edge : network.edges[u]) {
                if (level[edge.v] < 0 && edge.flow < edge.capacity) {
                    level[edge.v] = level[u] + 1;
                    queue.add(edge.v);
                }
            }
        }
        return level[sink] >= 0;
    }

    /**
     * Send flow from source to sink using DFS
     * @param network flow network
     * @param source source vertex
     * @param sink sink vertex
     * @param flow flow to send
     * @param level an array to store level of each vertex
     * @param pointers an array to store pointers to the next edge to visit
     * @return flow sent
     */
    private int dfs(Graph network, int source, int sink, int flow, int[] level, int[] pointers) {
        if (source == sink) return flow;
        for (int i = pointers[source]; i < network.edges[source].size(); i++) {
            Edge edge = network.edges[source].get(i);
            if (level[edge.v] == level[source] + 1 && edge.flow < edge.capacity) {
                int tempFlow = dfs(network, edge.v, sink, Math.min(flow, edge.capacity - edge.flow), level, pointers);
                if (tempFlow > 0) {
                    edge.flow += tempFlow;
                    network.edges[edge.v].get(edge.reverseIndex).flow -= tempFlow;
                    return tempFlow;
                }
            }
            pointers[source]++;
        }
        return 0;
    }

    /**
     * Find maximum flow from source to sink in the network with Dinic's algorithm
     * @param network flow network
     * @param source source vertex
     * @param sink sink vertex
     * @return maximum flow of the network
     */
    private int maxFlow(Graph network, int source, int sink) {
        int maxFlow = 0;
        int[] level = new int[network.numVertices];
        int[] pointers = new int[network.numVertices];
        while (bfs(network, source, sink, level)) {
            Arrays.fill(pointers, 0);
            while (true) {
                int tempFlow = dfs(network, source, sink, Integer.MAX_VALUE, level, pointers);
                if (tempFlow == 0) break;
                maxFlow += tempFlow;
            }
        }
        return maxFlow;
    }
}