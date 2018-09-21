package Database_DML;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Database.*;
public class insert {
 Connect c1=new Connect();
	
	 public void add(String tbname ,String arguments) throws SQLException 
	 {
		 
		 String query= new String("insert into "+tbname+" values("+arguments+")");
		 System.out.println(arguments);
		 c1.test();
		 c1.st=(Statement) c1.con.createStatement();
		 c1.st.executeUpdate(query);
	
	 }
	
	
	public static void main(String[] args) {
	   insert i1 = new insert();
	    

	}

}
