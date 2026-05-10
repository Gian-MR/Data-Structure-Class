package Examen_Final.Ejemplos.Grafos;
import java.util.*;

/**
 * REAL-WORLD GRAPH APPLICATIONS
 * 
 * This class demonstrates practical use cases where graphs are essential
 * in actual software systems and applications.
 */
public class RealWorldGraphExamples {
    
    /**
     * EXAMPLE 1: SOCIAL NETWORK
     * 
     * Users are vertices, friendships are edges
     * Problem: Find all friends within 2 degrees
     */
    static class SocialNetwork {
        private Map<String, List<String>> connections;
        
        public SocialNetwork() {
            this.connections = new HashMap<>();
        }
        
        public void addFriendship(String person1, String person2) {
            connections.putIfAbsent(person1, new ArrayList<>());
            connections.putIfAbsent(person2, new ArrayList<>());
            
            connections.get(person1).add(person2);
            connections.get(person2).add(person1);
        }
        
        public Set<String> findFriendsWithinDegrees(String person, int degrees) {
            Set<String> result = new HashSet<>();
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            
            queue.add(person);
            visited.add(person);
            int currentDegree = 0;
            
            while (!queue.isEmpty() && currentDegree < degrees) {
                int levelSize = queue.size();
                currentDegree++;
                
                for (int i = 0; i < levelSize; i++) {
                    String current = queue.poll();
                    
                    for (String friend : connections.getOrDefault(current, new ArrayList<>())) {
                        if (!visited.contains(friend)) {
                            visited.add(friend);
                            result.add(friend);
                            queue.add(friend);
                        }
                    }
                }
            }
            
            return result;
        }
        
        public void demonstrateSocialNetwork() {
            System.out.println("\n===== SOCIAL NETWORK EXAMPLE =====");
            
            // Create network
            addFriendship("Alice", "Bob");
            addFriendship("Alice", "Charlie");
            addFriendship("Bob", "David");
            addFriendship("Charlie", "Eve");
            addFriendship("David", "Frank");
            
            System.out.println("\nNetwork structure:");
            System.out.println("Alice --- Bob --- David --- Frank");
            System.out.println("|          ");
            System.out.println("Charlie --- Eve");
            
            Set<String> friends1 = findFriendsWithinDegrees("Alice", 1);
            System.out.println("\nAlice's direct friends (1 degree): " + friends1);
            
            Set<String> friends2 = findFriendsWithinDegrees("Alice", 2);
            System.out.println("Alice's friends within 2 degrees: " + friends2);
            
            Set<String> friends3 = findFriendsWithinDegrees("Alice", 3);
            System.out.println("Alice's friends within 3 degrees: " + friends3);
        }
    }
    
    /**
     * EXAMPLE 2: GPS NAVIGATION / MAP ROUTING
     * 
     * Cities are vertices, roads are weighted edges
     * Problem: Find shortest route from A to B (minimize distance)
     */
    static class CityNetwork {
        private Map<String, List<CityConnection>> cityGraph;
        
        static class CityConnection {
            String destination;
            int distance;
            
            CityConnection(String destination, int distance) {
                this.destination = destination;
                this.distance = distance;
            }
        }
        
        public CityNetwork() {
            this.cityGraph = new HashMap<>();
        }
        
        public void addRoad(String city1, String city2, int distance) {
            cityGraph.putIfAbsent(city1, new ArrayList<>());
            cityGraph.putIfAbsent(city2, new ArrayList<>());
            
            cityGraph.get(city1).add(new CityConnection(city2, distance));
            cityGraph.get(city2).add(new CityConnection(city1, distance));
        }
        
        public void findShortestRoute(String source, String destination) {
            System.out.println("\n===== GPS NAVIGATION EXAMPLE =====");
            System.out.println("Finding route from " + source + " to " + destination);
            
            Map<String, Integer> distances = new HashMap<>();
            Map<String, String> previousCity = new HashMap<>();
            Set<String> visited = new HashSet<>();
            
            // Initialize
            for (String city : cityGraph.keySet()) {
                distances.put(city, Integer.MAX_VALUE);
            }
            distances.put(source, 0);
            
            PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> 
                distances.get(a) - distances.get(b)
            );
            pq.add(source);
            
