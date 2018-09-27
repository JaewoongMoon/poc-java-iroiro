/**
 * @ AESEncryptor.java
 */
package encryption;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.google.common.hash.Hashing;

/**
 * <pre>
 * encryption
 * AESEncryptor.java 
 * </pre>
 *
 * @brief	: 
 * @author	: Jae-Woong Moon(mjw8585@gmail.com)
 * @Date	: 2017. 6. 30.
 */
public class AESEncryptor {

	private static final int KEY_SIZE = 128;
	
	private static byte[] adjustKey(byte[] key){
		return Arrays.copyOf(key, KEY_SIZE / 8); 
	}
	
	public static String encryptECB(String key, byte[] value){
		try{
			SecretKeySpec skeySpec = new SecretKeySpec(adjustKey(key.getBytes("UTF-8")), "AES");
			
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING"); 
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			
			byte[] encrypted = cipher.doFinal(value);
			System.out.println(Base64.encodeBase64String(encrypted));
			return Base64.encodeBase64String(encrypted);
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decryptECB(String key, String encrypted){
		try{
			SecretKeySpec skeySpec = new SecretKeySpec(adjustKey(key.getBytes("UTF-8")), "AES");
			
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
			return original;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encryptCBC(String key, String initVector, String value){
		try{
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(adjustKey(key.getBytes("UTF-8")), "AES");
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			
			byte[] encrypted = cipher.doFinal(value.getBytes());
			System.out.println("encrypted string : " + Base64.encodeBase64String(encrypted));
			
			return Base64.encodeBase64String(encrypted);
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String decryptCBC(String key, String initVector, String encrypted){
		try{
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(adjustKey(key.getBytes("UTF-8")), "AES");
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
			return new String(original, StandardCharsets.UTF_8);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void sampleRun(){
		// Sample Run
		String key = "SERVER-AES-KEY";
		System.out.println("==================== ECB 모드 =======================");
		String message = "Hello World";
		System.out.println(new String(decryptECB(key, encryptECB(key, message.getBytes(StandardCharsets.UTF_8)))));
		/*
		System.out.println("==================== CBC 모드 =======================");
		String initVector = "RandomInitVector"; //16 bytes IV
		System.out.println(decryptCBC(key, initVector, encryptCBC(key, initVector, "Hello World")));
		*/
	}
	
	public static void main(String[] args) {
		sampleRun();
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
}
