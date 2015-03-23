package updatePackage;

public class CoverageParams {
	
	private double longitude;
	private double latitude;
	private int    signalLevel;
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public void setSignalLevel(int signalLevel) {
		this.signalLevel = signalLevel;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public int getSignalLevel() {
		return signalLevel;
	}

}
