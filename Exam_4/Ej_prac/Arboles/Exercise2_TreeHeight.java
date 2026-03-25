package Exam_4.Ej_prac.Arboles;

public class Exercise2_TreeHeight {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int treeHeight(TreeNode root) {
        // Instructions:
        // 1. If root is null, return 0.
        // 2. Get the height of the left subtree.
        // 3. Get the height of the right subtree.
        // 4. Return 1 + max(leftHeight, rightHeight).

        // ADD CODE HERE
        return 0;
    }

    public static void main(String[] args) {
        // Tree:
        //       8
        //      / \
        //     3   10
        //    /
        //   1
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);

        System.out.println(treeHeight(root));
        // Expected idea:
        // 3
    }
}
