package weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherRedundancyCalculations {
    public List<String> getDay(List<String> days) {
        ArrayList<String> week = new ArrayList<>();
        
        for (String day : days) {
            if (day.endsWith("T12:00")) {
                week.add(day);
            }
        }

        return week;
    }
    
    // get the temperatures from midday
    public List<Double> getTemp(List<String> days, List<Double> temps) {
        ArrayList<Double> tmp = new ArrayList<>();
        
        for (int i = 0; i < days.size(); i++) {
            String day = days.get(i);
            Double temp = temps.get(i);
           
            if (day.endsWith("T12:00")) {
                tmp.add(temp);
            }
        }

        return tmp;
    }
    
    public Map<String, Double> mapDayTemps(ArrayList<String> days, ArrayList<Double> temps){
        Map<String, Double> tempMap = new HashMap<>();
        for(int i = 0; i < days.size(); i++){
            // remove T12:00 from days strings
            String noTime = days.get(i).replace("T12:00", "");
            tempMap.put(noTime, temps.get(i));
        }
        return tempMap;
    }
}
