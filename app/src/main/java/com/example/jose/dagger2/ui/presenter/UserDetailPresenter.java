package com.example.jose.dagger2.ui.presenter;

import android.content.Context;

import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.ui.presenter.abs.AbsUserDetailPresenter;

/**
 * Created by jose on 12/04/2017.
 */

public class UserDetailPresenter extends AbsUserDetailPresenter {
    Context context;
    User user;

    public UserDetailPresenter(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    @Override
    public void onImageClicked(User user) {
        view.showUserGreetings(user);
    }

    @Override
    public void initialize() {
        view.showLoading();
        view.showUserAddress(user.getAddress());
        view.showUserName(user.getName());
        view.showUserID(user.getId());
        view.showUserEmail(user.getEmail());
        view.loadImage(user.getThumbnail());
        view.hideLoading();
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
}
