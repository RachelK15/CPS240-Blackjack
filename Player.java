public class Player 
{
    private int betValue;
    private int moneyLeft;
    public Hand hand;
    
    public Player (int startMoney)
    {
        moneyLeft = startMoney;
    }
    
    public boolean placeBet(int newBet)
    {
        boolean goodBet;
        
        if (newBet < moneyLeft)
        {
            betValue = newBet;
            goodBet = true;
        }
        else
            goodBet = false;
        
        return goodBet;
    }
    
    public void adjustMoney(int value)
    {
        moneyLeft -= value;
    }
    
    public void setMoneyLeft(int money)
    {
        moneyLeft = money;
    }
}
