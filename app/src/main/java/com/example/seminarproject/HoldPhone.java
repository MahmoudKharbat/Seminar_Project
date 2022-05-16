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

    private CallBack callBack;

    public void setCallBack(CallBack callBack){
        this.callBack = callBack;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_hold_phone, container, false);
        handler = new Handler();
        callBack.onFragmentStart(3);
        runnable = new Runnable() {
            @Override
            public void run() {
                callBack.onFragmentStop(3);
            }
        };
        handler.postDelayed(runnable, 5000);
        return view;
    }
}