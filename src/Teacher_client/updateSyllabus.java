package Teacher_client;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Connection;
import Database.Connect;
import Database_DML.insert;
import Database_DML.update;
import Java.Login;

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
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class updateSyllabus {

	update u1=new update();
	private JFrame frame;
	private JTextField T_no;
	private JTextField T_name;
	public Login lg;
	homePage p1;
    private JTable table;
    java.sql.PreparedStatement pst;  
	Connect c1=new Connect();
	insert i1= new insert();
	private JTable table_1;
	
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateSyllabus window = new updateSyllabus();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public updateSyllabus() {
	//s.frame.dispose();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
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
        button_1.setBounds(285, 679, 716, 4);
        button_1.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(button_1);
        
        JLabel label_1 = new JLabel("Mini Project - Database Management System");
        label_1.setBounds(598, 136, 441, 67);
        label_1.setForeground(Color.WHITE);
        frame.getContentPane().add(label_1);
        
        JButton button_2 = new JButton("Back");
        button_2.setBounds(48, 186, 117, 25);
        button_2.setActionCommand("back");
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        if(s.equals("back"))
        {
        	frame.dispose();
        	try {
				new subjectMonitor();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        	}
        });
        button_2.setForeground(Color.GREEN);
        button_2.setBackground(SystemColor.textHighlight);
        button_2.setActionCommand("back");
        frame.getContentPane().add(button_2);
        

		JLabel lblControlPanel = new JLabel("");
		lblControlPanel.setForeground(new Color(255, 255, 255));
		lblControlPanel.setFont(new Font("Laksaman", Font.BOLD, 23));
		lblControlPanel.setBounds(295, 252, 200, 47);
		frame.getContentPane().add(lblControlPanel);
		lblControlPanel.setText("Update Topics:");
		
		JLabel lblNewLabel = new JLabel("subname");
		lblNewLabel.setBackground(SystemColor.activeCaptionText);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(931, 284, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setText(p1.selectedSub);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(712, 344, 289, 24);
		comboBox.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
		//comboBox.setForeground(new Color(255,255,255));
		//comboBox.setBackground(new Color(0,0,51));
		comboBox.setToolTipText("Which topic you covered?");
		frame.getContentPane().add(comboBox);
		comboBox.addItem("--Select Topic--");

		try {
			Connect db=new Connect();
			db.test();
			db.st = (com.mysql.jdbc.Statement) db.con.createStatement();
			java.sql.ResultSet rs=db.st.executeQuery("SELECT * FROM SMS.topic,SMS.subject where sub_name='"+p1.selectedSub+"'and subject.sub_code=topic.sub_code and topic.flag=0;");
			while(rs.next())
			{
				String pat = rs.getString(3);
				comboBox.addItem(pat);
			}
			rs.close();
			db.st.close();
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Completed");
		btnNewButton.setActionCommand("completed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=e.getActionCommand();
				String selectedTopic=(String) comboBox.getSelectedItem();
				System.out.println(selectedTopic);
				if(s.equals("completed"))
				{
					try {
						u1.modify("update topic set flag=1 where topic_name='"+selectedTopic+"'");
						new updateSyllabus();
						frame.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					new updateSyllabus();
					frame.dispose();
					
				}
			}
		});
		btnNewButton.setBounds(810, 594, 117, 25);
		frame.getContentPane().add(btnNewButton);
		/*
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBounds(953, 594, 117, 25);
		frame.getContentPane().add(btnUndo);
		btnUndo.setActionCommand("Undo");	
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=e.getActionCommand();
				if(s.equals("Undo"))
				{
					try {
						u1.undoChanges();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();
					new updateSyllabus();
				}
			}
		});
		
		
		
		*/
		
		
		
			
		}
		
		
		
       
	
	
	
	public void tab() throws SQLException
	{
		String[] cols= {"Topic Name","Number of Lecture"}; 
		 table_1 = new JTable();
	        table_1.setBounds(188, 404, 264, 227);
	        frame.getContentPane().add(table_1);
	        JScrollPane scroll= new JScrollPane(table_1);
	        scroll.setBounds(297, 344, 323, 286);
	        frame.getContentPane().add(scroll);
	        DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(cols);  
	        table_1.setModel(model);
	       c1.test();
	        c1.st=(com.mysql.jdbc.Statement) c1.con.createStatement();
	        ResultSet rs= c1.st.executeQuery("SELECT * FROM SMS.topic,SMS.subject where sub_name='"+p1.selectedSub+"'and subject.sub_code=topic.sub_code and flag=0;");
	        
	        while(rs.next())
	        {
	        	model.addRow(new Object[] {rs.getString("topic_name"),rs.getString("topicno_lecture")});

	        }
	        
	        
	}
}