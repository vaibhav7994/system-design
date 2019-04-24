package lru.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Vaibhav
 *
 * Implementation of lru cache
 */
public class LRUCache {

	private int size;
	private Map<Integer, Node> keyNodeMap;
	private DoublyLinkedList doublyLinkedList;

	public LRUCache(int size) {
		this.size = size;
		keyNodeMap = new HashMap<>();
		doublyLinkedList = new DoublyLinkedList();
	}

	/**
	 * Get method of cache
	 * 
	 * @param key
	 * @return
	 */
	public int getValue(int key) {
		// O(1) Complexity
		if (keyNodeMap.containsKey(key)) {
			int value = keyNodeMap.get(key).getValue();
			System.out.println("For key:" + key + " value get is:" + value);
			return value;
		} else {
			System.out.println("For key:" + key + " no value is found");
			return -1;
		}
	}

	/**
	 * Put method of cache
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {
		// O(1) Complexity
		if (keyNodeMap.containsKey(key)) {
			// Replace the value with new value and make it recent
			System.out.println("For key:" + key + " replacing the value with new value:" + value);
			Node node = keyNodeMap.get(key);
			node.setValue(value);
			doublyLinkedList.remove(node);
			doublyLinkedList.addToHead(node);
		} else {
			// New entry in cache
			System.out.println("For key:" + key + " Adding new entry in cache:" + value);
			Node node = new Node(key, value);
			if (keyNodeMap.size() == size) {
				// Evict from cache
				int tailKey = doublyLinkedList.removeFromTail();
				System.out.println("Evicting For key:" + tailKey);
				keyNodeMap.remove(tailKey);
			}

			// Add new node
			doublyLinkedList.addToHead(node);
			keyNodeMap.put(key, node);
		}
	}
}
