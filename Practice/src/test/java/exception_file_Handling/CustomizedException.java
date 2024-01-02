package exception_file_Handling;

class NegativeInputException extends Exception{
	public NegativeInputException(String message) {
		super(message);
	}
}
public class CustomizedException {

public void method1(int a , int b) throws NegativeInputException {
	if(a>0&&b>0) {
		int res=a+b;
		System.out.println(res);
	}else {
		throw new NegativeInputException("pass the exception");
	}
}
	public static void main(String[] args) {
		CustomizedException ce=new CustomizedException();
		try {
			ce.method1(-10,-30);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
