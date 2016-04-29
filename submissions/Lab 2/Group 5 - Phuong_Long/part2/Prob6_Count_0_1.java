/**
 * 
 */
package lab2_continue;

import java.util.Arrays;

/**
 * @author phuongnguyen, longhuynh
 *
 */
public class Prob6_Count_0_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = { {0, 0, 1, 1, 0, 0, 1, 0, 1}, 
				{0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1} };
		
		System.out.println("-----------------");
		Arrays.sort(test[0]);
		Arrays.stream(count_0_1(test[0])).forEach(System.out::println);
		
		System.out.println("-----------------");
		Arrays.sort(test[1]);
		Arrays.stream(count_0_1(test[1])).forEach(System.out::println);
		
		System.out.println("-----------------");
		Arrays.sort(test[2]);
		Arrays.stream(count_0_1(test[2])).forEach(System.out::println);
	}
	
	public static int[] count_0_1(int[] arr) {
		int c0 = 0;
		int c1 = 0;
		int i = 0;
		int size = arr.length;
		
		for (; i < size; i++) {
			if (arr[i] == 1) {
				break;	// because this array is sorted ASC from 0 to 1
			}
		}
		
		c0 = i;
		if (i != size) {
			c1 = size - i;
		}
		
		return new int[]{ c0, c1 };
	}
}
