package combatSim;

import java.util.Random;

public class Champion implements Runnable {

	private double maxHealth;
	private double currentHealth;
	private int attackDamage;
	private double attackSpeed;
	private double lifeSteal;
	private double armor;
	private double criticalStrike;
	private double dodge;
	private double critDamagePercent;
	private boolean isReadyToAttack;
	private boolean stop = false;
	private double lastDamageTaken;
	private boolean victory = false;
	private long stunDuration;
	private String champName;
	private boolean hasStun;
	private long stunCooldown;
	private boolean readyToStun;
	private boolean isBlinded = false;
	private long currentBlindDuration = 0;

	// use these to give relevant infos.
	// private double totalDamageTaken;
	// private double totalDamageHealed;
	// private double totalDamageMitigatedArmor;
	// private double totalDamageDealt;
	private ChampionPane pane;

	private Champion otherChamp;
	private Attack attackManager;
	private Ability abilityManager;
	private Thread attackThread;
	private Thread abilityThread;

	public Champion() {
	}

	public Champion(String ChampName, ChampionPane Pane, double Health,
			int AttackDamage, double LifeSteal, double AttackSpeed,
			double Armor, double CritStrike, double CritDamagePercent,
			double Dodge, boolean HasStun, long StunDuration, long StunCooldown) {
		this.champName = ChampName;
		this.pane = Pane;
		this.maxHealth = Health;
		this.attackDamage = AttackDamage;
		this.attackSpeed = AttackSpeed;
		this.armor = Armor;
		this.criticalStrike = CritStrike;
		this.critDamagePercent = CritDamagePercent;
		this.lifeSteal = LifeSteal;
		this.victory = false;
		this.dodge = Dodge;
		this.hasStun = HasStun;
		this.stunDuration = StunDuration;
		this.stunCooldown = StunCooldown;

	}

	@Override
	public void run() {
		attackManager = new Attack(this, otherChamp);
		abilityManager = new Ability(this, otherChamp, stunCooldown,
				stunDuration);

		attackThread = new Thread(attackManager);
		abilityThread = new Thread(abilityManager);

		attackThread.start();
		abilityThread.start();

		stop = false;
		while (!stop && this.currentHealth > 0) {

		}
		// set health regulation here, cant go above max or below zero.

	}

	// methods
	public double convertAtkSpd(double d) {// converts attackspeed into time in
		return 1000 / d;
	} // milliseconds for the threads to wait.

	public double getRawDamageOut() {
		Random crit = new Random();
		double damageGiven;
		double didyoucrit = (double) crit.nextInt(100);

		if (didyoucrit < criticalStrike) {
			damageGiven = attackDamage * ((critDamagePercent + 100) / 100);
			pane.setLiveOutput("I CRIT");
			return damageGiven;

		} else {
			damageGiven = attackDamage;
			pane.setLiveOutput("ATTACK!");
			return damageGiven;
		}

	}

	public void setOtherChamp(Champion champion) {
		otherChamp = champion;
	}

	public void takeDamage(double RawDamageIn) {
		double damageTaken;
		Random dodgeRandom = new Random();
		double didyoudodge = (double) dodgeRandom.nextInt(100);
		if (didyoudodge < this.dodge) {
			// you dodged
			lastDamageTaken = 0;
			pane.setLiveOutput("I DODGED");
			// System.out.println("Dodged - 0 dmg taken.");
		} else {
			if (this.armor >= 0)// calculates damage after armor
			{// i hate you thad
				System.out.println("took in " + RawDamageIn + " damage");
				damageTaken = (RawDamageIn * (100 / (100 + this.armor)));
				currentHealth -= damageTaken;
				lastDamageTaken = damageTaken;
				pane.setLiveOutput(Integer.toString((int) damageTaken));
				// System.out.println("Took" + damageTaken +
				// " mitigated damage");
				// System.out.println("CURRENT HP:"+health);
			} else {
				damageTaken = RawDamageIn; // no armor, returning true damage
				currentHealth -= damageTaken;
				pane.setLiveOutput(Integer.toString((int) damageTaken));
				lastDamageTaken = damageTaken;
				// System.out.println("CURRENT HP:"+health);
			}
		}
	}

	// getters
	public double getHealth() {
		return this.maxHealth;
	}
	
	public double getCurrentHealth() {
		return this.currentHealth;
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
		maxHealth = a;
	}
	public void setCurrentHealth(int a) {
		currentHealth = a;
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

	public void setBlinded(long duration) {
		currentBlindDuration = duration;
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

	public boolean isBlinded() {
		return isBlinded;
	}

	public void cancelBlind() {
		this.isBlinded = false;
	}

	public void stun(long duration) {
		this.pane.setCCStatus("STUNNED");
		attackManager.pause(duration);
		abilityManager.pause(duration);

		// sleeps self
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pane.setCCStatus("-");
		}

	}

	public void blind(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.attackManager.pause(duration);

	}

	public void silence(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.abilityManager.pause(duration);

	}

	public void requestStop() {
		stop = true;

	}

	public void healLifeSteal(double mitigatedDamage) {
		double healFor;
		healFor = mitigatedDamage * (this.lifeSteal / 100.0D);
		currentHealth += healFor;
		pane.setHealOutput(healFor);
	}

	public void setVictory() {
		victory = true;
	}

	public boolean getVictory() {
		return victory;
	}

	public boolean isReadyToStun() {
		return readyToStun;
	}

	public boolean hasStun() {
		return hasStun;
	}

	public long getStunDuration() {
		return stunDuration;
	}

	public long getCurrentBlindDuration() {
		return currentBlindDuration;
	}
}
