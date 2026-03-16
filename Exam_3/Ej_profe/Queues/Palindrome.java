package Exam_3.Ej_profe.Queues;

import java.util.*;
public class Palindrome {

    public boolean isPalindrome(String s) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        String word = s.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            queue.offer(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arg){
        Palindrome P = new Palindrome();
        String word = "reconocer";

        System.out.println(P.isPalindrome(word));
    }
}
