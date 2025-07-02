package utilities;

/**
 *
 * @author isaac
 */
public class UrlData {
    // Initialise main URL variable
    private String url;
    
    // Initialise coordinates
    private double lon;
    private double lat;
    
    private String profile; // Initialise travel method, e.g. walking or driving
    
    private String lang; // Initialise weather language choice
    
    private String[] coordinates; // Initialise grouped coordinates for Distance service
    
    // Conduct main URL Operation
    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }
    
    // Conduct weather URL Operations
    public String getLang() { return lang; }
    public void setLang(String value) { this.lang = value; }
    
    public String getWeatherUrl() { return " https://www.7timer.info/bin/civillight.php?"; }
    public String getUnit() { return "metric"; }
    public String getOutput() { return "json"; }
         
    // Conduct Distance URL Operations
    public String getProfile() { return profile; } // note, I use "/walking" but will add "/driving"
    public void setProfile(String value) { this.profile = value; }
    
    public String[] getCoordinates() { return coordinates; }
    public void setCoordinates(String[] value) { this.coordinates = value; }
    
    public String getService() { return "routes"; }
    public String getVersion() { return "v1"; }
    public String getAdditional() { return "?overview=false"; } 
    public String getDistanceUrl() { return " http://router.project-osrm.org/"; }
     
    // Conduct Crime URL Operations
    public String getCrimeUrl() { return " https://data.police.uk/api/crimes-street/all-crime?"; }

    // Conduct coordinate operations
    public double getLon() { return lon; } 
    public void setLon(Long value) { this.lon = value; }
    
    public double getLat() { return lat; }
    public void setLat(Long value) { this.lat = value; } 
}
