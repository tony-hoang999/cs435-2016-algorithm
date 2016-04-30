/**
 * 
 */
package lab3;

import java.util.Arrays;

/**
 * @author phuongnguyen, longhuynh
 *
 */
public class Prob4_MySort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] test = { 
				{ 2, 2, 0, 1, 1, 0, 0, 0, 1, 1 }, 
				{ 2, 0, 1, 1, 1, 0, 0, 2, 2, 1, 0, 1, 1 }, 
				{ 0, 1, 2, 2, 1, 0, 0, 2, 1 }, 
				{ 2, 0, 0, 1, 0, 0, 1 },
				{ 2, 2, 2, 1, 1, 0, 1, 0, 0, 0 },
				{ 1, 2, 2, 1 } };

		for (int[] arr : test) {
			System.out.println("-----------------");
			Arrays.stream(sort(arr)).forEach(x -> System.out.print(x + " "));
			System.out.println();
		}
	}

	public static int[] sort(int[] arr) {
		int len = arr.length;
		int i1 = len; // index of first 1
		int i2 = len; // index of first 2
		int tmp;

		for (int i = 0; i < len; i++) {
			if (arr[i] == 0) {
				if (i > i1) {
					// swap 0 <-> 1
					arr[i1] = 0;
					arr[i] = 1;
					
					// update index of first 1
					if (arr[i1 + 1] == 1) {
						i1++; // index of first 1 now is the index of next item of 1
					} else {
						i1 = i;
					}
				} 
				else if (i > i2) {
					// swap 0 <-> 2
					arr[i2] = 0;
					arr[i] = 2;
					
					// update index of first 2
					if (arr[i2 + 1] == 2) {
						i2++; // index of first 2 now is the index of next item of 2
					} else {
						i2 = i;
					}
				}
			}
			if (arr[i] == 1) {
				// set i1 in first time
				if (i1 == len) {
					i1 = i;
				}

				if (i > i2) {
					// swap 1 <-> 2
					arr[i2] = 1;
					arr[i] = 2;
					
					// update index of first 2
					tmp = i2;
					if (arr[i2 + 1] == 2) {
						i2++; // index of first 2 now is the index of next item of 2
					} else {
						i2 = i;
					}
					
					// update index of first 1
					if (tmp < i1) {
						i1 = tmp;
					}
				}

			}
			if (arr[i] == 2) {
				// set i2 in first time
				if (i2 == len) {
					i2 = i;
				}
			}
		}

		return arr;
	}

}
