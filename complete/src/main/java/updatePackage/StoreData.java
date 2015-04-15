package updatePackage;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		    
		    String carrierName = cp.getCarrierName();
		    if (carrierName.equals("T-Mobile")==true) {
		    	carrierName = "TMobile";
		    }
			
			query = "INSERT INTO "+ carrierName + " ";
			query += "(longitude,latitude,signalStrength,downloadSpeed,uploadSpeed,";
			query += "wifiSignalLevel, wifiDownloadSpeed,wifiUploadSpeed, ts) VALUES (";
			query += cp.getLongitude() + "," + cp.getLatitude() + "," + cp.getSignalStrength() +",";
			query += cp.getDownloadSpeed() + "," + cp.getUploadSpeed() + ",";
			query += cp.getWifiSignalStrength() + "," + cp.getWifiDownloadSpeed() + ",";
			query += cp.getWifiUploadSpeed() + ",'";
			query += cp.getTime() + "')";
			
			System.out.println(query);			
		    
		    st.execute(query);	
		    
		    System.out.println("Data has been stored successfully");
		    
		    st.close();
		    con.close();
		} catch (SQLException ex) {
			System.out.println("Unable to perform query operation");
		}		
	}	
	
	public ArrayList<VisualParams> getData(String carrierName, String dataType) {
		
		ArrayList<VisualParams> vpa = new ArrayList<VisualParams>(); 
		
		if (carrierName.equals("T-Mobile")) {
			carrierName = "TMobile";
		}
		
		try {
			Connection con = null;
			Statement st = null;
			String query = "";
			
			con = DriverManager.getConnection(url, user, password);
		    st = con.createStatement();
		    
		    query = "SELECT * FROM " + carrierName;
		    System.out.println(query);
		    ResultSet rs = st.executeQuery(query);	
		    
		    while (rs.next()) {
		    	Number dataValue;
		    	if(dataType=="signalStrength") {
		    		dataValue = rs.getInt(dataType);
		    	} else {
		    		dataValue = rs.getDouble(dataType);
		    	}
		    	vpa.add(new VisualParams(rs.getDouble("latitude"),rs.getDouble("longitude"),dataValue, dataType, rs.getString("time")));
		    }
		} catch (SQLException ex) {
			System.out.println("Unable to perform query operation");
		}
		return vpa;
	}
}