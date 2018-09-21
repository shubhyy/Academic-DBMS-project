package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Java.Confirm_detail;

public class Authentication {
	
   public static int flag=0;
	   public void authenticate(String uname1,String lname1) throws SQLException
	   {
		   Connect c1=new Connect();
		   c1.test();
		   c1.st= (Statement) c1.con.createStatement();
		   String query=new String("select * from user where username='"+uname1+"' and lname='"+lname1+"'");
		  ResultSet rs1=c1.st.executeQuery(query);
		   while(rs1.next())
		   {
			   if(uname1.equals(rs1.getString("username")) && lname1.equals(rs1.getString("lname")));   
			   {
			   System.out.println(rs1.getString("username"));
				 System.out.println(rs1.getString("lname"));
				 flag=1;
			    break;
			   }	
		   }
		   
		   
		   
		   
	   }
	
	

 public static void main(String args[])
 {
	 
 }

}
