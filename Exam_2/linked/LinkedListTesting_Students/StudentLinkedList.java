package Exam_2.linked.LinkedListTesting_Students;

public class StudentLinkedList { // ! Second class

    private static class Node {

        LinkedListTesting2 data;
        Node next;

        Node(LinkedListTesting2 data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // start of the line

    public StudentLinkedList() {
        head = null;
    }

    // Add to the end
    public void addLast(LinkedListTesting2 s) {
        Node newNode = new Node(s);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Remove First Student with matching id
    public Boolean removeById(int id) {
        if (head == null)
            return false;
        if (head.data.getId() == id) {
            head = head.next;
            return true;
        }
        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data.getId() == id) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    // Find Student by id
    public LinkedListTesting2 findById(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Print list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
