package Exam_5.Teoria.Heaps;
import java.util.*;

/**
 * Heap_Syntax_Methods
 *
 * Study guide for heaps in Java.
 *
 * Main ideas:
 * - Heap is a complete binary tree usually stored in an array/list.
 * - MinHeap property: parent <= children.
 * - MaxHeap property: parent >= children.
 *
 * Index formulas (0-based array):
 * - parent(i) = (i - 1) / 2
 * - left(i)   = 2 * i + 1
 * - right(i)  = 2 * i + 2
 */
public class Heap_Syntax_Methods {

    // Manual MinHeap implementation (exam-friendly).
    static class MinHeap {
        private final List<Integer> data = new ArrayList<>();

        public boolean isEmpty() {
            return data.isEmpty();
        }

        public int size() {
            return data.size();
        }

        public Integer peek() {
            return isEmpty() ? null : data.get(0);
        }

        // Insert: add at end, then bubble up.
        public void insert(int value) {
            data.add(value);
            bubbleUp(data.size() - 1);
        }

        // Remove min (root): swap with last, remove last, then bubble down.
        public Integer extractMin() {
            if (isEmpty()) {
                return null;
            }

            int min = data.get(0);
            int lastIndex = data.size() - 1;
            swap(0, lastIndex);
            data.remove(lastIndex);

            if (!isEmpty()) {
                bubbleDown(0);
            }
            return min;
        }

        // Heapify from arbitrary list in O(n).
        public void buildHeap(List<Integer> values) {
            data.clear();
            data.addAll(values);

            for (int i = parent(data.size() - 1); i >= 0; i--) {
                bubbleDown(i);
            }
        }

        public List<Integer> toList() {
            return new ArrayList<>(data);
        }

        private void bubbleUp(int index) {
            while (index > 0) {
                int parentIndex = parent(index);
                if (data.get(index) < data.get(parentIndex)) {
                    swap(index, parentIndex);
                    index = parentIndex;
                } else {
                    break;
                }
            }
        }

        private void bubbleDown(int index) {
            int size = data.size();

            while (true) {
                int leftIndex = left(index);
                int rightIndex = right(index);
                int smallest = index;

                if (leftIndex < size && data.get(leftIndex) < data.get(smallest)) {
                    smallest = leftIndex;
                }
                if (rightIndex < size && data.get(rightIndex) < data.get(smallest)) {
                    smallest = rightIndex;
                }

                if (smallest == index) {
                    break;
                }

                swap(index, smallest);
                index = smallest;
            }
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        private void swap(int i, int j) {
            int temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }
    }

    public static void main(String[] args) {
        // 1) Manual MinHeap usage
        MinHeap heap = new MinHeap();
        int[] values = {20, 5, 12, 7, 30, 2, 15};

        for (int value : values) {
            heap.insert(value);
        }

        System.out.println("Manual MinHeap array form: " + heap.toList());
        System.out.println("Peek min: " + heap.peek());
        System.out.println("Extract min: " + heap.extractMin());
        System.out.println("After extract: " + heap.toList());

        // Build heap from list
        List<Integer> raw = List.of(40, 10, 25, 8, 16, 50, 3);
        heap.buildHeap(raw);
        System.out.println("Heapified from raw list: " + heap.toList());

        // 2) Java built-in heap (PriorityQueue = MinHeap by default)
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.offer(9);
        minPQ.offer(1);
        minPQ.offer(6);
        minPQ.offer(3);

        System.out.println("PriorityQueue peek: " + minPQ.peek());
        System.out.println("PriorityQueue poll: " + minPQ.poll());
        System.out.println("PriorityQueue after poll: " + minPQ);

        // MaxHeap with PriorityQueue (reverse order comparator)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(java.util.Collections.reverseOrder());
        maxPQ.offer(9);
        maxPQ.offer(1);
        maxPQ.offer(6);
        maxPQ.offer(3);

        System.out.println("MaxHeap peek: " + maxPQ.peek());
        System.out.println("MaxHeap poll: " + maxPQ.poll());
        System.out.println("MaxHeap after poll: " + maxPQ);
    }
}
