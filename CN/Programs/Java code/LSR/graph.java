
// # Assignment-10 -> Dijakstra algorithm
// # Name: Suraj Dalvi - A44
// # Write a program for Dijakstra algorithm to implement Link State Routing (LSR)
import java.util.*;

class Graph {

    private int V;
    private List<List<iPair>> adj;

    Graph(int v) {
        this.V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u, w));
    }

    void shortestPath(int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>(
                V,
                Comparator.comparingInt(o -> o.first));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(0, src));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().second;

            for (iPair v : adj.get(u)) {
                if (dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second;
                    pq.add(new iPair(dist[v.first], v.first));
                }
            }
        }
        System.out.println("\n# Source Node: 2");
        System.out.println("\nVertex  Distance: ");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class iPair {

        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        System.out.println("\n----- Dijakstra algorithm (LSR) ------");

        // # Number of nodes
        int vertex = 4;

        // # Create Graph
        Graph g = new Graph(vertex);

        g.addEdge(0, 1, 2);
        g.addEdge(1, 2, 10);
        g.addEdge(2, 3, 8);
        g.addEdge(3, 2, 11);
        g.addEdge(2, 3, 7);

        // # Find shortest path from source node to all other nodes
        g.shortestPath(2);
    }
}