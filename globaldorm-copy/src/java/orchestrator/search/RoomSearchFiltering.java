package orchestrator.search;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import orchestrator.mongodb.MongoDBConnection;
import org.bson.conversions.Bson;

public class RoomSearchFiltering {

    MongoCollection<Document> roomsCollection = MongoDBConnection.roomsCollection;

    // search for rooms based on user query
    public String searchRooms(String query) {
        
        Bson filter = Filters.or(
            Filters.regex("name", query, "i"), 
            Filters.regex("location.city", query, "i"),
            Filters.regex("location.county", query, "i"),
            Filters.regex("location.postcode", query, "i")
        );

        // get matching rooms
        List<Document> matchingRooms = new ArrayList<>();
        try (MongoCursor<Document> pointer = roomsCollection.find(filter).iterator()) {
            while (pointer.hasNext()) {
                matchingRooms.add(pointer.next());
            }
        }
       
        Gson gson = new Gson();
        return gson.toJson(matchingRooms);
    }
}
