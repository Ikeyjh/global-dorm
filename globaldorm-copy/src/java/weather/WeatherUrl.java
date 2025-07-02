package weather;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author isaac
 */
public class WeatherUrl {
    public URL formatUrl(String lon, String lat) throws MalformedURLException{
        // create a Map of URL parameters
        Map<String,String> urlParams = new HashMap<>();
        urlParams.put("lon",lon);
        urlParams.put("lat", lat);
        urlParams.put("lang", "en"); // Add further language support in future
        urlParams.put("unit", "metric");
        urlParams.put("output","json");
        
        // convert parameters to string
        StringBuilder convertedParams = new StringBuilder();
        for(Map.Entry<String, String> entry : urlParams.entrySet()) {
            if(convertedParams.length() > 0){
                convertedParams.append("&");
            }
            convertedParams.append(entry.getKey()).append("=").append(entry.getValue());
        }
        
        // create new URL
        URL url = new URL(" https://www.7timer.info/bin/civillight.php?" + convertedParams.toString());
        return url;
    }
}
