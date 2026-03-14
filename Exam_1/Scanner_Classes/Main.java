package Exam_1.Scanner_Classes;
public class Main {
    public static void main(String[] arg){
        Persona p = new Persona("Gian");

        p.getCartera().ingresar(500);
        p.getCartera().gastar(300);
    }
}
