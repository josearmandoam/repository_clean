package com.example.jose.dagger2.datasource.api;

import com.example.jose.dagger2.datasource.api.model.UserApiEntry;

import java.util.List;

/**
 * Created by jose on 09/04/2017.
 */

public class GetUsersResponse {
    private List<UserApiEntry> results;

    public List<UserApiEntry> getResults() {
        return results;
    }
}
