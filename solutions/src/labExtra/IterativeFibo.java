/**
 * 
 */
package labExtra;

/**
 * @author phuongnguyen, longhuynh
 * 
 * Problem: 
 * Design an iterative algorithm to calculate Fibonacci numbers that takes O(n) time, and
 * O(1) space complexity. Use it to calculate the 10,000,000 Fibonacci number. If the result
 * is too large, give it in modulo of 1,000,000,007
 *
 */
public class IterativeFibo {
	protected static final int M = 1000000007;	// 10^9 + 7

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 7; i++) {
			System.out.println("i = " + i + ", Fibo = " + fibonacci(i));
		}
		
		System.out.println("i = 10000000, Fibo = " + fibonacci(10000000));
	}

	public static int fibonacci(int n) {
		int f0 = 0;
		int f1 = 1;
		
		if (n < 0) {
			System.out.println("n cannot be negative number.");
			return -1;
		}
		
		if (n < 2) {
			return n;
		}
		
		for (int i = 1; i < n; i++) {
			f1 = (f0 % M + f1 % M) % M;
			f0 = f1 - f0;
		}
		
		return f1;
	}

}
