package Hackathon;
import java.io.IOException;
import java.util.Scanner;

public class main_test {

	public static void main(String[] args) throws IOException 
	{
		Scanner scan = new Scanner(System.in);
		goQuestDay(5,4);//Replace with Stats.getIntel, Stats.getLuck, Stats.getCharis
		easyQuest thething = new easyQuest();
		thething.doEasyQuest();
	}

	static void goQuestDay( int intel, int charis) throws IOException 
	{
		Scanner scan = new Scanner(System.in);
		
		int actions = 5; // total actions every day
		System.out.println ("Welcome to the Questing Guild!");
		
		//declare/define quests
		trashQuest quest1 = new trashQuest();
		easyQuest quest2 = new easyQuest();
		easyQuest quest3 = new easyQuest();
		mediumQuest quest4 = new mediumQuest();
		
		//hardQuest quest5 = new hardQuest();
		
		while (actions > 0) //loop for each day
			{
			System.out.println ("These are the Current Postings: ");
			System.out.println ("  ----------------------------------------------------");
			System.out.println ("  |  1. (D-rank quest)" + quest1.getNpc());
			System.out.println ("  |  2. (C-rank quest)" + quest2.getNpc() +" " + quest2.getQuest());
			System.out.println ("  |  3. (B-rank quest)" + quest3.getNpc() + " " +quest3.getQuest());
			System.out.println ("  |  4. (A-rank quest) " + quest4.getSummary());
			System.out.println ("  ----------------------------------------------------");
			System.out.println ("What quest would you like to take?");
			int userInput = scan.nextInt();
			//Level requirements
			if (intel<3 && userInput>1) {System.out.println("Your Intelligence is too low for c & b."); userInput=1000;}
			if (charis<4 && userInput==4) {System.out.println("Your Charisma is too low for A.");userInput=1000;}
			else if (actions<5 && userInput==4) {System.out.println("There's not enough time in the day!"); userInput=1000;}
			while (userInput>4 || userInput<1)
				{
				System.out.println("That is not a valid choice. Please choose a number between 1 and 5: ");
				userInput = scan.nextInt();
				if (intel<3 && userInput>1) {System.out.println("Your Intelligence is too low for c & b."); userInput=1000;}
				if (charis<4 && userInput==4) {System.out.println("Your Charisma is too low for A.");userInput=1000;}
				
				else if (actions<5 && userInput==4) {System.out.println("There's not enough time in the day!"); userInput=1000;}
				}
			switch (userInput) 
				{
				case 1:
					{ 
					actions--;
					quest1.doTrashQuest();
					quest1 = new trashQuest();
					break;
					}
				case 2:
					{ 
					actions--;
					quest2.doEasyQuest();
					quest2 = new easyQuest();
					break;
					}
				case 3:
					{ 
					actions--;
					quest3.doEasyQuest();
					quest3 = new easyQuest();
					break;
					}
				case 4:
					{ 
					actions-=100;
					quest4.doMediumQuest();
					break;
					}
				}
			}
				
		
		
	}
}

