package updatePackage;

public class VisualParams {
	private double longitude;
	private double latitude;
	private int    signalStrength;
	private int    date;
	private int    time;
	
	public void setLongitude(double longitude)        { this.longitude = longitude;           }
	public void setLatitude(double latitude)          { this.latitude = latitude;             }
	public void setSignalStrength(int signalStrength) { this.signalStrength = signalStrength; }
	public void setDate(int date)                     { this.date = date;                     }
	public void setTime(int time)                     { this.time = time;                     }
	
	public double getLongitude()      { return this.longitude;      }
	public double getLatitude()       { return this.latitude;       }
	public int    getSignalStrength() { return this.signalStrength; }
	public int    getDate()           { return this.date;           }
	public int    getTime()           { return this.time;           }
	
	public static int calcDate(int year, int month, int day) {
		return (year*10000) + (month*100) + (day);
	}
	
	public static int calcTime(int hour, int minute) {
		return (hour*100) + (minute);
	}
}
