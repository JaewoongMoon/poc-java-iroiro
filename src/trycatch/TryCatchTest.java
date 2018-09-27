/**
 * @ TryCatchTest.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package trycatch;

/**
 * <pre>
 * trycatch
 * TryCatchTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016/02/16
 */
public class TryCatchTest {

	public static void main(String[] args) {
		try{
			System.out.println("try");
			return ;
		}catch(Exception c){
			System.out.println("catch");
		}finally{
			System.out.println("finally");
		}
		System.out.println("return");
	}
}
