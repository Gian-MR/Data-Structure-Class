package Exam_3.Queue_and_Stacks_and_sets;

public class StackQueuePractice {

    /*
     * =========================================
     * STACK INTERFACE
     * =========================================
     */

    public interface Stack<E> {
        int size();

        boolean isEmpty();

        E top();

        E pop();

        void push(E e);
    }

    /*
     * =========================================
     * STACK IMPLEMENTATION
     * =========================================
     */

    public static class SingleLinkedStack<E> implements Stack<E> {

        private static class Node<E> {
            E element;
            Node<E> next;

            Node(E e, Node<E> n) {
                element = e;
                next = n;
            }
        }

        private Node<E> top;
        private int size;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(E e) {
            top = new Node<>(e, top);
            size++;
        }

        public E pop() {
            if (isEmpty())
                return null;

            E answer = top.element;
            top = top.next;
            size--;
            return answer;
        }

        public E top() {
            if (isEmpty())
                return null;
            return top.element;
        }
    }

    /*
     * =========================================
     * QUEUE INTERFACE
     * =========================================
     */

    public interface Queue<E> {
        int size();

        boolean isEmpty();

        void enqueue(E e);

        E dequeue();

        E front();
    }

    /*
     * =========================================
     * QUEUE IMPLEMENTATION
     * =========================================
     */

    public static class LinkedQueue<E> implements Queue<E> {

        private static class Node<E> {
            E element;
            Node<E> next;

            Node(E e) {
                element = e;
            }
        }

        private Node<E> front;
        private Node<E> rear;
        private int size;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void enqueue(E e) {

            Node<E> newest = new Node<>(e);

            if (isEmpty())
                front = newest;
            else
                rear.next = newest;

            rear = newest;
            size++;
        }

        public E dequeue() {

            if (isEmpty())
                return null;

            E answer = front.element;
            front = front.next;
            size--;

            if (size == 0)
                rear = null;

            return answer;
        }

        public E front() {
            if (isEmpty())
                return null;
            return front.element;
        }
    }

    /*
     * ======================================================
     * EXERCISE 1
     * Reverse a String using a Stack
     * ======================================================
     * 
     * Example:
     * Input: "hello"
     * Output: "olleh"
     */

    public static String reverseString(String s) {

        Stack<Character> st = new SingleLinkedStack<>();

        // STEP 1
        // push each character of the string into the stack

        // STEP 2
        // create a String result = ""

        // STEP 3
        // while stack not empty
        // pop characters and append to result
        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
        }

        String reString = "";

        while(!st.isEmpty()){
            reString += st.pop();
        }

        return reString;
    }

    /*
     * ======================================================
     * EXERCISE 2
     * Balanced Parentheses
     * ======================================================
     * 
     * Examples:
     * 
     * "(())" -> true
     * "(()" -> false
     * "())(" -> false
     */

    public static boolean balancedParentheses(String s) {

        Stack<Character> st = new SingleLinkedStack<>();

        // STEP 1
        // loop through the string

        // STEP 2
        // if '(' push to stack

        // STEP 3
        // if ')'
        // check if stack empty
        // if empty return false
        // otherwise pop

        // STEP 4
        // after loop return st.isEmpty()

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            } else if(s.charAt(i) == ')' && st.isEmpty()){
                return false;   
            } else if(s.charAt(i) == ')'){
                st.pop();
            }
        }

        return st.isEmpty();
    }

    /*
     * ======================================================
     * EXERCISE 3
     * Reverse a Queue using a Stack
     * ======================================================
     * 
     * Example:
     * 
     * Queue: 1 2 3 4
     * Result: 4 3 2 1
     */

    public static void reverseQueue(Queue<Integer> q) {

        Stack<Integer> st = new SingleLinkedStack<>();

        // STEP 1
        // move all elements from queue -> stack

        // STEP 2
        // move all elements from stack -> queue
        while(!q.isEmpty()){
            st.push(q.dequeue());
        }

        while(!st.isEmpty()){
            q.enqueue(st.pop());
        }

    }

    /*
     * ======================================================
     * EXERCISE 4
     * Rotate Queue K times
     * ======================================================
     * 
     * Example:
     * 
     * Queue: 1 2 3 4 5
     * k = 2
     * 
     * Result:
     * 3 4 5 1 2
     */

    public static void rotateQueue(Queue<Integer> q, int k) {

        // STEP 1
        // repeat k times

        // STEP 2
        // remove front element

        // STEP 3
        // add it back to the queue
        while (k > 0) {
            q.enqueue(q.dequeue());
        }

    }

    /*
     * ======================================================
     * EXERCISE 5
     * Count Vowels using a Stack
     * ======================================================
     * 
     * Input:
     * "datastructures"
     * 
     * Output:
     * 5
     */

    public static int countVowels(String s) {

        Stack<Character> st = new SingleLinkedStack<>();

        int count = 0;

        // STEP 1
        // push all characters into stack

        // STEP 2
        // while stack not empty

        // STEP 3
        // pop character
        // if vowel -> count++

        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
        }

        while (!st.isEmpty()) {
            char c = Character.toLowerCase(st.pop());
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }

    /*
     * ======================================================
     * EXERCISE 6
     * Queue Simulation
     * ======================================================
     * 
     * Each number represents how many turns a person needs.
     * 
     * Each turn:
     * - front person reduces value by 1
     * - if still > 0 -> go to back
     * - if 0 -> leave
     * 
     * Return how many people finished.
     */

    public static int peopleFinished(int[] arr) {

        Queue<Integer> q = new LinkedQueue<>();

        int finished = 0;

        // STEP 1
        // enqueue all values

        // STEP 2
        // while queue not empty

        // dequeue front

        // reduce value by 1

        // if value == 0
        // finished++

        // else
        // enqueue again
        for (int i : arr) {
            q.enqueue(i);
        }

        while(!q.isEmpty()){
            int need = q.dequeue();
            need--;
            if (need == 0) {
                finished++;
            } else {
                q.enqueue(need);
            }
        }

        return finished;
    }

    /*
     * ======================================================
     * MAIN METHOD FOR TESTING
     * ======================================================
     */

    public static void main(String[] args) {

        System.out.println("Practice File Running...");

        System.out.println(reverseString("hello"));

        System.out.println(balancedParentheses("(())"));

        Queue<Integer> q = new LinkedQueue<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        rotateQueue(q, 2);

        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " ");
        }

    }

}
