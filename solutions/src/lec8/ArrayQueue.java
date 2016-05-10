/**
 * 
 */
package lec8;

import java.util.Arrays;

/**
 * @author 985109
 *
 */
@SuppressWarnings("unchecked")
public class ArrayQueue<AnyType> implements QueueInterface<AnyType> {
	private static final int DEFAULT_CAPACITY = 10;
	private int cap; // total number of elements in the queue
	private int cur; // current number of elements
	private int front; // front index
	private int back; // back index
	private AnyType[] A;

	/**
	 * Creates a new empty queue.
	 */
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates a Stack of the size initialCapacity
	 */
	public ArrayQueue(int initialCapacity) {
		if (initialCapacity <= 0) {
			cap = DEFAULT_CAPACITY;
			A = (AnyType[]) new Object[DEFAULT_CAPACITY];
		}

		else {
			cap = initialCapacity;
			A = (AnyType[]) new Object[initialCapacity];
		}

		// queue is empty
		back = -1;
		front = 0;
	}

	/**
	 * Tests if the queue is logically empty.
	 *
	 * @return true if the queue is empty and false otherwise
	 */
	public boolean isEmpty() {
		return cur == 0;
	}

	/**
	 * Puts a value into the back of the queue. It works with wrap-around. If
	 * the queue is full, it doubles its size.
	 *
	 * @param value
	 *            the item to insert.
	 */
	public void enqueue(AnyType value) {
		if (isFull())
			throw new QueueException("Queue is full. Cannot enqueue");

		back++;
		if (back == A.length) {
			back = 0;
		}

		A[back] = value;
		cur++;
	}

	/**
	 * Returns the first element in the queue.
	 *
	 * @return element at front of the queue
	 * @throws NoSuchElementException
	 *             if the queue is empty.
	 */
	public AnyType getFront() {
		if (isEmpty())
			throw new QueueException("Queue is empty.");
		else
			return A[front];
	}

	/**
	 * Returns and removes the front element of the queue. It works with
	 * wrap-around.
	 *
	 * @return element at front of the queue
	 * @throws NoSuchElementException
	 *             if the queue is empty.
	 */
	public AnyType dequeue() {
		AnyType e = getFront();
		A[front] = null; // for garbage collection
		front++;
		if (front == A.length) {
			front = 0;
		}
		cur--;
		return e;
	}

	/**
	 * Makes the queue physically empty.
	 *
	 */
	public void clear() {
		for (int i = 0; i < cap; i++)
			A[i] = null;

		cur = 0;
		back = -1;
		front = 0;
	}

	/**
	 * Tests if the queue is logically full
	 */
	public boolean isFull() {
		return cur == cap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (isEmpty())
			return "[ ]";

		StringBuffer out = new StringBuffer("ArrayQueue [cap=");
		out.append(cap).append(", cur=").append(cur).append(", front=").append(front).append(", back=").append(back)
				.append(", A=").append(Arrays.toString(A)).append("]");
		return out.toString();
	}

	public static void main(String[] args) {
		QueueInterface<Integer> q = new ArrayQueue<Integer>();
		try {
			// clear all elements
			q.clear();
			System.out.println(q);
			
			// Initialize
			for (int i = 0; i < 10; i++) {
				q.enqueue(i);
			}
			System.out.println(q);

			// dequeue when it is full
			System.out.println(q.dequeue());
			System.out.println(q);
			// dequeue the 2nd
			System.out.println(q.dequeue());
			System.out.println(q);

			// getFront at that time
			System.out.println(q.getFront());
			System.out.println(q);

			// enqueue, expected it is inserted at the 0 position
			q.enqueue(10);
			System.out.println(q);

			// enqueue, expected it is inserted at the 1 position
			q.enqueue(11);
			System.out.println(q);

			// dequeue from 2nd position to the end of queue
			// expected front = 0
			for (int i = 0; i < 8; i++) {
				q.dequeue();
			}
			System.out.println(q);

			// enqueue from 2nd position to the end of queue
			for (int i = 12; i < 20; i++) {
				q.enqueue(i);
			}
			System.out.println(q);
			// Then add one more element. Expected it throws QueueException due
			// to full
			q.enqueue(20);
		} catch (StackException e) {
			System.err.println(e);
		}

	}
}

/** QueueInterface **/
interface QueueInterface<AnyType> {
	/**
	 * Tests if the Queue is empty.
	 */
	public boolean isEmpty();

	/**
	 * Removes and returns the front item
	 */
	public AnyType dequeue() throws QueueException;

	/**
	 * Returns the front item without its removal
	 */
	public AnyType getFront() throws QueueException;

	/**
	 * Inserts an item to the back
	 */
	public void enqueue(AnyType e) throws QueueException;

	/**
	 * Removes all items from the Queue.
	 */
	public void clear();
}

/** QueueException **/
class QueueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueueException(String name) {
		super(name);
	}

	public QueueException() {
		super();
	}
}
