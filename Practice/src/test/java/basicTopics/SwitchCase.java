package basicTopics;

public class SwitchCase {
public static void main(String[] args) {
	
	int a=10;
	
	switch (a%2) {
	case 0:{
		System.out.println("even number");
	}
	break;
	case 1:{
		System.out.println("odd number");
	}
	break;
	default:{
		System.out.println("invalid");
	}
	}
	
}
}
