package Heroes;

import AttacksAndStrategyPattern.ChiefSpecial;
import Dungeon.DungeonCharacter;
import HeroAndMonster.Hero;
import Keyboard.Keyboard;
public class Chief extends Hero
{
//-----------------------------------------------------------------
    public Chief()
	{
		super("Chief", 250, 5, .9, 10, 90, .5);
		special = new ChiefSpecial();
    }//end constructor


//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Double Spear size and slice opponent");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    if(choice == 1) 
			{
		    	System.out.println(name + " slices " +
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
   

}//end class