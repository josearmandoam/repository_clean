package com.example.jose.dagger2.ui.presenter.abs;

import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.ui.presenter.Presenter;

import java.util.List;

/**
 * Created by jose on 10/04/2017.
 */

public abstract class AbsUserListPresenter extends Presenter<AbsUserListPresenter.View, AbsUserListPresenter.Navigator> {

    public abstract void onPicturedClicked(User user);

    public abstract void onBackgroundClicked(User user);

    public interface View {
        void showUserList(List<User> users);

        void showUserListError(Exception e);

        void showNoInternetAvailable();

        void showGreetingsUser(User user);

        void showLooading();

        void hideLoading();
    }

    public interface Navigator {
        public void navigateUserDetail(User user);
    }
}
