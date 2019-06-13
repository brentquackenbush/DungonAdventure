package Heroes;



import AttacksAndStrategyPattern.LaserBeam;
import AttacksAndStrategyPattern.SorceressSpecial;
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



public class Superman extends Hero
{
//-----------------------------------------------------------------
    public Superman()
	{
		super("Superman", 50000, 10, 20, 100, 500, 10);
		special = new LaserBeam();

    }//end constructor


//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. LaserBeam");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    if(choice == 1) 
			{
		    	System.out.println(name + " scissor kicks and punches " +
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

		} while(numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0);

    }//end overridden method
   

}