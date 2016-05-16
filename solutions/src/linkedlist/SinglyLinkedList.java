package linkedlist;

public class SinglyLinkedList {
		private Node head;  //zeroth element
		SinglyLinkedList(){
		}
		
		/** Returns the input item wrapped in a Node */
		public Node add(String item){
			if(head == null) {
				head = new Node(null, item);
			}
			else {
				head = new Node(head, item);
			}
				
			
			return head;
		}
		private Node getNode(int pos){
			if (pos >= size()) throw new IndexOutOfBoundsException();
			int pointer = 0;
			Node node = head;
			while(++pointer <= pos) {
				node = node.next;
			}
			
			//node is the node we are seeking
			return node;
		}
		
		public String get(int pos){
			Node node = getNode(pos);
			return (node != null) ? node.value : null;
		}
		/** returns the index of the String s, if found; 
		 * -1 otherwise 
		 */
		public int find(String s){
			if(s == null) return -1;
			Node currentNode = head;
			int i = -1;
			while(currentNode != null){
				++i;
				if(s.equals(currentNode.value)) return i;	
				currentNode = currentNode.next;
				
			}
			return -1;
		}
		
		
		public void insert(String s, int pos) {
			//corrected to throw exception
			if(pos > size()) {
				throw new IndexOutOfBoundsException("pos = "+pos +" but size = "+size());
			}
			if(pos == 0) {
				add(s);
			}
			else {
				Node next = head;
				Node previous = null;
				for(int i = 0; i < pos; ++i){
					previous = next;
					next = next.next;
				}
				Node insertNode = new Node(next,s);
				previous.next = insertNode;
			}
			
		}

		/** remove object at specified index */
		public boolean remove(int index){
			Node toBeRemoved = getNode(index);
			Node previous = null;
			if(index > 0) {
				previous = getNode(index-1);
			}
			if(toBeRemoved == null) return false;
			Node next = toBeRemoved.next;
			if(previous != null)
                previous.next = toBeRemoved.next;
			toBeRemoved = null;
			return true;
		}
		/** remove by specifying object -- removes
		 *  first occurrence of s
		 */
		public boolean remove(String s){
			int pos = find(s);
			if(pos == -1) return false;
			return remove(pos);
			
		}	
		
		public int size(){
			int count = 0;
			Node next = head;
			while(next != null){
				++count;
				next = next.next;
			}
			return count;
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder("[");
			Node next = head;
			while(next != null){
				sb.append(next.value+", ");
				next = next.next;
			}
			String ret = sb.toString();
			ret = ret.substring(0,ret.length()-2);
			return (ret +"]");
		}
		/******* sorting methods ********/



		/********* end sorting methods ********/
		
		
		
		class Node  {
			String value;
			Node next;
			Node(){}
			Node(Node next, String value){
				this.next = next;
				this.value = value;
			}
			public String toString(){
				return value;
			}
		}

		public static void main(String[]args){
			SinglyLinkedList l = new SinglyLinkedList();
			l.add("D");
			l.add("C");
			l.add("B");
			l.add("A");
			System.out.println(l);
			l.remove("C");
			System.out.println(l);
			l.insert("E", 1);
			System.out.println(l);
			l.add("WW");
			System.out.println(l);
			System.out.println(l.head.value);
			System.out.println(l.size());
			l.remove("E");
			System.out.println(l);
			
			l.meiLiReverse();
			System.out.println(l);
		}
		
		/**
		 * The algorithm: remove A[1] and add it to the front.
		 * Then remove A[2] and add it to the front. And so forth.
		 */
		public void meiLiReverse() {
			System.out.println("begin Mei Li reversal...");
			//counter for printing only
			int counter = 0;
			System.out.println("starting state: " + this);
			Node left = head;
			if(left == null || left.next == null) return;
			Node middle = null;
			do {
				middle = removeNext(left);
				add(middle);
				middle = left.next;
				System.out.println("after pass #" + (counter++) + ": " + this);
				
			} while(middle != null);
		}
		
		private void add(Node n) {
			if(head == null) {
				head = n;
			} else {
			    n.next = head;
				head = n;
			}
		}
		
		/** 
		 *  Removes the node left.next (if it's not null) by linking
		 *  left to left.next.next
		 */
		private Node removeNext(Node left) {
			Node middle = left.next;
			if(middle == null) return null;
			Node right = middle.next;
			//link left to right, excluding middle
			left.next = right;
			//return middle
			return middle;	
		}
		
		/**
		 * Internet solution. It works but it's a bit mysterious!
		 */
		public void reverse() {
			System.out.println("begin reversal...");
			//counter for printing only
			int counter = 0;
			System.out.println("starting state: " + this);
		    Node current = head;
		    head = null;
		    while (current != null) {
		        Node save = current;
		        current = current.next;
		        save.next = head;
		        head = save;
		        System.out.println("after pass #" + (counter++) + ": " + this);
		    }
		}
	}


