
public class Card 
	{
		private char faceValue;
		private int gameValue;
		private int suit;
		private boolean faceUp;
		
	public int getSuit()
	{
		return suit;
	}
	public int getGameValue()
	{
		return gameValue;
		
	}
	public void displayFaceValue()
	{
		System.out.print(faceValue);
	}
	public boolean getFaceUp()
	{
		return faceUp;
	}
	public void setFaceDown()
	{
		faceUp = false;
	}
	public Card(char faceValue, int gameValue, int suit)
	{
		this.faceValue = faceValue;
		this.gameValue = gameValue;
		this.suit = suit;
		faceUp = true;
		
	}

}
