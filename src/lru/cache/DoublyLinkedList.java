package lru.cache;

/**
 * 
 * @author Vaibhav
 *
 * Doubly linked list Implementation helper methods
 */
public class DoublyLinkedList {

	private Node head;
	private Node tail;

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}


	/**
	 * Remove element from linked list
	 * 
	 * @param node
	 */
	public void remove(Node node) {
		if (node != null) {
			// Single Element in list
			if (node.getPrev() == null && node.getNext() == null) {
				head = null;
				tail = null;
			}
			// Element present at head
			else if (node.getPrev() == null) {
				node.getNext().setPrev(null);
				head = node.getNext();
			}
			// Element present at tail
			else if (node.getNext() == null) {
				node.getPrev().setNext(null);
				tail = node.getPrev();
			}
			// Element Present in between
			else {
				node.getPrev().setNext(node.getNext());
				node.getNext().setPrev(node.getPrev());
				node.setPrev(null);
				node.setNext(null);
			}
		}
	}

	/**
	 * Remove entry from tail
	 */
	public int removeFromTail() {
		int key = tail.getKey();
		remove(tail);
		return key;
	}

	/**
	 * Add to head of linked list,update head and tail via reference
	 * 
	 * @param node
	 * @param head
	 * @param tail
	 */
	public void addToHead(Node node) {
		if (node != null) {
			if (head != null) {
				node.setNext(head);
				head.setPrev(node);
			}
			head = node;
			if (tail == null)
				tail = node;
		}
	}

}
