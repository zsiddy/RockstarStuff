import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.List;


public class TriviaQuestion 
{
	private String question;
	private String correctAnswer;
	private String[] incorrectAnswers;
	private String[] allAnswers;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	
	/**
	protected String[][] answerArray = {
			{"A", ""},
			{"B", ""},
			{"C", ""},
			{"D", ""}
	};
	
	String category;
	String difficulty;
	
	public TriviaQuestion(String question, String answer, String[] incorrectAnswers,  String difficulty, String category)
	{
		this.question = question;
		this.answer = answer;	
		this.incorrectAnswers = incorrectAnswers;
		this.category = category;
		this.difficulty = difficulty;
		
	}
	*/
	
	public TriviaQuestion(String question, String answer, String[] incorrectAnswers)
	{
		this.question = question;
		this.correctAnswer = answer;
		this.incorrectAnswers = incorrectAnswers;
		
		allAnswers = new String[4];
		setAllAnswers();
		allAnswersToString();
	}
	
	public TriviaQuestion()
	{
		
	}
	
	public void setQuestion(String question)
	{
		this.question = question;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public void setAnswer(String answer)
	{
		this.correctAnswer = answer;
	}
	
	public String getAnswer()
	{
		return correctAnswer;
	}
	
	public void setIncorrectAnswers(String[] strings)
	{
		this.incorrectAnswers = strings;
	}
	
	public String[] getIncorrectAnswers()
	{
		return incorrectAnswers;
	}
	
    public void setAllAnswers() 
    {
    		//allAnswers = incorrectAnswers;
    		for(int i = 0; i < incorrectAnswers.length; i++)
    		{
    			allAnswers[i] = incorrectAnswers[i];
    		}
    		allAnswers[4] = correctAnswer;
        shuffleAnswers();
    }
    
    public void shuffleAnswers()
    {
    		List<String> strList = Arrays.asList(allAnswers);
    		long seed = System.nanoTime();
    		Collections.shuffle(strList, new Random(seed));
    		allAnswers = strList.toArray(new String[strList.size()]);
    }
    
    public String[] getAllAnswers()
    {
    		return allAnswers;
    }
    
    public void allAnswersToString()
    {
    		answerA = allAnswers[0];
    		answerB = allAnswers[1];
    		answerC = allAnswers[2];
    		answerD = allAnswers[3];
    }
    
    public String answerToLetter()
    {
    		if(answerA.equals(correctAnswer))
    		{
    			return "A";
    		}
    		else if(answerB.equals(correctAnswer))
    		{
    			return "B";
    		}
    		else if(answerC.equals(correctAnswer))
    		{
    			return "C";
    		}
    		else
    		{
    			return "D";
    		}
    }
    
    public String getAnsA()
    {
    		return answerA;
    }
    
    public String getAnsB()
    {
    		return answerB;
    }
    
    public String getAnsC()
    {
    		return answerC;
    }
    
    public String getAnsD()
    {
    		return answerD;
    }

}