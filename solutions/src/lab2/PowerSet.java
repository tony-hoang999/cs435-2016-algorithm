/**
 * 
 */
package lab2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author phuongnguyen, longhuynh
 * 
 *         What is Power Set? In mathematics, the power set (or powerset) of any
 *         set S, written P(S), is the set of all subsets of S, including the
 *         empty set and S itself. Let's understand it with help of example.
 * 
 *         Case 1: Input: Set(S) = [1,2] Output: PowerSet P(S) = [[ ], [2], [1],
 *         [2, 1]]
 * 
 *         Case 2: Input: Set(S) = [a,b,c] Output: PowerSet P(S) = [[ ], [a],
 *         [b], [c], [a,b], [a, c], [b, c], [a, b, c]]
 *
 */
public class PowerSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> test = new ArrayList<String>();
		test.add("a");
		test.add("b");
		test.add("c");

		powserSet(test).stream().sorted((x, y) -> {
			return x.length() - y.length();
		}).forEach(System.out::println);

		// List<String> result = powserSet(test);
		// result.sort(String::compareToIgnoreCase);
		// result.forEach(System.out::println);
	}

	public static List<String> powserSet(List<String> X) {
		String f;
		List<String> P = new ArrayList<String>();
		P.add("[]");
		Set<String> S = new HashSet<String>(); // S is the empty set
		P.addAll(S); // P is now the set { S }

		Set<String> T;
		while (!X.isEmpty()) {
			// f â†? X.removeFirst()
			f = X.get(0);
			X.remove(0);

			// reset T
			T = new HashSet<String>();

			// for each x in P do
			for (String x : P) {
				// T is the set containing f & all elements of x
				// T â†? x U {f}
				if (x.equals("[]")) {
					T.add("[" + f + "]");
				} else {
					T.add("[" + x.substring(1, x.length() - 1) + ", " + f + "]");
				}
			}
			// P.add(T)
			P.addAll(T);
		}

		return P;
	}
}
