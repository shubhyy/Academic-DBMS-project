package Syllabus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Database.Connect;
import Database_DML.insert;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;

public class S3 {

	private JFrame frame;
	private JTextField T_no;
	private JTextField T_name;
    S2 s= new S2();
    private JTable table;
    java.sql.PreparedStatement pst;  
	Connect c1=new Connect();
	insert i1= new insert();
	private JTable table_1;
	private JTextField textField;
	
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S3 window = new S3();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public S3() {
	s.frame.dispose();
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
    	frame.setVisible(true);
        frame.getContentPane().setLayout(null);
        try {
			tab();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(973, 284, 317, 326);
        lblNewLabel.setIcon(new ImageIcon("/home/nikhil/eclipse-workspace/Teacher Monitoring System/src/Images/Martz90-Circle-Books.png"));
        frame.getContentPane().add(lblNewLabel);
    	
        JLabel lblSyllabusMonitoringSystem = new JLabel("Syllabus Monitoring System");
        lblSyllabusMonitoringSystem.setBounds(333, 12, 961, 208);
        lblSyllabusMonitoringSystem.setForeground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
        lblSyllabusMonitoringSystem.setFont(new Font("Sawasdee", Font.BOLD, 48));
        lblSyllabusMonitoringSystem.setBackground(UIManager.getColor("Button.foreground"));
        frame.getContentPane().add(lblSyllabusMonitoringSystem);
        
        JButton button = new JButton("");
        button.setBounds(285, 236, 716, 4);
        button.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(button);
        
        JButton button_1 = new JButton("");
        button_1.setBounds(285, 662, 716, 4);
        button_1.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(button_1);
        
        JLabel label_1 = new JLabel("Mini Project - Database Management System");
        label_1.setBounds(598, 136, 441, 67);
        label_1.setForeground(Color.WHITE);
        frame.getContentPane().add(label_1);
        
        JButton button_2 = new JButton("Back");
        button_2.setBounds(51, 232, 117, 25);
        button_2.setActionCommand("back");
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        if(s.equals("back"))
        {
        	frame.dispose();
        	new S2();
        }
        	}
        });
        button_2.setForeground(Color.WHITE);
        button_2.setBackground(new Color(51, 51, 51));
        button_2.setActionCommand("back");
        frame.getContentPane().add(button_2);
        
        JLabel lblTopicsForNew = new JLabel("Add new Topics for "+s.subcode+" Subject");
        lblTopicsForNew.setBounds(295, 248, 650, 82);
        lblTopicsForNew.setForeground(new Color(255, 255, 255));
        lblTopicsForNew.setFont(new Font("Laksaman", Font.BOLD, 37));
        frame.getContentPane().add(lblTopicsForNew);
        
        JLabel lblTopicNumber = new JLabel("Topic number");
        lblTopicNumber.setBounds(572, 352, 165, 31);
        lblTopicNumber.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(lblTopicNumber);
        
        JLabel lblTopicName = new JLabel("Topic name");
        lblTopicName.setBounds(572, 395, 117, 36);
        lblTopicName.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(lblTopicName);
        
        T_no = new JTextField();
        T_no.setBounds(705, 358, 114, 19);
        frame.getContentPane().add(T_no);
        T_no.setColumns(10);
        
        T_name = new JTextField();
        T_name.setBounds(705, 404, 114, 19);
        frame.getContentPane().add(T_name);
        T_name.setColumns(10);
        
        textField = new JTextField();
        textField.setBounds(705, 461, 114, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setActionCommand("submit");
        btnSubmit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	   String s1=e.getActionCommand();
        	   if(s1.equals("submit"))
        	   {
        		   System.out.println("hi");
        		   try {
					i1.add("topic", ""+s.subcode+T_no.getText()+","+s.subcode+",'"+T_name.getText()+"',0,"+textField.getText()+"");  
            	    JOptionPane.showMessageDialog(null,""+T_name.getText()+" added added Sucessfully");
        		    T_no.setText("");
  			        T_name.setText("");
  			        textField.setText("");
          	      
  		 tab();
        		   } catch (SQLException e1) {
					// TODO Auto-generated catch block
        			   JOptionPane.showMessageDialog(null,e1.getMessage());
   					
					e1.printStackTrace();
				}
			    
        	   }
        	
        	}
        });
        btnSubmit.setBounds(620, 544, 117, 25);
        frame.getContentPane().add(btnSubmit);
        
     
       
	}
	
	
	public void tab() throws SQLException
	{
		String[] cols= {"Topic ID","Subject code","Topic Name"}; 
		 table_1 = new JTable();
	        table_1.setBounds(188, 404, 264, 227);
	        frame.getContentPane().add(table_1);
	        JScrollPane scroll= new JScrollPane(table_1);
	        scroll.setBounds(51, 352, 413, 226);
	        frame.getContentPane().add(scroll);
	        DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(cols);  
	        table_1.setModel(model);
	        
	        
	        JLabel lblNumberOfLectures = new JLabel("Number of Lectures ");
	        lblNumberOfLectures.setForeground(Color.WHITE);
	        lblNumberOfLectures.setBounds(542, 443, 174, 54);
	        frame.getContentPane().add(lblNumberOfLectures);
	        
	        JLabel lblForTopic = new JLabel("For topic");
	        lblForTopic.setForeground(Color.WHITE);
	        lblForTopic.setBounds(541, 481, 70, 15);
	        frame.getContentPane().add(lblForTopic);
	   
	        c1.test();
	        c1.st=(com.mysql.jdbc.Statement) c1.con.createStatement();
	        ResultSet rs= c1.st.executeQuery("select * from topic where sub_code="+s.subcode+"");    
	       
	        while(rs.next())
	        {
	        	model.addRow(new Object[] {rs.getString("topic_id"),rs.getString("sub_code"),rs.getString("topic_name")});
	        }
	        
	        
	        
	        
	}
}
