package lab1;

import java.util.Scanner;

/*
 * Greatest Common Divisor Algorithm
 */

public class prob1 {

	public static void main(String[] args) {
		Scanner cs = new Scanner(System.in);
        int a = cs.nextInt();
        int b = cs.nextInt();
        System.out.println(gcd(a, b));
        cs.close();
	}
	
	public static int gcd(int a, int b) {
		int tmp;
		while (b > 0) {
			tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}

}
