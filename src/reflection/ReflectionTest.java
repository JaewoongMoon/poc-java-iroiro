package reflection;

import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		ReflectionTest t = new ReflectionTest();
		//일단 메서드의 파라메터 정보를 찍어보자. 
		//Method m = Class.forName("ReflectionTest").getMethod("testMethod", String.class, String.class, String.class);
		Method m = ReflectionTest.class.getMethod("testMethod", String.class, String.class, String.class);
		//m.
		
	}
	
	public void testMethod(String a1, String a2, String a3){
		
	}
	
	
}
