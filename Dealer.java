/**
 * The dealer contains the deck, all the players, and a hand of its own.
 */
import java.util.*;
public class Dealer 
{
    public  Hand hand;
    private Player[] players;
    Scanner keyboard = new Scanner(System.in);
    public Deck deck;
    
    /**
     * Dealer constructor.
     */
    public Dealer()
    {
    	players = new Player[1];
        deck = new Deck();
        deck.shuffle();
        hand = new Hand();
        players[0] = new Player(100);
    }//end Dealer
    
    /**
     * Deals the initial cards to all players and the dealer.
     */
    public void dealInitial()
    {
    	if(deck.getNumberCardsLeft() < 22)
    	{
    		deck = new Deck();
    		System.out.println("Shuffling Deck.");
    		deck.shuffle();
    	}//end if
        hand.addCard(deck.getCard(true));
        players[0].hand.addCard(deck.getCard(false));
        hand.addCard(deck.getCard(false));
        players[0].hand.addCard(deck.getCard(false));
        System.out.print("Dealer's Hand: ");
        hand.displayDealerHand();
        System.out.print("Your Hand: ");
        players[0].hand.displayHand();
        System.out.println("Your hand value: " + players[0].hand.getHandValue());
        if(players[0].hand.check21() == true)
        	System.out.println("Blackjack!");
    }//end dealInitial
    
    /**
     * Requests the bet from the player.
     * @return -1 Invalid input; -2 Not enough money; else Good bet
     */
    public int requestBet()
    {
        int bet = 0;
        System.out.print("You have $" + players[0].getMoneyLeft() + ". ");
        System.out.print("What would you like to bet? ");
        try
        {
        	bet = keyboard.nextInt();
        }//end try
        catch(Exception e)
        {
        	keyboard.nextLine();
        	return -1;
        }//end catch
        keyboard.nextLine();
        if(players[0].placeBet(bet) == true)
        	return bet;
        else
        	return -2;
    }//end requestBet
    
    /**
     * Ask the player what they would like to do next.
     * @return True if hand is complete. Otherwise false
     */
    public boolean askPlayerAction()
    {
        int response;
        boolean endHand = false;
        System.out.println("What would you like to do?" + "\n" +
                           "1. Hit" + "\n" +
                           "2. Stay");
        try
        {
        	response = keyboard.nextInt();
        }//end try
        catch(Exception e)
        {
        	keyboard.nextLine();
        	System.out.println("Invalid input.");
        	return false;
        }//end catch
        
        switch(response)
        {
        case 1:
        	System.out.println("Hit!");
        	players[0].hand.addCard(deck.getCard(false));
        	System.out.print("Your hand: ");
        	players[0].hand.displayHand();
        	System.out.println("Your hand value: " + players[0].hand.getHandValue());
        	if(players[0].hand.checkBust() == true)
        	{
        		endHand = true;
        		System.out.println("Bust!");
        	}//end if
        	else
        		endHand = false;
        	break;
        case 2:
        	System.out.println("Stand.");
        	endHand = true;
        	break;
        default:
        	System.out.println("Invalid Entry. Please try again.");
        	endHand = false;
        }//end switch
        return endHand;
    }//end askPlayerAction
    
    /**
     * Calculates if the player won the game
     * @return True if the player has money left, otherwise false
     */
    public boolean winLose()
    {
    	playDealer();
    	if(players[0].hand.check21() == true || hand.check21() == true)
    	{
    		if(hand.check21() == true)
    		{
    			//Dealer has blackjack
    			if(players[0].hand.check21() == true)
    			{
    				//Both have blackjack
    				System.out.println("You and the Dealer got a blackjack! You tie!");
    	        	//No money is changed
    			}//end if
    			else
    			{
    				//Only dealer has black jack
    				System.out.println("The Dealer got a blackjack. Sorry, you lost.");
    	        	players[0].adjustMoney(-1 * players[0].getBetValue());
    			}//end else
    		}//end if
    		else
    		{
    			//Dealer does not have blackjack
    			System.out.println("You got a blackjack! You win!");
	        	players[0].adjustMoney((int)(players[0].getBetValue() * 1.5));
    		}//end else
    	}//end if
    	else
    	{
    		//No blackjacks.
	    	if(players[0].hand.checkBust() == false)
	        {
	    		//Player does not bust
	    		if(hand.checkBust() == true)
	    		{
	    			//Dealer busts
	    			System.out.println("The Dealer busted. You win!");
		        	players[0].adjustMoney(players[0].getBetValue());
	    		}//end if
	    		else 
	    		{
	    			//Dealer does not bust
	    			if (hand.getHandValue() >= players[0].hand.getHandValue())
			        {
			        	//Player Loses
	    				if(hand.getHandValue() == players[0].hand.getHandValue())
	    					System.out.println("You and the Dealer tied. Sorry");
	    				else
	    					{System.out.println("Sorry, you lost.");
	    					players[0].adjustMoney(-1 * players[0].getBetValue());}
			        }//end if
			        else
			        {
			        	//Player Wins
			        	System.out.println("You win!");
			        	players[0].adjustMoney(players[0].getBetValue());
			        }//end else
	    		}//end else
	        }//end if
	    	else
	    	{
	    		//Player busts
	    		if(hand.checkBust() == false)
	    			System.out.println("You busted. Sorry, you lost.");
	    		else
	    			System.out.println("You and the dealer busted. Sorry, you lost.");
	    		players[0].adjustMoney(-1 * players[0].getBetValue());
	    	}//end else
    	}//end else
    	System.out.println("You have $" + players[0].getMoneyLeft() + " left.");
    	if(players[0].getMoneyLeft() > 0)
    		return true;
    	else
    		return false;
    }//end winLose
    
    /**
     * Resets the dealer for a new hand.
     */
    public void reset()
    {
    	hand.emptyHand();
    	players[0].hand.emptyHand();
    }//end reset
    
    /**
     * Plays out the dealer's hand.
     */
    private void playDealer()
    {
    	System.out.println("Dealer in playing...");
    	System.out.print("Dealer's Hand: ");
		hand.displayHand();
		System.out.println("Dealer's hand value: " + hand.getHandValue());
		if(hand.check21() == true)
			System.out.println("Blackjack!");
    	while(hand.getHandValue() < 17)
    	{
    		System.out.println("Hit!");
    		hand.addCard(deck.getCard(true));
    		System.out.print("Dealer's Hand: ");
    		hand.displayHand();
    		System.out.println("Dealer's hand value: " + hand.getHandValue());
    	}//end while
    	if(hand.getHandValue() > 21)
    		System.out.println("Bust!");
    	else
    		System.out.println("Stand.");
    	System.out.println("---------------------------------");
    	System.out.println("Dealer's hand value: " + hand.getHandValue());
    	System.out.println("Your hand value: " + players[0].hand.getHandValue());
    }//end playDealer
}//end Dealer