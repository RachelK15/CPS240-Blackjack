public class User
{
	public User()
	{
	}
	
	public Card hit(Deck deck)
	{
		System.out.println("Hit");
		return deck.getCard();
	}

	public void stand()
	{
		System.out.println("Stand");	
	}
}//end User