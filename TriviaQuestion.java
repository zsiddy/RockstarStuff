public class TriviaQuestion 
{
	String question;
	String[] incorrectAnswers;
	String answer;
	
	/**
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
		this.answer = answer;
		this.incorrectAnswers = incorrectAnswers;
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
		this.answer = answer;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public void setIncorrectAnswers(String[] incorrectAnswers)
	{
		this.incorrectAnswers = incorrectAnswers;
	}
	
	public String[] getIncorrectAnswers()
	{
		return incorrectAnswers;
	}

}