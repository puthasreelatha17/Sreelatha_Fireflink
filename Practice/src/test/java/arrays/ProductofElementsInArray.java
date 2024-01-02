package arrays;

public class ProductofElementsInArray {
	public static void name() {
		int prod = 1 ;
		int arr[] = { 4, 2, 5 ,11,4};
		for (int i = 0; i < arr.length; i++) {
			prod = arr[i] * prod;

		}
		System.out.println(prod);
	}

	public static void main(String[] args) {
		ProductofElementsInArray s = new ProductofElementsInArray();
		// s.name();
		name();
	}
}
