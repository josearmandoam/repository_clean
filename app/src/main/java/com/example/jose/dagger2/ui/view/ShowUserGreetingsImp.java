package com.example.jose.dagger2.ui.view;

import android.content.Context;
import android.widget.Toast;

import com.example.jose.dagger2.R;
import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.usecase.ShowUserGreetings;

/**
 * Created by jose on 10/04/2017.
 */

public class ShowUserGreetingsImp implements ShowUserGreetings {
    Context context;

    public ShowUserGreetingsImp(Context context) {
        this.context = context;
    }

    @Override
    public void show(User user) {
        Toast.makeText(context, context.getResources().getString(R.string.user_greetings) + " " + user.getName()
                        + "\n" + context.getResources().getString(R.string.user_greetings_email) + user.getEmail(),
                Toast.LENGTH_SHORT).show();
    }
}
