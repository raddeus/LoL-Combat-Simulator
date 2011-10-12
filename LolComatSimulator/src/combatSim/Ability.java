package combatSim;

public class Ability implements Runnable {

	private long cooldown;
	private Champion champ;
	private Champion otherChamp;
	private boolean ready = false;
	private boolean paused = false;
	private long pauseDuration;

	private boolean stuns = false;
	private boolean blinds = false;
	private boolean snares = false;
	private boolean suppresses = false;
	private boolean silences = false;
	private boolean knockups = false;
	private boolean fears = false;

	private long stunDuration;
	private long blindDuration;
	private long snareDuration;
	private long suppressDuration;
	private long silenceDuration;
	private long knockupDuration;
	private long fearDuration;
	
	private int attackPowerScaling;
	private int attackDamageScaling;
	
	public Ability() {
		
	}

	public void pause(long duration) {
		paused = true;
		pauseDuration = duration;
	}

	@Override
	public void run() {
		while (true) {
			if (ready && !paused) {
				if (stuns) {
					otherChamp.stun(applyCooldownReduction(stunDuration));
				}
				if (blinds) {
					otherChamp.blind(applyCooldownReduction(blindDuration));
				}
				if (suppresses) {
					otherChamp.suppress(applyCooldownReduction(suppressDuration));
				}
				if (silences) {
					otherChamp.silence(applyCooldownReduction(silenceDuration));
				}
				if (snares) {
					otherChamp.snare(applyCooldownReduction(snareDuration));
				}
				if (knockups) {
					otherChamp.knockup(applyCooldownReduction(knockupDuration));
				}
				if (fears) {
					otherChamp.fear(applyCooldownReduction(fearDuration));
				}
				//otherChamp.takeMagicDamage()
				this.setNotReady();
			} else{
				if (pauseDuration > cooldown) {
					try {
						Thread.sleep(pauseDuration);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						this.setReady();
						paused = false;
					}

				}else{
					try {
						Thread.sleep(cooldown);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						this.setReady();
						paused = false;
					}
				}
			}
		}

	}

	public long applyCooldownReduction(long a){
		return ((100-(long)champ.getCooldownReduction())/100)*a;	
	}
	
	public boolean isReady() {
		return ready;
	}

	public void setReady() {
		ready = true;
	}

	public void setNotReady() {
		ready = false;
	}
	
	public void setCooldown(long cd){
		cooldown = cd;
	}
	
	public void setStuns(long duration){
		if (duration != 0){
		stuns = true;
		stunDuration = duration;
		}
		else
			stuns = false;
	}
	
	public void setBlinds(long duration){
		if (duration != 0){
		blinds = true;
		blindDuration = duration;
		}
		else
			blinds = false;
	}
	
	public void setSnares(long duration){
		if (duration != 0){
		snares = true;
		snareDuration = duration;
		}
		else
			snares = false;
	}
	
	public void setSuppresses(long duration){
		if (duration != 0){
		suppresses = true;
		stunDuration = duration;
		}
		else
			suppresses = false;
	}
	
	public void setSilences(long duration){
		if (duration != 0){
		silences = true;
		silenceDuration = duration;
		}
		else
			silences = false;
	}
	
	public void setKnockups(long duration){
		if (duration != 0){
		knockups = true;
		knockupDuration = duration;
		}
		else
			knockups = false;
	}
	
	public void setThisChampion(Champion champion){
		this.champ = champion;
	}
	
	public void setOtherChampion(Champion champion){
		this.otherChamp = champion;
	}

	public void setAttackDamageScaling(int ADscaling) {
		attackDamageScaling = ADscaling;
	}

	public void setAttackPowerScaling(int APscaling) {
		attackPowerScaling = APscaling;
		
	}

	public void setFears(long duration) {
		if (duration != 0){
		fears = true;
		fearDuration = duration;
		}
		else
			fears = false;	
	}
	
}
