/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 *
 * @author isaac
 */
public class ResponseString {
    public StringBuilder responseToString(HttpURLConnection con) throws IOException{
        StringBuilder responseJson = new StringBuilder();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line;
            while((line = in.readLine()) != null){
                responseJson.append(line).append("\n");
            }
            return responseJson;
        }
    }
}
