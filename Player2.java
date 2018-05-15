import java.util.Scanner;

public class Player2 extends Player
{
	Scanner keyboard = new Scanner(System.in);
	private String nameSaver;
	
	public Player2()
	{
		setName();
		super.score = 0;
		super.name = nameSaver;
	}
	
	public void setName()
	{
		System.out.print("Enter Name for Player 2: ");
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
