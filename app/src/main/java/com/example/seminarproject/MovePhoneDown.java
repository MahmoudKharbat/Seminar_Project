package com.example.seminarproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovePhoneDown extends Fragment {

    private Fragment hold;
    private View view;
    private Runnable runnable;
    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_move_phone_down, container, false);
        hold = new HoldPhone();
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, hold).commit();
            }
        };
        handler.postDelayed(runnable, 5000);
        return view;
    }
}