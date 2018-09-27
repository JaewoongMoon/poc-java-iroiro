/**
 * @ EncodingTest.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package encoding;

import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 * encoding
 * EncodingTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 5. 25.
 */
public class EncodingTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String xss = "<script>alert('헤이')</script>";
		//String xss = "7866626d6c3d312676657273696f6e3d76322e36";
		
		System.out.println(new String(xss.getBytes(), "SHIFT_JIS"));
		System.out.println(new String(xss.getBytes(), "SJIS"));
		System.out.println(new String(xss.getBytes(), "UTF-8"));
		System.out.println(new String(xss.getBytes(), "MS949"));
		System.out.println(new String(xss.getBytes(), "EUC-KR"));
		System.out.println(new String(xss.getBytes(), "ISO8859_1"));
		System.out.println(new String(xss.getBytes(), "ASCII"));
		System.out.println(new String(xss.getBytes(), "UTF-16"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		ZonedDateTime zdt = ZonedDateTime.now();
		zdt = zdt.plusDays(Long.valueOf("3"));
		//String zdt = "3";
		
		String YYYYMMDDhhmmss = zdt.format(dtf);
		System.out.println(YYYYMMDDhhmmss);
	}
}
