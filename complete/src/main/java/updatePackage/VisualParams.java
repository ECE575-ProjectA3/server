package updatePackage;

public class VisualParams {
	private double 	longitude;
	private double 	latitude;
	private int		signalStrengthLevel;
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public void setSignalStrengthLevel(int signalStrengthLevel) {
		this.signalStrengthLevel = signalStrengthLevel;
	}
	
	public double getLongtitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public int getSignalStrengthLevel() {
		return signalStrengthLevel;
	}

}
