package com.example.seminarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    private Button startButton;
    private Intent instructionsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        startButton = findViewById(R.id.start_button);
        instructionsIntent = new Intent(this, InstructionsActivity.class);

        pressedBtn();
    }

    public void pressedBtn(){
        startButton.setOnClickListener(e-> {
            startActivity(instructionsIntent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}