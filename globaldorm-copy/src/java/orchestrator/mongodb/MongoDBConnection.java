package orchestrator.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {
    
    // connection URI for MongoDB on Atlas
    private static final String URI ="PLACEHOLDER";
    
    private static final MongoClient mongoClient;
    private static final MongoDatabase database;
    
    public static final MongoCollection<Document> pendingCollection;
    public static final MongoCollection<Document> historyCollection;
    public static final MongoCollection<Document> usersCollection;
    public static final MongoCollection<Document> roomsCollection;

    static {
        mongoClient = new MongoClient(new MongoClientURI(URI));
        database = mongoClient.getDatabase("globaldorm");
        
        pendingCollection = database.getCollection("applications");
        historyCollection = database.getCollection("history");
        usersCollection = database.getCollection("users");
        roomsCollection = database.getCollection("rooms");
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static MongoClient getClient() {
        return mongoClient;
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
