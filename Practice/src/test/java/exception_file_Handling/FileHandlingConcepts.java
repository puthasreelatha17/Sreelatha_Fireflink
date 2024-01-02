package exception_file_Handling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingConcepts {

	public static void main(String[] args) throws IOException {

		// To create file
		File f = new File("C:\\Users\\Putha Sreelatha\\Documents\\FileHandling\\Sample.txt");
		if (f.createNewFile()) {
			System.out.println("File created successfully");
		} else {
			System.out.println("File already exist");
		}

		// To write data to file
		FileWriter fw = new FileWriter(f);

		// to write data without overriding
		// FileWriter fw=new FileWriter(f,true);
		fw.write("Data written to file successfully");
		fw.flush();
		fw.close();

		// To read data to file
		FileReader fr = new FileReader(f);
		int i;
		while ((i = fr.read()) != -1)
			System.out.print((char) i);
		fr.close();
	}
}
