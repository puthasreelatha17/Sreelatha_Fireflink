package basicTopics;

import java.util.Random;

public class GenerateRandomNumber {

	public static void main(String[] args) {

		Random rm = new Random();
		int randomNumber = rm.nextInt(1000);
		System.out.println(randomNumber);
	}
}
