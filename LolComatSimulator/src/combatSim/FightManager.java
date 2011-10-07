package combatSim;

public class FightManager implements Runnable {

	Champion LeftChamp;
	Champion RightChamp;
	private StatEntryPane leftPane;
	private StatEntryPane rightPane;

	public FightManager(StatEntryPane LeftPane, StatEntryPane RightPane) {
		this.leftPane = LeftPane;
		this.rightPane = RightPane;
	}

	Thread LeftChampThread;
	Thread RightChampThread;

	public void initFight() {

		System.out.println("Starting Threads");
		LeftChampThread = new Thread(LeftChamp);
		RightChampThread = new Thread(RightChamp);
		LeftChampThread.start();
		RightChampThread.start();

	}

	@Override
	public void run() {
		System.out.println("Fight Manager thread starting. Leftchamphealth:"
				+ LeftChamp.getHealth() + "Right Health:"
				+ RightChamp.getHealth());
		System.out.println("initiating both progress bars...");
		leftPane.initPbar((int) LeftChamp.getHealth());
		rightPane.initPbar((int) RightChamp.getHealth());
		while ((LeftChamp.getHealth() > 0) && (RightChamp.getHealth() > 0)) {

			if (RightChamp.isReadyToAttack()) {
				System.out.println("Right attacks left");
				LeftChamp.takeDamage(RightChamp.getRawDamageOut());
				leftPane.setPbarHp((int) LeftChamp.getHealth());
				RightChamp.healLifeSteal(LeftChamp.getLastDamageTaken());
				RightChamp.setNotReady();
			}
			if (LeftChamp.isReadyToAttack()) {
				System.out.println("Left attacks right");
				RightChamp.takeDamage(LeftChamp.getRawDamageOut());
				rightPane.setPbarHp((int) RightChamp.getHealth());
				LeftChamp.healLifeSteal(RightChamp.getLastDamageTaken());
				LeftChamp.setNotReady();
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if (LeftChamp.getHealth() <= 0) {
			RightChamp.setVictory();
			rightPane.setLiveOutput("VICTORY");
			leftPane.setLiveOutput("DEFEAT");
		} else {
			LeftChamp.setVictory();
			leftPane.setLiveOutput("VICTORY");
			rightPane.setLiveOutput("DEFEAT");
		}
		System.out.println("FINAL SCORE");
		System.out.println("Left Champ - " + LeftChamp.getHealth());
		System.out.println("Right Champ - " + RightChamp.getHealth());
		LeftChamp.requestStop();
		RightChamp.requestStop();

	}

	public void addRightChampion(Champion rightChamp2) {
		RightChamp = rightChamp2;
	}

	public void addLeftChampion(Champion leftChamp2) {
		LeftChamp = leftChamp2;
	}

}
