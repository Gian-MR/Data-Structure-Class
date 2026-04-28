package Labs.Lab_9_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Comparator;

public class BSTRemoveWrapper {

    public interface Entry<K, V> {

        public K getKey();

        public V getValue();

    }

    public interface BinarySearchTree<K, V> {

        Entry<K, V> get(K key);

        void add(K key, V value);

        Entry<K, V> remove(K key);

        int size();

        boolean isEmpty();
    }

    public static class DefaultComparator<K> implements Comparator<K> {

        @SuppressWarnings("unchecked")
        @Override
        public int compare(K a, K b) {
            return ((Comparable<K>) a).compareTo(b);
        }

    }

    public static class LinkedBinarySearchTree<K, V> implements BinarySearchTree<K, V> {

        /**
         * Private class that will represent an Entry for the BST.
         * This class will hold the key-value pairs that will be store in the BST
         * 
         * @author Manuel Rodriguez
         *
         * @param <K> - represents a key
         * @param <V> - represents the value pointed by the key
         */
        private static class BTEntry<K, V> implements Entry<K, V> {

            private K key;
            private V value;

            public BTEntry(K key, V value) {
                super();
                this.key = key;
                this.value = value;
            }

            public void setKey(K key) {
                this.key = key;
            }

            public void setValue(V value) {
                this.value = value;
            }

            @Override
            public K getKey() {
                return this.key;
            }

            @Override
            public V getValue() {
                return this.value;
            }

        }

        /**
         * Private class that will represent the nodes of the Tree.
         * Notice it differs from the TreeNode from the more general Tree and
         * BinaryTree.
         * This is due to this one needing key-value pairs.
         * 
         * @author Manuel Rodriguez
         *
         * @param <K> - represents a key
         * @param <V> - represents the value pointed by the key
         */
        private static class BTNode<K, V> {
            private Entry<K, V> value;
            private BTNode<K, V> parent;
            private BTNode<K, V> leftChild;
            private BTNode<K, V> rightChild;

            public BTNode(Entry<K, V> value, BTNode<K, V> parent, BTNode<K, V> leftChild, BTNode<K, V> rightChild) {
                super();
                this.value = value;
                this.parent = parent;
                this.leftChild = leftChild;
                this.rightChild = rightChild;
            }

            public Entry<K, V> getValue() {
                return value;
            }

            public void setValue(Entry<K, V> value) {
                this.value = value;
            }

            public BTNode<K, V> getParent() {
                return parent;
            }

            public void setParent(BTNode<K, V> parent) {
                this.parent = parent;
            }

            public BTNode<K, V> getLeftChild() {
                return leftChild;
            }

            public void setLeftChild(BTNode<K, V> leftChild) {
                this.leftChild = leftChild;
            }

            public BTNode<K, V> getRightChild() {
                return rightChild;
            }

            public void setRightChild(BTNode<K, V> rightChild) {
                this.rightChild = rightChild;
            }
        }

        /*
         * BST Implementation starts here
         */

        private BTNode<K, V> root;
        private int size;
        private Comparator<K> comp;

        // How do we initialize a BST?
        public LinkedBinarySearchTree() {
            this.root = null;
            this.size = 0;
            this.comp = new DefaultComparator<K>();
        }

        public LinkedBinarySearchTree(Comparator<K> c) {
            this.root = null;
            this.size = 0;
            this.comp = c;
        }

        @Override
        public void add(K key, V value) {
            if (key == null || value == null) {
                throw new IllegalArgumentException();
            }
            // Check if it's the BST is empty
            if (this.root == null) {
                this.root = new BTNode<>(new BTEntry<K, V>(key, value), null, null, null);
                this.size++;
                return;
            }
            // Search for the position to place the entry and add it, if possible.
            recAdd(this.root, new BTEntry<K, V>(key, value));

        }

        private void recAdd(BTNode<K, V> n, BTEntry<K, V> e) {
            // How the key compares to the current node's key
            int res = comp.compare(n.getValue().getKey(), e.getKey());
            // If found we stop searching and do nothing.
            if (res == 0) {
                return;
            }
            // If the key of the entry is smaller than the current node
            else if (res > 0) {
                // If we reach a dead end add the node
                if (n.getLeftChild() == null) {
                    BTNode<K, V> left = new BTNode<>(e, n, null, null);
                    n.setLeftChild(left);
                    this.size++;
                    return;
                }
                // Keep searching
                recAdd(n.getLeftChild(), e);
            } else {
                // If we found a dead end we add the node
                if (n.getRightChild() == null) {
                    BTNode<K, V> right = new BTNode<>(e, n, null, null);
                    n.setRightChild(right);
                    this.size++;
                    return;
                }
                // Keep searching
                recAdd(n.getRightChild(), e);
            }

        }

