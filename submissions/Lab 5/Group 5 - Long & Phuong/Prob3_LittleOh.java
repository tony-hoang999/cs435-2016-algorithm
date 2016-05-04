/**
 * 
 */
package lab5;

import java.util.Arrays;

/**
 * @author phuongnguyen, longhuynh
 *
 *         Problem: Give an o(n) (“little-oh”) algorithm for determining whether
 *         a sorted array A of distinct integers contains an element m for which
 *         A[m] = m.
 */
public class Prob3_LittleOh {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// a sorted array A of distinct integers
		int[][] test = { { -4, -3, 1, 3, 5, 6, 8, 10, 15 }, // test[3] = 3: found
				{ -2, -1, 0 }, // -1: not found
				{ -1, 1},
				{ 0, 2, 3}
		 };
		for (int[] t : test) {
			System.out.println("--------------------");
			System.out.println(Arrays.toString(t));
			System.out.println(search(t));
		}
	}
	
	public static int search(int[] arr) {
		if (arr[0] == 0) {
			return 0;
		}
		
		return binarySearch(arr, 0, arr.length - 1);
	}
	
	public static int binarySearch(int[] arr, int lowerBound, int upperBound) {
		if (lowerBound > upperBound) {
			return -1;
		}
		int mid = (lowerBound + upperBound)/2;
		if (arr[mid] == mid) {
			return mid;
		} else if (arr[mid] < mid) {
			return binarySearch(arr, mid + 1, upperBound);
		} else if (arr[mid] > mid) {
			return binarySearch(arr, lowerBound, mid - 1);
		}
		return -1;
	}

}
