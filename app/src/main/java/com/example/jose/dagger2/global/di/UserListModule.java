package com.example.jose.dagger2.global.di;

import android.content.Context;

import com.example.jose.dagger2.ui.view.ShowErrorLoadingImp;
import com.example.jose.dagger2.ui.view.ShowNoInternetAvailableImp;
import com.example.jose.dagger2.ui.view.ShowUserGreetingsImp;
import com.example.jose.dagger2.ui.view.ShowUserListErrorImp;
import com.example.jose.dagger2.usecase.ShowErrorLoading;
import com.example.jose.dagger2.usecase.ShowNoInternetAvailable;
import com.example.jose.dagger2.usecase.ShowUserGreetings;
import com.example.jose.dagger2.usecase.ShowUserListError;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose on 10/04/2017.
 */
@Module
public class UserListModule {
    Context context;
    ShowUserGreetings showUserGreetings;
    ShowUserListError showUserListError;
    ShowNoInternetAvailable showNoInternetAvailable;
    ShowErrorLoading showErrorLoading;

    public UserListModule(Context context) {
        this.context = context;
        showUserGreetings = new ShowUserGreetingsImp(context);
        showUserListError = new ShowUserListErrorImp(context);
        showNoInternetAvailable = new ShowNoInternetAvailableImp(context);
        showErrorLoading = new ShowErrorLoadingImp(context);
    }

    @Provides
    public ShowUserGreetings provideShowUserGreetings() {
        return showUserGreetings;
    }

    @Provides
    public ShowNoInternetAvailable provideShowNoInternetAvailable() {
        return showNoInternetAvailable;
    }

    @Provides
    public ShowUserListError provideShowUserListError() {
        return showUserListError;
    }

    @Provides
    public ShowErrorLoading provideShowErrorLoading() {
        return showErrorLoading;
    }
}
