package Java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherWindow window = new TeacherWindow();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeacherWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Teacher Window");
		frame.setExtendedState(6);
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(0, 0, 1366, 759);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		JLabel label = new JLabel("Teacher Monitoring System");
		label.setForeground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		label.setFont(new Font("Sawasdee", Font.BOLD, 48));
		label.setBackground(UIManager.getColor("Button.foreground"));
		label.setBounds(348, -16, 961, 208);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(300, 208, 716, 4);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(300, 634, 716, 4);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("Mini Project - Database Management System");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(613, 108, 441, 67);
		frame.getContentPane().add(label_1);
		
		JButton btnLogout = new JButton("Logout");
	   btnLogout.setActionCommand("Login1");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s= e.getActionCommand();
			if(s.equals("Login1"))
			{
				frame.dispose();
				try {
					new Login();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnLogout.setForeground(new Color(204, 51, 0));
		btnLogout.setBackground(new Color(51, 51, 51));
		btnLogout.setBounds(1148, 204, 117, 25);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblTeacherLogin = new JLabel("Teacher Login");
		lblTeacherLogin.setForeground(new Color(0, 204, 51));
		lblTeacherLogin.setBounds(83, 108, 140, 104);
		frame.getContentPane().add(lblTeacherLogin);
	}
}
