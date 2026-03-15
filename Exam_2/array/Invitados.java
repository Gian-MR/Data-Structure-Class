package Exam_2.array;

import java.util.*;

public class Invitados {
    public static void main(String[] arg){
        ArrayList<String> invitados = new ArrayList<String>();
        boolean login = true;
        Scanner sc = new Scanner(System.in);
    
        // todo
        while(login){
            System.out.println("Enter name");
            String input = sc.nextLine();

                if(invitados.contains(input)){
                    System.out.println("Name already in the list.");
                
                }else if (input.equals("EXIT")){
                    login = false;
                }else{
                    invitados.add(input);
                    System.out.println("Name has been added to the list.");
                }
            }
        sc.close();
    }
}
