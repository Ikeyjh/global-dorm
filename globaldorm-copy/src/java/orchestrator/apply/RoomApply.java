package orchestrator.apply;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import orchestrator.mongodb.MongoDBConnection;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author isaac
 */
public class RoomApply {
    
    
    MongoCollection<Document> userCollection = MongoDBConnection.usersCollection;
    MongoCollection<Document> pendingCollection = MongoDBConnection.pendingCollection;
    
    public String applyForRoom(String data) {
        
        Gson gson = new Gson();
        UserData userData = gson.fromJson(data, UserData.class);
        
        String userEmail = userData.getUserEmail();
        
        Document user = userCollection.find(Filters.eq("email", userEmail)).first();
       
        if(user != null){
            ObjectId userId = user.getObjectId("_id");
            String uid = userId.toHexString();
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = currentDate.format(formatter);
            String status = "pending";
            String roomId = userData.getRoomId();
            
            Document applicationDocument = new Document("userId", uid)
                .append("roomId", roomId)
                .append("userEmail", userEmail)
                .append("date", date)
                .append("status", status);
            
            pendingCollection.insertOne(applicationDocument);
                
            return "{\"success\": \"application submitted successfully\"}";
        } else {
            return "{\"failure\": \"submission failed\"}";
        }
    }
}
