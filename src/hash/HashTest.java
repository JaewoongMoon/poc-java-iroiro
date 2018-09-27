/**
 * @ HashTest.java 
 */
package hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <pre>
 * hash
 * HashTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2016. 10. 6.
 */
public class HashTest {

	/**
	 * @Method 	: main
	 * @brief	: 
	 * @author	: 문재웅(mjw8585@gmail.com)
	 * @Date	: 2016. 10. 6.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// MD5, SHA1, SHA256, SHA512
		HashTest t = new HashTest();
	 	System.out.println(t.testMD5("1234"));
	 	System.out.println(t.testSHA256("가나다"));
	 	System.out.println(t.get_SHA_512_SecurePassword("가나다", ""));
	}

	public String testMD5(String str){
		String MD5 = ""; 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(str.getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			MD5 = null; 
		}
		return MD5;
	}
	
	public String testSHA256(String str){
		String SHA = ""; 
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-512"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString().toUpperCase();
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			SHA = null; 
		}
		return SHA;
	}
	
	public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
		String generatedPassword = null;
		    try {
		         MessageDigest md = MessageDigest.getInstance("SHA-512");
		         md.update(salt.getBytes("UTF-8"));
		         byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
		         StringBuilder sb = new StringBuilder();
		         for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		         }
		         generatedPassword = sb.toString();
		       }catch (NoSuchAlgorithmException e){
		    	   e.printStackTrace();
		       }catch (UnsupportedEncodingException e){
		    	   e.printStackTrace();
		       }
		    return generatedPassword;
		}
	
	
}
