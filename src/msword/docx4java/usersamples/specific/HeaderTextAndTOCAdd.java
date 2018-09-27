/**
 * @ Docx4JTest.java 
 */
package msword.docx4java.usersamples.specific;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.docx4j.Docx4J;
import org.docx4j.XmlUtils;
import org.docx4j.anon.Anonymize;
import org.docx4j.anon.AnonymizeResult;
import org.docx4j.jaxb.Context;
import org.docx4j.model.listnumbering.Emulator;
import org.docx4j.model.listnumbering.Emulator.ResultTriple;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;
import org.docx4j.openpackaging.parts.relationships.Namespaces;
import org.docx4j.wml.Body;
import org.docx4j.wml.Document;
import org.docx4j.wml.FldChar;
import org.docx4j.wml.Numbering;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.STFFTextType;
import org.docx4j.wml.STFldCharType;
import org.docx4j.wml.Text;

/**
 * <pre>
 * msword.docx4java
 * Docx4JTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2017. 2. 3.
 */
public class HeaderTextAndTOCAdd {


	public static void main(String[] args) throws Docx4JException, JAXBException {
		
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
		
		Document wmlDocument = documentPart.getJaxbElement();
		Body body = wmlDocument.getBody();
		
		ObjectFactory factory = Context.getWmlObjectFactory();

		// create paragraph
		P paragraphForTOC = factory.createP();
		
		// begin (r) 
		R r = factory.createR();
		FldChar fldchar = factory.createFldChar();
		fldchar.setFldCharType(STFldCharType.BEGIN);
		fldchar.setDirty(true); //?
		r.getContent().add(getWrappedFldChar(fldchar));  //??
		paragraphForTOC.getContent().add(r);
		
		// second (r1) 
		// 여기까지는 목차식이 단순히 텍스트 (TOC \\o \"1-3\" \\h \\z \\u \\h) 로 인식됨. 
		R r1 = factory.createR();
		Text txt = new Text();
		txt.setSpace("preserve");
		txt.setValue("TOC \\o \"1-3\" \\h \\z \\u \\h");
		r.getContent().add(factory.createRInstrText(txt));
		paragraphForTOC.getContent().add(r1);
		
		// end (r2) 
		// r2 까지 기술함으로써 위의 r1이 목차를 표시하는 식으로 인식됨. 
		FldChar fldcharend = factory.createFldChar();
		fldcharend.setFldCharType(STFldCharType.END);
		R r2 = factory.createR();
		r2.getContent().add(getWrappedFldChar(fldcharend));
		paragraphForTOC.getContent().add(r2);   
		
		
		// add paragraph to body
		body.getContent().add(paragraphForTOC);
		
		// 글에  헤더 텍스트를 추가한다.
		documentPart.addStyledParagraphOfText("Heading1", "제목1");
		documentPart.addStyledParagraphOfText("Heading2", "제목1-1");
		documentPart.addStyledParagraphOfText("Heading3", "제목1-1-1");
		documentPart.addStyledParagraphOfText("Heading1", "제목2");
		
		//documentPart.getstyle
		
		//wordMLPackage.save(new java.io.File(System.getProperty("user.dir") + 
		//		"/src/msword/docx4java/sample-docs/OUT_TableOfContentsTest.docx") );
		
		//printNumberingContent(wordMLPackage);
		/*
		String initialNumbering = "1";
		NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
		wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
		ndp.setJaxbElement((Numbering)XmlUtils.unmarshalString(initialNumbering));
		wordMLPackage.getMainDocumentPart().addParagraphOfText("Example of restarting numbering");
		*/
		//P p = createNum
	}
	
	private static JAXBElement getWrappedFldChar(FldChar fldchar){
		
		return new JAXBElement( new QName(Namespaces.NS_WORD12,"fldChar"), 
				FldChar.class, fldchar);  //어떻게 되는 거지?
	}
	
	private static void printNumberingContent(WordprocessingMLPackage wordMLPackage){
		NumberingDefinitionsPart ndp = wordMLPackage.getMainDocumentPart().getNumberingDefinitionsPart();
		Emulator listNumberingEmulator = ndp.getEmulator(); // 에뮬레이터를 세팅하지 않았다면 Null Pointer Exception
		
		for (Object o: wordMLPackage.getMainDocumentPart().getContent()){
			P p = (P)o;
			if (p.getPPr() != null){  // 문단에 세팅된 프로퍼티가 있다면
				String pStyleVal = null;
				if (p.getPPr().getPStyle() != null) { // 프로퍼티에 스타일이 세팅되어 있다면
					pStyleVal = p.getPPr().getPStyle().getVal();
				}
				String numId = null;
				String levelId = null;
				if (p.getPPr().getNumPr() != null){ // 프로퍼티에 넘버 프로퍼티가 세팅되어 있다면
					if (p.getPPr().getNumPr().getNumId() != null){
						numId = p.getPPr().getNumPr().getNumId().getVal().toString();
					}
					if (p.getPPr().getNumPr().getIlvl() != null) {
			            levelId=p.getPPr().getNumPr().getIlvl().getVal().toString();
			        }
				}
				ResultTriple rt = Emulator.getNumber(wordMLPackage, pStyleVal, numId, levelId);
				Text text = (Text)XmlUtils.unwrap(((R)p.getContent().get(0)).getContent().get(0));
				String content = text.getValue();
				System.out.println(content);
			}
		}
	}
	

}
