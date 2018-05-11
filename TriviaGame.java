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
public class TriviaGame
{
    private String player1;
    private String player2;
    private int count = 0;
    private String answer;
    Scanner keyboard = new Scanner(System.in);
    
    //String[][] trivia = new String[6][20];
    private String[][] trivia = {
        {"Is Rio lame?", "A: Yes", "B: Probably Yes", "C: Obviously Yes", "D: Definitely Yes", "D"},
        {"Is Cam lame?", "A: No", "B: Probably No", "C: Obviously No", "D: Definitely No", "C"}
    };
    
    public TriviaGame()
    {
        
    }

    public void playGame()
    {
        getPlayerNames();
        
        for(int i = 0; i < 1; i++)
        {
        		System.out.println("Question for: " + player1 + "...");
        		printQP1();
            validMove();
            checkCorrectAns();
        }
        
        for(int i = 0; i < 1; i++)
        {
        		System.out.println("Question for: " + player2 + "...");
        		printQP2();
	        validMove();
	        checkCorrectAns();
        }
    }
    
    public void getPlayerNames()
    {
        System.out.print("Enter Name for Player 1: ");
        player1 = keyboard.nextLine();
        
        System.out.print("Enter Name for Player 2: ");
        player2 = keyboard.nextLine();
        
        System.out.println();
    }
    
    public void printQP1()
    {
        System.out.println(trivia[0][0]);
        System.out.println(trivia[0][1]);
        System.out.println(trivia[0][2]);
        System.out.println(trivia[0][3]);
        System.out.println(trivia[0][4]);
    }

    public void printQP2()
    {
        System.out.println(trivia[1][0]);
        System.out.println(trivia[1][1]);
        System.out.println(trivia[1][2]);
        System.out.println(trivia[1][3]);
        System.out.println(trivia[1][4]);
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
    
    public void checkCorrectAns()
    {
        if(answer == trivia[0][5])
            {
                System.out.println("Correct!");
                System.out.println();
            }
            else
            {
                System.out.println("Wrong. The correct answer is: " + trivia[0][5] + ".");
                System.out.println();
            }
    }
}
