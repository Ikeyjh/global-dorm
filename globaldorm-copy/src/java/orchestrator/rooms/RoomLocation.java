package orchestrator.rooms;

/**
 *
 * @author isaac
 */
public class RoomLocation {
    private String city;
    private String county;
    private String postcode;
    
    public String getCity(){
        return this.city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public String getCounty(){
        return this.county;
    }
    
    public void setCounty(String county){
        this.county = county;
    }
    
    public String getPostcode(){
        return this.postcode;
    }
    
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
}
