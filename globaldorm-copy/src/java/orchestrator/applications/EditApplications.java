package orchestrator.applications;

import com.mongodb.client.MongoCollection;
import javax.ws.rs.core.Response;
import orchestrator.mongodb.MongoDBConnection;
import org.bson.Document;
import org.bson.types.ObjectId;

public class EditApplications {

    private static final MongoCollection<Document> pendingCollection = MongoDBConnection.pendingCollection;
    private static final MongoCollection<Document> historyCollection = MongoDBConnection.historyCollection;
    private static final MongoCollection<Document> roomCollection = MongoDBConnection.roomsCollection;
    
    public Response editApplication(String applicationId, String status) {
        try {
            
            Document query = new Document("_id", new ObjectId(applicationId));

            // find application to delete
            Document appToEdit = pendingCollection.find(query).first();

            if (appToEdit != null) {
                // if accepted, change room availability to false
                if("accepted".equals(status)){
                    String roomId = appToEdit.getString("roomId");
                    ObjectId objectId = new ObjectId(roomId);
                    Document roomQuery = new Document("_id", objectId);
                    Document room = roomCollection.find(roomQuery).first();
                    
                    Document update = new Document("$set", new Document("available", false));
                    roomCollection.updateOne(roomQuery, update);
                }
                
                // remove from applications then add to history
                appToEdit.put("status", status);
                historyCollection.insertOne(appToEdit);

                // delete the document from the applications collection
                pendingCollection.deleteOne(query);

                return Response.ok("{\"success\": true, \"message\": \"Application deleted and archived successfully.\"}")
                        .build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"success\": false, \"message\": \"Application not found.\"}")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"success\": false, \"message\": \"An error occurred.\"}")
                    .build();
        }
    }
}
