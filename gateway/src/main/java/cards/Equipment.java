package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Equipment implements Card{
	private String eqName;
	private CardType type = CardType.EQUIPMENT;
	private List<CardValue> eqValues;

	enum equipment {
		MEDIKIT("2"), FIRSTAID("1");
		
		private String val;
		
		public String eqVals() {
			return this.val;
		}
		
		private equipment(String val) {
			this.val = val;
		}
			
	}
	
	private Equipment(equipment eq) {
		eqName = eq.name();
		eqValues = eqValues(eq.eqVals());
		
	}

	public static Equipment randomEquipment() {
		final List<equipment> potato = Collections.unmodifiableList(Arrays.asList(equipment.values()));
		final int potatoSize = potato.size();
		final Random randomPotato = new Random();
		
		return new Equipment(potato.get(randomPotato.nextInt(potatoSize)));
		
	}
	
	private List<CardValue> eqValues(String eqValues) {
		List<CardValue> myVals = new ArrayList<CardValue>();
		myVals.add(new CardValue("Health",Integer.parseInt(eqValues)));
		return myVals;


	}
	
	public String getName() {
		return eqName;
	}
	
	public CardType getType() {
		return type;
	}
	
	public List<CardValue> getValues() {
		return eqValues;
	}
}