        @Override
        public Entry<K, V> get(K key) {
            if (key == null) {
                throw new IllegalArgumentException();
            }
            return recGet(this.root, key);
        }

        private Entry<K, V> recGet(BTNode<K, V> n, K key) {
            // TODO Auto-generated method stub
            if (n == null) {
                return null;
            }
            int res = comp.compare(key, n.getValue().getKey());
            if (res == 0) {
                return n.getValue();
            } else if (res < 0) {
                return recGet(n.getLeftChild(), key);
            } else {
                return recGet(n.getRightChild(), key);
            }
        }

        @Override
        public int size() {
            // TODO Auto-generated method stub
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return this.root == null;
        }

        /*
         * Implement the remove(K key) method for the Binary Search Tree ADT. This
         * method
         * removes a node that has a key equal to the key given as a parameter from
         * the Binary Search Tree while maintaining the BST Property intact. As
         * mentioned
         * in lectures, how the removal works is dependent on the number of children the
         * node being removed has. 
         * 
         * Cases to consider:
         * 
         * Node is a leaf: The node to remove is set to null.
         * Node has one child: The node to remove is replaced by its child.
         * Node has both children: The node to remove is replaced by its in-order
         * descendent.
         * 
         * An additional case to consider: What happens if the node being removed is the
         * root of the BST for any previously stated edge cases?  
         */
        @Override
        public Entry<K, V> remove(K key) {
            if (key == null)
                throw new IllegalArgumentException();
            // ADD CODE HERE
            BTNode<K, V> node = findNode(this.root, key);

            if (node == null) {
                return null;
            }

            Entry<K, V> removed = node.getValue();

            if (node.getLeftChild() == null && node.getRightChild() == null) {
                removeLeaf(node);
            } else if (node.getLeftChild() == null || node.getRightChild() == null) {
                removeOneChild(node);
            } else {
                removeTwoChildren(node);
            }

            this.size--;

            return removed;
        }

        // Can add auxiliary methods here
        private BTNode<K, V> findNode(BTNode<K, V> node, K key) {
            if (node == null) {
                return null;
            }

            int comparison = this.comp.compare(key, node.getValue().getKey());

            if (comparison == 0) {
                return node;
            } else if (comparison < 0) {
                return findNode(node.getLeftChild(), key);
            } else {
                return findNode(node.getRightChild(), key);
            }
        }
        
        private void removeLeaf(BTNode<K, V> node) {
            if (node.getParent() == null) {
                this.root = null;
            } else if (node == node.getParent().getLeftChild()) {
                node.getParent().setLeftChild(null);
            } else {
                node.getParent().setRightChild(null);
            }
        }

        private void removeOneChild(BTNode<K, V> node) {
            BTNode<K, V> child;

            if (node.getLeftChild() != null) {
                child = node.getLeftChild();
            } else {
                child = node.getRightChild();
            }

            if (node.getParent() == null) {
                this.root = child;
                child.setParent(null);
            } else if (node == node.getParent().getLeftChild()) {
                node.getParent().setLeftChild(child);
                child.setParent(node.getParent());
            } else {
                node.getParent().setRightChild(child);
                child.setParent(node.getParent());
            }
        }

        private void removeTwoChildren(BTNode<K, V> node) {
            BTNode<K, V> successor = smallestNode(node.getRightChild());

            node.setValue(successor.getValue());

            if (successor.getLeftChild() == null && successor.getRightChild() == null) {
                removeLeaf(successor);
            } else {
                removeOneChild(successor);
            }
        }

        private BTNode<K, V> smallestNode(BTNode<K, V> node) {
            while (node.getLeftChild() != null) {
                node = node.getLeftChild();
            }

            return node;
        }
        /*
         * DO NOT EDIT. THIS IS FOR TESTING
         */
        public ArrayList<V> inOrderTraversal() {
            return inOrderRec(this.root, new ArrayList<V>(this.size));
        }

        private ArrayList<V> inOrderRec(BTNode<K, V> n, ArrayList<V> ks) {
            // TODO Auto-generated method stub
            if (n == null) {
                return ks;
            }
            inOrderRec(n.getLeftChild(), ks);
            ks.add(n.getValue().getValue());
            inOrderRec(n.getRightChild(), ks);
            return ks;
        }

        /*
         * DO NOT EDIT. THIS IS FOR TESTING
         */
        public Entry<K, V> getRoot() {
            return this.root.getValue();
        }

    }

}
