import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;

public class AdminUpdate extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_icNum;
	private JTextField txt_phoneNum;
	private JTextField txt_email;
	private JTextField txt_report;
	private JTextField txt_location;
	private JList lst_idNum;
	private JComboBox cmb_status;
	
	ArrayList<Reporter> reportList = new ArrayList<Reporter>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdate frame = new AdminUpdate();
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
	public AdminUpdate() throws IOException{
		ReadFile();
		
		setTitle("Bina Negara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Update Status");
		lbl_title.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lbl_title.setBounds(246, 40, 180, 30);
		contentPane.add(lbl_title);
		
		lst_idNum = new JList();
		lst_idNum.setBounds(36, 102, 123, 175);
		contentPane.add(lst_idNum);
		if(lst_idNum.getModel().getSize() == 0)
		{
			DefaultListModel ArrList = new DefaultListModel();
			//JOptionPane.showMessageDialog(null,studentList.size());
		for(int i = 0; i<reportList.size();i++)
		{
			ArrList.addElement((i+1)+". "+reportList.get(i).getReportInfo().getIDNumber());
			//JOptionPane.showMessageDialog(null,studentList.get(i).getOwnerVehicle().getName());
		};
		lst_idNum.setModel(ArrList);
		}
		
		lst_idNum.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				int selectIndex = lst_idNum.getSelectedIndex();
				setTextFieldValues(selectIndex);
			}	
		});
		
		JLabel lbl_idNum = new JLabel("ID Number");
		lbl_idNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_idNum.setBounds(185, 102, 79, 14);
		contentPane.add(lbl_idNum);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_name.setBounds(185, 127, 46, 14);
		contentPane.add(lbl_name);
		
		JLabel lbl_icNum = new JLabel("IC Number");
		lbl_icNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_icNum.setBounds(185, 152, 79, 14);
		contentPane.add(lbl_icNum);
		
		JLabel lbl_phoneNum = new JLabel("Number Phone");
		lbl_phoneNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_phoneNum.setBounds(185, 177, 98, 14);
		contentPane.add(lbl_phoneNum);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_email.setBounds(185, 202, 46, 14);
		contentPane.add(lbl_email);
		
		JLabel lbl_report = new JLabel("Report On");
		lbl_report.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_report.setBounds(185, 227, 79, 14);
		contentPane.add(lbl_report);
		
		JLabel lbl_location = new JLabel("Location");
		lbl_location.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_location.setBounds(185, 252, 46, 14);
		contentPane.add(lbl_location);
		
		JLabel lbl_status = new JLabel("Status");
		lbl_status.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_status.setBounds(185, 277, 46, 14);
		contentPane.add(lbl_status);
		
		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_id.setBounds(293, 100, 193, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setEditable(false);
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_name.setColumns(10);
		txt_name.setBounds(293, 125, 193, 20);
		contentPane.add(txt_name);
		
		txt_icNum = new JTextField();
		txt_icNum.setEditable(false);
		txt_icNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_icNum.setColumns(10);
		txt_icNum.setBounds(293, 150, 193, 20);
		contentPane.add(txt_icNum);
		
		txt_phoneNum = new JTextField();
		txt_phoneNum.setEditable(false);
		txt_phoneNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_phoneNum.setColumns(10);
		txt_phoneNum.setBounds(293, 175, 193, 20);
		contentPane.add(txt_phoneNum);
		
		txt_email = new JTextField();
		txt_email.setEditable(false);
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_email.setColumns(10);
		txt_email.setBounds(293, 200, 193, 20);
		contentPane.add(txt_email);
		
		txt_report = new JTextField();
		txt_report.setEditable(false);
		txt_report.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_report.setColumns(10);
		txt_report.setBounds(293, 225, 193, 20);
		contentPane.add(txt_report);
		
		txt_location = new JTextField();
		txt_location.setEditable(false);
		txt_location.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_location.setColumns(10);
		txt_location.setBounds(293, 250, 193, 20);
		contentPane.add(txt_location);
		
		String status [] = {"Pending", "Approved"};
		cmb_status = new JComboBox(status);
		cmb_status.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmb_status.setBounds(293, 274, 193, 25);
		contentPane.add(cmb_status);
		
		JButton btn_back = new JButton("BACK");
		btn_back.setBounds(496, 313, 89, 23);
		contentPane.add(btn_back);
		
		JButton btn_save = new JButton("SAVE");
		btn_save.setBounds(397, 313, 89, 23);
		contentPane.add(btn_save);
		
		btn_save.addActionListener(this);
		btn_back.addActionListener(this);
	}
	
	public void setTextFieldValues(int selectedIndex) {
		Reporter item = reportList.get(selectedIndex);
		
		txt_id.setText(item.getReportInfo().getIDNumber());
		txt_name.setText(item.getName());
		txt_icNum.setText(String.valueOf(item.getICNumber()));
		txt_phoneNum.setText(String.valueOf(item.getPhoneNumber()));
		txt_email.setText(item.getEmail());
		txt_report.setText(item.getReportInfo().getReportType());
		txt_location.setText(item.getReportInfo().getLocation());
		
		String status = cmb_status.getActionCommand();
		
		if(status.equals("Pending")) {
			cmb_status.setSelectedIndex(0);
		}
		else if(status.equals("Approved")){
			cmb_status.setSelectedIndex(1);
		}
		
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

	public void UpdateStatus(int i) throws NumberFormatException, IOException{
		Reporter item = reportList.get(i);
		Report r = item.getReportInfo();
		int selectedIndex = cmb_status.getSelectedIndex();
		
		if(selectedIndex == 0) {
			r.setStatus("Pending");
		}
		else if(selectedIndex == 1){
			r.setStatus("Approved");
		}
		
	}
	
	public void refreshFrame() throws IOException
	{
		AdminUpdate main = new AdminUpdate();    
	    main.setVisible(true);
	    this.setVisible(false);
		
	}

	private void goToWelcome() {
		// TODO Auto-generated method stub
		Welcome main = new Welcome();
		main.setVisible(true);
		this.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = lst_idNum.getSelectedIndex();
		
		if(e.getActionCommand().equals("SAVE")) {
			try {
				UpdateStatus(index);
				writeToFile();
				reportList.clear();
				refreshFrame();
			}
			catch(NumberFormatException | IOException e1) {
				e1.printStackTrace();
				
			}
		}
		else {
			reportList.clear();
			goToWelcome();
		}
	}
}
