package Examen_Final.Ejemplos;

import java.util.*;

/**
 * Comprehensive guide to Comparable vs Comparator in Java
 * 
 * COMPARABLE:
 * - Interface with single method: compareTo()
 * - Defines NATURAL ordering for a class
 * - Implemented by the class being compared
 * - Object compares itself to another object
 * - Only one natural ordering per class
 * 
 * COMPARATOR:
 * - Functional interface with method: compare()
 * - Defines CUSTOM ordering
 * - Separate from the class being compared
 * - Can have multiple different orderings
 * - More flexible for different sorting strategies
 */

// ==================== COMPARABLE EXAMPLE ====================
/**
 * Student class implementing Comparable
 * Natural ordering: by GPA (highest first)
 */
class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int id;

    public Student(String name, double gpa, int id) {
        this.name = name;
        this.gpa = gpa;
        this.id = id;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getId() { return id; }

    /**
     * compareTo returns:
     * - negative if this < other
     * - zero if this == other
     * - positive if this > other
     */
    @Override
    public int compareTo(Student other) {
        // Natural ordering: by GPA (descending)
        return Double.compare(other.gpa, this.gpa);
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %d, GPA: %.2f)", name, id, gpa);
    }
}

// ==================== COMPARATOR EXAMPLES ====================
/**
 * Different Comparators for Student - custom orderings
 */
class StudentComparators {
    
    // Sort by name (ascending, alphabetically)
    public static class ByName implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }

    // Sort by ID (ascending)
    public static class ById implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getId(), s2.getId());
        }
    }

    // Sort by GPA (ascending)
    public static class ByGpaAscending implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s1.getGpa(), s2.getGpa());
        }
    }

    // Sort by name length
    public static class ByNameLength implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getName().length(), s2.getName().length());
        }
    }
}

// ==================== EXAMPLE WITH INTEGERS ====================
/**
 * Person class for additional examples
 */
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    // Natural ordering: by age
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

// ==================== MAIN DEMO ====================
public class ComparableVsComparator {

    public static void main(String[] args) {
        System.out.println("========== COMPARABLE VS COMPARATOR ==========\n");

        // Sample data
        List<Student> students = Arrays.asList(
            new Student("Alice", 3.8, 101),
            new Student("Bob", 3.5, 105),
            new Student("Charlie", 3.9, 103),
            new Student("Diana", 3.6, 102),
            new Student("Eve", 3.7, 104)
        );

        System.out.println("Original list:");
        students.forEach(System.out::println);

        // ============ COMPARABLE (Natural Ordering) ============
        System.out.println("\n--- COMPARABLE: Natural Ordering (by GPA, descending) ---");
        List<Student> sortedByComparable = new ArrayList<>(students);
        Collections.sort(sortedByComparable);  // Uses compareTo()
        sortedByComparable.forEach(System.out::println);

        // ============ COMPARATOR: By Name ============
        System.out.println("\n--- COMPARATOR: By Name (ascending) ---");
        List<Student> sortedByName = new ArrayList<>(students);
        sortedByName.sort(new StudentComparators.ByName());
        sortedByName.forEach(System.out::println);

        // ============ COMPARATOR: By ID ============
        System.out.println("\n--- COMPARATOR: By ID (ascending) ---");
        List<Student> sortedById = new ArrayList<>(students);
        sortedById.sort(new StudentComparators.ById());
        sortedById.forEach(System.out::println);

        // ============ COMPARATOR: By GPA Ascending ============
        System.out.println("\n--- COMPARATOR: By GPA (ascending) ---");
        List<Student> sortedByGpaAsc = new ArrayList<>(students);
        sortedByGpaAsc.sort(new StudentComparators.ByGpaAscending());
        sortedByGpaAsc.forEach(System.out::println);

        // ============ COMPARATOR: By Name Length ============
        System.out.println("\n--- COMPARATOR: By Name Length ---");
        List<Student> sortedByNameLength = new ArrayList<>(students);
        sortedByNameLength.sort(new StudentComparators.ByNameLength());
        sortedByNameLength.forEach(System.out::println);

        // ============ LAMBDA EXPRESSIONS ============
        System.out.println("\n--- COMPARATOR: Using Lambda (by name, reverse) ---");
        List<Student> sortedByNameReverse = new ArrayList<>(students);
        sortedByNameReverse.sort((s1, s2) -> s2.getName().compareTo(s1.getName()));
        sortedByNameReverse.forEach(System.out::println);

        // ============ PERSON EXAMPLES ============
        System.out.println("\n\n========== PERSON EXAMPLES ==========\n");

        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("Diana", 28)
        );

        System.out.println("Original:");
        people.forEach(System.out::println);

        // Natural ordering by age (Comparable)
        System.out.println("\n--- COMPARABLE: By Age (ascending) ---");
        List<Person> sortedPeople = new ArrayList<>(people);
        Collections.sort(sortedPeople);
        sortedPeople.forEach(System.out::println);

        // Custom ordering by name (Comparator with lambda)
        System.out.println("\n--- COMPARATOR: By Name (ascending) ---");
        people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        people.forEach(System.out::println);

        // ============ TREESETS & TREESETS ============
        System.out.println("\n\n========== TREESET EXAMPLES ==========\n");

        // TreeSet with Comparable (natural ordering)
        System.out.println("--- TreeSet<Student> (uses compareTo - by GPA) ---");
        Set<Student> treeSet1 = new TreeSet<>(students);
        treeSet1.forEach(System.out::println);

        // TreeSet with custom Comparator
        System.out.println("\n--- TreeSet<Student> with ByName Comparator ---");
        Set<Student> treeSet2 = new TreeSet<>(new StudentComparators.ByName());
        treeSet2.addAll(students);
        treeSet2.forEach(System.out::println);

        // ============ KEY DIFFERENCES SUMMARY ============
        System.out.println("\n\n========== KEY DIFFERENCES ==========\n");
        System.out.println("COMPARABLE:");
        System.out.println("  - Implemented BY the class being compared");
        System.out.println("  - Method: compareTo(Object other)");
        System.out.println("  - Defines NATURAL ordering");
        System.out.println("  - Only ONE natural order per class");
        System.out.println("  - Collections.sort() uses Comparable if available\n");

        System.out.println("COMPARATOR:");
        System.out.println("  - Created SEPARATELY from the class");
        System.out.println("  - Method: compare(T o1, T o2)");
        System.out.println("  - Defines CUSTOM orderings");
        System.out.println("  - MULTIPLE different orderings possible");
        System.out.println("  - Passed as argument to sort methods");
        System.out.println("  - Can use lambda expressions");
    }
}
