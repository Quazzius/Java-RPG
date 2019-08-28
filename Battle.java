package Hackathon;

import java.util.Scanner;

public class Battle
{

	public static final int minEnc = 1, maxEnc = 2, encNumber = 1, range = maxEnc - minEnc + 1;
	public static int rand, attack, hitDMG, hitChance, merch, city = 0;
	
	public static void battleSequence(int minRange, int maxRange, String eType, String aType, int eMaxHit, int eMinHit, 
			int enemyHP, int maxFlee, int minFlee, int rewardGold, int rewardPoints, int heroHit, String killText, String deathFlavor, char enemyAbility) {
		Scanner input = new Scanner(System.in);
		int poisonCount = 0; //initialize hero poisoned counter
		int ePoisonCount = 0; // initialize enemy poisoned counter
		int stunCount = 0;  //initialize hero stun
		int eStunCount = 0;
		int battleDec = 0;
		attack = Stats.getMaxDMG ( ) - Stats.getMinDMG() + 1;
		while (enemyHP > 0)  //fight sequence
		{	
			eStunCount--;
			if (eStunCount < 1) {
				int damage = (int) ( Math.random ( ) * maxRange + minRange ); //enemy attack range
				System.out.println ( eType + aType + " for " + damage + " damage.");
				hitChance = (int) ( Math.random ( ) * eMaxHit + eMinHit);  //enemy hit chance
				if (Stats.evade > hitChance) //if evade is greater than hit
				{
					System.out.println ( "But Misses!" );
				}
				else
				{
					Stats.setHp (-damage ); //player attacked
					System.out.println ( "-" + damage + " HP. " + "HP is " + Stats.hp + "/" + Stats.hpMax);
					 //if enemy ability type "v" vampirism
					if (enemyAbility == 'v') {  
						double vamp = damage * 0.25;  // heals 25% damage given
						int iVamp = (int) vamp;  // change from double to int
						if (iVamp > 0) {   // output if necessary
							System.out.println ( eType + " heals " + iVamp + " HP" );
							enemyHP += iVamp;
						}
					}
					else if (enemyAbility == 'p' && poisonCount < 1) {
						int poison = (int) (Math.random ( ) * 3 + 1);
						if (poison == 3) {
							System.out.println ( "You're Poisoned!" );
							poisonCount = 3;
						}
					}
					else if (enemyAbility == 's' && stunCount < 1) {
						int stun = (int) (Math.random ( ) * 8 + 1);
						if (stun == 5) {
							System.out.println ( "You're Stunned! (1 turn)\n" );
							stunCount = 2;
						}
					}
					if (Stats.getHp() < 1) //on death condition, reset variables to go to game over
					{
						enemyHP = 0;
						Stats.setBattleCount(5);
					}
				}
			}
			if (poisonCount > 0 ){
				poisonCount--;
				System.out.println ( "-2 HP (Poison), left: " + poisonCount);
				Stats.setHp(-2);
				
			}
			  //battle decision
			
			stunCount--;
			if (Stats.getHp() > 0 && stunCount < 1) {
				System.out.println ( "0 - Flee\n1 - Attack" );
					System.out.println ( "3 - Dynamite: " + Stats.getDynamite());
					System.out.println ( "5 - Health Potion: " + Stats.getHpPot() );
				
				
				battleDec = input.nextInt();
				
				//flee
				switch (battleDec) 
				{
					//flee
					case 0:
						hitChance = (int) ( Math.random ( ) * maxFlee + minFlee);  //chance to flee
						if (Stats.evade > hitChance) {  //flee successful
							System.out.println ( "You run away! Coward!" );
							enemyHP = 0;
						}
						else { //flee unsuccessful
							System.out.println ( "You try to run, but you trip and fall on your face." );
						}
						break;
				
					//attack
					case 1:
						hitDMG = (int) ( Math.random ( ) * attack + Stats.getMinDMG());  //possible damage range
						hitChance = (int) ( Math.random ( ) * heroHit + 1);  //chance to hit
						if (Stats.getDex() >= hitChance)  //if dex is at least heroHit chance
						{
							System.out.println ( "You hit for " + hitDMG + " DMG" );
							enemyHP -= hitDMG;
							
							//character ability Vamp
							if (Stats.getvRapier() == 0 || Stats.getsKatana() == 0) { 
								System.out.println ( "HP + 1" );
								Stats.setHp (1);
							}
							//character ability poison
							else if (Stats.getcKukri() == 0 && ePoisonCount < 1) {
								int ePoison = (int) (Math.random ( ) * 3 + 1);
								if (ePoison == 3) {
									System.out.println ( eType + " Poisoned!" );
									ePoisonCount = 3;
								}
							}
							else if (Stats.getlAxe() == 0) {
								int eStun = (int) (Math.random ( ) * 7 + 1);
								if (eStun == 3) {
									System.out.println ( eType + " Stunned!" );
									eStunCount = 2;
								}
							}
						}
						else
						{
							System.out.println ( "You miss! Lame!" );
						}
						if (ePoisonCount > 0) {
							System.out.println ( eType + " -2 HP (Poison), Left: " + ePoisonCount );
							enemyHP -= 2;
							ePoisonCount--;
						}
					break;
						
					case 3:
						if (Stats.getDynamite() > 0) {
							System.out.println ( "You light the wick and toss the dynamite at the " + eType );
							System.out.println ( "dealing 30 damage! Your reckless action deals 5 damage to you as well" );
							enemyHP -= 30;
							Stats.setHp (-5);
							Stats.setDynamite(-1);
						}
						else {
							System.out.println ( "Idiot! You have no explosives in your inventory!" );
						}
					break;
					
					//heal
					case 5:
						if (Stats.getHpPot() > 0) {
							System.out.println ( "That Sauce is Awesome!\n +50 HP" );
							Stats.setHpPot(-1);  //used potion
							Stats.setHp (50); // heal
						}
						else {
							System.out.println ( "Fool! You have no bottles in supply!" );
						}
				}
			}
		}
		if (Stats.getHp() > 0 && battleDec != 0) { //make sure hero did not die for reward
			System.out.println ( killText + eType + deathFlavor );
			Stats.setGold(rewardGold); // gold	
			Stats.setAreaCount(1);
		}	
	}
	
