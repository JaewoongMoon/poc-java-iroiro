package domain;

public class LogSearchCondition {

	private LogTable logTablePattern;
	
	private String serviceType;
	
	private String logType;
	
	private boolean logSeperated;
	
	private boolean conDetailTime;

	private boolean isLogType(String value){
		if(logType.equals(value)){
			return true;
		}else{
			return false;
		}
	}
	
	public LogSearchCondition(String serviceType, String logType, boolean logSeperated) {
		this.serviceType = serviceType;
		this.logType = logType;
		this.logSeperated = logSeperated;
	}
	
	public LogSearchCondition(String serviceType, String logType) {
		this.serviceType = serviceType;
		this.logType = logType;
	}
	
	public LogSearchCondition() {
	}
	
	public LogTable getLogTablePattern() {
		//if(logTablePattern == null){
			if(serviceType.equals("FTP")){
				
				if(isLogType("ACL")){
					logTablePattern =  LogTable.ACL_FTP;
				}else{
					logTablePattern = LogTable.FTP;
				}
			}else if(serviceType.equals("TELNET")){
				
				if(isLogType("ACL")){
					logTablePattern = LogTable.ACL_TELNET;
				}else{
					logTablePattern = LogTable.TELNET;
				}
			}else{
				
				if(isLogType("ACL")){
					logTablePattern = LogTable.ACL_DBMS;
				}else if(isLogType("IPS")){
					logTablePattern = LogTable.IPS;
				}else{
					if(logSeperated){
						logTablePattern = LogTable.WAS;
					}else{
						logTablePattern = LogTable.DBMS;
					}
				}
			}
			
		//}
		return logTablePattern;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public boolean isLogSeperated() {
		return logSeperated;
	}

	public void setLogSeperated(boolean logSeperated) {
		this.logSeperated = logSeperated;
	}

	public boolean isConDetailTime() {
		return conDetailTime;
	}

	public void setConDetailTime(boolean conDetailTime) {
		this.conDetailTime = conDetailTime;
	}
	
	
	
}
