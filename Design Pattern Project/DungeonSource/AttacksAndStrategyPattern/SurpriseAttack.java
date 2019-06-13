package AttacksAndStrategyPattern;
import Dungeon.DungeonCharacter;
import HeroAndMonster.Hero;

public class SurpriseAttack implements Attack {

	@Override
	public void attack(DungeonCharacter opponent, Hero hero) 
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								hero.getName() + " gets an additional turn.");
			hero.numTurns++;
			hero.attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    hero.attack(opponent);
		
	}

}
