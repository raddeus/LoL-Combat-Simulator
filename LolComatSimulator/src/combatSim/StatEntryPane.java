package combatSim;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;

public class StatEntryPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtAttackDamage;
	private JTextField txtAttackSpeed;
	private JTextField txtCriticalStrike;
	private JTextField txtLifeSteal;
	private JTextField txtHealth;
	private JTextField txtArmor;

	private double health;
	private int attackDamage;
	private double attackSpeed;
	private double lifeSteal;
	private double armor;
	private double criticalStrike;
	private int maxHealth;
	private double dodge;
	private double critdamage;
	
	JLabel lblAttackDamage = new JLabel("Attack Damage");
	JLabel lblAttackSpeed = new JLabel("Attack Speed");
	JLabel lblCritStrike = new JLabel("Critical Strike%");
	JLabel lblLifeSteal = new JLabel("LifeSteal%");
	JLabel lblHealth = new JLabel("Health");
	JLabel lblArmor = new JLabel("Armor");

	private JProgressBar pbCurrentHealth = new JProgressBar();
	private JLabel lblCurrentHealth = new JLabel("Health");
	private final JLabel lblLiveOutput = new JLabel("LiveOutput");
	private final JLabel lblDodge = new JLabel("Dodge%");
	private final JTextField txtDodge = new JTextField();
	private final JLabel lblCritDamage = new JLabel("CritDamage%");
	private final JTextField txtCritDamage = new JTextField();
	private final JLabel lblHeal = new JLabel(" ");

	public StatEntryPane() {
		setLayout(new MigLayout("", "[grow][55.00,grow]", "[][][][][][][][][][][][][]"));
		add(lblAttackDamage, "cell 0 0,alignx trailing");
		txtAttackDamage = new JTextField();
		add(txtAttackDamage, "cell 1 0,growx");
		txtAttackDamage.setColumns(10);
		add(lblAttackSpeed, "cell 0 1,alignx trailing");
		txtAttackSpeed = new JTextField();
		txtAttackSpeed.setColumns(10);
		add(txtAttackSpeed, "cell 1 1,growx");
		add(lblCritStrike, "cell 0 2,alignx trailing");
		txtCriticalStrike = new JTextField();
		txtCriticalStrike.setColumns(10);
		add(txtCriticalStrike, "cell 1 2,growx");
		add(lblLifeSteal, "cell 0 3,alignx trailing");
		txtLifeSteal = new JTextField();
		txtLifeSteal.setColumns(10);
		add(txtLifeSteal, "cell 1 3,growx");
		add(lblHealth, "cell 0 4,alignx trailing");
		txtHealth = new JTextField();
		txtHealth.setColumns(10);
		add(txtHealth, "cell 1 4,growx");
		add(lblArmor, "cell 0 5,alignx trailing");
		txtArmor = new JTextField();
		txtArmor.setColumns(10);
		add(txtArmor, "cell 1 5,growx");
		add(lblDodge, "cell 0 6,alignx trailing");
		txtDodge.setText("0");
		txtDodge.setColumns(10);
		add(txtDodge, "cell 1 6,growx");
		add(lblCritDamage, "cell 0 7,alignx trailing");
		txtCritDamage.setText("100");
		txtCritDamage.setColumns(10);
		add(txtCritDamage, "cell 1 7,growx");
		add(lblLiveOutput, "cell 0 9 2 1,alignx center");
		add(lblCurrentHealth, "cell 0 10 2 1,alignx center");
		pbCurrentHealth.setToolTipText("Current HP");
		add(pbCurrentHealth, "cell 0 11 2 1,alignx center");
		lblHeal.setForeground(Color.GREEN);
		add(lblHeal, "cell 0 12 2 1,alignx center");
	}
	
	public void initPbar(int health){
		pbCurrentHealth.setMaximum(health);
		pbCurrentHealth.setValue(health);
		pbCurrentHealth.repaint();
		lblCurrentHealth.setText(" "+health+"/"+health);
		maxHealth = health;
	}
	
	public void setPbarHp(int health){
		pbCurrentHealth.setValue(health);
		pbCurrentHealth.repaint();
		lblCurrentHealth.setText(" "+health+"/"+maxHealth);
	}
	
	public Champion getChampion(String ChampName){
	armor = Double.parseDouble(txtArmor.getText());
	attackDamage = Integer.parseInt(txtAttackDamage.getText());
	attackSpeed = Double.parseDouble(txtAttackSpeed.getText());
	criticalStrike = Double.parseDouble(txtCriticalStrike.getText());
	lifeSteal = Double.parseDouble(txtLifeSteal.getText());
	health = Integer.parseInt(txtHealth.getText());
	critdamage = Double.parseDouble(txtCritDamage.getText());
	dodge = Double.parseDouble(txtDodge.getText());
	Champion out = new Champion(ChampName, this, health, attackDamage, lifeSteal, attackSpeed, armor, criticalStrike, critdamage, dodge);
	System.out.println("creating new champion with health:"+health);
	return out;
	}

	public void setLiveOutput(String string) {
		lblLiveOutput.setText(string);
	}
	
	public void setHealOutput(double heal){
		lblHeal.setText("+"+Integer.toString((int)heal));
	}
}
