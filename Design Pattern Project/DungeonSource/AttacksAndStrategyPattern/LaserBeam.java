package AttacksAndStrategyPattern;

import Dungeon.DungeonCharacter;
import HeroAndMonster.Hero;

public class LaserBeam implements Attack
{

		public void attack(DungeonCharacter opponent, Hero hero) {
			if (Math.random() <= .4)
			{
				int laserBeam = (int)(Math.random() * 5000) + 1;
				System.out.println(hero.getName() + " laserBeams " +laserBeam
						+ " damage!");
				opponent.subtractHitPoints(laserBeam);
			}//end blow succeeded
			else
			{
				System.out.println(hero.getName() + " failed to land a crushing blow");
				System.out.println();
			}

		}



}


