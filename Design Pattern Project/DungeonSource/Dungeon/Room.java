package Dungeon;
import Dungeon.*;
import Heroes.*;
import Monsters.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Room 
{
	
	char[][] roomCharArray;
	
	public Room(char[][] room)
	{
		roomCharArray = room;
	}
	 
	
	public char[][] getCharArray()
	{
		return this.roomCharArray;
	}
	public void setCharArray(char[][] room)
	{
		this.roomCharArray = room;
	}
	
	public void changeRoomEvent(char letter)
	{
		this.roomCharArray[1][1] = letter;
	}
	
	public String getRow(int row)
	{

	    return Arrays.toString(this.roomCharArray[row]);
	}
	@Override
	public String toString()
	{
	 	StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 3; i++)
		{
			sb.append(Arrays.toString(roomCharArray[i]));
			sb.append("\r\n");
			/*for(int j = 0; j < 3; j++)
			{
				sb.append(roomCharArray[i][j]);
			
			}
	*/
		}
		return sb.toString();	
	}	
		
}
