package Java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import Database_DML.*;
import Syllabus.S3;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
public class AddTeacher {

	private JFrame frame;
	private JTextField textField_1;
	private JPasswordField passwordField;
    insert i1=new insert();
    private JTextField textField;
    private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher window = new AddTeacher();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddTeacher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add new Teacher");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(0, 0, 1366, 759);
		frame.setExtendedState(6);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JComboBox comboBox_1 = new JComboBox();
		JLabel lblSyllabusteacherMonitoringSystem = new JLabel("Syllabus Monitoring System");
		lblSyllabusteacherMonitoringSystem.setForeground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		lblSyllabusteacherMonitoringSystem.setFont(new Font("Sawasdee", Font.BOLD, 48));
		lblSyllabusteacherMonitoringSystem.setBackground(UIManager.getColor("Button.foreground"));
		lblSyllabusteacherMonitoringSystem.setBounds(338, 26, 961, 208);
		frame.getContentPane().add(lblSyllabusteacherMonitoringSystem);
		
		JButton button = new JButton("");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(290, 250, 716, 4);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(290, 676, 716, 4);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("Mini Project - Database Management System");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(603, 150, 441, 67);
		frame.getContentPane().add(label_1);
		
		JButton btnLogout = new JButton("Back");
		btnLogout.setForeground(new Color(255, 51, 51));
		btnLogout.setBackground(new Color(51, 51, 51));
		btnLogout.setActionCommand("back");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  String s= e.getActionCommand();
			  if(s.equals("back"))
			  {
				  try {
					  frame.dispose();
					new Administrator();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  }
			
			}
		});
		btnLogout.setBounds(67, 209, 117, 25);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblCreateNewTeacher = new JLabel("Create new User");
		lblCreateNewTeacher.setForeground(new Color(204, 204, 204));
		lblCreateNewTeacher.setFont(new Font("Laksaman", Font.BOLD, 29));
		lblCreateNewTeacher.setBounds(300, 237, 510, 75);
		frame.getContentPane().add(lblCreateNewTeacher);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		panel.setBounds(328, 349, 622, 286);
		frame.getContentPane().add(panel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Mrs.", "Miss."}));
		
		JLabel lblFullName = new JLabel("Full name");
		lblFullName.setForeground(new Color(255, 255, 255));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setActionCommand("create");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			String fname = new String( comboBox.getSelectedItem()+textField.getText());
			String lname = new String(textField_2.getText());
			String uname = new String(textField_1.getText());
			String pass = new String(passwordField.getText());
			String Utype = new String((String) comboBox_1.getSelectedItem());
			if(s.equals("create"))
			{
				try {
					 if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals(""))
        			 {
        			  JOptionPane.showMessageDialog(null, "Error check all fields");
        			 }
        			 else {
					
					i1.add("user","'"+uname+"','"+fname+"','"+lname+"','"+pass+"','"+Utype+"'");
				
					textField.setText("");
					textField_1.setText("");
					passwordField.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(null,fname+" added Succesfully");
	        		 
            			 }
 			

        			 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				}
			}
			}
		});
		btnCreateAccount.setBackground(new Color(204, 204, 204));
		
		JButton btnSubmit = new JButton("Reset");
		btnSubmit.setActionCommand("reset");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s= e.getActionCommand();
			if(s.equals("reset"))
			{

				textField.setText(null);
				textField_1.setText(null);
				passwordField.setText(null);
			
			}
			
			}
		});
		btnSubmit.setBackground(new Color(255, 102, 153));
		
		
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Teacher", "Administrator"}));
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(162)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(92)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(162)
					.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(162)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(162)
					.addComponent(lblPassword)
					.addGap(22)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(210)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnCreateAccount))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblUserType)))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblFullName))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblUsername))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblPassword))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSubmit)
						.addComponent(btnCreateAccount)))
		);
		panel.setLayout(gl_panel);
	}
}
