package orchestrator.applications;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import orchestrator.mongodb.MongoDBConnection;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author isaac
 */
public class ViewApplications {

    MongoCollection<Document> roomsCollection = MongoDBConnection.roomsCollection;

    // retrieve data from file
    public String applicationView(String userEmail, MongoCollection<Document> pendingOrHistoryCollection) {

        Document query = new Document("userEmail", userEmail);

        Document projection = new Document("roomId", 1).append("status", 1).append("date", 1);

        FindIterable<Document> applications = pendingOrHistoryCollection.find(query).projection(projection);

        StringBuilder response = new StringBuilder();

        for (Document doc : applications) {
            String roomId = doc.getString("roomId");

            ObjectId roomObjectId = new ObjectId(roomId);

            Document roomQuery = new Document("_id", roomObjectId);
            Document room = roomsCollection.find(roomQuery).first(); 

            if (room != null) {
                String roomName = room.getString("name");

                Document simplifiedDoc = new Document("applicationId", doc.getObjectId("_id").toString())
                        .append("roomName", roomName)
                        .append("date", doc.getString("date"))
                        .append("status", doc.getString("status"));

                response.append(simplifiedDoc.toJson()).append(",");
            }
        }

        if (response.length() > 1) {
            response.setLength(response.length() - 1);
        }

        return "[" + response.toString() + "]";
    }
    
    public String adminView(MongoCollection<Document> pendingCollection){
        // query to get all rooms
        StringBuilder result = new StringBuilder();
        FindIterable<Document> documents = pendingCollection.find(); 
        for(Document doc : documents){
            result.append(doc.toJson());
            result.append(",");
        }
        
        if(result.length() > 1){
            result.setLength(result.length() - 1);
        }
        
        return "[" + result.toString() + "]";
    }
}
