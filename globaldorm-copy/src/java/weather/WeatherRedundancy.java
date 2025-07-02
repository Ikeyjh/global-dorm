package weather;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.QueryParam;
import utilities.ResponseString;

/**
 *
 * @author isaac
 */
public class WeatherRedundancy {
    public String response(@QueryParam("lon")String lon, 
            @QueryParam("lat")String lat) throws MalformedURLException, ProtocolException, IOException {
        
        Gson gson = new Gson();
        
        URL url = new URL(" https://api.open-meteo.com/v1/forecast?" + "latitude=" + lat + "&longitude=" + lon + "&hourly=temperature_2m");
        
        HttpURLConnection con = null;
        
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        
        ResponseString responseString = new ResponseString();
        StringBuilder jsonResponse = responseString.responseToString(con);
        
        WeatherRedundancyData weatherData = gson.fromJson(jsonResponse.toString(), WeatherRedundancyData.class);
        
        // get average time and temperature
        List<String> time = weatherData.getHourly().getTime();
        List<Double> temp = weatherData.getHourly().getTemperature2m();
        
        // calculate averages
        WeatherRedundancyCalculations weatherCalc = new WeatherRedundancyCalculations();
        ArrayList<String> days = (ArrayList<String>) weatherCalc.getDay(time);
        List<Double> temps = weatherCalc.getTemp(days, temp);
        Map<String, Double> dayTemps = weatherCalc.mapDayTemps(days, (ArrayList<Double>) temps);
        
        StringBuilder result = new StringBuilder();
        result.append("{\"type\": \"redundant\",\n");
        for(Map.Entry<String, Double> entry : dayTemps.entrySet()){
            result.append("\"").append(entry.getKey()).append("\": ").append(entry.getValue()).append(",\n");
        }
        
        if (!dayTemps.isEmpty()) {
            result.deleteCharAt(result.length() - 2);
            result.deleteCharAt(result.length() - 1);  
        }
        
        result.append("}");
        
        return result.toString();
    }
}
