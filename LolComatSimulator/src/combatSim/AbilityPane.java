package combatSim;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class AbilityPane extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtStunDuration;
	private JTextField textField;
	private JTextField txtCooldown;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;

	/**
	 * Create the panel.
	 */
	public AbilityPane() {
		setLayout(new MigLayout("", "[80.00][grow][grow][grow][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		JRadioButton rdbtnMagic = new JRadioButton("Magic");
		buttonGroup.add(rdbtnMagic);
		add(rdbtnMagic, "cell 0 0");
		
		JRadioButton rdbtnPhysical = new JRadioButton("Physical");
		buttonGroup.add(rdbtnPhysical);
		add(rdbtnPhysical, "cell 1 0");
		
		JRadioButton rdbtnTrue = new JRadioButton("True");
		buttonGroup.add(rdbtnTrue);
		add(rdbtnTrue, "cell 2 0");
		
		JLabel lblBaseDamage = new JLabel("Base Damage");
		add(lblBaseDamage, "cell 0 1,alignx trailing");
		
		textField_3 = new JTextField();
		add(textField_3, "cell 1 1,growx");
		textField_3.setColumns(10);
		
		JLabel lblCost = new JLabel("Cost");
		add(lblCost, "cell 2 1 2 1,alignx center");
		
		JLabel lblApScaling = new JLabel("AP Scaling %");
		add(lblApScaling, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblMana = new JLabel("Mana");
		add(lblMana, "cell 2 2,alignx trailing");
		
		textField_20 = new JTextField();
		add(textField_20, "cell 3 2,growx");
		textField_20.setColumns(10);
		
		JLabel lblAdScaling = new JLabel("AD Scaling %");
		add(lblAdScaling, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblHealth = new JLabel("Health");
		add(lblHealth, "cell 2 3,alignx trailing");
		
		textField_21 = new JTextField();
		add(textField_21, "cell 3 3,growx");
		textField_21.setColumns(10);
		
		JLabel lblMrScaling = new JLabel("MR Scaling %");
		add(lblMrScaling, "cell 0 4,alignx trailing");
		
		textField_15 = new JTextField();
		add(textField_15, "cell 1 4,growx");
		textField_15.setColumns(10);
		
		JLabel lblEnergy = new JLabel("Energy");
		add(lblEnergy, "cell 2 4,alignx trailing");
		
		textField_22 = new JTextField();
		add(textField_22, "cell 3 4,growx");
		textField_22.setColumns(10);
		
		JLabel lblArmorScaling = new JLabel("Armor Scaling %");
		add(lblArmorScaling, "cell 0 5,alignx trailing");
		
		textField_16 = new JTextField();
		add(textField_16, "cell 1 5,growx");
		textField_16.setColumns(10);
		
		JLabel lblHealthScaling = new JLabel("Health Scaling %");
		add(lblHealthScaling, "cell 0 6,alignx trailing");
		
		textField_18 = new JTextField();
		add(textField_18, "cell 1 6,growx");
		textField_18.setColumns(10);
		
		JLabel lblAnimationTimems = new JLabel("Animation Time(ms)");
		add(lblAnimationTimems, "cell 2 6,alignx trailing");
		
		textField_23 = new JTextField();
		add(textField_23, "cell 3 6,growx");
		textField_23.setColumns(10);
		
		JLabel lblManaScaling = new JLabel("Mana Scaling %");
		add(lblManaScaling, "cell 0 7,alignx trailing");
		
		textField_19 = new JTextField();
		add(textField_19, "cell 1 7,growx");
		textField_19.setColumns(10);
		
		JLabel lblCooldownms = new JLabel("Cooldown(ms)");
		add(lblCooldownms, "cell 0 8,alignx right");
		
		txtCooldown = new JTextField();
		add(txtCooldown, "cell 1 8,growx");
		txtCooldown.setColumns(10);
		
		JLabel lblRange = new JLabel("Range");
		add(lblRange, "cell 0 9,alignx right");
		
		textField_9 = new JTextField();
		add(textField_9, "cell 1 9,growx");
		textField_9.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration");
		add(lblDuration, "cell 1 10,alignx center");
		
		JCheckBox chckbxAppliesStun = new JCheckBox("Stun");
		add(chckbxAppliesStun, "cell 0 11");
		
		txtStunDuration = new JTextField();
		add(txtStunDuration, "cell 1 11,growx");
		txtStunDuration.setColumns(10);
		
		JCheckBox chckbxResetAutoattack = new JCheckBox("Reset AutoAttack?");
		add(chckbxResetAutoattack, "cell 2 11");
		
		JCheckBox chckbxSnare = new JCheckBox("Snare");
		add(chckbxSnare, "cell 0 12");
		
		textField = new JTextField();
		add(textField, "cell 1 12,growx");
		textField.setColumns(10);
		
		JCheckBox chckbxDmgOnNext = new JCheckBox("Dmg on Next Auto");
		add(chckbxDmgOnNext, "cell 2 12");
		
		JCheckBox chckbxSilence = new JCheckBox("Silence");
		add(chckbxSilence, "cell 0 13");
		
		textField_4 = new JTextField();
		add(textField_4, "cell 1 13,growx");
		textField_4.setColumns(10);
		
		JCheckBox chckbxSuppress = new JCheckBox("Suppress");
		add(chckbxSuppress, "cell 0 14");
		
		textField_5 = new JTextField();
		add(textField_5, "cell 1 14,growx");
		textField_5.setColumns(10);
		
		JCheckBox chckbxBlind = new JCheckBox("Blind");
		add(chckbxBlind, "cell 0 15");
		
		textField_6 = new JTextField();
		add(textField_6, "cell 1 15,growx");
		textField_6.setColumns(10);
		
		JLabel lblDistance = new JLabel("Distance");
		add(lblDistance, "cell 2 15,alignx center");
		
		JCheckBox chckbxKnockback = new JCheckBox("KnockBack");
		add(chckbxKnockback, "cell 0 16");
		
		textField_7 = new JTextField();
		add(textField_7, "cell 1 16,growx");
		textField_7.setColumns(10);
		
		textField_17 = new JTextField();
		add(textField_17, "cell 2 16,growx");
		textField_17.setColumns(10);
		
		JCheckBox chckbxKnockup = new JCheckBox("KnockUp");
		add(chckbxKnockup, "cell 0 17");
		
		JLabel lblDuration_1 = new JLabel("Duration");
		add(lblDuration_1, "cell 1 18");
		
		JCheckBox chckbxSlow = new JCheckBox("Slow");
		add(chckbxSlow, "cell 0 19");
		
		textField_8 = new JTextField();
		add(textField_8, "cell 1 19,growx");
		textField_8.setColumns(10);
		
		textField_10 = new JTextField();
		add(textField_10, "cell 2 19,growx");
		textField_10.setColumns(10);
		
		JCheckBox checkBox_2 = new JCheckBox("%");
		add(checkBox_2, "cell 3 19");
		
		JCheckBox chckbxReduceArmor = new JCheckBox("Reduce Armor");
		add(chckbxReduceArmor, "cell 0 20");
		
		textField_11 = new JTextField();
		add(textField_11, "cell 1 20,growx");
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		add(textField_12, "cell 2 20,growx");
		textField_12.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("%");
		add(checkBox, "cell 3 20");
		
		JCheckBox chckbxReduceMr = new JCheckBox("Reduce MR");
		add(chckbxReduceMr, "cell 0 21");
		
		textField_13 = new JTextField();
		add(textField_13, "cell 1 21,growx");
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		add(textField_14, "cell 2 21,growx");
		textField_14.setColumns(10);
		
		JCheckBox checkBox_1 = new JCheckBox("%");
		add(checkBox_1, "cell 3 21");

	}

}
