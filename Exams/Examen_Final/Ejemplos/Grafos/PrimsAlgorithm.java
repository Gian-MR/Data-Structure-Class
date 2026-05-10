package Examen_Final.Ejemplos.Grafos;
import java.util.*;

/**
 * PRIM'S ALGORITHM - Minimum Spanning Tree (MST)
 * 
 * Problem: Find a TREE that connects all vertices with MINIMUM total weight
 * A spanning tree must have exactly (V-1) edges and connect all V vertices
 * 
 * Key Concepts:
 * - Only works on UNDIRECTED graphs
 * - Greedy algorithm: Always picks the minimum weight edge from visited to unvisited
 * - Time Complexity: O(V²) with array, O(E log V) with priority queue
 * - Applications: Network design, road construction, electrical grids
 * 
 * How it works:
 * 1. Start with any vertex in the MST
 * 2. Find minimum weight edge connecting MST to a vertex outside
 * 3. Add that vertex to MST
 * 4. Repeat until all vertices are in MST
 */
public class PrimsAlgorithm {
    
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;
        
        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
    
    private List<Edge>[] adjList;
    private int vertices;
    
    @SuppressWarnings("unchecked")
    public PrimsAlgorithm(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    
    /**
     * Add undirected weighted edge
     */
    public void addEdge(int u, int v, int weight) {
        adjList[u].add(new Edge(u, v, weight));
        adjList[v].add(new Edge(v, u, weight));
    }
    
    /**
     * PRIM'S ALGORITHM implementation
     */
    public void prim(int startVertex) {
        boolean[] inMST = new boolean[vertices];
        int[] minCost = new int[vertices];
        int[] parent = new int[vertices];
        
        // Initialize
        Arrays.fill(minCost, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        minCost[startVertex] = 0;
        
        // Priority queue: stores (weight, vertex) pairs
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(-1, startVertex, 0));
        
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        
        System.out.println("Starting Prim's algorithm from vertex " + startVertex);
        System.out.println("=================================================\n");
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.destination;
            
            // Skip if already in MST
            if (inMST[v]) continue;
            
            inMST[v] = true;
            
            if (parent[v] != -1) {
                System.out.println("Adding edge: " + parent[v] + " -- " + v + " (weight: " + minCost[v] + ")");
                mstEdges.add(new Edge(parent[v], v, minCost[v]));
                totalCost += minCost[v];
            } else {
                System.out.println("Starting vertex: " + v);
            }
            
            // Add all edges from this vertex to unvisited vertices
            for (Edge adjacentEdge : adjList[v]) {
                int u = adjacentEdge.destination;
                int weight = adjacentEdge.weight;
                
                if (!inMST[u] && weight < minCost[u]) {
                    minCost[u] = weight;
                    parent[u] = v;
                    pq.add(new Edge(-1, u, weight));
                    System.out.println("  → Found lighter edge to vertex " + u + ": weight " + weight);
                }
            }
        }
        
        // Print MST
        System.out.println("\n=================================================");
        System.out.println("MINIMUM SPANNING TREE:");
        System.out.println("=================================================");
        System.out.println("Edges in MST:");
        for (Edge edge : mstEdges) {
            System.out.println("  " + edge.source + " -- " + edge.destination + " (weight: " + edge.weight + ")");
        }
        System.out.println("\nTotal weight of MST: " + totalCost);
        System.out.println("Number of edges: " + mstEdges.size());
        System.out.println("(Should be " + (vertices - 1) + " edges for " + vertices + " vertices)");
    }
    
    public static void main(String[] args) {
        System.out.println("\n===== PRIM'S ALGORITHM EXAMPLE =====\n");
        
        PrimsAlgorithm graph = new PrimsAlgorithm(6);
        
        // Create a weighted undirected graph:
        //      10           12
        //   0 ------- 1 ------- 2
        //   |         |         |
        //   | 5       | 2       | 8
        //   |         |         |
        //   3 ------- 4 ------- 5
        //       3         4
        
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 12);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 2, 4);
        graph.addEdge(4, 5, 4);
        graph.addEdge(2, 5, 8);
        
        graph.prim(0);
        
        System.out.println("\n\n===== KEY INSIGHTS =====");
        System.out.println("• Prim's always picks the MINIMUM weight edge from MST to outside");
        System.out.println("• Different from Dijkstra:");
        System.out.println("  - Dijkstra: Finds shortest PATH from source to all nodes");
        System.out.println("  - Prim's: Finds minimum TREE connecting all nodes");
        System.out.println("• MST has exactly (V-1) edges and is acyclic");
        System.out.println("• Applications:");
        System.out.println("  - Road/railway networks (minimize total distance)");
        System.out.println("  - Power distribution systems");
        System.out.println("  - Computer network design");
    }
}
