package Dungeon;
import HeroAndMonster.Hero;

public class Potion
{

	private int healingPotCounter = 0;
	
	public void useHealingPotion(Hero hero)
	{
		int healingAmount = 5 + (int)(Math.random() * ((10 - 5) + 1));
		if(healingPotCounter > 0)
		{
			hero.addHitPoints(healingAmount);
			System.out.println(this.healingPotCounter + " healing potions left");
		}
		else
		{
			System.out.println("You do not have any available HEALING POTIONS!");
		}
	}
	
	public void addHealingPot()
	{
		this.healingPotCounter = this.healingPotCounter + 1;
	}
	
	
	
	
	
	
}
