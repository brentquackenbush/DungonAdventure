package AttacksAndStrategyPattern;
import Dungeon.DungeonCharacter;
import HeroAndMonster.Hero;

public interface Attack
{
	void attack(DungeonCharacter opponent, Hero hero);	
}
