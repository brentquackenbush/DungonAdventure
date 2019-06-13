package Dungeon;
import java.util.ArrayList;

import HeroAndMonster.Hero;
import HeroAndMonster.Monster;
import HeroAndMonster.MonsterFactory;
import Heroes.Warrior;
import Keyboard.Keyboard;
import Monsters.Ogre;

public class RoomEvent 
{

	private char exit = 'O';
	
	
	public void test(Hero hero, Room room)
	{
		char[][] dungeonRoom = room.getCharArray();
		roomEncounter(hero,dungeonRoom, room);
		
	}
	
	public void roomEncounter(Hero hero,char[][] room, Room currentRoom)
	{
		
		if(room[1][1] == 'M') 
		{
			multipleItems(hero);
		}
		if(room[1][1] == 'P')
		{
			enterPit(hero);
		}
		if(room[1][1] == 'O')
		{
			enterExit(room,hero);
		}
		if(room[1][1] == 'H')
		{
			hero.addHealingPot();
			
		}
		if(room[1][1] == 'X')
		{
			Battle battle = new Battle();
			battle.battle(hero);
			
		}
		if(room[1][1] == '1' || room[1][1] == '2' || room[1][1] == '3' || room[1][1] == '4')
		{
			hero.addPillar(room[1][1]);
		}

		currentRoom.changeRoomEvent('E');
		
	}
	
	public void multipleItems(Hero hero)
	{
		Battle battle = new Battle();
		int randomNum = (int)Math.random() * 99 + 1;
		Potion potion = new Potion();
		if(randomNum < 33) 
		{
			enterPit(hero);
			battle.battle(hero);
		}
		else if(randomNum > 33 && randomNum < 66)
		{
			potion .addHealingPot();
			enterPit(hero);
		}
		else if(randomNum > 67)
		{
			potion.addHealingPot();
			battle.battle(hero);
		}
	}
	
	public void enterPit(Hero hero)
	{
		int pitDamage = (int)(Math.random() * 20) + 1;
		hero.subtractHitPoints(pitDamage);
	}
	
	public void enterExit(char[][] room,Hero theHero)
	{
		
		if(room[1][1] == exit && theHero.getPillarSize() == 4)
		{
			System.out.println("-----------------------------------------------------");
			System.out.println("YOU HAVE WON THE GAME CONGRADULATIONS!!!");
			System.out.println("YOU ARE THE MIGHTIEST WARRIOR IN THE OO KINGDOM");
			System.out.println("-----------------------------------------------------");
		}
		else
		{
			System.out.println("Exit is locked, you don't have all the PILLARS!");
		}
	}
	
	
	
	
}
	
