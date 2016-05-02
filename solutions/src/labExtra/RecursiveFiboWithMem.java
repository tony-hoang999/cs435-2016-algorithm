/**
 * 
 */
package labExtra;

/**
 * @author phuongnguyen, longhuynh
 * 
 * Problem: Design an recursive algorithm to calculate Fibonacci numbers that takes only O(n)
 * (Instead of exponential times as being proved our class)
 *
 */
public class RecursiveFiboWithMem {
	protected static int[] storage;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 7; i++) {
			storage = new int[i];
			System.out.println("i = " + i + ", Fibo = " + getFiboWithMem(i));
		}
	}
	
	public static int getFiboWithMem(int n) {
		if (storage == null) {
			storage = new int[n];
		}
		
		if (n < 0) {
			System.out.println("n cannot be negative number.");
			return -1;
		}
		
		if (n < 2) {
			return n;
		}
		if (storage[n - 1] == 0) {
			storage[n - 1] = getFiboWithMem(n-1) + getFiboWithMem(n-2);
		}
		
		return storage[n - 1];
	}

}
