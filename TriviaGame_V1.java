/**
 * To Do:
 * Getting the questions via JSON
 * 
 * @author Zoe Siddall & Cameron Smith 
 * @version V1
 */
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TriviaGame_V1
{
    private String answer;
    Player1 player1 = new Player1();
    Player2 player2 = new Player2();
    private int currentRow;
    private static final int NUM_ROWS = 11;
    Scanner keyboard = new Scanner(System.in);
    
    private static OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    
    String q0 = "Q0\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
    String q1 = "What color are apples?\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	String q2 = "What color are bananas?\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	String q3 = "What color is Cameron?\n" + "(a) true\n(b) false\n(c) yellow\\n(d)purple";
	String q4 = "What color is Cameron's car?\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	String q5 = "Q5\n"+ "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	String q6 = "Q6\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	String q7 = "Q7\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	String q8 = "Q8\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	String q9 = "Q9\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	String q10 = "Q10\n" + "(a) red\n(b) blue\n(c) yellow\n(d)purple";
	
	// TODO Auto-generated method stub
	private TriviaQuestion[] trivia = {
			new TriviaQuestion(q0, "A", "easy", "fruit"),
			new TriviaQuestion(q1, "A", "easy", "fruit"),
			new TriviaQuestion(q2, "C", "easy", "fruit"),
			new TriviaQuestion(q3, "B", "easy", "fruit"),
			new TriviaQuestion(q4, "A", "easy", "fruit"),
			new TriviaQuestion(q5, "A", "easy", "fruit"),
			new TriviaQuestion(q6, "A", "easy", "fruit"),
			new TriviaQuestion(q7, "A", "easy", "fruit"),
			new TriviaQuestion(q8, "A", "easy", "fruit"),
			new TriviaQuestion(q9, "A", "easy", "fruit"),
			new TriviaQuestion(q10, "A", "easy", "fruit")
			};

    public void startGame()
    {
    		Random randStart = new Random();
    		
    		//If whoStarts = true, player 1 starts.
    		//Else, player 2 starts.
    		boolean whoStarts = randStart.nextBoolean();
    	
    		if(whoStarts)
    		{
    			for(currentRow = 0; currentRow < NUM_ROWS - 1; currentRow++)
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
    			for(currentRow = 1; currentRow < NUM_ROWS; currentRow++)
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
    
    //Maybe change return type ?
	public static String getJson(String url) throws IOException 
	{
	    Request request = new Request.Builder()
	        .url(url)
	        .build();

	    try (Response response = client.newCall(request).execute()) 
	    {
	      return response.body().string();
	    }
	}
	
	public static String[] getTrivia(String questions)
	{
		//trivia db api
		https://opentdb.com/api.php?amount=10&difficulty=hard&type=multiple
		return null;
		
	}
    
    public void printQ()
    {
        System.out.println(trivia[currentRow].question);
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
        if(answer.equals(trivia[currentRow].answer))
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
                System.out.println("Wrong. The correct answer is: " + trivia[currentRow].answer + ".");
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
    			System.out.println("WINNER: " + player1UC + "      Score: " + player1.score);
    			System.out.println("LOSER: " + player2UC + "       Score: " + player2.score);
    		}
    		else if(player1.getScore() < player2.getScore())
    		{
    			System.out.println("WINNER: " + player2UC + "      Score: " + player2.score);
    			System.out.println("LOSER: " + player1UC + "       Score: " + player1.score);
    		}
    		else
    		{
    			System.out.println(player1UC + " & " + 
    					player2UC + " TIE.");
    		}
    }
}
