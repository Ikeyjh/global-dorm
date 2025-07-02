package crime;

import java.io.IOException;
import java.net.URL;

/**
 * REST Web Service
 *
 * @author isaac
 */
public class Crime {

    public Crime() {
    }
    
    public String getJson(String lng, String lat) 
            throws IOException {
           
        // build url
        CrimeUrl crimeUrl = new CrimeUrl();
        URL url = crimeUrl.formatUrl(lat, lng);
       
        CrimeWebConnection webConnection = new CrimeWebConnection();
        CrimeJson crimeJson = new CrimeJson();
        
        return webConnection.httpClientHelper(url, crimeJson);
    }
}
