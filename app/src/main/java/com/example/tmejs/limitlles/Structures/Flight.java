package com.example.tmejs.limitlles.Structures;

import java.io.Serializable;

/**
 * Created by Tmejs on 09.06.2017.
 */

public class Flight implements Serializable {
    public Integer flightId = 1;
    public String name = "name";
    public String flightNum = "FR4734";
    public String dateFrom = "12/02/2017 13:00";
    public String dateTo = "12/02/2017 16:00";
    public String flightFrom = "Gdansk";
    public String flightTo = "London(Stansted)";

    public Flight(){

    }

    public Flight(Integer flightId, String name, String flightNum, String dateFrom, String dateTo, String flightFrom, String flightTo) {
        this.flightId = flightId;
        this.name = name;
        this.flightNum = flightNum;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }
}