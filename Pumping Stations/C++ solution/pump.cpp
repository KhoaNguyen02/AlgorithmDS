#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

class Edge {
public:
    int u, v, time;

    Edge(int u, int v, int time) : u(u), v(v), time(time) {}
};

class Graph {
public:
    int numVertices, numPumps;
    vector<int> pumpingStations;
    vector<vector<Edge>> edges;

    Graph(int numVertices, int numPumps) : numVertices(numVertices), numPumps(numPumps), edges(numVertices) {}

    void addPumpingStation(int vertex) {
        pumpingStations.push_back(vertex);
    }

    void addEdge(int u, int v, int time) {
        edges[u].push_back(Edge(u, v, time));
        edges[v].push_back(Edge(v, u, time));
    }

    string toString() {
        string result;
        for (int i = 0; i < numVertices; i++) {
            result += to_string(i) + ": ";
            for (const Edge &edge : edges[i]) {
                result += "(" + to_string(edge.v) + ", " + to_string(edge.time) + "); ";
            }
            result += "\n";
        }
        return result;
    }
};

class Main {
public:
    int solve(Graph &graph, int limit);

    Graph reduce(Graph &graph);

    int getShortestDist(Graph &graph, int start, int end);

    void explore(Graph &graph, int vertex, int amount, int active, int time, int limit,
                 vector<bool> &visited, int &result);
};

int Main::solve(Graph &graph, int limit) {
    Graph condensedGraph = reduce(graph);

    if (condensedGraph.numVertices == 0) {
        return 0;
    }

    vector<bool> visited(condensedGraph.numVertices, false);
    int result = 0;
    visited[0] = true;
    explore(condensedGraph, 0, 0, 0, 0, limit, visited, result);
    return result;
}

Graph Main::reduce(Graph &graph) {
    Graph condensedGraph(graph.numPumps + 1, graph.numPumps);

    for (int i = 0; i < graph.numPumps; i++) {
        condensedGraph.addPumpingStation(graph.pumpingStations[i]);
    }

    for (int i = 0; i < condensedGraph.numPumps; i++) {
        int dist = getShortestDist(graph, 0, condensedGraph.pumpingStations[i]);
        if (dist == INT_MAX) return Graph(0, 0);
        condensedGraph.addEdge(0, i + 1, dist);
    }

    for (int i = 0; i < condensedGraph.numPumps; i++) {
        for (int j = i + 1; j < condensedGraph.numPumps; j++) {
            int u = condensedGraph.pumpingStations[i];
            int v = condensedGraph.pumpingStations[j];
            int dist = getShortestDist(graph, u, v);
            if (dist == INT_MAX) return Graph(0, 0);
            condensedGraph.addEdge(i + 1, j + 1, dist);
        }
    }
    return condensedGraph;
}

int Main::getShortestDist(Graph &graph, int start, int end) {
    vector<int> dist(graph.numVertices, INT_MAX);
    dist[start] = 0;

    queue<int> q;
    vector<bool> inQueue(graph.numVertices, false);
    q.push(start);
    inQueue[start] = true;

    while (!q.empty()) {
        int u = q.front();
        q.pop();
        inQueue[u] = false;
        for (const Edge &neighbor : graph.edges[u]) {
            int v = neighbor.v;
            int time = neighbor.time;
            if (dist[u] + time < dist[v]) {
                dist[v] = dist[u] + time;
                if (!inQueue[v]) {
                    q.push(v);
                    inQueue[v] = true;
                }
            }
        }
    }
    return dist[end];
}

void Main::explore(Graph &graph, int vertex, int amount, int active, int time, int limit,
                   vector<bool> &visited, int &result) {
    if (time > limit) {
        result = max(result, amount - 200 * (active - 1) * (time - limit));
    }

    if (active == graph.numPumps) {
        result = max(result, amount + 200 * graph.numPumps * (limit - time));
    }

    for (const Edge &edge : graph.edges[vertex]) {
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

int main() {
    int numVertices, numPumps, numEdges, timeLimit;
    cin >> numVertices >> numPumps >> numEdges >> timeLimit;
    Graph graph(numVertices + 1, numPumps);
    graph.addEdge(0, 1, 0);
    for (int i = 0; i < numPumps; i++) {
        int pumpingStation;
        cin >> pumpingStation;
        graph.addPumpingStation(pumpingStation);
    }
    for (int i = 0; i < numEdges; i++) {
        int u, v, time;
        cin >> u >> v >> time;
        graph.addEdge(u, v, time);
    }
    Main main;
    cout << main.solve(graph, timeLimit) << endl;

    return 0;
}
