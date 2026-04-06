package Exam_4.Ej_prac.Arboles;

public class Syntax {
	/* 
	  !Trees quick syntax + methods (Java)
	 
	  ?1) Imports + declaration
	     import java.util.TreeSet;
	     import java.util.TreeMap;
	 
	     TreeSet<Type> set = new TreeSet<>();
	     TreeMap<KeyType, ValueType> map = new TreeMap<>();
	 
	  ?2) TreeSet basics (sorted unique values)
	     set.add(value);                 // add value
	     set.remove(value);              // remove value
	     set.contains(value);            // true if value exists
	     set.size();                     // number of elements
	     set.isEmpty();                  // true if empty
	     set.clear();                    // remove all
	 
	  ?3) TreeSet navigation helpers
	     set.first();                    // smallest element
	     set.last();                     // largest element
	     set.lower(x);                   // greatest < x
	     set.floor(x);                   // greatest <= x
	     set.ceiling(x);                 // smallest >= x
	     set.higher(x);                  // smallest > x
	 
	  ?4) TreeMap basics (sorted keys)
	     map.put(key, value);            // add or replace by key
	     map.get(key);                   // value or null
	     map.getOrDefault(key, def);     // value if exists, else def
	     map.remove(key);                // remove by key
	     map.containsKey(key);           // true if key exists
	     map.containsValue(value);       // true if value exists
	     map.size();
	     map.isEmpty();
	     map.clear();
	 
	  ?5) TreeMap navigation helpers
	     map.firstKey();                 // smallest key
	     map.lastKey();                  // largest key
	     map.lowerKey(k);                // greatest key < k
	     map.floorKey(k);                // greatest key <= k
	     map.ceilingKey(k);              // smallest key >= k
	     map.higherKey(k);               // smallest key > k
	 
	  ?6) Iteration
	     for (Type x : set) { ... }
	 
	     for (KeyType k : map.keySet()) { ... }
	     for (ValueType v : map.values()) { ... }
	     for (java.util.Map.Entry<KeyType, ValueType> e : map.entrySet()) {
	         KeyType key = e.getKey();
	         ValueType value = e.getValue();
	     }
	 
	  ?7) Custom binary tree node syntax
	     class Node {
	         int data;
	         Node left, right;
	         Node(int data) { this.data = data; }
	     }
	 
	  ?8) BST insert (recursive)
	     Node insert(Node root, int val) {
	         if (root == null) return new Node(val);
	         if (val < root.data) root.left = insert(root.left, val);
	         else if (val > root.data) root.right = insert(root.right, val);
	         return root;
	     }
	 
	  ?9) Traversals
	     void inorder(Node r) {          // Left, Root, Right
	         if (r == null) return;
	         inorder(r.left);
	         System.out.print(r.data + " ");
	         inorder(r.right);
	     }
	 
	     void preorder(Node r) {         // Root, Left, Right
	         if (r == null) return;
	         System.out.print(r.data + " ");
	         preorder(r.left);
	         preorder(r.right);
	     }
	 
	     void postorder(Node r) {        // Left, Right, Root
	         if (r == null) return;
	         postorder(r.left);
	         postorder(r.right);
	         System.out.print(r.data + " ");
	     }
	 
	  ?10) Notes
	     - TreeSet and TreeMap are sorted (natural order by default).
	     - They are implemented with balanced BST (Red-Black Tree).
	     - TreeSet: unique values only.
	     - TreeMap: unique keys, values can repeat.
	     - Most operations are O(log n).
	 
	  ! Example:
	     TreeSet<Integer> nums = new TreeSet<>();
	     nums.add(7);
	     nums.add(3);
	     nums.add(10);
	 
	     TreeMap<String, Integer> ages = new TreeMap<>();
	     ages.put("Ana", 20);
	     ages.put("Luis", 19);
	 */
}
