package Exam_3.Queue_and_Stacks_and_sets;


public class PracticeStackQueue {

    /*
     * =========================
     * STACK INTERFACE
     * =========================
     */
    public interface Stack<E> {
        int size();

        boolean isEmpty();

        E top();

        E pop();

        void push(E e);
    }

    /*
     * =========================
     * STACK IMPLEMENTATION
     * =========================
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
     * =========================
     * QUEUE INTERFACE
     * =========================
     */
    public interface Queue<E> {
        int size();

        boolean isEmpty();

        void enqueue(E e);

        E dequeue();

        E front();
    }

    /*
     * =========================
     * QUEUE IMPLEMENTATION
     * =========================
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
     * ====================================
     * EXERCISE 1
     * Reverse a String using a Stack
     * ====================================
     */
    public static String reverseString(String s) {

        Stack<Character> st = new SingleLinkedStack<>();

        // STEP 1
        // push each character of the string into the stack

        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
        }

        // STEP 2
        // create a String result = ""
        String result = "";

        // STEP 3
        // while stack not empty
        // pop characters and append to result
        while(!st.isEmpty()){
            result += st.pop();
        }

        // STEP 4
        // return result
        return result;
    }

    /*
     * ====================================
     * EXERCISE 2
     * Check Balanced Parentheses
     * ====================================
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
        // if empty -> return false
        // otherwise pop()

        // STEP 4
        // after loop
        // if stack empty -> true
        // otherwise false

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ('(')){
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && st.isEmpty()){
                return false;
            }else if (s.charAt(i) == ')'){
                st.pop();
            }
        }
        return st.isEmpty();
    }
    /*
     * ====================================
     * EXERCISE 3
     * Rotate a Queue k times
     * ====================================
     */
    public static void rotateQueue(Queue<Integer> q, int k) {

        // STEP 1
        // repeat k times

        // STEP 2
        // remove front element

        // STEP 3
        // add it back to the queue

        while (k > 0 && !q.isEmpty()){
            q.enqueue(q.dequeue());
            k--;
        }

    }
    /*
     * ====================================
     * EXERCISE 4
     * Palindrome using Stack
     * ====================================
     */
    public static boolean isPalindrome(String s) {

        Stack<Character> st = new SingleLinkedStack<>();

        String word = s.replaceAll("\\s+", "");

        for(int i = 0; i < word.length(); i++){
            st.push(word.charAt(i));
        }

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != st.pop()){
                return false;
            }
        }
        return true;
    }

    /*
     * ====================================
     * MAIN METHOD FOR TESTING
     * ====================================
     */
    public static void main(String[] args) {

        System.out.println("=== TEST AREA ===");

        // Try testing your functions here

        System.out.println(reverseString("hello"));

        System.out.println(isPalindrome("top spot"));

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
