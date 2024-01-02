package basicTopics;

/* converting 1 primitive to another primitive 
 * two types: widening and narrowing
 * Widening: process of converting lower to higher data type
 * widening can be done implicitly by compiler b/c there will be no data loss
 * Narrowing: process of converting higher to lower data type
 * narrowing cann't be done implicitly by compiler b/c there will be a data loss*/
public class PrimitiveTypeCasting {

	public static void main(String[] args) {
		
		//widening
		int a=10;
		System.out.println(a);
		double d=a;
		System.out.println(d);
		
		//narrowing
		double d1=20.0;
		System.out.println(d1);
		int b=(int)d1;
		System.out.println(b);
	}

}
