package exception_file_Handling;

public class UnCheckedException {
	
public static void main(String[] args) {
	
	int arr[]= {1,3,5,7,9};
	try {
		System.out.println(arr[5]);

	} catch (Exception e) {
		System.out.println("Element not found at index");
	}
}
}
