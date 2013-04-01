/**
 * A card is a standard playing card.
 * Face value can be 2 - A. Game value can be 1 - 10. Suit is 1 - 4.
 */
public class Card 
{
	private char faceValue;
	private int gameValue;
	private int suit;
	private boolean faceUp;

	/**
	 * Card constructor. By default, card is face up.
	 * @param faceValue The card's face value.
	 * @param gameValue The card's game value.
	 * @param suit The card's suit.
	 */
	public Card(char faceValue, int gameValue, int suit)
	{
		this.faceValue = faceValue;
		this.gameValue = gameValue;
		this.suit = suit;
		faceUp = true;
	}//end Card
	
	/**
	 * Returns the card's suit.
	 * @return The card's suit
	 */
	public int getSuit()
	{
		return suit;
	}//end getSuit
	
	/**
	 * Returns the card's game value.
	 * @return The card's game value.
	 */
	public int getGameValue()
	{
		return gameValue;
	}//end getGameValue
	
	/**
	 * Displays the card's suit.
	 */
	public void displaySuit()
	{
		switch(suit)
		{
		case 1:
			System.out.print("S");
			break;
		case 2:
			System.out.print("C");
			break;
		case 3:
			System.out.print("H");
			break;
		case 4:
			System.out.print("D");
			break;
		}//end switch
	}//end displaySuit
	
	/**
	 * Displays the card's face value.
	 */
	public void displayFaceValue()
	{
		if(faceValue != '0')
			System.out.print(faceValue);
		else
			System.out.print("10");
	}//end displayFaceValue
	
	/**
	 * Returns true if the card if face up. Otherwise, false.
	 * @return Face up
	 */
	public boolean getFaceUp()
	{
		return faceUp;
	}//end getFaceUp
	
	/**
	 * Sets the card to face down.
	 */
	public void setFaceDown()
	{
		faceUp = false;
	}//end setFaceDown
}//end Card