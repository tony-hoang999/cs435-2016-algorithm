/**
 * 
 */
package lab4;

import java.util.Arrays;

/**
 * @author phuongnguyen, longhuynh
 *
 *         Problem: MergeSortPlus (MergeSort + InsertionSort) 
 *         
 *         Input: unsorted array 
 *         
 *         Output: sorted array
 * 
 */

public class MergeSortPlus {
	// global storage to hold the sorted array
	int[] sortedArray;
	// constant of an array with 20 or fewer elements
	final int THRESHOLD = 21;

	// public sorter
	public int[] sort(int[] input) {
		int n = input.length;
		int[] tempStorage = new int[n];
		sortedArray = input;
		mergeSort(tempStorage, 0, n - 1);
		return sortedArray;
	}

	// mergeSort(array, lowerbound, upperboud)
	public void mergeSort(int[] array, int lb, int ub) {
		if (lb == ub) {
			return;
		}

		if ((ub - lb) < THRESHOLD) {
			insertionSort(lb, ub);
		} else {
			int mid = (lb + ub) / 2;

			// sort left half
			mergeSort(array, lb, mid);

			// sort right half
			mergeSort(array, mid + 1, ub);

			// merge left and right
			merge(array, lb, mid + 1, ub);
		}
	}

	// insertionSort(lowerbound, upperbound)
	public void insertionSort(int lb, int ub) {
		if (sortedArray == null || sortedArray.length < 2) {
			return;
		}

		int len = ub + 1;
		int tmp;
		int j;
		for (int i = lb; i < len; i++) {
			tmp = sortedArray[i];
			j = i;
			while (j > lb && tmp < sortedArray[j - 1]) {
				sortedArray[j] = sortedArray[j - 1];
				j--;
			}
			sortedArray[j] = tmp;
		}
	}

	// merge 2 arrays: [lowerPointer, upperPointer - 1] and [upperPointer,
	// upperBound]
	public void merge(int[] array, int lp, int up, int ub) {
		// lower bound
		int lb = lp;	
		// total elements need to be re-arrange
		int n = ub - lb + 1;	

		int mid = up - 1;	
		// merge [lowerBound, mid] and [mid + 1, upperBound]
		int j  = 0; //index of array
		while (lp <= mid && up <= ub) {
			if (sortedArray[lp] < sortedArray[up]) {
				array[j++] = sortedArray[lp++];
			} else {
				array[j++] = sortedArray[up++];
			}
		}
		// left array might still have elements
		while (lp <= mid) {
			array[j++] = sortedArray[lp++];
		}
	
		// right array might still have elements
		while (up <= ub) {
			array[j++] = sortedArray[up++];
		}
	
		//replace the range [lowerBound, upperBound] in sortedArray with 
		//the range [0, n-1] just created in array
		for (j=0; j<n; ++j) {
		      sortedArray[lb + j] = array[j];
		}	
	}
	
	public static void main(String[] args) {
		int[] arr = {2,4,7,13, 25, 35, 25, 2, 0, 29, 30};
		MergeSortPlus msp = new MergeSortPlus();
		
		System.out.println("Original array:");
		System.out.println(Arrays.toString(arr));
		
		msp.sort(arr);
		System.out.println("Sorted array:");
		System.out.println(Arrays.toString(arr));
	}

}