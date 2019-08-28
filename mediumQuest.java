package Hackathon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mediumQuest {

	private int quality;
	private String summary, quest, ending1, ending2, ending3, ending4;
	
	public mediumQuest() throws IOException 
	{
		// Points a FileReader object to the named text file.
		FileReader fr2 = new FileReader("mediumquest.txt");	
		// Creates a BufferedReader object to take in an input stream from the file.
		BufferedReader br2 = new BufferedReader(fr2);
		// String 'line' will store each text line read from the file.
		// Each line in the text file is terminated with a "\n" character.
		// The .readLine() method returns null when the end of the file is reached.
				
		//randomize quest
		int random2 = (int)(Math.random()*5); // REMEMBMER TO CHANGE THISSSS
		String line = br2.readLine();
		for (int ct=0; ct<random2; ct++)
			{
			line = br2.readLine();
			}
		br2.close();
				
		summary = line.substring(0, line.indexOf(";")); //gets summary
		line = line.substring(line.indexOf(";")+1); //removes summary
				
		quest = line.substring(0, line.indexOf(";")); //gets problem
		line = line.substring(line.indexOf(";")+1); //removes problem
				
		ending1 = line.substring(0, line.indexOf(";")); //gets ending 1
		line = line.substring(line.indexOf(";")+1); //removes ending 1
				
		ending2 = line.substring(0, line.indexOf(";")); //gets ending 2
		line = line.substring(line.indexOf(";")+1); //removes ending 2
				
		ending3 = line.substring(0, line.indexOf(";")); //gets ending 3
		line = line.substring(line.indexOf(";")+1); //removes ending 3
				
		ending4 = line; //sets ending 4
		}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void doMediumQuest() throws IOException
		{
		System.out.println("... You follow the flyer that says \"" + summary + "\"");
		System.out.println("... " + quest);
		System.out.println("... You accept the quest!");
		System.out.println ("... ----------------------------------------------------");
		//Obstacles
		for (int ct = 0; ct<5; ct++)
			{
			Obstacle o = new Obstacle();
			int solution = o.doObstacle(); //returns solution number
			quality-=solution;
			}
		//endings
		if (quality >= 10)
			{
			Stats.setGold(1000);
			System.out.println("... " + ending1);
			System.out.println("... You are awarded 1000 gold for your unworldly performance");
			}
		else if (quality >= 6)
			{
			Stats.setGold(600);
			System.out.println("... " + ending1);
			System.out.println("... You are awarded 600 gold for your amazing performance");
			}
		
		else if (quality >= 3)
			{
			Stats.setGold(300);
			System.out.println("... " + ending2);
			System.out.println("... You are awarded 300 gold for your mediocre performance");
			}
		else if (quality >= 0)
			{
			Stats.setGold(100);
			System.out.println("... " + ending3);
			System.out.println("... You are donated 100 gold for your sad performance");
			}
		else
			{
			System.out.println("... " + ending4);
			System.out.println("... Don't even think about getting any money.");
			}
		System.out.println ("----------------------------------------------------");
		}

	
	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}

	public String getEnding1() {
		return ending1;
	}

	public void setEnding1(String ending1) {
		this.ending1 = ending1;
	}

	public String getEnding2() {
		return ending2;
	}

	public void setEnding2(String ending2) {
		this.ending2 = ending2;
	}

	public String getEnding3() {
		return ending3;
	}

	public void setEnding3(String ending3) {
		this.ending3 = ending3;
	}

	public String getEnding4() {
		return ending4;
	}

	public void setEnding4(String ending4) {
		this.ending4 = ending4;
	}



}
