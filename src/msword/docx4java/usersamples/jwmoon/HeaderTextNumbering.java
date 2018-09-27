/**
 * @ HeaderTextNumbering.java 
 */
package msword.docx4java.usersamples.jwmoon;

import org.docx4j.XmlUtils;
import org.docx4j.model.datastorage.XPathEnhancerParser.main_return;
import org.docx4j.model.listnumbering.Emulator;
import org.docx4j.model.listnumbering.Emulator.ResultTriple;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.Text;

/**
 * <pre>
 * msword.docx4java.usersamples
 * HeaderTextNumbering.java 
 * </pre>
 *
 * @brief	: ms 워드 파일의 제목 텍스트에 넘버링 기능을 추가한다. 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2017. 2. 3.
 */
public class HeaderTextNumbering {

	private static String filePath = System.getProperty("user.dir") + "/src/msword/docx4java/sample-docs/";
	
	// 참고 URL : http://www.programcreek.com/java-api-examples/index.php?api=org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart
	public static void main(String[] args) {
		
		// 메인 Document에는 컨텐트가 들어가 있어야 한다. 
		
	}
	
	private static void printNumberingContent(WordprocessingMLPackage wordMLPackage){
		NumberingDefinitionsPart ndp = wordMLPackage.getMainDocumentPart().getNumberingDefinitionsPart();
		Emulator listNumberingEmulator = ndp.getEmulator();
		
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
