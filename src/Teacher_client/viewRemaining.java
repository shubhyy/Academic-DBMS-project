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

public class viewRemaining {

	private JFrame frame;
	private JTextField T_no;
	private JTextField T_name;
	public Login lg;
	homePage p1;
  //  S2 s= new S2();
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
					viewRemaining window = new viewRemaining();
				
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
	public viewRemaining() {
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
        button_2.setBounds(44, 199, 117, 25);
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
        //button_2.setActionCommand("back");
        frame.getContentPane().add(button_2);
        

		JLabel lblControlPanel = new JLabel("");
		lblControlPanel.setForeground(new Color(255, 255, 255));
		lblControlPanel.setFont(new Font("Laksaman", Font.BOLD, 23));
		lblControlPanel.setBounds(295, 252, 200, 47);
		frame.getContentPane().add(lblControlPanel);
		lblControlPanel.setText("Remaining Topics");
		
		JLabel lblNewLabel = new JLabel("subname");
		lblNewLabel.setBackground(SystemColor.activeCaptionText);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(931, 284, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setText(p1.selectedSub);
       
	}
	
	
	public void tab() throws SQLException
	{
		String[] cols= {"Topic Name","Number of Lecture"}; 
		 table_1 = new JTable();
	        table_1.setBounds(188, 404, 264, 227);
	        frame.getContentPane().add(table_1);
	        JScrollPane scroll= new JScrollPane(table_1);
	        scroll.setBounds(404, 311, 470, 340);
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