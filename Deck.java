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
		// Card (face value , game value , suit (1.Spades 2.Clubs 3.Hearts 4.Diamonds)
		cards[0]= new Card((char)'A',1,1);
		cards[1]= new Card((char)'J',10,1);
		cards[2]= new Card((char)'Q',10,1);
		cards[3]= new Card((char)'K',10,1);
		cards[4]= new Card((char)'A',1,2);
		cards[5]= new Card((char)'J',10,2);
		cards[6]= new Card((char)'Q',10,2);
		cards[7]= new Card((char)'K',10,2);
		cards[8]= new Card((char)'A',1,3);
		cards[9]= new Card((char)'J',10,3);
		cards[10]= new Card((char)'Q',10,3);
		cards[11]= new Card((char)'K',10,3);
		cards[12]= new Card((char)'A',1,4);
		cards[13]= new Card((char)'J',10,4);
		cards[14]= new Card((char)'Q',10,4);
		cards[15]= new Card((char)'K',10,4);
		
		int s = 1;	//s = suit
		int i = 16; //temp value for card index
		while(s <=4)
		do
		{
			
			while (i < 52)
				do
				{
					//for loop to create cards with value 2-10
					for(int j=2; j <10; j++)
					{
						card[i] = new Card((char)j,j,s);
						i++;
					}
					s++;//change suite
				}
		
		}
	
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
