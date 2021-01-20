import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;

public class ReportIssue extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_icNum;
	private JTextField txt_phone;
	private JTextField txt_email;
	private JTextField txt_location;
	private JComboBox cmb_reportOn;
	private JLabel lbl_NumID;
	private JButton btn_submit;
	private JButton btn_back;
	private JTextArea txt_description;


	ArrayList<Reporter> reportList = new ArrayList<Reporter>();
	private JLabel lbl_idNum;
	private JTextField txt_idNum;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportIssue frame = new ReportIssue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReportIssue() throws IOException{
		ReadFile();
		
		setTitle("Bina Negara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Report Issue");
		lbl_title.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lbl_title.setBounds(181, 26, 145, 30);
		contentPane.add(lbl_title);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_name.setBounds(40, 103, 46, 14);
		contentPane.add(lbl_name);
		
		JLabel lbl_IC = new JLabel("IC Number");
		lbl_IC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_IC.setBounds(40, 128, 97, 14);
		contentPane.add(lbl_IC);
		
		JLabel lblNoPhone = new JLabel("No Phone");
		lblNoPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNoPhone.setBounds(40, 153, 97, 14);
		contentPane.add(lblNoPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(40, 178, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblReportOn = new JLabel("Report On");
		lblReportOn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReportOn.setBounds(40, 203, 97, 14);
		contentPane.add(lblReportOn);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocation.setBounds(40, 228, 72, 14);
		contentPane.add(lblLocation);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_name.setBounds(147, 100, 228, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_icNum = new JTextField();
		txt_icNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_icNum.setColumns(10);
		txt_icNum.setBounds(147, 125, 228, 20);
		contentPane.add(txt_icNum);
		
		txt_phone = new JTextField();
		txt_phone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_phone.setColumns(10);
		txt_phone.setBounds(147, 150, 228, 20);
		contentPane.add(txt_phone);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_email.setColumns(10);
		txt_email.setBounds(147, 175, 228, 20);
		contentPane.add(txt_email);
		
		txt_location = new JTextField();
		txt_location.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_location.setColumns(10);
		txt_location.setBounds(147, 225, 228, 20);
		contentPane.add(txt_location);
		
		btn_back = new JButton("BACK");
		btn_back.setBounds(385, 407, 89, 23);
		contentPane.add(btn_back);
		
		btn_submit = new JButton("SUBMIT");
		btn_submit.setBounds(286, 407, 89, 23);
		contentPane.add(btn_submit);
		
		String type [] = {"Road Maintenance", "Highway Maintenance", "Bulding Insruction", "Structures"};
		cmb_reportOn = new JComboBox(type);
		cmb_reportOn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmb_reportOn.setBounds(147, 199, 228, 18);
		contentPane.add(cmb_reportOn);
		
		lbl_idNum = new JLabel("ID Number");
		lbl_idNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_idNum.setBounds(40, 78, 72, 14);
		contentPane.add(lbl_idNum);
		
		txt_idNum = new JTextField();
		txt_idNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_idNum.setText("RP");
		txt_idNum.setBounds(147, 75, 228, 20);
		contentPane.add(txt_idNum);
		txt_idNum.setColumns(10);
		
		txt_description = new JTextArea();
		txt_description.setText("Report Description");
		txt_description.setBounds(40, 256, 417, 132);
		contentPane.add(txt_description);
		
		btn_submit.addActionListener(this);
		btn_back.addActionListener(this);
		
	}
	
	public void writeToFile() {
		try {
			FileWriter file = new FileWriter("ReportList.txt");
			PrintWriter out = new PrintWriter(file);
			
			for(int i=0; i<reportList.size(); i++) {
				Reporter rp = reportList.get(i);
				
				Report r = rp.getReportInfo();
				out.print(r.getIDNumber()+";"+rp.getName()+";"+rp.getICNumber()+";"+rp.getPhoneNumber()+";"+rp.getEmail()+";");
				out.print(r.getReportType()+";"+r.getLocation()+";"+r.getStatus()+";"+r.getDescription());
				out.println();
			}
			JOptionPane.showMessageDialog(null, "List Updated");
			out.close();
			}
		catch(IOException ex) {System.out.println("There's no such file!");}
}
	
	public void ReadFile() throws IOException{
		
		FileReader file = new FileReader("ReportList.txt");
		try (BufferedReader in = new BufferedReader(file)){
			String input = "";
			
			while((input = in.readLine()) != null) {
				StringTokenizer word = new StringTokenizer(input, ";");
				
				String IDNumber = word.nextToken();
				String Name = word.nextToken();
				String ICNumber = word.nextToken();
				String PhoneNumber = word.nextToken();
				String Email = word.nextToken();
				String type = word.nextToken();
				String Location = word.nextToken();
				String Status = word.nextToken();
				String Description = word.nextToken();
				
				
				
				Report r = new Report(IDNumber, type, Location, Description, Status);
				Reporter rp = new Reporter(Name,ICNumber,PhoneNumber,Email, r);
				
				reportList.add(rp);
				
			}
		}
	}
	
	private void goToMenu() {
		// TODO Auto-generated method stub
		MainMenu main = new MainMenu();
		main.frmBinaNegara.setVisible(true);
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String type = cmb_reportOn.getActionCommand();
	
		if(e.getActionCommand().equals("SUBMIT")) {
			
			if(txt_name.getText().equals("")||txt_icNum.getText().equals("")||txt_phone.getText().equals("")||txt_email.getText().equals("")||type.equals("")||txt_location.getText().equals("") ) {
				JOptionPane.showMessageDialog(null,"Form is not complete.");
			}
			else {
				int reportType = cmb_reportOn.getSelectedIndex();
				
				String IDNumber = txt_idNum.getText();
				String Name = txt_name.getText();
				String ICNumber = txt_icNum.getText();
				String PhoneNumber = txt_phone.getText();
				String Email = txt_email.getText();
				
				if(reportType == 1) {
					type = "Road Maintenance";
				}
				else if(reportType == 2) {
					type = "Highway Maintenance";
				}
				else if(reportType == 3) {
					type = "Building Instruction";
				}
				else {
					type = "Structures";
				}
				
				String Location = txt_location.getText();
				String Description = txt_description.getText();
				String Status = "Pending";
				
				
				Report r = new Report(IDNumber, type, Location, Description, Status);
				Reporter rp = new Reporter(Name,ICNumber,PhoneNumber,Email, r);
				
				JOptionPane.showMessageDialog(null,"Submited Successfull!");
				reportList.add(rp);
				
				writeToFile();
				
				System.out.println(reportList.size());
			}
			
		}
		else{
			goToMenu();
		}
	}
}
