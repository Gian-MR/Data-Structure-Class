package Exam_1.Scanner_Classes;
//! original

interface Animal {
    public default void whatType(){}
}

interface FishAnimals {
     static void whatType(){}
}

class Both implements Animal, FishAnimals{
    public void whatType(){
        Animal.super.whatType();
    }
}

class Animals {
    public static void main(String[] args) {
         Both flyingfish = new Both();
         flyingfish.whatType();
    }
}
