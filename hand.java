public class Hand
{
	private Card cards[];
	private int handValue;
	private int numCards;
	
	public Hand()
	{
		numCards = 0;
		handValue = 0;
		cards = new int[11];
	}

	public int getHandValue()
	{
		return handValue;
	}
	
	public void addCard(Card newCard)
	{
		int index = 0;
		while (cards[i] != null)
			index++;
		cards[i] = newCard;
	}
	
	public void displayHand()
	{
		System.out.print("Cards in hand: ");
		int index = 0;
		while(cards[i] != null)
		{
			//print suit
			//print faceValue
		}
	}
}//end hand
