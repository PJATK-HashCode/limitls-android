package com.example.tmejs.limitlles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tmejs.limitlles.Activities.FlightsActivity;
import com.example.tmejs.limitlles.R;
import com.example.tmejs.limitlles.Structures.Flight;
import com.example.tmejs.limitlles.Structures.FlightConfig;
import com.example.tmejs.limitlles.Utils.RestConnectionUtil;

public class FlightDetailsActivity extends AppCompatActivity {

    public final static String FLIGHT_NUMBER_ID="FLIGHT_NUMBER_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);
        fillData((Flight) getIntent().getExtras().get(FlightsActivity.FLIGHT_STRING_NAME));

        ((TextView)findViewById(R.id.flight_num_detail)).setKeyListener(null);
        ((TextView)findViewById(R.id.flight_date_end_detail)).setKeyListener(null);
        ((TextView)findViewById(R.id.flight_date_start_detail)).setKeyListener(null);
        ((TextView)findViewById(R.id.flight_place_end_detail)).setKeyListener(null);
        ((TextView)findViewById(R.id.flight_place_start_detail)).setKeyListener(null);

    }


    private void fillData(Flight flight){
        ((TextView)findViewById(R.id.flight_num_detail)).setText(flight.flightNum);
        ((TextView)findViewById(R.id.flight_date_end_detail)).setText(flight.dateTo);
        ((TextView)findViewById(R.id.flight_date_start_detail)).setText(flight.dateFrom);
        ((TextView)findViewById(R.id.flight_place_end_detail)).setText(flight.flightFrom);
        ((TextView)findViewById(R.id.flight_place_start_detail)).setText(flight.flightTo);
        FlightConfig aa = new FlightConfig();
        ((TextView)findViewById(R.id.selectedConf)).setText(aa.configName);
    }


    public void iAm(View v){
        RestConnectionUtil.sendImRequest(MainActivity.Context().getUserID(),((Flight) getIntent().getExtras().get(FlightsActivity.FLIGHT_STRING_NAME)).flightId);
    }


    public void iWillBe(View v){
        Intent intent = new Intent(this,WillBeActivity.class);
        intent.putExtra(FLIGHT_NUMBER_ID,((Flight) getIntent().getExtras().get(FlightsActivity.FLIGHT_STRING_NAME)).flightId);
        startActivity(intent);
    }

    public void decline(View v){
        RestConnectionUtil.sendDeclineRequest(MainActivity.Context().getUserID(),((Flight) getIntent().getExtras().get(FlightsActivity.FLIGHT_STRING_NAME)).flightId);
    }
}
