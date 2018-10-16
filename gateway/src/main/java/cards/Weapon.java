package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Weapon implements Card{
	private String weName;
	private CardType type = CardType.WEAPON;
	private List<CardValue> weValues;

	enum weapons {
		SHOTGUN("0,4"),AK47("0,3");
		
		private String survDmg;
		
		public String wepVals() {
			return this.survDmg;
		}
		
		private weapons(String survDmg) {
			this.survDmg = survDmg;
		}
			
	}
	
	private Weapon(weapons wep) {
		weName = wep.name();
		weValues = weaponValues(wep.survDmg);
		
	}

	public static Weapon randomWeapon() {
		final List<weapons> potato = Collections.unmodifiableList(Arrays.asList(weapons.values()));
		final int potatoSize = potato.size();
		final Random randomPotato = new Random();
		
		return new Weapon(potato.get(randomPotato.nextInt(potatoSize)));
		
	}
	
	private List<CardValue> weaponValues(String weaponValues) {
		List<CardValue> myVals = new ArrayList<CardValue>();
		String[] vals = weaponValues.split(",");
		myVals.add(new CardValue("Survival",Integer.parseInt(vals[0].toString())));
		myVals.add(new CardValue("Damage",Integer.parseInt(vals[1].toString())));
		return myVals;


	}
	
	public String getName() {
		return weName;
	}
	
	public CardType getType() {
		return type;
	}
	
	public List<CardValue> getValues() {
		return weValues;
	}
}
