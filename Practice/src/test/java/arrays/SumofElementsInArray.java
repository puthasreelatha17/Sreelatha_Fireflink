package arrays;

public class SumofElementsInArray {
	public static void name() {
		int sum = 0;
		int arr[] = { 1, 2, 7, 4, 11, 20 };
		for (int i = 0; i < arr.length; i++) {
			sum = arr[i] + sum;

		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		SumofElementsInArray s = new SumofElementsInArray();
		// s.name();
		name();
	}
}
