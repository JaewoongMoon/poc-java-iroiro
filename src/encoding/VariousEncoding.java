package encoding;

import java.io.UnsupportedEncodingException;

import util.ByteUtil;

/**
 * @author	Jae-Woong Moon(mjw8585@gmail.com)
 * @brief	
 * @Date	2018/07/03	 
 */
public class VariousEncoding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] payload = "?>".getBytes();
		String encoded = new String(payload, "EUC_JP");
		String encoded2 = new String(payload, "UTF-8");
		String encoded3 = new String(payload, "EUC-KR");
		String encoded4 = new String(payload, "UTF-16");
		String encoded5 = new String(payload, "cp1252");
		String encoded6 = new String(payload, "ISO8859_1");
		String encoded7 = new String(payload, "ASCII");
		String encoded8 = new String(payload, "UTF-7"); //基本的には支援しない。jcharset-2.0.jarをｃｌａｓｓｐａｔｈについか
		
		System.out.println("== :" + ByteUtil.bytesToHex(encoded.getBytes()));
		System.out.println("== :" + ByteUtil.bytesToHex(encoded2.getBytes()));
		System.out.println("== :" + ByteUtil.bytesToHex(encoded3.getBytes()));
		System.out.println("== :" + ByteUtil.bytesToHex(encoded4.getBytes()));
		System.out.println("== :" + ByteUtil.bytesToHex(encoded5.getBytes()));
		System.out.println("== :" + ByteUtil.bytesToHex(encoded6.getBytes()));
		System.out.println("== :" + ByteUtil.bytesToHex(encoded7.getBytes()));
		System.out.println("== :" + ByteUtil.bytesToHex(encoded8.getBytes()));
		
	}
}
