package basicTopics;

/* one method calling another method and that method calling another method */ 
public class MethodChaining {
	
public static void method1() {
	System.out.println("method 1");
}
public  void method2() {
	method3();
	System.out.println("method 2");
}
public static void method3() {
	method1();
	System.out.println("method 3");
}
public static void main(String[] args) {
	MethodChaining m= new MethodChaining();
	m.method2();
}
}
