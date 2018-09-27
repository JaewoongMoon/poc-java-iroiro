/**
 * @ URLDecoder.java
 */
package encoding;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.commons.lang3.CharSet;

/**
 * <pre>
 * encoding
 * URLDecoder.java 
 * </pre>
 *
 * @brief	: 
 * @author	: Jae-Woong Moon(mjw8585@gmail.com)
 * @Date	: 2017. 6. 7.
 */
public class URLDecoder {
	
	public static void main(String[] args) {
		// decode
		/*
		String urlEncodedString ="%E6%96%B0%E5%AE%BF";
		String decoded = decodeString(urlEncodedString, "UTF-8");
		System.out.println(decoded);
		printBytes(decoded);
		*/
		
		System.out.println("==================================================");
		// encode
		String origin = "\"";
		String encoded = encodeString(origin, "UTF-8");
		System.out.println(origin + " => " + encoded);
		printBytes(encoded);
		//System.out.println(toHex(encoded));
	}

	public static String decodeString(String encodedString, String charSet){
		
		String decodeResult = "";
		try {
			decodeResult = java.net.URLDecoder.decode(encodedString, charSet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decodeResult;
		
	}
	
	public static String encodeString(String origin, String charSet){
		String encodedString = "";
		try {
			encodedString = URLEncoder.encode(origin, charSet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodedString;
	}
	
	public static void printBytes(String str){
		byte[] bytes = str.getBytes();
		System.out.println(bytes.length + " Bytes...");
		/*
		bytes = str.getBytes(StandardCharsets.UTF_8);
		System.out.println(Arrays.toString(bytes));
		
		bytes = str.getBytes(StandardCharsets.US_ASCII);
		System.out.println(bytes.length + " Bytes...");
		System.out.println(Arrays.toString(bytes));
		*/
		/*
		for (byte b : bytes){
			System.out.print("0x" + toHex(b+"") + " ");
		}*/
		System.out.println(bytesToHex(bytes));
		System.out.println();
	}
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	/*
	public static String toHex(String arg) {
	    return String.format("%040x", new BigInteger(1, arg.getBytes(StandardCharsets.UTF_8)));
	}*/
}
