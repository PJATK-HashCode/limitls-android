package com.example.tmejs.limitlles.Activities;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tmejs.limitlles.R;
import com.example.tmejs.limitlles.Structures.FlightConfig;
import com.example.tmejs.limitlles.Utils.RestConnectionUtil;

import java.util.Calendar;
import java.util.Date;

public class WillBeActivity extends AppCompatActivity {

    private Integer flightId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_will_be);
        flightId= ((Integer) getIntent().getExtras().get(FlightDetailsActivity.FLIGHT_NUMBER_ID));
    }


    public void addMin(View v){
        String min = ((EditText)findViewById(R.id.editText2)).getText().toString();
        Integer actualMin = Integer.parseInt(min);
        actualMin=actualMin+15;
        ((EditText)findViewById(R.id.editText2)).setText(actualMin.toString());
    }

    public void send(View v){
        String min = ((EditText)findViewById(R.id.editText2)).getText().toString();
        RestConnectionUtil.sendIWillBeRequest(MainActivity.Context().getUserID(),flightId,min);
        finish();
    }

    public void reset(View v){
        ((EditText)findViewById(R.id.editText2)).setText("0");
    }

}
