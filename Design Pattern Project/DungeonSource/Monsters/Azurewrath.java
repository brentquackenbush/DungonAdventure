package Monsters;

import Dungeon.DungeonCharacter;
import HeroAndMonster.Monster;

public class Azurewrath extends Monster
{
	public Azurewrath()
	{
		super("Azurewrath the mighty", 160, 3, .85, .1, 30, 50, 30, 35);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " uses his fierce attack speed to slice " +
							opponent.getName() + ":");
		super.attack(opponent);

	}
}
