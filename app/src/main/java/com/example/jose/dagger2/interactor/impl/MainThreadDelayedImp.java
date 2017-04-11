package com.example.jose.dagger2.interactor.impl;

import android.os.Handler;
import android.os.Looper;

import com.example.jose.dagger2.interactor.MainThread;

/**
 * Created by jose on 10/04/2017.
 */

public class MainThreadDelayedImp implements MainThread {
    private Handler handler;
    long delay;

    public MainThreadDelayedImp(long delay) {
        this.handler = new Handler(Looper.getMainLooper());
        this.delay = delay;
    }

    @Override
    public void post(Runnable runnable) {
        handler.postDelayed(runnable, delay);
    }
}
