import java.util.Scanner;

public class Player1 extends Player
{
	Scanner keyboard = new Scanner(System.in);
	private String nameSaver;
	
	public Player1()
	{
		setName();
		super.score = 0;
		super.name = nameSaver;
	}
	
	public void setName()
	{
		System.out.println("WELCOME TO TRIVIA SLOTH!");
		System.out.println();
		
		System.out.print("Enter Name for Player 1: ");
	    nameSaver = keyboard.nextLine();
	    System.out.println();
	}
	
	public String getName()
	{
		return super.name;
	}
	
	public int getScore()
	{
		return super.score;
	}
	
}
