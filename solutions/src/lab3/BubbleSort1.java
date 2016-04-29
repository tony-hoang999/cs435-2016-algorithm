package lab3;

public class BubbleSort1 {

	public static void main(String[] args) {
		int[] items = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		items = Sort(items);
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i] + " ");
		}
	}

	// If parameter is sorted list
	// The if clause in for loop never happen
	// That's mean swapped = false;
	// So O(n) for this solution
	public static int[] Sort(int[] items) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < items.length; i++) {
				if (items[i - 1] > items[i]) {
					int temp = items[i - 1];
					items[i - 1] = items[i];
					items[i] = temp;
					swapped = true;
				}
			}
		} while (swapped);

		return items;
	}

}
