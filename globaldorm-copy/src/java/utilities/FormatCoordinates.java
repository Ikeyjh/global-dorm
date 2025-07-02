/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author isaac
 */
public class FormatCoordinates {
    public String[] formatCoordinates(String method, String coordinates){
        // coordinates = "/-1.1715435,52.9128676;-1.186603,52.911640"; // long then lat
        String[] pairs = coordinates.substring(1).split(";");
        return pairs;
    }
}
