package strings;

public class FirstLetterOfWordInCapital {
public static void main(String[] args) {
	String s="my name is sreelatha reddy";
	char[] c = s.toCharArray();
	for (int i = 0; i < c.length-1; i++) {
		c[0] = Character.toUpperCase(c[0]);
		if (c[i+1]==' ') {
			c[i] = Character.toUpperCase(c[i+1]);
		}
	}
	s=String.valueOf(c);
	System.out.println(s);
}
}
