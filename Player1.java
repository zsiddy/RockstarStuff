/**
 * Write a description of class TriviaGameTest here.
 * 
 * @author Zoe Siddall & Cameron Smith 
 * @version V1
 */

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
		
		/**
	      `""==,,__  
	    	        `"==..__"=..__ _    _..-==""_
	    	             .-,`"=/ /\ \""/_)==""``
	    	            ( (    | | | \/ |
	    	             \ '.  |  \;  \ /
	    	              |  \ |   |   ||
	    	         ,-._.'  |_|   |   ||
	    	        .\_/\     -'   ;   Y
	    	       |  `  |        /    |-.
	    	       '. __/_    _.-'     /'
	    	   jgs        `'-.._____.-'
	    	   */
		
		
		System.out.println("	      `\"\"==,,__  ");
	    	System.out.println("	    	        `\"==..__\"=..__ _    _..-==\"\"_");
	    	System.out.println("	    	             .-,`\"=/ /\\ \\\"\"/_)==\"\"``");
	    	System.out.println("	    	            ( (    | | | \\/ |");
	    	System.out.println("	    	             \\ '.  |  \\;  \\ /");
	    	System.out.println("	    	              |  \\ |   |   ||");
	    	System.out.println("	    	         ,-._.'  |_|   |   ||");
	    	System.out.println("	    	        .\\_/\\     -'   ;   Y");
	    	System.out.println("	    	       |  `  |        /    |-.");
	    	System.out.println("	    	       '. __/_    _.-'     /'");
	    	System.out.println("	    	              `'-.._____.-'");
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
