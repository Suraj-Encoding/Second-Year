
// # Assignment-10 -> Dijakstra algorithm
// # Name: Suraj Dalvi - A44
// # Write a program for Dijakstra algorithm to implement Link State Routing (LSR)

import java.util.Scanner;

public class graph {

    private static void dijkstra(int[][] graph) {
        int v = graph.length;
        boolean visited[] = new boolean[v];
        
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n----- Dijakstra algorithm -----\n");
        System.out.print("# Enter vertices: ");
        int v = s.nextInt();
        System.out.print("\n# Enter edges: ");
        int e = s.nextInt();
        int graph[][] = new int[v][v];
        System.out.println("\n# Create Graph:");
        for (int i = 0; i < e; i++) {
            System.out.println("\n # Edge-" + (i+1) + ": ");
            System.out.print("\n Enter V1: ");
            int v1 = s.nextInt();
            System.out.print(" Enter V2: ");
            int v2 = s.nextInt();
            System.out.print(" Enter Weight: ");
            int weight = s.nextInt();
            graph[v1][v2] = weight;
            graph[v2][v1] = weight;
        }
        // # Call Function
        dijkstra(graph);
    }
}