package Exam_2.linked.LinkedListTesting_Students;

public class Main {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addLast(new LinkedListTesting2("Gian", 101));
        list.addLast(new LinkedListTesting2("Ana", 102));
        list.addLast(new LinkedListTesting2("Luis", 103));

        System.out.println("=== List ===");
        list.printList();

        System.out.println("\nFind id 102:");
        LinkedListTesting2 found = list.findById(102);
        System.out.println(found == null ? "Not found" : found);

        System.out.println("\nRemove id 101:");
        System.out.println(list.removeById(101) ? "Removed" : "Not removed");

        System.out.println("\n=== List after removal ===");
        list.printList();
    }
}
