package Hackathon;

import java.io.IOException;
import java.util.Scanner;

public class TownHub
{

public static void main(String[] args) {
	Stats.setGold ( 100 );
	Stats.setIntel ( 0 );
	Stats.setCharis ( 4 );
	homeHub();
	
	}
public static void homeHub() {
	int days = 14;
	while(days > 0) {
	Stats.setEvade(7);
	Stats.setDex(7);
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println ( "HOME AGAIN\n" );
		System.out.println ( "Welcome friend, what would you like to do?\n" );
		int casinoCost = 50;
		System.out.println ( "0 - Casino - Gamble your savings away or get rich" );
		int arenaCost = 100;
		System.out.println ( "1 - Arena - Battle Random enemies and gain sick amounts of gold" );
		System.out.println ( "2 - Quiz Show" );
		System.out.println ( "3 - Quest - you'll want some intelligence..." );
		System.out.println ( "\nDays:" + days + "/" + "14");
		
		
		System.out.println ( "\nYou Have " + Stats.getGold() + "gold");
		do {
			choice = input.nextInt();   //input decision
			if (choice < 0 || choice > 8) {
				System.out.println ( "You must enter a valid number" );
			}
		} while (choice < 0 || choice > 8);
		switch (choice) {
			
			case 0:
				if (Stats.getGold ( ) >= casinoCost) {
					Casino.casino ( );
				}
				else {
					System.out.println ( "You need more gold to enter the Casino" );
					days += 2;
				}
					
			break;
			
			case 1:
				if (Stats.getGold ( ) >= arenaCost) {
					Arena.arena();
				}
				else {
					System.out.println ( "You need more gold to enter the Arena" );
					days += 2;
				}
				
				Stats.setBattleCount(0);
							
				break;
			
			case 2:
				if (Stats.getIntel() < 10) {
					Library.library();
				}
				else {
					System.out.println ( "You're way too smart already..." );
					days += 2;
				}
				break;
				
			case 3:
				
				try
				{
					main_test.goQuestDay(Stats.getIntel ( ),Stats.getCharis ( ));
				} catch ( IOException e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			Stats.setCharis(2);
			days -= 2;	
		}
		System.out.println ( "GAME OVER\n" );
		System.out.println ( "Final Gold: " + Stats.getGold());
		if (Stats.getGold ( )<= 0) {
			System.out.println ( "\nYou lived a terribly unlucky life and died young, covered with mud\n"
					+ " in a random ditch outside Indianapolis" );
		}
		else if(Stats.getGold ( ) > 0 && Stats.getGold ( ) < 2000) {
			System.out.println ( "\nYou weren't terribly successful, though you didn't go into debt...\n Eventually you went back"
					+ "to college and got a decent job as a fisherman. ");
		}
		else if(Stats.getGold ( ) >= 2000 && Stats.getGold ( ) < 500) {
			System.out.println ( "You were pretty successful and was Elected mayor of the City. "
					+ "\nYou also founded a non-profit that gives money to impoverished families in Uganda");
		}
		else {
			System.out.println ( "You bought a Spaceship and founded the first colony on Mars. +"
					+ "All hail YOU!" );
		}
	}
}
