/**
 * To Do:
 * Random boolean generator to decide which player goes first
 * Loops to go through 5 questions per player
 * Getting the questions via JSON
 * 
 * @author Zoe Siddall & Cameron Smith 
 * @version V1
 */
import java.util.Scanner;
import java.util.Random;

public class TriviaGame_V1
{
    private String answer;
    Player1 player1 = new Player1();
    Player2 player2 = new Player2();
    protected int currentRow;
    
    Scanner keyboard = new Scanner(System.in);
    
    //2D String Array with 10 rows and 6 columns
    protected String[][] trivia = {
        {"Q0 Is Rio lame?", "A: Yes", "B: Probably Yes", "C: Obviously Yes", "D: Definitely Yes", "D"},
        {"Q1 Is Cam lame?", "A: No", "B: Probably No", "C: Obviously No", "D: Definitely No", "C"},
        {"Q2","A", "B", "C", "D", "A"},
        {"Q3","A", "B", "C", "D", "A"},
        {"Q4","A", "B", "C", "D", "A"},
        {"Q5","A", "B", "C", "D", "A"},
        {"Q6","A", "B", "C", "D", "A"},
        {"Q7","A", "B", "C", "D", "A"},
        {"Q8","A", "B", "C", "D", "A"},
        {"Q9","A", "B", "C", "D", "A"},
        {"Q10","A", "B", "C", "D", "A"},
    };
    
    public void startGame()
    {
    		Random randStart = new Random();
    		
    		//If whoStarts = true, player 1 starts.
    		//Else, player 2 starts.
    		boolean whoStarts = randStart.nextBoolean();
    	
    		if(whoStarts)
    		{
    			for(currentRow = 0; currentRow < trivia.length - 1; currentRow++)
    			{
    				if(currentRow % 2 == 0)
    				{
    					System.out.println("Question for: " + player1.getName() + "...");
    	        			printQ();
    	        			validMove();
    	        			checkAns();
    				}
    				else
    				{
    					System.out.println("Question for: " + player2.getName() + "...");
	        			printQ();
	        			validMove();
	        			checkAns();
    				}
    			}
    			
    			getWinner();
    		}
    		else
    		{
    			for(currentRow = 1; currentRow < trivia.length; currentRow++)
    			{
    				if(currentRow % 2 == 0)
    				{
    					System.out.println("Question for: " + player1.getName() + "...");
    	        			printQ();
    	        			validMove();
    	        			checkAns();
    				}
    				else
    				{
    					System.out.println("Question for: " + player2.getName() + "...");
	        			printQ();
	        			validMove();
	        			checkAns();
    				}
    			}
    			
    			getWinner();
    		}
    }
    
    public void printQ()
    {
        System.out.println(trivia[currentRow][0]);
        System.out.println(trivia[currentRow][1]);
        System.out.println(trivia[currentRow][2]);
        System.out.println(trivia[currentRow][3]);
        System.out.println(trivia[currentRow][4]);
    }
    
    public void validMove()
    {
        boolean validAns;
        String input;
        do
        {
            System.out.print("Answer (type letter, then hit enter): ");
            input = keyboard.nextLine();
            input = input.toUpperCase();
            if(input.equals("A")|| input.equals("B") || 
               input.equals("C") || input.equals("D"))
            {
                answer = input;
                validAns = true;
            }
            else
            {
                System.out.println("Please enter a valid response!");
                validAns = false;
            }
        }while(!validAns);
    }
    
    public void checkAns()
    {
        if(answer.equals(trivia[currentRow][5]))
            {
                System.out.println("Correct!");
                System.out.println();
                
                if(currentRow % 2 == 0)
				{
                		player1.score++;
				}
				else
				{
					player2.score++;
				}
            }
            else
            {
                System.out.println("Wrong. The correct answer is: " + trivia[currentRow][5] + ".");
                System.out.println();
            }
    }
    
    public void getWinner()
    {
    		String player1LC = player1.getName();
    		String player1UC = player1LC.toUpperCase();
    		
    		String player2LC = player2.getName();
    		String player2UC = player2LC.toUpperCase();
    		
    		if(player1.getScore() > player2.getScore())
    		{
    			System.out.println("WINNER: " + player1UC);
    			System.out.println("LOSER: " + player2UC);
    		}
    		else if(player1.getScore() < player2.getScore())
    		{
    			System.out.println("WINNER: " + player2UC);
    			System.out.println("LOSER: " + player1UC);
    		}
    		else
    		{
    			System.out.println(player1UC + " & " + 
    					player2UC + " TIE.");
    		}
    }
}
