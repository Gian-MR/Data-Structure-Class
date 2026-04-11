package Exam_4.Ej_prac.All;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise5_HashMapAndTreeScanner {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Instructions:
    // 1. Read an integer n.
    // 2. Read n integers using Scanner.
    // 3. Store each number's frequency in a HashMap<Integer, Integer>.
    // 4. Insert only the unique values into a Binary Search Tree.
    // 5. Print the frequency map.
    // 6. Print the BST values using inorder traversal.
    //
    // Example input:
    // 8
    // 5 3 5 8 3 10 1 8
    //
    // Expected idea:
    // Frequencies: {1=1, 3=2, 5=2, 8=2, 10=1}
    // Inorder BST: 1 3 5 8 10

    public static Map<Integer, Integer> countFrequencies(int[] values) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int value : values) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        return frequencyMap;
    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else if (value > root.val) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to type: ");
        int n = scanner.nextInt();

        int[] values = new int[n];
        TreeNode root = null;

        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            root = insert(root, values[i]);
        }

        Map<Integer, Integer> frequencyMap = countFrequencies(values);

        System.out.println("Frequencies: " + frequencyMap);
        System.out.print("BST inorder traversal: ");
        inorder(root);
        System.out.println();

        scanner.close();
    }
}
