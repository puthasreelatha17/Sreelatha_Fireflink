package strings;

public class CountNumberOfWordsInSentence {
	
public static void main(String[] args) {
 	  String sentence="My name is sreelatha reddy putha working as test engineer";
 	  int count = 1;
// 	  String[] words = sentence.split(" ");
// 	  for (int i = 0; i < words.length; i++) {
//		count++;
//	}
// 	  System.out.println(count);
 	  for (int i = 0; i < sentence.length(); i++) {
		if (sentence.charAt(i)==' '&&sentence.charAt(i+1)!=' ') {
			count++;
		}
	}
 	  System.out.println(count);
}
}
