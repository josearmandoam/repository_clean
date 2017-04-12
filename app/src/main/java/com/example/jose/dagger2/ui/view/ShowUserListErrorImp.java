package com.example.jose.dagger2.ui.view;

import android.content.Context;
import android.widget.Toast;

import com.example.jose.dagger2.R;
import com.example.jose.dagger2.usecase.ShowUserListError;

/**
 * Created by jose on 12/04/2017.
 */

public class ShowUserListErrorImp implements ShowUserListError {
    Context context;

    public ShowUserListErrorImp(Context context) {
        this.context = context;
    }

    @Override
    public void show() {
        Toast.makeText(context, context.getString(R.string.list_error), Toast.LENGTH_SHORT).show();
    }
}
