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
import javax.swing.JToggleButton;
import Database.*;
import Database_DML.update;

import javax.swing.DefaultComboBoxModel;
public class sModifyWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    ComboVals cv1= new ComboVals(),cv2=new ComboVals(); 
    Connect c1=new Connect();
    JComboBox comboBox_1 = new JComboBox();
    String tid=new String();
    private JTextField textField_3;
    update u1=new update();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sModifyWindow window = new sModifyWindow();
					
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
	public sModifyWindow() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
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
        	String s= e.getActionCommand();
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
        btnBack.setBounds(51, 217, 117, 25);
        frame.getContentPane().add(btnBack);
        
        JLabel lblSelectSubject = new JLabel("Select Subject");
        lblSelectSubject.setForeground(Color.WHITE);
        lblSelectSubject.setBounds(305, 396, 220, 74);
        frame.getContentPane().add(lblSelectSubject);
       
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Select Subject-"}));
        comboBox.setBounds(460, 421, 139, 24);
        frame.getContentPane().add(comboBox);
        cv1.comboval("subject");
        while(cv1.rs.next())
        {
        	comboBox.addItem(cv1.rs.getString(1));
        }
        
        
        JLabel lblModifySyllabus = new JLabel("Modify Syllabus");
        lblModifySyllabus.setForeground(Color.WHITE);
        lblModifySyllabus.setFont(new Font("Laksaman", Font.BOLD, 37));
        lblModifySyllabus.setBounds(295, 236, 426, 118);
        frame.getContentPane().add(lblModifySyllabus);
        
        JLabel lblSelectTopic = new JLabel("Select Topic");
        lblSelectTopic.setForeground(Color.WHITE);
        lblSelectTopic.setBounds(305, 454, 128, 44);
        frame.getContentPane().add(lblSelectTopic);
     comboBox.setActionCommand("up");
    comboBox.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s11=e.getActionCommand();
			int count=0;
			if(s11.equals("up"))
			{
				comboBox_1.removeAllItems();
				String subcode= new String((String) comboBox.getSelectedItem());
				try {
					
				c1.test();
				c1.st=(Statement) c1.con.createStatement();
				ResultSet rs1;
					rs1 = c1.st.executeQuery("select topic_id from topic where sub_code="+subcode+"");
			
			   while(rs1.next())
			   {
				   comboBox_1.addItem(rs1.getString(1));
			     
				   count++;
			   }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(count==0)
				{
					JOptionPane.showMessageDialog(null, "No Topics for "+subcode);
				}	
			}
			
			
				
			
		}
	});
        JLabel lblTopicId = new JLabel("Topic ID");
        lblTopicId.setForeground(Color.WHITE);
        lblTopicId.setBounds(654, 366, 137, 44);
        frame.getContentPane().add(lblTopicId);
        
        textField = new JTextField();
        textField.setBounds(778, 378, 114, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblTopicName = new JLabel("Topic Name");
        lblTopicName.setForeground(Color.WHITE);
        lblTopicName.setBounds(654, 438, 117, 15);
        frame.getContentPane().add(lblTopicName);
        
        textField_1 = new JTextField();
        textField_1.setBounds(778, 436, 114, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(779, 532, 114, 19);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblTotalLectures = new JLabel("Total Lectures");
        lblTotalLectures.setForeground(Color.WHITE);
        lblTotalLectures.setBounds(654, 519, 128, 45);
        frame.getContentPane().add(lblTotalLectures);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setActionCommand("up3");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
          String s=e.getActionCommand();
          if(s.equals("up3"))
          {
        	  String c1= new String((String) comboBox.getSelectedItem());
        	  String c2= new String((String) comboBox_1.getSelectedItem());
        	  if(c1.equals("-Select Subject-") || c2.equals("-Select topic-") || textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals(""))
        	  {
        		  JOptionPane.showMessageDialog(null, "Check all values");
        	  }else
        	  {
        		  try {
					u1.add("topic","topic_name='"+textField_1.getText()+"',flag="+textField_3.getText()+",topicno_lecture="+textField_2.getText()+"","topic_id="+textField.getText()+"");
				  JOptionPane.showMessageDialog(null, "Record Updated Sucessfully");
        		  } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	  }
          }
        	
        	}
        });
        btnUpdate.setBounds(818, 605, 117, 25);
        frame.getContentPane().add(btnUpdate);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-Select topic-"}));
        
     
        comboBox_1.setBounds(460, 464, 139, 25);
        frame.getContentPane().add(comboBox_1);
        comboBox_1.setActionCommand("update1");
        
        JLabel lblFlag = new JLabel("Flag");
        lblFlag.setForeground(Color.WHITE);
        lblFlag.setBounds(653, 489, 70, 15);
        frame.getContentPane().add(lblFlag);
        
        textField_3 = new JTextField();
        textField_3.setBounds(778, 487, 114, 19);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);
        comboBox_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		String s= e.getActionCommand();
		if(s.equals("update1"))
		{
            tid=(String) comboBox_1.getSelectedItem();
			try {
				c1.test();
				c1.st=(Statement) c1.con.createStatement();
				ResultSet rs3=c1.st.executeQuery("select * from topic where topic_id="+tid+"");
			    while(rs3.next())
			    {
			    	textField.setText(rs3.getString(1));
			    	textField_1.setText(rs3.getString(3));
			    	textField_2.setText(rs3.getString(5));
			    	textField_3.setText(rs3.getString(4));
			    }
			  
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
		}
				
			}
		});
	}
}
