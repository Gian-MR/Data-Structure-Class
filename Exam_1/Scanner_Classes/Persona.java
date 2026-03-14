package Exam_1.Scanner_Classes;
public class Persona {
    private String name;
    private Cartera cartera;
    
    public Persona(String name){
        this.name = name;
        cartera = new Cartera();
    }
    
    public Cartera getCartera() {
        return cartera;
    }
    
    public String getName(){
        return name;
    }
}


