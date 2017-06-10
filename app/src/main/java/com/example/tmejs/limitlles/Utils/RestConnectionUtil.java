package com.example.tmejs.limitlles.Utils;

import com.example.tmejs.limitlles.Structures.Flight;
import com.example.tmejs.limitlles.Structures.FlightConfig;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tmejs on 09.06.2017.
 */

public class RestConnectionUtil  {

    private final static String REST_URL="https://radiant-stream-52142.herokuapp.com/";

    public interface IOnResponse {
         void onResponse(String json);
    }

    private enum LOG_ACTIVITY{
        IM_HERE,
        WILL_BE_AT,
        DECLINE
    }


    private static String createJSon(HashMap<String,String> hm, LOG_ACTIVITY enumACT) {
        JSONObject jsonString = new JSONObject();

        for (Map.Entry<String,String> entry:hm.entrySet()) {
            try {
                jsonString.put(entry.getKey(), entry.getValue());
            }catch(Exception e){

            }
        };
        try {
            jsonString.put("ENUM", enumACT.toString());
        }catch(Exception e) {

        }
        return jsonString.toString();

    }



    //Feature
private static HashMap<String,String> parse(String json){

    return new HashMap<>();
}


    private static String getDataFromRest(String restString){
        String restConnectionString = REST_URL + restString;

        try{
            URL url = new URL(REST_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
            return jsonString.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private static void createRequest(HashMap<String,String> hm,LOG_ACTIVITY enump,IOnResponse onResponse){
        try{
        URL url = new URL(REST_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        writer.write(createJSon(hm,enump));
        writer.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer jsonString = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            jsonString.append(line);
        }
        br.close();
        connection.disconnect();
            onResponse.onResponse(jsonString.toString());
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }

    }


    public static void sendImRequest(Integer userId,Integer idLot){
        HashMap<String,String> values=new HashMap<>();
        values.put("user_id",userId.toString());
        values.put("id_lot",idLot.toString());
        createRequest(values, LOG_ACTIVITY.IM_HERE, new IOnResponse() {
            @Override
            public void onResponse(String json) {
            }
        });
    }

    public static void sendIWillBeRequest(Integer userID,Integer lotId, String minPlus){
        HashMap<String,String> values=new HashMap<>();
        values.put("user_id",userID.toString());
        values.put("id_lot",lotId.toString());
        values.put("date",minPlus.toString());
        createRequest(values, LOG_ACTIVITY.WILL_BE_AT, new IOnResponse() {
            @Override
            public void onResponse(String json) {
            }
        });
    }

    public static void sendDeclineRequest(Integer userId, Integer id_lot){
        HashMap<String,String> values=new HashMap<>();
        values.put("user_id",userId.toString());
        values.put("id_lot",id_lot.toString());
        createRequest(values, LOG_ACTIVITY.DECLINE, new IOnResponse() {
            @Override
            public void onResponse(String json) {
            }
        });
    }

    public static void getFlightsByUserID(Integer userId, IOnResponse resp){
        String restString = "/rest/client/" + userId;
        resp.onResponse(getDataFromRest(restString));
    }


    public static void getFlightConfigsByUserID(Integer userId, IOnResponse resp){
        String restString = "/rest/flight/" + userId;
        resp.onResponse(getDataFromRest(restString));
    }

    public static void getConfigByID(Integer id, IOnResponse resp){
        String restString = "/rest/flightconfig/" + id;
        resp.onResponse(getDataFromRest(restString));
    }








}
