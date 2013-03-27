import java.util.*;
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
		Card temp = null;
		int index1, index2;
		Random rand = new Random();
		int switches = Math.abs(rand.nextInt()) + 1000;
		for(long i = 0; i < switches; i++)
		{
			index1 = rand.nextInt(52);
			index2 = rand.nextInt(52);
			temp = cards[index1];
			cards[index1] = cards[index2];
			cards[index2] = temp;
		}
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
