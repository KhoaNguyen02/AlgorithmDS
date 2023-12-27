#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <climits>

using namespace std;

class Box {
public:
     double x, y, z;

     Box() : x(0), y(0), z(0) {}

     Box(double x, double y, double z) : x(x), y(y), z(z) {}

     bool isBigger(const Box &box) const {
          return (x > box.x && y > box.y && z > box.z) ||
                 (x > box.x && y > box.z && z > box.y) ||
                 (x > box.y && y > box.x && z > box.z) ||
                 (x > box.y && y > box.z && z > box.x) ||
                 (x > box.z && y > box.x && z > box.y) ||
                 (x > box.z && y > box.y && z > box.x);
     }
};

class Edge {
public:
     int u, v, flow, capacity, reverseIndex;

     Edge(int u, int v, int flow, int capacity, int reverseIndex)
         : u(u), v(v), flow(flow), capacity(capacity), reverseIndex(reverseIndex) {}
};

class Graph {
public:
     int numVertices;
     vector<vector<Edge>> edges;

     Graph(int numVertices) : numVertices(numVertices), edges(numVertices) {}

     void addEdge(int u, int v)
     {
          edges[u].emplace_back(u, v, 0, 1, edges[v].size());
          edges[v].emplace_back(v, u, 0, 0, edges[u].size() - 1);
     }
};

class Main {
public:
     int solve(int n, const vector<Box> &boxes);

private:
     Graph buildNetwork(int n, const vector<Box> &boxes);
     bool bfs(Graph &network, int source, int sink, vector<int> &level);
     int dfs(Graph &network, int source, int sink, int flow, vector<int> &level, vector<int> &pointers);
     int maxFlow(Graph &network, int source, int sink);
};

int Main::solve(int n, const vector<Box> &boxes) {
     Graph network = buildNetwork(n, boxes);
     int source = 0, sink = 2 * n + 1;
     return n - maxFlow(network, source, sink);
}

Graph Main::buildNetwork(int n, const vector<Box> &boxes) {
     Graph network(2 * n + 2);
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

bool Main::bfs(Graph &network, int source, int sink, vector<int> &level) {
     fill(level.begin(), level.end(), -1);
     level[source] = 0;
     queue<int> q;
     q.push(source);
     while (!q.empty()) {
          int u = q.front();
          q.pop();
          for (const Edge &edge : network.edges[u]) {
               if (level[edge.v] < 0 && edge.flow < edge.capacity) {
                    level[edge.v] = level[u] + 1;
                    q.push(edge.v);
               }
          }
     }
     return level[sink] >= 0;
}

int Main::dfs(Graph &network, int source, int sink, int flow, vector<int> &level, vector<int> &pointers) {
     if (source == sink)
          return flow;
     for (int i = pointers[source]; i < static_cast<int>(network.edges[source].size()); i++) {
          Edge &edge = network.edges[source][i];
          if (level[edge.v] == level[source] + 1 && edge.flow < edge.capacity) {
               int tempFlow = dfs(network, edge.v, sink, min(flow, edge.capacity - edge.flow), level, pointers);
               if (tempFlow > 0) {
                    edge.flow += tempFlow;
                    network.edges[edge.v][edge.reverseIndex].flow -= tempFlow;
                    return tempFlow;
               }
          }
          pointers[source]++;
     }
     return 0;
}

int Main::maxFlow(Graph &network, int source, int sink) {
     int maxFlow = 0;
     vector<int> level(network.numVertices);
     vector<int> pointers(network.numVertices);
     while (bfs(network, source, sink, level)) {
          fill(pointers.begin(), pointers.end(), 0);
          while (true) {
               int tempFlow = dfs(network, source, sink, INT_MAX, level, pointers);
               if (tempFlow == 0)
                    break;
               maxFlow += tempFlow;
          }
     }
     return maxFlow;
}

int main() {
     Main main;
     int n;
     cin >> n;
     vector<Box> boxes(n);
     for (int i = 0; i < n; i++) {
          double x, y, z;
          cin >> x >> y >> z;
          boxes[i] = Box(x, y, z);
     }
     cout << main.solve(n, boxes) << endl;
     return 0;
}
