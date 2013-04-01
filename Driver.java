/**
 * Plays the game blackjack with casino rules.
 */
import java.util.*;
public class Driver
{
	static boolean endGame = false;
	
	public static void main(String[] args)
	{
		Dealer dealer = new Dealer();
		boolean endHand = false;
		int betInfo = 0;
		endGame = false;
		System.out.println("Welcome to Blackjack!! Your currently have $100.");
		while(endGame == false)
		{
			System.out.println("---------------------------------");
			betInfo = 0;
			while(betInfo <= 0)
			{
				betInfo = dealer.requestBet();
				if(betInfo == -2)
					System.out.println("You do not have enough money.");
				else if(betInfo == -1)
					System.out.println("Invalid input.");
				else if(betInfo == 0)
					System.out.println("Your bet must be at least $1.");
			}//end while
			dealer.dealInitial();
			endHand = false;
			while(endHand == false)
			{
				endHand = dealer.askPlayerAction();
				System.out.println("---------------------------------");
			}//end while
			if(dealer.winLose() == true)
			{
				dealer.reset();
				while(askPlayAgain() == false);
			}//end if
			else
			{
				System.out.println("Sorry, you are out of money. Game over.");
				endGame = true;
			}//end else
		}//end while
		
		System.out.println("Thanks for playing!");
	}//end main
	
	/**
	 * Asks the player if they would like to play again.
	 * @return False if invalid input, otherwise true
	 */
	public static boolean askPlayAgain()
	{
		String answer = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Would you like to play again? Y/N: ");
		answer = keyboard.next();
		keyboard.nextLine();
		if(answer.toLowerCase().matches("y"))
		{
			endGame = false;
			return true;
		}//end if
		else
		{
			if(answer.toLowerCase().matches("n"))
			{
				endGame = true;
				return true;
			}//end if
			else
			{
				System.out.println("Invalid input");
				return false;
			}//end else
		}//end else
	}//end askPlayAgain
}//end Driver