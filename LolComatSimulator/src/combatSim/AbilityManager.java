package combatSim;

public class AbilityManager extends Champion implements Runnable {

	private long cooldown;
	private Champion champ;
	private Champion otherChamp;
	private long stunDuration;
	private boolean ready = false;
	private boolean paused = false;
	private long pauseDuration;

	public AbilityManager(Champion ThisChampion, Champion OtherChampion,
			long Cooldown, long StunDuration) {
		cooldown = Cooldown;
		champ = ThisChampion;
		otherChamp = OtherChampion;
		stunDuration = StunDuration;
	}

	public void pause(long duration) {
		paused = true;
		pauseDuration = duration;
	}

	@Override
	public void run() {

		while (true) {

			if (ready && !paused) {

				if (champ.hasStun()) {
					otherChamp.stun(stunDuration);
				}

				this.setNotReady();

			} else{

				// what to do when this ability is ready.
				if (pauseDuration > cooldown) {
					try {
						Thread.sleep(pauseDuration);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						this.setReady();
						paused = false;
					}

				}else{
					try {
						Thread.sleep(cooldown);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						this.setReady();
						paused = false;
					}
				}
			}
		}

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

}
