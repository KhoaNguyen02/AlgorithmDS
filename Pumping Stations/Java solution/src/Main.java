import java.util.*;

class Edge {
    int u, v, time;

    /**
     * An object to create an edge (u, v) in our graph.
     * @param u start vertex
     * @param v end vertex
     * @param time time to travel from u to v
     */
    Edge(int u, int v, int time) {
        this.u = u;
        this.v = v;
        this.time = time;
    }
}

class Graph {
    int numVertices, numPumps;

    // List of pumping stations
    List<Integer> pumpingStations;

    // Adjacency list
    List<Edge>[] edges;

    /**
     * An object to create a graph.
     * @param numVertices number of vertices in the graph
     * @param numPumps number of pumping stations in the graph
     */
    Graph(int numVertices, int numPumps) {
        this.numVertices = numVertices;
        this.numPumps = numPumps;
        pumpingStations = new ArrayList<>();
        edges = new List[numVertices];
        for (int i = 0; i < numVertices; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    /**
     * Add a pumping station to the graph.
     * @param vertex location of this station
     */
    void addPumpingStation(int vertex) {
        pumpingStations.add(vertex);
    }

    /**
     * Add an undirected edge to the graph.
     * @param u start vertex
     * @param v end vertex
     * @param time time to travel from u to v
     */
    void addEdge(int u, int v, int time) {
        edges[u].add(new Edge(u, v, time));
        edges[v].add(new Edge(v, u, time));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            sb.append(i).append(": ");
            for (Edge edge : edges[i]) {
                sb.append("(").append(edge.v).append(", ").append(edge.time).append(")").append("; ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVertices = scanner.nextInt();
        int numPumps = scanner.nextInt();
        int numEdges = scanner.nextInt();
        int timeLimit = scanner.nextInt();
        Graph graph = new Graph(numVertices + 1, numPumps);
        graph.addEdge(0, 1, 0);
        for (int i = 0; i < numPumps; i++) {
            graph.addPumpingStation(scanner.nextInt());
        }
        for (int i = 0; i < numEdges; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        Main main = new Main();
        System.out.println(main.solve(graph, timeLimit));
    }

    /**
     * Reduce original graph to a smaller graph with start vertex and pumping stations as vertices.
     * Each edge (u, v) in the reduced graph is the shortest path from u to v in the original graph.
     * @param graph original graph
     * @return reduced graph
     */
    public Graph reduce(Graph graph) {
        Graph condensedGraph = new Graph(graph.numPumps +1, graph.numPumps);

        // Add pumps to the graph
        for (int i = 0; i < graph.numPumps; i++) {
            condensedGraph.addPumpingStation(graph.pumpingStations.get(i));
        }

        // Add edges between start vertex and pumping stations
        for (int i = 0; i < condensedGraph.numPumps; i++) {
            int dist = getShortestDist(graph, 0, condensedGraph.pumpingStations.get(i));
            if (dist == Integer.MAX_VALUE) return null;
            condensedGraph.addEdge(0, i+1, dist);
        }

        // Add edges between pumping stations
        for (int i = 0; i < condensedGraph.numPumps; i++) {
            for (int j = i+1; j < condensedGraph.numPumps; j++) {
                int u = condensedGraph.pumpingStations.get(i);
                int v = condensedGraph.pumpingStations.get(j);
                int dist = getShortestDist(graph, u, v);
                if (dist == Integer.MAX_VALUE) return null;
                condensedGraph.addEdge(i+1, j+1, dist);
            }
        }
        return condensedGraph;
    }

    /**
     * Find the shortest distance from start vertex to end vertex in the graph
     * using Shortest Path Faster Algorithm.
     * @param graph given graph
     * @param start start vertex
     * @param end end vertex
     * @return shortest distance
     */
    public int getShortestDist(Graph graph, int start, int end) {
        int[] dist = new int[graph.numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[graph.numVertices];
        queue.offer(start);
        inQueue[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            inQueue[u] = false;
            for (Edge neighbor : graph.edges[u]) {
                int v = neighbor.v;
                int time = neighbor.time;
                if (dist[u] + time < dist[v]) {
                    dist[v] = dist[u] + time;
                    if (!inQueue[v]) {
                        queue.offer(v);
                        inQueue[v] = true;
                    }
                }
            }
        }
        return dist[end];
    }

    /**
     * Explore all possible paths in reduced graph within a time limit, and record
     * total amount of water that can be pumped for each path.
     * @param graph reduced graph
     * @param vertex current vertex
     * @param amount total amount of water pumped
     * @param active number of active pumping stations
     * @param time current time stamp
     * @param limit time limit
     * @param visited list of visited vertices
     * @param result maximum amount of water that can be pumped so far
     */
    public void explore(Graph graph, int vertex, int amount, int active, int time, int limit,
                        boolean[] visited, int[] result) {
        // If we run out of time, update the result if the current amount is higher
        if (time > limit) {
            result[0] = Math.max(result[0], amount - 200 * (active - 1) * (time - limit));
        }
        // If all pumps are visited and we still have time, update the result if the current amount is higher
        if (active == graph.numPumps) {
            result[0] = Math.max(result[0], amount + 200 * graph.numPumps * (limit - time));
        }
        // Explore all possible paths
        for (Edge edge : graph.edges[vertex]) {
            if (visited[edge.v]) continue;
            visited[edge.v] = true;
            int activateTime = time + edge.time + 10;
            active++;
            int accumulateAmount = amount + 200 * (active - 1) * (activateTime - time);
            explore(graph, edge.v, accumulateAmount, active, activateTime, limit, visited, result);
            visited[edge.v] = false;
            active--;
        }
    }

    /**
     * Solve Pumping Station problem using graph reduction and dynamic programming.
     * @param graph given graph
     * @param limit time limit
     * @return maximum amount of water that can be pumped
     */
    public int solve(Graph graph, int limit) {
        // Reduce graph
        Graph condensedGraph = reduce(graph);

        // If there is no path from start vertex to any pumping station, return 0
        if (condensedGraph == null) return 0;

        // Recursively find maximum amount of water that can be pumped
        boolean[] visited = new boolean[condensedGraph.numVertices];
        int[] result = {0};
        visited[0] = true;
        explore(condensedGraph, 0, 0, 0, 0, limit, visited, result);
        return result[0];
    }
}
