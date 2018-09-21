package Teacher_client;
import java.sql.SQLException;
import Database.*;
import Java.*;
import Java.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import Syllabus.*;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class homePage {
  
	private JFrame frame;
	public static String selectedSub;
	JLabel lblNewLabel = new JLabel("");
    //public String uname;
   
	/**
	 * Launch the application.
	 */
	   public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage window = new homePage();					
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
	public homePage() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame("Teacher Window");
		frame.getContentPane().setForeground(Color.GREEN);
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(0, 0, 1366, 768);
		frame.setExtendedState(6);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		 Login lg= new Login();
		 lg.frame.dispose();
		

		JComboBox comboBox = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select Subject--"}));
		comboBox.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		comboBox.setForeground(new Color(255,255,255));
		comboBox.setBackground(new Color(0,0,51));
		comboBox.setToolTipText("Select Subject");
		comboBox.setBounds(535, 400, 291, 24);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("--------------Select Subject--------------");
		
		
		try {
			Connect db=new Connect();
			db.test();
			db.st = (com.mysql.jdbc.Statement) db.con.createStatement();
			java.sql.ResultSet rs=db.st.executeQuery("SELECT * FROM SMS.subject,SMS.allocation where username='"+lg.uname+"'and allocation.sub_code=subject.sub_code;");
			while(rs.next())
			{
				String pat = rs.getString(3);
				comboBox.addItem(pat);
			}
			//selectedSub=(String) comboBox.getSelectedItem();
			rs.close();
			db.st.close();
		//comboBox.addItem("TOC");
		//comboBox.addItem("DBMS");
		//comboBox.addItem("OS");
		//comboBox.addItem("SEPM");
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		//System.out.println(comboBox.getSelectedItem());
		//int cnt=comboBox.getComponentCount();
		//System.out.println("Alloted subjects : "+cnt);
		if(comboBox.getComponentCount()==0)
		{
			lblNewLabel.setText("Sorry ! No subject alloted.");
		}
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(733, 316, 278, 15);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblSyllabusMonitoringSystem = new JLabel("Syllabus Monitoring System");
		lblSyllabusMonitoringSystem.setForeground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		lblSyllabusMonitoringSystem.setFont(new Font("Sawasdee", Font.BOLD, 48));
		lblSyllabusMonitoringSystem.setBackground(UIManager.getColor("Button.foreground"));
		lblSyllabusMonitoringSystem.setBounds(360, 12, 961, 208);
		frame.getContentPane().add(lblSyllabusMonitoringSystem);
		
		JButton button = new JButton("");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(312, 236, 716, 4);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(312, 662, 716, 4);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("Mini Project - Database Management System");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(625, 136, 441, 67);
		frame.getContentPane().add(label_1);
		
		JLabel lblControlPanel = new JLabel("");
		lblControlPanel.setForeground(new Color(255, 255, 255));
		lblControlPanel.setFont(new Font("Laksaman", Font.BOLD, 23));
		lblControlPanel.setBounds(328, 264, 200, 47);
		frame.getContentPane().add(lblControlPanel);
		lblControlPanel.setText("Welcome  "+lg.uname);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("OptionPane.messageForeground"));
		panel.setBounds(403, 557, 550, 93);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnReportGenerator = new JButton("Report Generator");
		btnReportGenerator.setActionCommand("report");
		btnReportGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  
			
					  
			}
		});
		btnReportGenerator.setForeground(new Color(255, 255, 255));
		btnReportGenerator.setBackground(new Color(0, 0, 51));
		btnReportGenerator.setBounds(96, 23, 359, 46);
		panel.add(btnReportGenerator);
		
		JButton btnBack = new JButton("Logout");
		btnBack.setActionCommand("Login1");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  String s= e.getActionCommand();
			  if(s.equals("Login1"))
			  {
		 		try {
					frame.dispose();
		 			new Login();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			  }
			}
		});
		btnBack.setForeground(new Color(204, 0, 0));
		btnBack.setBackground(new Color(51, 51, 51));
		btnBack.setBounds(1151, 215, 90, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setActionCommand("subjectMonitor");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=e.getActionCommand();
				selectedSub=(String) comboBox.getSelectedItem();
				System.out.println(selectedSub);
				if(s.equals("subjectMonitor"))
				{
					try {
						frame.dispose();
						new subjectMonitor();
						
					}catch(Exception ee) {
						ee.printStackTrace();
						
						
					}
				}
				
				
			}
		});
		
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(new Color(51, 51, 51));
		btnNewButton.setBounds(594, 459, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
	
	}
}