package Examen_Final.Ejemplos;
import java.util.Arrays;

/**
 * Comprehensive collection of sorting algorithms
 * Includes: Selection Sort, Insertion Sort, Merge Sort, Quick Sort, Heap Sort, and Tim Sort
 */
public class SortingAlgorithms {

    // ==================== SELECTION SORT ====================
    /**
     * Selection Sort: O(n²) time | O(1) space
     * Divides array into sorted and unsorted portions, repeatedly selecting minimum
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    // ==================== INSERTION SORT ====================
    /**
     * Insertion Sort: O(n²) time | O(1) space
     * Builds sorted array by inserting elements one at a time
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // ==================== MERGE SORT ====================
    /**
     * Merge Sort: O(n log n) time | O(n) space
     * Divide and conquer: splits array in half, recursively sorts, then merges
     */
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // ==================== QUICK SORT ====================
    /**
     * Quick Sort: O(n log n) average | O(n²) worst | O(log n) space
     * Divide and conquer: partitions array around pivot, recursively sorts partitions
     */
    public static void quickSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ==================== HEAP SORT ====================
    /**
     * Heap Sort: O(n log n) time | O(1) space
     * Builds max heap, repeatedly removes root and heapifies
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // ==================== TIM SORT ====================
    /**
     * Tim Sort: O(n log n) time | O(n) space
     * Hybrid of merge sort and insertion sort (Java's default sorting algorithm)
     * This is a simplified demonstration; Java's actual implementation is more complex
     */
    public static void timSort(int[] arr) {
        final int RUN = 32;  // Minimum run length
        int n = arr.length;

        // Sort individual runs using insertion sort
        for (int start = 0; start < n; start += RUN) {
            int end = Math.min(start + RUN, n);
            insertionSortRange(arr, start, end - 1);
        }

        // Merge sorted runs
        for (int size = RUN; size < n; size *= 2) {
            for (int start = 0; start < n; start += size * 2) {
                int mid = start + size;
                int end = Math.min(start + size * 2, n);

                if (mid < end) {
                    mergeRange(arr, start, mid - 1, end - 1);
                }
            }
        }
    }

    private static void insertionSortRange(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void mergeRange(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // ==================== TESTING ====================
    public static void main(String[] args) {
        int[] original = {64, 34, 25, 12, 22, 11, 90, 88, 45, 50};

        // Selection Sort
        int[] arr1 = original.clone();
        selectionSort(arr1);
        System.out.println("Selection Sort: " + Arrays.toString(arr1));

        // Insertion Sort
        int[] arr2 = original.clone();
        insertionSort(arr2);
        System.out.println("Insertion Sort: " + Arrays.toString(arr2));

        // Merge Sort
        int[] arr3 = original.clone();
        mergeSort(arr3);
        System.out.println("Merge Sort:     " + Arrays.toString(arr3));

        // Quick Sort
        int[] arr4 = original.clone();
        quickSort(arr4);
        System.out.println("Quick Sort:     " + Arrays.toString(arr4));

        // Heap Sort
        int[] arr5 = original.clone();
        heapSort(arr5);
        System.out.println("Heap Sort:      " + Arrays.toString(arr5));

        // Tim Sort
        int[] arr6 = original.clone();
        timSort(arr6);
        System.out.println("Tim Sort:       " + Arrays.toString(arr6));

        // Java's built-in (also Tim Sort)
        int[] arr7 = original.clone();
        Arrays.sort(arr7);
        System.out.println("Arrays.sort():  " + Arrays.toString(arr7));
    }
}
