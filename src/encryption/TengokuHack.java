/**
 * @ TengokuHack.java
 */
package encryption;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <pre>
 * encryption
 * TengokuHack.java 
 * </pre>
 *
 * @brief	: 
 * @author	: Jae-Woong Moon(mjw8585@gmail.com)
 * @Date	: 2017. 7. 4.
 */
public class TengokuHack {
	
	private static final int HASH_LENGTH = 20;
	private static final String aesKey = "0r5bcPOmkZ071Fm5"; //AES-KEY (16 bytes)
	private static final String macKey= "9UX35aIir2"; // (10 Bytes)
	
	public static void main(String[] args){
		//String req = "lEQGo4R7wPvUha/i5hAJVzNiQbQVjbtui5B4qHhF39I2of46v0H/n1ega8Y/YbAzEO0J++AEQolXGHrVTJWIfqOFGUHorQuzx411cr34N6INIUhKtHMfSHqhtlpLZNWauY91Wj3TDet53vwi9ATsgGypr2et1Ydz7o+vhZf6Yedlyayfu3nB7aaZMiUc9zaDGcZL9yYtcvUhtJiN9gXG3qVmMqxQHSzMTNZLFsacXxByIgVTayv4+ZRMdGj4XLLgp2GEZCNwXg/bYyLIs5hb9DyZXsbLDt0935/xWF9x8PYdZ1J2MbtqAsym+AdmsEM4AvVL7jc72t+7MqCXesxsjWiJiahlvAXgZ2TWic3Sy8JZK0FhvENZDOXWQ8k4sOHDKAzNYcLNMvQawECx2n8l6ofcFEJ5VU6C2cwAOcKd7wuUiQg3dOQPNh3SVlKxmiWuCpmfPpFDjto23kHDm8uLY9H1P6SR+31R+MbIVQuYvz4iXOtgxzTjOVfIfObSLm5G9a3inIMwW0SN6RoFPoa5Bq5lcPjlBCFdo+qkT8CeN4KMELbPQNCOwDgs6bWGSpfZgn/RCk5IvuJcQB4d4FvMeg==";
		String res = "gQDpt7ypit9HjzKA1qNWfuwPblwWrvNhYMxg6RIRD1EDEGuPzcXNOvq+tfOVB7ILq3ANDPt2lvk49eDC8FidnL7Zh0mYMncxivEvkKbH8o3Z4uY9KI/IKeW25MM6TnKk7EeiwnewNUy2FB1gYVfI8mtFzuvMbLPERbLpq+eVdXOAw6+fe5MrNvodef3zizoDM3Ud3qzUXuEzqWubd+cFZco/4x5c0fc63B5xxzBxd9sRhApvrRxex5f7wzK90PpXmcmTSNutWJO3xXseZperkLw8cC8yEAcBLwhYwhDDdzmBlD1gclnV3c0QNIKj3tlnD/1DlU5ubKfCaKecJOT6bPq2WfuluIWUD08dZGKWIV1y9D46ANSFHYlynU+0LLFVkuVnRDEBqoOFjsz8iPfrMMLQXwzfl6CUP2qdwAiZIhQS8LuEz9/2hKP1YxN1mkmlT9NOAX7tz4CXjw9ukdONgDC8BPyJK8dXQLDmeM58K/ecp1dT9G0lPKvv/QSJ4QAUaKt9MaNLNXjZ7gGGvMnv3sbXhTTDQN5mUpLYBxY5SBdVAWKQpoXgwnr2wqVpaCC2JALGSiHdlLBZ1ZQpieNHmaRQanUVqDci6Kdfj++XSPuqPjOidGahF8zIBGr/O3RAyDDMhoR2FAyS7nPZeAxGefHH/s8wH5CBizoMHSjVL79GDkp0UtBmFXAtMoXSXgb4AXW0lwO+sOFRANvULwKh4ecMsG9yrN+X5aMnLW8Tkb+Ct4MxbQaipJ8oA94VSTl+DFxkQStiwcl/FjWg5hPZ3BVDtNdwR+erayyCvzmAik9wJH4fH98RGa/mAYgqr69KjP7AcqakKdIZK1qecDlqNUrhIGBNNBgMZ2wSyDho/SRea8hZC8BWawXkEDAgfMqPN3nTxTiBuV3YFLhBTvA9XvkgCTBZm7svPXdjHOs+5OGetFbuISxmoZzKnuhRiKEamJAEJHCybPl7iB+H3WHLi5ydC6FFlKDfdqUiBzEPOs7saMj8tHaJN5dAgEnNdJmpXp740LNm5BEdqebHntXw/p/sF7t/cEKiTVZGSfPOUBqDqtNKbTeMJfjnQAx7/gkrsMRijh+KIamJfDpDlJAFZbwnEEyM0heuOa4Vm8VfB+6XlQRTN4vNkNP1NlzDVnVMXumY+MqU1WVjvn6waAQRf+9VzEwYSBBsJigvNhhOFEFjkYkR1q2Z/Jz9yX+lLztvFqzpfza4hSJ7FlNKOUepaw==";
		TengokuHack h = new TengokuHack();
		//System.out.println(res);
		//System.out.println("============ decrypted ===================");
		String message = h.decrypt(res);
		System.out.println(message);
		
		/*
		byte[] decryptBytes = AESEncryptor.decryptECB_Byte(aesKey, res);
		byte[] messageBytes = new byte[decryptBytes.length-20];
		System.arraycopy(decryptBytes, HASH_LENGTH, messageBytes, 0, decryptBytes.length-HASH_LENGTH); 
		*/
		
		String computedHash = AESEncryptor.bytesToHex(h.getHash(message.getBytes(StandardCharsets.UTF_8), macKey));
		System.out.println("computed : " + computedHash);
		
		
		// 해시 값 체크 (c# 결과와 비교) 동일한 것을 확인했다. 즉 Hash 함수에는 문제가 없다. 
		/*
		String message = "message";
		byte[] hash = h.getHash(message.getBytes(), macKey);
		System.out.println(AESEncryptor.bytesToHex(hash));
		*/
	}
	
