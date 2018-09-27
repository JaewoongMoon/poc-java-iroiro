/**
 * @ TestThread.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package thread;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * thread
 * TestThread.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 4. 13.
 */
public class TestThread implements Runnable{

	public static void main(String[] args) throws IOException {
		TestThread t1 = new TestThread();
		File file = new File("test.txt");
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		
	}
	
	public void run() {
		
	};
}
