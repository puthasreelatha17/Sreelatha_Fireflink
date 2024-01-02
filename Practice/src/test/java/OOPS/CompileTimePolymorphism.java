package OOPS;

/* Binding the method declaration with definition by compiler during compilation
*  also called as early binding
*  static binding because once binding done at compile time we cann't modify at runtime
*  example are method overloading or constructor overloading */

public class CompileTimePolymorphism {
	public static void method() {
		System.out.println("No arguments method");
	}
	
	public static void method(int a) {
		System.out.println("single argument method");
	}
	
	
	public static void method(int a, int b) {
		System.out.println("two arguments method");
	}
	
	public static void method(char c) {
		System.out.println("char type argument method");
	}
public static void main(String[] args) {
  method();
  method('a');
  method(10);
  method(10,20);
}
}
