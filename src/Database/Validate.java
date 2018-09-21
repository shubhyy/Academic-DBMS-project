package Database;
import Java.*;
import java.sql.*;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;
import Teacher_client.*;
public class Validate  {

 Connect c1= new Connect();
 Login l1;

 
        public void Validate1(String username,String passwd,String Utype) throws Exception
        {
   try {
        	System.out.println("Entered in Validate");
        	c1.test();
        	c1.st=(Statement) c1.con.createStatement(); 
        	String query = new String("select * from user where username='"+username+"'and password = '"+passwd+"' and user_type='"+Utype+"'");
        	c1.st = (Statement) c1.con.createStatement();	
        	
        	 ResultSet rs = c1.st.executeQuery(query);
        	     while (rs.next())
        	       {
        	         if ((username.equals(rs.getString("username"))) && (passwd.equals(rs.getString("password"))) && (Utype.equals(rs.getString("user_type"))) )
        	         {
        	         
        	        	
	            		 
        	        	
        	            	 if(Utype.equals("Teacher"))
        	            	 {
        	            		 JOptionPane.showMessageDialog(null, "Teacher Login Successfully");
        	            		 System.out.println("User Verified");
        	            		 l1.frame.dispose();
         	            		
        	            		 new homePage();
        	            		 
        	            	 }else
        	            		 if(Utype.equals("Administrator"))
        	            		 {
        	            		  JOptionPane.showMessageDialog(null, "Administrator Successfully");
        	            		  System.out.println("User Verified");
        	            		  l1.frame.dispose();
        	            		  new Administrator();
        	            		 
        	            		 }else
        	            		 {
        	            		
        	            		
        	            		 }
        	            break;		 
        	            }
        	         else
        	            		 {
        	            			 JOptionPane.showMessageDialog(null, "Login fail");
        	            		 }
        	 
        	         
   
        	       }
        	       
            rs.close();
        	
   }catch(NullPointerException n1)
   {
   
   }
   }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Validate v1= new Validate();
 
	}

}
