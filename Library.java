package Hackathon;
import java.util.Scanner;
public class Library {

public static void library() {
	
	
	int i = Stats.getIntel();
	
	Scanner input = new Scanner(System.in);{
	
	for (int j = 0; j < 3; j++) {
		if(i <= 0) {
			int a = (int)(Math.random() * 5);
			int b = (int)(Math.random() * 5);
			System.out.print("Solve:" + a+"+"+b+"=?" );
			int answer = a + b;
			int ansIn = input.nextInt();
			if(answer == ansIn) {
				 Stats.setIntel(1);
				 Stats.setGold(25);
				 System.out.println ( "Intelligence + 1, Gold + 25" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		if(i == 1) {
			int a = (int)(Math.random() * 25);
			int b = (int)(Math.random() * 25);
			System.out.print("Solve:" + a+"-"+b+"=?" );
			int answer = a - b;
			int ansIn = input.nextInt();
			if(answer == ansIn) {
				 Stats.setIntel(1);
				 Stats.setGold(50);
				 System.out.println ( "Intelligence + 1, Gold + 50" );
			}
			else {
				Stats.setIntel(-1);
			}
		}
		if(i == 2) {
			
			System.out.print("Solve:Why did the chicken cross the Road?" );
			String answer = input.nextLine();
			answer = input.nextLine();
			if(answer.equals ( "to get to the other side" ) || answer.equals ( "to get to the other side" ) ) {
				 Stats.setIntel(1);
				 Stats.setGold(100);
				 System.out.println ( "Intelligence + 1, Gold + 100" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		if(i == 3) {
			int a = (int)(Math.random() * 1000);
			int b = (int)(Math.random() * 1000);
			System.out.print("Solve:" + a+"+"+b+"=?" );
			int answer = a + b;
			int ansIn = input.nextInt();
			if(answer == ansIn) {
				 Stats.setIntel(1);
				 Stats.setGold(150);
				 System.out.println ( "Intelligence + 1, Gold + 150" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		if(i == 4) {
			int a = (int)(Math.random() * 5);
			int b = (int)(Math.random() * 5);
			System.out.print("Solve:We have a barrel in the shape of a cylinder, the base is a circle with a radius of"+ a +"and the height is"+ b +"what is the volume of the Barrel?");
			int answer = (int) ((Math.PI)*(Math.pow(a, 2)) * b );
			int ansIn = input.nextInt();
			if(answer == ansIn) {
				 Stats.setIntel(1);
				 Stats.setGold(200);
				 System.out.println ( "Intelligence + 1, Gold + 200" );
			}
			else {
				Stats.setIntel(-1);	
			}
		}
		if(i == 5) {
			int a = (int)(Math.random() * 11);
			int b = (int)(Math.random() * 21);
			System.out.print("Solve:We have a pile of grain in the shape of a circlular prism , The raduis of the base is"+ a +"and the height is"+ b +"what is the volume of the pile of grain?");
			int answer = (int) ((1/3)*(Math.PI)*(Math.pow(a, 2)) * b );
			int ansIn = input.nextInt();
			if(answer == ansIn) {
				 Stats.setIntel(1);
				 Stats.setGold(250);
				 System.out.println ( "Intelligence + 1, Gold + 250" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		if(i == 6) {
			System.out.print("Solve:What common English verb becomes its own past tence by rearranging its letters?" );
			String answer = input.nextLine();
			if(answer == "eat" || answer == "Eat" ) {
				 Stats.setIntel(1);
				 Stats.setGold(300);
				 System.out.println ( "Intelligence + 1, Gold + 300" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		if(i == 7) {
			int a = (int)(Math.random() * 100);
			
			System.out.print("Solve:If "+a+" is the tempature in Fahrenheit what would that be in celcius?");
			int answer = ((5/9)*(a-32));
			int ansIn = input.nextInt();
			if(answer == ansIn) {
				 Stats.setIntel(1);
				 Stats.setGold(350);
				 System.out.println ( "Intelligence + 1, Gold + 350" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		if(i == 8) {
			System.out.print("Solve:If Jack is older then Jenny. Jimmy is older Jack. Jenny is older then Jimmy. If the First two statements are true. Is the third statement true?" );
			String answer = input.nextLine();
			if(answer == "no" || answer == "No" ) {
				 Stats.setIntel(1);
				 Stats.setGold(400);
				 System.out.println ( "Intelligence + 1, Gold + 400" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		if(i == 9) {
			int a = (int)(Math.random() * 25);
			int b = (int)(Math.random() * 50);
			System.out.print("Solve:We have another much bigger pile of grain in the shape of a circlular prism , The raduis of the base is"+ a +"and the height is"+ b +"what is the volume of the pile of grain?");
			int answer = (int) ((1/3)*(Math.PI)*(Math.pow(a, 2)) * b );
			int ansIn = input.nextInt();
			if(answer == ansIn) {
				 Stats.setIntel(1);
				 Stats.setGold(450);
				 System.out.println ( "Intelligence + 1, Gold + 450" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		if(i == 10) {
			System.out.print("Solve:It occurs once in a minute, twice in a moment, but never in an hour?" );
			String answer = input.nextLine();
			if(answer == "m" || answer == "M" ) {
				 Stats.setIntel(0);
				 Stats.setGold(500);
				 System.out.println ( "Intelligence + 1, Gold + 500" );
			}
			else {
				Stats.setIntel(-1);
				System.out.println ( "Intelligence - 1" );
			}
		}
		i++;
	  }
	}
}
}
