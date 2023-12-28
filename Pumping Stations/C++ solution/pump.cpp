#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

class Edge {
public:
    int u, v, time;

    /**
     * A class to create an edge (u, v) in our graph.
     * @param u start vertex
     * @param v end vertex
     * @param time time to travel from u to v
     */
    Edge(int u, int v, int time) : u(u), v(v), time(time) {}
};

class Graph {
public:
    int n_vertices, n_pumps;

    // List of pumping stations
    vector<int> pump_stations;

    // Adjacency list
    vector<vector<Edge>> edges;

    /**
     * A class to build a graph.
     * @param n_vertices number of vertices in the graph
     * @param n_pumps number of pumping stations in the graph
    */
    Graph(int n_vertices, int n_pumps) : n_vertices(n_vertices), n_pumps(n_pumps), edges(n_vertices) {}

    /**
     * Add a pumping station to the graph.
     * @param vertex location of this pumping station
     */
    void addPumpingStation(int vertex) {
        pump_stations.push_back(vertex);
    }

    /**
     * Add an edge (u,v) with weight time to the graph.
     * @param u start vertex
     * @param v end vertex
     * @param time time to travel from u to v
    */
    void addEdge(int u, int v, int time) {
        edges[u].push_back(Edge(u, v, time));
        edges[v].push_back(Edge(v, u, time));
    }
};

class Main {
public:
    /**
     * Solve the problem with graph reduction and dynamic programming.
     * @param graph the graph
     * @param limit the time limit
     * @return the maximum amount of money that can be earned
     */
    int solve(Graph &graph, int limit);

    /**
     * Reduce the graph to a smaller graph with only start vertex and pumping stations.
     * Each edge (u, v) in the reduced graph is the shortest path from u to v in the original graph.
     * @param graph original graph
     * @return reduced graph
     */
    Graph reduce(Graph &graph);

    /**
     * Get the shortest distance from a vertex to another vertex using SPFA.
     * @param graph given graph
     * @param start start vertex
     * @param end end vertex
     * @return shortest distance from start to end
    */
    int get_shortest_dist(Graph &graph, int start, int end);
    
    /**
     * Explore all possible paths in reduced graph within the time limit, and find 
     * the maximum amount of water that can be pumped out.
     * @param graph reduced graph
     * @param vertex current vertex
     * @param amount current amount of water
     * @param active number of active pumping stations
     * @param time current time
     * @param limit time limit
     * @param visited visited vertices
     * @param result maximum amount of water that can be pumped out
    */
    void explore(Graph &graph, int vertex, int amount, int active, int time, int limit,
                 vector<bool> &visited, int &result);
};

int Main::solve(Graph &graph, int limit) {
    Graph condensed_graph = reduce(graph);

    if (condensed_graph.n_vertices == 0) {
        return 0;
    }

    vector<bool> visited(condensed_graph.n_vertices, false);
    int result = 0;
    visited[0] = true;
    explore(condensed_graph, 0, 0, 0, 0, limit, visited, result);
    return result;
}

Graph Main::reduce(Graph &graph) {
    Graph condensed_graph(graph.n_pumps + 1, graph.n_pumps);

    // Add pumping stations to the reduced graph
    for (int i = 0; i < graph.n_pumps; i++) {
        condensed_graph.addPumpingStation(graph.pump_stations[i]);
    }

    // Add edges between start vertex and pumping stations
    for (int i = 0; i < condensed_graph.n_pumps; i++) {
        int dist = get_shortest_dist(graph, 0, condensed_graph.pump_stations[i]);
        if (dist == INT_MAX) return Graph(0, 0);
        condensed_graph.addEdge(0, i + 1, dist);
    }

    // Add edges between pumping stations
    for (int i = 0; i < condensed_graph.n_pumps; i++) {
        for (int j = i + 1; j < condensed_graph.n_pumps; j++) {
            int u = condensed_graph.pump_stations[i];
            int v = condensed_graph.pump_stations[j];
            int dist = get_shortest_dist(graph, u, v);
            if (dist == INT_MAX) return Graph(0, 0);
            condensed_graph.addEdge(i + 1, j + 1, dist);
        }
    }
    return condensed_graph;
}

int Main::get_shortest_dist(Graph &graph, int start, int end) {
    vector<int> dist(graph.n_vertices, INT_MAX);
    dist[start] = 0;

    // Initialize queue
    queue<int> q;
    vector<bool> in_queue(graph.n_vertices, false);
    q.push(start);
    in_queue[start] = true;

    // Shortest path faster algorithm (SPFA)
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        in_queue[u] = false;
        for (const Edge &neighbor : graph.edges[u]) {
            int v = neighbor.v;
            int time = neighbor.time;
            if (dist[u] + time < dist[v]) {
                dist[v] = dist[u] + time;
                if (!in_queue[v]) {
                    q.push(v);
                    in_queue[v] = true;
                }
            }
        }
    }
    return dist[end];
}

void Main::explore(Graph &graph, int vertex, int amount, int n_active, int time, int limit,
                   vector<bool> &visited, int &result) {
    // If time exceeds limit, stop exploring this path, and update result
    if (time > limit) {
        result = max(result, amount - 200 * (n_active - 1) * (time - limit));
    }

    // If all pumping stations are active and we still have time left, update result
    if (n_active == graph.n_pumps && time <= limit) {
        result = max(result, amount + 200 * graph.n_pumps * (limit - time));
    }
    // Recursive case: explore all possible paths
    for (const Edge &edge : graph.edges[vertex]) {
        if (visited[edge.v]) continue;
        visited[edge.v] = true;
        int time_to_activate = time + edge.time + 10;
        n_active++;
        int curr_amount = amount + 200 * (n_active - 1) * (time_to_activate - time);
        explore(graph, edge.v, curr_amount, n_active, time_to_activate, limit, visited, result);
        visited[edge.v] = false;
        n_active--;
    }
}

int main() {
    int n_vertices, n_pumps, n_edges, limit;
    cin >> n_vertices >> n_pumps >> n_edges >> limit;
    Graph graph(n_vertices + 1, n_pumps);
    graph.addEdge(0, 1, 0);
    for (int i = 0; i < n_pumps; i++) {
        int pumpingStation;
        cin >> pumpingStation;
        graph.addPumpingStation(pumpingStation);
    }
    for (int i = 0; i < n_edges; i++) {
        int u, v, time;
        cin >> u >> v >> time;
        graph.addEdge(u, v, time);
    }
    Main main;
    cout << main.solve(graph, limit) << endl;

    return 0;
}
