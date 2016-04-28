package lab2;

public class Problem2 {

	public static void main(String[] args) {
		int[] array1 = new int[] {1, 4, 5, 8, 17};
		int[] array2 = new int[] {2, 4, 8, 11, 13, 21, 23, 25};
		int[] result = merge(array1, array2);
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] merge(int array1[], int array2[]) {
		int end1 = array1.length - 1;
		int end2 = array2.length - 1;
		int newLength = array1.length + array2.length;
		int[] newArray = new int[newLength];
				
		while (newLength > 0) {
			newLength--;
			if (end2 < 0 || (end1 >= 0 && array1[end1] > array2[end2]))
				newArray[newLength] = array1[end1--];
			else
				newArray[newLength] = array2[end2--];	
		}		
		return newArray;
	}
}