package Dungeon;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import HeroAndMonster.Hero;
import HeroAndMonster.HeroFactory;
import Keyboard.Keyboard;

public class DungeonAdventure 
{

	public static void main(String[] args)
	{
		Dungeon dungeon = new Dungeon();
		Hero theHero;
		String playAgain = "y";
		do
		{
			System.out.println("WELCOME TO DUNGEON ADVENTURES A WHERE YOU MUST OBTAIN ALL 4 PILLARS OF OO\n"
					+ "ABSTRACTION-----ENCAPSULATION-----INHERITANCE-----POLYMORPHISM\n"
					+ "These will be represented by numbers 1, 2, 3, and 4,\n"
					+ "-------------------------------------------------------------------------------"
					);
			theHero = chooseHero();
			theHero.setLocation(dungeon.getEntrance());
			do 
			{
				if(theHero.getPillarSize() == 4)
					break;
				
				menu(theHero);
			}while(!endGame(theHero));

		}while(playAgain.equalsIgnoreCase("y"));
	}
	public static void menu(Hero theHero)
	{
		Room room;
		RoomEvent roomEvent = new RoomEvent();
		Dungeon dungeon = new Dungeon();
		Scanner scan = new Scanner(System.in);
		int options;
		String move = null;

		System.out.println(dungeon.getRoom(theHero.getLocation()));
		roomEvent.test(theHero, dungeon.getRoom(theHero.getLocation()));
		dungeon.getRoom(theHero.getLocation()).changeRoomEvent('E');
		System.out.println("1.Move");
		System.out.println("2.Take Healing potion");
		System.out.println("3.Print out numbers of pillars you own");
		System.out.println("4.Print out whole Dungeon");
		System.out.println("-------------------------------------------");
		options = scan.nextInt();
		
		if(theHero.getPillarSize() == 4)
			return;
		if(options == 1)
		{
		//System.out.println("To move: WSAD  W for north, A for west, S for south, D for east");
		//move = scan.nextLine();
		//dungeon.canMove(move, theHero);
			moveChoice(dungeon,theHero);
		}
		else if(options == 2)
		{
			System.out.println("HealthPoints before: "+theHero.getHitPoints());
			theHero.useHealingPotion(theHero);
			System.out.println("HealthPoints after: " +theHero.getHitPoints());
		}
		else if(options == 3)
		{
			System.out.println(theHero.getPillarSize());
		}
		else if(options == 4)
		{
			printFullDungeon();
		}

	}
	public static void moveChoice(Dungeon dungeon, Hero theHero)
	{
		Scanner scan = new Scanner(System.in);
		String move = null;
		System.out.println(dungeon.getRoom(theHero.getLocation()));
		System.out.println("To move: WSAD  W for north, A for west, S for south, D for east");
		move = scan.nextLine();
		dungeon.canMove(move, theHero);
	}

	public static Hero chooseHero()
	{
		HeroFactory heroFactory = new HeroFactory();
		int choice;

		System.out.println("Choose a hero:\n" +
				"1. Warrior\n" +
				"2. Sorceress\n" +
				"3. Thief\n" +
				"4. Chief\n"+
				"5. Superman");
		choice = Keyboard.readInt();

		return heroFactory.createHero(choice);
	}
	public static void printFullDungeon()
	{
		Scanner scan = null;
		try {
			scan = new Scanner(new File("printDungeon"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scan.hasNext())
		{
			System.out.println(scan.nextLine());
		}
	}
	public static boolean endGame(Hero hero)
	{
		if(hero.getHitPoints() == 0)
			return true;
		else 
			return false;
	}
}


