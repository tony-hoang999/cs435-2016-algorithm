/**
 * 
 */
package labExtra;

/**
 * @author phuongnguyen, longhuynh
 *
 *         Problem: Design an O(log n) algorithm to calculate Fibonacci numbers
 * 
 *         Solution: Another O(n) which relies on the fact that if we n times
 *         multiply the matrix M = {{1,1},{1,0}} to itself (in other words
 *         calculate power(M, n )), then we get the (n+1)th Fibonacci number as
 *         the element at row and column (0, 0) in the resultant matrix.
 * 
 *         The matrix representation gives the following closed expression for
 *         the Fibonacci numbers:
 *         [ {1 1} {1 0} ]^n = [ {F(n+1) F(n)} { F(n) F(n-1)} ]
 */
public class FiboWithOLogN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 7; i++) {
			System.out.println("i = " + i + ", Fibo = " + fibonacci(i));
		}
	}

	public static int fibonacci(int n) {
		int[][] f = { { 1, 1 }, { 1, 0 } };
		if (n < 2)
			return n;
		power(f, n - 1);
		return f[0][0];
	}

	public static void power(int[][] f, int n) {
		if (n == 0 || n == 1)
			return;

		int[][] m = { { 1, 1 }, { 1, 0 } };

		// Start optimize from O(n)
		// n - 1 times multiply the matrix to {{1,0},{0,1}}
		// for (i = 2; i <= n; i++) {
		// multiply(f, m);
		// }
		// to O(log n) by using Algorithmic Paradigm: Divide and conquer
		// Ideally, base on the power(x, y)
		// temp = power(x, y/2);
		power(f, n / 2);
		// if (y%2 == 0) return temp*temp;
		multiply(f, f);
		// else return x*temp*temp;
		if (n % 2 != 0)
			multiply(f, m);
		// End optimize
	}

	// multiply 2-dimensional arrays
	public static void multiply(int[][] f, int[][] m) {
		int x = f[0][0] * m[0][0] + f[0][1] * m[1][0];
		int y = f[0][0] * m[0][1] + f[0][1] * m[1][1];
		int z = f[1][0] * m[0][0] + f[1][1] * m[1][0];
		int w = f[1][0] * m[0][1] + f[1][1] * m[1][1];

		f[0][0] = x;
		f[0][1] = y;
		f[1][0] = z;
		f[1][1] = w;
	}
}
