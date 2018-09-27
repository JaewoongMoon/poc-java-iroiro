package kerberos;

import javax.security.auth.*;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import com.sun.security.auth.callback.TextCallbackHandler;

/**
 * @author	Jae-Woong Moon(mjw8585@gmail.com)
 * @brief	
 * @Date	2018. 1. 30.	 
 */
/**
 * This JaasAcn application attempts to authenticate a user and reports whether
 * or not the authentication was successful.
 */
public class JaasAcn {

	public static void main(String[] args) {
		// Obtain a LoginContext, needed for authentication. Tell
		// it to use the LoginModule implementation specified by
		// the entry named "JaasSample" in the JAAS login
		// configuration file and to also use the specified
		// CallbackHandler.
		System.setProperty("java.security.krb5.realm", "HANGAME.JP");
		System.setProperty("java.security.krb5.kdc", "kerberos1.hangame.jp");
		System.setProperty("java.security.auth.login.config", "jaas.conf");
		//System.out.println(System.getProperty("java.security.krb5.realm"));
		//System.out.println(System.getProperty("java.security.auth.login.config"));

		LoginContext lc = null;
		try {
			System.out.println("STEP 1. LoginContext를 만듭니다...");
			lc = new LoginContext("JaasSample", new TextCallbackHandler());

		} catch (LoginException le) {
			System.err.println("[LoginException] Cannot create LoginContext. " + le.getMessage());
			System.exit(-1);
		} catch (SecurityException se) {
			System.err.println("[SecurityException] Cannot create LoginContext. " + se.getMessage());
			System.exit(-1);
		}

		try {
			System.out.println("STEP 2. Login을 시도합니다...");
			// attempt authentication
			lc.login();

		} catch (LoginException le) {

			System.err.println("Authentication failed: ");
			System.err.println("  " + le.getMessage());
			System.exit(-1);

		}

		System.out.println("Authentication succeeded!");

	}
}
