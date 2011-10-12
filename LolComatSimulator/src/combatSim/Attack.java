package combatSim;

public class Attack implements Runnable {
	private Champion champion;
	private Champion otherChampion;
	private boolean stop = false;
	private long convertedAttackSpeed;
	private boolean paused = false;
	Thread pauseThread = new Thread();
	private long pauseDuration;
	
	public Attack(Champion Champion, Champion OtherChampion) {
		this.champion = Champion;
		this.otherChampion = OtherChampion;
	}

		
	public void pause(long duration){
		paused = true;
		pauseDuration = duration;
		
	}
	@Override
	public void run() {
		convertedAttackSpeed = (long) champion.convertAtkSpd(champion.getAttackSpeed());

		while(true){
		if(paused){
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			paused = false;
			pauseDuration = 0; //necessary?
		
			
		}
		
		stop = false;
		while (!stop && !paused && champion.getHealth() > 0) {
		
			otherChampion.takeAttackDamage(champion.getRawAttackDamageOut());
			champion.healLifeSteal(otherChampion.getLastDamageTaken());
			//wait between autos
			
			try {
				System.out.println("Time until next auto: "
						+ convertedAttackSpeed);
				Thread.sleep(convertedAttackSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		}
	

	}


}
