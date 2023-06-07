// # Assignment-10 -> Dijakstra algorithm
// # Name: Suraj Dalvi - A44
// # Write a program for Dijakstra algorithm to implement Link State Routing (LSR)

import java.util.Scanner;

public class graph {

    private static void dijkstra(int[][] graph, int source) {
        int v = graph.length;
        boolean visited[] = new boolean[v];
        int distance[] = new int[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        for (int i = 0; i < v - 1; i++) {
            // Find vertex with min distance
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;
            // Explore neighbors
            for (int j = 0; j < v; j++) {
                if (graph[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDist = distance[minVertex] + graph[minVertex][j];
                    if (newDist < distance[j]) {
                        distance[j] = newDist;
                    }
                }
            }
        }

        // # Print Distance
        System.out.println("\n# Source Node: " + source);
        System.out.println("\nNode\tEdge\tDistance");
        System.out.println("--------------------------");
        for (int i = 0; i < v; i++) {
            System.out.println(" " + i + "\t" + source + "-->" + i + "\t   " + distance[i]);
        }

    }

    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n----- Dijakstra algorithm -----\n");
        System.out.print("# Enter vertices: ");
        int v = s.nextInt();
        System.out.print("\n# Enter edges: ");
        int e = s.nextInt();
        System.out.print("\n# Enter source node: ");
        int source = s.nextInt();
        int graph[][] = new int[v][v];
        System.out.println("\n# Create Graph:");
        for (int i = 0; i < e; i++) {
            System.out.println("\n # Edge-" + (i + 1) + ": ");
            System.out.print("\n Enter V1: ");
            int v1 = s.nextInt();
            System.out.print(" Enter V2: ");
            int v2 = s.nextInt();
            System.out.print(" Enter Weight: ");
            int weight = s.nextInt();
            graph[v1][v2] = weight;
            graph[v2][v1] = weight;
        }
        System.out.println("\nGraph created successfully..");
        // # Call Function
        dijkstra(graph, source);
        s.close();
    }
}