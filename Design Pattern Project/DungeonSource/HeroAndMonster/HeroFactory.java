package HeroAndMonster;
import Heroes.Chief;
import Heroes.Sorceress;
import Heroes.Superman;
import Heroes.Thief;
import Heroes.Warrior;

public class HeroFactory
{
	
	public Hero createHero(int choice)
	{
	
		if(choice == 1)
		{
			return new Warrior();
		}
		else if(choice == 2)
		{
			return new Sorceress();
		}
		else if(choice ==3)
		{
			return new Thief();
		}
		else if(choice == 4) 
		{
			return new Chief();
		}
		else {
			return new Superman();
		}
		
		
		
	}

}

