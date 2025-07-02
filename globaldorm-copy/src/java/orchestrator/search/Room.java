package orchestrator.search;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author isaac
 */
public class Room {
    private long id;
    private String name;
    private RoomLocation location;
    private RoomDetails details;
    private double distance;
    
    @SerializedName("price_per_month_gbp")
    private long pricePerMonthGbp;
    
    @SerializedName("availability_date")
    private String availabilityDate;
    
    @SerializedName("spoken_languages")
    private String[] spokenLanguages;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public RoomLocation getLocation() { return location; }
    public void setLocation(RoomLocation value) { this.location = value; }

    public RoomDetails getDetails() { return details; }
    public void setDetails(RoomDetails value) { this.details = value; }

    public long getPricePerMonthGbp() { return pricePerMonthGbp; }
    public void setPricePerMonthGbp(long value) { this.pricePerMonthGbp = value; }

    public String getAvailabilityDate() { return availabilityDate; }
    public void setAvailabilityDate(String value) { this.availabilityDate = value; }

    public String[] getSpokenLanguages() { return spokenLanguages; }
    public void setSpokenLanguages(String[] value) { this.spokenLanguages = value; }
    
}
