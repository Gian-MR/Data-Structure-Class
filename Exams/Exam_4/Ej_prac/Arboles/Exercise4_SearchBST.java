package Exam_4.Ej_prac.Arboles;

public class Exercise4_SearchBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean searchBST(TreeNode root, int target) {
        // Instructions:
        // 1. If root is null, return false.
        // 2. If root.val equals target, return true.
        // 3. If target is smaller than root.val, search in the left subtree.
        // 4. Otherwise, search in the right subtree.

        // ADD CODE HERE
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        } else if (target < root.val) {
            return searchBST(root.left, target);
        } else {
            return searchBST(root.right, target);
        }
    }

    public static void main(String[] args) {
        // BST:
        //       20
        //      /  \
        //    10    30
        //   / \   / \
        //  5  15 25 35
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        System.out.println(searchBST(root, 25));
        // Expected idea:
        // true

        System.out.println(searchBST(root, 99));
        // Expected idea:
        // false
    }
}
