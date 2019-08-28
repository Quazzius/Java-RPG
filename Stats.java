package Hackathon;

public class Stats
{

	static int gold, hp, hpMax, minDMG, maxDMG, dex, evade, sSword,
	lSword, lArmor, mBoots, mDagger, mShield, bSword, hpPot,
	points, battleDec, vRapier, dynamite, cKukri, direction, battleCount,
	pDagger, slArmor, sKatana, lAxe,vBangle,areaCount, intel, charis;

	public static int getBattleCount( )
	{
		return battleCount;
	}

	public static void setBattleCount( int battleCount )
	{ 
		if (battleCount == 1) {
			Stats.battleCount += battleCount;
		}
		else {
			Stats.battleCount = battleCount;
		}
	}

	public static int getIntel( )
	{
		return intel;
	}

	public static void setIntel( int intel )
	{
		Stats.intel += intel;
	}

	public static int getCharis( )
	{
		return charis;
	}

	public static void setCharis( int car )
	{
		Stats.charis += car;
	}

	public static int getGold( )
	{
		return gold;
	}

	public static void setGold( int gold )
	{
		Stats.gold += gold;
	}

	public static int getHp( )
	{
		return hp;
	}

	public static void setHp( int hp )
	{
		Stats.hp += hp;
		if (Stats.hp > Stats.hpMax) {
			hp = Stats.hpMax;
		}
	}

	public static int getHpMax( )
	{
		return hpMax;
	}

	public static void setHpMax( int hpMax )
	{
		Stats.hpMax += hpMax;
		if (Stats.hp > hpMax) {
			Stats.hp = hpMax;
		}
	}

	public static int getMinDMG( )
	{
		return minDMG;
	}

	public static void setMinDMG( int minDMG )
	{
		if (minDMG == 1 || minDMG == -1) {
			Stats.minDMG += minDMG;
		}
		else {
			Stats.minDMG = minDMG;
		}
		
	}

	public static int getMaxDMG( )
	{
		return maxDMG;
	}

	public static void setMaxDMG( int maxDMG )
	{
		if(maxDMG == 1 || maxDMG == -1 || maxDMG == 2) {
			Stats.maxDMG += maxDMG;
		}
		else {
			Stats.maxDMG = maxDMG;
		}
	}

	public static int getDex( )
	{
		return dex;
	}

	public static void setDex( int dex )
	{
		Stats.dex += dex;
	}

	public static int getEvade( )
	{
		return evade;
	}

	public static void setEvade( int evade )
	{
		Stats.evade += evade;
	}

	public static int getsSword( )
	{
		return sSword;
	}

	public static void setsSword( int sSword )
	{
			Stats.sSword += sSword;
	}

	public static int getlSword( )
	{
		return lSword;
	}

	public static void setlSword( int lSword )
	{
		
		Stats.lSword += lSword;
	}

	public static int getlArmor( )
	{
	
		return lArmor;
	}

	public static void setlArmor( int lArmor )
	{
		Stats.lArmor += lArmor;
	}

	public static int getmBoots( )
	{
		return mBoots;
	}

	public static void setmBoots( int mBoots )
	{
		Stats.mBoots += mBoots;
	}

	public static int getmDagger( )
	{
		return mDagger;
	}

	public static void setmDagger( int mDagger )
	{
		Stats.mDagger += mDagger;
	}

	public static int getmShield( )
	{
		return mShield;
	}

	public static void setmShield( int mShield )
	{
		Stats.mShield += mShield;
	}

	public static int getbSword( )
	{
		return bSword;
	}

	public static void setbSword( int bSword )
	{
		Stats.bSword += bSword;
	}

	public static int getHpPot( )
	{
		return hpPot;
	}

	public static void setHpPot( int hpPot )
	{
		Stats.hpPot += hpPot;
	}

	public static int getBattleDec( )
	{
		return battleDec;
	}

	public static void setBattleDec( int battleDec )
	{
		Stats.battleDec += battleDec;
	}

	public static int getvRapier( )
	{
		
		return vRapier;
	}

	public static void setvRapier( int vRapier )
	{
		
		Stats.vRapier += vRapier;
	}

	public static int getDynamite( )
	{
		return dynamite;
	}

	public static void setDynamite( int dynamite )
	{
		Stats.dynamite += dynamite;
	}

	public static int getcKukri( )
	{
		
		return cKukri;
	}

	public static void setcKukri( int cKukri )
	{
		
		Stats.cKukri += cKukri;
	}

	public static int getDirection( )
	{
		return direction;
	}

	public static void setDirection( int direction )
	{
		Stats.direction = direction;
	}

	public static int getpDagger( )
	{
		return pDagger;
	}

	public static void setpDagger( int pDagger )
	{
		Stats.pDagger += pDagger;
	}

	public static int getSlArmor( )
	{
		return slArmor;
	}

	public static void setSlArmor( int slArmor )
	{
		Stats.slArmor += slArmor;
	}

	public static int getsKatana( )
	{
		
		return sKatana;
	}

	public static void setsKatana( int sKatana )
	{
		
		Stats.sKatana += sKatana;
	}

	public static int getlAxe( )
	{
		return lAxe;
	}

	public static void setlAxe( int lAxe )
	{
		
		Stats.lAxe += lAxe;
	}
	public static int getAreaCount( )
	{
		return areaCount;
	}

	public static void setAreaCount( int areaCount )
	{
		if (areaCount == 0) {
			Stats.areaCount = areaCount;
		}
		else {
			Stats.areaCount += areaCount;
		}
	}
	public static void initialize() {
		 Stats.setHpMax(100); Stats.setHp(100); Stats.setMinDMG(2); Stats.setMaxDMG(5); Stats.setDex(7); Stats.setEvade(7);Stats.setsSword(1); 
		Stats.setlSword(1); Stats.setlArmor(1); Stats.setmBoots(1); Stats.setmDagger(1); Stats.setmShield(1); Stats.setbSword(1); Stats.setHpPot(0); 
		Stats.setBattleDec(0);Stats.setvRapier(1); Stats.setDynamite(0); Stats.setcKukri(1); Stats.setDirection(0); 
		Stats.setpDagger(1); Stats.setSlArmor(1); Stats.setsKatana(1); Stats.setlAxe(1); Stats.setAreaCount(0);
	}
}
