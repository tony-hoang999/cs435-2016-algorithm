/**
 * 
 */
package finalreview.lec8;

import java.util.Arrays;

/**
 * @author 985109
 *
 */
public class MySimpleStack<T> {
	protected static final int SIZE = 20; 
	private T[] values;
	private int top;

	@SuppressWarnings("unchecked")
	MySimpleStack() {
		values = (T[]) new Object[SIZE];
		top = 0;
	}


	public boolean isEmpty(MySimpleStack<T> S) {
		if (S.top == 0) {
			return true;
		}
		
		return false;
	}
	
	public void push(MySimpleStack<T> S, T x) {
		S.top = top + 1;
		if (S.top < getSize(S)) {
			S.values[S.top] = x;
		}
		else {
			resize(S);
		}
	}
	
	public T pop(MySimpleStack<T> S) throws Exception {
		if (isEmpty(S) ) {
			throw new Exception("underflow");
		}
		else {
			S.top = S.top - 1;
			return S.values[S.top];
		}
	}
	
	public void resize(MySimpleStack<T> S) {
		S.values = Arrays.copyOf(S.values, S.values.length * 2);
	}
	
	public int getSize(MySimpleStack<T> S) {
		return S.values.length;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MySimpleStack<Integer> s = new MySimpleStack<Integer>();
		s.push(s, 15);
		s.push(s, 6);
		s.push(s, 2);
		s.push(s, 9);
		
	}
}
