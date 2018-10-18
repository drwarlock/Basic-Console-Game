package gateway;

import java.util.Scanner;
import character.Character;
import character.Encounter;

public class Entry {
	public static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		
		//text sections should be redone
		//create character

		System.out.println("To interact with the prompts simply answer the question, \n"
				+"if a prompt includes (x) simply type the number x.\n"
				+"What is your name? \n\n");
		
		String charName = scanner.nextLine();
		Character myChar = new Character(charName);
		

		System.out.println("Welcome "+myChar.getName()+", adventure awaits... \n"
				+"The end came quick for most, but not you. You've managed to create makeshift camp \n"
				+"and get a moments respite. After a short rest you begin to hear the skitteing of the \n"
				+"creatures wandering just beyond the light created by your campfire.\n");
		try {
			int i = 1;
		while(myChar.getAlive()) {
			//System.out.print(myChar.getAlive());
			System.out.print("Turn :"+i+"\n");
			Encounter myenc = new Encounter(myChar);
			i++;
		}
		scanner.close();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}