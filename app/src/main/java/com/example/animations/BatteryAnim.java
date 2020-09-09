package com.example.animations;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BatteryAnim  extends AppCompatActivity {
    ImageView imgBattery;
    AnimationDrawable batteryAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);



    }

    @Override
    protected void onStart() {
        super.onStart();
        imgBattery=findViewById(R.id.imgBattery);
        imgBattery.setBackgroundResource(R.drawable.battery_animation_list);
        batteryAnim=(AnimationDrawable)imgBattery.getBackground();
        batteryAnim.start();
    }



}
