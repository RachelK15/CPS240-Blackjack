public class Hand
{
	private Card[] cards;
	private int handValue;
	private int numCards;
	
	public Hand()
	{
		numCards = 0;
		handValue = 0;
		cards = new Card[11];
		for(int i = 0; i < 11; i++)
			cards[i] = null;
	}

	public int getHandValue()
	{
		return handValue;
	}
	
	public void addCard(Card newCard)
	{
		int index = 0;
		while (cards[index] != null)
			index++;
		cards[index] = newCard;
		numCards++;
		setHandValue();
	}
	
	public void displayHand()
	{
		System.out.print("Cards in hand: ");
		int index = 0;
		while(cards[index] != null)
		{
			cards[index].displayFaceValue();
			System.out.print(" ");
			index++;
		}
		System.out.println();
	}
	
	private boolean checkBust()
	{
		if(handValue > 21)
			return true;
		else
			return false;
	}
	
	public int getNumCards()
	{
		return numCards;
	}
	
	private boolean check21()
	{
		if(handValue == 21)
			return true;
		else
			return false;
	}
	
	private void setHandValue()
	{
		int index = 0;
		int numAces = 0;
		handValue = 0;
		while(cards[index] != null)
		{
			if(cards[index].getGameValue() == 1)
			{
				numAces++;
			}
			handValue += cards[index].getGameValue();
			index++;
		}
		for(int i = 0; i < numAces; i++)
		{
			if(handValue + 10 <= 21)
				handValue += 10;
		}
	}
}//end hand