            while (!pq.isEmpty()) {
                String current = pq.poll();
                
                if (visited.contains(current)) continue;
                visited.add(current);
                
                for (CityConnection conn : cityGraph.getOrDefault(current, new ArrayList<>())) {
                    int newDist = distances.get(current) + conn.distance;
                    
                    if (newDist < distances.get(conn.destination)) {
                        distances.put(conn.destination, newDist);
                        previousCity.put(conn.destination, current);
                        pq.add(conn.destination);
                    }
                }
            }
            
            // Print route
            System.out.println("Shortest distance: " + distances.get(destination) + " km");
            System.out.print("Route: ");
            
            List<String> path = new ArrayList<>();
            String current = destination;
            while (current != null) {
                path.add(0, current);
                current = previousCity.get(current);
            }
            
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) System.out.print(" → ");
            }
            System.out.println();
        }
        
        public void demonstrateCityNetwork() {
            // Create network
            addRoad("New York", "Boston", 215);
            addRoad("New York", "Philadelphia", 95);
            addRoad("Philadelphia", "Washington DC", 140);
            addRoad("Boston", "Washington DC", 440);
            addRoad("Washington DC", "Atlanta", 630);
            addRoad("Philadelphia", "Atlanta", 1000);
            
            findShortestRoute("New York", "Atlanta");
        }
    }
    
    /**
     * EXAMPLE 3: COMPUTER NETWORKS / ROUTING PROTOCOLS
     * 
     * Computers are vertices, network connections are weighted edges
     * Problem: Minimize total cable needed to connect all computers
     */
    static class ComputerNetworkDesign {
        private List<NetworkEdge> edges;
        private Map<Integer, Integer> parent;
        
        static class NetworkEdge implements Comparable<NetworkEdge> {
            int computer1, computer2, cableCost;
            
            NetworkEdge(int c1, int c2, int cost) {
                this.computer1 = c1;
                this.computer2 = c2;
                this.cableCost = cost;
            }
            
            @Override
            public int compareTo(NetworkEdge other) {
                return this.cableCost - other.cableCost;
            }
        }
        
        public ComputerNetworkDesign(int numComputers) {
            this.edges = new ArrayList<>();
            this.parent = new HashMap<>();
            for (int i = 0; i < numComputers; i++) {
                parent.put(i, i);
            }
        }
        
        public void addConnection(int comp1, int comp2, int cost) {
            edges.add(new NetworkEdge(comp1, comp2, cost));
        }
        
        private int find(int x) {
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }
        
        private boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            
            if (px == py) return false;
            
            parent.put(px, py);
            return true;
        }
        
        public void designMinimumNetworkCost() {
            System.out.println("\n===== COMPUTER NETWORK DESIGN =====");
            
            Collections.sort(edges);
            
            List<NetworkEdge> mstEdges = new ArrayList<>();
            int totalCost = 0;
            
            System.out.println("\nBuilding minimum cost network:");
            for (NetworkEdge edge : edges) {
                if (union(edge.computer1, edge.computer2)) {
                    mstEdges.add(edge);
                    totalCost += edge.cableCost;
                    System.out.println("Connect Computer " + edge.computer1 + " - Computer " + 
                                     edge.computer2 + " (Cost: $" + edge.cableCost + ")");
                    
                    if (mstEdges.size() == parent.size() - 1) break;
                }
            }
            
            System.out.println("\nTotal cable cost: $" + totalCost);
        }
        
        public void demonstrateNetworkDesign() {
            // 4 computers to connect
            addConnection(0, 1, 50);  // Cheap connection
            addConnection(0, 2, 100);
            addConnection(1, 2, 60);
            addConnection(1, 3, 40);  // Cheap connection
            addConnection(2, 3, 80);
            
            designMinimumNetworkCost();
        }
    }
    
    /**
     * EXAMPLE 4: COURSE PREREQUISITES
     * 
     * Courses are vertices, prerequisites are directed edges
     * Problem: Find valid course completion order (topological sort)
     */
    static class UniversityCoursePlan {
        private Map<String, List<String>> prerequisites;
        
        public UniversityCoursePlan() {
            this.prerequisites = new HashMap<>();
        }
        
        public void addCourseRequirement(String course, String prerequisite) {
            prerequisites.putIfAbsent(course, new ArrayList<>());
            prerequisites.get(course).add(prerequisite);
        }
        
        public boolean canCompleteCourses(List<String> allCourses) {
            System.out.println("\n===== COURSE PLANNING =====");
            System.out.println("Checking if course sequence is valid...\n");
            
            Map<String, Integer> inDegree = new HashMap<>();
            Map<String, List<String>> graph = new HashMap<>();
            
            // Initialize
            for (String course : allCourses) {
                inDegree.put(course, 0);
                graph.put(course, new ArrayList<>());
            }
            
            // Build graph
            for (String course : allCourses) {
                for (String prereq : prerequisites.getOrDefault(course, new ArrayList<>())) {
                    graph.get(prereq).add(course);
                    inDegree.put(course, inDegree.get(course) + 1);
                }
            }
            
            // Topological sort
            Queue<String> queue = new LinkedList<>();
            for (String course : allCourses) {
                if (inDegree.get(course) == 0) {
                    queue.add(course);
                }
            }
            
            List<String> courseOrder = new ArrayList<>();
            while (!queue.isEmpty()) {
                String course = queue.poll();
                courseOrder.add(course);
                System.out.println("Take: " + course);
                
                for (String nextCourse : graph.get(course)) {
                    inDegree.put(nextCourse, inDegree.get(nextCourse) - 1);
                    if (inDegree.get(nextCourse) == 0) {
                        queue.add(nextCourse);
                    }
                }
            }
            
            boolean canComplete = courseOrder.size() == allCourses.size();
            System.out.println("\nCan complete all courses: " + canComplete);
            
            return canComplete;
        }
        
        public void demonstrateCoursePlanning() {
            // Prerequisites structure:
            // Calculus requires Algebra
            // Physics requires Algebra and Calculus
            // Chemistry requires Algebra
            
            addCourseRequirement("Calculus", "Algebra");
            addCourseRequirement("Physics", "Algebra");
            addCourseRequirement("Physics", "Calculus");
            addCourseRequirement("Chemistry", "Algebra");
            
            List<String> courses = Arrays.asList("Algebra", "Calculus", "Physics", "Chemistry");
            canCompleteCourses(courses);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║          REAL-WORLD GRAPH APPLICATIONS                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        // Example 1: Social Network
        SocialNetwork social = new SocialNetwork();
        social.demonstrateSocialNetwork();
        
        // Example 2: GPS Navigation
        CityNetwork cities = new CityNetwork();
        cities.demonstrateCityNetwork();
        
        // Example 3: Computer Network Design
        ComputerNetworkDesign network = new ComputerNetworkDesign(4);
        network.demonstrateNetworkDesign();
        
        // Example 4: Course Planning
        UniversityCoursePlan courses = new UniversityCoursePlan();
        courses.demonstrateCoursePlanning();
        
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  These are just a few examples! Graphs are everywhere:        ║");
        System.out.println("║  - Facebook/LinkedIn (social networks)                        ║");
        System.out.println("║  - Google Maps (shortest paths)                               ║");
        System.out.println("║  - Internet routing (network optimization)                    ║");
        System.out.println("║  - Video game AI (pathfinding)                                ║");
        System.out.println("║  - Compiler design (dependency analysis)                      ║");
        System.out.println("║  - Recommendation systems (collaborative filtering)           ║");
        System.out.println("║  - Movie databases (actor connections)                        ║");
        System.out.println("║  - Flight route optimization                                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
}
