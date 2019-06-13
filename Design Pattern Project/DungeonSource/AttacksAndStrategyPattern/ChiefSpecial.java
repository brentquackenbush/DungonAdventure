package AttacksAndStrategyPattern;
import Dungeon.DungeonCharacter;
import HeroAndMonster.Hero;

public class ChiefSpecial implements Attack
{


	@Override
	public void attack(DungeonCharacter opponent, Hero hero) {
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(hero.getName() + " spear doubled it's size and SLICES for " + blowPoints
					+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end slice succeeded
		else
		{
			System.out.println(hero.getName() + " failed double to his spear size");
			System.out.println();
		}

	}



}


