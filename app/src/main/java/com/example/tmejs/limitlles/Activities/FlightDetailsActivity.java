package com.example.tmejs.limitlles.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tmejs.limitlles.Activities.FlightsActivity;
import com.example.tmejs.limitlles.R;
import com.example.tmejs.limitlles.Structures.Flight;

public class FlightDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);
        fillData((Flight) getIntent().getExtras().get(FlightsActivity.FLIGHT_STRING_NAME));
    }


    private void fillData(Flight flight){
        ((TextView)findViewById(R.id.flight_num_detail)).setText(flight.flightNum);
        ((TextView)findViewById(R.id.flight_date_end_detail)).setText(flight.dateTo);
        ((TextView)findViewById(R.id.flight_date_start_detail)).setText(flight.dateFrom);
        ((TextView)findViewById(R.id.flight_place_end_detail)).setText(flight.flightFrom);
        ((TextView)findViewById(R.id.flight_place_start_detail)).setText(flight.flightTo);
    }
}
