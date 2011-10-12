package combatSim;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class AbilityPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtStunDuration;
	private JTextField txtSnareDuration;
	private JTextField txtCooldown;
	private JTextField txtADScaling;
	private JTextField txtAPScaling;
	private JTextField txtBaseDamage;
	private JTextField txtSilenceDuration;
	private JTextField txtSuppressDuration;
	private JTextField txtBlindDuration;
	private JTextField txtKnockBack;
	private JTextField textField_8;
	private JTextField txtRange;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField txtMRScaling;
	private JTextField txtArmorScaling;
	private JTextField txtKnockBackDistance;
	private JTextField txtHealthScaling;
	private JTextField txtManaScaling;
	private JTextField txtManaCost;
	private JTextField txtHealthCost;
	private JTextField txtEnergyCost;
	private JTextField txtAnimationTime;
	private JTextField txtRank;
	private JTextField txtFearDuration;

	/**
	 * Create the panel.
	 */
	public AbilityPane() {
		setLayout(new MigLayout("", "[80.00][55.00,grow][][59.00]", "[][][][][][][][][][][][][][][][][][][][][][][]"));
		JRadioButton rdbtnMagic = new JRadioButton("Magic");
		rdbtnMagic.setEnabled(false);
		JRadioButton rdbtnPhysical = new JRadioButton("Physical");
		rdbtnPhysical.setEnabled(false);
		JRadioButton rdbtnTrue = new JRadioButton("True");
		rdbtnTrue.setEnabled(false);

		txtBaseDamage = new JTextField();
		txtBaseDamage.setEnabled(false);
		JLabel lblCost = new JLabel("Cost");
		lblCost.setEnabled(false);

		JLabel lblMana = new JLabel("Mana");
		lblMana.setEnabled(false);

		JLabel lblApScaling = new JLabel("AP Scaling %");
		lblApScaling.setEnabled(false);

		JLabel lblBaseDamage = new JLabel("Base Damage");
		lblBaseDamage.setEnabled(false);
		buttonGroup.add(rdbtnMagic);
		add(rdbtnMagic, "cell 0 0");

		buttonGroup.add(rdbtnPhysical);
		add(rdbtnPhysical, "cell 1 0");

		buttonGroup.add(rdbtnTrue);
		add(rdbtnTrue, "cell 2 0");

		add(lblBaseDamage, "cell 0 1,alignx trailing");

		txtBaseDamage.setText("0");
		add(txtBaseDamage, "cell 1 1,growx");
		txtBaseDamage.setColumns(10);

		add(lblCost, "cell 2 1,alignx center");

		add(lblApScaling, "cell 0 2,alignx trailing");

		txtAPScaling = new JTextField();
		txtAPScaling.setEnabled(false);
		txtAPScaling.setText("0");
		add(txtAPScaling, "cell 1 2,growx");
		txtAPScaling.setColumns(10);

		add(lblMana, "cell 2 2,alignx trailing");

		txtManaCost = new JTextField();
		txtManaCost.setEnabled(false);
		txtManaCost.setText("0");
		add(txtManaCost, "cell 3 2,growx");
		txtManaCost.setColumns(10);

		JLabel lblAdScaling = new JLabel("AD Scaling %");
		lblAdScaling.setEnabled(false);
		add(lblAdScaling, "cell 0 3,alignx trailing");

		txtADScaling = new JTextField();
		txtADScaling.setEnabled(false);
		txtADScaling.setText("0");
		add(txtADScaling, "cell 1 3,growx");
		txtADScaling.setColumns(10);

		JLabel lblHealth = new JLabel("Health");
		lblHealth.setEnabled(false);
		add(lblHealth, "cell 2 3,alignx trailing");

		txtHealthCost = new JTextField();
		txtHealthCost.setEnabled(false);
		txtHealthCost.setText("0");
		add(txtHealthCost, "cell 3 3,growx");
		txtHealthCost.setColumns(10);

		JLabel lblMrScaling = new JLabel("MR Scaling %");
		lblMrScaling.setEnabled(false);
		add(lblMrScaling, "cell 0 4,alignx trailing");

		txtMRScaling = new JTextField();
		txtMRScaling.setEnabled(false);
		txtMRScaling.setText("0");
		add(txtMRScaling, "cell 1 4,growx");
		txtMRScaling.setColumns(10);

		JCheckBox checkBox_3 = new JCheckBox("%");
		checkBox_3.setEnabled(false);
		add(checkBox_3, "cell 2 4,alignx right");

		JLabel lblArmorScaling = new JLabel("Armor Scaling %");
		lblArmorScaling.setEnabled(false);
		add(lblArmorScaling, "cell 0 5,alignx trailing");

		txtArmorScaling = new JTextField();
		txtArmorScaling.setEnabled(false);
		txtArmorScaling.setText("0");
		add(txtArmorScaling, "cell 1 5,growx");
		txtArmorScaling.setColumns(10);

		JLabel lblEnergy = new JLabel("Energy");
		lblEnergy.setEnabled(false);
		add(lblEnergy, "cell 2 5,alignx trailing");

		txtEnergyCost = new JTextField();
		txtEnergyCost.setEnabled(false);
		txtEnergyCost.setText("0");
		add(txtEnergyCost, "cell 3 5,growx");
		txtEnergyCost.setColumns(10);

		JLabel lblHealthScaling = new JLabel("Health Scaling %");
		lblHealthScaling.setEnabled(false);
		add(lblHealthScaling, "cell 0 6,alignx trailing");

		txtHealthScaling = new JTextField();
		txtHealthScaling.setEnabled(false);
		txtHealthScaling.setText("0");
		add(txtHealthScaling, "cell 1 6,growx");
		txtHealthScaling.setColumns(10);

		JLabel lblAnimationTimems = new JLabel("Animation Time(ms)");
		lblAnimationTimems.setEnabled(false);
		add(lblAnimationTimems, "cell 2 6,alignx trailing");

		txtAnimationTime = new JTextField();
		txtAnimationTime.setEnabled(false);
		txtAnimationTime.setText("0");
		add(txtAnimationTime, "cell 3 6,growx");
		txtAnimationTime.setColumns(10);

		JLabel lblManaScaling = new JLabel("Mana Scaling %");
		lblManaScaling.setEnabled(false);
		add(lblManaScaling, "cell 0 7,alignx trailing");

		txtManaScaling = new JTextField();
		txtManaScaling.setEnabled(false);
		txtManaScaling.setText("0");
		add(txtManaScaling, "cell 1 7,growx");
		txtManaScaling.setColumns(10);

		JLabel lblCooldownms = new JLabel("Cooldown(ms)");
		add(lblCooldownms, "cell 0 8,alignx right");

		txtCooldown = new JTextField();
		txtCooldown.setText("0");
		add(txtCooldown, "cell 1 8,growx");
		txtCooldown.setColumns(10);

		JLabel lblRank = new JLabel("Rank:");
		lblRank.setEnabled(false);
		add(lblRank, "cell 2 8,alignx trailing");

		txtRank = new JTextField();
		txtRank.setEnabled(false);
		txtRank.setText("0");
		add(txtRank, "cell 3 8,growx");
		txtRank.setColumns(10);

		JLabel lblRange = new JLabel("Range");
		add(lblRange, "cell 0 9,alignx right");

		txtRange = new JTextField();
		txtRange.setEnabled(false);
		txtRange.setText("0");
		add(txtRange, "cell 1 9,growx");
		txtRange.setColumns(10);

		JLabel lblDuration = new JLabel("Duration(ms)");
		add(lblDuration, "cell 1 10,alignx center");

		JLabel chckbxAppliesStun = new JLabel("Stun");
		add(chckbxAppliesStun, "cell 0 11");

		txtStunDuration = new JTextField();
		txtStunDuration.setText("0");
		add(txtStunDuration, "cell 1 11,growx");
		txtStunDuration.setColumns(10);

		JCheckBox chckbxResetAutoattack = new JCheckBox("Reset AutoAttack?");
		chckbxResetAutoattack.setEnabled(false);
		add(chckbxResetAutoattack, "cell 2 11");

		JLabel chckbxSnare = new JLabel("Snare");
		add(chckbxSnare, "cell 0 12");

		txtSnareDuration = new JTextField();
		txtSnareDuration.setText("0");
		add(txtSnareDuration, "cell 1 12,growx");
		txtSnareDuration.setColumns(10);

		JCheckBox chckbxDmgOnNext = new JCheckBox("Dmg on Next Auto");
		chckbxDmgOnNext.setEnabled(false);
		add(chckbxDmgOnNext, "cell 2 12");

		JLabel chckbxSilence = new JLabel("Silence");
		add(chckbxSilence, "cell 0 13");

		txtSilenceDuration = new JTextField();
		txtSilenceDuration.setText("0");
		add(txtSilenceDuration, "cell 1 13,growx");
		txtSilenceDuration.setColumns(10);

		JLabel chckbxSuppress = new JLabel("Suppress");
		add(chckbxSuppress, "cell 0 14");

		txtSuppressDuration = new JTextField();
		txtSuppressDuration.setText("0");
		add(txtSuppressDuration, "cell 1 14,growx");
		txtSuppressDuration.setColumns(10);

		JLabel chckbxBlind = new JLabel("Blind");
		add(chckbxBlind, "cell 0 15");

		txtBlindDuration = new JTextField();
		txtBlindDuration.setText("0");
		add(txtBlindDuration, "cell 1 15,growx");
		txtBlindDuration.setColumns(10);

		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setEnabled(false);
		add(lblDistance, "cell 2 15,alignx center");
		
		JLabel lblFear = new JLabel("Fear");
		add(lblFear, "cell 0 16,alignx trailing");
		
		txtFearDuration = new JTextField();
		txtFearDuration.setText("0");
		txtFearDuration.setColumns(10);
		add(txtFearDuration, "cell 1 16,growx");

		JLabel chckbxKnockback = new JLabel("KnockBack");
		add(chckbxKnockback, "cell 0 17");

		txtKnockBack = new JTextField();
		txtKnockBack.setEnabled(false);
		txtKnockBack.setText("0");
		add(txtKnockBack, "cell 1 17,growx");
		txtKnockBack.setColumns(10);

		txtKnockBackDistance = new JTextField();
		txtKnockBackDistance.setEnabled(false);
		txtKnockBackDistance.setText("0");
		add(txtKnockBackDistance, "cell 2 17,growx");
		txtKnockBackDistance.setColumns(10);

		JCheckBox chckbxKnockup = new JCheckBox("KnockUp");
		chckbxKnockup.setEnabled(false);
		add(chckbxKnockup, "cell 0 18");

		JLabel lblDuration_1 = new JLabel("Duration");
		lblDuration_1.setEnabled(false);
		add(lblDuration_1, "cell 1 19");

		JCheckBox chckbxSlow = new JCheckBox("Slow");
		chckbxSlow.setEnabled(false);
		add(chckbxSlow, "cell 0 20");

		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setText("0");
		add(textField_8, "cell 1 20,growx");
		textField_8.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setText("0");
		add(textField_10, "cell 2 20,growx");
		textField_10.setColumns(10);

		JCheckBox checkBox_2 = new JCheckBox("%");
		checkBox_2.setEnabled(false);
		add(checkBox_2, "cell 3 20");

		JCheckBox chckbxReduceArmor = new JCheckBox("Reduce Armor");
		chckbxReduceArmor.setEnabled(false);
		add(chckbxReduceArmor, "cell 0 21");

		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setText("0");
		add(textField_11, "cell 1 21,growx");
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setEnabled(false);
		textField_12.setText("0");
		add(textField_12, "cell 2 21,growx");
		textField_12.setColumns(10);

		JCheckBox checkBox = new JCheckBox("%");
		checkBox.setEnabled(false);
		add(checkBox, "cell 3 21");

		JCheckBox chckbxReduceMr = new JCheckBox("Reduce MR");
		chckbxReduceMr.setEnabled(false);
		add(chckbxReduceMr, "cell 0 22");

		textField_13 = new JTextField();
		textField_13.setEnabled(false);
		textField_13.setText("0");
		add(textField_13, "cell 1 22,growx");
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setEnabled(false);
		textField_14.setText("0");
		add(textField_14, "cell 2 22,growx");
		textField_14.setColumns(10);

		JCheckBox checkBox_1 = new JCheckBox("%");
		checkBox_1.setEnabled(false);
		add(checkBox_1, "cell 3 22");

	}

	public Ability getAbility(){
		Ability abilityOut = new Ability();
		abilityOut.setStuns(Long.parseLong(txtStunDuration.getText()));
		abilityOut.setSnares(Long.parseLong(txtSnareDuration.getText()));
		abilityOut.setCooldown(Long.parseLong(txtCooldown.getText()));
		abilityOut.setAttackDamageScaling(Integer.parseInt(txtADScaling.getText()));
		abilityOut.setAttackPowerScaling(Integer.parseInt(txtAPScaling.getText()));
		abilityOut.setSilences(Long.parseLong(txtSilenceDuration.getText()));
		abilityOut.setSuppresses(Long.parseLong(txtSuppressDuration.getText()));
		abilityOut.setBlinds(Long.parseLong(txtBlindDuration.getText()));
		abilityOut.setFears(Long.parseLong(txtFearDuration.getText()));
		return abilityOut;
	}
}
