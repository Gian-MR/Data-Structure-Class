package Examen_Final.Ejemplos.Grafos;
/**
 * ╔════════════════════════════════════════════════════════════════════╗
 * ║                  COMPREHENSIVE GRAPHS GUIDE                        ║
 * ║                 Understanding the PDF Examples                     ║
 * ╚════════════════════════════════════════════════════════════════════╝
 */

// ============================================================================
// 1. GRAPH BASICS
// ============================================================================
/*
   A GRAPH consists of:
   
   Vertices (Nodes): Data points in the graph
   Edges: Connections between vertices
   
   TYPES OF GRAPHS:
   
   a) UNDIRECTED vs DIRECTED
      Undirected:  0 --- 1      Both directions work
                   (bidirectional edge)
      
      Directed:    0 ---> 1     Only one direction
                   (unidirectional edge)
   
   b) WEIGHTED vs UNWEIGHTED
      Unweighted:  0 --- 1      Edge has no weight/cost
      
      Weighted:    0 --10--> 1  Edge has weight/cost
   
   c) CONNECTED vs DISCONNECTED
      Connected: All vertices can be reached from any other
      Disconnected: Some vertices isolated from others
*/


// ============================================================================
// 2. GRAPH REPRESENTATIONS
// ============================================================================
/*
   HOW TO STORE A GRAPH IN MEMORY?
   
   A) ADJACENCY LIST (Preferred for sparse graphs)
      Structure: Map/Array of Lists
      
      Graph:     0 --- 1 --- 2
                 |     |
                 3     4
      
      Adjacency List:
      0: [1, 3]
      1: [0, 2, 4]
      2: [1]
      3: [0]
      4: [1]
      
      Memory: O(V + E) - only stores existing edges
      Edge lookup: O(degree) - need to search the list
      Best for: Sparse graphs (few edges)
      Example: Social networks, web graphs
   
   
   B) ADJACENCY MATRIX (Preferred for dense graphs)
      Structure: 2D Array [V][V]
      
      Graph:     0 --- 1 --- 2
                 |     |
                 3     4
      
      Adjacency Matrix:
         0  1  2  3  4
      0 [0  1  0  1  0]
      1 [1  0  1  0  1]
      2 [0  1  0  0  0]
      3 [1  0  0  0  0]
      4 [0  1  0  0  0]
      
      Memory: O(V²) - always takes quadratic space
      Edge lookup: O(1) - direct access matrix[u][v]
      Best for: Dense graphs (many edges)
      Example: Complete graphs, flight routes
*/


// ============================================================================
// 3. GRAPH TRAVERSAL ALGORITHMS
// ============================================================================
/*
   BREADTH-FIRST SEARCH (BFS)
   ═══════════════════════════
   Explores LEVEL BY LEVEL (like ripples in water)
   
   Uses: QUEUE (FIFO - First In First Out)
   
   Example:
      Graph:          0
                     / \
                    1   2
                   / \
                  3   4
                       \
                        5
      
      Starting from 0:
      Level 0: Visit 0
      Level 1: Visit 1, 2  (neighbors of 0)
      Level 2: Visit 3, 4  (neighbors of 1)
      Level 3: Visit 5     (neighbor of 4)
      
      Order: 0 → 1, 2 → 3, 4 → 5
   
   Use Cases:
   - Shortest path in unweighted graphs
   - Social network distance (degrees of separation)
   - Level-order traversal in trees
   
   
   DEPTH-FIRST SEARCH (DFS)
   ════════════════════════
   Goes DEEP first before exploring siblings
   
   Uses: STACK (LIFO - Last In First Out) or Recursion
   
   Example:
      Graph:          0
                     / \
                    1   2
                   / \
                  3   4
                       \
                        5
      
      Starting from 0:
      Go to 1 → Go to 3 (dead end) → Back to 1
      Go to 4 → Go to 5 (dead end) → Back to 4
      Back to 0 → Go to 2 (no children)
      
      Order: 0 → 1 → 3 → 4 → 5 → 2
   
   Use Cases:
   - Topological sorting
   - Cycle detection
   - Maze solving
   - Connected components
*/


