package serialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @brief :
 * @author : Jae-Woong Moon(mjw8585@gmail.com)
 * @Date : 2017. 11. 22.
 */
public class User implements Serializable {

	private String name;
	private String password;
	private String email;
	private int age;
	
	public User() {
		System.out.println("생성자!!!");
	}
	
	public User(String name, String password, String email, int age) {
		System.out.println("생성자!!!");
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		System.out.println("==== readObject!!!");
		in.defaultReadObject();
		//Object obj = in.readObject();
		//System.out.println("name : " + this.name);
		
		// 예를들어, 좀 억지긴 하지만 name에 들어온 문자열을 실행시킨다고 해보자. 
		
		 try
	      {
	         Runtime rt = Runtime.getRuntime();
	         //String cmdString = "cmd /c dir";
	         String cmdString = name;

	         System.out.println(cmdString);
	         Process pr = rt.exec(cmdString);

	         BufferedReader input = new BufferedReader(
	        		 new InputStreamReader(pr.getInputStream()));

	         String line = null;

	         while ((line = input.readLine()) != null)
	         {
	            System.out.println(line);
	         }

	         int exitVal = pr.waitFor();
	         System.out.println("Exited with error code " + exitVal);

	      }
	      catch (Exception e)
	      {
	         System.out.println(e.toString());
	         e.printStackTrace();
	      } 
		
		System.out.println("Reading object has done.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "(" + name + ", " + password + ", " + email + ", " + age + ")";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
