/**
 * A deck contains 52 standard playing cards.
 */
import java.util.*;
public class Deck 
{
	private int numberCardsLeft;
	private Card[] cardsUsed;
	private Card[] cards;
	
	 /**
	  * Deck constructor.
	  */
	public Deck()
	{
		cards= new Card[52];
		//Card (face value , game value , suit (1.Spades 2.Clubs 3.Hearts 4.Diamonds)
		cards[0] = new Card('A', 1, 1);
		cards[1] = new Card('2', 2, 1);
		cards[2] = new Card('3', 3, 1);
		cards[3] = new Card('4', 4, 1);
		cards[4] = new Card('5', 5, 1);
		cards[5] = new Card('6', 6, 1);
		cards[6] = new Card('7', 7, 1);
		cards[7] = new Card('8', 8, 1);
		cards[8] = new Card('9', 9, 1);
		cards[9] = new Card('0', 10, 1);
		cards[10] = new Card('J', 10, 1);
		cards[11] = new Card('Q', 10, 1);
		cards[12] = new Card('K', 10, 1);
		
		cards[13] = new Card('A', 1, 2);
		cards[14] = new Card('2', 2, 2);
		cards[15] = new Card('3', 3, 2);
		cards[16] = new Card('4', 4, 2);
		cards[17] = new Card('5', 5, 2);
		cards[18] = new Card('6', 6, 2);
		cards[19] = new Card('7', 7, 2);
		cards[20] = new Card('8', 8, 2);
		cards[21] = new Card('9', 9, 2);
		cards[22] = new Card('0', 10, 2);
		cards[23] = new Card('J', 10, 2);
		cards[24] = new Card('Q', 10, 2);
		cards[25] = new Card('K', 10, 2);
		
		cards[26] = new Card('A', 1, 3);
		cards[27] = new Card('2', 2, 3);
		cards[28] = new Card('3', 3, 3);
		cards[29] = new Card('4', 4, 3);
		cards[30] = new Card('5', 5, 3);
		cards[31] = new Card('6', 6, 3);
		cards[32] = new Card('7', 7, 3);
		cards[33] = new Card('8', 8, 3);
		cards[34] = new Card('9', 9, 3);
		cards[35] = new Card('0', 10, 3);
		cards[36] = new Card('J', 10, 3);
		cards[37] = new Card('Q', 10, 3);
		cards[38] = new Card('K', 10, 3);
		
		cards[39] = new Card('A', 1, 4);
		cards[40] = new Card('2', 2, 4);
		cards[41] = new Card('3', 3, 4);
		cards[42] = new Card('4', 4, 4);
		cards[43] = new Card('5', 5, 4);
		cards[44] = new Card('6', 6, 4);
		cards[45] = new Card('7', 7, 4);
		cards[46] = new Card('8', 8, 4);
		cards[47] = new Card('9', 9, 4);
		cards[48] = new Card('0', 10, 4);
		cards[49] = new Card('J', 10, 4);
		cards[50] = new Card('Q', 10, 4);
		cards[51] = new Card('K', 10, 4);
		
		cardsUsed = new Card[52];
		for (int i = 0; i < 52; i++)
			cardsUsed [i] = null;
		
		numberCardsLeft = 52;
	}//end Deck
		
	/**
	 * Returns the number of cards left.
	 * @return The number of cards remaining in the deck.
	 */
	public int getNumberCardsLeft()
	{
		return numberCardsLeft;
	}//end getNumberCardsLeft
	
	/**
	 * Shuffles the deck.
	 */
	public void shuffle()
	{
		Card temp = null;
		int index1, index2;
		Random rand = new Random();
		int switches = Math.abs(rand.nextInt(1000000)) + 1000;
		for(long i = 0; i < switches; i++)
		{
			index1 = rand.nextInt(52);
			index2 = rand.nextInt(52);
			temp = cards[index1];
			cards[index1] = cards[index2];
			cards[index2] = temp;
		}//end for
	}//end shuffle
	
	/**
	 * Returns the next card in the deck.
	 * @param faceUp True if set card face up, False if set card face down.
	 * @return The next card in the deck.
	 */
	public Card getCard(boolean faceUp)
	{
		Card temp = cards[52 - numberCardsLeft];
		cardsUsed[52 - numberCardsLeft] = temp;
		numberCardsLeft --;
		if(faceUp == true)
			temp.setFaceDown();
		return temp;	
	}//end getCard
}//end Deck