package combatSim;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainWindow extends JFrame {

	FightManager FightManager;
	StatEntryPane leftPane = new StatEntryPane(FightManager);
	StatEntryPane rightPane = new StatEntryPane(FightManager);
	Thread FightManagerThread;
	Champion leftChamp;
	Champion rightChamp;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblDisclaimerThisApp = new JLabel(
			"<html>Disclaimer: This app is in its very early stages of development.<br>" +
			"There will be bugs and accuracy errors for the time being.<br>If you would " +
			"like to point an error out to me<br>Please do so on the reddit post<br>or email" +
			" me at<br>thadblankenship@gmail.com </html>");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		setTitle("LoL AD Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[215.00][][215.00]", "[grow][][][grow][grow]"));
		contentPane.add(leftPane, "cell 0 0,grow");
		contentPane.add(rightPane, "cell 2 0,grow");
		JButton btnFight = new JButton("FIGHT");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FightManager = new FightManager(leftPane, rightPane);
				FightManagerThread = new Thread(FightManager);
				FightManager.initFight();
				FightManagerThread.start();
			}
		});
		contentPane.add(btnFight, "cell 1 2");
		contentPane.add(lblDisclaimerThisApp, "cell 0 4 3 1");
	}

}
