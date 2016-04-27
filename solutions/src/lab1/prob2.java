/**
 * 
 */
package lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author phuongnguyen
 * 
 *         Problem 2: SubsetSum.
 * 
 *         You are given a set S = {s0, s1, . . ., sn−1} of positive integers
 *         and a non-negative integer k; S and k are inputs to your algorithm.
 *         Your algorithm will return "true" if there is a subset T of S such
 *         that the sum of the elements of T is precisely k, “false,” otherwise.
 *
 */
public class prob2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> s = new ArrayList<Integer>();
		int k;
		
//		Scanner cs = new Scanner(System.in);
//		// enter the length of S
//        int n = cs.nextInt();
//        
//        // enter positive integers of S
//        for (int i = 0; i < n; i++) {
//        	s.add(cs.nextInt());
//        }
//        
//        // enter a non-negative integer k
//        k = cs.nextInt();
		
		s.add(1);
		s.add(2);
		s.add(4);
		s.add(6);
		s.add(5);
		k = 9;
        
		// get subset T
        List<Integer> result = subsetSum(s, k);
        
        if (result == null){
        	System.out.println("Not found.");
        }
        else {
        	System.out.println("subset T:");
        	result.forEach(System.out::println);
        }
        	
//        cs.close();
	}
	
	public static List<Integer> subsetSum(List<Integer> s, int target) {
		List<Integer> left = new ArrayList<Integer>();
		int sumLeft = 0;
		int item = 0;
		int size;
		
		// new list in which all elements is less than k
		for (int i : s) {
			if (i > target) {
				s.remove(i);
			}
		}
		// sort new list ASC
		Collections.sort(s);
		
		size = s.size();
		// go through array S
		for (int i = 0; i < size; i++) {
			for (int leftSize = i + 1; leftSize < size; leftSize++) {
				// reset left and sumLeft
				left = new ArrayList<Integer>();
				sumLeft = 0;
				
				// go through LEFT and calculate sumLeft
				for (int j = 0; j < leftSize; j++) {
					sumLeft += s.get(j);
					left.add(s.get(j));
				}
				
				// go though RIGHT and calculate sumLeft with each element in list
				// if found sumLeft + item == target then return list of LEFT
				// if sumLeft + item > target then NOT DO ANYTHING MORE
				for (int k = leftSize; k < size; k++) {
					item = s.get(k);
					if (sumLeft + item == target) {
						left.add(item);
						return left;
					}
					else {
						if (sumLeft + item > target) {
							break;
						}
					}
				}
			}
//			int leftSize = i + 1;
//			
//			while (leftSize < size) {
//				// reset left and sumLeft
//				left = new ArrayList<Integer>();
//				sumLeft = 0;
//				
//				// go through LEFT and calculate sumLeft
//				for (int j = 0; j < leftSize; j++) {
//					sumLeft += s.get(j);
//					left.add(s.get(j));
//				}
//				
//				// go though RIGHT and calculate sumLeft with each element in list
//				// if found sumLeft + item == target then return list of LEFT
//				// if sumLeft + item > target then NOT DO ANYTHING MORE
//				for (int k = leftSize; k < size; k++) {
//					item = s.get(k);
//					if (sumLeft + item == target) {
//						left.add(item);
//						return left;
//					}
//					else {
//						if (sumLeft + item > target) {
//							break;
//						}
//					}
//				}
//				
//				// increase leftSize
//				leftSize ++;
//			}
		}
		
		return null;
	}

}
