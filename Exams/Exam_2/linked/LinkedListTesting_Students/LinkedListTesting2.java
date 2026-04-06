package Exam_2.linked.LinkedListTesting_Students;

public class LinkedListTesting2 { //! First Class -> Student <- 

    private String name;
    private int id;

    public LinkedListTesting2(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {return name;}
    public int getId() {return id;} 

    @Override 
    public String toString(){
        return "Student{name='" + name + "', id=" + id + "}";
    }
}



