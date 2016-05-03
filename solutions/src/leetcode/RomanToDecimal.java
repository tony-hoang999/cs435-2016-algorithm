package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {
	public static void main(String[] args) {	
		String[] test = { "II", "V", "XIV", "XIX", "XL", "MXL", "MCMXCVI" };
		for (String s : test) {
			System.out.print("Roman: " + s + ", Decimal = ");
//			System.out.println(convertRomanToDecimal(s));
			System.out.println(romanToInt(s));
		}
	}
	
	// runtime on leetcode: 15 ms
	public static int convertRomanToDecimal(String s) {
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		dict.put('I', 1);
		dict.put('V', 5);
		dict.put('X', 10);
		dict.put('L', 50);
		dict.put('C', 100);
		dict.put('D', 500);
		dict.put('M', 1000);
		
		char[] chars = s.toCharArray();
		int last = chars.length - 1;
		char prev = chars[last];
		int retVal = dict.get(prev);
		
		for (int i = last - 1; i > -1; i--) {
			if (dict.get(chars[i]) < dict.get(prev)) {
				retVal -= dict.get(chars[i]);
			}
			else {
				retVal += dict.get(chars[i]);
			}
			prev = chars[i];
		}
		
		return retVal;
	}
	
	// runtime on leetcode: 8 ms
	public static int romanToInt(String s) {
		// runtime on leetcode: 7 ms 
		int n = s.length();
		
		int[] in = new int[n];
		// runtime on leetcode: 7 ms
		char[] chars = s.toCharArray();
		for (int i = 0; i < n; i++) {
			if (chars[i] == 'I') {
				in[i] = 1;
			}
			else if (chars[i] == 'V') {
				in[i] = 5;
			}
			else if (chars[i] == 'X') {
				in[i] = 10;
			}
			else if (chars[i] == 'L') {
				in[i] = 50;
			}
			else if (chars[i] == 'C') {
				in[i] = 100;
			}
			else if (chars[i] == 'D') {
				in[i] = 500;
			}
			else if (chars[i] == 'M') {
				in[i] = 1000;
			}
		}
		
		int val = 0;
		int retVal = in[n - 1];
		int prev = retVal;
		for (int i = n - 2; i > -1; i--) {
			val = in[i];
			if (val < prev) {
				retVal -= val;
			} else {
				retVal += val;
			}
			prev = val;
		}
		
		return retVal;
	}
	
	// runtime on leetcode is 6 ms
	static int[] dict = new int [128];
	
	static {
		dict['I'] = 1;
		dict['V'] = 5;
		dict['X'] = 10;
		dict['L'] = 50;
		dict['C'] = 100;
		dict['D'] = 500;
		dict['M'] = 1000;
	}
	
	public int convertRomanToInt(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		
		int val = 0;
		int retVal = dict[chars[n - 1]];
		int prev = retVal;
		
		for (int i = n - 2; i > -1; i--) {
			val = dict[chars[i]];
			if (val < prev) {
				retVal -= val;
			} else {
				retVal += val;
			}
			prev = val;
		}
		
		return retVal;

	}
}
