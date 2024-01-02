package arrays;

public class LargestNumberInArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 7, 4, 11,6};
		int max=arr[0];
		 for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
System.out.println(max);
	}

}
