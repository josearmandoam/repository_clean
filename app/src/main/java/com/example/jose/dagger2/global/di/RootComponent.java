package com.example.jose.dagger2.global.di;

import com.example.jose.dagger2.global.App;
import com.example.jose.dagger2.ui.presenter.UserListPresenter;

import dagger.Component;

/**
 * Created by jose on 10/04/2017.
 */

@Component(modules = MainModule.class)
public interface RootComponent {
    void inject(App application);

    void inject(UserListPresenter userListPresenterImp);
}
