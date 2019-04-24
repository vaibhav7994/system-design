package lru.cache;

/**
 * 
 * 
 * @author Vaibhav
 *
 * Demo class to illustrate LRU Cache
 */
public class LRUDemo {

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(5);
		lruCache.put(1, 100);
		lruCache.put(2, 102);
		lruCache.put(3, 103);
		lruCache.put(4, 104);
		lruCache.put(1, 101);
		lruCache.put(5, 105);
		lruCache.put(6, 106);
		lruCache.getValue(2);
		lruCache.getValue(1);
	}
}
