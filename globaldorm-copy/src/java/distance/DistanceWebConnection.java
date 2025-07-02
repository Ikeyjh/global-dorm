package distance;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author isaac
 */
public class DistanceWebConnection {
    public String httpClientHelper(URL url, DistanceJson distanceJson) throws IOException{
        HttpURLConnection con = null;
        try {
            // create URL Connection 
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            
            if(responseCode == HttpURLConnection.HTTP_OK){
                // read contents 
                return distanceJson.formatJson(con);
                
            } else{
                String errorMessage = "HTTP Error Code " + responseCode + " - Unable to process request.";
                throw new WebApplicationException(errorMessage, Response.status(Response.Status.BAD_REQUEST)
                        .entity(errorMessage).build());
            }   
        } finally {
            if(con != null){
                con.disconnect();
            }
        }
    }
}