// ============================================================================
// 4. SHORTEST PATH ALGORITHMS (WEIGHTED GRAPHS)
// ============================================================================
/*
   DIJKSTRA'S ALGORITHM
   ════════════════════
   Problem: Find shortest path from source to ALL other nodes
   
   Constraints:
   - Only works with POSITIVE weights
   - Cannot handle negative edge weights
   
   Strategy: GREEDY - Always pick closest unvisited node
   
   Example:
      Graph:      0 --10--> 1 --12--> 2
                  |         |          |
                  | 5       | 2        | 8
                  v         v          v
                  3 <-3---- 4 --4----> 5
      
      From source 0:
      
      Step 1: Start at 0 (distance 0)
              Options: 1 (dist 10), 3 (dist 5)
              Pick 3 (closest)
      
      Step 2: From 3, check neighbors
              Options: 4 (dist 5+3=8)
              Pick 4
      
      Step 3: From 4, check neighbors
              Options: 1 (dist 8+2=10), 2 (dist 8+4=12), 5 (dist 8+4=12)
              Pick 1 (tie with 10)
      
      Step 4: From 1, check neighbors
              Options: 2 (dist 10+12=22)
              Pick 2 (but 2+4=6 is closer from 4)
      
      Final distances: 0→0, 0→1:10, 0→2:12, 0→3:5, 0→4:8, 0→5:12
   
   Time Complexity: O(E log V) with priority queue
   
   Use Cases:
   - GPS navigation (Google Maps)
   - Network routing protocols
   - Game AI pathfinding
*/


// ============================================================================
// 5. MINIMUM SPANNING TREE (WEIGHTED GRAPHS)
// ============================================================================
/*
   PRIM'S ALGORITHM
   ════════════════
   Problem: Find a TREE connecting all vertices with minimum total weight
   
   A spanning tree:
   - Connects all V vertices
   - Has exactly V-1 edges
   - Has no cycles
   
   Strategy: GREEDY - Always pick minimum weight edge from tree to outside
   
   Example:
      Graph:      0 --10-- 1 --12-- 2
                  |        |        |
                  | 5      | 2      | 8
                  |        |        |
                  3 ---3-- 4 ---4-- 5
      
      Starting from 0:
      
      Step 1: Add vertex 0 to tree
      Step 2: Min edge from tree: 0-3 (weight 5)
              Add 3 to tree
      Step 3: Min edge from tree to outside:
              0-1 (10), 3-4 (3) ← pick this
              Add 4 to tree
      Step 4: Min edge from tree to outside:
              0-1 (10), 1-4 (2) ← pick this
              Add 1 to tree
      Step 5: Min edge from tree to outside:
              1-2 (12), 4-2 (4) ← pick this
              Add 2 to tree
      Step 6: Min edge from tree to outside:
              2-5 (8) ← pick this
              Add 5 to tree
      
      MST edges: 0-3 (5) + 3-4 (3) + 1-4 (2) + 4-2 (4) + 2-5 (8)
      Total weight: 22
   
   Time Complexity: O(E log V) with priority queue
   
   Use Cases:
   - Road/railway network design (minimize total length)
   - Power distribution systems
   - Computer network design
   - Clustering algorithms
   
   
   DIFFERENCE: DIJKSTRA vs PRIM
   ════════════════════════════
   Dijkstra:
   - Finds shortest PATHS from source to all nodes
   - Result is V paths (not a single tree)
   - Works with directed graphs
   - Cannot handle negative weights
   
   Prim:
   - Finds minimum SPANNING TREE
   - Result is ONE tree with V-1 edges connecting all nodes
   - Works only with undirected graphs
   - Can handle negative weights
*/


// ============================================================================
// 6. ALGORITHM COMPLEXITY COMPARISON
// ============================================================================
/*
   ┌─────────────────┬──────────────────────────────────────┐
   │   Algorithm     │    Time Complexity                   │
   ├─────────────────┼──────────────────────────────────────┤
   │ BFS             │ O(V + E)  - visit each vertex/edge   │
   │ DFS             │ O(V + E)  - visit each vertex/edge   │
   │ Dijkstra        │ O(E log V) - with priority queue     │
   │ Prim            │ O(E log V) - with priority queue     │
   │ Kruskal         │ O(E log E) - sort edges              │
   └─────────────────┴──────────────────────────────────────┘
   
   Space Complexity:
   ┌─────────────────────────────┬─────────────┐
   │    Representation           │  Memory     │
   ├─────────────────────────────┼─────────────┤
   │ Adjacency List              │ O(V + E)    │
   │ Adjacency Matrix            │ O(V²)       │
   │ BFS/DFS visited set         │ O(V)        │
   │ Dijkstra distance array     │ O(V)        │
   └─────────────────────────────┴─────────────┘
*/


