package Database;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Connect {
	public Statement st = null;
	 public Connection con;  
	 public void test() throws SQLException
	    {
		   
		     try {
		          Class.forName("com.mysql.jdbc.Driver");
		          }catch (ClassNotFoundException e) 
		           {
		        	  e.printStackTrace();
			       }
			       
		         System.out.println("Connecting to Database");
			   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS", "root", "root");
			     if (con == null)
			     {
			      System.out.println("connection failed");
			     }
			    else
			    {
			      System.out.println("Database connected");
			    }
			     
			     
	       }
	

   public static void main(String args[]) throws SQLException{  

	   Connect c1 = new Connect();
	   c1.test();
	       }
       }  
   