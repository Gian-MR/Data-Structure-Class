package Exam_4.Ej_prac.arborles_pdf;

public class Exercise8_LowestCommonAncestorBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    // Instructions:
    // 1. In a BST, left values are smaller and right values are larger.
    // 2. If both p and q are smaller than root, move left.
    // 3. If both are larger than root, move right.
    // 4. Otherwise, root is the split point and the LCA.

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        // ADD CODE HERE
        TreeNode cur = root;
        while (cur != null) {
            if (p < cur.val && q < cur.val) {
                cur = cur.left;
            } else if (p > cur.val && q > cur.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
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

        System.out.println(lowestCommonAncestor(root, 5, 15).val);
        // Expected idea:
        // 10

        System.out.println(lowestCommonAncestor(root, 25, 35).val);
        // Expected idea:
        // 30
    }
}
