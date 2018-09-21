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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import Database.*;
import Database_DML.insert;
public class AllocateWindow {

	private JFrame frame;
	private JTextField textField;
   Connect c1=new Connect();
   ComboVals cv1=new ComboVals();
   insert i1=new insert();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllocateWindow window = new AllocateWindow();
					
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
	public AllocateWindow() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame("Teacher allocation system");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(0, 0, 1360, 759);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(6);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        JLabel label = new JLabel("");
        label.setForeground(Color.WHITE);
        
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
        btnBack.setBounds(53, 215, 117, 25);
        frame.getContentPane().add(btnBack);
        
        JLabel lblTeacherName = new JLabel("Teacher Name");
        lblTeacherName.setForeground(new Color(255, 255, 255));
        lblTeacherName.setBounds(500, 382, 134, 30);
        frame.getContentPane().add(lblTeacherName);
        
        JLabel lblSubjectCode = new JLabel("Subject Code");
        lblSubjectCode.setForeground(new Color(255, 255, 255));
        lblSubjectCode.setBounds(500, 424, 145, 41);
        frame.getContentPane().add(lblSubjectCode);
        
        JLabel lblTotalLectures = new JLabel("Total Lectures");
        lblTotalLectures.setForeground(new Color(255, 255, 255));
        lblTotalLectures.setBounds(500, 477, 152, 41);
        frame.getContentPane().add(lblTotalLectures);
        
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(new Color(102, 102, 102));
        comboBox.setForeground(new Color(255, 255, 255));
        comboBox.setBounds(662, 385, 190, 24);
        frame.getContentPane().add(comboBox);
	    cv1.comboval("user");
		while(cv1.rs.next())
		{
		  comboBox.addItem(cv1.rs.getString(1));	
		}
       
        
        
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBackground(new Color(102, 102, 102));
        comboBox_1.setForeground(new Color(255, 255, 255));
        comboBox_1.setBounds(663, 432, 189, 24);
        frame.getContentPane().add(comboBox_1);
        cv1.comboval("subject");
        while(cv1.rs.next())
        {
        	comboBox_1.addItem(cv1.rs.getString(1));
        }
        comboBox_1.setActionCommand("update");
        comboBox_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	String s= e.getActionCommand();
        	String traceitem=new String((String) comboBox_1.getSelectedItem());
        	if(s.equals("update"))
        	{
              try {
				c1.test();
			
              c1.st=(Statement) c1.con.createStatement();
              ResultSet rs = c1.st.executeQuery("select sub_name from subject where sub_code="+traceitem);
        	 while(rs.next())
        	 {
        		label.setText(rs.getString(1));	
        	 }
        	}
        	
        	 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		     	}
        	 }
        	}
        });
        
        
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setActionCommand("submit");
        btnSubmit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	 String s= e.getActionCommand();
        	 String Tname = new String((String) comboBox.getSelectedItem());
        	 String subject=new String((String) comboBox_1.getSelectedItem());
        	 
        	 if(s.equals("submit"))
        	 {
        	    try {
					i1.add("allocation",""+subject+",'"+Tname+"',"+textField.getText()+"");
				    JOptionPane.showMessageDialog(null,Tname+" is Allocated for"+subject);
        	    } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	 
        	 }
        	
        	}
        });
        btnSubmit.setForeground(new Color(204, 204, 204));
        btnSubmit.setBackground(new Color(51, 51, 51));
        btnSubmit.setBounds(705, 550, 117, 25);
        frame.getContentPane().add(btnSubmit);
        
        JLabel lblTeacherAllocation = new JLabel("Teacher Allocation");
        lblTeacherAllocation.setForeground(new Color(255, 255, 255));
        lblTeacherAllocation.setFont(new Font("Laksaman", Font.BOLD, 37));
        lblTeacherAllocation.setBounds(295, 236, 472, 74);
        frame.getContentPane().add(lblTeacherAllocation);
        
        textField = new JTextField();
        textField.setBounds(662, 488, 114, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnClear = new JButton("Clear");
          btnClear.setActionCommand("clr");
          
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	String s= e.getActionCommand();
        	if(s.equals("clr"))
        	{
        		textField.setText("");
        		
        	}
        	
        	
        	}
        });
        btnClear.setForeground(new Color(204, 0, 0));
        btnClear.setBackground(new Color(51, 51, 51));
        btnClear.setBounds(552, 550, 117, 25);
        frame.getContentPane().add(btnClear);
        
       
        label.setBounds(870, 424, 277, 41);
        frame.getContentPane().add(label);
	}
}
