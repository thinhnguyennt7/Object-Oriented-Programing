// You can create a map using one of its three concrete classes: 
// HashMap, LinkedHashMap, or TreeMap.

// HashMap: in random order -> efficient for locating a value, inserting an entry, and deleting an entry.

// LinkedHashMap: in order -> extends HashMap 
	// To construct a LinkedHashMap with the access order, use LinkedHashMap(initialCapacity, loadFactor, true).

// TreeMap: in sorted order -> The keys can be sorted using the Comparable interface or the Comparator interface
	// 


// A map is a container object that stores a collection of key/value pairs.

// Functions for map

// +clear(): void
// +containsKey(key: Object): boolean
// +containsValue(value: Object): boolean
// +entrySet(): Set<Map.Entry<K,V>> +get(key: Object): V
// +isEmpty(): boolean
// +keySet(): Set<K>
// +put(key: K, value: V): V
// +putAll(m: Map<? extends K,? extends
// V>): void
// +remove(key: Object): V +size(): int
// +values(): Collection<V>
// +getKey(): K
// +getValue(): V
// +setValue(value: V): void

import java.util.*;

public class TestMap {
	public static void main(String[] args) {
		// Create a HashMap
		Map<String, Integer> hashmap = new HashMap<>();
		hashmap.put("thinh", 7);
		hashmap.put("Nina", 9);
		hashmap.put("Tuan", 10);

		// Create a treemap from the preceding hashmap
		Map<String, Integer> treemap = new TreeMap<>(hashmap);

		// Create a linkedHashMap
		Map<String, Integer> linkedhashmap = new LinkedHashMap<>(16, 0.75f, true); // (initialCapacity, loadFactor, true)
		linkedhashmap.put("thinh", 7);
		linkedhashmap.put("Nina", 9);
		linkedhashmap.put("Tuan", 10);
	}
}


