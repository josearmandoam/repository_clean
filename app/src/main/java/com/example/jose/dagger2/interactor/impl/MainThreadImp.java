package com.example.jose.dagger2.interactor.impl;

import android.os.Handler;
import android.os.Looper;

import com.example.jose.dagger2.interactor.MainThread;


/**
 * Created by jose on 10/04/2017.
 */

public class MainThreadImp implements MainThread {
    private Handler handler;

    public MainThreadImp() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
