public class Dealer 
{
    private  Hand hand;
    private Player players[];
    Scanner keyboard = new Scanner(System.in);
    
    public Dealer()
    {
        players = new Player[1];
    }
    
    public void setUpGame()
    {
        players[0].setMoneyLeft(100);
    }
    
    private void dealInital()
    {
        
    }
    
    public int requestBet()
    {
        int bet;
        
        System.out.println("What would you like to bet?");
        bet = keyboard.nextInt();
        
        return bet;
    }
    
    public int askPlayerAction()
    {
        int response;
        
        System.out.println("What would you like to do?" + "\n" +
                           "1. Hit" + "\n" +
                           "2. Stay");
        response = keyboard.nextInt();
        
        return response;
    }
    
    public void winLose()
    {
            if (hand.getHandValue() < players[0].hand.getHandValue())
            {
                players[0].adjustMoney(player[0].betValue;
            }
    }
}
