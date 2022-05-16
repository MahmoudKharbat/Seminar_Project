package com.example.seminarproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class MovePhoneUp extends Fragment {

    private Fragment moveDown;
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

        view = inflater.inflate(R.layout.fragment_move_phone_up, container, false);
        moveDown = new MovePhoneDown();
        ((MovePhoneDown)moveDown).setCallBack(callBack);
        handler = new Handler();
        callBack.onFragmentStart(1);


        runnable = new Runnable() {
            @Override
            public void run() {
                callBack.onFragmentStop(1);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, moveDown).commit();
            }
        };
        handler.postDelayed(runnable, 5000);
        return view;
    }
}