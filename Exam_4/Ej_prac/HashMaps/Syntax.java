package Exam_4.Ej_prac.HashMaps;

public class Syntax {
	/* 
	  !HashMap quick syntax + methods (Java)
	 
	  ?1) Import + declaration
	     import java.util.HashMap;
	     HashMap<KeyType, ValueType> map = new HashMap<>();
	 
	  ?2) Basic CRUD
	     map.put(key, value);           // add or replace value for key
	     map.get(key);                  // returns value or null if not found
	     map.getOrDefault(key, def);    // value if exists, else def
	     map.remove(key);               // remove by key
	     map.remove(key, value);        // remove only if key maps to value
	 
	  ?3) Checks + size
	     map.containsKey(key);          // true if key exists
	     map.containsValue(value);      // true if value exists
	     map.size();                    // number of pairs
	     map.isEmpty();                 // true if no pairs
	     map.clear();                   // remove all entries
	 
	  ?4) Replace/update helpers
	     map.replace(key, newValue);                // replace if key exists
	     map.replace(key, oldValue, newValue);      // replace if current value matches oldValue
	     map.putIfAbsent(key, value);               // put only when key is missing
	 
	  ?5) Iteration
	     for (K key : map.keySet()) { ... }
	     for (V value : map.values()) { ... }
	     for (Map.Entry<K, V> e : map.entrySet()) {
	         K key = e.getKey();
	         V value = e.getValue();
	     }
	 
	  ?6) Useful modern methods
	     map.forEach((k, v) -> System.out.println(k + " -> " + v));
	     map.computeIfAbsent(key, k -> createValue());
	     map.computeIfPresent(key, (k, v) -> updatedValue(v));
	     map.merge(key, value, (oldV, newV) -> combinedValue(oldV, newV));
	 
	  ?7) Notes
	     - Keys are unique.
	     - Values can repeat.
	     - HashMap is NOT ordered.
	     - HashMap is not synchronized (not thread-safe by default).
	 
	 ! Example:
	     HashMap<String, Integer> scores = new HashMap<>();
	     scores.put("Ana", 90);
	     scores.put("Luis", 85);
	     int anaScore = scores.getOrDefault("Ana", 0);
	 */
}
