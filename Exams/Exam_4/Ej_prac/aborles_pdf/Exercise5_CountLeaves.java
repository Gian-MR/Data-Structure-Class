package Exam_4.Ej_prac.aborles_pdf;

public class Exercise5_CountLeaves {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    // Instructions:
    // 1. If root is null, return 0.
    // 2. If root has no children, return 1.
    // 3. Recursively count leaves in left and right subtrees.
    // 4. Return the sum.

    public static int countLeaves(TreeNode root) {
        // ADD CODE HERE
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {
        // Tree:
        //       10
        //      /  \
        //     5   20
        //    / \    \
        //   3   7    30
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(30);

        System.out.println(countLeaves(root));
        // Expected idea:
        // 3
    }
}
