package Exam_1.Scanner_Classes;

/*
class -> extend (in classes u just do everything like create the method with the code etc)

interface -> implemnts  (in interfaces u just create the method with no code)

*/
// import java.util.InputMismatchException;
import java.util.Scanner;

// public class repaso1 {
//     public static void main(String[] arg ){
//         String passwords = "hello world";
//         int tries = 5;

//         try (Scanner sc = new Scanner(System.in)) {
//             while (tries > 0) {
//                 try {
//                     System.out.print("Enter Password: ");
//                     String input = sc.nextLine();

//                     if (passwords.equals(input)) {
//                         System.out.println("Ur in :D");
//                         break;
//                     } else {
//                         tries--;
//                         if (tries > 0) {
//                             System.out.println("Incorrect Password. U have " + tries + " tries left");
//                         } else {
//                             System.out.println("Incorrect password. No tries left. Access denied.");
//                         }
//                     }
//                 } catch (InputMismatchException ime) {
//                     System.out.println("Invalid input type. Please enter text and press Enter.");
//                     sc.nextLine();
//                 } catch (Exception e) {
//                     System.out.println("An unexpected error occurred: " + e.getMessage());
//                     e.printStackTrace();
//                     break;
//                 }
//             }
//         } catch (Exception e) {
//             System.out.println("Failed to initialize input: " + e.getMessage());
//             e.printStackTrace();
//         }
//     }
// }

public class repaso1 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);

        int age = 0;
        double salary = 0.0;

        boolean validAge = false;
        boolean validSalary = false;

        while(!validAge){
            try{
                System.out.println("Enter Age");
                String input = sc.nextLine();

                age = Integer.parseInt(input);

                if(age > 0){
                    validAge = true;
                }else{
                    System.out.println("Invalid age.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Pls enter valid Number.");
            }
        }

        while(!validSalary){
            try{
                System.out.println("Enter your salary");
                String input = sc.nextLine();

                salary = Double.parseDouble(input);

                if(salary >= 0){
                    validSalary = true;
                }else{
                    System.out.println("Salary cannot be negative.");
                }
            } catch (NumberFormatException e){
                System.out.println("Pls enter valid number");
            }
        }
        sc.close();
    }
}


