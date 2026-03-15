package Exam_2.array;

import java.util.*;

public class merged {
    ArrayList<Integer> list_1 = new ArrayList<Integer>();
    ArrayList<Integer> list_2 = new ArrayList<Integer>();
    ArrayList<Integer> list_3 = new ArrayList<Integer>();
    Random rand = new Random();


    void fill(){
        for(int i = 0; i < 10; i++){
            list_1.add(rand.nextInt(10));
            list_2.add(rand.nextInt(10));
        }
        System.out.println(list_1);
        System.out.println(list_2);
    }

    //todo
    void merge(){
        for(int i = 0; i < list_1.size(); i++){
            list_3.add(list_1.get(i));
            list_3.add(list_2.get(i));
        }
        System.out.println(list_3);
    }


    public static void main(String[] arg){
        merged m = new merged();

        m.fill();
        m.merge();
    }
}
