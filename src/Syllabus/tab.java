/*     */ package Syllabus;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
/*     */ 
/*     */ public class tab
/*     */ {
/*     */   JTable table;
/*     */   java.sql.PreparedStatement pst;
/*  14 */   String[] columnNames = { "Student Name", "Roll", "Shift", "Class", "Batch" };
/*     */   String from;
/*     */   java.sql.Connection con;
/*     */   String ids;
/*     */   Statement st;
/*     */   Statement st1;
/*     */   ResultSet rs;
/*     */   ResultSet rs1;
/*     */   JPanel panel = new JPanel();


/*  23 */   public tab() { JFrame frame = new JFrame("Database Search Result");
/*     */    
              panel.setBounds(0, 0, 100, 276);
frame.getContentPane().add(panel);
     
/*  27 */     DefaultTableModel model = new DefaultTableModel();
/*  28 */     model.setColumnIdentifiers(this.columnNames);
/*     */     
/*     */ 
/*  31 */     this.table = new JTable();
/*  32 */     this.table.setModel(model);
/*  33 */     this.table.setAutoResizeMode(4);
/*  34 */     this.table.setFillsViewportHeight(true);
/*  35 */     JScrollPane scroll = new JScrollPane(this.table);
     scroll.setBounds(0, 0, 100, 300);
/*  36 */     scroll.setHorizontalScrollBarPolicy(
/*  37 */       30);
/*  38 */     scroll.setVerticalScrollBarPolicy(
/*  39 */       20);
/*     */     
/*     */ 
/*     */ 
/*  43 */     String shift = "";
/*  44 */     String cls = "";
/*  45 */     String batch = "";
/*  46 */     String name = "";
/*  47 */     String roll = "";
/*     */     try
/*     */     {
/*  50 */       Class.forName("com.mysql.jdbc.Driver");
/*  51 */       this.con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
/*  52 */       this.st = this.con.createStatement();
/*  53 */       this.st.close();
/*  54 */       this.rs.close();
/*     */     }
/*     */     catch (Exception localException1) {}
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  61 */       this.pst = this.con.prepareStatement("select * from students");
/*  62 */       ResultSet rs = this.pst.executeQuery();
/*  63 */       int i = 0;
/*  64 */       while (rs.next()) {
/*  65 */         name = rs.getString("studname");
/*  66 */         shift = rs.getString("shift");
/*  67 */         cls = rs.getString("class");
/*  68 */         batch = rs.getString("batch");
/*  69 */         roll = rs.getString("roll");
/*     */         
/*     */ 
/*  72 */         model.addRow(new Object[] { name, roll, shift, cls, batch });
/*  73 */         i++;
/*     */       }
/*     */       
/*     */ 
/*  77 */       if (i < 1)
/*     */       {
/*  79 */         javax.swing.JOptionPane.showMessageDialog(null, "No Record Found", "Error", 0);
/*     */       }
/*     */       
/*  82 */       if (i == 1)
/*     */       {
/*  84 */         System.out.println(i + " Record Found");
/*     */       }
/*     */       else
/*     */       {
/*  88 */         System.out.println(i + " Records Found");
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/*  92 */       javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
/*     */     }
/*  94 */      panel.add(scroll);
     
     
     
     /*  95 */     frame.setVisible(true);
/*  96 */     frame.setSize(1200, 600);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 100 */     new tab();
/*     */   }
/*     */ }


/* Location:              D:\Acadamic Data\Final Year Project\JAR\MIT_LAB v.7.3.jar!\View\StudTab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */