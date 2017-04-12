package com.example.jose.dagger2.interactor;

import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.usecase.GetUsers;

import java.util.List;

/**
 * Created by jose on 10/04/2017.
 */

public class GetUsersInteractor implements Interactor, GetUsers, GetUsers.Listener {
    GetUsers.Listener listener = new NullListener();
    GetUsers getUsers;
    Executor executor;
    MainThread mainThread;

    public GetUsersInteractor(GetUsers getUsers, Executor executor, MainThread mainThread) {
        this.getUsers = getUsers;
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        getUsers.getUsers(listener);
    }

    @Override
    public List<User> get() {
        throw new IllegalArgumentException("Please use a sync version of this interactor");
    }

    @Override
    public void getUsers(Listener listener) {
        if (listener != null) {
            this.listener = listener;
        }
        this.executor.run(this);
    }

    @Override
    public void onUsersReceived(List<User> users, boolean isCached) {
        listener.onUsersReceived(users, isCached);
    }

    @Override
    public void onError(Exception e) {
        listener.onError(e);
    }

    @Override
    public void onNoInternertAvailable() {
        listener.onNoInternertAvailable();
    }

    private class NullListener implements Listener {

        @Override
        public void onUsersReceived(List<User> users, boolean isCached) {

        }

        @Override
        public void onError(Exception e) {

        }

        @Override
        public void onNoInternertAvailable() {

        }
    }
}
