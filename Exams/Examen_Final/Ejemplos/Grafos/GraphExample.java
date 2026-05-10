package Examen_Final.Ejemplos.Grafos;
import java.util.*;

/**
 * GRAPH BASICS - Understanding Vertices, Edges, and Adjacency
 * 
 * A graph consists of:
 * - Vertices (nodes): The data points
 * - Edges: Connections between vertices
 * - Can be Directed (one-way) or Undirected (two-way)
 * - Can be Weighted or Unweighted
 */
public class GraphExample {
    
    // Using Adjacency List representation (better for sparse graphs)
    private Map<Integer, List<Integer>> adjList;
    private int vertices;
    
    public GraphExample(int vertices) {
        this.vertices = vertices;
        this.adjList = new HashMap<>();
        
        // Initialize empty lists for each vertex
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }
    
    /**
     * Add an edge to the graph (UNDIRECTED)
     * For undirected graphs, if there's an edge from A to B,
     * there's also an edge from B to A
     */
    public void addEdgeUndirected(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);  // For undirected graphs
    }
    
    /**
     * Add an edge to the graph (DIRECTED)
     * Only goes from u to v (one direction)
     */
    public void addEdgeDirected(int u, int v) {
        adjList.get(u).add(v);
    }
    
    /**
     * Display the adjacency list representation
     */
    public void displayGraph() {
        System.out.println("\n=== ADJACENCY LIST ===");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("===== GRAPH BASICS EXAMPLE =====\n");
        
        // Create an undirected graph with 5 vertices (0, 1, 2, 3, 4)
        GraphExample graph = new GraphExample(5);
        
        // Add edges to create this graph:
        // 0 -- 1 -- 2
        //      |    |
        //      3 -- 4
        
        System.out.println("Creating an UNDIRECTED graph:");
        graph.addEdgeUndirected(0, 1);
        graph.addEdgeUndirected(1, 2);
        graph.addEdgeUndirected(1, 3);
        graph.addEdgeUndirected(2, 4);
        graph.addEdgeUndirected(3, 4);
        
        graph.displayGraph();
        
        // Now let's show a DIRECTED graph
        System.out.println("\n\n===== DIRECTED GRAPH EXAMPLE =====\n");
        GraphExample directedGraph = new GraphExample(4);
        
        // Create directed graph (like one-way streets):
        // 0 -> 1 -> 2
        //      |    ^
        //      v    |
        //      3 ---
        
        System.out.println("Creating a DIRECTED graph:");
        directedGraph.addEdgeDirected(0, 1);
        directedGraph.addEdgeDirected(1, 2);
        directedGraph.addEdgeDirected(1, 3);
        directedGraph.addEdgeDirected(3, 2);
        
        directedGraph.displayGraph();
        
        System.out.println("\n\nKey Differences:");
        System.out.println("UNDIRECTED: If 0->1 exists, then 1->0 automatically exists");
        System.out.println("DIRECTED: Only 0->1 exists (like a one-way street)");
    }
}
