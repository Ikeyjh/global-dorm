package geocoding;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Web Service
 *
 * @author isaac
 */
public class Geocoding {

    public Geocoding() {
    }
    
    public String getJson(String postcode) throws MalformedURLException, IOException{
   
        URL url = new URL(" http://api.getthedata.com/postcode/" + postcode);
        
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                
                while((line = in.readLine()) != null){
                    response.append(line);
                }
                
                in.close();
                
                String result = response.toString();
                Gson gson = new Gson();
                
                GeocodingData geocodingData = gson.fromJson(result, GeocodingData.class);
                String latitude = geocodingData.getData().getLatitude();
                String longitude = geocodingData.getData().getLongitude();
                
                List<Object> resultArray = new ArrayList<>();
                resultArray.add("lat:" + latitude);
                resultArray.add("lng:" + longitude);
                return gson.toJson(resultArray);
                
            } else {
                throw new IOException("HTTP Error Code: " + responseCode);
            }
        } finally {
            if(con != null) {
                con.disconnect();
            }
        }
    }
}


