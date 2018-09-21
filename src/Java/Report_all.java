package Java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Panel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import Database.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.*;


public class Report_all {

	private JFrame frame;
     Connect c1= new Connect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_all window = new Report_all();
			
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
	public Report_all() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {

		
		frame = new JFrame("Report Generation");
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
        
        JTable table = new JTable();
        
        DefaultTableModel model= new DefaultTableModel();
        String[] cols = {"Subject Code","Total Topic","Completed Topic","Completed Status"};
        JScrollPane scroll = new JScrollPane(table);
	    
        model.setColumnIdentifiers(cols);
	    table.setModel(model);
	    frame.getContentPane().add(scroll);
	   
	    scroll.setBounds(285,246,716,404);
	    
	    JButton btnGeneratePdf = new JButton("Generate PDF");
	    btnGeneratePdf.setActionCommand("report");
	    btnGeneratePdf.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	String s= e.getActionCommand();
	    	if(s.equals("report"))
	    	{
	    		try {
					save_pdf_report();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    	
	    	}
	    });
	    btnGeneratePdf.setBounds(1070, 519, 171, 25);
	    frame.getContentPane().add(btnGeneratePdf);
	    
	    JLabel label = new JLabel("");
	    label.setIcon(new ImageIcon("/home/nikhil/eclipse-workspace/Teacher Monitoring System/src/Images/icon_pdf.png"));
	    label.setBounds(1091, 377, 116, 127);
	    frame.getContentPane().add(label);
	    
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
	    btnBack.setBounds(69, 195, 117, 25);
	    frame.getContentPane().add(btnBack);
	    
	    JLabel lblNewLabel = new JLabel("Report ");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setFont(new Font("Laksaman", Font.BOLD, 57));
	    lblNewLabel.setBounds(34, 329, 233, 137);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel lblGenerator = new JLabel("Generator");
	    lblGenerator.setForeground(Color.WHITE);
	    lblGenerator.setFont(new Font("Lucida Bright", Font.BOLD, 24));
	    lblGenerator.setBounds(59, 418, 171, 66);
	    frame.getContentPane().add(lblGenerator);
	    c1.test();
        c1.st=(com.mysql.jdbc.Statement) c1.con.createStatement();
        ResultSet rs= c1.st.executeQuery("select * from progress");    
       
        while(rs.next())
        {
        	model.addRow(new Object[] {rs.getString("sub_code"),rs.getString("total_topic"),rs.getString("completed_topics"),rs.getFloat("percent_completed")});
        }
        
	}
	
	

    
  Document document = new Document();
   
   public void save_pdf_report() throws DocumentException { 
    	
    	       String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    	       String timeStamp1 = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
    	       
    	       try
   {
     Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS", "root", "root");
         Statement statement = con.createStatement();
         System.out.println(timeStamp);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("SMS/" + timeStamp + "_Record.pdf"));
        document.open();
         PdfPTable table = new PdfPTable(5);
         
         String sql = new String("SELECT * FROM progress");
          String code= new String();
         ResultSet rs = statement.executeQuery(sql);
    
                    PdfPCell cell1 = new PdfPCell(new Paragraph("Subject Name"));
                    PdfPCell cell2 = new PdfPCell(new Paragraph("Subject Code"));
    /* 456 */       PdfPCell cell3 = new PdfPCell(new Paragraph("Total topic"));
    /* 457 */       PdfPCell cell4 = new PdfPCell(new Paragraph("Completed Topics"));
    /* 458 */       PdfPCell cell5 = new PdfPCell(new Paragraph("Percent Completed"));
    
    /*     */ 
    /* 466 */       table.addCell(cell1);
    /* 467 */       table.addCell(cell2);
    /* 468 */       table.addCell(cell3);
    /* 469 */       table.addCell(cell4);
    /* 469 */       table.addCell(cell5);
    
            while (rs.next())
      
            { 
           
    	    code=rs.getString(2);
            
            c1.test();
            c1.st= (com.mysql.jdbc.Statement) c1.con.createStatement();
            
            ResultSet rs1= c1.st.executeQuery("select sub_name from subject where sub_code="+code+"");    
            rs1.next();
            System.out.println("Sub Name"+rs1.getString(1));
            cell1 = new PdfPCell(new Paragraph(rs1.getString("sub_name").toString()));            
            cell2 = new PdfPCell(new Paragraph(rs.getString(2).toString()));
            cell3 = new PdfPCell(new Paragraph(rs.getString(3).toString()));
            cell4 = new PdfPCell(new Paragraph(rs.getString(4).toString()));
            cell5= new PdfPCell(new Paragraph(rs.getString("percent_completed")));
            table.addCell(cell1);
            
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            

            
            
            
          
          
          }
         
          document.addTitle("SMS");
          Paragraph p= new Paragraph();
          final String FONT = "Delicious-SmallCaps.otf";
          FontFactory.register(FONT,"Greek-Regular");
            com.itextpdf.text.Font f = FontFactory.getFont("Greek-Regular", "Cp1253", true);
          f.setSize(37);
          f.setStyle(Font.DIALOG);
          Paragraph p1=new Paragraph("Syllabus Monitoring System",f);
          p1.setAlignment(Paragraph.ALIGN_CENTER);
          p1.setAlignment(Paragraph.ALIGN_CENTER);
          
          final String FONT1 = "Delicious-SmallCaps.otf";
          FontFactory.register(FONT,"Greek-Regular");
          com.itextpdf.text.Font f1 = FontFactory.getFont("Greek-Regular", "Cp1253", true);
          f1.setSize(14);
          Paragraph p2=new Paragraph("Mini Project DBMS",f1);
          p2.setAlignment(Paragraph.ALIGN_CENTER);
          
          Paragraph p3= new Paragraph();
          p3.add("Date: "+timeStamp1);
          p3.setAlignment(Paragraph.ALIGN_RIGHT);
          
          document.add(p1);
          document.add(p2);
          document.add(p3);
          
          document.add(Chunk.NEWLINE);
          
          document.add(table);
                    document.close();
         writer.close();
        con.close();
        JOptionPane.showMessageDialog(null, "PDF Created Sucessfully");  
        }
        catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
       }
      }
}


