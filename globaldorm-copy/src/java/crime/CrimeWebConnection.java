package crime;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author isaac
 */
public class CrimeWebConnection {
    public String httpClientHelper(URL url, CrimeJson crimeJson) throws IOException{
        HttpURLConnection con = null;
        try {
            // Create URL Connection 
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            
            if(responseCode == HttpURLConnection.HTTP_OK){
                // Read contents
                return crimeJson.formatJson(con);
            } else{
                throw new IOException("HTTP Error Code: " + responseCode);
            }   
        } finally {
            if(con != null){
                con.disconnect();
            }
        }
    }
}
