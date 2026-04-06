package Exam_1.two_classes;

import java.util.*;

public class Store {
    ArrayList<String> books = new ArrayList<>();
    int count;

    void addbook(String bookNames){
        if(count < 5){
            books.add(bookNames);
            count++;
        }else{
            System.out.println("Its full");
        }
    }

    void showBooks(){
        for(String Book : books){
            System.out.println("- " + Book);
        }
    }
}
