package Exam_4.Ej_prac.aborles_pdf;

public class Exercise7_IsValidBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    // Instructions:
    // 1. A valid BST requires left < node < right.
    // 2. Use helper recursion with lower and upper bounds.
    // 3. If a node breaks bounds, return false.
    // 4. Otherwise validate both subtrees.

    public static boolean isValidBST(TreeNode root) {
        // ADD CODE HERE
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long low, long high) {
        if (node == null) {
            return true;
        }
        if (node.val <= low || node.val >= high) {
            return false;
        }
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }

    public static void main(String[] args) {
        // Valid BST:
        //      8
        //     / \
        //    3  10
        //   / \   \
        //  1   6  14
        TreeNode valid = new TreeNode(8);
        valid.left = new TreeNode(3);
        valid.right = new TreeNode(10);
        valid.left.left = new TreeNode(1);
        valid.left.right = new TreeNode(6);
        valid.right.right = new TreeNode(14);

        // Invalid BST:
        //      8
        //     / \
        //    3   10
        //       /
        //      7   (7 is invalid here for right subtree of 8)
        TreeNode invalid = new TreeNode(8);
        invalid.left = new TreeNode(3);
        invalid.right = new TreeNode(10);
        invalid.right.left = new TreeNode(7);

        System.out.println(isValidBST(valid));
        // Expected idea:
        // true

        System.out.println(isValidBST(invalid));
        // Expected idea:
        // false
    }
}
