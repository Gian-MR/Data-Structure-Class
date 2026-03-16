package Exam_3.Ej_profe.Stacks;

import java.util.*;

public class Parentesis_balanceados {


    boolean check_parentesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Parentesis_balanceados p = new Parentesis_balanceados();
        String parentesis = "(){}[],";

        System.out.println(p.check_parentesis(parentesis));
    }
}
