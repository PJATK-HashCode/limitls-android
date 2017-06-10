package com.example.tmejs.limitlles.Structures;

import java.io.Serializable;

/**
 * Created by Tmejs on 09.06.2017.
 */

public class FlightConfig implements Serializable{


    public String configName="ToLondon";
    public Integer configID = 1;
    public String medicineInfo="paracetamol 12:00,16:00";
    public String confINfo="Blind person, with dog assistant. Always with guide";
    public Boolean guideDog=false;
    public Boolean wheelChair=false;

    public FlightConfig(String configName, Integer configID, String medicineInfo, String confINfo, Boolean guideDog, Boolean wheelChair) {
        this.configName = configName;
        this.configID = configID;
        this.medicineInfo = medicineInfo;
        this.confINfo = confINfo;
        this.guideDog = guideDog;
        this.wheelChair = true;
    }
    public FlightConfig(){

    }
}