	public static void enemies() {
		int enemy = (int) ( Math.random ( ) * 9 + 1);  //random enemy
		switch (enemy)
		{
			case 1: 
				System.out.println ("Its a bear!" );   //Bear fight
				char enemyAbility = 'a';  //enemy special ability class ( none)
				int enemyHP = 15;   //enemy health initialize
				String eType = "Bear"; //type of enemy
				String aType = " Swipes";  //attack style
				String killText = "You killed a "; //type of death
				String deathFlavor = "! +80 gold for some reason"; //flavor text on enemy death
				int minRange = 3, maxRange = 8;  // enemy damage range;
				int eMinHit = 4, eMaxHit = 10;  // enemy chance to hit
				int minFlee = 4, maxFlee = 8;   // chance to flee from  enemy
				int heroHit = 8;  // chance to hit enemy
				int rewardGold = 80, rewardPoints = 50;
				 Battle.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit, enemyHP, maxFlee, 
						minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
			break;
			
			case 2: 
				System.out.println ("The ground explodes in front of you and a glistening insect crawls from the chasm" ); //Ferns
				enemyAbility = 's';
				 enemyHP = 35;   
				 eType = "Crystal Scorpion";
				 aType = " Stings";
				 killText = "You crush the ";
				 deathFlavor = " and find it has a diamond for a heart. +114 Gold! ";
				 minRange = 5; 
				 maxRange = 7;
				 eMinHit = 5; 
				 eMaxHit = 12;
				 minFlee = 4; 
				 maxFlee = 8;
				 heroHit = 9;
				 rewardGold = 114;
				 rewardPoints = 155;
				Battle.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
					enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
			break;
			
			case 3: 
				System.out.println ( "An Elf appears... to be very Menacing!" );
				enemyAbility = 'a';
				enemyHP = 15;   
				eType = "Crazy Elf";
				aType = " attacks";
				killText = "You killed a ";
				deathFlavor = ". and robbed his corpse of 72 gold! Awesome!";
				minRange = 3; 
				maxRange = 5;
				eMinHit = 6; 
				eMaxHit = 10;
				minFlee = 4; 
				maxFlee = 8;
				heroHit = 8;
				rewardGold = 72;
				rewardPoints = 30;
				 Battle.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
						minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
				 
				 break;
				 
			case 4: 
				System.out.println ( "Its a Giant Sewer Rat! " );   //Sewer Rat
				enemyAbility = 'a';
				enemyHP = 25;   
				eType = "Sewer Rat";
				aType = " bites";
				killText = "You killed a Giant ";
				deathFlavor = "! Gross!\nOne of the locals witnessed your heroic deed and hands you 110 gold";
				minRange = 5; 
				maxRange = 8;
			 	eMinHit = 6; 
				eMaxHit = 12;
				minFlee = 6; 
				maxFlee = 6;
				heroHit = 9;
				rewardGold = 110;
				rewardPoints = 250;
				Battle.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
					enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
	
			break;
			
			case 5: 
				System.out.println ("A robed figure leaps from the shadows and stabs at you without warning" ); //cultist 
				enemyAbility = 'p';
				enemyHP = 30;   
				eType = "Cultist";
				aType = " stabs wildly";
				killText = "You decapitate the ";
				deathFlavor = " of Chaos...\ntheir purse holds 124 gold.";
				minRange = 5; 
				maxRange = 8;
			 	eMinHit = 5; 
				eMaxHit = 12;
				minFlee = 5; 
				maxFlee = 7;
				heroHit = 8;
				rewardGold = 124;
				rewardPoints = 110;
				Battle.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
					enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				break;
				
			case 6:
				System.out.println ("A Giant Leech! Disgusting!" ); //leech 
				enemyAbility = 'v';
				enemyHP = 24;   
				eType = "Leech";
				aType = " bites";
				killText = "You Skewer the Giant ";
				deathFlavor = ". Gross! it expells 80 gold";
				minRange = 3; 
				maxRange = 8;
			 	eMinHit = 4; 
				eMaxHit = 12;
				minFlee = 4; 
				maxFlee = 8;
				heroHit = 8;
				rewardGold = 80;
				rewardPoints = 70;
				 Battle.battleSequence ( minRange, maxRange, eType, aType, eMaxHit, eMinHit,  enemyHP, maxFlee,
						minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility );
				 break;
				 
				 
			case 7: 
				System.out.println ("The sky darkens. You look above to see an enormous colony of thirsty Vampire Bats" ); //bat 
				enemyAbility = 'v';
				enemyHP = 40;   
				eType = "Vampire Bat";
				aType = " swoops";
				killText = "You slaughter the colony of ";
				deathFlavor = "s and the crowd throws 150 gold at you.";
				minRange = 7; 
				maxRange = 5;
			 	eMinHit = 5; 
				eMaxHit = 12;
				minFlee = 5; 
				maxFlee = 7;
				heroHit = 9;
				rewardGold = 150;
				rewardPoints = 140;
				Battle.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
					enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				break;
			
			case 8: 
				System.out.println ("The nerby ferns begin to hiss. They uproot themselves and lash at you with their barbed stolons" ); //Ferns
				enemyAbility = 'a';
				enemyHP = 35;   
				eType = "Fern Feind";
				 aType = " whips ";
				killText = "You dice the ";
				deathFlavor = "s and clip their buds worth 5 gold a piece. +85 gold";
				 minRange = 5; 
				 maxRange = 8;
				 eMinHit = 5; 
				 eMaxHit = 12;
				 minFlee = 4; 
				 maxFlee = 8;
				 heroHit = 9;
				 rewardGold = 160;
				 rewardPoints = 125;
				Battle.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
					enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
			
			break;
			
			case 9: 
				System.out.println ("An octopus-like plant wants to devour you!" ); //bat 
				enemyAbility = 'p';
				enemyHP = 50;   
				eType = "Malboro Red";
				aType = " swats";
				killText = "You slay the ";
				deathFlavor = ". upon death it spews 200 gold.";
				minRange = 6; 
				maxRange = 9;
			 	eMinHit = 5; 
				eMaxHit = 12;
				minFlee = 5; 
				maxFlee = 7;
				heroHit = 9;
				rewardGold = 200;
				rewardPoints = 170;
				Battle.battleSequence(minRange, maxRange, eType, aType, eMaxHit, eMinHit,  
					enemyHP, maxFlee, minFlee, rewardGold, rewardPoints, heroHit, killText, deathFlavor, enemyAbility);
				
		}
		
		Stats.setBattleCount(1);
		if (Stats.getBattleCount() < 4) {
			System.out.println ( "\nNext Battle!\n" );
		}
		else {
			System.out.println ( "You head back to town..." );
		}
	}

}
