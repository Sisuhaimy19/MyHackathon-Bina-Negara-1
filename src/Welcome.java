import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;

public class Welcome extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setTitle("Bina Negara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("</MyHackathon>....");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel.setBounds(109, 44, 232, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images/icon.png"));
		lblNewLabel_1.setBounds(169, 85, 95, 112);
		contentPane.add(lblNewLabel_1);
		
		JButton btn_welcome = new JButton("WELCOME");
		btn_welcome.setBounds(163, 230, 112, 23);
		contentPane.add(btn_welcome);
		
		btn_welcome.addActionListener(this);
	}
	private void goToAdminUpdate() throws IOException {
		AdminUpdate update = new AdminUpdate();
		update.setVisible(true);
		this.dispose();
	}

	private void goToMainMenu() throws IOException {
		MainMenu reportIssue = new MainMenu();
		reportIssue.frmBinaNegara.setVisible(true);
		this.dispose();
	}
	
	public void ChooseOwner() throws IOException{
		Object[] options = {"Customer", "Admin"};
		int dialogResult = JOptionPane.showOptionDialog(null, "Who're you?", "Register", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		
		if(dialogResult == 0 ) {
			goToMainMenu();
		}
		else {
			JPasswordField pwd = new JPasswordField(10);

			int action = JOptionPane.showConfirmDialog(null, pwd,"Enter Password",JOptionPane.OK_CANCEL_OPTION);
			if(action < 0){
			    JOptionPane.showMessageDialog(null,"Canceled");
			}
			else 
			{
			    String password = new String(pwd.getPassword());
			    if (password.equals("admin123")){
			     // login success
			    	goToAdminUpdate();
			   }
			   else{
			    // login failed
				   JOptionPane.showMessageDialog(null, "Wrong Password!");
			   }

			}
			
			
//			   JPasswordField pwd = new JPasswordField(10);
//			    int action = JOptionPane.showConfirmDialog(null, pwd,"Enter Password",JOptionPane.OK_CANCEL_OPTION);
//			    if(action < 0)JOptionPane.showMessageDialog(null,"Cancel, X or escape key selected");
//			    else JOptionPane.showMessageDialog(null,"Your password is "+new String(pwd.getPassword()));
//			    System.exit(0);
//			
//				String m = JOptionPane.showInputDialog("Password");
//			
//				if(m.equals("admin123")) {
//				goToAdminUpdate();
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Wrong Password!");
//				}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			ChooseOwner();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
