package com.example.jose.dagger2.global.di;

import com.example.jose.dagger2.ui.activity.UserListActivity;

import dagger.Component;

/**
 * Created by jose on 10/04/2017.
 */
@Component(dependencies = RootComponent.class, modules = {UserListModule.class, MainModule.class})
public interface UserListComponent {
    void inject(UserListActivity userListActivity);
}
