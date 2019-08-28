package Hackathon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class trashQuest {
	private String npc;
	private String quest = "begs you for money!";
	private String soln1 = "Give them money";
	private String soln2 = "Don't give them money";
	Scanner scan = new Scanner(System.in);
	
	public trashQuest() throws IOException 
		{
		// Points a FileReader object to the named text file.
		File filename = new File ("NPCnames.txt");
		
		// Creates a BufferedReader object to take in an input stream from the file.
		BufferedReader br = new BufferedReader(new FileReader (filename));
		// String 'name' will store each text line read from the file.
		// Each line in the text file is terminated with a "\n" character.
		// The .readLine() method returns null when the end of the file is reached.
				
		//randomize name
		int random = (int)(Math.random()*200);
		String name = br.readLine();
		for (int ct=0; ct<random; ct++)
			{
			name = br.readLine();
			}
		br.close();
				
		npc = name;		
		}

	public void doTrashQuest()
		{
		System.out.println(npc + " " + quest);
		System.out.println("What do you do?");
		System.out.println("     1: " + soln1);
		System.out.println("     2: " + soln2);
		System.out.println("...");
		int userInput = scan.nextInt();
		while (userInput>2 || userInput<1)
			{
			System.out.println("That is not a valid choice. Please choose 1 or 2: ");
			userInput = scan.nextInt();
			}
		if (userInput ==1)
			{
			Stats.setGold(-100);
			System.out.println("Your Gold decreases by 100..." );
			}
		else if (userInput ==2)
			{
			Stats.setCharis(-1);
			System.out.println("Your Charisma decreases by 1..." );
			}
		}
	public String getNpc() {
		return npc;
	}
	public void setNpc(String npc) {
		this.npc = npc;
	}
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	public String getSoln1() {
		return soln1;
	}
	public void setSoln1(String soln1) {
		this.soln1 = soln1;
	}
	public String getSoln2() {
		return soln2;
	}
	public void setSoln2(String soln2) {
		this.soln2 = soln2;
	}

}
