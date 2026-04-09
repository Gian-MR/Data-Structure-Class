package Exam_4.Ej_prac.HashSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class syntax {

	/*
	 * =====================================================
	 * HASHSET QUICK SYNTAX + METHODS (JAVA)
	 * =====================================================
	 *
	 * What HashSet is:
	 * - Stores unique elements only.
	 * - Does not guarantee order.
	 * - Allows one null element.
	 * - Fast for contains, add, and remove in average case.
	 *
	 * =====================================================
	 * 1) IMPORTS + DECLARATION
	 * =====================================================
	 * import java.util.HashSet;
	 * import java.util.Set;
	 *
	 * HashSet<String> names = new HashSet<>();
	 * Set<String> names = new HashSet<>();   // preferred variable type
	 *
	 * With initial values:
	 * Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3));
	 * Set<Integer> numbers = new HashSet<>(java.util.List.of(1, 2, 3));
	 *
	 * Constructors:
	 * new HashSet<>()
	 * new HashSet<>(Collection<? extends E> c)
	 * new HashSet<>(int initialCapacity)
	 * new HashSet<>(int initialCapacity, float loadFactor)
	 *
	 * =====================================================
	 * 2) BASIC OPERATIONS
	 * =====================================================
	 * set.add(value);            // adds a value, returns true if it was new
	 * set.remove(value);         // removes a value, returns true if removed
	 * set.contains(value);       // true if value exists
	 * set.size();                // number of elements
	 * set.isEmpty();             // true if no elements
	 * set.clear();               // removes everything
	 *
	 * Example:
	 * Set<String> fruits = new HashSet<>();
	 * fruits.add("Apple");
	 * fruits.add("Banana");
	 * fruits.add("Apple");    // duplicate ignored
	 * System.out.println(fruits);
	 *
	 * =====================================================
	 * 3) BULK OPERATIONS
	 * =====================================================
	 * set.addAll(otherSet);      // union-style add
	 * set.removeAll(otherSet);   // remove every element found in otherSet
	 * set.retainAll(otherSet);   // keep only elements also in otherSet
	 * set.containsAll(otherSet); // true if all elements of otherSet are present
	 *
	 * Example:
	 * Set<Integer> a = new HashSet<>(Set.of(1, 2, 3));
	 * Set<Integer> b = new HashSet<>(Set.of(3, 4, 5));
	 *
	 * a.addAll(b);      // {1,2,3,4,5}
	 * a.removeAll(b);   // remove 3,4,5 from a
	 * a.retainAll(b);   // keep only values in b
	 *
	 * =====================================================
	 * 4) ITERATION
	 * =====================================================
	 * for (String item : set) {
	 *     System.out.println(item);
	 * }
	 *
	 * Iterator<String> it = set.iterator();
	 * while (it.hasNext()) {
	 *     String item = it.next();
	 *     System.out.println(item);
	 * }
	 *
	 * set.forEach(System.out::println);
	 *
	 * =====================================================
	 * 5) CONVERSION / COPYING
	 * =====================================================
	 * Object[] array = set.toArray();
	 * String[] arr = set.toArray(new String[0]);
	 * Set<String> copy = new HashSet<>(set);
	 *
	 * =====================================================
	 * 6) USEFUL SET OPERATIONS
	 * =====================================================
	 * Union:
	 * Set<Integer> union = new HashSet<>(set1);
	 * union.addAll(set2);
	 *
	 * Intersection:
	 * Set<Integer> intersection = new HashSet<>(set1);
	 * intersection.retainAll(set2);
	 *
	 * Difference:
	 * Set<Integer> difference = new HashSet<>(set1);
	 * difference.removeAll(set2);
	 *
	 * Subset check:
	 * boolean subset = set2.containsAll(set1);
	 *
	 * Disjoint check:
	 * boolean disjoint = Collections.disjoint(set1, set2);
	 *
	 * =====================================================
	 * 7) COMMON RETURN VALUES
	 * =====================================================
	 * add(E e) -> true if the set changed
	 * remove(Object o) -> true if the element was removed
	 * contains(Object o) -> true if the element exists
	 *
	 * =====================================================
	 * 8) IMPORTANT NOTES
	 * =====================================================
	 * - No duplicates.
	 * - No index-based access like arrays or ArrayList.
	 * - Order is not guaranteed.
	 * - If you need sorted unique values, use TreeSet.
	 * - If you need insertion order, use LinkedHashSet.
	 *
	 * =====================================================
	 * 9) MINI EXAMPLE
	 * =====================================================
	 * Set<String> names = new HashSet<>();
	 * names.add("Ana");
	 * names.add("Luis");
	 * names.add("Ana");
	 *
	 * System.out.println(names.contains("Ana"));
	 * System.out.println(names.size());
	 * names.remove("Luis");
	 *
	 * for (String name : names) {
	 *     System.out.println(name);
	 * }
	 *
	 * =====================================================
	 * 10) EXTRA NOTES ABOUT HASHSET
	 * =====================================================
	 * - HashSet is backed by a HashMap internally.
	 * - Most operations are average O(1).
	 * - Use proper equals() and hashCode() in custom objects.
	 */
	public static void main(String[] args) {
		// This file is a study reference.
		// Add practice code here if you want to test HashSet behavior.
	}
}
