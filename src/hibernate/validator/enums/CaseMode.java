package hibernate.validator.enums;

public enum CaseMode {

	UPPER(2),
	LOW(1),
	NONE(0);
	
	private int value;
	
	CaseMode(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
}
