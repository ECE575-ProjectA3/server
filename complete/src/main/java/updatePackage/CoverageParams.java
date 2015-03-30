package updatePackage;

class CoverageParams {

    private double longitude;
    private double latitude;
    private int    signalLevel;
    private String networkProviderName;
    private double dataSpeed;
    private int    month;
    private int    monthDay;
    private int    year;
    private int    hour;
    private int    minute;

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setSignalLevel(int signalLevel) {
        this.signalLevel = signalLevel;
    }

    public void setNetworkProviderName(String networkProviderName) { this.networkProviderName = networkProviderName;}

    public void setDataSpeed(double dataSpeed) { this.dataSpeed = dataSpeed;}

    public void setMonth(int month) {this.month = month;}

    public void setMonthDay(int monthDay) { this.monthDay = monthDay;}

    public void setYear(int year) { this.year = year;}

    public void setHour(int hour) { this.hour = hour;}

    public void setMinute(int minute) {this.minute = minute;}

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getSignalLevel() {
        return signalLevel;
    }

    public String getNetworkProviderName() {return networkProviderName;}

    public double getDataSpeed() { return dataSpeed;}

    public int getMonth() { return month;}

    public int getMonthDay() { return monthDay;}

    public int getYear() { return year;}

    public int getHour() { return hour;}

    public int getMinute() { return minute;}
}