package lru.cache;

/**
 * 
 * @author Vaibhav
 *
 * Node class 
 */
public class Node {

	private int key;
	private int value;
	private Node prev;
	private Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
