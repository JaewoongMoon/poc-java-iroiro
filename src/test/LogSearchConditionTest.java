package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import domain.LogSearchCondition;
import domain.LogTable;

public class LogSearchConditionTest {

	@Test
	public void getLogTablePatternTest(){
		// CASE 1. DBMS   
		LogSearchCondition c = new LogSearchCondition();
		c.setServiceType("");
		c.setLogType("");
		c.setLogSeperated(false);
		assertThat(c.getLogTablePattern(), is(LogTable.DBMS));
		
		// CASE 2. FTP
		c.setServiceType("FTP");
		assertThat(c.getLogTablePattern(), is(LogTable.FTP));
		
		// CASE 3. TELNET 
		c.setServiceType("TELNET");
		assertThat(c.getLogTablePattern(), is(LogTable.TELNET));
		
		// CASE 4.ACL_DBMS
		c.setServiceType("DBMS");
		c.setLogType("ACL");
		assertThat(c.getLogTablePattern(), is(LogTable.ACL_DBMS));
		
		// CASE 5. ACL_FTP
		c.setServiceType("FTP");
		c.setLogType("ACL");
		assertThat(c.getLogTablePattern(), is(LogTable.ACL_FTP));
		
		// CASE 6. ACL_TELNET
		c.setServiceType("TELNET");
		c.setLogType("ACL");
		assertThat(c.getLogTablePattern(), is(LogTable.ACL_TELNET));
		
		// CASE 7. WAS
		c.setServiceType("");
		c.setLogType("");
		c.setLogSeperated(true);
		assertThat(c.getLogTablePattern(), is(LogTable.WAS));
		
		// CASE 8. IPS
		c.setServiceType("");
		c.setLogType("IPS");
		c.setLogSeperated(false);
		assertThat(c.getLogTablePattern(), is(LogTable.IPS));
	}
}
