package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberRegexTest {

	public static void main(String[] args) {
		/*
		Pattern p = Pattern.compile("^[A-z]+$");
		Matcher m = p.matcher("AAaBBdd");
		boolean b = m.matches();
		System.out.println(b);
		*/
		String regex1 = "* as";
		String regex2 = ",";
		String query = "a.FILEID as fileId, ";
		Pattern pattern = Pattern.compile("a.* as");
		Matcher matcher = pattern.matcher(query);
		//boolean b = matcher.matches();
		System.out.println(matcher.replaceAll("private String"));
		
	}
}
