package crime;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author isaac
 */
public class CrimeUrl {
    public URL formatUrl(String lat, String lng) throws MalformedURLException {
        Map<String, String> urlParams = new LinkedHashMap<>();
        
        urlParams.put("lat", lat);
        urlParams.put("lng", lng);
        
        StringBuilder convertedParams = new StringBuilder();
        for(Map.Entry<String, String> entry : urlParams.entrySet()){
            if(convertedParams.length() > 0){
                convertedParams.append("&");
            }
            convertedParams.append(entry.getKey()).append("=").append(entry.getValue());
        }
        URL url = new URL(" https://data.police.uk/api/crimes-street/all-crime?" + convertedParams.toString());
        return url;
    }
}
