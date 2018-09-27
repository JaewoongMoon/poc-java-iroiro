package serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @brief	:참고 : http://flowarc.tistory.com/entry/Java-%EA%B0%9D%EC%B2%B4-%EC%A7%81%EB%A0%AC%ED%99%94Serialization-%EC%99%80-%EC%97%AD%EC%A7%81%EB%A0%AC%ED%99%94Deserialization
 * @author	: Jae-Woong Moon(mjw8585@gmail.com)
 * @Date	: 2017. 11. 22.
 */
public class TestClass {

	private static final String path = "user.ser"; //프로젝트 루트에 저장됨. 
	
	public static void main(String[] args) {
		serialize();
		deserialize();
	}
	
	public static void serialize(){
		try{
			FileOutputStream fos = new FileOutputStream(path);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			//String name = "cmd /c dir";
			//String name = "cmd /c type D:\\flag.txt";
			String name = "calc.exe";
			User u1 = new User(name, "1234", "jwmoon@nhn-japan.com", 30); 
			//User u2 = new User("User2", "5678", "teser@gmail.com", 25);
			
			//ArrayList list =new ArrayList<>();
			//list.add(u1);
			//list.add(u2);
			
			System.out.println("Serialize 를 시작합니다. ");
			out.writeObject(u1);
			//out.writeObject(u2);
			//out.writeObject(list);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deserialize(){
		System.out.println("Deserialize 를 시작합니다. ");
		try {
			FileInputStream fis = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			User u1 = (User) ois.readObject();  // 역시 역직렬화할 때는 생성자가 호출되지 않는다.  
			//User u2 = (User) ois.readObject();
			//ArrayList list = (ArrayList) ois.readObject();
			
			System.out.println(u1.toString());
			
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
