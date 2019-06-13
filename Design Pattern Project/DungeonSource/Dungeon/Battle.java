package Dungeon;
import HeroAndMonster.Hero;
import HeroAndMonster.Monster;
import HeroAndMonster.MonsterFactory;
import Keyboard.Keyboard;
import Monsters.Azurewrath;
import Monsters.DarkKnight;
import Monsters.Gremlin;
import Monsters.Ogre;
import Monsters.Skeleton;

public class Battle
{
    private MonsterFactory monsterFactory;
	private Potion potion;
	Monster theMonster;
	int choice = (int)(Math.random() * 6) + 1;

	public Battle()
	{
		monsterFactory= new MonsterFactory();
	}
	
    public void battle(Hero hero)
	{	

    	theMonster = monsterFactory.createMonster(choice);
		do
		{
		   
			battle(hero, theMonster);

		} while (isDefeated(theMonster));

    }



	
	public boolean isDefeated(Monster monster)
	{
		if(monster.getHitPoints() == 0)
			return false;
		return true;
	}
	

	public void battle(Hero theHero, Monster theMonster)
	{

		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive())
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);


		}//end battle loop

		if (!theMonster.isAlive()) {
			System.out.println(theHero.getName() + " was victorious!");
			randomPotionDrop();
		}
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");


	}//end battle method
	
	public void randomPotionDrop()
	{
		int randomNum = (int)Math.random() * 100 +1;
		if(randomNum >= 90) 
		{
			System.out.println("Enemy has dropped a healing potion. Potion added to BAG");
			potion.addHealingPot();
		}
			
	}


}//end Battle class