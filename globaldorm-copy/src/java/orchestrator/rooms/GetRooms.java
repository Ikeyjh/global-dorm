package orchestrator.rooms;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import orchestrator.mongodb.MongoDBConnection;
import org.bson.Document;

public class GetRooms {
    
    MongoCollection<Document> roomsCollection = MongoDBConnection.roomsCollection;
    
    public GetRooms(){ 
    }
      
    public String getAvailableRooms(){
        
        Document query = new Document("available", true);
        
        FindIterable<Document> rooms = roomsCollection.find(query);
     
        StringBuilder result = new StringBuilder();
        
        result.append("[");
        
        boolean first = true;
        for(Document room : rooms){
            if(!first){
                result.append(",");
            }
            result.append(room.toJson());
            first = false;
        }
        result.append("]");
        
        return result.toString();
        
    }
}
