package com.example.jose.dagger2.ui.presenter.abs;

import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.ui.presenter.Presenter;

/**
 * Created by jose on 12/04/2017.
 */

public abstract class AbsUserDetailPresenter extends Presenter<AbsUserDetailPresenter.View, AbsUserDetailPresenter.Navigator> {

    public abstract void onImageClicked(User user);

    public interface Navigator {
        void navigate();
    }

    public interface View {
        void showUserGreetings(User user);

        void showLoading();

        void hideLoading();

        void showErrorLoading();

        void showUserName(String name);

        void showUserEmail(String email);

        void showUserID(String id);

        void showUserAddress(String address);

        void loadImage(String thumbnail);
    }
}
