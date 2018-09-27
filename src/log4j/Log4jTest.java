package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
	
	Logger log = Logger.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		
		Log4jTest t = new Log4jTest();
		t.PrintLog();
		
	}
	
	public void PrintLog(){
		//System.out.println(System.getProperty("user.dir"));
		//PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\log4j\\log4j.xml");
		//PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\log4j\\log4j.properties");
		
		log.debug("======= PRINT DEBUG");
	}
}
