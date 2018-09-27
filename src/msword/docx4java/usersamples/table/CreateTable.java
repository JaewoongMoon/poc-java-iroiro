/**
 * @ CreateTable.java 
 */
package msword.docx4java.usersamples.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.docx4j.XmlUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.model.datastorage.XPathEnhancerParser.main_return;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.ParaRPr;
import org.docx4j.wml.R;
import org.docx4j.wml.RFonts;
import org.docx4j.wml.RPr;
import org.docx4j.wml.Style;
import org.docx4j.wml.Styles;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.TblPr;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;

/**
 * <pre>
 * msword.docx4java.usersamples.table
 * CreateTable.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2017. 2. 6.
 */
public class CreateTable {

	public static void main(String[] args) throws Exception {
		
		boolean save = true; 
		
		WordprocessingMLPackage mlPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mdp = mlPackage.getMainDocumentPart();
		
		// set font
		setFonts(mdp, "Meiryo");
		
		
		// Ex 1: add text in Title style
		mdp.addStyledParagraphOfText("Title", "Ex1. 이 것은 타이틀입니다.");
		
		// Ex 2: add normal paragraph
		mdp.addParagraphOfText("Ex2. 이 것은 일반 텍스트입니다.");
		
		// Ex 3-a: bold text  (Ppr 객체에 설정)
		
		ObjectFactory factory = Context.getWmlObjectFactory();
		P p = factory.createP();
		
		Text t = factory.createText();
		t.setValue("Ex 3a. 普通のテキストです。");
		
		R run = factory.createR();
		run.getContent().add(t);
		p.getContent().add(run);
		
		///////////////////////////////////////////////////////////////
		// rpr: bold 설정을 가지고 있는 설정 객체  
		RPr rpr = factory.createRPr();
		BooleanDefaultTrue b = new BooleanDefaultTrue();
		b.setVal(true);
		rpr.setB(b);
		///////////////////////////////////////////////////////////////
		
		run.setRPr(rpr);
		
		PPr ppr = factory.createPPr();
		p.setPPr(ppr);
		ParaRPr paraRpr = factory.createParaRPr();
		ppr.setRPr(paraRpr);
		rpr.setB(b);
		
		//mdp.getJaxbElement().getBody().getContent().add(p);
		mdp.addObject(p);  //alternative
		
		
		// Ex 3-b : bold text (R 객체에 설정)
		P p3b = mdp.addParagraphOfText("Ex 3b. 볼드체입니다.");
		R r3b = (R)p3b.getContent().get(0);
		r3b.setRPr(rpr);
		
		// Ex 4: bold text ( XML 로 설정)
		String str = "<w:p xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" ><w:r><w:rPr><w:b /></w:rPr><w:t>Ex 4. 볼드체 XML</w:t></w:r></w:p>";
		mdp.addObject(XmlUtils.unmarshalString(str));
		
		
		// Ex 5: 테이블 만들기 
		int writableWidthTwips = mlPackage.getDocumentModel().getSections().get(0)
				.getPageDimensions().getWritableWidthTwips(); // 문서의 넓이를 가져오는 것인듯. 
		int cols = 3;
		int cellWidthTwips = new Double(Math.floor( (writableWidthTwips/cols )))
				.intValue(); //문서의 넓이를 칼럼 수로 나눠서 각 칼럼 넓이가 동일하게 떨어지도록..
		
		
		Tbl table = TblFactory.createTable(3, cols, cellWidthTwips);
		mdp.addObject(table);
		//System.out.println(table.getContent().get(0).getClass()); //Tr 클래스임. 
		Tr tr1 = (Tr)table.getContent().get(0);
		//System.out.println(tr1.getContent().get(0).getClass());  //Tc 클래스임. 
		Tc tc1 = (Tc)tr1.getContent().get(0);
		//System.out.println(tc1.getContent().get(0).getClass()); // P 클래스임. 
		P tc1p = (P)tc1.getContent().get(0);
		tc1p.getContent().get(0); // index out of bounds. 아무런 값이 없을때는...
		System.out.println(tc1p.getContent().get(0).getClass());
		/*
		tc1.getContent().add(
				mdp.createParagraphOfText("これは日本語です。"));
				*/
		/*
		tc1.getContent().add(
				mdp.createParagraphOfText("테이블 안에 넣는 텍스트 두번째")); // 이어서 들어가게 된다. 
		 */
		

		
		/////////////////////////////////////////////////////////////////
		// Pretty print the main document part
		//System.out.println(
			//	XmlUtils.marshaltoString(mdp.getJaxbElement(), true, true));

		
		// Optionally save it
		if (save) {
			String filename = System.getProperty("user.dir") +
					"/src/msword/docx4java/sample-docs" +
					"/OUT_JwmoonCreateWordprocessingMLDocument.docx";
			mlPackage.save(new java.io.File(filename) );
			System.out.println("Saved " + filename);
		}
	}
	
	/**
	 * @Method 	: setFonts
	 * @brief	: 실행해보니 폰트가 설정은 되지만 실제로 글자에까지 적용되어 있지는 않았다. 
	 * 			   뭔가 추가 코드가 있어야 될 것 같다.   
	 * @author	: 문재웅(mjw8585@gmail.com)
	 * @Date	: 2017. 2. 6.
	 * @param mdp
	 * @param fontName
	 */
	public static void setFonts(MainDocumentPart mdp, String fontName){
		Styles styles = mdp.getStyleDefinitionsPart().getJaxbElement();
		ObjectFactory factory = Context.getWmlObjectFactory();
		
		for (Style s : styles.getStyle()){
			
			System.out.println(s.getName().getVal());
			//if (s.getName().getVal().equals("NORMAL")){
				RPr rpr = s.getRPr();
				if (rpr == null){
					rpr = factory.createRPr();
					s.setRPr(rpr);
				}
				
				RFonts rf = rpr.getRFonts();
				
				if (rf == null){
					rf = factory.createRFonts();
					rpr.setRFonts(rf);
				}
				
				rf.setAscii(fontName);
			}
		//}
	}
}

