package Hackathon;

import java.util.Scanner;

public class Casino
{


	public static void casino()
	{

		System.out.println ( "Welcome to the Casino! Choose your game." );
		int continueGame = 1;
		for(int i = 0; i < 5; i++)
		{
			System.out.println ( "(1) - The Guessing Game" );
			System.out.println ( "(2) - Slots" );
			Scanner inputChoice = new Scanner ( System.in );
			int choice = inputChoice.nextInt ( );
			switch ( choice )
			{
				case 1:
					//Guessing Game

					// Setting the range from user input
					int max = 0;
					int min = 0;
					int bet = 0;


					//Set difficulty from user input
					System.out.println ("Choose your difficulty?");
					System.out.println ("(1) - Easy");
					System.out.println ("(2) - Medium");
					System.out.println ("(3) - Hard");

					Scanner inputChoiceTwo = new Scanner(System.in);
					int difficulty = inputChoiceTwo.nextInt ( );

					switch(difficulty)
					{
						case 1:
							max = 10;
							break;
						case 2:
							max = 25;
							break;
						case 3:
							max = 50;
							break;
					}

					//Getting players bet
					do
					{
						System.out.println ("How much would you like to bet: ");
						Scanner inputBet = new Scanner(System.in);
						bet = inputBet.nextInt ( );
					} while (bet > Stats.getGold ( ));
					Stats.setGold(-bet);

					// creating random#
					int range = max - min + 1;
					int rand = (int) ( Math.random ( ) * range ) + min;
					int points = 5;

					// Output number for testing
					System.out.println ( rand + " Testing Number" );

					// Get user's guess
					int userGuess;
					Scanner input = new Scanner ( System.in );
					System.out.format ( "Enter your guess ( %s - %s ): ", min, max );
					userGuess = input.nextInt ( );

					// Lose condition
					if( userGuess != rand )
					{
						System.out.println ("You lost.");
					} 
					// Win Condition
					else 
					{
						System.out.println ( "You Guessed correctly!" );
						int winnings = 0;
						// Give gold
						switch (difficulty)
						{
							case 1:
								winnings = (int) ( bet * 1.25 );
								break;
							case 2:
								winnings = (int) ( bet * 1.50 );
								break;
							case 3:
								winnings = bet * 2;
								break;
						}
						System.out.println ( "You won: " + winnings + " Gold!" );
						Stats.setGold ( winnings );
					}
					break;

				case 2:
					//Slots --------

					//Get bet
					do
					{
						System.out.println ("How much would you like to bet: ");
						Scanner inputBet = new Scanner(System.in);
						bet = inputBet.nextInt ( );
					} while (bet > Stats.getGold ());
					//remove bet amt of gold from stats
					Stats.setGold(-bet);

					int slotOne;
					int slotTwo;
					int slotThree;
					int leverPull;

					//pulling lever

					range = 5;
					slotOne = (int) ( Math.random ( ) * range ) + 1;
					slotTwo = (int) ( Math.random ( ) * range ) + 1;
					slotThree = (int) ( Math.random ( ) * range ) + 1;

					int topOne = slotOne - 1;
					int topTwo = slotTwo - 1;
					int topThree = slotThree - 1;
					int bottomOne = slotOne + 1;
					int bottomTwo = slotTwo + 1;
					int bottomThree = slotThree + 1;
					int winnings = 0;

					//display slots
					showSlots(slotOne, slotTwo, slotThree,
							topOne, topTwo, topThree,
							bottomOne, bottomTwo, topThree);

					//distribute winnings
					if(slotOne == slotTwo && slotTwo == slotThree)
					{
						winnings += bet * 7;
					}
					if(topOne == slotTwo && slotTwo == bottomThree)
					{
						winnings += bet * 5;
					}
					if(topThree == slotTwo && slotTwo == bottomOne)
					{
						winnings += bet * 5;
					}
					System.out.println ( "You won: "  + winnings + " gold!" );
					Stats.setGold ( winnings );

					break;

			}
			
			//If user is out of gold remove from Casino
			if (Stats.getGold ( ) <= 0)
			{
				System.out.println ( "You have been forcibly removed from the Casino for lack of funds.\n" );
				break;
			}


		}
	}

	
	// Displaying the Slots to the user
	public static void showSlots(int slotOne, int slotTwo, int slotThree, 
			int topOne, int topTwo, int topThree,
			int bottomOne, int bottomTwo, int bottomThree)
	{
		System.out.println( "__________________" );
		System.out.printf ( "| [%s]  [%s]  [%s]  |", topOne, topTwo, topThree);
		System.out.println();
		System.out.printf ( "| [%s]  [%s]  [%s]  |", slotOne, slotTwo, slotThree);
		System.out.println();
		System.out.printf ( "| [%s]  [%s]  [%s]  |", bottomOne, bottomTwo, bottomThree);
		System.out.println();
		System.out.println( "|________________|" );
	}
}