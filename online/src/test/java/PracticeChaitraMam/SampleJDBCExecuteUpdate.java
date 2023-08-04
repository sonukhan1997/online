package PracticeChaitraMam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
public static void main(String[] args) throws SQLException {
	Connection con=null;
	
		try {
			Driver driverref=new Driver();
			
			//step 1: register the driver
			DriverManager.registerDriver(driverref);
			
			//step 2: get the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonu ", "root", "root");
			
			//step 3:issue create statement
			Statement state=con.createStatement();
			// step 4: execute a query
			String query="insert into candidateinfo values('raju',20,'banglore')";
			int result=state.executeUpdate(query);
			if(result>=1)
			{
				System.out.println("data added");
			}
			ResultSet resul=state.executeQuery("select * from candidateinfo;");
			while(resul.next())
			{
				System.out.println(resul.getString(1)+" "+resul.getInt(2)+" "+resul.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}