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
public class ArrayStack<AnyType> implements StackInterface<AnyType> {
	private static final int DEFAULT_CAPACITY = 15;
	private int top; // reference to the top element
	private AnyType[] A;

	/**
	 * Creates a Stack of the size initialCapacity
	 */
	public ArrayStack(int initialCapacity) {
		if (initialCapacity <= 0)
			A = (AnyType[]) new Object[DEFAULT_CAPACITY];
		else
			A = (AnyType[]) new Object[initialCapacity];

		top = -1; // stack is empty
	}

	/**
	 * Creates a Stack with the default capacity
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Tests if the stack is empty.
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Returns the top item without its removal.
	 */
	public AnyType peek() {
		if (isEmpty())
			throw new StackException("Stack is empty");
		return A[top];
	}

	/**
	 * Removes and returns the item at the top of this stack.
	 */
	public AnyType pop() {
		AnyType x = peek();
		A[top] = null; // make sure the object is destroyed
		top--;
		return x;
	}

	/**
	 * Inserts an item onto the top of the stack.
	 */
	public void push(AnyType e) {
		if (top == A.length)
			doubleSize();	// Stack has overflowed
		top++;
		A[top] = e;
	}

	/**
	 * Resize the length of stack by doubling current capacity.
	 */
	public void doubleSize() {
		A = Arrays.copyOf(A, A.length * 2);
	}
	
	/**
	 * Removes all items from the Stack.
	 */
	public void clear() {
		for (int i = 0; i <= top; i++)
			A[i] = null;

		top = -1;
	}

	/**
	 * Returns a string representation of the Stack.
	 */
	public String toString() {
		if (isEmpty())
			return "[ ]";

		StringBuffer out = new StringBuffer("[");
		for (int i = 0; i < top; i++)
			out.append(A[i] + ", ");

		out.append(A[top] + "]");
		return out.toString();
	}

	public static void main(String[] args) {
		StackInterface<Integer> s = new ArrayStack<Integer>();

		try {
			 // initialize
			 s.push(15);
			 s.push(6);
			 s.push(2);
			 s.push(9);
			 System.out.println(s);
			
			 // push 17 & 3
			 s.push(17);
			 s.push(3);
			 System.out.println(s);
			
			 // pop(3)
			 System.out.println(s.pop());
			 System.out.println(s);
			
			 // peek(current position)
			 System.out.println(s.peek());

		} catch (StackException e) {
			System.err.println(e);
		}
	}
}

/** StackInterface **/
interface StackInterface<AnyType> {
	/**
	 * Tests if the stack is empty.
	 */
	public boolean isEmpty();

	/**
	 * Removes and returns the item at the top of this stack.
	 */
	public AnyType pop() throws StackException;

	/**
	 * Returns the top item without its removal
	 */
	public AnyType peek() throws StackException;

	/**
	 * Inserts an item onto the top of the stack.
	 */
	public void push(AnyType e) throws StackException;

	/**
	 * Removes all items from the stack.
	 */
	public void clear();
}

/** StackException **/
class StackException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackException(String name) {
		super(name);
	}

	public StackException() {
		super();
	}
}
