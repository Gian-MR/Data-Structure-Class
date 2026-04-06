package Exam_1.Scanner_Classes;
public class Cartera { //Ejercicio 2 practica 
    private double balance;
    
    public Cartera(){
        balance = 0;
    }

    public void ingresar(double monto){
        if(monto <= 0){
            System.out.println("Ingreso invalido");
            return;
        }
        balance += monto;
        System.out.println("Ingreso Realizado");
    }
    public void gastar(double monto){
        if(monto <= 0){
            System.out.println("Gasto Invalido");
            return;
        }
        if(monto > balance){
            System.out.println("Fondos insuficientes");
            return;
        }
        balance -= monto;
        System.out.println("Gasto realizado. Balance: " + balance);
    }
    public double getBalance(){
         return balance;
    }
}


