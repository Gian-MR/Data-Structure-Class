package Exam_2.List_Array_LinkedList;
import java.util.*;

public class RegListTesting {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 Random Numbers:");

        List<Integer> list = new ArrayList<>();
        int count = 5;
        int max;

        while (count != 0) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                list.add(number);
                count--;
            } else {
                String bad = sc.next(); // consume the non-int token (like "a")
                System.out.println("\"" + bad + "\" is not a number. Try again:");
            }
        }

        System.out.println("\nThanks your list is: " + list);

        max = list.get(0);

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        System.out.println("\nThe biggest random number is: " + max);
        
        sc.close();
    }
}
