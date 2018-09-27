/**
 * @ CreateNewDocx.java 
 */
package msword.docx4java.usersamples.basics;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 * <pre>
 * msword.docx4java.usersamples.basics
 * CreateNewDocx.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2017. 2. 5.
 */
public class CreateNewDocx {

	public static void main(String[] args) throws Docx4JException {
		
		// Create the package
		WordprocessingMLPackage wordMLPacakge = WordprocessingMLPackage.createPackage();
		
		// Save it
		wordMLPacakge.save(new java.io.File("helloworld.docx"));
		
	}
}
