package Hackathon;

import java.util.Scanner;

public class Arena
{
	public static Scanner input = new Scanner (System.in);
	
	public static int rand, attack, hitDMG, hitChance;
	
	
	public static void arena() {
		
		
		Stats.initialize();
		
		int merch = 0;
		while (merch != -1) {
			System.out.println ( "Welcome to the Arena! Prepare yourself!" );
			int sSwordCost = 10;
			int bSwordCost = 120;
			System.out.println ( "0 - Snowy Bastard Sword. 6 - 12 DMG. (120 gold) In stock: " + Stats.getbSword() );
			System.out.println ( "1 - A reliable steel Short Sword. DMG: 3-6. (10 gold). In Stock: " + Stats.getsSword() );
			int lSwordCost = 15;
			int dynamiteCost = 25;
			System.out.println ( "2 - dynamite does 30 damage though damages you for 5. (25 gold)");
			int lArmorCost = 15;
			System.out.println ( "3 - Leather Armour. + 1 evade. (15 gold). InStock: " + Stats.getlArmor());
			int slArmorCost = 50;
			System.out.println ( "4 - Studded leather armor, + 2 evade (50 gold) In stock: " + Stats.getSlArmor ( ));
			int vRapierCost = 150;
			System.out.println ( "5 - Void Rapier. 5 - 11 DMG. Heals 1 HP on Hit. (150 gold)" + Stats.getvRapier() );
			int hpPotCost = 15;
			System.out.println ( "6 - Magic EEL Sauce to go. Heal 50 HP in battle (15 gold)" );
			int cKukriCost = 115;
			System.out.println ( "7 - Coral Kukri. 6 - 11 DMG, 33% Chance to Poison (115 gold)" + Stats.getcKukri());
			int lAxeCost = 240;
			System.out.println ( "8 - Lightning Axe. 8 - 13 DMG, 14% Chance to Stun (240 gold)" + Stats.getlAxe() );
			System.out.println ( "9 - BATTLE!!!!" );
			
			System.out.println ( "You have " + Stats.getGold() + " gold");
			do {
				merch = input.nextInt();   //input decision
				if (merch < 0 || merch > 9) {
					System.out.println ( "You must enter a valid number (0-9)" );
				}
			} while (merch < 0 || merch > 9);
				switch (merch)
				{
					case 0:
						if (Stats.getbSword() > 0)
						{
							if (Stats.getGold() >= bSwordCost)
							{
								System.out.println ( "Gripping the pommel, a chill flows from your palm to the top of your head." );
								System.out.println ( "It feels as though you pulled this sword from its own grave" );
								System.out.println ( "DMG = 6 - 12" );
								Stats.setMinDMG(6);
								Stats.setMaxDMG(12);
								Stats.setGold(-bSwordCost);
								Stats.setbSword(-1);
								Stats.setvRapier(1);
							}
							else
							{
								System.out.println ( "You are too poor for this item. you have " + Stats.getGold() + " gold");
							}
						}
						else
						{
							System.out.println ( "Sorry, This item is out of stock." );
						}
						
						break;
						
					case 1:  //buy  short sword
						if (Stats.getsSword() > 0)
						{
							if (Stats.getGold() >= sSwordCost)
							{
								System.out.println ( "The Short Sword is now yours! DMG: 3-6" );
								Stats.setMinDMG(3);
								Stats.setMaxDMG(6);
								Stats.setGold(-sSwordCost);
								Stats.setsSword(-1);
								Stats.setvRapier(1);
							
								if(Stats.getmDagger() == 0)
								{
									Stats.setMinDMG(1);
								}
							}
							else
							{
								System.out.println ( "You are too poor for this item. you have " + Stats.getGold() + " gold");
							}
						}
						else
						{
							System.out.println ( "Sorry, This item is out of stock." );
						}
						break;
						
					case 2:  //buy long sword
						if (Stats.getDynamite() < 1) {
							if (Stats.getGold() >= dynamiteCost) {
								System.out.println ( "You get a Stick of Dynamite. Use it recklessly" );
								Stats.setGold(-dynamiteCost);
								Stats.setDynamite(1);
							}
							else {
								System.out.println ( "I'm your friend but I still require payment. " );
								System.out.println ( "You only have " + Stats.getGold() + " gold..." );
							}
						}
						else {
							System.out.println ( "You can only hold one explosive at a time." );
						}
						break;
						
					case 3:  // buy leather armor
						if (Stats.getlArmor() > 0)
						{
							if (Stats.getGold() >= lArmorCost)
							{
								System.out.println ( "The Leather Armor fits! +1 Evade" );
								Stats.setEvade(1);
								Stats.setGold(-lArmorCost);
								Stats.setlArmor(-1);
							}
							else
							{
								System.out.println ( "You are too poor for this item. you have " + Stats.getGold() + " gold");
							}
						}
						else
						{
							System.out.println ( "Sorry, This item is out of stock." );
						}
						break;
						
					case 4:
						if (Stats.getSlArmor() > 0)
						{
							if (Stats.getGold() >= slArmorCost)
							{
								if (Stats.getlArmor() == 0) {
									System.out.println ( "You're glad to get some new armor and remove your old leather armor. -1 Evade" );
									System.out.println ( "It would be best if it was burned...\n" );
									Stats.setEvade(-1);
								}
								System.out.println ( "The Studded Leather Armor fits like a glove. +2 Evade" );
								Stats.setEvade(2);
								Stats.setGold(-slArmorCost);
								Stats.setSlArmor(-1);
							}
							else
							{
								System.out.println ( "You are too poor for this item. you have " + Stats.getGold() + " gold");
							}
						}
						else
						{
							System.out.println ( "Sorry, This item is out of stock." );
						}
						break;
						
					case 5:
						if (Stats.getvRapier() > 0)
						{
							if (Stats.getGold() >= vRapierCost)
							{
								System.out.println ( "Gripping the pommel, you get the feeling of a ghostly tentacle\nweaving its way through the tendons of your forearm." );
								System.out.println ( "DMG = 5 - 11. Max HP -10.\nYou feel more vascular." );
								Stats.setMinDMG(5);
								Stats.setMaxDMG(11);
								Stats.setGold(-vRapierCost);
								Stats.setvRapier(-1);
							
							}
							else
							{
								System.out.println ( "You are too poor for this item. you have " + Stats.getGold() + " gold");
							}
						}
						else
						{
							System.out.println ( "Sorry, This item is out of stock." );
						}
						break;
						
					case 6:
						if (Stats.getHpPot() < 1) {
							if (Stats.getGold() >= hpPotCost) {
								System.out.println ( "You get a bottle of Magic EEl Sauce. Use it wisely" );
								Stats.setGold(-hpPotCost);
								Stats.setHpPot(1);
							}
							else {
								System.out.println ( "Damn it man! I'm a Merchant, not a Barber! You'll get no charity here. " );
								System.out.println ( "You have " + Stats.getGold() + " gold. Go find some more" );
							}
						}
						else {
							System.out.println ( "You can only hold one bottle at a time." );
						}
						break;
						
					case 7: 
						if (Stats.getcKukri() > 0)
						{
							if (Stats.getGold() >= cKukriCost)
							{
								System.out.println ( "The Coral Kukri is now yours! DMG: 6-11. careful not to poison yourself..." );
								Stats.setMinDMG(6);
								Stats.setMaxDMG(11);
								Stats.setGold(-cKukriCost);
								Stats.setcKukri(-1);
								Stats.setvRapier(1);
								Stats.setlAxe(1);
								Stats.setsKatana(1);
							}
							else
							{
								System.out.println ( "You are too poor for this item. you have " + Stats.getGold() + " gold");
							}
						}
						else
						{
							System.out.println ( "Sorry, This item is out of stock." );
						}
						break;
						
					case 8:
						if (Stats.getlAxe() > 0)
						{
							if (Stats.getGold() >= lAxeCost)
							{
								System.out.println ( "A surge of static energy flows through your whole body and settles\n 8 - 13 DMG" );
								Stats.setMinDMG(8);
								Stats.setMaxDMG(13);
								Stats.setGold(-lAxeCost);
								Stats.setlAxe(-1);
								Stats.setcKukri(1);
								Stats.setvRapier(1);
								Stats.setsKatana(1);
								
							}
							else
							{
								System.out.println ( "You are too poor for this item. you have " + Stats.getGold() + " gold");
							}
						}
						break;
						
					case 9:
						while (Stats.getBattleCount() < 5) {
							
							Battle.enemies ( );
					
						merch = -1;
					}
			}
		}
	}
}

