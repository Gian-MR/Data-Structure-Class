package Examen_Final.Ejemplos.Grafos;
import java.util.*;

/**
 * ADJACENCY MATRIX REPRESENTATION
 * 
 * vs Adjacency List:
 * - Matrix: Uses 2D array [V][V]
 * - Matrix Memory: O(V²) - always uses quadratic space
 * - Matrix: Fast edge lookup O(1)
 * - List: Uses Map + Lists
 * - List Memory: O(V + E) - only stores existing edges
 * - List: Slower edge lookup O(degree)
 * 
 * When to use:
 * - DENSE graphs (many edges): Use MATRIX
 * - SPARSE graphs (few edges): Use ADJACENCY LIST
 */
public class AdjacencyMatrixExample {
    
    private int[][] matrix;
    private int vertices;
    
    public AdjacencyMatrixExample(int vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
        // Initialize with 0 (no edges)
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    
    /**
     * Add unweighted edge to adjacency matrix
     */
    public void addEdgeUnweighted(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;  // For undirected
    }
    
    /**
     * Add weighted edge to adjacency matrix
     */
    public void addEdgeWeighted(int u, int v, int weight) {
        matrix[u][v] = weight;
        matrix[v][u] = weight;  // For undirected
    }
    
    public void displayMatrix() {
        System.out.println("\nADJACENCY MATRIX:");
        System.out.print("    ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void analyzeEdges() {
        System.out.println("\nEDGE ANALYSIS:");
        int edgeCount = 0;
        System.out.println("Edges found:");
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (matrix[i][j] != 0) {
                    System.out.println("  " + i + " -- " + j + " (weight: " + matrix[i][j] + ")");
                    edgeCount++;
                }
            }
        }
        System.out.println("Total edges: " + edgeCount);
        System.out.println("Matrix size: " + vertices + "x" + vertices + " = " + (vertices * vertices) + " cells");
    }
    
    public static void main(String[] args) {
        System.out.println("===== ADJACENCY MATRIX EXAMPLE =====\n");
        
        // UNWEIGHTED EXAMPLE
        System.out.println("---------- UNWEIGHTED GRAPH ----------");
        AdjacencyMatrixExample unweighted = new AdjacencyMatrixExample(5);
        
        // Create graph:
        // 0 -- 1 -- 2
        //      |    |
        //      3 -- 4
        
        unweighted.addEdgeUnweighted(0, 1);
        unweighted.addEdgeUnweighted(1, 2);
        unweighted.addEdgeUnweighted(1, 3);
        unweighted.addEdgeUnweighted(2, 4);
        unweighted.addEdgeUnweighted(3, 4);
        
        unweighted.displayMatrix();
        unweighted.analyzeEdges();
        
        System.out.println("\n\nTo check if edge exists: matrix[u][v] != 0");
        System.out.println("Is there edge 0→1? " + (unweighted.matrix[0][1] != 0));
        System.out.println("Is there edge 0→4? " + (unweighted.matrix[0][4] != 0));
        
        // WEIGHTED EXAMPLE
        System.out.println("\n\n---------- WEIGHTED GRAPH ----------");
        AdjacencyMatrixExample weighted = new AdjacencyMatrixExample(4);
        
        // Create weighted graph:
        //     10       5
        //  0 ----> 1 ----> 2
        //   \             /
        //    \ 15 (cost) /
        //     \         / 8
        //      \--------> 3
        
        weighted.addEdgeWeighted(0, 1, 10);
        weighted.addEdgeWeighted(1, 2, 5);
        weighted.addEdgeWeighted(0, 3, 15);
        weighted.addEdgeWeighted(2, 3, 8);
        
        weighted.displayMatrix();
        weighted.analyzeEdges();
        
        // COMPARISON
        System.out.println("\n\n===== MATRIX vs LIST COMPARISON =====");
        System.out.println("Graph with 5 vertices and 5 edges:");
        System.out.println("  Adjacency Matrix:");
        System.out.println("    - Memory: 5×5 = 25 cells (fixed)");
        System.out.println("    - Edge lookup: O(1) - direct access matrix[u][v]");
        System.out.println("    - Best for: Dense graphs (many edges)");
        System.out.println("  Adjacency List:");
        System.out.println("    - Memory: 5 nodes + 10 pointers (for undirected) ≈ 15 cells");
        System.out.println("    - Edge lookup: O(degree) - search the list");
        System.out.println("    - Best for: Sparse graphs (few edges)");
    }
}
