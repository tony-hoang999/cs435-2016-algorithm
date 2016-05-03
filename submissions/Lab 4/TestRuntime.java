/**
 * 
 */
package lab4;

import java.util.Random;

/**
 * @author 985109
 *
 */
public class TestRuntime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = {100, 1000, 10000, 100000, 1000000, 10000000 };
		for (int i : test) {
			System.out.println("Total elements: " + i);
			printRunningTime(generateRandomArray(i));
			System.out.println();
		}
		
	}
	
	public static void printRunningTime(int[] arr) {
		long start = 0;
		long end = 0;
		MergeSort ms = new MergeSort();
		MergeSortPlus msp = new MergeSortPlus();
		
		int[] arrMS = new int[arr.length];
		System.arraycopy(arr, 0, arrMS, 0, arr.length);
		
		int[] arrMSP = new int[arr.length];
		System.arraycopy(arr, 0, arrMSP, 0, arr.length);
		
		System.out.print("\tMerge Sort (ms): ");
		start = System.currentTimeMillis();
		ms.sort(arrMS);
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		System.out.print("\tMerge Sort Plus (ms): ");
		start = System.currentTimeMillis();
		msp.sort(arrMSP);
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int[] generateRandomArray(int n) {
		int[] arr = new int[n];
		Random rd = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = rd.nextInt(n);
		}
		
		return arr;
	}
}
