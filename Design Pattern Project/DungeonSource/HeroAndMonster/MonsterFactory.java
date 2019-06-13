package HeroAndMonster;

import Monsters.Azurewrath;
import Monsters.DarkKnight;
import Monsters.Godzilla;
import Monsters.Gremlin;
import Monsters.Ogre;
import Monsters.Skeleton;

public class MonsterFactory 
{
	
	public Monster createMonster(int random)
	{
		
		if(random == 1)
		{
			return new Skeleton();
		}
		else if(random == 2)
		{
			return new Ogre();
		}
		else if(random == 3)
		{
			return new Gremlin();
		}
		else if(random == 4)
		{
			return  new DarkKnight();
		}
		else if(random == 5)
		{
			return new Azurewrath();
		}
		else
		{
			return new Godzilla();
		}

	
	}
}
