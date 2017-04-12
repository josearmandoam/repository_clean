package com.example.jose.dagger2.global;

import android.app.Application;

import com.example.jose.dagger2.global.di.DaggerRootComponent;
import com.example.jose.dagger2.global.di.MainModule;
import com.example.jose.dagger2.global.di.RootComponent;

/**
 * Created by jose on 10/04/2017.
 */

public class App extends Application {
    private MainModule mainModule;
    RootComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependencyInjector();
    }

    private void initializeDependencyInjector() {
        mainModule = new MainModule(this);
        component = DaggerRootComponent.builder()
                .mainModule(mainModule)
                .build();
        component.inject(this);
    }

    public MainModule getMainModule() {
        return mainModule;
    }

    public RootComponent getComponent() {
        return component;
    }
}
