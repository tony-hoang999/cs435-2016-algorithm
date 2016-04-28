package lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class prob2 {
	
	public static void main(String[] args) {
		List<Integer> s = new ArrayList<Integer>();
		int k;
		
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
		}
		
		return null;
	}
}
