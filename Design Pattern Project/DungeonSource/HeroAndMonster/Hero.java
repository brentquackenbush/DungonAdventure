package HeroAndMonster;
import java.util.ArrayList;

import AttacksAndStrategyPattern.Attack;
import Dungeon.DungeonCharacter;
import Dungeon.Potion;
import Keyboard.Keyboard;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;
	public int numTurns;
	protected Attack special;
	HeroFactory heroFactory;
	private int[] location;
	private int x;
	private int y;
	private Potion potion = new Potion();
	private ArrayList<Character> pillars = new ArrayList<Character>();
	private int healingPotCounter = 0;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  public void readName()
  {
		System.out.print("Enter character name: ");
		name = Keyboard.readString();
  }//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(name + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices
	
	public void setLocation(int[] locations)
	{
		this.location = locations;
	}
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.location[0] = x;
		this.location[1] = y;
	}
	
	public int[] getLocation()
	{
		return this.location;
	}
	public void addPillar(char pillar)
	{
		if(pillars.contains(pillar))
			System.out.println("YOU ALREADY ACQUIRED THIS PILLAR");
		else
			pillars.add(pillar);
	}
	
	public int getPillarSize()
	{
		return this.pillars.size();
	}
	
	
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

	
}//end Hero class