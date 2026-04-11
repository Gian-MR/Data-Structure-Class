package Exam_4.Ej_prac.arborles_pdf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Exercise6_LevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    // Instructions:
    // 1. If root is null, return an empty list.
    // 2. Use a Queue to do BFS.
    // 3. Remove one node at a time, add its value to result.
    // 4. Push non-null left and right children into the queue.

    public static List<Integer> levelOrder(TreeNode root) {
        // ADD CODE HERE
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            result.add(cur.val);

            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Tree:
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4  5    6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(levelOrder(root));
        // Expected idea:
        // [1, 2, 3, 4, 5, 6]
    }
}
