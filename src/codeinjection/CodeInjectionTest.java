/**
 * @ CodeInjectionTest.java 
 */
package codeinjection;

/**
 * <pre>
 * codeinjection
 * CodeInjectionTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2017. 1. 30.
 */
public class CodeInjectionTest {

	/**
	 * @Method 	: main
	 * @brief	: 
	 * @author	: 문재웅(mjw8585@gmail.com)
	 * @Date	: 2017. 1. 30.
	 * @param args
	 */
	public static void main(String[] args) {
		
		String injected = "\");out.println(\"test\"); ";
		//String injected = System.in.read();
		call(injected);
		System.out.println(System.getProperties());
		
	}
	
	public static void call(String arg){
		System.out.println(arg);
	}

}
