package combatSim;

public class Fight implements Runnable {

	private Champion LeftChamp;
	private Champion RightChamp;
	private ChampionInputPane leftPane;
	private ChampionInputPane rightPane;
	private Ability leftAbility;
	private Ability rightAbility;

	public Fight(ChampionInputPane LeftPane, ChampionInputPane RightPane,
			Ability LeftAbility, Ability RightAbility) {
		this.leftPane = LeftPane;
		this.rightPane = RightPane;
		this.leftAbility = LeftAbility;
		this.rightAbility = RightAbility;
	}

	Thread LeftChampThread;
	Thread RightChampThread;

	public void initFight() {
		LeftChamp = leftPane.getChampion("leftChamp");
		RightChamp = rightPane.getChampion("rightChamp");
		LeftChamp.setOtherChamp(RightChamp);
		RightChamp.setOtherChamp(LeftChamp);
		LeftChamp.setAbility(leftAbility);
		RightChamp.setAbility(rightAbility);
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
		while ((LeftChamp.getCurrentHealth() > 0)
				&& (RightChamp.getCurrentHealth() > 0)) {
			leftPane.setPbarHp((int) LeftChamp.getCurrentHealth());
			rightPane.setPbarHp((int) RightChamp.getCurrentHealth());
		}

		if (LeftChamp.getCurrentHealth() <= 0) {
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
