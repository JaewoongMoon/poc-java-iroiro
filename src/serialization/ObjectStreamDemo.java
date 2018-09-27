package serialization;

import java.io.ObjectStreamClass;
import java.util.ArrayList;

/**
 * @author	Jae-Woong Moon(mjw8585@gmail.com)
 * @ref		https://www.geeksforgeeks.org/java-io-objectstreamclass-java/
 * @Date	2017. 12. 26.	 
 */
public class ObjectStreamDemo {

	public static void main(String[] args) {
		//ex1();
		ex2();
	}
	
	/**
	 * @brief Java code illustrating forClass(), lookup() and lookupAny() method
	 */
	private static void ex1() {
		// creating object stream class for Number
		ObjectStreamClass geeks_stream = ObjectStreamClass.lookup(Number.class);
		ObjectStreamClass quiz_stream = ObjectStreamClass.lookupAny(ArrayList.class);
		
		// checking class instance
		System.out.println(geeks_stream.forClass()); 
		System.out.println(quiz_stream.forClass());
	}
	
	private static void ex2() {
		// creating object stream class for Number
		ObjectStreamClass geeks_stream = ObjectStreamClass.lookup(Number.class);
		
		// checking field
		System.out.println(geeks_stream.getField("quiz_stream"));
		System.out.println(geeks_stream.getFields());
		
		// class name
		System.out.println("class name: " + geeks_stream.getClass());
		
		// checking serial version UID
		System.out.println(geeks_stream.getSerialVersionUID());
		
		System.out.println(geeks_stream.toString());
	}
}
