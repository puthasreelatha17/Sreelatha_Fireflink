package OOPS;

/*by upcasting we can access only parent class properties
*to get subclass properties we have to perform downcasting
*for downcasting upcasting is mandatory*/

class A {
	public void method() {
		System.out.println("parent class implementation");
	}
}

class B extends A {
	public void methods() {
		System.out.println("subclass class implementation");
	}
}

public class Upcasting_Downcasting {
	public static void main(String[] args) {

		// upcasting
		A a = new B();
		a.method();

		// downcasting
		B b = (B) a;
		b.method();
		b.methods();
	}

}
