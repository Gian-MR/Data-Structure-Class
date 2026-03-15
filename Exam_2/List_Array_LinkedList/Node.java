package Exam_2.List_Array_LinkedList;
public class Node {
    // nodos -> guarda un valor(contiene un inico elemento de datos) y apunta a otro nodo, puede ser simple(alfrente) o double(alfrente y atras)
    // faster than normal array list insertingwise in the middle 
    int data;
    Node next; // if it was double it would also have prev;
    public Node(int data){
        this.data = data;
        this.next = null;
        //if it was double it would also have this.prev = null;
    }
}

class SingleLinkedList{
    public static void main(String[] args) {
        
    Node prmNode = new Node(20);
    Node seguNode = new Node(20);
    Node tercerNode = new Node(20);

    prmNode.next = seguNode;
    seguNode.next = tercerNode;

    Node curNode = prmNode;
    while(curNode != null){
        System.out.println(curNode.data);
        curNode = curNode.next;
        }
    }
}




