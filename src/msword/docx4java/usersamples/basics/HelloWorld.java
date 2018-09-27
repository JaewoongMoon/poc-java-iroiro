/**
 * @ HelloWorld.java 
 */
package msword.docx4java.usersamples.basics;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

/**
 * <pre>
 * msword.docx4java.usersamples
 * HelloWorld.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2017. 2. 3.
 */
public class HelloWorld {

	private static String filePath = System.getProperty("user.dir") + "/src/msword/docx4java/sample-docs/";
	private static WordprocessingMLPackage wordMLPackage = null;
	
	private static void main() throws Docx4JException{
				
		wordMLPackage = WordprocessingMLPackage.createPackage();
		wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello World!");
		wordMLPackage.save(new java.io.File(filePath + "hello.docx"));
	}

}
