package Java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.mysql.jdbc.Statement;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Database.*;
public class EditUser {

	private JFrame frame;
	Connect c1= new Connect();
	static String user= new String("null");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUser window = new EditUser();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public EditUser() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		c1.test();
		frame = new JFrame("Edit password");
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
	    lblSyllabusMonitoringSystem.setBounds(308, 23, 961, 208);
	    frame.getContentPane().add(lblSyllabusMonitoringSystem);
	    
	    JButton button = new JButton("");
	    button.setBackground(Color.LIGHT_GRAY);
	    button.setBounds(260, 247, 716, 4);
	    frame.getContentPane().add(button);
	    
	    JButton button_1 = new JButton("");
	    button_1.setBackground(Color.LIGHT_GRAY);
	    button_1.setBounds(260, 673, 716, 4);
	    frame.getContentPane().add(button_1);
	    
	    JLabel label_1 = new JLabel("Mini Project - Database Management System");
	    label_1.setForeground(Color.WHITE);
	    label_1.setBounds(573, 147, 441, 67);
	    frame.getContentPane().add(label_1);
	    
	    JLabel lblEditUser = new JLabel("Edit User");
	    lblEditUser.setForeground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
	    lblEditUser.setFont(new Font("Laksaman", Font.BOLD, 29));
	    lblEditUser.setBounds(270, 234, 510, 75);
	    frame.getContentPane().add(lblEditUser);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Teacher", "Administrator"}));
	    comboBox.setBounds(748, 263, 228, 24);
	    frame.getContentPane().add(comboBox);
	    
	    JLabel lblSelectUserType = new JLabel("Select User Type");
	    lblSelectUserType.setFont(new Font("Dialog", Font.BOLD, 14));
	    lblSelectUserType.setForeground(new Color(255, 255, 255));
	    lblSelectUserType.setBounds(606, 268, 174, 15);
	    frame.getContentPane().add(lblSelectUserType);
	    
	    JComboBox comboBox_1 = new JComboBox();
	    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--------- Please Select User Type ---------"}));
	    comboBox_1.setBounds(461, 410, 301, 24);
	    frame.getContentPane().add(comboBox_1);
	    
	    comboBox.setActionCommand("refresh");
	    comboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	 String s= e.getActionCommand();
	    	 if(s.equals("refresh"))
	    	 {
	    
	    		 try {
				     	c1.st=(Statement) c1.con.createStatement();
	    		        String s1= new String("SELECT username from user where user_type='"+comboBox.getSelectedItem()+"'");
	    		        java.sql.ResultSet rs= c1.st.executeQuery(s1);
	    		        comboBox_1.removeAllItems();
	    		    
	    		        while(rs.next())
	    		        {
	    		        	comboBox_1.addItem(rs.getString(1));
	    		        }
	    	         } catch (SQLException e1) {
				     		// TODO Auto-generated catch block
				     		e1.printStackTrace();
					}    
	    	 
	    	 }
	    	}
	    });
	    
	    
	    
	    
	   
	    
	    JButton btnChangePassword = new JButton("Next");
	    btnChangePassword.setActionCommand("update");
	    btnChangePassword.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	String s= e.getActionCommand();
	    	 user= (String) comboBox_1.getSelectedItem();
   		   
	    	if(s.equals("update"))
	    	  {
	    	  if(user.equals("--------- Please Select User Type ---------")){
        		  System.out.println("string matched");
	    		  JOptionPane.showMessageDialog(null, "first select user");

	    	  }
	    		  else
	    		  {
	    			  System.out.println("string not matched");
	    			  frame.dispose();
	    		  new Confirm_detail();
	    		  }
	    		  }
	    	}
	    });
	    btnChangePassword.setBackground(new Color(51, 51, 51));
	    btnChangePassword.setForeground(new Color(255, 255, 255));
	    btnChangePassword.setBounds(508, 513, 199, 33);
	    frame.getContentPane().add(btnChangePassword);
	    
	    JButton btnBack = new JButton("Back");
	    btnBack.setActionCommand("back");
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	 String s= e.getActionCommand();
	    	 if(s.equals("back"))
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
	    btnBack.setForeground(new Color(255, 255, 255));
	    btnBack.setBackground(new Color(51, 51, 51));
	    btnBack.setBounds(32, 223, 117, 25);
	    frame.getContentPane().add(btnBack);
	
	}
}
