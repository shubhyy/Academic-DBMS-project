package Database_DML;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Database.*;


public class delete {
  Connect c1= new Connect();
  
  public void delete1(String query) throws SQLException
  {
	  c1.test();
	  c1.st= (Statement) c1.con.createStatement();
	  c1.st.executeUpdate("DELETE FROM user WHERE username='"+query+"'");
  }
  
  
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stb
      delete d= new delete();

	}

}
