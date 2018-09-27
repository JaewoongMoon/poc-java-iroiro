package domain;

public enum LogTable {
	
	 DBMS(1){
		@Override public String tableName(){
				return "db_user_xx#db_query_xx";
			}
	},FTP(2){
		@Override public String tableName(){
			return "ftp_user_xx#ftp_cmd_xx";
		}
	}, TELNET(3){
		@Override public String tableName(){
			return "shell_user_xx#shell_cmd_xx";
		}
	}, ACL_DBMS(4){
		@Override public String tableName(){
			return "db_acl_xx";
		}
	}, ACL_FTP(5){
		@Override public String tableName(){
			return "ftp_acl_xx";
		}
	}, ACL_TELNET(6){
		@Override public String tableName(){
			return "shell_acl_xx";
		}
	}, WAS(7){
		@Override public String tableName(){
			return "was_user_xx";
		}
	}, IPS(8){
		@Override public String tableName(){
			return "ips_log_xx";
		}
	};
	
	
	private final int value;
	
	LogTable(int value){
		this.value = value;
	}
	
	public int intValue(){
		return value;
	}
	
	public String tableName(){
		return tableName();
	}
	
	public static LogTable valueOf(int value){
		switch(value){
			case 1 : return DBMS;
			case 2 : return FTP;
			case 3 : return TELNET;
			case 4 : return ACL_DBMS;
			case 5 : return ACL_FTP;
			case 6 : return ACL_TELNET;
			case 7 : return WAS;
			case 8 : return IPS;
			default : throw new AssertionError("Unkown value : " + value);
		}
	}
	
	
}
