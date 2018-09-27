package authentication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author	Jae-Woong Moon(mjw8585@gmail.com)
 * @brief	
 * @Date	2018. 4. 13.	 
 */
public class APITest {

	public static void main(String[] args) throws IOException {
		// STEP 1. Prepare Connection
		URL url = new URL("http://davis.nhn-japan.com/host/detail");
		String param = "hostId=1572";
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
	    con.setDoOutput(true);
	    con.addRequestProperty("Cookie", "JSESSIONID=CD01AC5180EDBD703F16FAC1DDEF2E41");
	    
	    // STEP 2. Send request
	    DataOutputStream wr = new DataOutputStream (con.getOutputStream());
	    wr.writeBytes(param);
	    wr.close();

	    // STEP 3. Get Response
	    InputStream is = con.getInputStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    StringBuilder response = new StringBuilder();
	    String line;
	    while ((line = rd.readLine()) != null) {
	      response.append(line);
	      response.append('\r');
	    }
	    rd.close();
	    is.close();
	    con.disconnect();
	    System.out.println(response);
	}
}
