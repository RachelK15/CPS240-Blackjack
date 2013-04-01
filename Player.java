/**
 * A player has a certain amount of money left and a hand of cards.
 *
 */
public class Player
{
    private int betValue;
    private int moneyLeft;
    public Hand hand;
    
    /**
     * Player constructor.
     * @param startMoney The money the player should start with
     */
    public Player (int startMoney)
    {
    	hand = new Hand();
        moneyLeft = startMoney;
    }//end Player
    
    /**
     * Sets the bet amount for the current hand.
     * @param newBet The bet amount
     * @return True if valid bet, otherwise false
     */
    public boolean placeBet(int newBet)
    {
        boolean goodBet;
        
        if (newBet <= moneyLeft)
        {
            betValue = newBet;
            goodBet = true;
        }//end if
        else
            goodBet = false;
        
        return goodBet;
    }//end placeBet
    
    /**
     * Change the player's money left.
     * @param value The amount to change the player's money by
     */
    public void adjustMoney(int value)
    {
        moneyLeft += value;
    }//end adjustMoney
    
    /**
     * Returns the amount of money the player has left.
     * @return The amount of money the player has left
     */
    public int getMoneyLeft()
    {
    	return moneyLeft;
    }//end getMoneyLeft
    
    /**
     * Returns the bet that was last made by the player.
     * @return The bet that was last made by the player.
     */
    public int getBetValue()
    {
    	return betValue;
    }//end getBetValue
}//end Player