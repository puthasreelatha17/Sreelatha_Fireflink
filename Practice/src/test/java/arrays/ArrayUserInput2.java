package arrays;

import java.util.Scanner;

public class ArrayUserInput2 {
	 static double n;
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the size:");
	  n = sc.nextDouble();
	 double arr[]= new double[(int) n];
	System.out.println("Enter the elements of array");
	for (int i = 0; i <n; i++) {
		arr[i]=sc.nextDouble();
		//System.out.print(arr[i]+" ");
	}
	//accessing the elements of array
	System.out.println("Elements in the array are:");
	for (int i = (int) n-1; i >0; i--) {
		System.out.print(arr[i]+" ");
	}
}
}
