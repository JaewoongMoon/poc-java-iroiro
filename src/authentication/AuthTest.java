package authentication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author	Jae-Woong Moon(mjw8585@gmail.com)
 * @brief	
 * @Date	2018. 4. 13.	 
 */
public class AuthTest {

	public static void main(String[] args) throws IOException {
		// STEP 1. Prepare Connection
		URL url = new URL("http://10.32.34.56:8080/drs/exeLogin");
		String param = "userId=admin&passwd=1q2w#E$R";  // user id and password
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
	    con.setDoOutput(true);
	    con.setInstanceFollowRedirects(false);
	    
	    // STEP 2. Send request
	    DataOutputStream wr = new DataOutputStream (con.getOutputStream());
	    wr.writeBytes(param);
	    wr.close();

	    // STEP 3. Get sessionId from response   
	    Map<String, List<String>> map = con.getHeaderFields();
	    String sessionIdField = "";   
	    for(String cookie: map.get("Set-Cookie")) {
			for(String field: cookie.split(";")) {  // "JSESSIONID=xxxx; Path=/; HttpOnly" -> "JSESSIONID=xxxx"
				if(field.contains("JSESSIONID")) {
					sessionIdField = field;
					break;
				}
			}
		}
	    System.out.println(sessionIdField);
	    con.disconnect();
	}
}