	// AES암호화(ECB모드)된 Base64 문자열을 리턴한다. 
	public String encrypt(String src){
		return "";
	}
	
	// 복호화된 원문 문자열을 리턴한다.
	public String decrypt(String encrypted){
		byte[] decrypted = AESEncryptor.decryptECB(aesKey, encrypted);
		// STEP 1. 해시 분리
		byte[] hash = getHashFromDecrypted(decrypted);
		
		// STEP 2. 컨텐츠 부분 분리
		/// ver1. { 앞의 쓸데없는 문자열을 제거
		/*
		int startIndex = searchStartIndex(decrypted);
		String message = decrypted.substring(startIndex, decrypted.length());
		*/
		/// ver2. 21번째 바이트부터 분리된 바이트 배열을 변환
		byte[] content = new byte[decrypted.length - HASH_LENGTH];
		System.arraycopy(decrypted, HASH_LENGTH, content, 0, decrypted.length-HASH_LENGTH);
		String message = new String(content, StandardCharsets.UTF_8); 
		return message;
	}
	
	private byte[] getHashFromDecrypted(byte[] decrypted){

		//System.out.println("bytes length : " + bytes.length);
		byte[] hash = new byte[HASH_LENGTH];
		System.arraycopy(decrypted, 0, hash, 0, HASH_LENGTH);
		//System.out.println("======================== hash ==============================");
		System.out.println("hash : " + AESEncryptor.bytesToHex(hash)); 
		return hash;
	}
	
	// { 의 인덱스를 찾아서 리턴해준다.  
	private  int searchStartIndex(String src){
		int idx = src.indexOf("{");
		return idx;
	}
	
	// 해시계산을 두 번한다. 
	private byte[] getHash(byte[] src, String macKey){
		
		// STEP 1. [[macKey의 바이트 배열] + [공백(스페이스)의 바이트배열] + [원문의 바이트배열]] 을 SHA-1으로 해싱한다. 
		byte[] macBytes =  macKey.getBytes(StandardCharsets.UTF_8);
		byte[] spaceBytes = " ".getBytes(StandardCharsets.UTF_8);
		byte[] array = new byte[macBytes.length + spaceBytes.length + src.length]; //src 의 length 는 가변적일 것이다...
		
		// array에 카피한다. 
		System.arraycopy(macBytes, 0, array, 0, macBytes.length);  //STEP 1. macBytes 카피
		System.arraycopy(spaceBytes, 0, array, macBytes.length, spaceBytes.length); //STEP2. 그 뒤에 spaceBytes 카피
		System.arraycopy(src, 0, array, macBytes.length + spaceBytes.length, src.length); //STEP3. 마지막에 src 카피
		
		// array의 SHA1 해시값 구하기 
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hash_1 = md.digest(array);
		
		// STEP 2. [[macKey의 바이트배열] + [STEP 1의 바이트 배열]] 을 SHA-1으로 해싱한다.
		byte[] result = new byte[macBytes.length + hash_1.length];
		System.arraycopy(macBytes, 0, result, 0, macBytes.length);
		System.arraycopy(hash_1, 0, result, macBytes.length, hash_1.length);
		byte[] hash_2 = md.digest(result);
		
		return hash_2;
	}
	
}
