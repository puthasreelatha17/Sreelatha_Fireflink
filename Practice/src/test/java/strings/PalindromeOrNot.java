package strings;

public class PalindromeOrNot {

	public static void main(String[] args) {

		String name = "madam";
		String temp = "";
         
		for (int i = name.length() - 1; i >= 0; i--) {
			temp = temp + name.charAt(i);
		}
		if (name.equalsIgnoreCase(temp)) {
			System.out.println(name + " is a plaindrome");
		} else {
			System.out.println(name + " is not a plaindrome");
		}
	}

}
