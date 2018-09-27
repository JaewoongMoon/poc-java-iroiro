package string;

public class replaceAllTest {

	public static void main(String[] args) {
		String src = "개행\n문자\n테스트";
		String result = src.replaceAll("\n","<br>" );
		System.out.println(result);
	}
}
