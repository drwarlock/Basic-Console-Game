package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Armor implements Card{
	private String arName;
	private CardType type = CardType.ARMOR;
	private List<CardValue> arValues;

	enum armor {
		KEVLAR("2,0"),LEATHER("3,0");
		
		private String survDmg;
		
		public String arVals() {
			return this.survDmg;
		}
		
		private armor(String survDmg) {
			this.survDmg = survDmg;
		}
			
	}
	
	private Armor(armor arm) {
		arName = arm.name();
		arValues = armValues(arm.survDmg);
		
	}

	public static Armor randomArmor() {
		final List<armor> potato = Collections.unmodifiableList(Arrays.asList(armor.values()));
		final int potatoSize = potato.size();
		final Random randomPotato = new Random();
		
		return new Armor(potato.get(randomPotato.nextInt(potatoSize)));
		
	}
	
	private List<CardValue> armValues(String arValues) {
		List<CardValue> myVals = new ArrayList<CardValue>();
		String[] vals = arValues.split(",");
		myVals.add(new CardValue("Survival",Integer.parseInt(vals[0].toString())));
		myVals.add(new CardValue("Damage",Integer.parseInt(vals[1].toString())));
		return myVals;


	}
	
	public String getName() {
		return arName;
	}
	
	public CardType getType() {
		return type;
	}
	
	public List<CardValue> getValues() {
		return arValues;
	}
}
