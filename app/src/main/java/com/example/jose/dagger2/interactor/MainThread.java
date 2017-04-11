package com.example.jose.dagger2.interactor;

/**
 * Created by jose on 10/04/2017.
 */

public interface MainThread {
    void post(final Runnable runnable);
}
