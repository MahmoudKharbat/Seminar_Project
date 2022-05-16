package com.example.seminarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,HomePageActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}