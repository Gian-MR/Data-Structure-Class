package Exam_3.Ej_profe.Stacks;

import java.util.*;

public class String_Reversal {
    Stack<Character> word = new Stack<>();

    void reverse (String s){
        for(int i = 0; i < s.length(); i++){
            word.push(s.charAt(i));
        }

        String result = "";

        while (!word.isEmpty()) {
            result += word.pop();
        }

        System.out.println(result);
    }

    public static void main(String [] arg){
        String_Reversal S = new String_Reversal();
        String word = "hello";

        S.reverse(word);
    }
}
