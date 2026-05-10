package Examen_Final.Ejemplos.Grafos;
import java.util.*;

/**
 * DIJKSTRA'S ALGORITHM - Shortest Path in Weighted Graphs
 * 
 * Problem: Find the shortest path from a source node to all other nodes
 * 
 * Key Concepts:
 * - Works with WEIGHTED GRAPHS (edges have distances/costs)
 * - Works with POSITIVE weights only
 * - Greedy algorithm: Always picks the closest unvisited node
 * - Time Complexity: O(V²) with array, O(E log V) with priority queue
 * 
 * How it works:
 * 1. Start at source node with distance 0, all others infinity
 * 2. Pick unvisited node with smallest distance
 * 3. Update distances to its neighbors
 * 4. Mark it as visited
 * 5. Repeat until all nodes visited
 */
public class DijkstraAlgorithm {
    
    static class Edge {
        int destination;
        int weight;
        
        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        
        // For priority queue - min heap (smallest distance first)
        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }
    
    private List<Edge>[] adjList;
    private int vertices;
    
    @SuppressWarnings("unchecked")
    public DijkstraAlgorithm(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int u, int v, int weight) {
        adjList[u].add(new Edge(v, weight));
        adjList[v].add(new Edge(u, weight));  // For undirected
    }
    
    /**
     * DIJKSTRA'S ALGORITHM implementation
     */
    public void dijkstra(int source) {
        int[] distance = new int[vertices];
        int[] previous = new int[vertices];
        boolean[] visited = new boolean[vertices];
        
        // Initialize
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distance[source] = 0;
        
        // Priority queue: stores (vertex, distance) pairs
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        
        System.out.println("Starting Dijkstra from vertex " + source);
        System.out.println("============================================\n");
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            
            // Skip if already visited
            if (visited[u]) continue;
            
            visited[u] = true;
            System.out.println("Processing vertex " + u + " (distance: " + distance[u] + ")");
            
            // Check all neighbors
            for (Edge edge : adjList[u]) {
                int v = edge.destination;
                int weight = edge.weight;
                
                // If unvisited and found shorter path
                if (!visited[v] && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    previous[v] = u;
                    pq.add(new Node(v, distance[v]));
                    System.out.println("  → Updated distance to vertex " + v + ": " + distance[v] + 
                                     " (via vertex " + u + ")");
                }
            }
        }
        
        // Print results
        System.out.println("\n============================================");
        System.out.println("SHORTEST DISTANCES from vertex " + source + ":");
        System.out.println("============================================");
        for (int i = 0; i < vertices; i++) {
            System.out.print("To vertex " + i + ": ");
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("UNREACHABLE");
            } else {
                System.out.println(distance[i]);
                // Print the path
                System.out.print("  Path: ");
                printPath(i, previous);
                System.out.println();
            }
        }
    }
    
    private void printPath(int vertex, int[] previous) {
        if (vertex == -1) return;
        
        List<Integer> path = new ArrayList<>();
        int current = vertex;
        
        while (current != -1) {
            path.add(0, current);
            if (previous[current] == -1) break;
            current = previous[current];
        }
        
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" → ");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("\n===== DIJKSTRA'S ALGORITHM EXAMPLE =====\n");
        
        DijkstraAlgorithm graph = new DijkstraAlgorithm(6);
        
        // Create a weighted graph:
        //     10       12
        //  0 -----> 1 -----> 2
        //  |        |         |
        //  | 5      | 2       | 8
        //  v        v         v
        //  3 <----- 4 ------> 5
        //      3         4
        
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 12);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 2, 8);
        graph.addEdge(4, 5, 4);
        graph.addEdge(2, 5, 8);
        
        graph.dijkstra(0);
        
        System.out.println("\n\n===== KEY INSIGHTS =====");
        System.out.println("• Dijkstra ALWAYS picks the unvisited node with SMALLEST distance");
        System.out.println("• This greedy approach guarantees the shortest path");
        System.out.println("• Does NOT work with negative weights");
        System.out.println("• Time Complexity: O(E log V) with priority queue");
        System.out.println("• Perfect for: GPS navigation, network routing, game AI pathfinding");
    }
}
