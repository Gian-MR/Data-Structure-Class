package Exam_4.Ej_prac.Arboles;

public class Exercise1_CountNodes {

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
    // 2. Recursively count nodes in the left subtree.
    // 3. Recursively count nodes in the right subtree.
    // 4. Return 1 + leftCount + rightCount.

    public static int countNodes(TreeNode root) {
        // ADD CODE HERE
        if (root == null) {
            return 0;
        }
        return 1 + (countNodes(root.left) + countNodes(root.right));
    }

    public static void main(String[] args) {
        // Tree:
        //       10
        //      /  \
        //     5    15
        //    / \
        //   2   7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        System.out.println(countNodes(root));
        // Expected idea:
        // 5
    }
}
