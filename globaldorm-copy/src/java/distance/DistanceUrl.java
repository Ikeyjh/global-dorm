package distance;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author isaac
 */
public class DistanceUrl {
    public URL formatUrl(String coordinates) 
            throws IOException{
        
        // create map or url params
        List<String> urlParams = new ArrayList<>();
        urlParams.add("route");
        urlParams.add("v1"); 
        urlParams.add("walking"); 
        urlParams.add(coordinates);
        
        StringBuilder convertedParams = new StringBuilder();
        for(String entry : urlParams){
            convertedParams.append("/");
            
            convertedParams.append(entry);
            
            if(coordinates.equals(entry)){
                convertedParams.append("?overview=false");
            }
        }
 
        URL url = new URL(" http://router.project-osrm.org" + convertedParams);
        return url;
    }
}
