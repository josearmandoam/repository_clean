package com.example.jose.dagger2.datasource.api.model;

import com.example.jose.dagger2.global.model.User;

/**
 * Created by jose on 09/04/2017.
 */

public class UserApiEntry {
    private static final String SPACE = " ";
    String email;
    IdApiEntry id = new IdApiEntry();
    LocationApiEntry location = new LocationApiEntry();
    PictureApiEntry picture = new PictureApiEntry();
    NameApiEntry name = new NameApiEntry();

    public User ParseUser() {
        User user = new User();
        user.setId(id.parseId());
        user.setAddress(location.getStreet());
        user.setThumbnail(picture.getLarge());
        user.setEmail(email);
        user.setName(
                new StringBuilder()
                        .append(name.getTitle()).append(SPACE)
                        .append(name.getFirst()).append(SPACE)
                        .append(name.getLast()).toString()
        );
        return user;
    }
}
