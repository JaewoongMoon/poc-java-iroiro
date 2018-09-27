/**
 * @ SqlInjection.java
 * 
 * Copyright 2016 NHN Techorus Corp. All rights Reserved. 
 * NHN Techorus PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <pre>
 * sqlinjection
 * SqlInjection.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(jwmoon@nhn-techorus.com)
 * @Date	: 2016. 4. 12.
 */
public class SqlInjection {

	public static void main(String[] args) throws SQLException {
		Connection c = null;
		String userid = "id";
		String passwd = "1234";
		
		String query = "SELECT * FROM users WHERE userid = ? AND password = ?";
		PreparedStatement stmt = c.prepareStatement(query);
		//stmt.setString(parameterIndex, x);
		//stmt.getq
		
	}
}
