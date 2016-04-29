/**
 * 
 */
package lab2_continue;

/**
 * @author phuongnguyen, longhuynh
 *
 */
public class Prob4_Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 7; i++) {
			System.out.println("i = " + i + ", Fibo = " + fibonacci(i));
		}
	}

	public static int fibonacci(int n) {
		int f0 = 0;
		int f1 = 1;
		
		if (n == 0) {
			return f0;
		}
		if (n == 1) {
			return f1;
		}
		
		for (int i = 1; i < n; i++) {
			f1 = f0 + f1;
			f0 = f1 - f0;
		}
		
		return f1;
	}
}
