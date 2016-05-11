/**
 * 
 */
package lec8;

import java.util.NoSuchElementException;

/**
 * @author 985109
 *
 */
public class DoublyLinkedList<AnyType> {
	/*******************************************************
	 *
	 * The Node class
	 *
	 ********************************************************/
	private static class Node<AnyType> {
		private AnyType data;
		private Node<AnyType> prev;
		private Node<AnyType> next;

		public Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	private Node<AnyType> head;

	/**
	 * Constructs an empty list
	 */
	public DoublyLinkedList() {
		head = null;
	}

	/**
	 * Returns true if the list is empty
	 *
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Removes all nodes from the list.
	 *
	 */
	public void clear() {
		head = null;
	}

	/**
	 * Returns x if this list contains the specified element.
	 *
	 */
	public Node<AnyType> search(AnyType data) {
		Node<AnyType> x = head;
		while (x != null) {
			if (x.data == data) {
				return x;
			}
			x = x.next;
		}

		return null;
	}
	
	 /**
	 * Inserts a new node at the beginning of this list.
	 *
	 */
	 public void insertFirst(AnyType item) {
		 head = new Node<AnyType>(item, null, head);
		 if (head.next != null) {
			 head.next.prev = head;
		 }
	 }
	 
	 /**
	 * Inserts a new node at the beginning of this list.
	 *
	 */
	 public void insertFirst(Node<AnyType> x) {
		 x.next = head;
		 if (head != null) {
			 head.prev = x;
		 }
		 head = x;
		 x.prev = null;
	 }
	
	 /**
	 * Returns the first element in the list.
	 *
	 */
	 public AnyType getFirst() {
		 if (head == null)
			 throw new NoSuchElementException();
		
		 return head.data;
	 }
	
	 /**
	 * Removes the first element in the list.
	 *
	 */
	 public AnyType deleteFirst() {
		 AnyType tmp = getFirst();
		 head = head.next;
		 return tmp;
	 }
	 
	 /**
	 * Removes the first element in the list.
	 *
	 */
	 public void delete(Node<AnyType> x) {
		 if (x.prev != null) {
			 x.prev.next = x.next;
		 }
		 else {
			 head = x.next;
		 }
		 
		 if (x.next != null) {
			 x.next.prev = x.prev;
		 }
	 }
	 
	/**
	 * Returns a string representation
	 *
	 */
	public String toString() {
		if (head != null) {
			StringBuffer result = new StringBuffer();
			Node<AnyType> x = head;
			while (x != null) {
				result.append(String.valueOf(x.data) + " ");
				x = x.next;
			}

			return result.toString();
		} else {
			return "";
		}
	}
	
	 /***** Include the main() for testing and debugging *****/
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		// Initialize
		list.insertFirst(1);
		list.insertFirst(4);
		list.insertFirst(16);
		list.insertFirst(9);
		System.out.println(list);
		
		// insert new node of 25
		list.insertFirst(25);
		System.out.println(list);
		
		// delete node of 4
		list.delete(list.search(4));
		System.out.println(list);

		// delete first node
		list.deleteFirst();
		System.out.println(list);
	}
}
