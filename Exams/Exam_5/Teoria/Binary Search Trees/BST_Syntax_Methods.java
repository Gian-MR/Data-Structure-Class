import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * BST_Syntax_Methods
 *
 * A compact study guide with common Binary Search Tree (BST) syntax and methods.
 *
 * Core BST rule:
 * - left subtree values < node value
 * - right subtree values > node value
 */
public class BST_Syntax_Methods {

    // Basic node structure used in BST problems.
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static class BST {
        private Node root;

        public boolean isEmpty() {
            return root == null;
        }

        public void clear() {
            root = null;
        }

        // Insert value (ignores duplicates).
        public void insert(int value) {
            root = insert(root, value);
        }

        private Node insert(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }

            if (value < node.value) {
                node.left = insert(node.left, value);
            } else if (value > node.value) {
                node.right = insert(node.right, value);
            }
            return node;
        }

        // Search for value.
        public boolean contains(int value) {
            Node curr = root;
            while (curr != null) {
                if (value < curr.value) {
                    curr = curr.left;
                } else if (value > curr.value) {
                    curr = curr.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        // Delete value using the standard 3-case BST deletion logic.
        public void delete(int value) {
            root = delete(root, value);
        }

        private Node delete(Node node, int value) {
            if (node == null) {
                return null;
            }

            if (value < node.value) {
                node.left = delete(node.left, value);
            } else if (value > node.value) {
                node.right = delete(node.right, value);
            } else {
                // Case 1: leaf node
                if (node.left == null && node.right == null) {
                    return null;
                }
                // Case 2: one child
                if (node.left == null) {
                    return node.right;
                }
                if (node.right == null) {
                    return node.left;
                }
                // Case 3: two children
                Node successor = minNode(node.right);
                node.value = successor.value;
                node.right = delete(node.right, successor.value);
            }
            return node;
        }

        // Minimum value in BST.
        public int findMin() {
            if (root == null) {
                throw new IllegalStateException("Tree is empty");
            }
            return minNode(root).value;
        }

        // Maximum value in BST.
        public int findMax() {
            if (root == null) {
                throw new IllegalStateException("Tree is empty");
            }
            Node curr = root;
            while (curr.right != null) {
                curr = curr.right;
            }
            return curr.value;
        }

        private Node minNode(Node node) {
            Node curr = node;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        // Height: empty tree = -1, leaf = 0.
        public int height() {
            return height(root);
        }

        private int height(Node node) {
            if (node == null) {
                return -1;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }

        // Depth-first traversals.
        public List<Integer> inOrder() {
            List<Integer> result = new ArrayList<>();
            inOrder(root, result);
            return result;
        }

        private void inOrder(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }
            inOrder(node.left, result);
            result.add(node.value);
            inOrder(node.right, result);
        }

        public List<Integer> preOrder() {
            List<Integer> result = new ArrayList<>();
            preOrder(root, result);
            return result;
        }

        private void preOrder(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }
            result.add(node.value);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }

        public List<Integer> postOrder() {
            List<Integer> result = new ArrayList<>();
            postOrder(root, result);
            return result;
        }

        private void postOrder(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.value);
        }

        // Breadth-first traversal (level order).
        public List<Integer> levelOrder() {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                result.add(current.value);

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            return result;
        }

        // Optional helper: sorted array to balanced BST.
        public static BST fromSortedArray(int[] nums) {
            BST bst = new BST();
            bst.root = buildBalanced(nums, 0, nums.length - 1);
            return bst;
        }

        private static Node buildBalanced(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            Node node = new Node(nums[mid]);
            node.left = buildBalanced(nums, left, mid - 1);
            node.right = buildBalanced(nums, mid + 1, right);
            return node;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("In-order (sorted): " + tree.inOrder());
        System.out.println("Pre-order: " + tree.preOrder());
        System.out.println("Post-order: " + tree.postOrder());
        System.out.println("Level-order: " + tree.levelOrder());

        System.out.println("Contains 40? " + tree.contains(40));
        System.out.println("Contains 99? " + tree.contains(99));

        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Height: " + tree.height());

        tree.delete(20); // leaf
        tree.delete(30); // one child
        tree.delete(50); // two children

        System.out.println("After deletions, in-order: " + tree.inOrder());

        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        BST balanced = BST.fromSortedArray(sorted);
        System.out.println("Balanced BST from sorted array, level-order: " + balanced.levelOrder());
    }
}
