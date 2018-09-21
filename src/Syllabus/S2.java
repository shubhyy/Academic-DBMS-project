package Syllabus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.mysql.jdbc.Statement;

import Database.Connect;
import Java.Administrator;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import Database_DML.*;
public class S2 {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblAs = new JLabel("");
	Connect c1=new Connect();
    insert i1= new insert();	
	static String subcode = new String("null");
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S2 S2 = new S2();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public S2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		


		
		
		frame = new JFrame();
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
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(51, 51, 51));
        btnBack.setActionCommand("back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	 String s=e.getActionCommand();
        	 if(s.equals("back"))
        	 {
        		 frame.dispose();
        		 try {
					new Administrator();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	 }
        	}
        });
        btnBack.setBounds(45, 215, 117, 25);
        frame.getContentPane().add(btnBack);
        
        JComboBox comboBox = new JComboBox();
        
        JButton btnNext = new JButton("Next");
        btnNext.setActionCommand("next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	 String s=e.getActionCommand();
        	 String sv=(String) comboBox.getSelectedItem();
        	 if(s.equals("next"))
        	 {
        	
        		
        		 try {
        			 
        			 if(textField.getText().equals("") || textField_1.getText().equals(""))
        			 {
        			  JOptionPane.showMessageDialog(null, "Error check all fields");
        			 }
        			 else {
					       i1.add("subject", " "+textField.getText()+","+sv+",'"+textField_1.getText()+"'");
				           subcode=textField.getText();
				           frame.dispose();
			        		 new S3();
			        		 
        			 }
        		 
        		 
        		 } catch (SQLException e1) {
					// TODO Auto-generated catch block
        			  JOptionPane.showMessageDialog(null, e1.getMessage());
             		 
        			 e1.printStackTrace();
				
        		 
        		 }
        		 
        		
        		 }
        	}
        });
        btnNext.setBackground(new Color(51, 51, 51));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBounds(829, 613, 155, 25);
        frame.getContentPane().add(btnNext);
        
        JLabel lblAddNewSubject = new JLabel("Add New Subject");
        lblAddNewSubject.setFont(new Font("Laksaman", Font.BOLD, 37));
        lblAddNewSubject.setForeground(new Color(255, 255, 255));
        lblAddNewSubject.setBackground(new Color(51, 51, 51));
        lblAddNewSubject.setBounds(285, 218, 313, 143);
        frame.getContentPane().add(lblAddNewSubject);
        
        JLabel lblSubjectCode = new JLabel("Subject code");
        lblSubjectCode.setForeground(new Color(255, 255, 255));
        lblSubjectCode.setBounds(606, 342, 160, 33);
        frame.getContentPane().add(lblSubjectCode);
        
        JLabel lblSubjectName = new JLabel("Subject Name");
        lblSubjectName.setForeground(new Color(255, 255, 255));
        lblSubjectName.setBounds(605, 429, 117, 25);
        frame.getContentPane().add(lblSubjectName);
        
        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setForeground(new Color(255, 255, 255));
        lblSemester.setBounds(605, 471, 70, 15);
        frame.getContentPane().add(lblSemester);
        
        JLabel label_2 = new JLabel("");
        label_2.setBounds(526, 505, 70, 15);
        frame.getContentPane().add(label_2);
        
        textField = new JTextField();
        textField.setBounds(745, 349, 114, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        textField.setActionCommand("update");
        textField.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	 String s=e.getActionCommand();
        	 String s11= new String(textField.getText());
     		String s12= new String(s11.substring(0,2));
        	 
        	 if(s.equals("update"))
        	 {
        		try {
					c1.test();
					c1.st=(Statement) c1.con.createStatement();
					System.out.println(s12);
					String s1=new String ("select branch from branch where branch_code='"+s12+"'");
					java.sql.ResultSet rs= c1.st.executeQuery(s1);
					while(rs.next())
					{
					   lblAs.setText(rs.getString(1));	
					}
				
        		
        		 
        		
        		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	 }
        	}
        });
        
        textField_1 = new JTextField();
        textField_1.setBounds(745, 431, 114, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
       
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
        comboBox.setBounds(744, 469, 107, 20);
        frame.getContentPane().add(comboBox);
        
        
        lblAs.setFont(new Font("Dialog", Font.BOLD, 13));
        lblAs.setForeground(Color.WHITE);
        lblAs.setBounds(745, 385, 256, 25);
        frame.getContentPane().add(lblAs);
        
        JLabel lblBranch = new JLabel("Selected Branch");
        lblBranch.setForeground(new Color(255, 255, 255));
        lblBranch.setBounds(605, 392, 117, 15);
        frame.getContentPane().add(lblBranch);
        
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(1034, 246, 197, 208);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblBranchCodes = new JLabel("Branch Codes");
        lblBranchCodes.setFont(new Font("Laksaman", Font.BOLD, 13));
        lblBranchCodes.setBounds(52, 12, 97, 58);
        panel.add(lblBranchCodes);
        
        JLabel lblinformationTechnology = new JLabel("10 - I.T.");
        lblinformationTechnology.setBounds(61, 56, 159, 36);
        panel.add(lblinformationTechnology);
        
        JLabel lblCe = new JLabel("11 - C.O.");
        lblCe.setBounds(61, 89, 70, 15);
        panel.add(lblCe);
        
        JLabel lblEtc = new JLabel("12 - E&TC.");
        lblEtc.setFont(new Font("Dialog", Font.BOLD, 12));
        lblEtc.setBounds(60, 109, 70, 15);
        panel.add(lblEtc);
        
        JLabel lblMe = new JLabel("13 - M.E");
        lblMe.setFont(new Font("Dialog", Font.BOLD, 12));
        lblMe.setBounds(60, 128, 70, 15);
        panel.add(lblMe);
        
        JLabel lblCe_1 = new JLabel("14 - C.E");
        lblCe_1.setBounds(59, 146, 70, 15);
        panel.add(lblCe_1);
	}
}
