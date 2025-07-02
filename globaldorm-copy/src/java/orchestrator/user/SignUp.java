package orchestrator.user;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import javax.ws.rs.core.Response;
import orchestrator.mongodb.MongoDBConnection;

public class SignUp {
    
    MongoCollection<Document> usersCollection = MongoDBConnection.usersCollection;

    public Response signUp(String data) {
        try {
            Gson gson = new Gson();
            SignupData signupData = gson.fromJson(data, SignupData.class);

            Document userDocument = new Document()
                    .append("first_name", signupData.getFname())
                    .append("last_name", signupData.getLname())
                    .append("phone", signupData.getPhone())
                    .append("email", signupData.getEmail())
                    .append("postcode", signupData.getPostcode());

            usersCollection.insertOne(userDocument);

            return Response.status(Response.Status.CREATED)
                    .entity("user registered successfully")
                    .build();

        } catch (JsonSyntaxException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("error: " + e.getMessage())
                    .build();
        }
    }
}