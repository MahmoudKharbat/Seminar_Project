package com.example.seminarproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HoldPhone extends Fragment {

    private Intent resultIntent;
    private View view;
    private Runnable runnable;
    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_hold_phone, container, false);
        handler = new Handler();
        resultIntent = new Intent(view.getContext(), ResultsActivity.class);

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(resultIntent);
                getActivity().finish();
            }
        };
        handler.postDelayed(runnable, 5000);
        return view;
    }
}