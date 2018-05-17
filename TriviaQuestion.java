import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import groovy.json.StringEscapeUtils;
import java.util.List;
import java.util.Base64;
import java.io.UnsupportedEncodingException;

public class TriviaQuestion 
{
	private String question;
	private String correctAnswer;
	private String[] incorrectAnswers = new String[3];
	private String[] allAnswers = new String [4];
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
		
		allAnswers[0] = "No Answer";
		allAnswers[1] = "No Answer";
		allAnswers[2] = "No Answer";
		allAnswers[3] = "No Answer";
		//setAllAnswers();
		//allAnswersToString();
	}
	
	public TriviaQuestion()
	{
		//trivia[i].setQuestion(qnumber.getQuestion());
		//trivia[i].setAnswer(qnumber.getCorrect_answer());
		//trivia[i].setIncorrectAnswers(qnumber.getIncorrect_answers());
		
		//Results result = new Results();
		//result = TriviaGame_V1.getTrivia();
		//setQuestion(getQuestion());
		//setAnswer(result.getCorrect_answer());
		//setIncorrectAnswers(result.getIncorrect_answers());
		
		//allAnswers = new String[4];
		//setAllAnswers();
		//allAnswersToString();
	}
	
	public void setQuestion(String question)
	{
		this.question = StringEscapeUtils.unescapeJava(question);
		//StringEscapeUtils.unescapeHtml4.question;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public void setAnswer(String answer)
	{
		//this.correctAnswer = answer;
		this.correctAnswer = StringEscapeUtils.unescapeJava(answer);
	}
	
	public String getAnswer()
	{
		return correctAnswer;
	}
	
	public void setIncorrectAnswers(String[] strings)
	{
		//this.incorrectAnswers = strings;
		for(int i = 0; i < 3; i++)
		{
			incorrectAnswers[i] = StringEscapeUtils.unescapeJava(strings[i]);
			//incorrectAnswers[i] = StringEscapeUtils.unescapeHtml4.strings[i];
		}
	}
	
	public String[] getIncorrectAnswers()
	{
		return incorrectAnswers;
	}
	
    public void setAllAnswers() 
    {
    		for(int i = 0; i < 3; i++)
    		{
    			allAnswers[i] = incorrectAnswers[i];
    		}
    		allAnswers[3] = correctAnswer;
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
    
    /*
    private String decode(String in) {
        //Log.d(TAG, "in: " + in);
        try {
            byte[] bytes = Base64.decode(in, Base64.URL_SAFE);
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    */
  

}