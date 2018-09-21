package Java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Database.Authentication;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Confirm_detail {

	private JFrame frame;
	private JTextField textField_1;
    public static int flag=0; 
	EditUser eu1;
     Authentication a1=new Authentication();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm_detail window = new Confirm_detail();
				   
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Confirm_detail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Authentication");
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
        lblSyllabusMonitoringSystem.setBounds(333, 12, 961, 208);
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
        btnBack.setActionCommand("back1");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
          String s=e.getActionCommand();
          if(s.equals("back1"))
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
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(51, 51, 51));
        btnBack.setBounds(63, 195, 117, 25);
        frame.getContentPane().add(btnBack);
        
        JLabel lblFirstAuthenticateYour = new JLabel("First Authenticate Your Details");
        lblFirstAuthenticateYour.setFont(new Font("Laksaman", Font.PLAIN, 37));
        lblFirstAuthenticateYour.setForeground(new Color(255, 255, 255));
        lblFirstAuthenticateYour.setBounds(295, 210, 585, 127);
        frame.getContentPane().add(lblFirstAuthenticateYour);
        
        textField_1 = new JTextField();
        textField_1.setBounds(652, 501, 114, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblLastName = new JLabel("Last name");
        lblLastName.setForeground(new Color(255, 255, 255));
        lblLastName.setBounds(548, 502, 97, 15);
        frame.getContentPane().add(lblLastName);
        
        JButton btnAuthticate = new JButton("Authticate");
        btnAuthticate.setActionCommand("authenticate");
        btnAuthticate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	String s=e.getActionCommand();
        	String uname= new String(eu1.user);
        	
        	String lname=new String(textField_1.getText());
        	
        	if(s.equals("authenticate"))
        	{
        	   try {
				a1.authenticate(uname,lname);
		        if(a1.flag == 0)
		        {
		        	System.out.println("Wrong Last name");
		          JOptionPane.showMessageDialog(null,"Wrong Lastname ");
		        }
		        else
		        {
		        	System.out.println("Authentication Success");
			        frame.dispose();
		        	new Edit_pass();   	
		        }
        	   
        	   
        	   } catch (Exception e1) {
        		 
        		   JOptionPane.showMessageDialog(null,e1.getMessage(),"ERROR",0);
        		    e1.printStackTrace();
			}	
        	}
        	
        	}
        });
        btnAuthticate.setForeground(new Color(255, 255, 255));
        btnAuthticate.setBackground(new Color(51, 51, 51));
        btnAuthticate.setBounds(661, 554, 117, 25);
        frame.getContentPane().add(btnAuthticate);
        
        JButton btnReset = new JButton("Reset");
        btnReset.setForeground(new Color(255, 255, 255));
        btnReset.setBackground(new Color(51, 51, 51));
        btnReset.setBounds(532, 554, 117, 25);
        frame.getContentPane().add(btnReset);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("/home/nikhil/eclipse-workspace/Teacher Monitoring System/src/Images/administrator.png"));
        label.setBounds(606, 351, 130, 119);
        frame.getContentPane().add(label);
        
        JLabel lblUsename = new JLabel("Usename: "+eu1.user);
        lblUsename.setForeground(new Color(255, 255, 255));
        lblUsename.setBounds(600, 465, 138, 19);
        frame.getContentPane().add(lblUsename);
	}
}
