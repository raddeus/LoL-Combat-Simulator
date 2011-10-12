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
	private int cooldownReduction;
	private int tenacity;
	private int abilityPower;
	private double critDamagePercent;
	private boolean isReadyToAttack;
	private boolean stop = false;
	private double lastDamageTaken;
	private boolean victory = false;
	private long stunDuration;
	private String champName;
	private long currentBlindDuration = 0;

	// use these to give relevant infos.
	// private double totalDamageTaken;
	// private double totalDamageHealed;
	// private double totalDamageMitigatedArmor;
	// private double totalDamageDealt;
	private ChampionInputPane pane;

	private Champion otherChamp;
	private Attack attack;
	private Ability ability;
	private Thread attackThread;
	private Thread abilityThread;

	public Champion() {
	}

	public Champion(String ChampName, ChampionInputPane Pane, double Health,
			int AttackDamage, double LifeSteal, double AttackSpeed,
			double Armor, double CritStrike, double CritDamagePercent,
			double Dodge, int Tenacity, int CooldownReduction, int AbilityPower) {
		this.champName = ChampName;
		this.pane = Pane;
		this.maxHealth = Health;
		this.currentHealth = Health;
		this.attackDamage = AttackDamage;
		this.attackSpeed = AttackSpeed;
		this.armor = Armor;
		this.criticalStrike = CritStrike;
		this.critDamagePercent = CritDamagePercent;
		this.lifeSteal = LifeSteal;
		this.victory = false;
		this.dodge = Dodge;
		this.tenacity = Tenacity;
		this.cooldownReduction = CooldownReduction;
		this.abilityPower = AbilityPower;

	}

	@Override
	public void run() {
		attack = new Attack(this, otherChamp);

		ability.setThisChampion(this);
		ability.setOtherChampion(otherChamp);

		attackThread = new Thread(attack);
		abilityThread = new Thread(ability);

		attackThread.start();
		abilityThread.start();

		stop = false;
		while (!stop && this.currentHealth > 0) {
			if (currentHealth > maxHealth)
				currentHealth = maxHealth;
		}
		// set health regulation here, cant go above max or below zero.

	}

	// methods
	public double convertAtkSpd(double d) {// converts attackspeed into time in
		return 1000 / d;
	} // milliseconds for the threads to wait.

	public double getRawAttackDamageOut() {
		Random crit = new Random();
		double damageGiven;
		double didyoucrit = (double) crit.nextInt(100);

		if (didyoucrit < criticalStrike) {
			damageGiven = attackDamage * ((critDamagePercent + 100) / 100);
			otherChamp.setLiveOutput("CRIT");
			return damageGiven;

		} else {
			damageGiven = attackDamage;
			otherChamp.setLiveOutput("Hit");
			return damageGiven;
		}

	}

	public void setOtherChamp(Champion champion) {
		otherChamp = champion;
	}

	public void takeAttackDamage(double rawDamage) {
		double damageTaken;
		Random dodgeRandom = new Random();
		double didyoudodge = (double) dodgeRandom.nextInt(100);
		if (didyoudodge < this.dodge) {
			// you dodged
			lastDamageTaken = 0;
			setLiveOutput("DODGE!");
			// System.out.println("Dodged - 0 dmg taken.");
		} else {
			if (this.armor >= 0)// calculates damage after armor
			{
				System.out.println("took in " + rawDamage + " damage");
				damageTaken = (rawDamage * (100 / (100 + this.armor)));
				currentHealth -= damageTaken;
				lastDamageTaken = damageTaken;
				setLiveOutput(Integer.toString((int) damageTaken));
			} else {
				damageTaken = rawDamage; // no armor, returning true damage
				currentHealth -= damageTaken;
				setLiveOutput(Integer.toString((int) damageTaken));
				lastDamageTaken = damageTaken;
			}
		}
	}

	private void setLiveOutput(String string) {
		pane.setLiveOutput(string);

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

	public int getTenacity() {
		return this.tenacity;
	}

	public int getCooldownReduction() {
		return this.cooldownReduction;
	}

	public int getAbilityPower() {
		return this.abilityPower;
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

	public void setTenacity(int a) {
		this.tenacity = a;
	}

	public void setCooldownReduction(int a) {
		this.cooldownReduction = a;
	}

	public void setAbilityPower(int a) {
		this.abilityPower = a;
	}

	public boolean isReadyToAttack() {
		return isReadyToAttack;
	}

	public void stun(long duration) {
		this.pane.setCCStatus("STUNNED");
		attack.pause(applyTenacity(duration));
		ability.pause(applyTenacity(duration));

		// sleeps self
		try {
			Thread.sleep(applyTenacity(duration));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pane.setCCStatus("-");
		}

	}

	public void blind(long duration) {
		this.pane.setCCStatus("BLINDED");
		attack.pause(applyTenacity(duration));

		// sleeps self
		try {
			Thread.sleep(applyTenacity(duration));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pane.setCCStatus("-");
		}

	}

	public void silence(long duration) {
		this.pane.setCCStatus("Silenced");
		ability.pause(applyTenacity(duration));
		try {
			Thread.sleep(applyTenacity(duration));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pane.setCCStatus("-");
		}

	}

	public void suppress(long duration) {
		this.pane.setCCStatus("SUPPRESSED");
		attack.pause(applyTenacity(duration));
		ability.pause(applyTenacity(duration));

		// sleeps self
		try {
			Thread.sleep(applyTenacity(duration));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pane.setCCStatus("-");
		}

	}

	public void snare(long duration) {
		this.pane.setCCStatus("SNARED");

		// movementManager.pause(applyTenacity(duration));
		// sleeps self
		try {
			Thread.sleep(applyTenacity(duration));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pane.setCCStatus("-");
		}

	}
	
	public void fear(long duration) {
		this.pane.setCCStatus("FEARED");
		attack.pause(applyTenacity(duration));
		ability.pause(applyTenacity(duration));
//movement class stuff
		// sleeps self
		try {
			Thread.sleep(applyTenacity(duration));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pane.setCCStatus("-");
		}

	}

	public void knockup(long duration) {
		this.pane.setCCStatus("KNOCKUP");
		attack.pause(applyTenacity(duration));
		ability.pause(applyTenacity(duration));

		// sleeps self
		try {
			Thread.sleep(applyTenacity(duration));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.pane.setCCStatus("-");
		}

	}

	private long applyTenacity(long ccduration) {
		return ((100-tenacity)/100)*ccduration;
	}

	public void requestStop() {
		stop = true;

	}

	public void stealLife(double mitigatedDamage) {
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

	public long getStunDuration() {
		return stunDuration;
	}

	public long getCurrentBlindDuration() {
		return currentBlindDuration;
	}

	public void setAbility(Ability Ability) {
		ability = Ability;
	}


}
