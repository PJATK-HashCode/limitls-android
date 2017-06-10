package com.example.tmejs.limitlles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tmejs.limitlles.R;
import com.example.tmejs.limitlles.Structures.Flight;
import com.example.tmejs.limitlles.Structures.FlightConfig;
import com.example.tmejs.limitlles.Utils.RestConnectionUtil;

import java.util.ArrayList;
import java.util.List;

public class ConfigsActivity extends AppCompatActivity {


    public static final String FLIGHT_CONFIG_STRING_NAME="FLIGHT_CONFIG_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configs);
        fillData(loadConfigs(MainActivity.Context().getUserID()));
    }


    private List<FlightConfig> loadConfigs(Integer userID){
        return new ArrayList<>();
    }

    private void fillData(final List<FlightConfig> dataList){

        ListView listView = (ListView) findViewById(R.id.configs_list_view);

        dataList.add(new FlightConfig());
        dataList.add(new FlightConfig("ToSydney",2,"","Physically disabled",false,true));
        List<String> aa=new ArrayList<>();
        for (FlightConfig ff:dataList) {
            aa.add(ff.configName);
        }



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                aa);


        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Zbieramy id
                //switchToFlightDetails(dataList.get(position));
                switchToConfigFlightDetails(dataList.get(position));
            }
        });

    }


    public void switchToConfigFlightDetails(FlightConfig fc){

        Intent intent = new Intent(this,FlightConfigDetailActivity.class);
        intent.putExtra(FLIGHT_CONFIG_STRING_NAME,fc);
        startActivity(intent);

    }

}
