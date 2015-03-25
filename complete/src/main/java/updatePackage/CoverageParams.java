package updatePackage;

class CoverageParams {

    private double longitude;
    private double latitude;
    private int    signalLevel;
    private String networkProviderName;
    private double dataSpeed;

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
}