package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import character.Character;
import gateway.Entry;

public class Encounter {
	private boolean enc = true;
	private int encCardIndex;
	private int monsters;
	private Card myCard;
	private List<Card> encList = new ArrayList<Card>();
	private Character player;
	
	public Encounter(Character player) {
		this.player = player;
		
		addCard();
		
		myCard = encounterCard();
		chooseAdventurePath(myCard);
		
	}
	
	private void addCard() {
		//this should randomly add several cards into encounter list
		encList.add(Monster.getMonster());
	}
	
	private Card encounterCard() {
		return encounterCard(getRandom(encList.size()));
	}
	
	private Card encounterCard(int index) {
		encCardIndex = index;
		return encList.get(index);
	}
	
	private int getRandom(int bound) {
		Random random = new Random();
		return random.nextInt(bound);
	}
	
	private void chooseAdventurePath(Card myChoices) {
		switch(myChoices.getType()) {
			case MONSTER:
				
				System.out.println("You have encountered creatures lurking in the woods \n"
						+"you do your best to remain unseen, but they catch your scent. \n"
						+"(1)Fight or (2)Run");
				
				int choice = Integer.parseInt(Entry.scanner.nextLine());
				
				//System.out.println(choice);
				
				if(choice==1) {
					while(!fight()) {
						System.out.println("The battle continues... \n");
					}
				}else if(choice==2) {
					System.out.println("Reason is the better part of valor, the dead can call no man a coward.\n"
							+"You decide to escape and avoid the confrontation\n");
					enc = false;
					player.rest();
					encList.remove(encCardIndex);
				}else {
					System.out.println("You're mind races and you press the wrong key on the keyboard\n"
							+"your error may cost you your life as the monsters charge.\n");
					while(!fight()) {
						System.out.println("The battle continues... \n");
					}
				}
				break;
			default:
				break;
			}
		myCard = null;
		encList = null;
	}
	
	public boolean getEnc() {
		return enc;
	}
	
	private boolean fight() {
		System.out.println("You stand your ground and fight.\n You have "+player.getHealth()+" health remaining.\n");
		
		boolean complete = false;
		if(monsters<1) {
			List<CardValue> myVals = myCard.getValues(); 
			for(int n = 0; n < myVals.size();n++) {
				if(myVals.get(n).getName()=="ttl") {
					monsters+=myVals.get(n).getValue();
				}
			}
			System.out.println("There are "+monsters+" creatures. \n");
		}else {
			System.out.println("There are "+monsters+" creatures. \n");
		}
		
		if(player.getDamage()>=monsters) {
			
			encList.remove(encCardIndex);
			//monsters dead, remove card from encounter
			System.out.println("The monsters are dead");
			complete = true;
		}else {
			monsters-=player.getDamage();
			System.out.println("You have killed "+player.getDamage()+" monsters \n"
					+"the remaining "+ monsters +" attack, you're survival rating is "+player.getSurvival());
			
			//monsters number reduced then recompared
			if(monsters>player.getSurvival()) {
				if(!player.getSurvived()) {
						System.out.println("You are dead... probably of dysentary... but it could be monsters\n");
						complete = true;
				}else {
					System.out.println("You've been biten, you have "+player.getHealth()+" remaining\n");
				}
			}
		}
		return complete;
	}	
	
}
