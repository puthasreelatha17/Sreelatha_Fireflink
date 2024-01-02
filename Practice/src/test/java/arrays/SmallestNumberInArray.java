package arrays;

public class SmallestNumberInArray {

	public static void main(String[] args) {
		int arr[] = { 2, 7, 1, 4, 11,6};
		int min=arr[0];
		 for (int i = 0; i < arr.length; i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
System.out.println(min);
	}

}
