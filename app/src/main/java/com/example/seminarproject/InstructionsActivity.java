package com.example.seminarproject;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class InstructionsActivity extends AppCompatActivity {

    private Fragment moveUp;
    private SensorManager sensorManager;
    private Sensor accSensor;
    private ArrayList<Double> points;

    private float currentX;
    private float currentY;
    private float currentZ;
    private TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, moveUp).commit();
                }
            }
        });

        points = new ArrayList<>();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        moveUp = new MovePhoneUp();
        ((MovePhoneUp)moveUp).setCallBack(new CallBack() {
            @Override
            public void onFragmentStop(int index) {

                if(index == 3){
                    Intent resultIntent = new Intent(InstructionsActivity.this, ResultsActivity.class);
                    double [] arr = new double[points.size()];
                    for(int i = 0 ; i < points.size(); i++){
                        arr[i] = points.get(i);
                    }
                    resultIntent.putExtra("points", arr);
                    startActivity(resultIntent);
                    finish();
                }
            }

            @Override
            public void onFragmentStart(int index) {
                if(index == 1){
                    t1.speak("Move the phone up", TextToSpeech.QUEUE_FLUSH, null);
                    return;
                }
                if(index == 2){
                    t1.speak("Move the phone down", TextToSpeech.QUEUE_FLUSH, null);
                    return;
                }
                if(index == 3){
                    t1.speak("Hold the phone", TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

    }

    private void start(){

    }

    private final SensorEventListener accSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            currentX = event.values[0];
            currentY = event.values[1];
            currentZ = event.values[2];
            double pitch = atan2(-currentX, sqrt(currentY*currentY + currentZ*currentZ)) * 180/Math.PI;

            System.out.println("pitch = "+ Math.abs(pitch));
            points.add(Math.abs(pitch));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,HomePageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager != null){
            sensorManager.unregisterListener(accSensorEventListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(accSensorEventListener, accSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

}