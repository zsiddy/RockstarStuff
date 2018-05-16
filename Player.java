/**
 * Write a description of class TriviaGameTest here.
 * 
 * @author Zoe Siddall & Cameron Smith 
 * @version V1
 */

public abstract class Player
{
	protected String name;
	protected int score;
	
	public Player()
	{
	}
	
	public abstract void setName();
	
	public abstract String getName();
	
	public abstract int getScore();

}
