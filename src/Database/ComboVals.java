package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Statement;

public class ComboVals {
  Connect c1= new Connect();
  public ResultSet rs=null;
     public void comboval(String table_name) throws SQLException
     {
    	
    	 c1.test();
    	 c1.st =(Statement) c1.con.createStatement();
    	 String query=new String("select * from "+table_name);
          rs= c1.st.executeQuery(query);
     
        
     }
  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
