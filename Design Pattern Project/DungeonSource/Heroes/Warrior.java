package Heroes;

import AttacksAndStrategyPattern.CrushingBlow;
import Dungeon.DungeonCharacter;
import HeroAndMonster.Hero;
import Keyboard.Keyboard;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */




public class Warrior extends Hero 
{

	
    public Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2);
		special = new CrushingBlow();
    }//end constructor
    
    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;
		do
		{
			System.out.println("1. Attack Opponent");
			System.out.println("2. Crushing Blow on Opponent");
			System.out.print("Choose an option: ");
			choice = Keyboard.readInt();

			if(choice == 1) 
			{
				System.out.println(name + " swings a mighty sword at " +
						opponent.getName() + ":");
				super.attack(opponent);
			}
			if(choice == 2) 
			{
				special.attack(opponent, this);
			}
			else
				System.out.println("invalid choice!");
			
			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);
	}

    
  

	

}//end Hero class