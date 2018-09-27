/**
 * @ DivideStage.java 
 */
package msword.docx4java.usersamples.basics;

import java.math.BigInteger;

import java.util.List;

   

import org.docx4j.model.structure.SectionWrapper;

import org.docx4j.openpackaging.exceptions.Docx4JException;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import org.docx4j.wml.CTColumns;

import org.docx4j.wml.SectPr;

/**
 * <pre>
 * msword.docx4java.usersamples
 * DivideStage.java 
 * </pre>
 *
 * @brief	: 단 나누기 샘플 소스 코드이다. 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2017. 2. 3.
 */
public class DivideStage {

	 private static WordprocessingMLPackage wordMLPackage = null;
	 private static String filePath = System.getProperty("user.dir") + "/src/msword/docx4java/sample-docs/";
	 private static org.docx4j.wml.ObjectFactory factory=null;	

	 public static void main(String[] args) throws Docx4JException {
	        wordMLPackage = WordprocessingMLPackage.createPackage();
	        wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello World!");
	        setColumns();        
	        wordMLPackage.save(new java.io.File(filePath + "divideStage.docx"));
	 }

	 public static void setColumns(){
	        List<SectionWrapper> sections = wordMLPackage.getDocumentModel().getSections();

	        SectPr sectionProperties = sections.get(sections.size() - 1).getSectPr();
	        if(sectionProperties==null){
	            sectionProperties = factory.createSectPr();
	            wordMLPackage.getMainDocumentPart().addObject(sectionProperties);
	            sections.get(sections.size() - 1).setSectPr(sectionProperties);
	        }

	        CTColumns ctcol = new CTColumns();
	        BigInteger colnum = new BigInteger("2");

	        ctcol.setNum(colnum);
	        sectionProperties.setCols(ctcol);
	 }
}