// ============================================================================
// 7. PRACTICAL EXAMPLES IN YOUR WORKSPACE
// ============================================================================
/*
   Files created:
   
   1. GraphExample.java
      - Basic graph creation with adjacency list
      - Undirected and directed graphs
      - Simple edge addition
   
   2. BFSandDFSExample.java
      - BFS traversal (level-by-level)
      - DFS traversal (iterative and recursive)
      - Comparison of both algorithms
      - Visual output showing order of traversal
   
   3. DijkstraAlgorithm.java
      - Finding shortest paths from source to all nodes
      - Using priority queue (min-heap)
      - Reconstruction of actual paths
      - Step-by-step output
   
   4. AdjacencyMatrixExample.java
      - Matrix vs List comparison
      - Weighted and unweighted examples
      - Space usage analysis
      - When to use each representation
   
   5. PrimsAlgorithm.java
      - Finding minimum spanning tree
      - Greedy edge selection
      - Total cost calculation
      - Comparison with Dijkstra
*/


// ============================================================================
// 8. HOW TO RUN EXAMPLES
// ============================================================================
/*
   From terminal:
   
   $ javac GraphExample.java
   $ java GraphExample
   
   $ javac BFSandDFSExample.java
   $ java BFSandDFSExample
   
   $ javac DijkstraAlgorithm.java
   $ java DijkstraAlgorithm
   
   $ javac AdjacencyMatrixExample.java
   $ java AdjacencyMatrixExample
   
   $ javac PrimsAlgorithm.java
   $ java PrimsAlgorithm
*/


// ============================================================================
// 9. QUICK REFERENCE: WHEN TO USE WHAT
// ============================================================================
/*
   Need to find something in a graph?
   
   ✓ Shortest path in unweighted graph?     → BFS
   ✓ Visit all nodes (any order)?           → BFS or DFS
   ✓ Shortest path in weighted graph?       → Dijkstra
   ✓ Shortest path with negative edges?     → Bellman-Ford
   ✓ Minimum spanning tree?                 → Prim or Kruskal
   ✓ Detect cycles?                         → DFS or Union-Find
   ✓ Topological sorting?                   → DFS
   ✓ Connected components?                  → DFS or Union-Find
   ✓ Strongly connected components?         → Kosaraju or Tarjan
   
   Need to represent a graph?
   
   ✓ Few edges (sparse)?                    → Adjacency List
   ✓ Many edges (dense)?                    → Adjacency Matrix
   ✓ Need fast edge lookup?                 → Adjacency Matrix
   ✓ Limited memory?                        → Adjacency List
*/


// ============================================================================
// 10. COMMON MISTAKES TO AVOID
// ============================================================================
/*
   ✗ Using Dijkstra with negative weights
   ✗ Forgetting to mark vertices as visited (causes infinite loops)
   ✗ Using adjacency matrix for sparse graphs (wastes memory)
   ✗ Confusing Dijkstra (paths) with Prim (spanning tree)
   ✗ Not initializing visited set/array before traversal
   ✗ Using BFS when you need DFS (or vice versa)
   ✗ Forgetting that MST needs exactly V-1 edges
   ✗ Trying to use Prim on directed graphs
*/

public class GraphsComprehensiveGuide {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║           GRAPHS COMPREHENSIVE GUIDE                          ║");
        System.out.println("║                                                                ║");
        System.out.println("║  Read the JavaDoc comments above for complete explanation     ║");
        System.out.println("║  Run the example files to see algorithms in action:           ║");
        System.out.println("║                                                                ║");
        System.out.println("║  1. java GraphExample                                         ║");
        System.out.println("║  2. java BFSandDFSExample                                     ║");
        System.out.println("║  3. java DijkstraAlgorithm                                    ║");
        System.out.println("║  4. java AdjacencyMatrixExample                               ║");
        System.out.println("║  5. java PrimsAlgorithm                                       ║");
        System.out.println("║                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
}
