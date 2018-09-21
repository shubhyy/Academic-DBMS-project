package Database_DML;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Database.*;
public class update {
 Connect c1=new Connect();
	
	 public void add(String table_name,String arguments,String condition) throws SQLException 
	 {
		 
		 String query= new String("UPDATE "+table_name+" SET "+arguments+" WHERE "+condition+"");
		 System.out.println(arguments);
		 c1.test();
		 c1.st=(Statement) c1.con.createStatement();
		 c1.st.executeUpdate(query);
	
	 }

	 
	 
	 public void modify(String query) throws SQLException
	  {
		  try {
		 // savepoint1 = c1.con.setSavepoint("Savepoint1");
		  c1.test();
		  c1.st= (Statement) c1.con.createStatement();
		  c1.st.executeUpdate(query);
		  c1.con.commit();
		  }catch(SQLException e)
		  {
			  c1.con.rollback();
		  }
	  }
	
	public static void main(String[] args) {
	   update i1 = new update();
	    

	}

}
