package updatePackage;

class CoverageParams {

    private Double 	longitude;
    private Double 	latitude;
    private Integer signalLevel;
    private String  networkProviderName;
    private Double  dataSpeed;
    private Double  dataUploadSpeed;
    private Integer wifiSignalLevel;
    private Double  wifiDownloadSpeed;
    private Double  wifiUploadSpeed;    
    private String 	dateTime;

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setSignalLevel(Integer signalLevel) {
        this.signalLevel = signalLevel;
    }

    public void setNetworkProviderName(String networkProviderName) { this.networkProviderName = networkProviderName;}

    public void setDataSpeed(Double dataSpeed) { this.dataSpeed = dataSpeed;}
    
    public void setDataUploadSpeed(Double dataUploadSpeed) { this.dataUploadSpeed = dataUploadSpeed;}
    
    public void setWifiSignalLevel(Integer wifiSignalLevel) { this.wifiSignalLevel = wifiSignalLevel;}
    
    public void setWifiDownloadSpeed(Double wifiDownloadSpeed) { this.wifiDownloadSpeed = wifiDownloadSpeed;}
    
    public void setWifiUploadSpeed(Double wifiUploadSpeed) { this.wifiUploadSpeed = wifiUploadSpeed;}

    public void setDateTime(String dateTime) {this.dateTime = dateTime;}

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Integer getSignalLevel() {
        return signalLevel;
    }

    public String getNetworkProviderName() {return networkProviderName;}

    public Double getDataSpeed() { return dataSpeed;}
    
    public Double getDataUploadSpeed() { return dataUploadSpeed; }
    
    public Integer getWifiSignalLevel() { return wifiSignalLevel; }
    
    public Double getWifiDownloadSpeed() { return wifiDownloadSpeed;}
    
    public Double getWifiUploadSpeed() { return wifiUploadSpeed;}

    public String getDateTime() { return dateTime;}
}