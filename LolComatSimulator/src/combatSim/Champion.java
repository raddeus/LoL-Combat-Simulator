package combatSim;

import java.util.Random;

public class Champion implements Runnable {
	private double health;
	private int attackDamage;
	private double attackSpeed = 1.5;
	private double lifeSteal;
	private double armor;
	private double criticalStrike;
	private double dodge;
	private double critDamagePercent;
	private boolean isReadyToAttack = true;
	private boolean stop = false;
	private double lastDamageTaken;
	private boolean victory = false;
	private boolean stunned = false;
	private long stunDuration = 2000;
	private String champName;

	// use these to give relevant infos.
	// private double totalDamageTaken;
	// private double totalDamageHealed;
	// private double totalDamageMitigatedArmor;
	// private double totalDamageDealt;
	
	private StatEntryPane pane;

	public Champion() {
	}

	public Champion(String ChampName, StatEntryPane Pane, double Health, int AttackDamage,
			double LifeSteal, double AttackSpeed, double Armor,
			double CritStrike, double CritDamagePercent, double Dodge) {
		this.champName = ChampName;
		this.pane = Pane;
		this.health = Health;
		this.attackDamage = AttackDamage;
		this.attackSpeed = AttackSpeed;
		this.armor = Armor;
		this.criticalStrike = CritStrike;
		this.critDamagePercent = CritDamagePercent;
		this.lifeSteal = LifeSteal;
		this.victory = false;
		this.dodge = Dodge;
		

	}
	// methods
	private double convertAtkSpd(double d) {// converts attackspeed into time in
		return 1000 / d;}					// milliseconds for the threads to wait.
											
	public double getRawDamageOut() {
		Random crit = new Random();
		double damageGiven;
		double didyoucrit = (double) crit.nextInt(100);

		if (didyoucrit < criticalStrike) {
			damageGiven = attackDamage * ((critDamagePercent + 100) / 100);
			System.out
					.println("CRIT! for: " + damageGiven + " dmg unmitigated");
			pane.setLiveOutput("I CRIT");
			return damageGiven;

		} else {
			damageGiven = attackDamage;
			System.out.println("nonCRIT! for :" + damageGiven
					+ " dmg unmitigated");
			pane.setLiveOutput("ATTACK!");
			return damageGiven;
		}


	}

	public void takeDamage(double RawDamageIn) {
		double damageTaken;
		Random dodgeRandom = new Random();
		double didyoudodge = (double) dodgeRandom.nextInt(100);
		if (didyoudodge < this.dodge) {
			// you dodged
			lastDamageTaken = 0;
			pane.setLiveOutput("I DODGED");
			System.out.println("Dodged - 0 dmg taken.");
		} else {
			if (this.armor >= 0)// calculates damage after armor
			{//i hate you thad
				System.out.println("took in " + RawDamageIn + " damage");
				damageTaken = (RawDamageIn * (100 / (100 + this.armor)));
				health -= damageTaken;
				lastDamageTaken = damageTaken;
				pane.setLiveOutput(Integer.toString((int) damageTaken));
				System.out.println("Took" + damageTaken + " mitigated damage");
			} else {
				damageTaken = RawDamageIn; // no armor, returning true damage
				health -= damageTaken;
				pane.setLiveOutput(Integer.toString((int) damageTaken));
				lastDamageTaken = damageTaken;
			}
		}
	}

	// getters
	public double getHealth() {
		return this.health;
	}

	public double getAttackSpeed() {
		return this.attackSpeed;
	}

	public int getAttackDamage() {
		return this.attackDamage;
	}

	public double getLifeSteal() {
		return this.lifeSteal;
	}

	public double getLastDamageTaken() {
		return lastDamageTaken;
	}

	public double getArmor() {
		return this.armor;
	}

	public double getCrit() {
		return this.criticalStrike;
	}

	// setters
	public void setHealth(int a) {
		health = a;
	}

	public void setATKsp(double d) {
		attackSpeed = d;
	}

	public void setAD(int a) {
		attackDamage = a;
	}

	public void setNotReady() {
		isReadyToAttack = false;
	}
	
	public void setStunned(boolean b){
		stunned = b;
	}

	public void setLifeSteal(double d) {
		lifeSteal = d;
	}

	public void setArmor(int a) {
		armor = a;
	}

	public void setCrit(double d) {
		criticalStrike = d;
	}

	public boolean isReadyToAttack() {
		return isReadyToAttack;
	}

	@Override
	public void run() {
		stop = false;
		while (!stop && this.health > 0) {
			if(stunned){
				//sleep for stun duration
				try {
					Thread.sleep(stunDuration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					stunned = false;
				}
			}
			isReadyToAttack = true;
			try {
				System.out.println("sleeping for"
						+ (long) convertAtkSpd(attackSpeed));
				Thread.sleep((long) convertAtkSpd(attackSpeed));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public void requestStop() {
		stop = true;

	}

	public void healLifeSteal(double mitigatedDamage) {
		double healFor;
		System.out.println("taking in number for healing:" + mitigatedDamage);
		healFor = mitigatedDamage * (this.lifeSteal / 100.0D);
		health += healFor;
		System.out.println("Healed for " + healFor);
		pane.setHealOutput(healFor);
	}

	public void setVictory() {
		victory = true;
	}

	public boolean getVictory() {
		return victory;
	}
}
