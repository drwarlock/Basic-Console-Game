package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Empty implements Card{
	private String emptyName;
	private CardType type = CardType.EMPTY;
	private List<CardValue> emptyValues;

	
	private Empty() {
		emptyName = "Empty";
		emptyValues = emptyValues();
		
	}

	public static Empty getEmpty() {
		return new Empty();
	}
	
	private List<CardValue> emptyValues() {
		List<CardValue> myVals = new ArrayList<CardValue>();
		myVals.add(new CardValue("Empty",0));
		return myVals;
	}
	
	public String getName() {
		return emptyName;
	}
	
	public CardType getType() {
		return type;
	}
	
	public List<CardValue> getValues() {
		return emptyValues;
	}
}
