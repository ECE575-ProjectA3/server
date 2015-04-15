package updatePackage;

public class VisualParams {
	private double latitude;
	private double longitude;
	private Number dataValue;
	private String dataType;
	private String time;
	
	/*
	 * Create a new VisualParams object
	 */
	VisualParams(double latitude, double longitude, 
			Number dataValue, String dataType, String time) {
		
		setLatitude(latitude);
		setLongitude(longitude);
		setDataValue(dataValue);
		setDataType(dataType);
		setTime(time);
	}
	VisualParams() {}
	
	public void setLatitude(double latitude){
		this.latitude = latitude;
	}
	public void setLongitude(double longitude){
		this.longitude = longitude;
	}
	public void setDataValue(Number dataValue) {
		this.dataValue = dataValue;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	public double getLongitude() {
		return this.longitude;
	}
	public Number getDataValue() {
		return this.dataValue;
	}
	public String getDataType() {
		return this.dataType;
	}
	public String getTime() {
		return this.time;
	}
}
