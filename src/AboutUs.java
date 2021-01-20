import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class AboutUs extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setTitle("Bina Negara");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 0, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("About Us");
		lbl_title.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lbl_title.setBounds(171, 35, 148, 42);
		contentPane.add(lbl_title);
		
		JLabel lbl_phoneNum = new JLabel("OUR CARELINE");
		lbl_phoneNum.setForeground(Color.WHITE);
		lbl_phoneNum.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		lbl_phoneNum.setBounds(175, 107, 115, 14);
		contentPane.add(lbl_phoneNum);
		
		JLabel lbl_fb = new JLabel("FACEBOOK");
		lbl_fb.setForeground(Color.WHITE);
		lbl_fb.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		lbl_fb.setBounds(71, 173, 94, 14);
		contentPane.add(lbl_fb);
		
		JLabel lbl_ig = new JLabel("INSTAGRAM");
		lbl_ig.setForeground(Color.WHITE);
		lbl_ig.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		lbl_ig.setBounds(71, 262, 115, 14);
		contentPane.add(lbl_ig);
		
		JLabel lbl_twitter = new JLabel("TWITTER");
		lbl_twitter.setForeground(Color.WHITE);
		lbl_twitter.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		lbl_twitter.setBounds(276, 173, 94, 14);
		contentPane.add(lbl_twitter);
		
		JLabel lbl_yt = new JLabel("YOUTUBE");
		lbl_yt.setForeground(Color.WHITE);
		lbl_yt.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		lbl_yt.setBounds(276, 262, 94, 14);
		contentPane.add(lbl_yt);
		
		JLabel lbl_num = new JLabel("03-999 8880");
		lbl_num.setBounds(199, 132, 91, 14);
		contentPane.add(lbl_num);
		
		JLabel lbl_fb1 = new JLabel("facebook.com/myhackerton");
		lbl_fb1.setBounds(81, 198, 179, 14);
		contentPane.add(lbl_fb1);
		
		JLabel lbl_ig1 = new JLabel("instagram.com/myhackerton");
		lbl_ig1.setBackground(SystemColor.menu);
		lbl_ig1.setBounds(81, 287, 179, 14);
		contentPane.add(lbl_ig1);
		
		JLabel lbl_twiter1 = new JLabel("twitter.com/myhackerton");
		lbl_twiter1.setBounds(286, 198, 164, 14);
		contentPane.add(lbl_twiter1);
		
		JLabel lbl_yt1 = new JLabel("youtube.com/myhackerton");
		lbl_yt1.setBounds(286, 287, 164, 14);
		contentPane.add(lbl_yt1);
		
		JButton btn_back = new JButton("BACK");
		btn_back.setBounds(361, 340, 89, 23);
		contentPane.add(btn_back);
		
		btn_back.addActionListener(this);
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
		goToMenu();
	}
}
