/**
 * A hand contains up to eleven standard playing cards.
 */
public class Hand
{
	private Card[] cards;
	private int handValue;
	private int numCards;
	
	/**
	 * Hand constructor.
	 */
	public Hand()
	{
		numCards = 0;
		handValue = 0;
		cards = new Card[11];
		for(int i = 0; i < 11; i++)
			cards[i] = null;
	}//end hand
	
	/**
	 * Removes all cards from hand.
	 */
	public void emptyHand()
	{
		for(int i = 0; i < 11; i++)
			cards[i] = null;
		handValue = 0;
		numCards = 0;
	}//end emptyHand

	/**
	 * Returns the hand's value.
	 * @return the hand's value
	 */
	public int getHandValue()
	{
		return handValue;
	}//end getHandValue
	
	/**
	 * Add a card to the hand.
	 * @param newCard The card to add to the hand
	 */
	public void addCard(Card newCard)
	{
		int index = 0;
		while (cards[index] != null)
			index++;
		cards[index] = newCard;
		numCards++;
		setHandValue();
	}//end addCard
	
	/**
	 * Displays every card in the hand.
	 */
	public void displayHand()
	{
		int index = 0;
		while(cards[index] != null)
		{
			cards[index].displayFaceValue();
			cards[index].displaySuit();
			System.out.print(" ");
			index++;
		}//end while
		System.out.println();
	}//end displayHand
	
	/**
	 * Displays only cards that are face up.
	 */
	public void displayDealerHand()
	{
		int index = 0;
		while(cards[index] != null)
		{
			if(cards[index].getFaceUp() == true)
			{
				cards[index].displayFaceValue();
				cards[index].displaySuit();
				System.out.print(" ");
			}//end if
			index++;
		}//end while
		System.out.println();
	}//end displayDealerHand
	
	/**
	 * Checks if the hand value is over 21.
	 * @return True if over 21, otherwise false
	 */
	public boolean checkBust()
	{
		if(handValue > 21)
			return true;
		else
			return false;
	}//end checkBust
	
	/**
	 * Returns the number of cards in hand.
	 * @return The number of cards in hand
	 */
	public int getNumCards()
	{
		return numCards;
	}//end getNumCards
	
	/**
	 * Checks if the current hand contains a blackjack.
	 * @return True if blackjack, otherwise false
	 */
	public boolean check21()
	{
		if(numCards == 2)
		{
			if(cards[0].getGameValue() == 1 && cards[1].getGameValue() == 10)
				return true;
			else if(cards[1].getGameValue() == 1 && cards[0].getGameValue() == 10)
				return true;
			else
				return false;
		}//end if
		else
			return false;
	}//end check21
	
	/**
	 * Calculates the hand's value.
	 */
	private void setHandValue()
	{
		int index = 0;
		int numAces = 0;
		handValue = 0;
		while(cards[index] != null)
		{
			if(cards[index].getGameValue() == 1)
				numAces++;
			handValue += cards[index].getGameValue();
			index++;
		}//end while
		for(int i = 0; i < numAces; i++)
			if(handValue + 10 <= 21)
				handValue += 10;
	}//end setHandValue
}//end hand
