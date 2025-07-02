package orchestrator.search;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author isaac
 */
public class RoomDetails {
    private boolean furnished;
    private String[] amenities;
    
    @SerializedName("live_in_landlord")
    private boolean liveInLandlord;
    
    @SerializedName("shared_with")
    private long sharedWith;
    
    @SerializedName("bills_included")
    private boolean billsIncluded;
    
    @SerializedName("bathroom_shared")
    private boolean bathroomShared;

    public boolean getFurnished() { return furnished; }
    public void setFurnished(boolean value) { this.furnished = value; }

    public String[] getAmenities() { return amenities; }
    public void setAmenities(String[] value) { this.amenities = value; }

    public boolean getLiveInLandlord() { return liveInLandlord; }
    public void setLiveInLandlord(boolean value) { this.liveInLandlord = value; }

    public long getSharedWith() { return sharedWith; }
    public void setSharedWith(long value) { this.sharedWith = value; }

    public boolean getBillsIncluded() { return billsIncluded; }
    public void setBillsIncluded(boolean value) { this.billsIncluded = value; }

    public boolean getBathroomShared() { return bathroomShared; }
    public void setBathroomShared(boolean value) { this.bathroomShared = value; }
}
