package AttacksAndStrategyPattern;
import Dungeon.DungeonCharacter;
import HeroAndMonster.Hero;

public class CrushingBlow implements Attack{

	@Override
	public void attack(DungeonCharacter opponent, Hero hero) {
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(hero.getName() + " lands a CRUSHING BLOW for " + blowPoints
					+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(hero.getName() + " failed to land a crushing blow");
			System.out.println();
		}

	}



}
