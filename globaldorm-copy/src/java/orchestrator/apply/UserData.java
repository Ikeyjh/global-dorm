package orchestrator.apply;

public class UserData{
    private String userEmail;
    private String roomId;
   
    public String getUserEmail(){
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }
   
    public String getRoomId(){
        return this.roomId;
    }
    
    public void setRoomId(String roomId){
        this.roomId = roomId;
    }  
}