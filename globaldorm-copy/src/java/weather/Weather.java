package weather;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author isaac
 */
public class Weather {
    
    public Weather() {
    }

    public String getJson(
            @QueryParam("lon")String lon, 
            @QueryParam("lat")String lat) 
            throws IOException, ParseException {
 
        // format url
        WeatherUrl weatherUrl = new WeatherUrl();
        URL url = weatherUrl.formatUrl(lon, lat);
        
        WeatherJson weatherJson = new WeatherJson();
        
        WeatherWebConnection webConnection = new WeatherWebConnection();
        return webConnection.httpClientHelper(url, weatherJson, lon, lat);
    }     
}


