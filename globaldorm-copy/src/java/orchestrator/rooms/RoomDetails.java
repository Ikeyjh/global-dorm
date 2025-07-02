package orchestrator.rooms;

import java.util.List;

/**
 *
 * @author isaac
 */
public class RoomDetails {
    private boolean furnished;
    private List<String> amenities;
    private boolean live_in_landlord;
    private int shared_with;
    private boolean bills_included;
    private boolean bathroom_shared;
    
    public boolean getFurnished(){
        return this.furnished;
    }
    
    public void setFurnished(boolean furnished){
        this.furnished = furnished;
    }
    
    public List<String> getAmenities(){
        return this.amenities;
    }
    
    public void setAmenities(List<String> amenities){
        this.amenities = amenities;
    }
    
    public boolean getLive_in_landlord(){
        return this.live_in_landlord;
    }
    
    public void setLive_in_landlord(Boolean live_in_landlord){
        this.live_in_landlord = live_in_landlord;
    }
    
    public int getShared_with(){
        return this.shared_with;
    }
    
    public void setShared_with(int shared_with){
        this.shared_with = shared_with;
    }
    
    public boolean getBills_included(){
        return this.bills_included;
    }
    
    public void setBills_included(boolean bills_included){
        this.bills_included = bills_included;
    }
    
    public boolean getBathroom_shared(){
        return this.bathroom_shared;
    }
    
    public void setBathroomShared(boolean bathroom_shared){
        this.bathroom_shared = bathroom_shared;
    }
}