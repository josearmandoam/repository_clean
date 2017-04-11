package com.example.jose.dagger2.usecase;

import com.example.jose.dagger2.global.model.User;

import java.util.List;

/**
 * Created by jose on 09/04/2017.
 */

public interface GetUsers {
    List<User> get();

    void getUsers(final Listener listener);

    interface Listener {
        void onUsersReceived(List<User> users, boolean isCached);

        void onError(Exception e);

        void onNoInternertAvailable();
    }
}
