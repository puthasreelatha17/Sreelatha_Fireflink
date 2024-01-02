package OOPS;

//without upcasting if we create object of subclass and try to access overriding method we will get parent class implementation
//with upcasted reference variable if we try to access overriding method we will always get subclass implementation

class C {
	public void method() {
		System.out.println("parent class implementation");
	}
}

class D extends C {

	public void method() {
		System.out.println("subclass class implementation");
	}
}

public class MethodOverriding {

	public static void main(String[] args) {

		// upcasting
		// C a = new C();//parent class implementation
		C a = new D();// sub class implementation
		a.method();

	}

}
