package exception_file_Handling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* also called compiler aware exception 
 * it will be handled with throws keyword
 * throws keyword should be declared with method signature*/

public class CheckedException {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("");
	}
}
