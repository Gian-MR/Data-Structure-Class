package Examen_Final.Ejemplos.Grafos;
import java.util.*;

/**
 * GRAPH TRAVERSAL - BFS vs DFS
 * 
 * BFS (Breadth-First Search):
 * - Explores LEVEL BY LEVEL (like ripples in water)
 * - Uses a QUEUE (FIFO - First In First Out)
 * - Finds shortest path in UNWEIGHTED graphs
 * - Order: Visit all neighbors before going deeper
 * 
 * DFS (Depth-First Search):
 * - Goes DEEP first before exploring siblings
 * - Uses a STACK (LIFO - Last In First Out) or recursion
 * - Useful for topological sorting, cycle detection
 * - Order: Go as deep as possible before backtracking
 */
public class BFSandDFSExample {
    
    private Map<Integer, List<Integer>> adjList;
    private int vertices;
    
    public BFSandDFSExample(int vertices) {
        this.vertices = vertices;
        this.adjList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    
    /**
     * BREADTH-FIRST SEARCH (BFS)
     * Explores nodes level by level
     */
    public List<Integer> bfs(int startVertex) {
        List<Integer> visitOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // Start with the initial vertex
        queue.add(startVertex);
        visited.add(startVertex);
        
        while (!queue.isEmpty()) {
            // Get the first vertex in queue (FIFO)
            int current = queue.poll();
            visitOrder.add(current);
            
            System.out.println("Visiting vertex: " + current);
            
            // Add all unvisited neighbors to the queue
            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    System.out.println("  → Added neighbor " + neighbor + " to queue");
                }
            }
        }
        
        return visitOrder;
    }
    
    /**
     * DEPTH-FIRST SEARCH (DFS) - Iterative using Stack
     * Goes deep before exploring siblings
     */
    public List<Integer> dfsIterative(int startVertex) {
        List<Integer> visitOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        // Start with the initial vertex
        stack.push(startVertex);
        visited.add(startVertex);
        
        while (!stack.isEmpty()) {
            // Get the top vertex from stack (LIFO)
            int current = stack.pop();
            visitOrder.add(current);
            
            System.out.println("Visiting vertex: " + current);
            
            // Add unvisited neighbors to stack
            // Add in reverse order so leftmost is visited first
            List<Integer> neighbors = new ArrayList<>(adjList.get(current));
            Collections.reverse(neighbors);
            
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    System.out.println("  → Pushed neighbor " + neighbor + " to stack");
                }
            }
        }
        
        return visitOrder;
    }
    
    /**
     * DEPTH-FIRST SEARCH (DFS) - Recursive
     * Simpler and more elegant using recursion
     */
    public void dfsRecursive(int vertex, Set<Integer> visited, List<Integer> visitOrder) {
        visited.add(vertex);
        visitOrder.add(vertex);
        System.out.println("Visiting vertex: " + vertex);
        
        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                System.out.println("  → Recursively visiting neighbor " + neighbor);
                dfsRecursive(neighbor, visited, visitOrder);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("===== BFS vs DFS EXAMPLE =====\n");
        
        BFSandDFSExample graph = new BFSandDFSExample(6);
        
        // Create this graph:
        //       0
        //      / \
        //     1   2
        //    / \
        //   3   4
        //        \
        //         5
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        
        // ===== BFS =====
        System.out.println("\n========== BFS TRAVERSAL ==========");
        System.out.println("Starting from vertex 0");
        System.out.println("Expected order: Visit all neighbors of current level before going deeper");
        System.out.println("Expected: 0 → 1, 2 → 3, 4 → 5\n");
        
        List<Integer> bfsOrder = graph.bfs(0);
        System.out.println("\nBFS Visit Order: " + bfsOrder);
        System.out.println("This is LEVEL-BY-LEVEL traversal!");
        
        // ===== DFS Iterative =====
        System.out.println("\n========== DFS TRAVERSAL (Iterative) ==========");
        System.out.println("Starting from vertex 0");
        System.out.println("Expected order: Go as deep as possible before backtracking");
        System.out.println("Expected: 0 → 1 → 3 → 4 → 5 → 2\n");
        
        List<Integer> dfsIterOrder = graph.dfsIterative(0);
        System.out.println("\nDFS (Iterative) Visit Order: " + dfsIterOrder);
        System.out.println("This is DEPTH-FIRST traversal!");
        
        // ===== DFS Recursive =====
        System.out.println("\n========== DFS TRAVERSAL (Recursive) ==========");
        System.out.println("Starting from vertex 0\n");
        
        List<Integer> dfsRecOrder = new ArrayList<>();
        graph.dfsRecursive(0, new HashSet<>(), dfsRecOrder);
        System.out.println("\nDFS (Recursive) Visit Order: " + dfsRecOrder);
        
        // ===== COMPARISON =====
        System.out.println("\n========== COMPARISON ==========");
        System.out.println("BFS Order:        " + bfsOrder);
        System.out.println("DFS Order:        " + dfsIterOrder);
        System.out.println("\nBFS uses QUEUE (FIFO) - explores LEVEL by LEVEL");
        System.out.println("DFS uses STACK (LIFO) - explores DEEP first");

        //!Ignore this code 
        try {
            System.out.println(graph.vertices);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
