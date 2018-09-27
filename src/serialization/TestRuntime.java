package serialization;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author	Jae-Woong Moon(mjw8585@gmail.com)
 * @brief	
 * @Date	2018. 6. 20.	 
 */
public class TestRuntime {

	public static void main(String args[])
	   {
	      try
	      {
	         Runtime rt = Runtime.getRuntime();
	         String cmdString = "cmd /c type D:\\flag.txt";

	         System.out.println(cmdString);
	         Process pr = rt.exec(cmdString);

	         BufferedReader input = new BufferedReader(new InputStreamReader(
	                                                   pr.getInputStream()));

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
	   }
}
