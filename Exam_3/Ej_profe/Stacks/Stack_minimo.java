package Exam_3.Ej_profe.Stacks;

import java.util.*;

public class Stack_minimo {
    Stack<Integer> stack = new Stack<>();

    void fill() {
        stack.addAll(List.of(3, 2, 3, 4, 9, 6, 7, 8));
    }

    void push(Integer n){
        stack.add(n);
    }

    void pop(){
        stack.pop();
    }

    void getMin() {
        if (stack.isEmpty()) {
            System.out.println("Stack vacio");
            return;
        }
        System.out.println(Collections.min(stack));
    }

    public static void main(String[] args) {
        Stack_minimo S = new Stack_minimo();
        S.fill();
        S.push(1);
        S.pop();
        S.getMin();
    }
}
