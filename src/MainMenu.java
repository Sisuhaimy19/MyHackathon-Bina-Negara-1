import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.Color;

public class MainMenu implements ActionListener{

	JFrame frmBinaNegara;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmBinaNegara.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBinaNegara = new JFrame();
		frmBinaNegara.setTitle("Bina Negara");
		frmBinaNegara.getContentPane().setBackground(new Color(138, 43, 226));
		frmBinaNegara.setBounds(100, 100, 400, 280);
		frmBinaNegara.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBinaNegara.getContentPane().setLayout(null);
		
		JButton btn_report_issue = new JButton("REPORT ISSUE");
		btn_report_issue.setBounds(120, 100, 135, 23);
		frmBinaNegara.getContentPane().add(btn_report_issue);
		
		JButton btn_check_update = new JButton("CHECK UPDATE");
		btn_check_update.setBounds(120, 134, 135, 23);
		frmBinaNegara.getContentPane().add(btn_check_update);
		
		JButton btn_about_us = new JButton("ABOUT US");
		btn_about_us.setBounds(120, 168, 135, 23);
		frmBinaNegara.getContentPane().add(btn_about_us);
		
		JLabel lblNewLabel = new JLabel("</MyHackathon>....");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel.setBounds(69, 49, 232, 30);
		frmBinaNegara.getContentPane().add(lblNewLabel);
		
		btn_report_issue.addActionListener(this);
		btn_check_update.addActionListener(this);
		btn_about_us.addActionListener(this);
	}
	
	private void goToReportIssue() throws IOException {
		ReportIssue reportIssue = new ReportIssue();
		reportIssue.setVisible(true);
		this.frmBinaNegara.dispose();
	}
	
	private void goToCheckUpdate() throws IOException {
		CheckUpdate checkUpdate = new CheckUpdate();
		checkUpdate.setVisible(true);
		this.frmBinaNegara.dispose();
	}
	
	private void goToAboutUs() {
		AboutUs aboutUs = new AboutUs();
		aboutUs.setVisible(true);
		this.frmBinaNegara.dispose();	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("REPORT ISSUE")) {
			try {
				goToReportIssue();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("CHECK UPDATE")) {
			try {
				goToCheckUpdate();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			goToAboutUs();
		}
	}
}
