package Exam_3.Queue_and_Stacks_and_sets;

import java.util.*;

public class SetPracticeFromPDF {

    /*
     * =====================================================
     * EXERCISE 1
     * Basic Set Operations
     * =====================================================
     * 
     * Goal:
     * Practice add, remove, contains, size, isEmpty, clear
     * 
     * Instructions:
     * 1. Create a Set<String> called fruits
     * 2. Add: Apple, Banana, Orange, Apple
     * 3. Print the set
     * 4. Print whether it contains "Apple"
     * 5. Remove "Banana"
     * 6. Print the set again
     * 7. Print the size
     * 8. Clear the set
     * 9. Print whether it is empty
     * 
     * Expected concept:
     * Duplicate values should not be stored.
     */

    public static void basicSetOperations() {

        // create the set here
        Set<String> fruits = new HashSet<>(); 

        // add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");

        // print set
        for (String string : fruits) {
            System.out.println(string); //prints each one in there line
        }

        // check contains("Apple")
        fruits.contains("Apple");

        // remove Banana
        fruits.remove("Banana");

        // print updated set
        System.out.println(fruits); // prints like [Apple, Banana, Orange]

        // print size
        System.out.println(fruits.size());

        // clear set
        fruits.clear();

        // print isEmpty()
        System.out.println("itsEmpty()");

    }

    /*
     * =====================================================
     * EXERCISE 2
     * Union of Two Sets
     * =====================================================
     * 
     * Similar to the PDF example:
     * set1 = {1, 2, 3, 4}
     * set2 = {3, 4, 5, 6}
     * 
     * Goal:
     * Return a new set containing all unique elements.
     * 
     * Hint:
     * Make a copy of set1, then use addAll(set2)
     */

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {

        // create a new set that starts as a copy of set1
        Set<Integer> copySet1 = new HashSet<>(set1);

        // add all elements from set2
        copySet1.addAll(set2);

        // return the union set

        return copySet1;
    }

    /*
     * =====================================================
     * EXERCISE 3
     * Intersection of Two Sets
     * =====================================================
     * 
     * Goal:
     * Return a new set containing only elements
     * that both sets have in common.
     * 
     * Hint:
     * Make a copy of one set, then use retainAll(otherSet)
     */

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {

        // create a copy of set1
        Set<Integer> copySet1 = new HashSet<>(set1);

        // keep only the elements also in set2
        copySet1.retainAll(set2);

        // return the result

        return copySet1;
    }

    /*
     * =====================================================
     * EXERCISE 4
     * Difference of Two Sets
     * =====================================================
     * 
     * Goal:
     * Return a new set with the elements in set1
     * that are NOT in set2.
     * 
     * Hint:
     * Make a copy of set1, then use removeAll(set2)
     */

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {

        // create a copy of set1
        Set<Integer> copySet1 = new HashSet<>(set1);

        // remove all elements found in set2
        copySet1.removeAll(set2);

        // return result
        return copySet1;
    }

    /*
     * =====================================================
     * EXERCISE 5
     * Subset Check
     * =====================================================
     * 
     * Goal:
     * Return true if set1 is a subset of set2
     * 
     * Example:
     * set1 = {Apu, Ned}
     * set2 = {Apu, Bob, Ben, Ned, Al}
     * 
     * Output:
     * true
     * 
     * Hint:
     * Java uses containsAll()
     */

    public static boolean isSubset(Set<String> set1, Set<String> set2) {

        // return whether set2 contains all elements of set1

        return set2.containsAll(set1);
    }

    /*
     * =====================================================
     * EXERCISE 6
     * Are Disjointed
     * =====================================================
     * 
     * This is very similar to the non-member method
     * shown in the PDF.
     * 
     * Goal:
     * Return true if the two sets have no elements in common.
     * 
     * Example:
     * S1 = {1,2,3}
     * S2 = {9,4,5}
     * Output: true
     * 
     * Hint:
     * Use Collections.disjoint(set1, set2)
     */

    public static <E> boolean areDisjointed(Set<E> set1, Set<E> set2) {

        // return true if the sets have no common elements

        return Collections.disjoint(set1,set2);
    }

    /*
     * =====================================================
     * EXERCISE 7
     * Unique Characters in a String
     * =====================================================
     * 
     * This is directly inspired by the PDF topic
     * "Caracteres únicos en un String".
     * 
     * Goal:
     * Return a Set<Character> containing the unique
     * characters of the string.
     * 
     * Example:
     * "banana" -> [b, a, n]
     */

    public static Set<Character> uniqueCharacters(String s) {

        // create a set of characters
        Set<Character> letras = new HashSet<>();

        // loop through the string
        for(int i = 0; i < s.length(); i++){
            letras.add(s.charAt(i));
        }

        // return the set

        return letras;
    }

    /*
     * =====================================================
     * EXERCISE 8
     * Count Unique Characters
     * =====================================================
     * 
     * Goal:
     * Return how many different characters appear in the string.
     * 
     * Example:
     * "mississippi" -> 4
     * because the unique letters are: m, i, s, p
     */

    public static int countUniqueCharacters(String s) {

        // you may reuse a Set<Character>
        Set<Character> letras = new HashSet<>();

        // add all characters
        for (int i = 0; i < s.length(); i++) {
            letras.add(s.charAt(i));
        }
        // return set size

        return letras.size();
    }

