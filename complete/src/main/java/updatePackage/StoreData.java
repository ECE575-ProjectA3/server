package updatePackage;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreData {
	
	String url = "jdbc:mysql://universitystudenthousing.cji1dpedv3e5.us-east-1.rds.amazonaws.com:3306/csc540project1";
    String user = "";
    String password = "";
	
	StoreData() {   
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	System.out.println("Where is your MySQL JDBC Driver?");
        	e.printStackTrace();
        }
		System.out.println("Loaded JDBC driver");
	}
	
	public void storeSensorData(CoverageParams cp) {
		try {
			Connection con = null;
			Statement st = null;
			String query = "";
			
			con = DriverManager.getConnection(url, user, password);
		    st = con.createStatement();
		    
		    String carrierName = cp.getNetworkProviderName();
		    if (carrierName.equals("T-Mobile")==true) {
		    	carrierName = "TMobile";
		    }
			
			query = "INSERT INTO "+ carrierName + " ";
			query += "(longitude,latitude,signalStrength,downloadSpeed,uploadSpeed,";
			query += "wifiSignalLevel, wifiDownloadSpeed,wifiUploadSpeed, ts) VALUES (";
			query += cp.getLongitude() + "," + cp.getLatitude() + "," + cp.getSignalLevel() +",";
			query += cp.getDataSpeed() + "," + cp.getDataUploadSpeed() + ",";
			query += cp.getWifiSignalLevel() + "," + cp.getWifiDownloadSpeed() + ",";
			query += cp.getWifiUploadSpeed() + ",'";
			query += cp.getDateTime() + "')";
			
			System.out.println(query);			
		    
		    st.execute(query);	
		    
		    System.out.println("Data has been stored successfully");
		    
		    st.close();
		    con.close();
		} catch (SQLException ex) {
			System.out.println("Unable to perform query operation");
		}		
	}		
}