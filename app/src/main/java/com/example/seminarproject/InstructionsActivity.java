package com.example.seminarproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

public class InstructionsActivity extends AppCompatActivity {

    Fragment moveUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        moveUp = new MovePhoneUp();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, moveUp).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,HomePageActivity.class);
        startActivity(intent);
        finish();
    }

}