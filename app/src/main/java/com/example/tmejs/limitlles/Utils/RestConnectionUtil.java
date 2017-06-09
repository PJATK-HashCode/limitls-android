package com.example.tmejs.limitlles.Utils;

import android.net.http.HttpResponseCache;

import com.example.tmejs.limitlles.Structures.Flight;
import com.example.tmejs.limitlles.Structures.FlightConfig;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tmejs on 09.06.2017.
 */

public class RestConnectionUtil  {

    private final static String REST_URL="REST_URL";

    private enum LOG_ACTIVITY{
        IM_HERE,
        WILL_BE_AT,
        DECLINE
    }


    private static String createJSon(HashMap<String,String> hm) {
        JSONObject jsonString = new JSONObject();

        for (Map.Entry<String,String> entry:hm.entrySet()) {
            try {
                jsonString.put(entry.getKey(), entry.getValue());
            }catch(Exception e){

            }
        };

        return jsonString.toString();

    }

    private static void createRequest() throws IOException{
        try{
        URL url = new URL(REST_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        writer.write(createJSon(null));
        writer.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer jsonString = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            jsonString.append(line);
        }
        br.close();
        connection.disconnect();
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }

    }




    //TODO
    public static List<Flight> getFlightsByUserID(Integer userId){


        return new ArrayList<Flight>();
    }


    public static List<FlightConfig> getFlightConfigsByUserID(Integer userId){
        return new ArrayList<>();
    }

    public static FlightConfig getConfigByID(int id){
        return new FlightConfig();
    }







    
}
