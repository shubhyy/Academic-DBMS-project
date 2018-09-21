package Teacher_client;
import Database.*;
import Java.AddTeacher;
import Java.EditUser;
import Java.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import com.mysql.jdbc.Statement;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import Syllabus.*;
public class subjectMonitor {

	 
	private JFrame frame;
	homePage p1;
	Connect c1= new Connect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					subjectMonitor window = new subjectMonitor();					
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
	public subjectMonitor() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame("Teacher Window");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(0, 0, 1366, 768);
		frame.setExtendedState(6);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel label = new JLabel("Teacher Monitoring System");
		label.setForeground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		label.setFont(new Font("Sawasdee", Font.BOLD, 48));
		label.setBackground(UIManager.getColor("Button.foreground"));
		label.setBounds(360, 12, 961, 208);
		frame.getContentPane().add(label);
		
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Laksaman", Font.BOLD, 32));
		lblNewLabel.setBackground(SystemColor.activeCaptionText);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(762, 252, 239, 89);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setText(p1.selectedSub);
		System.out.println(p1.selectedSub);
		
		JButton btnAddTeacher = new JButton("Update Syllabus");
		btnAddTeacher.setActionCommand("updateSyll");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s= e.getActionCommand();
			if(s.equals("updateSyll"))
			{
				frame.dispose();
				new updateSyllabus();
			}
			}
		});
		btnAddTeacher.setForeground(new Color(255, 255, 255));
		btnAddTeacher.setBackground(new Color(0, 0, 51));
		btnAddTeacher.setBounds(410, 512, 231, 56);
		frame.getContentPane().add(btnAddTeacher);
		
		JButton btnAddSyllabus = new JButton("View Completed Topics");
		btnAddSyllabus.setActionCommand("viewCompleted");
		btnAddSyllabus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("viewCompleted"))
			{
				frame.dispose();
				new viewCompleted();
			}
			}
		});
		btnAddSyllabus.setForeground(new Color(255, 255, 255));
		btnAddSyllabus.setBackground(new Color(0, 0, 51));
		btnAddSyllabus.setBounds(801, 423, 221, 47);
		frame.getContentPane().add(btnAddSyllabus);
		
		JButton btnModifySyllabus = new JButton("View Remaining Topics");
		btnModifySyllabus.setForeground(new Color(255, 255, 255));
		btnModifySyllabus.setBackground(new Color(0, 0, 51));
		btnModifySyllabus.setBounds(801, 482, 221, 47);
		btnModifySyllabus.setActionCommand("viewR");
		frame.getContentPane().add(btnModifySyllabus);
		btnModifySyllabus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("viewR"))
			{
				frame.dispose();
				new viewRemaining();
			}
			}
		});
		
		
		JButton btnAddHod = new JButton("View Syllabus");
		btnAddHod.setActionCommand("viewSyllabus");
		btnAddHod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s= e.getActionCommand();
			if(s.equals("viewSyllabus"))
			{
				frame.dispose();
				new viewSyllabus();
				
			}
			
			}
		});
		btnAddHod.setForeground(new Color(255, 255, 255));
		btnAddHod.setBackground(new Color(0, 0, 51));
		btnAddHod.setBounds(801, 366, 221, 47);
		frame.getContentPane().add(btnAddHod);
		
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
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setBackground(new Color(51, 51, 51));
		btnBack.setBounds(1098, 215, 90, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblControlPanel = new JLabel("Control Panel");
		lblControlPanel.setForeground(new Color(255, 255, 255));
		lblControlPanel.setFont(new Font("Laksaman", Font.BOLD, 23));
		lblControlPanel.setBounds(322, 252, 269, 47);
		frame.getContentPane().add(lblControlPanel);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setForeground(Color.GREEN);
		btnBack_1.setBackground(new Color(51, 51, 51));
		btnBack_1.setBounds(51, 178, 117, 25);
		frame.getContentPane().add(btnBack_1);
		
		btnBack_1.setActionCommand("back");
		
		JLabel lblCompletedSyllabus = new JLabel("Completed");
		lblCompletedSyllabus.setForeground(new Color(255, 255, 255));
		lblCompletedSyllabus.setFont(new Font("Laksaman", Font.BOLD, 35));
		lblCompletedSyllabus.setBounds(322, 336, 294, 67);
		frame.getContentPane().add(lblCompletedSyllabus);
		
		JLabel lblNull = new JLabel("0%");
		lblNull.setForeground(new Color(102, 255, 0));
		lblNull.setFont(new Font("Laksaman", Font.BOLD, 49));
		lblNull.setBounds(555, 362, 219, 125);
		frame.getContentPane().add(lblNull);
		
		JLabel lblSyllabus = new JLabel(" Syllabus:");
		lblSyllabus.setForeground(new Color(255, 255, 255));
		lblSyllabus.setFont(new Font("Laksaman", Font.BOLD, 50));
		lblSyllabus.setBounds(322, 371, 269, 105);
		frame.getContentPane().add(lblSyllabus);
		
		String sub_code = new String();
		c1.test();
		c1.st= (Statement) c1.con.createStatement();
		ResultSet rs= c1.st.executeQuery("select  sub_code from subject where sub_name='"+p1.selectedSub+"'");
		
		while(rs.next())
		{
			sub_code= new String(rs.getString(1));
		}
		System.out.println("subcode:"+sub_code);
		c1.test();
		c1.st= (Statement) c1.con.createStatement();
		ResultSet rs1= c1.st.executeQuery("select percent_completed from progress where sub_code="+sub_code+"");
		
		
		while(rs1.next())
		{
			
			String temp=rs1.getString(1);
			float t = Float.parseFloat(temp);
			String formattedString = String.format("%.02f", t);
			lblNull.setText(formattedString+"%");
		}
		
		
		
		
		
		
		btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        if(s.equals("back"))
        {
        	frame.dispose();
        	try {
				new homePage();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        	}
        });
		
	}
}