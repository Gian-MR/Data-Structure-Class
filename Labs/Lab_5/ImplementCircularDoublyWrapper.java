package Labs.Lab_5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImplementCircularDoublyWrapper {

    public static interface List<E> extends Iterable<E> {
        public void add(E elm);

        public void add(E elm, int index);

        public boolean remove(int index);

        public boolean remove(E elm);

        public E get(int index);

        public E set(E elm, int index);

        public int size();

        public int removeAll(E elm);

        public void clear();

        public boolean contains(E elm);

        public int firstIndex(E elm);

        public int lastIndex(E elm);

        public boolean isEmpty();

    }

    public static class CircularDoublyLinkedList<E> implements List<E> {

        private class Node {
            private E value;
            private Node next, prev;

            public Node(E value, Node next, Node prev) {
                this.value = value;
                this.next = next;
                this.prev = prev;
            }

            public Node(E value) {
                this(value, null, null); // Delegate to other constructor
            }

            // public Node() {
            //     this(null, null, null); // Delegate to other constructor
            // }

            public E getValue() {
                return value;
            }

            public void setValue(E value) {
                this.value = value;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getPrev() {
                return prev;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
            }

            public void clear() {
                value = null;
                next = prev = null;
            }
        } // End of Node class

        private class ListIterator implements Iterator<E> {

            private Node nextNode;

            public ListIterator() {
                nextNode = header.getNext();
            }

            @Override
            public boolean hasNext() {
                return nextNode != header;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E val = nextNode.getValue();
                    nextNode = nextNode.getNext();
                    return val;
                } else
                    throw new NoSuchElementException();
            }

        } // End of ListIterator class, DO NOT REMOVE, TEST WILL FAIL

        /* private fields */
        private Node header; // "dummy" node
        private int currentSize;

        public CircularDoublyLinkedList() {

            header = new Node(null);
            /*
             * TODO
             * What should the header point to??
             * Remember the List is supposed to act like a circle
             */
            header.setNext(header);
            header.setPrev(header);
            currentSize = 0;
        }

        @Override
        public void add(E obj) {
            /* TODO ADD YOUR CODE HERE */
            Node last = header.getPrev();
            Node newNode = new Node(obj, header, last);
            last.setNext(newNode);
            header.setPrev(newNode);
            currentSize++;
        }

        @Override
        public void add(E elm, int index) {
            /* TODO ADD YOUR CODE HERE */
            if (index < 0 || index > currentSize)
                throw new IndexOutOfBoundsException();

            if (index == currentSize) {
                add(elm);
                return;
            }

            Node curr = header.getNext();
            for (int i = 0; i < index; i++)
                curr = curr.getNext();

            Node prev = curr.getPrev();
            Node newNode = new Node(elm, curr, prev);
            prev.setNext(newNode);
            curr.setPrev(newNode);
            currentSize++;
        }

        @Override
        public boolean remove(E obj) {
            /* TODO ADD YOUR CODE HERE */
            Node curr = header.getNext();
            while (curr != header) {
                if (curr.getValue().equals(obj)) {
                    curr.getPrev().setNext(curr.getNext());
                    curr.getNext().setPrev(curr.getPrev());
                    curr.clear();
                    currentSize--;
                    return true;
                }
                curr = curr.getNext();
            }
            return false;
        }

        @Override
        public boolean remove(int index) {
            /* TODO ADD YOUR CODE HERE */
            if (index < 0 || index >= currentSize)
                throw new IndexOutOfBoundsException();

            Node curr = header.getNext();
            for (int i = 0; i < index; i++)
                curr = curr.getNext();

            curr.getPrev().setNext(curr.getNext());
            curr.getNext().setPrev(curr.getPrev());
            curr.clear();
            currentSize--;
            return true;
        }

        @Override
        public int removeAll(E obj) {
            /* TODO ADD YOUR CODE HERE */
            int removed = 0;
            Node curr = header.getNext();

            while (curr != header) {
                Node next = curr.getNext();
                if (curr.getValue().equals(obj)) {
                    curr.getPrev().setNext(curr.getNext());
                    curr.getNext().setPrev(curr.getPrev());
                    curr.clear();
                    currentSize--;
                    removed++;
                }
                curr = next;
            }

            return removed;
        }

        @Override
        public E get(int index) {
            /* TODO ADD YOUR CODE HERE */
            if (index < 0 || index >= currentSize)
                throw new IndexOutOfBoundsException();

            Node curr = header.getNext();
            for (int i = 0; i < index; i++)
                curr = curr.getNext();

            return curr.getValue();
        }

        @Override
        public E set(E elm, int index) {
            /* TODO ADD YOUR CODE HERE */
            if (index < 0 || index >= currentSize)
                throw new IndexOutOfBoundsException();

            Node curr = header.getNext();
            for (int i = 0; i < index; i++)
                curr = curr.getNext();

            E old = curr.getValue();
            curr.setValue(elm);
            return old;
        }

        @Override
        public int firstIndex(E obj) {
            /* TODO ADD YOUR CODE HERE */
            int idx = 0;
            Node curr = header.getNext();
            while (curr != header) {
                if (curr.getValue().equals(obj))
                    return idx;
                curr = curr.getNext();
                idx++;
            }
            return -1;
        }

        @Override
        public int lastIndex(E obj) {
            /* TODO ADD YOUR CODE HERE */
            int idx = currentSize - 1;
            Node curr = header.getPrev();
            while (curr != header) {
                if (curr.getValue().equals(obj))
                    return idx;
                curr = curr.getPrev();
                idx--;
            }
            return -1;
        }

        @Override
        public int size() {
            /* TODO ADD YOUR CODE HERE */
            return currentSize;
        }

        @Override
        public boolean isEmpty() {
            /* TODO ADD YOUR CODE HERE */
            return currentSize == 0;
        }

        @Override
        public boolean contains(E obj) {
            /* TODO ADD YOUR CODE HERE */
            return firstIndex(obj) != -1;
        }

        @Override
        public void clear() {
            /* TODO ADD YOUR CODE HERE */
            header.setNext(header);
            header.setPrev(header);
            currentSize = 0;
        }

        @Override
        public Iterator<E> iterator() {
            return new ListIterator();
        } // DO NOT DELETE, TESTS WILL FAIL

        public String toString() {
            Node temp = this.header.getNext();
            String r = "{";
            while (temp != header) {
                r += " " + temp.getValue() + ",";
                temp = temp.getNext();
            }
            r = r.substring(0, r.length() - 1) + "}";
            return r;
        }
    }

}