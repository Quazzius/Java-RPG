package Hackathon;
import java.io.*; 
import java.io.IOException;
import java.util.Scanner;

public class easyQuest 
{
	//variable declarations
	private String npc;
	private String quest;
	private String soln1;
	private String soln2;
	private String soln3;
	Scanner scan = new Scanner(System.in);
	
	//getters and setters
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

	public String getSoln3() {
		return soln3;
	}

	public void setSoln3(String soln3) {
		this.soln3 = soln3;
	}

	//Standard definitions
	public easyQuest(String name, String line, String sol1, String sol2, String sol3)
		{
		npc = name;
		quest = line;
		soln1 = sol1;
		soln2 = sol2;
		soln3 = sol3;
		}	
	
	//really useful random creation thing
	public easyQuest()throws IOException
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
		
		// Points a FileReader object to the named text file.
		FileReader fr2 = new FileReader("easyquest.txt");	
		// Creates a BufferedReader object to take in an input stream from the file.
		BufferedReader br2 = new BufferedReader(fr2);
		// String 'line' will store each text line read from the file.
		// Each line in the text file is terminated with a "\n" character.
		// The .readLine() method returns null when the end of the file is reached.
		
		//randomize quest
		int random2 = (int)(Math.random()*12);
		String line = br2.readLine();
		for (int ct=0; ct<random2; ct++)
			{
			line = br2.readLine();
			}
		br2.close();
		
		npc = name;
		
		quest = line.substring(0, line.indexOf(";")); //gets quest
		line = line.substring(line.indexOf(";")+1); //removes quest
		
		soln1 = line.substring(0, line.indexOf(";")); //gets solution 1
		line = line.substring(line.indexOf(";")+1); //removes solution 1
		
		soln2 = line.substring(0, line.indexOf(";")); //gets solution 2
		line = line.substring(line.indexOf(";")+1); //removes solution 2
		
		soln3 = line; //sets solution 3
		}
	
	
	public void doEasyQuest()
		{
		System.out.println(npc + " " + quest);
		System.out.println("What do you do?");
		System.out.println("     1: " + soln1);
		System.out.println("     2: " + soln2);
		System.out.println("     3: " + soln3);
		System.out.println("...");
		int userInput = scan.nextInt();
		while (userInput>3 || userInput<1)
			{
			System.out.println("That is not a valid choice. Please choose 1, 2, or 3: ");
			userInput = scan.nextInt();
			}
		if (userInput ==1)
			{
			Stats.setGold(-100);
			Stats.setCharis(1);
			System.out.println("Your Charisma increases by 1!" );
			System.out.println("Your Gold decreases by 100..." );
			}
		else if (userInput ==2)
			{
			Stats.setCharis(-1);
			System.out.println("Your Charisma decreases by 1.." );
			}
		else
			{
			Stats.setGold(100);
			System.out.println("Your Gold increases by 100!" );
			}
	}
}
	
	