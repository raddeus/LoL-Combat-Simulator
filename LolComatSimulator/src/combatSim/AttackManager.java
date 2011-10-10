package combatSim;

public class AttackManager extends Champion implements Runnable {
	private Champion champion;
	private Champion otherChampion;
	private boolean stop = false;
	private long convertedAttackSpeed;
	private boolean paused = false;
	Thread pauseThread = new Thread();
	private long pauseDuration;
	
	public AttackManager(Champion Champion, Champion OtherChampion) {
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
		//
		//Copy pasted in here. This is the attack thread. It covers ad based attacks.
		//And will have all of the commands to do manipulate it. Also need an ability thread.
		//
		while(true){
		if(paused){
			try {
				System.out.println("SLEEPING CUZ IM PAUSED "
						+ pauseDuration);
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			paused = false;
			pauseDuration = 0; //necessary?
		
			
		}
		
		stop = false;
		while (!stop && !paused && champion.getHealth() > 0) {
		
			otherChampion.takeDamage(champion.getRawDamageOut());
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
	
		//
		//
		//
		
//		while (champion.isReadyToAttack()) {
//			System.out.println("I'm ATTACKING HURRRR!");
//			otherChampion.takeDamage(champion.getRawDamageOut());
//
//			champion.healLifeSteal(otherChampion.getLastDamageTaken());
//			champion.setNotReady();
//			// TODO Auto-generated method stub
//
//		}

	}


}
