package Hackathon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Obstacle {
	
	private String problem, soln1, soln2, soln3, soln4;
	Scanner scan = new Scanner(System.in);
	
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
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

	public Obstacle() throws IOException 
		{
		// Points a FileReader object to the named text file.
		FileReader fr2 = new FileReader("obstacles.txt");	
		// Creates a BufferedReader object to take in an input stream from the file.
		BufferedReader br2 = new BufferedReader(fr2);
		// String 'line' will store each text line read from the file.
		// Each line in the text file is terminated with a "\n" character.
		// The .readLine() method returns null when the end of the file is reached.
		
		//randomize quest
		int random2 = (int)(Math.random()*15);
		String line = br2.readLine();
		for (int ct=0; ct<random2; ct++)
			{
			line = br2.readLine();
			}
		br2.close();
		
		problem = line.substring(0, line.indexOf(";")); //gets problem
		line = line.substring(line.indexOf(";")+1); //removes problem
		
		soln1 = line.substring(0, line.indexOf(";")); //gets solution 1
		line = line.substring(line.indexOf(";")+1); //removes solution 1
		
		soln2 = line.substring(0, line.indexOf(";")); //gets solution 2
		line = line.substring(line.indexOf(";")+1); //removes solution 2
		
		soln3 = line.substring(0, line.indexOf(";")); //gets solution 3
		line = line.substring(line.indexOf(";")+1); //removes solution 3
		
		soln4 = line; //sets solution 4
		}
	
	public int doObstacle() throws IOException 
		{
		
		System.out.println("... You're wandering around...");
		scan.nextLine();
		System.out.println("... Suddenly, an Obstacle appears!");
		System.out.println("!!!" + problem);
		
		System.out.println("... What do you do?!?");
		
		System.out.println("...     1: " + soln1);
		System.out.println("...     2: " + soln2);
		System.out.println("...     3: " + soln3);
		System.out.println("...     4: " + soln4);
		System.out.println("...");
		int userInput = scan.nextInt();
		while (userInput>4 || userInput<1)
			{
			System.out.println("... That is not a valid choice. Please choose a number between 1 and 4: ");
			userInput = scan.nextInt();
			}
		switch (userInput)
			{
			case 1: 
				{
				System.out.println("... Its very effective!");
				break;
				} 
			case 2: 
				{
				System.out.println("... Its not effective... your plan backfired!");
				break;
				} 
			case 3: 
				{
				System.out.println("... Its somewhat effective.");
				break;
				} 
			case 4: 
				{
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
					
				System.out.println("... \"YOU WIMP!!!\" " + name + " spawns out of nowehere and yells at you for being useless.");
				
				break;
				} 
			}
		System.out.println ("----------------------------------------------------");
		return userInput;
		}

}
