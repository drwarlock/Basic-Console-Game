package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import cards.Card;
import cards.Monster;
import cards.CardValue;

public class Encounter {
	private int encCardIndex;
	private int monsters;
	private Card myCard;
	private List<Card> encList = new ArrayList<Card>();
	private Character player;
	
	public Encounter(Character player) {
		this.player = player;
		
		addCard();
		
		myCard = encounterCard();
		try {
			chooseAdventurePath(myCard);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
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
	
	private boolean fight() throws InterruptedException {
		boolean complete = false;
		if(monsters<1) {
			List<CardValue> myVals = myCard.getValues(); 
			for(int n = 0; n < myVals.size();n++) {
				if(myVals.get(n).getName()=="ttl") {
					monsters+=myVals.get(n).getValue();
				}
			}
		}
		System.out.println("Total number of monsters "+monsters+"\n");
		
		if(player.getDamage()>monsters) {
			
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
		Thread.sleep(100);
		return complete;
	}
	
	private void chooseAdventurePath(Card myChoices) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		switch(myChoices.getType()) {
			case MONSTER:
				
				System.out.println("You have encountered creatures lurking in the woods \n"
						+"you do your best to remain unseen, but they catch your scent. \n"
						+"(1)Fight or (2)Run");
				
				int choice = Integer.parseInt(scanner.nextLine());
				
				System.out.println(choice);
				
				if(choice==1) {
					while(!fight()) {
						System.out.println("The battle continues... \n");
					}
				}
				
				break;
			default:
				break;
			}
	
	}
		
	
	
}
