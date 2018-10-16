package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster implements Card{
	private String mName;
	private CardType type = CardType.MONSTER;
	private List<CardValue> mValues = new ArrayList<CardValue>();
	
	private Monster(String mName) {
		this.mName = mName;
		setValues();
	}

	public static Monster getMonster() {
		return new Monster("Chum");
	}
	
	private void setValues() {
		Random random = new Random();
		mValues.add(new CardValue("ttl",random.nextInt(10)));
	}
	
	public String getName() {
		return mName;
	}

	public CardType getType() {
		return type;
	}
	
	public List<CardValue> getValues(){
		return mValues;
	}
}
