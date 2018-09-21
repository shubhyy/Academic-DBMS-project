package Java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.mysql.jdbc.Statement;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import Database.*;
public class Edit_pass {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	Connect c2= new Connect();
	EditUser eu1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_pass window = new Edit_pass();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Edit_pass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Change password");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(0, 0, 1360, 759);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(6);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        
        JLabel lblSyllabusMonitoringSystem = new JLabel("Syllabus Monitoring System");
        lblSyllabusMonitoringSystem.setForeground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
        lblSyllabusMonitoringSystem.setFont(new Font("Sawasdee", Font.BOLD, 48));
        lblSyllabusMonitoringSystem.setBackground(UIManager.getColor("Button.foreground"));
        lblSyllabusMonitoringSystem.setBounds(332, 12, 961, 208);
        frame.getContentPane().add(lblSyllabusMonitoringSystem);
        
        JButton button = new JButton("");
        button.setBackground(Color.LIGHT_GRAY);
        button.setBounds(285, 236, 716, 4);
        frame.getContentPane().add(button);
        
        JButton button_1 = new JButton("");
        button_1.setBackground(Color.LIGHT_GRAY);
        button_1.setBounds(285, 662, 716, 4);
        frame.getContentPane().add(button_1);
        
        JLabel label_1 = new JLabel("Mini Project - Database Management System");
        label_1.setForeground(Color.WHITE);
        label_1.setBounds(598, 136, 441, 67);
        frame.getContentPane().add(label_1);
        
        JButton btnBack = new JButton("Back");
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(51, 51, 51));
        btnBack.setActionCommand("back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	  String s= e.getActionCommand();
        	  if(s.equals("back"))
        	  {
        		  frame.dispose();
        		  new Confirm_detail();
        	  }
        	}
        });
        btnBack.setBounds(51, 214, 117, 25);
        frame.getContentPane().add(btnBack);
        
        JLabel lblEditYourPassword = new JLabel("Edit Your Password");
        lblEditYourPassword.setForeground(new Color(255, 255, 255));
        lblEditYourPassword.setFont(new Font("Laksaman", Font.PLAIN, 37));
        lblEditYourPassword.setBounds(285, 251, 497, 67);
        frame.getContentPane().add(lblEditYourPassword);
        
        textField_1 = new JTextField();
        textField_1.setBounds(700, 421, 114, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(700, 472, 114, 19);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblEnterNewPassword = new JLabel("Enter new password");
        lblEnterNewPassword.setForeground(new Color(255, 255, 255));
        lblEnterNewPassword.setBounds(528, 411, 154, 38);
        frame.getContentPane().add(lblEnterNewPassword);
        
        JLabel lblRetypeNewPassword = new JLabel("Re-type new password");
        lblRetypeNewPassword.setForeground(new Color(255, 255, 255));
        lblRetypeNewPassword.setBounds(528, 458, 163, 47);
        frame.getContentPane().add(lblRetypeNewPassword);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setActionCommand("update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	 String s12= e.getActionCommand();
        	 if(s12.equals("update"))
        	 {
        		 try {
					if(textField_2.getText()=="" || eu1.user.equals("null"))
					{
					    JOptionPane.showMessageDialog(null, "Error in User or Password Check Details again");
						
					}
					else
					{
						c2.test();
					    c2.st= (Statement) c2.con.createStatement();
					    c2.st.executeUpdate("UPDATE user SET password='"+textField_2.getText()+"' WHERE username='"+eu1.user+"'");
	        		    textField_1.setText("");
	        		    textField_2.setText("");
	        		    JOptionPane.showMessageDialog(null, "Password Updated Sucessfully");
						
					}
					
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		 
        	 }
        	
        	}
        });
        btnUpdate.setBounds(697, 552, 117, 25);
        frame.getContentPane().add(btnUpdate);
        
        JButton btnReset = new JButton("Reset");
        btnReset.setActionCommand("reset");
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	String s1= e.getActionCommand();
        	if(s1.equals("reset"))
        	{
               textField_1.setText("");
               textField_2.setText("");
               
        	}
        	}
        });
        btnReset.setBounds(528, 552, 117, 25);
        frame.getContentPane().add(btnReset);
        
        JLabel lblImage = new JLabel("");
        lblImage.setIcon(new ImageIcon("/home/nikhil/eclipse-workspace/Teacher Monitoring System/src/Images/administrator.png"));
        lblImage.setBounds(1086, 82, 107, 112);
        frame.getContentPane().add(lblImage);
        
        
        JLabel label = new JLabel("Hi "+eu1.user);
        label.setForeground(new Color(255, 255, 255));
        label.setBounds(1112, 195, 134, 25);
        frame.getContentPane().add(label);
	}
}
