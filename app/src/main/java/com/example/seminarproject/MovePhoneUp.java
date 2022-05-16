package com.example.seminarproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovePhoneUp extends Fragment {

    private Fragment moveDown;
    private View view;
    private Runnable runnable;
    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_move_phone_up, container, false);
        moveDown = new MovePhoneDown();
        handler = new Handler();


        runnable = new Runnable() {
            @Override
            public void run() {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, moveDown).commit();
            }
        };
        handler.postDelayed(runnable, 5000);
        return view;
    }
}