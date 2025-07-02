package crime;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import utilities.ResponseString;

/**
 *
 * @author isaac
 */
public class CrimeJson {
    public String formatJson(HttpURLConnection con) throws IOException{
        // put JSON response in a string
        ResponseString responseString = new ResponseString();
        StringBuilder responseJson = responseString.responseToString(con);
        
        Gson gson = new Gson();
        Type crimeDataListType = new TypeToken<List<CrimeData>>(){}.getType();
        List<CrimeData> crimeDataList = gson.fromJson(responseJson.toString(), crimeDataListType);
        
        // count crime occurences 
        Map<CrimeCategory, Integer> categoryCounts = new HashMap<>();
        
        // iterate through crime data and count occurrences of each category
        for(CrimeData crimeData : crimeDataList) {
            CrimeCategory category = crimeData.getCategory();
            categoryCounts.put(category, categoryCounts.getOrDefault(category, 0) + 1);
        }
        
        // convert map entries to a list    
        List<Map.Entry<CrimeCategory, Integer>> sortedCategoryCounts = new ArrayList<>(categoryCounts.entrySet());

        // sort entry values in descending order
        Collections.sort(sortedCategoryCounts, new Comparator<Map.Entry<CrimeCategory, Integer>>() {
            @Override
            public int compare(Map.Entry<CrimeCategory, Integer> entry1, Map.Entry<CrimeCategory, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
        
            // create list of crime objects to return as json
            List<Map<String, Object>> allCrimes = new ArrayList<>();
            for(Map.Entry<CrimeCategory, Integer> entry : sortedCategoryCounts) {
                Map<String, Object> crime = new LinkedHashMap<>();
                crime.put("category", entry.getKey().toString().toLowerCase().replace("_", "-"));
                crime.put("count", entry.getValue());
                allCrimes.add(crime);
            }
            return gson.toJson(allCrimes);      
    }
}
