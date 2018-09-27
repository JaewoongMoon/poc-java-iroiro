/**
 * @ DecodingTest.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package encoding;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;



/**
 * <pre>
 * encoding
 * DecodingTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 7. 27.
 */
public class DecodingTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//String hex_val = "e585a8e593a1e38397e383ace382bce383b3e38388e382ace38381e383a3202831e697a531e59b9ee5bc95e38191e3828be784a1e6969929";
		
		//hexToUtf8(hex_val);
		
		String tokenKey = "/kZycW33RidntijuwHHlWwRdVXkrobJar2XkK0QEOc2lSja7j799lawVWc5bm8j4";
		byte[] decode1 = Base64.decodeBase64(tokenKey);
		System.out.println(new String (decode1, "UTF-8"));
	}
	
	private static String hexToUtf8(String hex){
		ByteBuffer buff = ByteBuffer.allocate(hex.length()/2);
		for (int i = 0; i < hex.length(); i+=2) {
		    buff.put((byte)Integer.parseInt(hex.substring(i, i+2), 16));
		}
		buff.rewind();
		Charset cs = Charset.forName("UTF-8");                              
		CharBuffer cb = cs.decode(buff);                                    
		System.out.println(cb.toString());
		return cb.toString();
	}
}
