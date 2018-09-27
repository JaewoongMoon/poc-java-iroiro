package oracle.dataType;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleResultSet;
import oracle.sql.BFILE;

public class BFileTest {

	
	
	public static void main(String[] args) throws Exception {
		
		// Register the Oracle JDBC driver
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		// Connect to the database
		Connection conn =
		  DriverManager.getConnection ("jdbc:oracle:thin:@192.168.137.5:1521:orcl", "system", "Aegiswall00");

		// It's faster when auto commit is off
		conn.setAutoCommit (false);

		// Create a Statement
		Statement stmt = conn.createStatement ();

		try
		{
		  stmt.execute ("drop directory TEST_DIR");
		}
		catch (SQLException e)
		{
		  // An error is raised if the directory does not exist.  Just ignore it.
			System.out.println("STEP 1. ");
		}
		
		stmt.execute ("create directory TEST_DIR as '/tmp/filetest'");

		try
		{
		  stmt.execute ("drop table test_dir_table");
		}
		catch (SQLException e)
		{
			System.out.println("STEP 2. ");
		  // An error is raised if the table does not exist.  Just ignore it.
		}
		
		
		// Create and populate a table with files
		// The files file1 and file2 must exist in the directory TEST_DIR created
		// above as symbolic name for /private/local/filetest.
		stmt.execute ("create table test_dir_table (x varchar2 (30), b bfile)");
		stmt.execute ("insert into test_dir_table values ('one', bfilename ('TEST_DIR', 'file1'))");
		stmt.execute ("insert into test_dir_table values  ('two', bfilename ('TEST_DIR', 'file2'))");

		// Select the file from the table
		ResultSet rset = stmt.executeQuery ("select * from test_dir_table");
		while (rset.next ())
		{
		  String x = rset.getString (1);
		  BFILE bfile = ((OracleResultSet)rset).getBFILE (2);
		  System.out.println ("B FILE : " + x + " " + bfile);

		  // Dump the file contents
		  dumpBfile (conn, bfile);
		}

		// Close all resources
		rset.close();
		stmt.close();
		conn.close();}

		// Utility function to dump the contents of a Bfile

		static void dumpBfile (Connection conn, BFILE bfile) throws Exception{

		System.out.println ("Dumping file " + bfile.getName());

		System.out.println ("File exists: " + bfile.fileExists());

		System.out.println ("File open: " + bfile.isFileOpen());

		System.out.println ("Opening File: ");

		bfile.openFile();

		System.out.println ("File open: " + bfile.isFileOpen());

		long length = bfile.length();
		System.out.println ("File length: " + length);

		int chunk = 10;

		InputStream instream = bfile.getBinaryStream();

		// Create temporary buffer for read
		byte[] buffer = new byte[chunk];

		// Fetch data  
		while ((length = instream.read(buffer)) != -1)
		{
		  System.out.print("Read " + length + " bytes: ");

		  for (int i=0; i<length; i++)
		    System.out.print(buffer[i]+" ");
		  System.out.println();
		}

		// Close input stream
		instream.close();

		// close file handler
		bfile.closeFile();
	}
	
}
