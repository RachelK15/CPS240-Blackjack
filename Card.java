
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
	public Card(char faceValue, int gameValue, int suit, boolean faceUp)
	{
		this.faceValue = faceValue;
		this.gameValue = gameValue;
		this.suit = suit;
		this.faceUp = faceUp;
		
	}

}
