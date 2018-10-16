package cards;

public class CardValue {
	
	private String cdName;
	private int cdValue;
	
	public CardValue(String name, int value) {
		cdName = name;
		cdValue = value;
	}
	
	public String getName() {
		return cdName;
	}
	
	public int getValue() {
		return cdValue;
	}

}
