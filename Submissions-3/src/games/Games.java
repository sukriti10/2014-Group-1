package games;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import spree.EventManager;
import common.AccData;


@SuppressWarnings("unused")
public class Games {

	int max_participant;
	int min_participant;
	AccData acc;
	
	

	private static String url = "jdbc:mysql://localhost:3306/Spree";
	EventManager em=new EventManager();


	public Object getDetails() throws SQLException{
		Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
		Statement s = conn.createStatement();
		String query = "Select * from Event where EventManager="+em.getName();
		ResultSet rs = s.executeQuery(query);
		
		Object[][] data = new Object[10][5];

		int i=0;
		if(!rs.wasNull()){
			
		
		while(rs.next()){
			data[i][0] = (String)rs.getString("Name");
			data[i][1] = (String)rs.getString("EventManager");
			data[i][2] = (String)rs.getString("Venue");
			data[i][3] = (String)rs.getString("TimeSlot");
			data[i][4] = (String)rs.getString("TimeDuration");
			data[i][5] = (String)rs.getString("Result");
			
			
			++i;
			
		}
		
		return data;
		}
		else
			return null ;
		
		 
	}
	
	public void setResult(String d,Games game,int status) throws SQLException{
	
		  	
		Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
		Statement s = conn.createStatement();
		
		String query = "UPDATE Event " +
                "SET Results = "+d+" WHERE Name = + "+game.em.getName();
		
		
		ResultSet rs = s.executeQuery(query);

		rs.close();
		 s.close();
		 conn.close();
		
		
	}
	
	
	

}
