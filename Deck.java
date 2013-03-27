
public class Deck 
{
		private int numberCardsLeft;
		private Card[] cardsUsed;
		private Card[] cards;
	
	public int getNumberCardsLeft()
	{
		return numberCardsLeft;
	}
	public void shuffle()
	{
		// done by Rachel 
	}
	public Deck()
	{
		cards= new Card[52];
		// Car (face value , game value , suit (1.Spades 2.Clubs 3.Hearts 4.Diamonds)
		// create a for loop for all 52 cards
		// don't forget J Q K A
		cards[0]= new Card((char)'A',1,1);
		cards[1]= new Card((char)2,2,1);
	
		cardsUsed = new Card[52];
		
		for (int i = 0; i < 52; i++)
			cardsUsed [i] = null;
		
		numberCardsLeft = 52;
		
	}
	public Card getCard()
	{
		Card temp = cards[52 - numberCardsLeft];
		cardsUsed[52 - numberCardsLeft] = temp;
		numberCardsLeft --;
		return temp;
			
	}



}
