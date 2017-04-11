package com.example.jose.dagger2.global.di;

import android.content.Context;

import com.example.jose.dagger2.ui.view.ShowUserGreetingsImp;
import com.example.jose.dagger2.usecase.ShowUserGreetings;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 10/04/2017.
 */
@Module
public class UserListModule {
    Context context;
    ShowUserGreetings showUserGreetings;
    public UserListModule(Context context) {
        this.context = context;
        showUserGreetings=new ShowUserGreetingsImp(context);
    }
    @Provides
    public ShowUserGreetings provideShowUserGreetings() { return showUserGreetings; }
}
