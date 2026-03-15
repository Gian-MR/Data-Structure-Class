package Exam_2.linked;

import java.util.*;

public class IteratorPrac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<String> palabras = new LinkedList<>();

        for(int i = 0; i < 20; i++){
            System.out.println("Palabras por favor:");
            try{
                String input = sc.nextLine();
                palabras.add(input);
            } catch (Exception e){
                System.out.println("Enter a word");
                sc.next();
                i--;
            }
        }

        System.out.println("Palabras con más de 8 letras:");

        // todo
       Iterator<String> it = palabras.iterator();

       while (it.hasNext()) {
            String palabra = it.next();
            
            if(palabra.length() > 8){
                System.out.println(palabra);
            }
       }
       sc.close();
    }
}
