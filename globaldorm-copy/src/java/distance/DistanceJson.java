package distance;

import com.google.gson.Gson;
import utilities.ResponseString;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 *
 * @author isaac
 */
public class DistanceJson {
    public String formatJson(HttpURLConnection con) throws IOException{
        
        ResponseString responseString = new ResponseString();
        StringBuilder responseJson = responseString.responseToString(con);
        
        Gson gson = new Gson();
        DistanceData data = gson.fromJson(responseJson.toString(), DistanceData.class);
        
        DistanceRoute[] routes = data.getRoutes();
       
        String distance = String.valueOf(routes[0].getDistance());
        return distance;
    }
}
