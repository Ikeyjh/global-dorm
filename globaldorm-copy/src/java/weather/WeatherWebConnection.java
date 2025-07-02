package weather;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

/**
 *
 * @author isaac
 */
public class WeatherWebConnection {
    public String httpClientHelper(URL url, WeatherJson weatherJson, String lon, String lat) throws IOException, ParseException{
        HttpURLConnection con = null;
        try {
            // create connection
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            
            // read contents
            if(responseCode == HttpURLConnection.HTTP_OK){
                return weatherJson.formatJson(con);
            } else{
                // redundancy connection
                WeatherRedundancy weatherRedundancy = new WeatherRedundancy();
                weatherRedundancy.response(lon, lat);
                throw new IOException("HTTP Error Code: " + responseCode);
            }   
        } finally {
            if(con != null){
                con.disconnect();
            }
        }
    }
}
