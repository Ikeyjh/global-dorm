package weather;

import com.google.gson.Gson;
import utilities.ResponseString;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author isaac
 */
public class WeatherJson {
    public String formatJson(HttpURLConnection con) throws IOException, ParseException{
        // put JSON response in a string
        ResponseString responseString = new ResponseString();
        StringBuilder responseJson = responseString.responseToString(con);
        
        // format json
        Gson gson = new Gson();
        WeatherData weatherData = gson.fromJson(responseJson.toString(), WeatherData.class);
        
        List<Map<String,Object>> relevantData = new ArrayList<>();
        for (WeatherDataseries data : weatherData.getDataseries()) {
            Map<String, Object> dayData = new HashMap<>();
            dayData.put("date", formatDate(String.valueOf(data.getDate())));
            dayData.put("weather", data.getWeather());

            // temperature Details
            Map<String, Long> temp = new HashMap<>();
            
            temp.put("max", data.getTemp2M().getMax());
            temp.put("min", data.getTemp2M().getMin());
            dayData.put("temperature", temp);

            dayData.put("wind10MMax", data.getWind10MMax());

            relevantData.add(dayData);
        }
        return gson.toJson(relevantData);
    }
    
    public String formatDate(String dateStr) throws ParseException{
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        try{
            java.util.Date date = inputFormat.parse(dateStr);
            
            String formattedDate = outputFormat.format(date);
            
            return formattedDate;
        } catch (ParseException e){
            return "invalid date format";
        }
    }
}