package Java;
import Database.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import Syllabus.*;
import javax.swing.ImageIcon;
public class Administrator {
  
	 
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator window = new Administrator();					
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
	public Administrator() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		Login l1= new Login();
		l1.frame.dispose();
		frame = new JFrame("Administrator Window");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(0, 0, 1366, 768);
		frame.setExtendedState(6);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
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
		
		JButton btnAddTeacher = new JButton("Add User");
		btnAddTeacher.setActionCommand("addT");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s= e.getActionCommand();
			if(s.equals("addT"))
			{
				frame.dispose();
				new AddTeacher();
			}
			}
		});
		btnAddTeacher.setForeground(new Color(255, 255, 255));
		btnAddTeacher.setBackground(new Color(0, 0, 51));
		btnAddTeacher.setBounds(430, 378, 201, 37);
		frame.getContentPane().add(btnAddTeacher);
		
		JButton btnAddSyllabus = new JButton("Add Syllabus");
		btnAddSyllabus.setActionCommand("syll");
		btnAddSyllabus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("syll"))
			{
				frame.dispose();
				new S2();
			}
			}
		});
		btnAddSyllabus.setForeground(new Color(255, 255, 255));
		btnAddSyllabus.setBackground(new Color(0, 0, 51));
		btnAddSyllabus.setBounds(716, 326, 201, 47);
		frame.getContentPane().add(btnAddSyllabus);
		
		JButton btnModifySyllabus = new JButton("Modify Syllabus");
		btnModifySyllabus.setActionCommand("modify");
		btnModifySyllabus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s.equals("modify"))
	 		{
				frame.dispose();
			 try {
				new sModifyWindow();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 		}
			
			}
		});
		btnModifySyllabus.setForeground(new Color(255, 255, 255));
		btnModifySyllabus.setBackground(new Color(0, 0, 51));
		btnModifySyllabus.setBounds(716, 385, 201, 47);
		frame.getContentPane().add(btnModifySyllabus);
		
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
		btnBack.setForeground(new Color(255, 0, 51));
		btnBack.setBackground(new Color(0, 51, 51));
		btnBack.setBounds(1151, 215, 90, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblDataOperatorWindow = new JLabel("");
		lblDataOperatorWindow.setIcon(new ImageIcon("/home/nikhil/eclipse-workspace/Teacher Monitoring System/src/Images/administrator.png"));
		lblDataOperatorWindow.setForeground(new Color(0, 204, 0));
		lblDataOperatorWindow.setBounds(70, 52, 101, 101);
		frame.getContentPane().add(lblDataOperatorWindow);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setActionCommand("dele");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		   String s= e.getActionCommand();
		   if(s.equals("dele"))
		   {
			   frame.dispose();
			  try {
				new DeleteWindow();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   }
			}
		});
		btnDeleteUser.setForeground(new Color(255, 255, 255));
		btnDeleteUser.setBackground(new Color(0, 0, 51));
		btnDeleteUser.setBounds(430, 427, 201, 37);
		frame.getContentPane().add(btnDeleteUser);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(403, 557, 550, 93);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnReportGenerator = new JButton("Report Generator");
		btnReportGenerator.setActionCommand("report");
		btnReportGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  String s=e.getActionCommand();
			  if(s.equals("report"))
			  {
			    frame.dispose();
			    try {
					new Report_all();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  }
					  
			}
		});
		btnReportGenerator.setForeground(new Color(255, 255, 255));
		btnReportGenerator.setBackground(new Color(0, 0, 51));
		btnReportGenerator.setBounds(75, 23, 359, 46);
		panel.add(btnReportGenerator);
		
		JLabel lblControlPanel = new JLabel("Control Panel");
		lblControlPanel.setForeground(new Color(255, 255, 255));
		lblControlPanel.setFont(new Font("Laksaman", Font.BOLD, 23));
		lblControlPanel.setBounds(313, 265, 269, 47);
		frame.getContentPane().add(lblControlPanel);
		
		JButton btnAllocateTeacher = new JButton("Allocate Teacher");
		btnAllocateTeacher.setActionCommand("allocate");
		btnAllocateTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s= e.getActionCommand();
			if(s.equals("allocate"))
			{
				frame.dispose();
				try {
					new AllocateWindow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			}
		});
		btnAllocateTeacher.setForeground(new Color(255, 255, 255));
		btnAllocateTeacher.setBackground(new Color(0, 0, 51));
		btnAllocateTeacher.setBounds(716, 444, 201, 47);
		frame.getContentPane().add(btnAllocateTeacher);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/nikhil/eclipse-workspace/Teacher Monitoring System/src/Images/System-control-panel-icon.png"));
		label.setBounds(186, 236, 119, 101);
		frame.getContentPane().add(label);
		
		JLabel lblWelcome = new JLabel("Welcome "+l1.uname);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblWelcome.setBounds(62, 153, 180, 32);
		frame.getContentPane().add(lblWelcome);
	}
}
