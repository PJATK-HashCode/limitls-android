package com.example.tmejs.limitlles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.tmejs.limitlles.R;
import com.example.tmejs.limitlles.Structures.Flight;
import com.example.tmejs.limitlles.Structures.FlightConfig;
import com.example.tmejs.limitlles.Utils.RestConnectionUtil;

public class FlightConfigDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_config_detail);
        fillData((FlightConfig) getIntent().getExtras().get(ConfigsActivity.FLIGHT_CONFIG_STRING_NAME));
    }

    @Override
    protected void onResume(){
        super.onResume();
        fillData(RestConnectionUtil.getConfigByID(((FlightConfig) getIntent().getExtras().get(ConfigsActivity.FLIGHT_CONFIG_STRING_NAME)).configID));

    }

    //TODO
    public void fillData(FlightConfig fc){

    }

    public void editConfig(View v){
        Intent intent = new Intent(this,EditFlightConfigActivity.class);
        intent.putExtra(ConfigsActivity.FLIGHT_CONFIG_STRING_NAME,(FlightConfig) getIntent().getExtras().get(ConfigsActivity.FLIGHT_CONFIG_STRING_NAME));
        startActivity(intent);

    }

}
