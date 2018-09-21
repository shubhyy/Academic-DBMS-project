package Java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Database_DML.*;

import com.mysql.jdbc.Statement;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Database.*;

public class DeleteWindow {
  Connect c1= new Connect();
  delete d1= new delete();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteWindow window = new DeleteWindow();
					
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
	public DeleteWindow() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		c1.test();
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
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(51, 51, 51));
        btnBack.setBounds(58, 215, 117, 25);
        frame.getContentPane().add(btnBack);
        
        JLabel lblDeleteUser = new JLabel("Delete User");
        lblDeleteUser.setFont(new Font("Laksaman", Font.BOLD, 37));
        lblDeleteUser.setForeground(new Color(255, 255, 255));
        lblDeleteUser.setBounds(285, 265, 311, 56);
        frame.getContentPane().add(lblDeleteUser);
        
        JLabel lblTeacherName = new JLabel("Teacher name");
        lblTeacherName.setForeground(new Color(255, 255, 255));
        lblTeacherName.setBounds(472, 406, 174, 25);
        frame.getContentPane().add(lblTeacherName);
        
        
        JComboBox comboBox = new JComboBox();
        
        c1.st= (Statement) c1.con.createStatement();
        ResultSet rs= c1.st.executeQuery("select * from user");
        while(rs.next())
        {
        	 comboBox.addItem(rs.getString(1));
        }
        
        comboBox.setBounds(598, 406, 302, 24);
        frame.getContentPane().add(comboBox);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setActionCommand("delete");
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	  String s= e.getActionCommand();
        	  String item= new String((String) comboBox.getSelectedItem());
        	  JComboBox cmb1=new JComboBox();
        	  
        	  System.out.println("String "+item);
        	  if(s.equals("delete"))
        	  {
        		
					  if(comboBox.getSelectedItem()==null)
					  {
						  JOptionPane.showMessageDialog(null," Error Null value can't be deleted ");
						    
					  }else
					  {
        			  try {
				  		  d1.delete1(item);
			              comboBox.removeItemAt(comboBox.getSelectedIndex());
			              JOptionPane.showMessageDialog(null,item+" Deleted Sucessfully ");
					  }catch (SQLException e1) {
				       	// TODO Auto-generated catch block
					    e1.printStackTrace();
					   }
					   }  
        	  }
        	}
        });
        btnDelete.setBounds(598, 496, 117, 25);
        frame.getContentPane().add(btnDelete);
	}
}
