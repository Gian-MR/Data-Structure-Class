package Exam_4.Ej_prac.Arboles;

import java.util.ArrayList;
import java.util.List;

public class Exercise3_InorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // Instructions:
        // 1. Create an ArrayList<Integer> for the result.
        // 2. Use a helper method for recursive inorder traversal.
        // 3. Inorder order is: Left -> Root -> Right.
        // 4. Add visited node values to the list.
        // 5. Return the list.

        // ADD CODE HERE
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, result);
        result.add(root.val);
        inorderHelper(root.right, result);
    }

    public static void main(String[] args) {
        // Tree:
        //       4
        //      / \
        //     2   6
        //    / \ / \
        //   1  3 5  7
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(inorderTraversal(root));
        // Expected idea:
        // [1, 2, 3, 4, 5, 6, 7]
    }
}
