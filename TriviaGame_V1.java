/**
 * To Do:
 * Change stuff to work with answer + incorrectAnswers array
 * Put the answers in a random order, but make sure we know where the right one is
 * Check given answer against correct answer
 * Have method that equates correct answer letter with correct answer String
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
	
	// TODO Auto-generated method stub
	protected TriviaQuestion[] trivia = 
	{
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion(),
			new TriviaQuestion()
			};
	
	public TriviaGame_V1()
	{
	}

	
	public void preStart()
	{
		//getTrivia();
		int i = 0;
		for ( Results qnumber : getTrivia())
		{
			
			trivia[i].setQuestion(qnumber.getQuestion());
			trivia[i].setAnswer(qnumber.getCorrect_answer());
			trivia[i].setIncorrectAnswers(qnumber.getIncorrect_answers());

			trivia[i].setAllAnswers();
			trivia[i].shuffleAnswers();
			trivia[i].allAnswersToString();
			i++;
		}
	}

    public void startGame()
    {
    		preStart();
    	
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
	
	public static Results[] getTrivia()
	{
		String json = null;
		try
		{
			json = getJson("https://opentdb.com/api.php?amount=11&difficulty=hard&type=multiple");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Gson gson = new Gson();

		JsonParser jsonParser = gson.fromJson(json,JsonParser.class);
		
		return jsonParser.getResults();
	}
    
    public void printQ()
    {
    		System.out.println(trivia[currentRow].getQuestion());
        System.out.println("A: " + trivia[currentRow].getAnsA());
        System.out.println("B: " + trivia[currentRow].getAnsB());
        System.out.println("C: " + trivia[currentRow].getAnsC());
        System.out.println("D: " + trivia[currentRow].getAnsD());
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
        if(answer.equals(trivia[currentRow].answerToLetter()))
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
                System.out.println("Wrong. The correct answer is: " + trivia[currentRow].getAnswer() + ".");
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
