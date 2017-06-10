package com.example.tmejs.limitlles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tmejs.limitlles.R;
import com.example.tmejs.limitlles.Utils.RestConnectionUtil;
import com.example.tmejs.limitlles.Structures.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightsActivity extends AppCompatActivity {

    public static final String FLIGHT_STRING_NAME="FLIGHT_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        //Load Flights and fill
        fillData(loadFlights(MainActivity.Context().getUserID()));
    }


    public List<Flight> loadFlights(Integer userID){

        return new ArrayList<>();

    }


    public void fillData(final List<Flight> dataList){
        ListView listView = (ListView) findViewById(R.id.FlightsListView);

        List<String> aa=new ArrayList<>();
        for (Flight ff:dataList) {
            aa.add(ff.name);
        }
        Flight newFl=new Flight();
        aa.add(newFl.flightNum);

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
                switchToFlightDetails(new Flight());
            }
        });

    }


    private void switchToFlightDetails(Flight flight){
        Intent intent = new Intent(this,FlightDetailsActivity.class);
        intent.putExtra(FLIGHT_STRING_NAME,flight);
        startActivity(intent);
    }



    public void back(View v)
    {
        finish();
    }
}
