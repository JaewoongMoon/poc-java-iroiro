/**
 * @ FileNameFiltering.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package filtering;

/**
 * <pre>
 * filtering
 * FileNameFiltering.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 6. 28.
 */
public class FileNameFiltering {

	public static void main(String[] args) {
		String fileName = "test.jsp%00</script>\\.bmp";
		System.out.println(fileName.replaceAll(".", ""));
		//System.out.println(checkext("test.jsp%\\.bmp"));
		//System.out.println(checkext("test.bmp.jsp")); //false
		System.out.println(checkext(fileName)); //true
		//System.out.println(checkext("test.jsp%zz.bmp")); //true
		//System.out.println(checkext("test.asp;zz.bmp")); //false
		//System.out.println(" 0".indexOf("\0"));
		//System.out.println(fileName.substring(fileName.lastIndexOf('.') + 1));
	}
	
	// 업로드 필터링 함수 
	public static String checkext(String fileName) {

		String chkExt = "false"; 
		String Exts = "jpg,gif,bmp"; //허용할 확장자
		fileName = getSafeStr(fileName);

		if ((fileName.indexOf("\0") > -1) || (fileName.indexOf(";") > -1) || (fileName.indexOf("./") > -1) || (fileName.indexOf(".\\") > -1))
		{
			chkExt = "false";
		}else{
			String file_ext = fileName.substring(fileName.lastIndexOf('.') + 1); 
			if (!Exts.equals("")) { 
				Exts = Exts.replaceAll(" ","");
				String compStr[] = Exts.split(","); 
				for (int i = 0;i < compStr.length; i++) { 
					if (file_ext.equalsIgnoreCase(compStr[i])) { 
						chkExt = "true"; 
					}
				}
			}else{
				chkExt = "true";
			}
		}
		return chkExt; 
	}
	
	// 특수문자 필터링 함수 
	private static String getSafeStr(String fileName){
		String[] symbols = {"\\%", "\\,", "\\?", "\\<", "\\>", "\\$", "\\!", "\\^",
		                      "\\*", "\\(", "\\)", "\\+", "\\;", "\\#", "\\=", "\\'", "\\/", "\\\\"};
		String safeStr = fileName;
		for (String symbol : symbols){
			safeStr = safeStr.replaceAll(symbol, "");
		}
		return safeStr;
	}

}
