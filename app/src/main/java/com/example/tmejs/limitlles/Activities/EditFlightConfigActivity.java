package com.example.tmejs.limitlles.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tmejs.limitlles.R;
import com.example.tmejs.limitlles.Structures.FlightConfig;

public class EditFlightConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_flight_config);
        fillData((FlightConfig) getIntent().getExtras().get(ConfigsActivity.FLIGHT_CONFIG_STRING_NAME));
    }


    private void fillData(FlightConfig fc){


    }


}
