package com.example.jose.dagger2.ui.presenter;

import android.content.Context;

import com.example.jose.dagger2.global.App;
import com.example.jose.dagger2.global.di.RootComponent;
import com.example.jose.dagger2.global.di.UserListComponent;
import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.interactor.GetUsersInteractor;
import com.example.jose.dagger2.ui.presenter.abs.AbsUserListPresenter;
import com.example.jose.dagger2.usecase.GetUsers;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by jose on 10/04/2017.
 */

public class UserListPresenter extends AbsUserListPresenter {
    Context ctx;
    GetUsers getUsers;


    @Inject
    public UserListPresenter(Context context, GetUsersInteractor getUsersInteractor) {
        this.ctx = context;
        this.getUsers = getUsersInteractor;
        getComponent().inject(this);
    }


    @Override
    public void initialize() {
        view.showLooading();
        getUsers.getUsers(new GetUsers.Listener() {
            @Override
            public void onUsersReceived(List<User> users, boolean isCached) {
                view.showUserList(users);
                view.hideLoading();
            }

            @Override
            public void onError(Exception e) {
                view.showUserListError(e);
                view.hideLoading();
            }

            @Override
            public void onNoInternertAvailable() {
                view.showNoInternetAvailable();
                view.hideLoading();
            }
        });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
    protected RootComponent getComponent() {
            return ((App)ctx.getApplicationContext()).getComponent();
    }

    @Override
    public void onPicturedClicked(User user) {
        view.showGreetingsUser(user);
    }

    @Override
    public void onBackgroundClicked(User user) {
        navigator.navigateUserDetail(user);
    }
}
