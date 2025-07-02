package orchestrator.rooms;

import com.google.gson.annotations.SerializedName;
import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author isaac
 */
public class RoomData {
    @SerializedName("_id")
    private ObjectId id;
    private String name;
    private RoomLocation location;
    private RoomDetails details;
    @SerializedName("price_per_month_gbp")
    private int price;
    @SerializedName("spoken_languages")
    private List<String> languages;
    @SerializedName("move_in_date")
    private LocalDate date;
    private boolean available;
    private double distance;
    
    public ObjectId getId(){
        return this.id;
    }
    
    public void setId(ObjectId id){
        this.id = id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public RoomLocation getLocation(){
        return this.location;
    }
    
    public void setLocation(RoomLocation location){
        this.location = location;
    }
    
    public RoomDetails getRoomDetails(){
        return this.details;
    }
    
    public void setRoomDetails(RoomDetails details){
        this.details = details;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public List<String> getLanguages(){
        return this.languages;
    }
    
    public void setLanguages(List<String> languages){
        this.languages = languages;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public void setDate(LocalDate date){
        this.date = date;
    }
    
    public boolean getAvailable(){
        return this.available;
    }
    
    public void setAvailable(boolean available){
        this.available = available;
    }
    
    public double getDistance(){
        return this.distance;
    }
    
    public void setDistance(double distance){
        this.distance = distance;
    }
}
