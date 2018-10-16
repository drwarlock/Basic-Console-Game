package character;

import java.util.List;

import cards.Armor;
import cards.Card;
import cards.CardValue;
import cards.Weapon;

public class Character {
	private int myHealth;
	private String myName;
	private Card[] myHand = new Card[2];
	
	public Character(String name) {
		myName = name;
		getStartHand();
		setHealth();
	}
	
	private void getStartHand() {
		myHand[0] = Weapon.randomWeapon();
		myHand[1] = Armor.randomArmor();
	}
	
	private void setHealth() {
		myHealth = 2;
	}
	
	public int getHealth() {
		return myHealth;
	}
	
	public boolean getAlive() {
		boolean alive = false;
		if(myHealth>0) {
			alive = true;
		}
		return alive;
	}
	
	public boolean getSurvived() {
		myHealth--;
		
		boolean alive = false;
		if(myHealth > 0) {
			alive = true;
		}
		return alive;
	}
	
	public String getName() {
		return myName;
	}
	
	public Card[] getHand() {
		return myHand;
	}
	
	public int getSurvival() {
		int survival = 0;
		for(int i = 0; i < myHand.length; i++) {
			List<CardValue> myVals = myHand[i].getValues(); 
			for(int n = 0; n < myVals.size();n++) {
				if(myVals.get(n).getName()=="Survival") {
					survival+=myVals.get(n).getValue();
				}
			}
		}
		return survival;
	}

	public int getDamage() {
		int damage = 0;
		for(int i = 0; i < myHand.length; i++) {
			List<CardValue> myVals = myHand[i].getValues(); 
			for(int n = 0; n < myVals.size();n++) {
				if(myVals.get(n).getName()=="Damage") {
					damage+=myVals.get(n).getValue();
				}
			}
		}
		return damage;
	}
	
}
