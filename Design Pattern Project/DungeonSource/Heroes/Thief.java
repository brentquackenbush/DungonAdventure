package Heroes;

import AttacksAndStrategyPattern.SurpriseAttack;
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

public class Thief extends Hero
{

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);
		
		special = new SurpriseAttack();
    }//end constructor



    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;
		
		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

			if(choice == 1) 
			{
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

}