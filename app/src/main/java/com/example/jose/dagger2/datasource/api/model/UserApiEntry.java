package com.example.jose.dagger2.datasource.api.model;

import com.example.jose.dagger2.global.model.User;

/**
 * Created by jose on 09/04/2017.
 */

public class UserApiEntry {
    private static final String SPACE = " ";
    String email;
    IdApiEntry idApiEntry = new IdApiEntry();
    LocationApiEntry locationApiEntry = new LocationApiEntry();
    PictureApiEntry pictureApiEntry = new PictureApiEntry();
    NameApiEntry nameApiEntry = new NameApiEntry();

    public User ParseUser() {
        User user = new User();
        user.setId(idApiEntry.parseId());
        user.setAddress(locationApiEntry.getStreet());
        user.setThumbnail(pictureApiEntry.getThumnbnail());
        user.setName(
                new StringBuilder()
                        .append(nameApiEntry.getTitle()).append(SPACE)
                        .append(nameApiEntry.getFirst()).append(SPACE)
                        .append(nameApiEntry.getLast()).toString()
        );
        return user;
    }
}
