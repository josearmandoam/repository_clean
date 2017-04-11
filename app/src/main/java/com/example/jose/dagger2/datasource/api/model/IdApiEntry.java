package com.example.jose.dagger2.datasource.api.model;

/**
 * Created by jose on 09/04/2017.
 */

public class IdApiEntry {
    String name = "";
    String value = "";

    public String parseId() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(name != null ? name : "")
                .append(value != null ? value : "");
        return stringBuilder.toString();
    }
}