    /*
     * =====================================================
     * EXERCISE 9
     * Employees Not Sick
     * =====================================================
     * 
     * From the PDF practice idea:
     * employees = {Ann, Apu, Ned, Ben, Bob, Jil, Dan}
     * sickEmployees = {Ben, Apu}
     * 
     * Goal:
     * Return a set of employees who are NOT sick.
     * 
     * Hint:
     * Use difference logic:
     * employees - sickEmployees
     */

    public static Set<String> employeesNotSick(Set<String> employees, Set<String> sickEmployees) {

        // create a copy of employees
        Set<String> emp = new HashSet<>(employees);

        // remove all sick employees
        emp.removeAll(sickEmployees);

        // return result
        return emp;
    }

    /*
     * =====================================================
     * EXERCISE 10
     * Employees Currently Working
     * =====================================================
     * 
     * From the PDF practice idea:
     * employees = {Ann, Apu, Ned, Ben, Bob, Jil, Dan}
     * sickEmployees = {Ben, Apu}
     * employeesOnVacation = {Ann, Ned}
     * 
     * Goal:
     * Return the employees who are currently working,
     * meaning they are NOT sick and NOT on vacation.
     * 
     * Hint:
     * You can think of this as:
     * employees - sickEmployees - employeesOnVacation
     */

    public static Set<String> employeesWorking(Set<String> employees,
            Set<String> sickEmployees,
            Set<String> employeesOnVacation) {

        // create a copy of employees
        Set<String> emp = new HashSet<>(employees);

        // remove sick employees
        emp.removeAll(sickEmployees);

        // remove employees on vacation
        emp.removeAll(employeesOnVacation);

        // return result

        return emp;
    }

    /*
     * =====================================================
     * EXERCISE 11
     * Add Without Duplicates Check
     * =====================================================
     * 
     * Goal:
     * Return how many values were ACTUALLY added to the set.
     * 
     * Example:
     * arr = {5, 6, 5, 7, 6, 8}
     * Output:
     * 4
     * 
     * Hint:
     * set.add(x) returns true only if x was really added
     */

    public static int countActuallyAdded(int[] arr) {

        // create a Set<Integer>
        Set<Integer> numbers = new HashSet<>();

        // count how many times add(...) returns true
        int count = 0;
        for (Integer num : arr) {
            if (numbers.add(num)) {
                count++;
            }
        }
        // return that count

        return count;
    }

    /*
     * =====================================================
     * EXERCISE 12
     * Same Unique Elements
     * =====================================================
     * 
     * Goal:
     * Return true if two arrays contain the same unique elements,
     * even if repeated a different number of times.
     * 
     * Example:
     * arr1 = {1,2,2,3}
     * arr2 = {3,1,1,2}
     * Output: true
     * 
     * Hint:
     * Convert both arrays into sets, then compare the sets
     */

    public static boolean sameUniqueElements(int[] arr1, int[] arr2) {

        // create two sets
        Set<Integer> numbers1 = new HashSet<>();
        Set<Integer> numbers2 = new HashSet<>();

        // add elements from arr1 to first set
        for (Integer integer : arr1) {
            numbers1.add(integer);
        }

        // add elements from arr2 to second set
        for (Integer integer : arr2) {
            numbers2.add(integer);
        }

        // compare both sets

        return numbers1.equals(numbers2);
    }

    /*
     * =====================================================
     * MAIN METHOD
     * =====================================================
     * 
     * Use this area to test your exercises.
     */

    public static void main(String[] args) {

        System.out.println("=== Set Practice From PDF ===");

        // EXERCISE 1
        // basicSetOperations();

        // EXERCISE 2, 3, 4
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        System.out.println("Union:");
        System.out.println(union(set1, set2));

        System.out.println("Intersection:");
        System.out.println(intersection(set1, set2));

        System.out.println("Difference set1 - set2:");
        System.out.println(difference(set1, set2));

        // EXERCISE 5
        Set<String> a = new HashSet<>(Arrays.asList("Apu", "Ned"));
        Set<String> b = new HashSet<>(Arrays.asList("Apu", "Bob", "Ben", "Ned", "Al"));
        System.out.println("Is subset?");
        System.out.println(isSubset(a, b));

        // EXERCISE 6
        Set<Integer> d1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> d2 = new HashSet<>(Arrays.asList(9, 4, 5));
        System.out.println("Are disjointed?");
        System.out.println(areDisjointed(d1, d2));

        // EXERCISE 7 and 8
        System.out.println("Unique characters:");
        System.out.println(uniqueCharacters("banana"));

        System.out.println("Count unique characters:");
        System.out.println(countUniqueCharacters("mississippi"));

        // EXERCISE 9 and 10
        Set<String> employees = new HashSet<>(Arrays.asList("Ann", "Apu", "Ned", "Ben", "Bob", "Jil", "Dan"));
        Set<String> sickEmployees = new HashSet<>(Arrays.asList("Ben", "Apu"));
        Set<String> employeesOnVacation = new HashSet<>(Arrays.asList("Ann", "Ned"));

        System.out.println("Employees not sick:");
        System.out.println(employeesNotSick(employees, sickEmployees));

        System.out.println("Employees working:");
        System.out.println(employeesWorking(employees, sickEmployees, employeesOnVacation));

        // EXERCISE 11
        int[] nums = { 5, 6, 5, 7, 6, 8 };
        System.out.println("Actually added count:");
        System.out.println(countActuallyAdded(nums));

        // EXERCISE 12
        int[] arr1 = { 1, 2, 2, 3 };
        int[] arr2 = { 3, 1, 1, 2 };
        System.out.println("Same unique elements?");
        System.out.println(sameUniqueElements(arr1, arr2));
    }
}
