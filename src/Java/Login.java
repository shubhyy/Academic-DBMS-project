package Java;
import java.awt.EventQueue;
import Database.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Database.*;
public class Login {

	public static JFrame frame;
	public static JTextField textField;
	private JPasswordField passwordField;
    public JComboBox comboBoxUser = new JComboBox();
	Validate v1 = new Validate();
	JLabel label_1 = new JLabel("");
	public static String uname= new String();
	/**
	 * Launch the application.
	 */
  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Login() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame("Login");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(400, 100, 1366, 768);
		frame.setExtendedState(6);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblTeacherMonitoringSystem = new JLabel("Syllabus Monitoring System");
		lblTeacherMonitoringSystem.setBackground(new Color(51, 51, 51));
		lblTeacherMonitoringSystem.setForeground(new Color(153, 204, 153));
		lblTeacherMonitoringSystem.setFont(new Font("Sawasdee", Font.BOLD, 48));
		lblTeacherMonitoringSystem.setBounds(350, 10, 961, 208);
		frame.getContentPane().add(lblTeacherMonitoringSystem);
		
		JButton button = new JButton("");
		button.setBackground(new Color(192, 192, 192));
		button.setBounds(302, 234, 716, 4);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBackground(new Color(192, 192, 192));
		button_1.setBounds(302, 660, 716, 4);
		frame.getContentPane().add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(427, 288, 486, 312);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Username");
		lblName.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblName.setForeground(new Color(211, 211, 211));
		lblName.setBounds(142, 92, 133, 15);
		panel.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		lblPassword.setForeground(new Color(211, 211, 211));
		lblPassword.setBounds(142, 141, 70, 15);
		panel.add(lblPassword);
		
		 textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setBounds(254, 90, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 240));
		passwordField.setBounds(254, 139, 114, 19);
		panel.add(passwordField);
		
		JLabel lblLogin = new JLabel("Log in");
		lblLogin.setForeground(new Color(211, 211, 211));
		lblLogin.setFont(new Font("Laksaman", Font.BOLD, 39));
		lblLogin.setBounds(36, 17, 148, 51);
		panel.add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
	   btnLogin.setActionCommand("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 String s= e.getActionCommand();
			 String Utype= new String((String) comboBoxUser.getSelectedItem());
			 if(s.equals("Login"))
			 {
				 uname= new String(textField.getText());
				 String pass= new String(passwordField.getText());
				 
				 
			     try {
				  
			    	 
				    
				     try {
						v1.Validate1(uname,pass,Utype);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    label_1.setText("Check Username Password");
			   
			     
			     } catch (NullPointerException e1) {	
			       e1.printStackTrace();
				}
			     
			 }
			
			}
		});
		btnLogin.setForeground(Color.LIGHT_GRAY);
		btnLogin.setBackground(new Color(64, 64, 64));
		btnLogin.setBounds(277, 236, 117, 25);
		panel.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setActionCommand("mw");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s= e.getActionCommand();
		
			
			}
		});
		btnReset.setForeground(Color.LIGHT_GRAY);
		btnReset.setBackground(Color.DARK_GRAY);
		btnReset.setBounds(148, 236, 117, 25);
		panel.add(btnReset);
		
		
		comboBoxUser.setToolTipText("Who are you ?  select here !!!");
		comboBoxUser.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		comboBoxUser.setBackground(new Color(240, 248, 255));
		comboBoxUser.setBounds(142, 185, 226, 24);
		panel.add(comboBoxUser);
		comboBoxUser.addItem("--Select User--");

		comboBoxUser.addItem("Teacher");
		comboBoxUser.addItem("Administrator");
		
		Database.Connect c1 =new Connect();
		c1.test();
		System.out.println(comboBoxUser.getSelectedItem());
		JLabel label = new JLabel("");
		label.setBounds(231, 17, 70, 15);
		panel.add(label);
		
		JLabel lblForgotPassword = new JLabel("Forgot password ?");
		lblForgotPassword.setBounds(125, 268, 253, 34);
		panel.add(lblForgotPassword);
		lblForgotPassword.setForeground(Color.WHITE);
		
		JButton btnResetHere = new JButton("Reset here");
		btnResetHere.setActionCommand("resetpass");
		btnResetHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s= e.getActionCommand();
			if(s.equals("resetpass"))
			{
				frame.dispose();
				try {
					new EditUser();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnResetHere.setBounds(277, 275, 117, 25);
		panel.add(btnResetHere);
		btnResetHere.setBackground(Color.LIGHT_GRAY);
		btnResetHere.setForeground(Color.BLACK);
		
		JLabel lblMiniProject = new JLabel("Mini Project - Database Management System");
		lblMiniProject.setForeground(Color.WHITE);
		lblMiniProject.setBounds(615, 134, 441, 67);
		frame.getContentPane().add(lblMiniProject);
		label_1.setBounds(585, 633, 252, 15);
		frame.getContentPane().add(label_1);
		label_1.setForeground(Color.RED);
	}
}
