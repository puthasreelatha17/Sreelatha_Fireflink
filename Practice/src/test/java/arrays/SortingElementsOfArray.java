package arrays;

public class SortingElementsOfArray {

	public static void main(String[] args) {
		int arr[] = { 1,6 ,2, 7, 2,4, 11,6};
		int temp;
		System.out.println("Before sorting elements in array are:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		 for (int i = 0; i < arr.length; i++) {
		
			 for (int j = i+1; j < arr.length; j++) {
					if (arr[i]>arr[j]) {
						temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
					}
				}
		}
		 System.out.println();
		 System.out.println("After sorting elements in array are:");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
	}	

}
