package updatePackage;

public class CoverageParams {
    private double longitude;
    private double latitude;
    private int    signalStrength;
    private String networkProvider;
    private double dataSpeed;
    private int    year;
    private int    month;
    private int    day;
    private int    hour;
    private int    minute;

    public void setLongitude(double longitude)     { this.longitude = longitude;           }
    public void setLatitude(double latitude)       { this.latitude = latitude;             }
    public void setSignalLevel(int signalStrength) { this.signalStrength = signalStrength; }

    public void setNetworkProvider(String networkProvider) { this.networkProvider = networkProvider; }
    public void setDataSpeed(double dataSpeed)             { this.dataSpeed = dataSpeed;             }

    public void setYear(int year)     { this.year = year;     }
    public void setMonth(int month)   { this.month = month;   }
    public void setDay(int day)       { this.day = day;       }
    public void setHour(int hour)     { this.hour = hour;     }
    public void setMinute(int minute) { this.minute = minute; }

    public double getLongitude()      { return longitude;      }
    public double getLatitude()       { return latitude;       }
    public int    getSignalStrength() { return signalStrength; }

    public String getNetworkProvider() { return networkProvider; }
    public double getDataSpeed()       { return dataSpeed;       }

    public int getYear()   { return year;   }
    public int getMonth()  { return month;  }
    public int getDay()    { return day;    }
    public int getHour()   { return hour;   }
    public int getMinute() { return minute; }
}