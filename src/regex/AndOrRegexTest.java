/**
 * @ AndOrRegexTest.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * regex
 * AndOrRegexTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016/03/28
 */
public class AndOrRegexTest {

	
	
	public static void main(String[] args) {
		String regex = "AND|OR";
		String src = "AND abcd AND defg";
		String src2 = "OR abcd AND defg";
		String result = src.replaceFirst(regex, "");
		String result2 = src2.replaceFirst(regex, "");
		
		/*
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(src);
		boolean b = m.matches();
		*/
		System.out.println(result);
		System.out.println(result2);
	}
}
