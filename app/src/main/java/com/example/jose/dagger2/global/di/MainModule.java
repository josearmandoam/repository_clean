package com.example.jose.dagger2.global.di;

import com.example.jose.dagger2.datasource.api.GetUsersApiImp;
import com.example.jose.dagger2.global.App;
import com.example.jose.dagger2.interactor.GetUsersInteractor;
import com.example.jose.dagger2.interactor.impl.MainThreadImp;
import com.example.jose.dagger2.interactor.impl.ThreadExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 10/04/2017.
 */

@Module
public class MainModule {
    private App app;
    GetUsersInteractor interactor;


    public MainModule(App app) {
        this.app = app;
        interactor=new GetUsersInteractor(new GetUsersApiImp(10,0),
                new ThreadExecutor(),
                new MainThreadImp());
    }
    @Provides
    public GetUsersInteractor provideGetUsersInteractor() { return interactor; }

}
