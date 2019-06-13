package Dungeon;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import HeroAndMonster.Hero;

public class Dungeon 
{
	private Room[][] dungeon;
	private int[] entrance = {0,1};
	
	public Dungeon() 
	{
		dungeon = new Room[5][5];
		createRoom();
	}

	public Room getRoom(int x, int y)
	{
		return dungeon[x][y];

	}
	public Room getRoom(int[] location)
	{
		return dungeon[location[0]][location[1]];

	}

	public int[] getEntrance()
	{
		return entrance;
	}

	private void createRoom()
	{

		Scanner scan = null;
		try {
			scan = new Scanner(new File("DungeonRead"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i =0;
		/*
		for(Room[] row: dungeon)
		{
			for(Room column: row)
			{
		 */
		for(int row = 0; row < 5; row++)
		{
			for(int column = 0; column < 5; column++) {
					char[][] room = new char[3][];
					room[0] = scan.nextLine().toCharArray();
					room[1] = scan.nextLine().toCharArray();
					room[2] = scan.nextLine().toCharArray();
					Room r = new Room(room);
					dungeon[row][column] = r;

			}
		}
	}
	void canMove(String input, Hero hero)
	{
		
		    String wall= "That is a wall";
		    int [] currentLocation= hero.getLocation();
		    
			Room currentRoom = getRoom(currentLocation);
		    //boolean success=false;


		    if (input.equalsIgnoreCase("W")){
		        if (currentRoom.getRow(0).contains("-")){
		            System.out.println("Moved north");
		            hero.setLocation(currentLocation[0]-1,currentLocation[1]);

		        }else{
		            System.out.println(wall);
		        }
		    }
		    else if (input.equalsIgnoreCase("A")){
		        if (currentRoom.getRow(1).substring(0,2).contains("|")){
		            System.out.println("Moved west");
		            hero.setLocation(currentLocation[0],currentLocation[1]-1);
		        }else{
		            System.out.println(wall);
		        }
		    }
		    //east
		    else if (input.equalsIgnoreCase("D")){
		        if (currentRoom.getRow(1).substring(2).contains("|")){
		            System.out.println("Moved east");
		            hero.setLocation(currentLocation[0],currentLocation[1]+1);

		        
		        }
		        else{
		            System.out.println(wall);
		        }
		    }

		    //south
		    else if (input.equalsIgnoreCase("S")){
		        if (currentRoom.getRow(2).contains("-")){
		            System.out.println("Moved south");
		           hero.setLocation(currentLocation[0]+1,currentLocation[1]);
		        }else{
		            System.out.println(wall);
		        }
		    }
		    else {
		        System.out.println("INVALID INPUT");
		    }
		}


}
