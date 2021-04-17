package com.example.hitballgameroverimaxim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import views.CustomView;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    Sensor accelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomView customView = new CustomView(this);


    }


}