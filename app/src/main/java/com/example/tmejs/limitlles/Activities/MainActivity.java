package com.example.tmejs.limitlles.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tmejs.limitlles.R;
import com.example.tmejs.limitlles.Utils.StoredDataUtil;

public class MainActivity extends AppCompatActivity {


    private static MainActivity Instance;
    private Integer usreID;


    public void setUserID(Integer id){
        usreID=id;
    }


    public static MainActivity Context(){
        return Instance;
    }

    public Integer getUserID(){
        return usreID;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Instance=this;
        //Walidacja czy mamy zapisane poprawne dane
        if(!validPassword()){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);}
    }


    @Override
    public void onResume(){
        super.onResume();
//        if(!validPassword()){
//            Intent intent = new Intent(this,LoginActivity.class);
//            startActivity(intent);}
    }


    private Boolean validPassword(){
        //Check do id exist
        if(StoredDataUtil.checkDoLogDataExist(this)){
            //Read ID
            usreID = StoredDataUtil.getUserID(this);
            if(usreID!=null) return true;
        }
        return false;
    }


    public void logout(View v){
        resetPasswords();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }



    public void resetPasswords(){
        StoredDataUtil.removeUserID(this);
    }


    public void switchToFlights(View v){
        Intent intent = new Intent(this,FlightsActivity.class);
        startActivity(intent);
    }


    public void switchToConfigurations(View v){
        Intent intent = new Intent(this,ConfigsActivity.class);
        startActivity(intent);
    }

}
