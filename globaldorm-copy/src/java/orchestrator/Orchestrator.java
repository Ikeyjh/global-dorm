package orchestrator;

import com.mongodb.client.MongoCollection;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import orchestrator.applications.EditApplications;
import orchestrator.applications.ViewApplications;
import orchestrator.apply.RoomApply;
import crime.Crime;
import distance.Distance;
import geocoding.Geocoding;
import java.text.ParseException;
import orchestrator.mongodb.MongoDBConnection;
import orchestrator.rooms.GetRooms;
import orchestrator.search.RoomSearchFiltering;
import orchestrator.user.SignUp;
import org.bson.Document;
import weather.Weather;

/**
 * REST Web Service
 *
 * @author isaac
 */
@Path("orchestrator")
public class Orchestrator {
    
    MongoCollection<Document> pendingCollection = MongoDBConnection.pendingCollection;
    MongoCollection<Document> historyCollection = MongoDBConnection.historyCollection;
    
    // sign up for accommodation
    @POST
    @Path("signup")
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUp(String data) throws IOException{ 
        SignUp sign = new SignUp();
        return sign.signUp(data);
    }

    // apply for accommodation
    @POST
    @Path("apply")
    @Produces(MediaType.APPLICATION_JSON)
    // change to public Response when finised testing 
    public String roomApply(String data) throws IOException{ 
        RoomApply roomApply = new RoomApply();
        return roomApply.applyForRoom(data); 
    }
    
    // user view applications
    @GET
    @Path("pending")
    public String applicationView(@QueryParam("userEmail")String userEmail){
        ViewApplications viewApplications = new ViewApplications();
        String applications = viewApplications.applicationView(userEmail, pendingCollection);
        return applications;
    }
    
    // show all applications for admin
    @GET
    @Path("admin")
    public String adminView(){
        ViewApplications viewApplications = new ViewApplications();
        String admin = viewApplications.adminView(pendingCollection);
        return admin;
    }
    
    // view history of applications
    @GET
    @Path("history")
    public String historyView(@QueryParam("userEmail")String userEmail ){
        
        ViewApplications viewHistory = new ViewApplications();
        String history = viewHistory.applicationView(userEmail, historyCollection);
        return history;
    }
    
    // edit applications
    @DELETE
    @Path("delete/{applicationId}/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editApplication(@PathParam("applicationId") String applicationId,
            @PathParam("status")String status){
        EditApplications editApplications = new EditApplications();
        return editApplications.editApplication(applicationId, status);
    }
    
    // filter search results
    @GET
    @Path("filter")
    @Produces(MediaType.APPLICATION_JSON)
    public String roomFilter(@QueryParam("query")String query){
        RoomSearchFiltering roomFiltering = new RoomSearchFiltering();
        return roomFiltering.searchRooms(query);
    }
    
    // get available rooms
    @GET
    @Path("rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRooms() {
        GetRooms getRooms = new GetRooms();
        return getRooms.getAvailableRooms();
    }
    
    // call crime api
    @GET
    @Path("crime")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCrime(
            @QueryParam("lng")String lng,
            @QueryParam("lat")String lat) 
            throws IOException {
           
        Crime crime = new Crime();
        return crime.getJson(lng, lat);
    }
    
    // call geocoding api
    @GET
    @Path("geocoding")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGeocoding(@QueryParam("postcode")String postcode) throws MalformedURLException, IOException{
        Geocoding geocoding = new Geocoding();
        return geocoding.getJson(postcode);
    }
    
    // call distance api
    @GET
    @Path("distance")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("coordinates") String coordinates) throws IOException {
        Distance distance = new Distance();
        return distance.getJson(coordinates);
    }
    
    @GET
    @Path("weather")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(
            @QueryParam("lon")String lon, 
            @QueryParam("lat")String lat) 
            throws IOException, ParseException {
        
        Weather weather = new Weather();
        return weather.getJson(lon, lat);
    }  
}
