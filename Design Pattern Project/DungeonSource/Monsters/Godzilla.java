package Monsters;

import Dungeon.DungeonCharacter;
import HeroAndMonster.Monster;

public class Godzilla extends Monster
{
	public Godzilla()
	{
		super("G0DZILLA", 800, 1, .1, .1, 100, 200, 0, 0);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " uses his fierce attack speed to slice " +
							opponent.getName() + ":");
		super.attack(opponent);

	}
}
