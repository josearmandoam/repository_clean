package com.example.jose.dagger2.datasource.api.retrofit;

import com.example.jose.dagger2.datasource.api.GetUsersResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by jose on 09/04/2017.
 */

public interface GetRetrofitRequest {
    @GET("/")
    void getRandomsUsers(@Query("results") int maxUsers, @Query("seed") int page,
                         Callback<GetUsersResponse> callback);
}
