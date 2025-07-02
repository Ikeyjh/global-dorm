package distance;

import java.io.IOException;
import java.net.URL;

public class Distance {

    public Distance() {
    }

    public String getJson(String coordinates) throws IOException {
        
        // format url
        DistanceUrl distanceUrl = new DistanceUrl();
        URL url = distanceUrl.formatUrl(coordinates);

        // get distance data
        DistanceJson distanceJson = new DistanceJson();
        DistanceWebConnection webConnection = new DistanceWebConnection();
        String jsonResponse = webConnection.httpClientHelper(url, distanceJson);
        
        // extract distance
        double distance = extractDistanceFromJson(jsonResponse);

        // calculate estimated walking time
        double walkingTimeInMinutes = Math.round(calculateWalkingTime(distance) * 10) / 10;

        // return the formatted response
        return "{ \"Distance\": " + distance + ", \"walkingTime\": " + walkingTimeInMinutes + " }";
    }

    public double extractDistanceFromJson(String jsonResponse) {
        String distanceStr = jsonResponse.replaceAll("[^0-9.]", ""); 
        return Double.parseDouble(distanceStr);
    }

    public double calculateWalkingTime(double distance) {
        double avgWalkSpeed = 1.4; // average walking speed (m/s)
        double timeInSeconds = distance / avgWalkSpeed;
        return timeInSeconds / 60; // convert seconds to minutes
    }
}
