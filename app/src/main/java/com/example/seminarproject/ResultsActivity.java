package com.example.seminarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    private TextView test_results_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        test_results_txt = findViewById(R.id.test_results_txt);
        double [] points = getIntent().getExtras().getDoubleArray("points");
        double results = 0;
        for(int i = 0 ; i < points.length - 1; i++) {
            results += Math.abs(points[i] - points[i + 1]);
        }

        System.out.println("Results Number: "+ results);
        test_results_txt.setText( results + "");
        if (results >= 10 && results <= 100){
            test_results_txt.setText("Negative");
            test_results_txt.setTextColor(Color.GREEN);
        }
        else if(results < 10){
            test_results_txt.setText("Please hold your phone on hand and rerun the check!");
            test_results_txt.setTextColor(Color.BLACK);
        }else{
            test_results_txt.setText("Positive");
            test_results_txt.setTextColor(Color.RED);
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,HomePageActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}