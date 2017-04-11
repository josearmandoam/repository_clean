package com.example.jose.dagger2.datasource.api;

import com.example.jose.dagger2.datasource.api.model.UserApiEntry;
import com.example.jose.dagger2.datasource.api.retrofit.GetRetrofitRequest;
import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.usecase.GetUsers;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jose on 09/04/2017.
 */

public class GetUsersApiImp implements GetUsers, Callback<GetUsersResponse> {
    private static final String ENDPOINT = "https://api.randomuser.me";
    private int pageSize = 0;
    private int pageNumber = 0;

    Listener listener = new NullListener();

    public GetUsersApiImp(int pageSize, int pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    @Override
    public List<User> get() {
        throw new IllegalStateException("Not implemented yet");
    }

    @Override
    public void getUsers(Listener listener) {
        if (listener != null) {
            this.listener = listener;
        }
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ENDPOINT).build();
        GetRetrofitRequest request = restAdapter.create(GetRetrofitRequest.class);
        request.getRandomsUsers(pageSize, pageNumber, this);
    }

    @Override
    public void success(GetUsersResponse getUsersResponse, Response response) {
        List<User> list = new ArrayList<User>();
        for (UserApiEntry userapi : getUsersResponse.getResults()) {
            list.add(userapi.ParseUser());
        }
        listener.onUsersReceived(list, false);
    }

    @Override
    public void failure(RetrofitError error) {
        listener.onError(error);
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
