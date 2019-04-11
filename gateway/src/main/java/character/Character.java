package character;

import java.util.ArrayList;
import java.util.List;

import cards.Armor;
import cards.Card;
import cards.CardValue;
import cards.Empty;
import cards.Equipment;
import cards.Weapon;

public class Character {
	private ArrayList<Character_Ability> stats = new ArrayList<Character_Ability>(); 
	private int myHealth;
	private String myName;
	private Card[] myHand = new Card[3];
	
	public Character(String name) {
		myName = name;
		getStartHand();
		setHealth();
	}
	
	private void getStartHand() {
		//this needs to be adjusted to random cards.
		
		myHand[0] = Weapon.randomWeapon();
		myHand[1] = Armor.randomArmor();
		myHand[2] = Equipment.randomEquipment();
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
		}else {
			alive = bandage();
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
	
	public void rest() {
		if(myHealth<2) {
			myHealth++;
		}
	}
	
	public boolean bandage() {
		if(myHealth<1) {
			for(int i = 0; i < myHand.length; i++) {
				List<CardValue> myVals = myHand[i].getValues(); 
				for(int n = 0; n < myVals.size();n++) {
					if(myVals.get(n).getName()=="Health") {
						myHealth+=myVals.get(n).getValue();
						myHand[i] = Empty.getEmpty();
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
