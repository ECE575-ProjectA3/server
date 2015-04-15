package updatePackage;

import java.sql.Statement;
//import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreData {
	
	//database field names
	public static final String LATITUDE				= "latitude";
	public static final String LONGITUDE			= "longitude";
	public static final String DATETIME				= "dateTime";
	public static final String SIGNALSTRENGTH		= "signalStrength";
	public static final String DOWNLOADSPEED		= "downloadSpeed";
	public static final String UPLOADSPEED			= "uploadSpeed";
	public static final String WIFISIGNALSTRENGTH	= "wifiSignalStrength";
	public static final String WIFIDOWNLOADSPEED	= "wifiDownloadSpeed";
	public static final String WIFIUPLOADSPEED		= "wifiUploadSpeed";
	
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
	
	/*
	 * Fetch filtered data from the specified table
	 */
	public ArrayList<VisualParams> getData(String carrierName, String dataType, String minDate, String maxDate, String minTime, String maxTime) {
		
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
		    
		    //filter results by date and time
		    query = "SELECT * FROM "+carrierName+
		    		" WHERE "+DATETIME+" > " + minDate + " AND "+DATETIME+" <= DATEADD(day,1," + maxDate + ")" +
		    		" AND DATEPART(hh,"+DATETIME+") >= " + minTime +
		    		" AND DATEPART(hh,"+DATETIME+") <= " + maxTime;
		    
		    System.out.println(query);
		    ResultSet rs = st.executeQuery(query);
		    
		    while (rs.next()) {
		    	Number dataValue;
		    	if(dataType==SIGNALSTRENGTH || dataType==WIFISIGNALSTRENGTH) {
		    		dataValue = rs.getInt(dataType);
		    	} else {
		    		dataValue = rs.getDouble(dataType);
		    	}
		    	vpa.add(new VisualParams(rs.getDouble(LATITUDE),rs.getDouble(LONGITUDE),
		    			dataValue, dataType, rs.getString(DATETIME)));
		    }
		} catch (SQLException ex) {
			System.out.println("Unable to perform query operation");
		}
		return vpa;
	}
	public ArrayList<VisualParams> getData(String carrierName, String dataType, String minDate, String maxDate) {
		return getData(carrierName,dataType,minDate,maxDate,RequestController.DEFAULT_MIN_TIME,RequestController.DEFAULT_MAX_TIME);
	}
	public ArrayList<VisualParams> getData(String carrierName, String dataType) {
		return getData(carrierName,dataType,RequestController.DEFAULT_MIN_DATE,RequestController.DEFAULT_MAX_DATE);
	}
}