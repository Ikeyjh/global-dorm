package crime;

public class CrimeLocation {
    private String latitude;
    private CrimeStreet street;
    private String longitude;

    public String getLatitude() { return latitude; }
    public void setLatitude(String value) { this.latitude = value; }

    public CrimeStreet getStreet() { return street; }
    public void setStreet(CrimeStreet value) { this.street = value; }

    public String getLongitude() { return longitude; }
    public void setLongitude(String value) { this.longitude = value; }
}