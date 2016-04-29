package lab3;

public class BubbleSort2 {

	public static void main(String[] args) {
		int[] items = new int[] { 6, 7, 3, 5, 1, 2, 9 };
		items = Sort(items);
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i] + " ");
		}
	}

	public static int[] Sort(int[] items) {
		boolean swapped;
		int times = 0;
		do {
			swapped = false;
			// times variable will cut the running time of BubbleSort in half.
			for (int i = 1; i < items.length - times; i++) {
				if (items[i - 1] > items[i]) {
					int temp = items[i - 1];
					items[i - 1] = items[i];
					items[i] = temp;
					swapped = true;
				}
			}

			times++;
		} while (swapped);

		return items;
	}
}
