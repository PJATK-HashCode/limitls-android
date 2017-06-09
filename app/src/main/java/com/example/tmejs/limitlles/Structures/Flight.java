package com.example.tmejs.limitlles.Structures;

import java.io.Serializable;

/**
 * Created by Tmejs on 09.06.2017.
 */

public class Flight implements Serializable {
    public String name ="name";
    public String flightNum="flightNum";
    public String dateFrom="dateFrom";
    public String dateTo="dateTo";
    public String flightFrom="flightFrom";
    public String flightTo="flightTo";

    public Flight(){

    }
    public Flight(String name, String flightNum, String dateFrom, String dateTo, String flightFrom, String flightTo) {
        this.name = name;
        this.flightNum = flightNum;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }
}