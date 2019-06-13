package Monsters;

import Dungeon.DungeonCharacter;
import HeroAndMonster.Monster;

public class DarkKnight extends Monster
{

    public DarkKnight()
	{
		super("Dark Knight the Archfiend", 400, 1, .8, 0, 10, 40, 0, 0);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " swing's his shadow sword at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}
}