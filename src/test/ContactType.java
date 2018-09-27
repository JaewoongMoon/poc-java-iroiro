package test;


public enum ContactType {

	NONE(0){
		@Override
		public String getLabelText() {
			return "";
		}
	},
	PRODUCT_QUESTION(1){
		@Override
		public String getLabelText() {
			return "製品に関するお問い合わせ";
		}
	},
	TECHNICAL_SUPPORT(2){
		@Override
		public String getLabelText() {
			return "技術サポート";
		}
	},
	PARTNER_QUESTION(3){
		@Override
		public String getLabelText() {
			return "パートナーに関するお問い合わせ";
		}
	},
	STOP_MAILING(4){
		@Override
		public String getLabelText() {
			return "メール配信の停止";
		}
	} ;
	
	private final int value;
	
	ContactType(int value){
		this.value = value;
	}
	
	public int intValue(){
		return value;
	}
	
	public String getLabelText(){
		return getLabelText();
	}
	
	public static ContactType valueOf(int value){
		switch(value){
		case 0 : return NONE;
		case 1 : return PRODUCT_QUESTION;
		case 2: return TECHNICAL_SUPPORT;
		case 3 : return PARTNER_QUESTION;
		case 4 : return STOP_MAILING;
		default : throw new AssertionError("Unkown Value : " + value);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ContactType.PARTNER_QUESTION.getLabelText());
	}
	
}
