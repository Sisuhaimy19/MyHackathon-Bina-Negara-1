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
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;

public class CheckUpdate extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable tbl_update;
	
	ArrayList<Reporter> reportList = new ArrayList<Reporter>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckUpdate frame = new CheckUpdate();
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
	public CheckUpdate() throws IOException{
		ReadFile();
		
		setTitle("Bina Negara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 0, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_checkUpdate = new JLabel("Check Update");
		lbl_checkUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lbl_checkUpdate.setBounds(158, 39, 163, 30);
		contentPane.add(lbl_checkUpdate);
		
		JButton btn_back = new JButton("BACK");
		btn_back.setBounds(349, 246, 89, 23);
		contentPane.add(btn_back);
		
		tbl_update = addRowData();
		tbl_update.setBounds(48, 88, 379, 125);
		contentPane.add(tbl_update);
		
		btn_back.addActionListener(this);
	}
	
	private void goToMenu() {
		// TODO Auto-generated method stub
		MainMenu main = new MainMenu();
		main.frmBinaNegara.setVisible(true);
		this.dispose();
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
	
	public JTable addRowData()
	{
		JTable tbl_update;
	    Object[] columns = {"ID Number","Name","Status"};
	    Object data[][] = new Object[reportList.size()][3];
	    
	    for(int i=0; i<reportList.size(); i++) {
	    	Reporter item = reportList.get(i);
	    	
	    	data[i][0] = item.getReportInfo().getIDNumber();
	    	data[i][1] = item.getName();
	    	data[i][2] = item.getReportInfo().getStatus();
	    }
	    	tbl_update = new JTable(data, columns);
	    	return tbl_update;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		goToMenu();
	}
}
