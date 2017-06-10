package com.example.tmejs.limitlles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

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
        ((EditText) findViewById(R.id.ConfName)).setKeyListener(null);
        ((EditText) findViewById(R.id.medicineInfo)).setKeyListener(null);
        ((EditText) findViewById(R.id.ConfInfo)).setKeyListener(null);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    public void fillData(FlightConfig fc){
        ((EditText) findViewById(R.id.ConfName)).setText(fc.configName);
        ((EditText) findViewById(R.id.medicineInfo)).setText(fc.medicineInfo);
        ((EditText) findViewById(R.id.ConfInfo)).setText(fc.confINfo);
        ((CheckBox) findViewById(R.id.dogChBox)).setChecked(fc.guideDog);
        ((CheckBox) findViewById(R.id.wheelChBox)).setChecked(fc.wheelChair);
    }


}
